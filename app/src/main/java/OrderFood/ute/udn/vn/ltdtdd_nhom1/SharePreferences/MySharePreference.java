package OrderFood.ute.udn.vn.ltdtdd_nhom1.SharePreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreference {
    private static final String MY_SHARE_PREFERNCES = "MY_SHARE_PREFERNCES";
    private Context mContext;

    public MySharePreference(Context mContext) {
        this.mContext = mContext;
    }

    public void putBooleanValues(String key, boolean value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERNCES,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValues(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERNCES,0);
        return sharedPreferences.getBoolean(key,false);
    }
}
