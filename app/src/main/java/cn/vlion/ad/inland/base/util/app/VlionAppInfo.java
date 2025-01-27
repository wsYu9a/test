package cn.vlion.ad.inland.base.util.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.p;
import cn.vlion.ad.inland.base.u0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.sigmob.windad.WindAds;

/* loaded from: classes.dex */
public class VlionAppInfo {
    private String appName;
    private String appVersion;
    private String currency;
    private String packageName;

    public static class b {

        /* renamed from: a */
        public static VlionAppInfo f3402a = new VlionAppInfo();
    }

    private VlionAppInfo() {
    }

    public static VlionAppInfo getInstance() {
        return b.f3402a;
    }

    public String getAppName(Context context) {
        StringBuilder sb2;
        String str;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        String str2;
        if (TextUtils.isEmpty(this.appName)) {
            if (context != null) {
                try {
                    packageManager = context.getPackageManager();
                    applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException e10) {
                    e = e10;
                    sb2 = new StringBuilder();
                    str = "getAppNameError: app name NameNotFoundException：";
                    sb2.append(str);
                    sb2.append(e);
                    LogVlion.e(sb2.toString());
                    VlionSDkManager.getInstance().upLoadCatchException(e);
                    str2 = "";
                    this.appName = str2;
                    return this.appName;
                } catch (Throwable th2) {
                    e = th2;
                    sb2 = new StringBuilder();
                    str = "getAppNameError: app name Throwable：";
                    sb2.append(str);
                    sb2.append(e);
                    LogVlion.e(sb2.toString());
                    VlionSDkManager.getInstance().upLoadCatchException(e);
                    str2 = "";
                    this.appName = str2;
                    return this.appName;
                }
                if (applicationInfo != null) {
                    str2 = (String) packageManager.getApplicationLabel(applicationInfo);
                    this.appName = str2;
                }
            }
            str2 = "";
            this.appName = str2;
        }
        return this.appName;
    }

    public String getCurrency() {
        return WindAds.USD;
    }

    public String getPackageName(Context context) {
        if (TextUtils.isEmpty(this.packageName)) {
            this.packageName = u0.a(context);
        }
        return this.packageName;
    }

    public float getSystemVolume(Context context) {
        if (context == null) {
            return 0.0f;
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int streamVolume = audioManager != null ? audioManager.getStreamVolume(3) : 0;
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            LogVlion.e("sysVolume=" + streamVolume);
            if (streamVolume > 0) {
                return (streamVolume * 1.0f) / streamMaxVolume;
            }
            return 0.0f;
        } catch (Throwable th2) {
            p.a(th2, "getSystemVolume:  Throwable：", th2);
            return 0.0f;
        }
    }

    public String getVersionName(Context context) {
        if (TextUtils.isEmpty(this.appVersion)) {
            String str = "";
            if (context != null) {
                try {
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        if (packageInfo != null) {
                            str = packageInfo.versionName;
                        }
                    } catch (Throwable th2) {
                        LogVlion.e("getVersionName:  Throwable：" + th2);
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    if (TextUtils.isEmpty(str)) {
                        LogVlion.e("getVersionNameError: version name is null");
                    }
                } catch (Throwable th3) {
                    p.a(th3, "getAppNameError: app name Throwable：", th3);
                }
            }
            this.appVersion = str;
        }
        return this.appVersion;
    }

    public void hideNavigationBar(Activity activity) {
        u0.a(activity);
    }

    public boolean isApkInDebug(Context context) {
        return u0.b(context);
    }

    public /* synthetic */ VlionAppInfo(a aVar) {
        this();
    }
}
