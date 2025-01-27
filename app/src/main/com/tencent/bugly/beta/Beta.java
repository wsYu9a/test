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
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.tencent.bugly.proguard.C0871p;
import com.tencent.bugly.proguard.C0874t;
import com.tencent.bugly.proguard.C0876v;
import com.tencent.bugly.proguard.C0878x;
import com.tencent.bugly.proguard.C0879y;
import com.tencent.bugly.proguard.C0880z;
import com.tencent.bugly.proguard.H;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.r;
import com.umeng.analytics.pro.bx;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
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
    private static DownloadTask f22069a = null;

    private static void a(boolean z10, boolean z11, int i10) {
        try {
            if (z10) {
                d.f22149a.a(z10, z11, i10);
                UpgradeStateListener upgradeStateListener2 = upgradeStateListener;
                if (upgradeStateListener2 != null) {
                    e.a(new com.tencent.bugly.beta.global.d(18, upgradeStateListener2, 2, Boolean.valueOf(z10)));
                } else {
                    e.a(new com.tencent.bugly.beta.global.d(5, strToastCheckingUpgrade));
                }
            } else if (i10 == 0 || i10 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy != null && betaGrayStrategy.f22135a != null && System.currentTimeMillis() - betaGrayStrategy.f22139e <= com.tencent.bugly.beta.global.e.f22100b.f22105d) {
                    d.f22149a.a(z10, z11, 0, null, "");
                }
                d.f22149a.a(z10, z11, i10);
            } else if (i10 != 3) {
            } else {
                r.f22838a.a(z10, z11, 3);
            }
        } catch (Exception e10) {
            if (X.a(e10)) {
                return;
            }
            e10.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() {
        if (new File(com.tencent.bugly.beta.global.e.f22100b.J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(com.tencent.bugly.beta.global.e.f22100b.J.getAbsolutePath(), true);
        } else {
            X.b(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (((java.lang.Boolean) r4[2]).booleanValue() == com.tencent.bugly.beta.upgrade.d.f22149a.f22155g) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cancelDownload() {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            com.tencent.bugly.beta.upgrade.d r3 = com.tencent.bugly.beta.upgrade.d.f22149a
            com.tencent.bugly.beta.global.d r4 = r3.f22158j
            if (r4 == 0) goto L25
            java.lang.Object[] r4 = r4.f22098b
            r5 = r4[r2]
            com.tencent.bugly.beta.download.DownloadTask r6 = r3.f22151c
            if (r5 != r6) goto L25
            r5 = r4[r1]
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r3 = r3.f22150b
            if (r5 != r3) goto L25
            r3 = r4[r0]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            com.tencent.bugly.beta.upgrade.d r4 = com.tencent.bugly.beta.upgrade.d.f22149a
            boolean r4 = r4.f22155g
            if (r3 == r4) goto L43
        L25:
            com.tencent.bugly.beta.upgrade.d r3 = com.tencent.bugly.beta.upgrade.d.f22149a
            com.tencent.bugly.beta.global.d r4 = new com.tencent.bugly.beta.global.d
            com.tencent.bugly.beta.download.DownloadTask r5 = r3.f22151c
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r6 = r3.f22150b
            boolean r7 = r3.f22155g
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r2] = r5
            r8[r1] = r6
            r8[r0] = r7
            r0 = 14
            r4.<init>(r0, r8)
            r3.f22158j = r4
        L43:
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.f22149a
            com.tencent.bugly.beta.global.d r0 = r0.f22158j
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

    public static void cleanTinkerPatch(boolean z10) {
        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z10);
    }

    public static void downloadPatch() {
        r rVar = r.f22838a;
        rVar.f22839b = rVar.a((B) null);
        try {
            r rVar2 = r.f22838a;
            BetaGrayStrategy betaGrayStrategy = rVar2.f22839b;
            if (betaGrayStrategy != null) {
                rVar2.a(0, betaGrayStrategy.f22135a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            d.f22149a.f22150b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy = d.f22149a.f22150b;
            if (betaGrayStrategy != null) {
                return new UpgradeInfo(betaGrayStrategy.f22135a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            r.f22838a.f22839b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy = r.f22838a.f22839b;
            if (betaGrayStrategy != null) {
                return new UpgradeInfo(betaGrayStrategy.f22135a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.f22063id = 1002;
        beta.version = "1.5.23";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (f22069a == null) {
            d.f22149a.f22150b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (d.f22149a.f22150b != null) {
                DownloadTask a10 = com.tencent.bugly.beta.global.e.f22100b.f22123s.a(d.f22149a.f22150b.f22135a.f22563k.f22890c, com.tencent.bugly.beta.global.e.f22100b.f22127w.getAbsolutePath(), null, d.f22149a.f22150b.f22135a.f22563k.f22889b);
                f22069a = a10;
                a10.setDownloadType(1);
                d.f22149a.f22151c = f22069a;
            }
        }
        return d.f22149a.f22151c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        return new com.tencent.bugly.beta.UpgradeInfo(r0.f22135a);
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
            com.tencent.bugly.proguard.B r3 = r0.f22135a     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L28
            if (r2 == 0) goto L28
            com.tencent.bugly.proguard.B r3 = r2.f22135a     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L28
            long r3 = r0.f22139e     // Catch: java.lang.Exception -> L43
            long r5 = r2.f22139e     // Catch: java.lang.Exception -> L43
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L38
            goto L39
        L28:
            if (r0 == 0) goto L38
            com.tencent.bugly.proguard.B r3 = r0.f22135a     // Catch: java.lang.Exception -> L43
            if (r3 != 0) goto L2f
            goto L38
        L2f:
            if (r2 == 0) goto L39
            com.tencent.bugly.proguard.B r2 = r2.f22135a     // Catch: java.lang.Exception -> L43
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
            com.tencent.bugly.proguard.B r0 = r0.f22135a     // Catch: java.lang.Exception -> L43
            r2.<init>(r0)     // Catch: java.lang.Exception -> L43
            return r2
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized B getUpgradeStrategy() {
        synchronized (Beta.class) {
            d.f22149a.f22150b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            try {
                BetaGrayStrategy betaGrayStrategy = d.f22149a.f22150b;
                if (betaGrayStrategy != null) {
                    return (B) betaGrayStrategy.f22135a.clone();
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static synchronized void init(Context context, boolean z10) {
        synchronized (Beta.class) {
            try {
                X.c("Beta init start....", new Object[0]);
                H a10 = H.a();
                int i10 = instance.f22063id;
                int i11 = com.tencent.bugly.beta.global.e.f22099a + 1;
                com.tencent.bugly.beta.global.e.f22099a = i11;
                a10.a(i10, i11);
                if (TextUtils.isEmpty(initProcessName)) {
                    initProcessName = context.getPackageName();
                }
                X.c("Beta will init at: %s", initProcessName);
                String str = com.tencent.bugly.crashreport.common.info.a.m().f22296h;
                X.c("current process: %s", str);
                if (TextUtils.equals(initProcessName, str)) {
                    com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
                    if (!TextUtils.isEmpty(eVar.f22129y)) {
                        X.e("Beta has been initialized [apkMD5 : %s]", eVar.f22129y);
                        return;
                    }
                    X.c("current upgrade sdk version:1.5.23", new Object[0]);
                    eVar.G = z10;
                    long j10 = upgradeCheckPeriod;
                    if (j10 < 0) {
                        X.e("upgradeCheckPeriod cannot be negative", new Object[0]);
                    } else {
                        eVar.f22105d = j10;
                        X.c("setted upgradeCheckPeriod: %d", Long.valueOf(j10));
                    }
                    long j11 = initDelay;
                    if (j11 < 0) {
                        X.e("initDelay cannot be negative", new Object[0]);
                    } else {
                        eVar.f22103c = j11;
                        X.c("setted initDelay: %d", Long.valueOf(j11));
                    }
                    if (smallIconId != 0) {
                        try {
                            if (context.getResources().getDrawable(smallIconId) != null) {
                                int i12 = smallIconId;
                                eVar.f22113i = i12;
                                X.c("setted smallIconId: %d", Integer.valueOf(i12));
                            }
                        } catch (Exception e10) {
                            X.b("smallIconId is not available:\n %s", e10.toString());
                        }
                    }
                    if (largeIconId != 0) {
                        try {
                            if (context.getResources().getDrawable(largeIconId) != null) {
                                int i13 = largeIconId;
                                eVar.f22114j = i13;
                                X.c("setted largeIconId: %d", Integer.valueOf(i13));
                            }
                        } catch (Exception e11) {
                            X.b("largeIconId is not available:\n %s", e11.toString());
                        }
                    }
                    if (defaultBannerId != 0) {
                        try {
                            if (context.getResources().getDrawable(defaultBannerId) != null) {
                                int i14 = defaultBannerId;
                                eVar.f22115k = i14;
                                X.c("setted defaultBannerId: %d", Integer.valueOf(i14));
                            }
                        } catch (Exception e12) {
                            X.b("defaultBannerId is not available:\n %s", e12.toString());
                        }
                    }
                    if (upgradeDialogLayoutId != 0) {
                        try {
                            XmlResourceParser layout = context.getResources().getLayout(upgradeDialogLayoutId);
                            if (layout != null) {
                                int i15 = upgradeDialogLayoutId;
                                eVar.f22116l = i15;
                                X.c("setted upgradeDialogLayoutId: %d", Integer.valueOf(i15));
                                layout.close();
                            }
                        } catch (Exception e13) {
                            X.b("upgradeDialogLayoutId is not available:\n %s", e13.toString());
                        }
                    }
                    if (tipsDialogLayoutId != 0) {
                        try {
                            XmlResourceParser layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                            if (layout2 != null) {
                                int i16 = tipsDialogLayoutId;
                                eVar.f22117m = i16;
                                X.c("setted tipsDialogLayoutId: %d", Integer.valueOf(i16));
                                layout2.close();
                            }
                        } catch (Exception e14) {
                            X.b("tipsDialogLayoutId is not available:\n %s", e14.toString());
                        }
                    }
                    UILifecycleListener<UpgradeInfo> uILifecycleListener = upgradeDialogLifecycleListener;
                    if (uILifecycleListener != null) {
                        try {
                            eVar.f22118n = uILifecycleListener;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("setted upgradeDialogLifecycleListener:%s");
                            sb2.append(upgradeDialogLifecycleListener);
                            X.c(sb2.toString(), new Object[0]);
                        } catch (Exception e15) {
                            X.b("upgradeDialogLifecycleListener is not available:\n %", e15.toString());
                        }
                    }
                    List<Class<? extends Activity>> list = canShowUpgradeActs;
                    if (list != null && !list.isEmpty()) {
                        for (Class<? extends Activity> cls : canShowUpgradeActs) {
                            if (cls != null) {
                                eVar.f22120p.add(cls);
                            }
                        }
                        X.c("setted canShowUpgradeActs: %s", eVar.f22120p);
                    }
                    List<Class<? extends Activity>> list2 = canNotShowUpgradeActs;
                    if (list2 != null && !list2.isEmpty()) {
                        for (Class<? extends Activity> cls2 : canNotShowUpgradeActs) {
                            if (cls2 != null) {
                                eVar.f22121q.add(cls2);
                            }
                        }
                        X.c("setted canNotShowUpgradeActs: %s", eVar.f22121q);
                    }
                    boolean z11 = autoCheckUpgrade;
                    eVar.f22107e = z11;
                    eVar.f22109f = autoCheckAppUpgrade;
                    eVar.f22111g = autoCheckHotfix;
                    X.c("autoCheckUpgrade %s", z11 ? "is opened" : "is closed");
                    X.c("autoCheckAppUpgrade %s", eVar.f22109f ? "is opened" : "is closed");
                    X.c("autoCheckHotfix %s", eVar.f22111g ? "is opened" : "is closed");
                    boolean z12 = autoInstallApk;
                    eVar.f22110fa = z12;
                    X.c("autoInstallApk %s", z12 ? "is opened" : "is closed");
                    boolean z13 = autoDownloadOn4g;
                    eVar.V = z13;
                    X.c("autoDownloadOn4g %s", z13 ? "is opened" : "is closed");
                    boolean z14 = showInterruptedStrategy;
                    eVar.f22112h = z14;
                    X.c("showInterruptedStrategy %s", z14 ? "is opened" : "is closed");
                    X.c("isDIY %s", upgradeListener != null ? "is opened" : "is closed");
                    File file = storageDir;
                    if (file != null) {
                        if (file.exists() || storageDir.mkdirs()) {
                            File file2 = storageDir;
                            eVar.f22119o = file2;
                            X.c("setted storageDir: %s", file2.getAbsolutePath());
                        } else {
                            X.c("storageDir is not exists: %s", storageDir.getAbsolutePath());
                        }
                    }
                    if (eVar.f22123s == null) {
                        eVar.f22123s = C0876v.f22882a;
                    }
                    if (TextUtils.isEmpty(eVar.f22128x)) {
                        eVar.f22128x = com.tencent.bugly.crashreport.common.info.a.m().e();
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
                    eVar.f22130z = appVersionCode;
                    eVar.Z = canNotifyUserRestart;
                    X.c("canNotifyUserRestart %s", canNotifyUserRestart + "");
                    eVar.f22101aa = canAutoDownloadPatch;
                    X.c("canAutoDownloadPatch %s", canAutoDownloadPatch + "");
                    eVar.f22102ba = enableHotfix;
                    X.c("enableHotfix %s", enableHotfix + "");
                    List<String> list3 = soBlackList;
                    if (list3 != null && !list3.isEmpty()) {
                        for (String str2 : soBlackList) {
                            if (str2 != null) {
                                eVar.f22104ca.add(str2);
                            }
                        }
                        X.c("setted soBlackList: %s", eVar.f22104ca);
                    }
                    String str3 = appChannel;
                    if (str3 != null) {
                        eVar.R = str3;
                        X.c("Beta channel %s", str3);
                    }
                    eVar.a(context);
                    ResBean resBean = (ResBean) com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.CREATOR);
                    ResBean.f22088a = resBean;
                    if (resBean == null) {
                        ResBean.f22088a = new ResBean();
                    }
                    d dVar = d.f22149a;
                    dVar.f22153e = upgradeListener;
                    dVar.f22154f = upgradeStateListener;
                    dVar.f22152d = downloadListener;
                    if (getStrategyTask() != null && downloadListener != null) {
                        getStrategyTask().addListener(d.f22149a.f22152d);
                    }
                    if (enableHotfix) {
                        X.c("enableHotfix %s", "1");
                        ca.c("D4", "1");
                        C0874t.a(context);
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
                    W.c().a(new com.tencent.bugly.beta.global.d(1, new Object[0]), eVar.f22103c);
                    H a11 = H.a();
                    int i17 = instance.f22063id;
                    int i18 = com.tencent.bugly.beta.global.e.f22099a - 1;
                    com.tencent.bugly.beta.global.e.f22099a = i18;
                    a11.a(i17, i18);
                    X.c("Beta init finished...", new Object[0]);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized void installApk(File file) {
        synchronized (Beta.class) {
            try {
                B upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.f22100b.f22126v, file, upgradeStrategy.f22563k.f22889b)) {
                    C0871p.f22799a.a(new C0880z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f22562j, upgradeStrategy.f22570r, upgradeStrategy.f22573u, null));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
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
        boolean z10;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
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
                    String a10 = com.tencent.bugly.beta.global.a.a(str, "");
                    boolean a11 = com.tencent.bugly.beta.global.a.a("PatchResult", false);
                    if (TextUtils.isEmpty(a10) || !a11) {
                        z10 = false;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("lib/");
                        sb2.append(a10);
                        z10 = TinkerManager.loadLibraryFromTinker(eVar.f22126v, sb2.toString(), str);
                    }
                    if (!z10) {
                        System.loadLibrary(str);
                    }
                    com.tencent.bugly.beta.global.a.b("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                com.tencent.bugly.beta.global.a.b("LoadSoFileResult", false);
                return;
            }
        }
        X.b("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i10, String str2, long j10, int i11, int i12, String str3, String str4, long j11, String str5, String str6, int i13, int i14, long j12, String str7, boolean z10, boolean z11, int i15, String str8, long j13) {
        synchronized (Beta.class) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("IMG_title", str6);
                hashMap.put("VAL_style", String.valueOf(i13));
                d.f22149a.a(z10, z11, i15, new B(str, str2, j10, 0, new C0879y(com.tencent.bugly.beta.global.e.f22100b.f22128x, (byte) 1, i12, str3, i11, "", 1L, "", str5, "", ""), new C0878x(str5, str4, "", j11, ""), (byte) i10, i14, j12, null, "", hashMap, str7, 1, j13, 1), str8 == null ? "" : str8);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        com.tencent.bugly.beta.global.e.f22100b.f22124t = downloadListener2;
        if (downloadListener2 == null || (downloadTask = d.f22149a.f22151c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z10) {
        synchronized (Beta.class) {
            try {
                B upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && z10) {
                    C0871p.f22799a.a(new C0880z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f22562j, upgradeStrategy.f22570r, upgradeStrategy.f22573u, null));
                    X.c("安装事件保存成功", new Object[0]);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i10, String str2, long j10, int i11, int i12, String str3, String str4, long j11, String str5, String str6, int i13, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z10) {
        synchronized (Beta.class) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("IMG_title", str6);
                hashMap.put("VAL_style", String.valueOf(i13));
                B b10 = new B(str, str2, j10, 0, new C0879y(com.tencent.bugly.beta.global.e.f22100b.f22128x, (byte) 1, i12, str3, i11, "", 1L, "", str5, "1.5.23", ""), new C0878x(str5, str4, "", j11, ""), (byte) i10, 0, 0L, null, "", hashMap, null, 1, System.currentTimeMillis(), 1);
                DownloadTask downloadTask = f22069a;
                if (downloadTask != null && !downloadTask.getDownloadUrl().equals(str4)) {
                    f22069a.delete(true);
                    f22069a = null;
                }
                if (f22069a == null) {
                    com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
                    DownloadTask a10 = eVar.f22123s.a(b10.f22563k.f22890c, eVar.f22127w.getAbsolutePath(), null, b10.f22563k.f22889b);
                    f22069a = a10;
                    a10.setDownloadType(1);
                }
                f22069a.addListener(downloadListener2);
                UpgradeDialog.instance.setUpgradeInfo(b10, f22069a);
                UpgradeDialog upgradeDialog = UpgradeDialog.instance;
                upgradeDialog.upgradeRunnable = runnable;
                upgradeDialog.cancelRunnable = runnable2;
                f.f22131a.a(com.tencent.bugly.beta.global.e.f22100b.f22123s, b10.f22569q);
                if (z10) {
                    f.f22131a.a(new com.tencent.bugly.beta.global.d(2, UpgradeDialog.instance, Boolean.valueOf(b10.f22564l == 2)), 3000);
                } else {
                    f.f22131a.a(new com.tencent.bugly.beta.global.d(2, UpgradeDialog.instance, Boolean.valueOf(b10.f22564l == 2)));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static DownloadTask startDownload() {
        d dVar = d.f22149a;
        com.tencent.bugly.beta.global.d dVar2 = dVar.f22157i;
        if (dVar2 == null || dVar2.f22098b[0] != dVar.f22151c) {
            dVar.f22157i = new com.tencent.bugly.beta.global.d(13, dVar.f22151c, dVar.f22150b);
        }
        d.f22149a.f22157i.run();
        return d.f22149a.f22151c;
    }

    public static void unInit() {
        if (com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false)) {
            com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = d.f22149a.f22151c;
        if (downloadTask != null) {
            downloadTask.removeListener(com.tencent.bugly.beta.global.e.f22100b.f22124t);
        }
        com.tencent.bugly.beta.global.e.f22100b.f22124t = null;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // com.tencent.bugly.a
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        int i12;
        String str;
        String str2;
        String str3;
        Cursor cursor;
        int i13 = 1;
        int i14 = 0;
        String str4 = bx.f23687e;
        String str5 = " ";
        String str6 = "_id";
        int i15 = i10;
        int i16 = i11;
        while (i15 < i16) {
            if (i15 != 10) {
                i12 = i15;
                str = str6;
                str2 = str5;
                str3 = str4;
            } else {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.setLength(i14);
                    sb2.append(" CREATE TABLE  IF NOT EXISTS ");
                    sb2.append("st_1002");
                    sb2.append(" ( ");
                    sb2.append(str6);
                    sb2.append(str5);
                    sb2.append(TypedValues.Custom.S_INT);
                    sb2.append(" , ");
                    sb2.append(str4);
                    sb2.append(str5);
                    sb2.append("text");
                    sb2.append(" , ");
                    sb2.append("_tm");
                    sb2.append(str5);
                    sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                    sb2.append(" , ");
                    sb2.append("_dt");
                    sb2.append(str5);
                    sb2.append("blob");
                    sb2.append(",primary key(");
                    sb2.append(str6);
                    sb2.append(",");
                    sb2.append(str4);
                    sb2.append(" )) ");
                    Object[] objArr = new Object[i13];
                    objArr[i14] = sb2.toString();
                    X.a("create %s", objArr);
                    sQLiteDatabase.execSQL(sb2.toString());
                } catch (Throwable th2) {
                    if (!X.a(th2)) {
                        th2.printStackTrace();
                    }
                }
                i12 = i15;
                str = str6;
                str2 = str5;
                str3 = str4;
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
                            if (cursor.getLong(cursor.getColumnIndex(str)) > 0) {
                                contentValues.put(str, Long.valueOf(cursor.getLong(cursor.getColumnIndex(str))));
                            }
                            contentValues.put("_tm", Long.valueOf(cursor.getLong(cursor.getColumnIndex("_tm"))));
                            contentValues.put(str3, cursor.getString(cursor.getColumnIndex(str3)));
                            contentValues.put("_dt", cursor.getBlob(cursor.getColumnIndex("_dt")));
                            sQLiteDatabase.replace("st_1002", null, contentValues);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                if (!X.a(th)) {
                                    th.printStackTrace();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                i15 = i12 + 1;
                                i16 = i11;
                                str6 = str;
                                str4 = str3;
                                str5 = str2;
                                i13 = 1;
                                i14 = 0;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    cursor.close();
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
            }
            i15 = i12 + 1;
            i16 = i11;
            str6 = str;
            str4 = str3;
            str5 = str2;
            i13 = 1;
            i14 = 0;
        }
    }

    public static void checkAppUpgrade(boolean z10, boolean z11) {
        a(z10, z11, 1);
    }

    public static void checkUpgrade(boolean z10, boolean z11) {
        a(z10, z11, 0);
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
    public synchronized void init(Context context, boolean z10, BuglyStrategy buglyStrategy) {
        com.tencent.bugly.crashreport.common.info.a.m().a("G10", "1.5.23");
        if (autoInit) {
            init(context, z10);
        }
    }
}
