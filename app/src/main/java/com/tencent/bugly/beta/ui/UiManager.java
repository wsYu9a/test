package com.tencent.bugly.beta.ui;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class UiManager {
    private static d upgradeForceChecker;
    public static final Map<Integer, BaseFrag> TEMP_FRAG = new ConcurrentHashMap();
    public static final Map<Integer, d> TEMP_CAN_SHOW_UPGRADE_CHECKER = new ConcurrentHashMap();
    public static final Map<Integer, d> TEMP_TOP_SHOW_CHECKER = new ConcurrentHashMap();

    public static synchronized boolean canShowUpgrade() {
        Class<?> cls;
        synchronized (UiManager.class) {
            String topAct = getTopAct();
            if (topAct == null || topAct.equals("background") || topAct.equals("unknown")) {
                return false;
            }
            try {
                cls = Class.forName(topAct);
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
                cls = null;
            }
            if (!e.f22100b.f22120p.isEmpty()) {
                for (Class<? extends Activity> cls2 : e.f22100b.f22120p) {
                    if (TextUtils.equals(cls2.getName(), topAct) || (cls != null && cls2.isAssignableFrom(cls))) {
                        return true;
                    }
                }
                return false;
            }
            if (e.f22100b.f22121q.isEmpty()) {
                return true;
            }
            for (Class<? extends Activity> cls3 : e.f22100b.f22121q) {
                if (TextUtils.equals(cls3.getName(), topAct) || (cls != null && cls3.isAssignableFrom(cls))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static String getTopAct() {
        try {
            return a.m().W;
        } catch (SecurityException unused) {
            X.b("无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return null;
        } catch (Exception e10) {
            if (X.a(e10)) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    public static synchronized void show(BaseFrag baseFrag, boolean z10) {
        synchronized (UiManager.class) {
            show(baseFrag, z10, false, 5000L);
        }
    }

    public static synchronized void show(BaseFrag baseFrag, boolean z10, boolean z11, long j10) {
        synchronized (UiManager.class) {
            if (baseFrag != null) {
                try {
                    if (!baseFrag.isShowing()) {
                        int hashCode = baseFrag.hashCode();
                        if (baseFrag instanceof UpgradeDialog) {
                            com.tencent.bugly.beta.utils.e.b(upgradeForceChecker);
                            if (((UpgradeDialog) baseFrag).strategyDetail.f22564l == 2) {
                                d dVar = new d(15, baseFrag, Boolean.valueOf(z10), Boolean.valueOf(z11), Long.valueOf(j10));
                                upgradeForceChecker = dVar;
                                com.tencent.bugly.beta.utils.e.a(dVar, 3000L);
                            }
                            if (!z10 && !canShowUpgrade()) {
                                Map<Integer, d> map = TEMP_CAN_SHOW_UPGRADE_CHECKER;
                                d dVar2 = map.get(Integer.valueOf(hashCode));
                                if (dVar2 == null) {
                                    dVar2 = new d(11, baseFrag, Boolean.valueOf(z10), Boolean.valueOf(z11), Long.valueOf(j10));
                                    map.put(Integer.valueOf(hashCode), dVar2);
                                }
                                com.tencent.bugly.beta.utils.e.b(dVar2);
                                com.tencent.bugly.beta.utils.e.a(dVar2, j10);
                                return;
                            }
                            com.tencent.bugly.beta.utils.e.b(TEMP_CAN_SHOW_UPGRADE_CHECKER.remove(Integer.valueOf(hashCode)));
                        }
                        if (!z11 && !ca.b(e.f22100b.f22126v)) {
                            Map<Integer, d> map2 = TEMP_TOP_SHOW_CHECKER;
                            d dVar3 = map2.get(Integer.valueOf(hashCode));
                            if (dVar3 == null) {
                                dVar3 = new d(11, baseFrag, Boolean.valueOf(z10), Boolean.valueOf(z11), Long.valueOf(j10));
                                map2.put(Integer.valueOf(hashCode), dVar3);
                            }
                            com.tencent.bugly.beta.utils.e.b(dVar3);
                            com.tencent.bugly.beta.utils.e.a(dVar3, j10);
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
                } finally {
                }
            }
        }
    }
}
