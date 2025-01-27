package com.vivo.mobilead.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class w0 {

    /* renamed from: a */
    private static final AtomicInteger f30789a = new AtomicInteger(1);

    public static String a(Context context) {
        int myPid;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        try {
            myPid = Process.myPid();
            runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        } catch (Exception unused) {
        }
        if (runningAppProcesses == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static int b() {
        return Build.VERSION.SDK_INT < 17 ? a() : View.generateViewId();
    }

    public static int c() {
        try {
            if (com.vivo.mobilead.manager.f.j().c() == null) {
                return 1;
            }
            return com.vivo.mobilead.manager.f.j().c().getResources().getConfiguration().orientation == 2 ? 2 : 1;
        } catch (Exception e2) {
            x0.b("Utils", e2.getMessage(), e2);
            return 1;
        }
    }

    public static boolean d() {
        return false;
    }

    public static <T extends com.vivo.mobilead.unified.base.e> void b(Integer num, SparseArray<T> sparseArray) {
        T valueAt;
        if (sparseArray == null || sparseArray.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            if ((num == null || sparseArray.keyAt(i2) != num.intValue()) && (valueAt = sparseArray.valueAt(i2)) != null) {
                valueAt.a();
                valueAt.a(null);
            }
        }
        sparseArray.clear();
    }

    private static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = f30789a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static <T extends com.vivo.mobilead.unified.a> void a(Integer num, SparseArray<T> sparseArray) {
        T valueAt;
        if (sparseArray == null || sparseArray.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            if ((num == null || sparseArray.keyAt(i2) != num.intValue()) && (valueAt = sparseArray.valueAt(i2)) != null) {
                valueAt.d();
                if (valueAt instanceof com.vivo.mobilead.unified.interstitial.g) {
                    ((com.vivo.mobilead.unified.interstitial.g) valueAt).a((com.vivo.mobilead.g.b) null);
                }
                if (valueAt instanceof com.vivo.mobilead.unified.reward.h) {
                    ((com.vivo.mobilead.unified.reward.h) valueAt).a((com.vivo.mobilead.g.b) null);
                }
                if (valueAt instanceof com.vivo.mobilead.unified.banner.f) {
                    ((com.vivo.mobilead.unified.banner.f) valueAt).a((com.vivo.mobilead.g.b) null);
                }
            }
        }
        sparseArray.clear();
    }

    public static String b(String str) {
        try {
            String str2 = "{\"scene\":\"1000\",\"gameId\":" + str + "}";
            x0.a("Utils", "json:" + str2);
            return new String(Base64.encode(str2.getBytes(), 2), "UTF-8");
        } catch (Exception e2) {
            x0.b("Utils", "getEncryptSourceAppend error : ", e2);
            return "";
        }
    }

    public static void a(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.e c2;
        if (bVar == null) {
            return;
        }
        if ((bVar.l() == 3 || bVar.l() == 9 || bVar.l() == 4) && (c2 = bVar.c()) != null) {
            List<com.vivo.ad.model.i> d2 = c2.d();
            ArrayList arrayList = null;
            if (d2 != null && d2.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < d2.size(); i2++) {
                    com.vivo.ad.model.i iVar = d2.get(i2);
                    if (iVar != null && (q.a(bVar) || i2 != 1)) {
                        com.vivo.ad.model.a aVar = new com.vivo.ad.model.a();
                        aVar.c(iVar.c());
                        aVar.d(iVar.d());
                        aVar.a(iVar.a());
                        aVar.b(iVar.b());
                        if (i2 == d2.size() - 1) {
                            if (bVar.r() != null) {
                                aVar.a(new ArrayList<>(bVar.r()));
                            }
                        } else {
                            aVar.a((ArrayList<com.vivo.ad.model.a>) null);
                        }
                        arrayList2.add(aVar);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null && arrayList.size() > 0) {
                if (bVar.r() == null) {
                    bVar.a(new ArrayList<>());
                    arrayList.remove(arrayList.size() - 1);
                }
                bVar.r().clear();
                bVar.r().addAll(arrayList);
                return;
            }
            bVar.r().clear();
        }
    }

    public static boolean a(char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        sb.append("");
        return sb.toString().getBytes().length == 1;
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!a(str.charAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            x0.b("Utils", "", e2);
            return 0;
        }
    }
}
