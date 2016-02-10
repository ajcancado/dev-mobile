package br.com.ivalue.ivalue;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import br.com.ivalue.adapters.DataAdapter;
import br.com.ivalue.models.Data;
import br.com.ivalue.models.Properties;
import br.com.ivalue.uteis.ConectividadeUtil;


public class MainActivity extends GenericActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String GET_PROPERTIES = "http://177.71.250.111:3000/search/properties?authorization=3e2234b49b1da098fe0768142f40d086&city_id=1";

    private DrawerLayout mDrawerLayout;

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

        mSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);

        filterList = new ArrayList<Data>();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        configureSearch();

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        map.setMyLocationEnabled(true);

//        map.animateCamera(CameraUpdateFactory.zoomTo(12));

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

                    String texto = newQuery.toLowerCase(Locale.getDefault());
                    filter(texto);
                }
            }
        });
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

                adapter = new DataAdapter(getApplicationContext(), properties.getData());

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

    private void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());

        properties.getData().clear();

        if (charText.length() == 0) {
            properties.getData().addAll(filterList);
        } else {
            for (Data data : filterList) {
                if (data.getAddress().toLowerCase(Locale.getDefault()).contains(charText) || data.getDistrict().toLowerCase(Locale.getDefault()).contains(charText)) {
                    properties.getData().add(data);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
