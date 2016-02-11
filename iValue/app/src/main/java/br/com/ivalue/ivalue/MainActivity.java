package br.com.ivalue.ivalue;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.ivalue.adapters.DataAdapter;
import br.com.ivalue.helper.DataHelper;
import br.com.ivalue.models.Data;
import br.com.ivalue.models.Properties;
import br.com.ivalue.uteis.ConectividadeUtil;


public class MainActivity extends GenericActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String GET_PROPERTIES = "http://177.71.250.111:3000/search/properties?authorization=3e2234b49b1da098fe0768142f40d086&city_id=1";

    private FloatingSearchView mSearchView;

    private GoogleMap map;

    private ListView listView;
    private DataAdapter adapter;

    private Properties properties;

    private ArrayList<Data> filterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterList = new ArrayList<Data>();

        mSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);

        configureSearch();

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        configureMap();

        listView = (ListView) findViewById(R.id.list);

        configureProgressDialog("Carregando...");

        prepareRequest();
    }

    private void configureSearch() {

        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                if (!oldQuery.equals("") && newQuery.equals("")) {
                    mSearchView.clearSuggestions();
                } else {
                    mSearchView.showProgress();

                    DataHelper.find(MainActivity.this, newQuery, filterList, new DataHelper.OnFindResultsListener() {

                        @Override
                        public void onResults(List<DataSuggestion> results) {

                            mSearchView.swapSuggestions(results);

                            mSearchView.hideProgress();
                        }
                    });
                }
            }
        });

        mSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
//                Log.d(TAG, "onSuggestionClicked()");

                DataSuggestion dataSuggestion = (DataSuggestion) searchSuggestion;

                Data data = dataSuggestion.getmData();

                Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSearchAction() {
//                Log.d(TAG, "onSearchAction()");
            }
        });

        mSearchView.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
//                Log.d(TAG, "onFocus()");

                mSearchView.swapSuggestions(DataHelper.getHistory(MainActivity.this, filterList, 3));
            }

            @Override
            public void onFocusCleared() {
//                Log.d(TAG, "onFocusCleared()");
            }

        });
    }

    public void configureMap(){

        map.setMyLocationEnabled(true);

        LatLng origem = obterCoordenadaOrigem();

        if (origem != null) {

            int zoomMapa = 15;

            map.moveCamera(CameraUpdateFactory.newLatLng(origem));
            map.animateCamera(CameraUpdateFactory.zoomTo(zoomMapa));
        }

    }

    private LatLng obterCoordenadaOrigem() {

        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            
            return null ;
        }
        else{

            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, true);

            Location myLocation = locationManager.getLastKnownLocation(provider);

            LatLng origem = new LatLng(myLocation.getLatitude(),myLocation.getLongitude());

            return origem;
        }
    }

    public void prepareRequest() {

        if (ConectividadeUtil.isAirplaneModeOn(this)) {
            ConectividadeUtil.confirmarModoAviao(this);
        } else if (ConectividadeUtil.isOnline(this)) {
            doRequest();
        } else {
            ConectividadeUtil.confirmarConexaoInternet(this);
        }
    }

    private void doRequest() {

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(0,
                GET_PROPERTIES, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "Success: " + response.toString());

                hidepDialog();

                Gson gson = new Gson();

                properties = gson.fromJson(response.toString(), Properties.class);

                filterList.addAll(properties.getData());

                adapter = new DataAdapter(MainActivity.this, properties.getData());

                listView.setAdapter(adapter);

                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

                hidepDialog();
            }
        });

        Application.getInstance().addToRequestQueue(jsonObjReq);
    }
}
