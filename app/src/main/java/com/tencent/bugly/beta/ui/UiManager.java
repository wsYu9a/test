package com.tencent.bugly.beta.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class UiManager {
    private static d upgradeForceChecker;
    public static final Map<Integer, BaseFrag> TEMP_FRAG = new ConcurrentHashMap();
    public static final Map<Integer, d> TEMP_CAN_SHOW_UPGRADE_CHECKER = new ConcurrentHashMap();
    public static final Map<Integer, d> TEMP_TOP_SHOW_CHECKER = new ConcurrentHashMap();

    public static synchronized boolean canShowUpgrade() {
        synchronized (UiManager.class) {
            String topAct = getTopAct();
            if (topAct == null || topAct.equals("background") || topAct.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName(topAct);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            if (!e.f24621b.p.isEmpty()) {
                for (Class<? extends Activity> cls2 : e.f24621b.p) {
                    if (TextUtils.equals(cls2.getName(), topAct) || (cls != null && cls2.isAssignableFrom(cls))) {
                        return true;
                    }
                }
                return false;
            }
            if (e.f24621b.q.isEmpty()) {
                return true;
            }
            for (Class<? extends Activity> cls3 : e.f24621b.q) {
                if (TextUtils.equals(cls3.getName(), topAct) || (cls != null && cls3.isAssignableFrom(cls))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static String getTopAct() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                return a.m().W;
            }
            ActivityManager activityManager = (ActivityManager) e.f24621b.v.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty()) {
                return null;
            }
            return runningTasks.get(0).topActivity.getClassName();
        } catch (SecurityException unused) {
            X.b("无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return null;
        } catch (Exception e2) {
            if (X.a(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static synchronized void show(BaseFrag baseFrag, boolean z) {
        synchronized (UiManager.class) {
            if (Build.VERSION.SDK_INT >= 14) {
                show(baseFrag, z, false, 5000L);
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) e.f24621b.v.getSystemService(TTDownloadField.TT_ACTIVITY);
                    if (activityManager != null) {
                        activityManager.getRunningTasks(1);
                        show(baseFrag, z, false, 5000L);
                    }
                } catch (SecurityException unused) {
                    if (z) {
                        show(baseFrag, z, true, 0L);
                        return;
                    }
                    X.b("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
                    BetaGrayStrategy betaGrayStrategy = com.tencent.bugly.beta.upgrade.d.f24648a.f24649b;
                    if (betaGrayStrategy != null && betaGrayStrategy.f24634a != null) {
                        BetaNotifyManager.instance.postUpgradeNotify(com.tencent.bugly.beta.upgrade.d.f24648a.f24649b.f24634a, baseFrag);
                    }
                }
            }
        }
    }

    public static synchronized void show(BaseFrag baseFrag, boolean z, boolean z2, long j2) {
        synchronized (UiManager.class) {
            if (baseFrag != null) {
                if (!baseFrag.isShowing()) {
                    int hashCode = baseFrag.hashCode();
                    if (baseFrag instanceof UpgradeDialog) {
                        com.tencent.bugly.beta.utils.e.b(upgradeForceChecker);
                        if (((UpgradeDialog) baseFrag).strategyDetail.l == 2) {
                            d dVar = new d(15, baseFrag, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                            upgradeForceChecker = dVar;
                            com.tencent.bugly.beta.utils.e.a(dVar, 3000L);
                        }
                        if (!z && !canShowUpgrade()) {
                            Map<Integer, d> map = TEMP_CAN_SHOW_UPGRADE_CHECKER;
                            d dVar2 = map.get(Integer.valueOf(hashCode));
                            if (dVar2 == null) {
                                dVar2 = new d(11, baseFrag, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                                map.put(Integer.valueOf(hashCode), dVar2);
                            }
                            com.tencent.bugly.beta.utils.e.b(dVar2);
                            com.tencent.bugly.beta.utils.e.a(dVar2, j2);
                            return;
                        }
                        com.tencent.bugly.beta.utils.e.b(TEMP_CAN_SHOW_UPGRADE_CHECKER.remove(Integer.valueOf(hashCode)));
                    }
                    if (!z2 && !ca.b(e.f24621b.v)) {
                        Map<Integer, d> map2 = TEMP_TOP_SHOW_CHECKER;
                        d dVar3 = map2.get(Integer.valueOf(hashCode));
                        if (dVar3 == null) {
                            dVar3 = new d(11, baseFrag, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
                            map2.put(Integer.valueOf(hashCode), dVar3);
                        }
                        com.tencent.bugly.beta.utils.e.b(dVar3);
                        com.tencent.bugly.beta.utils.e.a(dVar3, j2);
                        return;
                    }
                    com.tencent.bugly.beta.utils.e.b(TEMP_TOP_SHOW_CHECKER.remove(Integer.valueOf(hashCode)));
                    d dVar4 = new d(17, TEMP_FRAG, Integer.valueOf(hashCode), baseFrag);
                    FragmentActivity activity = baseFrag.getActivity();
                    if (activity != null) {
                        if (activity instanceof BetaActivity) {
                            ((BetaActivity) activity).onDestroyRunnable = dVar4;
                        } else {
                            com.tencent.bugly.beta.utils.e.a(dVar4, 400L);
                        }
                        activity.finish();
                    } else {
                        dVar4.run();
                    }
                }
            }
        }
    }
}
