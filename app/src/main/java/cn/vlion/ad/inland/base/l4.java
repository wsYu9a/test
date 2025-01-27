package cn.vlion.ad.inland.base;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Build;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.io.File;

/* loaded from: classes.dex */
public final class l4 {

    /* renamed from: f */
    public static volatile l4 f3066f;

    /* renamed from: a */
    public volatile boolean f3067a;

    /* renamed from: b */
    public d0 f3068b;

    /* renamed from: c */
    public int f3069c = -1;

    /* renamed from: d */
    public int f3070d = -1;

    /* renamed from: e */
    public int f3071e = -1;

    public final synchronized void a(Application application) {
        if (!this.f3067a) {
            try {
                if (application != null) {
                    LogVlion.e("VlionCustomSDk getAppId() =");
                    s sVar = new s();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 33) {
                        application.registerReceiver(sVar, intentFilter, 2);
                    } else {
                        application.registerReceiver(sVar, intentFilter);
                    }
                    LogVlion.e("VlionCustomSDk onInitSuccess " + i10);
                    this.f3067a = true;
                    try {
                        LogVlion.e("deleteAllVideoFile=");
                        t.a(t.c(application));
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    try {
                        LogVlion.e("deleteAllRewardVideo=");
                        String str = "";
                        try {
                            str = t.d(application) + "reward" + File.separator;
                            File file = new File(str);
                            if (!file.exists()) {
                                LogVlion.e("getDownRewardVideoPath mkdirs is" + file.mkdirs());
                            }
                        } catch (Throwable th3) {
                            VlionSDkManager.getInstance().upLoadCatchException(th3);
                        }
                        t.a(str);
                    } catch (Throwable th4) {
                        VlionSDkManager.getInstance().upLoadCatchException(th4);
                    }
                    try {
                        LogVlion.e("deleteAllApk=");
                        t.a(t.a(application));
                    } catch (Throwable th5) {
                        VlionSDkManager.getInstance().upLoadCatchException(th5);
                    }
                    try {
                        LogVlion.e("getDownNativesVideoPath=");
                        t.a(t.b(application));
                    } catch (Throwable th6) {
                        VlionSDkManager.getInstance().upLoadCatchException(th6);
                    }
                } else {
                    this.f3067a = false;
                    LogVlion.e("VlionCustomSDk onInitFailure application=" + application);
                }
            } catch (Throwable th7) {
                StringBuilder a10 = l1.a("VlionCustomSDk initSDK Throwable=");
                a10.append(th7.getMessage());
                LogVlion.e(a10.toString());
            }
        }
    }

    public final void a(Application application, VlionServiceConfig.DataBean.ListenSwitchBean listenSwitchBean) {
        try {
            this.f3068b = new d0();
            IntentFilter intentFilter = new IntentFilter();
            if (listenSwitchBean.getInstalled() == 1) {
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                LogVlion.e("VLionAddReceiver  开启 = AddReceiver   ACTION_PACKAGE_ADDED ");
            }
            if (listenSwitchBean.getUpdated() == 1) {
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                LogVlion.e("VLionAddReceiver  开启 = AddReceiver   ACTION_PACKAGE_REPLACED ");
            }
            if (listenSwitchBean.getRemoved() == 1) {
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                LogVlion.e("VLionAddReceiver  开启 = AddReceiver   ACTION_PACKAGE_REMOVED ");
            }
            this.f3069c = listenSwitchBean.getInstalled();
            this.f3070d = listenSwitchBean.getUpdated();
            this.f3071e = listenSwitchBean.getRemoved();
            intentFilter.addDataScheme("package");
            application.registerReceiver(this.f3068b, intentFilter);
            LogVlion.e("VLionAddReceiver  开启 = AddReceiver");
            LogVlion.e("VlionCustomSDk  开启 = AddReceiver ");
        } catch (Throwable th2) {
            StringBuilder a10 = l1.a("VlionCustomSDk initVLionAddReceiver Throwable=");
            a10.append(th2.getMessage());
            LogVlion.e(a10.toString());
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
