package cn.vlion.ad.inland.base.util.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.Map;

/* loaded from: classes.dex */
public class VlionAdStrategySharedPreferences {
    public static final String REFRESHDATE = "refreshdate";
    private static volatile VlionAdStrategySharedPreferences instance;
    private SharedPreferences sharedPreferences;

    public static VlionAdStrategySharedPreferences getInstance() {
        if (instance == null) {
            synchronized (VlionAdStrategySharedPreferences.class) {
                try {
                    if (instance == null) {
                        instance = new VlionAdStrategySharedPreferences();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void clearSP() {
        try {
            SharedPreferences sharedPreferences = this.sharedPreferences;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public boolean getADStrategysIdRreshdate() {
        try {
            String dateFormatDay = VlionDateUtils.dateFormatDay();
            SharedPreferences sharedPreferences = this.sharedPreferences;
            String string = sharedPreferences != null ? sharedPreferences.getString("refreshdate", "") : "";
            if (!TextUtils.isEmpty(string) && !TextUtils.equals(dateFormatDay, string)) {
                if (!string.isEmpty()) {
                    clearSP();
                }
                return false;
            }
            return true;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public Map<String, ?> initSpgetAll(Context context) {
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("vlion_ad_strategy", 0);
                this.sharedPreferences = sharedPreferences;
                return sharedPreferences.getAll();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return null;
    }

    public void setADStrategysData(String str, String str2) {
        try {
            if (this.sharedPreferences == null || str == null || str2 == null) {
                return;
            }
            this.sharedPreferences.edit().putString(str, str2).putString("refreshdate", VlionDateUtils.dateFormatDay()).apply();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
