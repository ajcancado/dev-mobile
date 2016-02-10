package br.com.ivalue.ivalue;

import android.app.Activity;
import android.app.ProgressDialog;

public abstract class GenericActivity extends Activity {

    protected ProgressDialog pDialog;

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void showpDialog() {
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }

    protected void hidepDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    protected void configureProgressDialog(String message) {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage(message);
        pDialog.setCancelable(false);
    }
}
