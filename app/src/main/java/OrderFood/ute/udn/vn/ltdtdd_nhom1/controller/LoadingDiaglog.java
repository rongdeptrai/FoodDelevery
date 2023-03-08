package OrderFood.ute.udn.vn.ltdtdd_nhom1.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;

public class LoadingDiaglog {
    Activity activity;
    AlertDialog alertDialog;
    public LoadingDiaglog(Activity myActivity){
        activity = myActivity;
    }
    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog_login,null));
        builder.setCancelable(true);

        alertDialog = builder.create();
        alertDialog.show();
    }

    public void dismissDialog(){
        alertDialog.dismiss();
    }
}
