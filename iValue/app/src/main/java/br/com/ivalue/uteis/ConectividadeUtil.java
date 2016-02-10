package br.com.ivalue.uteis;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

public class ConectividadeUtil {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    @SuppressLint("InlinedApi")
    public static boolean isAirplaneModeOn(Context context) {

        return Settings.System.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }

    public static void confirmarModoAviao(final Context contexto) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(contexto);

        alertDialog.setTitle("Modo Avião");
        alertDialog
                .setMessage("Seu smartphone está no modo avião. Você gostaria de ir ao menu de configurações e desativa-lo ?");

        alertDialog.setPositiveButton("Configurações",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                        contexto.startActivity(intent);
                    }
                });

        alertDialog.setNegativeButton("Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

    public static void confirmarConexaoInternet(final Context contexto) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(contexto);

        alertDialog.setTitle("Sem internet");
        alertDialog
                .setMessage("Seu smartphone está sem conexão. Você gostaria de ir ao menu de configurações e ativa-la ?");

        alertDialog.setPositiveButton("WIFI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_WIFI_SETTINGS);
                        contexto.startActivity(intent);
                    }
                });

        alertDialog.setNeutralButton("Dados Móveis",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(
                                "com.android.settings",
                                "com.android.settings.Settings$DataUsageSummaryActivity"));
                        contexto.startActivity(intent);
                    }
                });

        alertDialog.setNegativeButton("Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }
}
