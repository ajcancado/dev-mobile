package br.com.ivalue.helper;


import android.content.Context;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import br.com.ivalue.ivalue.DataSuggestion;
import br.com.ivalue.models.Data;

public class DataHelper {

        private static List<Data> datas = null;

        public interface OnFindResultsListener{

                void onResults(List<DataSuggestion> results);
        }

        public static List<DataSuggestion> getHistory(Context context, ArrayList<Data> filterList ,int count){

                datas = filterList;

                List<DataSuggestion> suggestionList = new ArrayList<>();

                DataSuggestion colorSuggestion;
                for(int i=0; i<count; i++){
                        colorSuggestion = new DataSuggestion(datas.get(i));
                        colorSuggestion.setIsHistory(true);
                        suggestionList.add(colorSuggestion);
                }

                return suggestionList;
        }

        public static void find(Context context, String query, ArrayList<Data> filterList ,final OnFindResultsListener listener){

                datas = filterList;

                new Filter(){

                        @Override
                        protected FilterResults performFiltering(CharSequence constraint) {


                                List<DataSuggestion> suggestionList = new ArrayList<>();

                                if (!(constraint == null || constraint.length() == 0)) {

                                        for(Data data: datas){

                                                if(data.getAddress().toUpperCase().contains(constraint.toString().toUpperCase()))
                                                        suggestionList.add(new DataSuggestion(data));
                                        }

                                }

                                FilterResults results = new FilterResults();
                                results.values = suggestionList;
                                results.count = suggestionList.size();

                                return results;
                        }

                        @Override
                        protected void publishResults(CharSequence constraint, FilterResults results) {

                                if(listener!=null)
                                        listener.onResults((List<DataSuggestion>) results.values);
                        }
                }.filter(query);

        }

}