package cn.vlion.ad.inland.core;

import android.app.Application;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.md5.MD5Utils;
import cn.vlion.ad.inland.core.init.VlionSDk;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdKeys;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {
    public static String a(String str, String str2) {
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", str);
            jSONObject.put("sd", VlionAESUtils.encrypt(b(str, str2), HttpRequestUtil.KEY, HttpRequestUtil.IV));
            str3 = jSONObject.toString();
            LogVlion.e("VlionCoreNetWorkProxy getAdData:jsonObjectAES= " + str3);
        } catch (Exception e10) {
            LogVlion.e("getAESParameterJson ====getParameterJson 请求参数=====Exception=" + e10);
            e10.printStackTrace();
        }
        LogVlion.e("getAESParameterJson ====getParameterJson 请求参数=====" + str3);
        return str3;
    }

    public static String b(String str, String str2) {
        String str3 = "";
        try {
            String cfgVer = VlionServiceConfigParse.getInstance().getCfgVer();
            if (TextUtils.isEmpty(cfgVer)) {
                cfgVer = "";
            }
            Application application = VlionSDkManager.getInstance().getApplication();
            VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
            VlionAppInfo vlionAppInfo = VlionAppInfo.getInstance();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", str);
            jSONObject.put(AdKeys.APP_VER, vlionAppInfo.getVersionName(application));
            jSONObject.put("sdk_ver", VlionSDkManager.getInstance().getSdkVersionName());
            jSONObject.put("cfg_ver", cfgVer);
            jSONObject.put(bt.f23628x, vlionDeviceInfo.getOs());
            jSONObject.put("os_ver", vlionDeviceInfo.getOsv());
            jSONObject.put("platform_list", k0.j());
            jSONObject.put("manufacturer", vlionDeviceInfo.getMake());
            jSONObject.put(bm.f6905j, vlionDeviceInfo.getMake());
            jSONObject.put(bm.f6904i, vlionDeviceInfo.getModel());
            jSONObject.put("screen_width", vlionDeviceInfo.getWidth(application));
            jSONObject.put("screen_height", vlionDeviceInfo.getHeight(application));
            jSONObject.put(bt.N, vlionDeviceInfo.getLanguage());
            jSONObject.put(bt.M, vlionDeviceInfo.getTimezone());
            jSONObject.put("imei", vlionDeviceInfo.getImei(application));
            jSONObject.put(AdKeys.OAID, vlionDeviceInfo.getOaid());
            jSONObject.put("android_id", vlionDeviceInfo.getAndroidId(application));
            jSONObject.put(bd.f23524d, vlionDeviceInfo.getUserAgent(application));
            jSONObject.put("package_name", VlionAppInfo.getInstance().getPackageName(application));
            jSONObject.put(z2.b.f33623h, str2);
            String str4 = str + vlionAppInfo.getVersionName(application) + vlionDeviceInfo.getMake() + cfgVer + vlionDeviceInfo.getLanguage() + vlionDeviceInfo.getMake() + vlionDeviceInfo.getModel() + vlionDeviceInfo.getOs() + vlionDeviceInfo.getOsv() + k0.j() + vlionDeviceInfo.getHeight(application) + vlionDeviceInfo.getWidth(application) + VlionSDk.getSdkVersionName() + vlionDeviceInfo.getTimezone() + str2;
            LogVlion.e("ParameterCoreUtil ====stringBuffer =" + str4);
            jSONObject.put("sign", MD5Utils.getMD5Code(str4));
            str3 = jSONObject.toString();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            LogVlion.e("ParameterCoreUtil ====getParameterJson 请求参数=====Exception=" + th2);
        }
        LogVlion.e("ParameterCoreUtil ====getParameterJson 请求参数=====" + str3);
        return str3;
    }
}
