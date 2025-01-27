package cn.vlion.ad.inland.base.util.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionSharedPreferences {
    private static final String KEY_SP_APP_LIST_DATE = "vlion_key_app_list_date";
    private static final String KEY_SP_FOREGROUND_DATE = "vlion_key_foreground_date";
    private static final String KEY_SP_OAID = "vlion_key_oa";
    private static final String KEY_SP_SIDREFRESHDATE = "vlion_key_sIdrefreshdate";
    private static final String KEY_SP_STRATEGUSID = "vlion_key_strategysId";
    private static final String KEY_SP_UA = "vlion_key_ua";
    private static final String KEY_SP_UUID = "vlion_key_uuid";
    private static volatile VlionSharedPreferences instance;
    private static SharedPreferences sharedPreferences;

    private String getAppListLastData() {
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            return sharedPreferences2 != null ? sharedPreferences2.getString(KEY_SP_APP_LIST_DATE, "") : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public static VlionSharedPreferences getInstance() {
        if (instance == null) {
            synchronized (VlionSharedPreferences.class) {
                try {
                    if (instance == null) {
                        instance = new VlionSharedPreferences();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public String getAppActivatedStrategysIdData() {
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            return sharedPreferences2 != null ? sharedPreferences2.getString(KEY_SP_STRATEGUSID, "") : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public String getOaid() {
        SharedPreferences sharedPreferences2;
        try {
            sharedPreferences2 = sharedPreferences;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (sharedPreferences2 == null) {
            return "";
        }
        String string = sharedPreferences2.getString(KEY_SP_OAID, "");
        if (!TextUtils.isEmpty(string)) {
            return VlionAESUtils.decrypt(string, HttpRequestUtil.KEY, HttpRequestUtil.IV);
        }
        return "";
    }

    public boolean getStrategysIdRreshdate() {
        try {
            String dateFormatDay = VlionDateUtils.dateFormatDay();
            SharedPreferences sharedPreferences2 = sharedPreferences;
            String string = sharedPreferences2 != null ? sharedPreferences2.getString(KEY_SP_SIDREFRESHDATE, "") : "";
            if (string.isEmpty()) {
                return true;
            }
            return TextUtils.equals(dateFormatDay, string);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public String getUa() {
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            return sharedPreferences2 != null ? sharedPreferences2.getString(KEY_SP_UA, "") : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public String getUuid() {
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            return sharedPreferences2 != null ? sharedPreferences2.getString(KEY_SP_UUID, "") : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public void initSP(Context context) {
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("vlion_data", 0);
        }
    }

    public boolean isAppListEventTodayHas() {
        try {
            return TextUtils.equals(VlionDateUtils.dateFormatDay(), getAppListLastData());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public void setAppActivatedStrategysIdData(String str) {
        try {
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(KEY_SP_STRATEGUSID, str).putString(KEY_SP_SIDREFRESHDATE, VlionDateUtils.dateFormatDay()).apply();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setAppListEventEventDate() {
        try {
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(KEY_SP_APP_LIST_DATE, VlionDateUtils.dateFormatDay()).apply();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setOaid(String str) {
        try {
            if (sharedPreferences == null || TextUtils.isEmpty(str)) {
                return;
            }
            sharedPreferences.edit().putString(KEY_SP_OAID, VlionAESUtils.encrypt(str, HttpRequestUtil.KEY, HttpRequestUtil.IV)).apply();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setUa(String str) {
        try {
            if (sharedPreferences == null || TextUtils.isEmpty(str)) {
                return;
            }
            sharedPreferences.edit().putString(KEY_SP_UA, str).apply();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setUuid(String str) {
        try {
            if (sharedPreferences == null || TextUtils.isEmpty(str)) {
                return;
            }
            sharedPreferences.edit().putString(KEY_SP_UUID, str).apply();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
