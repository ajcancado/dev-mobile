package br.com.ivalue.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import br.com.ivalue.ivalue.Application;
import br.com.ivalue.ivalue.R;
import br.com.ivalue.models.Data;

/**
 * Created by arthur on 10/02/16.
 */
public class DataAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private ImageLoader imageLoader;
    private List<Data> dataItens;

    public DataAdapter(Context context, List<Data> dataItens) {

        mContext = context;
        inflater = LayoutInflater.from(mContext);

        this.dataItens = dataItens;
        this.imageLoader = Application.getInstance().getImageLoader();
    }

    static class ViewHolder {

        NetworkImageView agency_logo;

        TextView type;
        TextView category;
        TextView address;
        TextView district;
        TextView city;
    }

    @Override
    public int getCount() {
        return this.dataItens != null ? this.dataItens.size() : 0;
    }

    @Override
    public Object getItem(int location) {
        return dataItens.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<Data> getDataItens() {
        return dataItens;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final ViewHolder holder;

        if (view == null) {

            holder = new ViewHolder();
            view = this.inflater.inflate(R.layout.row_data, null);

            holder.agency_logo = (NetworkImageView) view.findViewById(R.id.imgLogo);

            holder.type = (TextView) view.findViewById(R.id.txtTipo);
            holder.category = (TextView) view.findViewById(R.id.txtCategoria);
            holder.address = (TextView) view.findViewById(R.id.txtEndereco);
            holder.district = (TextView) view.findViewById(R.id.txtBairro);
            holder.city = (TextView) view.findViewById(R.id.txtCidade);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (imageLoader == null) {
            imageLoader = Application.getInstance().getImageLoader();
        }

        Data data = dataItens.get(position);

        holder.agency_logo.setImageUrl(data.getAgency_logo(), imageLoader);

        holder.type.setText(data.getType());
        holder.category.setText(data.getCategory());
        holder.address.setText(data.getAddress());
        holder.district.setText(data.getDistrict());
        holder.city.setText(data.getCity());

        return view;
    }
}
