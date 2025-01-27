package cn.vlion.ad.inland.base.util.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.google.gson.Gson;

/* loaded from: classes.dex */
public class VlionConfigSharedPreferences {
    private static final String KEY_SP_config = "vlion_key_config";
    private static volatile VlionConfigSharedPreferences instance;
    private static SharedPreferences sharedPreferences;

    public static VlionConfigSharedPreferences getInstance() {
        if (instance == null) {
            synchronized (VlionConfigSharedPreferences.class) {
                try {
                    if (instance == null) {
                        instance = new VlionConfigSharedPreferences();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void clear() {
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().clear().apply();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionServiceConfig getConfigData() {
        VlionServiceConfig vlionServiceConfig;
        VlionServiceConfig.DataBean dataBean;
        try {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                String string = sharedPreferences2.getString(KEY_SP_config, "");
                if (!TextUtils.isEmpty(string)) {
                    String decrypt = VlionAESUtils.decrypt(string, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                    if (!TextUtils.isEmpty(decrypt) && (vlionServiceConfig = (VlionServiceConfig) new Gson().fromJson(decrypt, VlionServiceConfig.class)) != null) {
                        int code = vlionServiceConfig.getCode();
                        LogVlion.e("VlionCoreNetWorkProxy code=: " + code);
                        if (code == 0 && (dataBean = (VlionServiceConfig.DataBean) new Gson().fromJson(vlionServiceConfig.getData(), VlionServiceConfig.DataBean.class)) != null) {
                            vlionServiceConfig.setDataBean(dataBean);
                            return vlionServiceConfig;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return null;
    }

    public void initSP(Context context) {
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("vlion_config", 0);
        }
    }

    public void setConfigData(String str) {
        SharedPreferences sharedPreferences2;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String encrypt = VlionAESUtils.encrypt(str, HttpRequestUtil.KEY, HttpRequestUtil.IV);
            if (TextUtils.isEmpty(encrypt) || (sharedPreferences2 = sharedPreferences) == null) {
                return;
            }
            sharedPreferences2.edit().putString(KEY_SP_config, encrypt).apply();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
