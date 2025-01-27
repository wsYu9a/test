package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.beta.upgrade.ActiveListener;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.upgrade.d;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0912p;
import com.tencent.bugly.proguard.C0915t;
import com.tencent.bugly.proguard.C0917v;
import com.tencent.bugly.proguard.C0919x;
import com.tencent.bugly.proguard.C0920y;
import com.tencent.bugly.proguard.C0921z;
import com.tencent.bugly.proguard.H;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.r;
import com.umeng.analytics.pro.aq;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Beta extends a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    public static ActiveListener activeListener = null;
    public static boolean autoCheckAppUpgrade = false;
    public static boolean autoCheckHotfix = false;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoInit = true;
    public static BetaPatchListener betaPatchListener = null;
    public static int defaultBannerId = 0;
    public static DownloadListener downloadListener = null;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static int largeIconId = 0;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static boolean autoDownloadOnWifi = false;
    public static boolean canShowApkInfo = true;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static String appVersionName = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appChannel = null;
    public static boolean canNotifyUserRestart = false;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static boolean dialogFullScreen = false;
    public static boolean autoInstallApk = true;
    public static boolean autoDownloadOn4g = false;
    public static boolean setPatchRestartOnScreenOff = true;
    public static boolean enableActiveH5Alert = true;
    public static Beta instance = new Beta();

    /* renamed from: a */
    private static DownloadTask f24591a = null;

    private static void a(boolean z, boolean z2, int i2) {
        try {
            if (z) {
                d.f24648a.a(z, z2, i2);
                UpgradeStateListener upgradeStateListener2 = upgradeStateListener;
                if (upgradeStateListener2 != null) {
                    e.a(new com.tencent.bugly.beta.global.d(18, upgradeStateListener2, 2, Boolean.valueOf(z)));
                } else {
                    e.a(new com.tencent.bugly.beta.global.d(5, strToastCheckingUpgrade));
                }
            } else if (i2 == 0 || i2 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy != null && betaGrayStrategy.f24634a != null && System.currentTimeMillis() - betaGrayStrategy.f24638e <= com.tencent.bugly.beta.global.e.f24621b.f24623d) {
                    d.f24648a.a(z, z2, 0, null, "");
                }
                d.f24648a.a(z, z2, i2);
            } else if (i2 != 3) {
            } else {
                r.f25134a.a(z, z2, 3);
            }
        } catch (Exception e2) {
            if (X.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() {
        if (new File(com.tencent.bugly.beta.global.e.f24621b.J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(com.tencent.bugly.beta.global.e.f24621b.J.getAbsolutePath(), true);
        } else {
            X.b(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (((java.lang.Boolean) r1[2]).booleanValue() == com.tencent.bugly.beta.upgrade.d.f24648a.f24654g) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cancelDownload() {
        /*
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.f24648a
            com.tencent.bugly.beta.global.d r1 = r0.f24657j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
            java.lang.Object[] r1 = r1.f24619b
            r5 = r1[r4]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f24650c
            if (r5 != r6) goto L25
            r5 = r1[r3]
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = r0.f24649b
            if (r5 != r0) goto L25
            r0 = r1[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.tencent.bugly.beta.upgrade.d r1 = com.tencent.bugly.beta.upgrade.d.f24648a
            boolean r1 = r1.f24654g
            if (r0 == r1) goto L43
        L25:
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.f24648a
            com.tencent.bugly.beta.global.d r1 = new com.tencent.bugly.beta.global.d
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f24650c
            r5[r4] = r6
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r0.f24649b
            r5[r3] = r4
            boolean r3 = r0.f24654g
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r5[r2] = r3
            r2 = 14
            r1.<init>(r2, r5)
            r0.f24657j = r1
        L43:
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.f24648a
            com.tencent.bugly.beta.global.d r0 = r0.f24657j
            r0.run()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.cancelDownload():void");
    }

    public static void checkAppUpgrade() {
        a(true, false, 1);
    }

    public static void checkHotFix() {
        a(false, false, 3);
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void cleanTinkerPatch(boolean z) {
        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void downloadPatch() {
        r rVar = r.f25134a;
        rVar.f25135b = rVar.a((B) null);
        try {
            r rVar2 = r.f25134a;
            BetaGrayStrategy betaGrayStrategy = rVar2.f25135b;
            if (betaGrayStrategy != null) {
                rVar2.a(0, betaGrayStrategy.f24634a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            d.f24648a.f24649b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy = d.f24648a.f24649b;
            if (betaGrayStrategy != null) {
                return new UpgradeInfo(betaGrayStrategy.f24634a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            r.f25134a.f25135b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy = r.f25134a.f25135b;
            if (betaGrayStrategy != null) {
                return new UpgradeInfo(betaGrayStrategy.f24634a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.id = 1002;
        beta.version = "1.5.23";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (f24591a == null) {
            d.f24648a.f24649b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (d.f24648a.f24649b != null) {
                DownloadTask a2 = com.tencent.bugly.beta.global.e.f24621b.s.a(d.f24648a.f24649b.f24634a.k.f25178c, com.tencent.bugly.beta.global.e.f24621b.w.getAbsolutePath(), null, d.f24648a.f24649b.f24634a.k.f25177b);
                f24591a = a2;
                a2.setDownloadType(1);
                d.f24648a.f24650c = f24591a;
            }
        }
        return d.f24648a.f24650c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        return new com.tencent.bugly.beta.UpgradeInfo(r0.f24634a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.bugly.beta.UpgradeInfo getUpgradeInfo() {
        /*
            java.lang.String r0 = "hotfix.strategy.bch"
            r1 = 0
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r2 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L43
            android.os.Parcelable r0 = com.tencent.bugly.beta.global.a.a(r0, r2)     // Catch: java.lang.Exception -> L43
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r0     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = "app.upgrade.strategy.bch"
            android.os.Parcelable r2 = com.tencent.bugly.beta.global.a.a(r3, r2)     // Catch: java.lang.Exception -> L43
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch: java.lang.Exception -> L43
            if (r0 == 0) goto L28
            com.tencent.bugly.proguard.B r3 = r0.f24634a     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L28
            if (r2 == 0) goto L28
            com.tencent.bugly.proguard.B r3 = r2.f24634a     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L28
            long r3 = r0.f24638e     // Catch: java.lang.Exception -> L43
            long r5 = r2.f24638e     // Catch: java.lang.Exception -> L43
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L38
            goto L39
        L28:
            if (r0 == 0) goto L38
            com.tencent.bugly.proguard.B r3 = r0.f24634a     // Catch: java.lang.Exception -> L43
            if (r3 != 0) goto L2f
            goto L38
        L2f:
            if (r2 == 0) goto L39
            com.tencent.bugly.proguard.B r2 = r2.f24634a     // Catch: java.lang.Exception -> L43
            if (r2 != 0) goto L36
            goto L39
        L36:
            r0 = r1
            goto L39
        L38:
            r0 = r2
        L39:
            if (r0 == 0) goto L43
            com.tencent.bugly.beta.UpgradeInfo r2 = new com.tencent.bugly.beta.UpgradeInfo     // Catch: java.lang.Exception -> L43
            com.tencent.bugly.proguard.B r0 = r0.f24634a     // Catch: java.lang.Exception -> L43
            r2.<init>(r0)     // Catch: java.lang.Exception -> L43
            return r2
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized B getUpgradeStrategy() {
        synchronized (Beta.class) {
            d.f24648a.f24649b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            try {
                BetaGrayStrategy betaGrayStrategy = d.f24648a.f24649b;
                if (betaGrayStrategy != null) {
                    return (B) betaGrayStrategy.f24634a.clone();
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (Beta.class) {
            X.c("Beta init start....", new Object[0]);
            H a2 = H.a();
            int i2 = instance.id;
            int i3 = com.tencent.bugly.beta.global.e.f24620a + 1;
            com.tencent.bugly.beta.global.e.f24620a = i3;
            a2.a(i2, i3);
            if (TextUtils.isEmpty(initProcessName)) {
                initProcessName = context.getPackageName();
            }
            X.c("Beta will init at: %s", initProcessName);
            String str = com.tencent.bugly.crashreport.common.info.a.m().f24755h;
            X.c("current process: %s", str);
            if (TextUtils.equals(initProcessName, str)) {
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f24621b;
                if (!TextUtils.isEmpty(eVar.y)) {
                    X.e("Beta has been initialized [apkMD5 : %s]", eVar.y);
                    return;
                }
                X.c("current upgrade sdk version:1.5.23", new Object[0]);
                eVar.G = z;
                long j2 = upgradeCheckPeriod;
                if (j2 < 0) {
                    X.e("upgradeCheckPeriod cannot be negative", new Object[0]);
                } else {
                    eVar.f24623d = j2;
                    X.c("setted upgradeCheckPeriod: %d", Long.valueOf(j2));
                }
                long j3 = initDelay;
                if (j3 < 0) {
                    X.e("initDelay cannot be negative", new Object[0]);
                } else {
                    eVar.f24622c = j3;
                    X.c("setted initDelay: %d", Long.valueOf(j3));
                }
                if (smallIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(smallIconId) != null) {
                            int i4 = smallIconId;
                            eVar.f24628i = i4;
                            X.c("setted smallIconId: %d", Integer.valueOf(i4));
                        }
                    } catch (Exception e2) {
                        X.b("smallIconId is not available:\n %s", e2.toString());
                    }
                }
                if (largeIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(largeIconId) != null) {
                            int i5 = largeIconId;
                            eVar.f24629j = i5;
                            X.c("setted largeIconId: %d", Integer.valueOf(i5));
                        }
                    } catch (Exception e3) {
                        X.b("largeIconId is not available:\n %s", e3.toString());
                    }
                }
                if (defaultBannerId != 0) {
                    try {
                        if (context.getResources().getDrawable(defaultBannerId) != null) {
                            int i6 = defaultBannerId;
                            eVar.k = i6;
                            X.c("setted defaultBannerId: %d", Integer.valueOf(i6));
                        }
                    } catch (Exception e4) {
                        X.b("defaultBannerId is not available:\n %s", e4.toString());
                    }
                }
                if (upgradeDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout = context.getResources().getLayout(upgradeDialogLayoutId);
                        if (layout != null) {
                            int i7 = upgradeDialogLayoutId;
                            eVar.l = i7;
                            X.c("setted upgradeDialogLayoutId: %d", Integer.valueOf(i7));
                            layout.close();
                        }
                    } catch (Exception e5) {
                        X.b("upgradeDialogLayoutId is not available:\n %s", e5.toString());
                    }
                }
                if (tipsDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                        if (layout2 != null) {
                            int i8 = tipsDialogLayoutId;
                            eVar.m = i8;
                            X.c("setted tipsDialogLayoutId: %d", Integer.valueOf(i8));
                            layout2.close();
                        }
                    } catch (Exception e6) {
                        X.b("tipsDialogLayoutId is not available:\n %s", e6.toString());
                    }
                }
                UILifecycleListener<UpgradeInfo> uILifecycleListener = upgradeDialogLifecycleListener;
                if (uILifecycleListener != null) {
                    try {
                        eVar.n = uILifecycleListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append("setted upgradeDialogLifecycleListener:%s");
                        sb.append(upgradeDialogLifecycleListener);
                        X.c(sb.toString(), new Object[0]);
                    } catch (Exception e7) {
                        X.b("upgradeDialogLifecycleListener is not available:\n %", e7.toString());
                    }
                }
                List<Class<? extends Activity>> list = canShowUpgradeActs;
                if (list != null && !list.isEmpty()) {
                    for (Class<? extends Activity> cls : canShowUpgradeActs) {
                        if (cls != null) {
                            eVar.p.add(cls);
                        }
                    }
                    X.c("setted canShowUpgradeActs: %s", eVar.p);
                }
                List<Class<? extends Activity>> list2 = canNotShowUpgradeActs;
                if (list2 != null && !list2.isEmpty()) {
                    for (Class<? extends Activity> cls2 : canNotShowUpgradeActs) {
                        if (cls2 != null) {
                            eVar.q.add(cls2);
                        }
                    }
                    X.c("setted canNotShowUpgradeActs: %s", eVar.q);
                }
                boolean z2 = autoCheckUpgrade;
                eVar.f24624e = z2;
                eVar.f24625f = autoCheckAppUpgrade;
                eVar.f24626g = autoCheckHotfix;
                Object[] objArr = new Object[1];
                objArr[0] = z2 ? "is opened" : "is closed";
                X.c("autoCheckUpgrade %s", objArr);
                Object[] objArr2 = new Object[1];
                objArr2[0] = eVar.f24625f ? "is opened" : "is closed";
                X.c("autoCheckAppUpgrade %s", objArr2);
                Object[] objArr3 = new Object[1];
                objArr3[0] = eVar.f24626g ? "is opened" : "is closed";
                X.c("autoCheckHotfix %s", objArr3);
                boolean z3 = autoInstallApk;
                eVar.fa = z3;
                Object[] objArr4 = new Object[1];
                objArr4[0] = z3 ? "is opened" : "is closed";
                X.c("autoInstallApk %s", objArr4);
                boolean z4 = autoDownloadOn4g;
                eVar.V = z4;
                Object[] objArr5 = new Object[1];
                objArr5[0] = z4 ? "is opened" : "is closed";
                X.c("autoDownloadOn4g %s", objArr5);
                boolean z5 = showInterruptedStrategy;
                eVar.f24627h = z5;
                Object[] objArr6 = new Object[1];
                objArr6[0] = z5 ? "is opened" : "is closed";
                X.c("showInterruptedStrategy %s", objArr6);
                Object[] objArr7 = new Object[1];
                objArr7[0] = upgradeListener != null ? "is opened" : "is closed";
                X.c("isDIY %s", objArr7);
                File file = storageDir;
                if (file != null) {
                    if (file.exists() || storageDir.mkdirs()) {
                        File file2 = storageDir;
                        eVar.o = file2;
                        X.c("setted storageDir: %s", file2.getAbsolutePath());
                    } else {
                        X.c("storageDir is not exists: %s", storageDir.getAbsolutePath());
                    }
                }
                if (eVar.s == null) {
                    eVar.s = C0917v.f25173a;
                }
                if (TextUtils.isEmpty(eVar.x)) {
                    eVar.x = com.tencent.bugly.crashreport.common.info.a.m().e();
                }
                eVar.T = enableNotification;
                X.c("enableNotification %s", enableNotification + "");
                eVar.U = autoDownloadOnWifi;
                X.c("autoDownloadOnWifi %s", autoDownloadOnWifi + "");
                eVar.W = canShowApkInfo;
                X.c("canShowApkInfo %s", canShowApkInfo + "");
                eVar.X = canAutoPatch;
                X.c("canAutoPatch %s", canAutoPatch + "");
                eVar.Y = betaPatchListener;
                eVar.A = appVersionName;
                eVar.z = appVersionCode;
                eVar.Z = canNotifyUserRestart;
                X.c("canNotifyUserRestart %s", canNotifyUserRestart + "");
                eVar.aa = canAutoDownloadPatch;
                X.c("canAutoDownloadPatch %s", canAutoDownloadPatch + "");
                eVar.ba = enableHotfix;
                X.c("enableHotfix %s", enableHotfix + "");
                List<String> list3 = soBlackList;
                if (list3 != null && !list3.isEmpty()) {
                    for (String str2 : soBlackList) {
                        if (str2 != null) {
                            eVar.ca.add(str2);
                        }
                    }
                    X.c("setted soBlackList: %s", eVar.ca);
                }
                String str3 = appChannel;
                if (str3 != null) {
                    eVar.R = str3;
                    X.c("Beta channel %s", str3);
                }
                eVar.a(context);
                ResBean resBean = (ResBean) com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.CREATOR);
                ResBean.f24609a = resBean;
                if (resBean == null) {
                    ResBean.f24609a = new ResBean();
                }
                d dVar = d.f24648a;
                dVar.f24652e = upgradeListener;
                dVar.f24653f = upgradeStateListener;
                dVar.f24651d = downloadListener;
                if (getStrategyTask() != null && downloadListener != null) {
                    getStrategyTask().addListener(d.f24648a.f24651d);
                }
                if (enableHotfix) {
                    X.c("enableHotfix %s", "1");
                    ca.c("D4", "1");
                    C0915t.a(context);
                }
                Resources resources = context.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = resources.getConfiguration();
                Locale locale = Locale.getDefault();
                configuration.locale = locale;
                if (locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
                    strToastYourAreTheLatestVersion = context.getResources().getString(R.string.strToastYourAreTheLatestVersion);
                    strToastCheckUpgradeError = context.getResources().getString(R.string.strToastCheckUpgradeError);
                    strToastCheckingUpgrade = context.getResources().getString(R.string.strToastCheckingUpgrade);
                    strNotificationDownloading = context.getResources().getString(R.string.strNotificationDownloading);
                    strNotificationClickToView = context.getResources().getString(R.string.strNotificationClickToView);
                    strNotificationClickToInstall = context.getResources().getString(R.string.strNotificationClickToInstall);
                    strNotificationClickToContinue = context.getResources().getString(R.string.strNotificationClickToContinue);
                    strNotificationClickToRetry = context.getResources().getString(R.string.strNotificationClickToRetry);
                    strNotificationDownloadSucc = context.getResources().getString(R.string.strNotificationDownloadSucc);
                    strNotificationDownloadError = context.getResources().getString(R.string.strNotificationDownloadError);
                    strNotificationHaveNewVersion = context.getResources().getString(R.string.strNotificationHaveNewVersion);
                    strNetworkTipsMessage = context.getResources().getString(R.string.strNetworkTipsMessage);
                    strNetworkTipsTitle = context.getResources().getString(R.string.strNetworkTipsTitle);
                    strNetworkTipsConfirmBtn = context.getResources().getString(R.string.strNetworkTipsConfirmBtn);
                    strNetworkTipsCancelBtn = context.getResources().getString(R.string.strNetworkTipsCancelBtn);
                    strUpgradeDialogVersionLabel = context.getResources().getString(R.string.strUpgradeDialogVersionLabel);
                    strUpgradeDialogFileSizeLabel = context.getResources().getString(R.string.strUpgradeDialogFileSizeLabel);
                    strUpgradeDialogUpdateTimeLabel = context.getResources().getString(R.string.strUpgradeDialogUpdateTimeLabel);
                    strUpgradeDialogFeatureLabel = context.getResources().getString(R.string.strUpgradeDialogFeatureLabel);
                    strUpgradeDialogUpgradeBtn = context.getResources().getString(R.string.strUpgradeDialogUpgradeBtn);
                    strUpgradeDialogInstallBtn = context.getResources().getString(R.string.strUpgradeDialogInstallBtn);
                    strUpgradeDialogRetryBtn = context.getResources().getString(R.string.strUpgradeDialogRetryBtn);
                    strUpgradeDialogContinueBtn = context.getResources().getString(R.string.strUpgradeDialogContinueBtn);
                    strUpgradeDialogCancelBtn = context.getResources().getString(R.string.strUpgradeDialogCancelBtn);
                }
                resources.updateConfiguration(configuration, displayMetrics);
                W.c().a(new com.tencent.bugly.beta.global.d(1, new Object[0]), eVar.f24622c);
                H a3 = H.a();
                int i9 = instance.id;
                int i10 = com.tencent.bugly.beta.global.e.f24620a - 1;
                com.tencent.bugly.beta.global.e.f24620a = i10;
                a3.a(i9, i10);
                X.c("Beta init finished...", new Object[0]);
            }
        }
    }

    public static synchronized void installApk(File file) {
        synchronized (Beta.class) {
            try {
                B upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.f24621b.v, file, upgradeStrategy.k.f25177b)) {
                    C0912p.f25111a.a(new C0921z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f24932j, upgradeStrategy.r, upgradeStrategy.u, null));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void installTinker() {
        enableHotfix = true;
        installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerManager.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerManager.loadArmV7Library(context, str);
    }

    public static void loadLibrary(String str) {
        boolean z;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f24621b;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (!com.tencent.bugly.beta.global.a.a("LoadSoFileResult", true)) {
                        System.loadLibrary(str);
                        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                        return;
                    }
                    com.tencent.bugly.beta.global.a.b("LoadSoFileResult", false);
                    String a2 = com.tencent.bugly.beta.global.a.a(str, "");
                    boolean a3 = com.tencent.bugly.beta.global.a.a("PatchResult", false);
                    if (TextUtils.isEmpty(a2) || !a3) {
                        z = false;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("lib/");
                        sb.append(a2);
                        z = TinkerManager.loadLibraryFromTinker(eVar.v, sb.toString(), str);
                    }
                    if (!z) {
                        System.loadLibrary(str);
                    }
                    com.tencent.bugly.beta.global.a.b("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                com.tencent.bugly.beta.global.a.b("LoadSoFileResult", false);
                return;
            }
        }
        X.b("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, int i6, long j4, String str7, boolean z, boolean z2, int i7, String str8, long j5) {
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i5));
            d.f24648a.a(z, z2, i7, new B(str, str2, j2, 0, new C0920y(com.tencent.bugly.beta.global.e.f24621b.x, (byte) 1, i4, str3, i3, "", 1L, "", str5, "", ""), new C0919x(str5, str4, "", j3, ""), (byte) i2, i6, j4, null, "", hashMap, str7, 1, j5, 1), str8 == null ? "" : str8);
        }
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        com.tencent.bugly.beta.global.e.f24621b.t = downloadListener2;
        if (downloadListener2 == null || (downloadTask = d.f24648a.f24650c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        synchronized (Beta.class) {
            try {
                B upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && z) {
                    C0912p.f25111a.a(new C0921z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f24932j, upgradeStrategy.r, upgradeStrategy.u, null));
                    X.c("安装事件保存成功", new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        B b2;
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i5));
            B b3 = new B(str, str2, j2, 0, new C0920y(com.tencent.bugly.beta.global.e.f24621b.x, (byte) 1, i4, str3, i3, "", 1L, "", str5, "1.5.23", ""), new C0919x(str5, str4, "", j3, ""), (byte) i2, 0, 0L, null, "", hashMap, null, 1, System.currentTimeMillis(), 1);
            DownloadTask downloadTask = f24591a;
            if (downloadTask != null && !downloadTask.getDownloadUrl().equals(str4)) {
                f24591a.delete(true);
                f24591a = null;
            }
            if (f24591a == null) {
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f24621b;
                b2 = b3;
                DownloadTask a2 = eVar.s.a(b2.k.f25178c, eVar.w.getAbsolutePath(), null, b2.k.f25177b);
                f24591a = a2;
                a2.setDownloadType(1);
            } else {
                b2 = b3;
            }
            f24591a.addListener(downloadListener2);
            UpgradeDialog.instance.setUpgradeInfo(b2, f24591a);
            UpgradeDialog upgradeDialog = UpgradeDialog.instance;
            upgradeDialog.upgradeRunnable = runnable;
            upgradeDialog.cancelRunnable = runnable2;
            f.f24630a.a(com.tencent.bugly.beta.global.e.f24621b.s, b2.q);
            if (z) {
                f fVar = f.f24630a;
                Object[] objArr = new Object[2];
                objArr[0] = UpgradeDialog.instance;
                objArr[1] = Boolean.valueOf(b2.l == 2);
                fVar.a(new com.tencent.bugly.beta.global.d(2, objArr), 3000);
            } else {
                f fVar2 = f.f24630a;
                Object[] objArr2 = new Object[2];
                objArr2[0] = UpgradeDialog.instance;
                objArr2[1] = Boolean.valueOf(b2.l == 2);
                fVar2.a(new com.tencent.bugly.beta.global.d(2, objArr2));
            }
        }
    }

    public static DownloadTask startDownload() {
        d dVar = d.f24648a;
        com.tencent.bugly.beta.global.d dVar2 = dVar.f24656i;
        if (dVar2 == null || dVar2.f24619b[0] != dVar.f24650c) {
            dVar.f24656i = new com.tencent.bugly.beta.global.d(13, dVar.f24650c, dVar.f24649b);
        }
        d.f24648a.f24656i.run();
        return d.f24648a.f24650c;
    }

    public static void unInit() {
        if (com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false)) {
            com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = d.f24648a.f24650c;
        if (downloadTask != null) {
            downloadTask.removeListener(com.tencent.bugly.beta.global.e.f24621b.t);
        }
        com.tencent.bugly.beta.global.e.f24621b.t = null;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // com.tencent.bugly.a
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        int i4;
        String str;
        String str2;
        Cursor cursor;
        String str3 = " , ";
        String str4 = "_id";
        int i5 = i2;
        int i6 = i3;
        while (i5 < i6) {
            if (i5 != 10) {
                i4 = i5;
                str = str3;
                str2 = str4;
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.setLength(0);
                    sb.append(" CREATE TABLE  IF NOT EXISTS ");
                    sb.append("st_1002");
                    sb.append(" ( ");
                    sb.append(str4);
                    sb.append(" ");
                    sb.append("integer");
                    sb.append(str3);
                    sb.append(aq.f25697e);
                    sb.append(" ");
                    sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
                    sb.append(str3);
                    sb.append("_tm");
                    sb.append(" ");
                    sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                    sb.append(str3);
                    sb.append("_dt");
                    sb.append(" ");
                    sb.append("blob");
                    sb.append(",primary key(");
                    sb.append(str4);
                    sb.append(",");
                    sb.append(aq.f25697e);
                    sb.append(" )) ");
                    X.a("create %s", sb.toString());
                    sQLiteDatabase.execSQL(sb.toString());
                } catch (Throwable th) {
                    if (!X.a(th)) {
                        th.printStackTrace();
                    }
                }
                i4 = i5;
                str = str3;
                str2 = str4;
                try {
                    cursor = sQLiteDatabase.query("t_pf", null, "_id = 1002", null, null, null, null);
                    if (cursor == null) {
                        if (cursor != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    while (cursor.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            if (cursor.getLong(cursor.getColumnIndex(str2)) > 0) {
                                contentValues.put(str2, Long.valueOf(cursor.getLong(cursor.getColumnIndex(str2))));
                            }
                            contentValues.put("_tm", Long.valueOf(cursor.getLong(cursor.getColumnIndex("_tm"))));
                            contentValues.put(aq.f25697e, cursor.getString(cursor.getColumnIndex(aq.f25697e)));
                            contentValues.put("_dt", cursor.getBlob(cursor.getColumnIndex("_dt")));
                            sQLiteDatabase.replace("st_1002", null, contentValues);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (!X.a(th)) {
                                    th.printStackTrace();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                i5 = i4 + 1;
                                i6 = i3;
                                str4 = str2;
                                str3 = str;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    cursor.close();
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            }
            i5 = i4 + 1;
            i6 = i3;
            str4 = str2;
            str3 = str;
        }
    }

    public static void checkAppUpgrade(boolean z, boolean z2) {
        a(z, z2, 1);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        a(z, z2, 0);
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
        X.c("setPatchRestartOnScreenOff %s", setPatchRestartOnScreenOff + "");
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerManager.TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        com.tencent.bugly.crashreport.common.info.a.m().a("G10", "1.5.23");
        if (autoInit) {
            init(context, z);
        }
    }
}
