package br.com.ivalue.ivalue;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

import br.com.ivalue.models.Data;

/**
 * Created by arthur on 11/02/16.
 */
public class DataSuggestion implements SearchSuggestion {

    private Data mData;

    private String mAddress;

    private boolean mIsHistory;

    public DataSuggestion(Data data) {

        this.mData = data;
        this.mAddress = mData.getAddress();
    }

    public DataSuggestion(Parcel source) {
        this.mAddress = source.readString();
    }

    public Data getmData() {
        return mData;
    }

    public void setIsHistory(boolean isHistory) {
        this.mIsHistory = isHistory;
    }

    public boolean getIsHistory() {
        return this.mIsHistory;
    }

    @Override
    public String getBody() {
        return mData.getAddress();
    }

    @Override
    public Creator getCreator() {
        return CREATOR;
    }

    ///////

    public static final Creator<DataSuggestion> CREATOR = new Creator<DataSuggestion>() {
        @Override
        public DataSuggestion createFromParcel(Parcel in) {
            return new DataSuggestion(in);
        }

        @Override
        public DataSuggestion[] newArray(int size) {
            return new DataSuggestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAddress);
    }
}
