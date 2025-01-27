package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ac {
    private static AtomicInteger aTH = new AtomicInteger(0);
    private static volatile boolean aTI = false;
    private static volatile boolean aTJ;

    /* renamed from: com.kwad.sdk.utils.ac$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aLj;
        final /* synthetic */ String aTK;

        public AnonymousClass1(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            int b10 = bl.b("ksadsdk_kv_perf", str, 0);
            if (TextUtils.isEmpty(str2)) {
                bl.aw("ksadsdk_kv_perf", str);
            } else {
                bl.a("ksadsdk_kv_perf", str, b10 + 1);
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.ac$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ String aLj;
        final /* synthetic */ String aTK;

        public AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            SharedPreferences hc2 = bl.hc("ksadsdk_kv_perf");
            if (hc2 != null && hc2.contains(str)) {
                if (TextUtils.isEmpty(str2)) {
                    bl.a("ksadsdk_kv_perf_failed", str, bl.b("ksadsdk_kv_perf_failed", str, 0) + 1);
                } else {
                    bl.a("ksadsdk_kv_perf_success", str, bl.b("ksadsdk_kv_perf_success", str, 0) + 1);
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.ac$3 */
    public class AnonymousClass3 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.utils.b.a Nk = ac.Nk();
            if (Nk == null) {
                return;
            }
            ac.c(Nk);
            com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
            if (bVar != null) {
                bVar.a(Nk);
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.ac$4 */
    public class AnonymousClass4 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            Context context;
            try {
                context = ad.getContext();
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e10));
            }
            if (context == null) {
                return;
            }
            Iterator<String> it = i.a.anU.iterator();
            while (it.hasNext()) {
                ac.R(context, it.next());
            }
            ac.ed(0);
            ac.aTH.set(0);
        }
    }

    /* renamed from: com.kwad.sdk.utils.ac$5 */
    public class AnonymousClass5 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            try {
                Context context = ad.getContext();
                if (context != null) {
                    Iterator<String> it = i.a.anU.iterator();
                    while (it.hasNext()) {
                        ac.Q(context, it.next());
                    }
                    ac.ed(1);
                    ac.aTH.set(1);
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e10));
            }
        }
    }

    private static int Nh() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int zZ = hVar.zZ();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "config mode:" + zZ);
        return zZ;
    }

    private static void Ni() {
        if (aTI) {
            return;
        }
        aTH.set(Nl());
        aTJ = bl.m("kssdk_kv_mode", "downgrade", false);
        aTI = true;
    }

    public static void Nj() {
        if (Nm() || Nh() == 0) {
            return;
        }
        h.execute(new bd() { // from class: com.kwad.sdk.utils.ac.3
            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.utils.b.a Nk = ac.Nk();
                if (Nk == null) {
                    return;
                }
                ac.c(Nk);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(Nk);
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a Nk() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences hc2 = bl.hc("ksadsdk_kv_perf");
        if (hc2 == null) {
            return null;
        }
        try {
            all = hc2.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Integer) it.next().getValue()).intValue();
        }
        aVar.aWT = i10;
        SharedPreferences.Editor edit = hc2.edit();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            edit.putInt(it2.next().getKey(), 0);
        }
        edit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    private static int Nl() {
        int b10 = bl.b("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "local mode:" + b10);
        return b10;
    }

    public static boolean Nm() {
        Ni();
        return aTH.get() == 0;
    }

    private static boolean Nn() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int No() {
        Ni();
        int Nh = (aTJ || !Nn()) ? 0 : Nh();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "targetMode:" + Nh);
        return Nh;
    }

    public static void Np() {
        Ni();
        int i10 = aTH.get();
        int No = No();
        boolean z10 = i10 != No;
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "needTransfer:" + z10);
        if (z10) {
            transfer(No);
        }
    }

    private static void Nq() {
        h.execute(new bd() { // from class: com.kwad.sdk.utils.ac.4
            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                Context context;
                try {
                    context = ad.getContext();
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e10));
                }
                if (context == null) {
                    return;
                }
                Iterator<String> it = i.a.anU.iterator();
                while (it.hasNext()) {
                    ac.R(context, it.next());
                }
                ac.ed(0);
                ac.aTH.set(0);
            }
        });
    }

    private static void Nr() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        h.execute(new bd() { // from class: com.kwad.sdk.utils.ac.5
            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    Context context = ad.getContext();
                    if (context != null) {
                        Iterator<String> it = i.a.anU.iterator();
                        while (it.hasNext()) {
                            ac.Q(context, it.next());
                        }
                        ac.ed(1);
                        ac.aTH.set(1);
                    }
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e10));
                }
            }
        });
    }

    public static void Q(Context context, String str) {
        SharedPreferences hc2;
        com.kwad.sdk.utils.a.c aw = com.kwad.sdk.utils.a.e.aw(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (hc2 = bl.hc(str)) == null) {
            SharedPreferences.Editor edit = hc2.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (aw.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences hc3 = bl.hc(str);
        if (hc3 == null) {
            aw.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        aw.putAll(hc3.getAll());
        aw.putBoolean("sp_to_kv_transfer_flag", true);
        bl.aw(str, "kv_to_sp_transfer_flag");
        a(str, aw);
    }

    public static void R(Context context, String str) {
        SharedPreferences hc2 = bl.hc(str);
        if (hc2 == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = hc2.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (hc2.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.a.c aw = com.kwad.sdk.utils.a.e.aw(context, str);
        Map<String, Object> all = aw.getAll();
        if (all.isEmpty()) {
            bl.l(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        bl.a(str, all);
        bl.l(str, "kv_to_sp_transfer_flag", true);
        aw.remove("sp_to_kv_transfer_flag");
        aw.release();
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (i.a.anV.contains(str)) {
            return;
        }
        cVar.release();
    }

    @WorkerThread
    public static void ar(String str, String str2) {
        h.execute(new bd() { // from class: com.kwad.sdk.utils.ac.1
            final /* synthetic */ String aLj;
            final /* synthetic */ String aTK;

            public AnonymousClass1(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int b10 = bl.b("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    bl.aw("ksadsdk_kv_perf", str);
                } else {
                    bl.a("ksadsdk_kv_perf", str, b10 + 1);
                }
            }
        });
    }

    public static void as(String str, String str2) {
        h.execute(new bd() { // from class: com.kwad.sdk.utils.ac.2
            final /* synthetic */ String aLj;
            final /* synthetic */ String aTK;

            public AnonymousClass2(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                SharedPreferences hc2 = bl.hc("ksadsdk_kv_perf");
                if (hc2 != null && hc2.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bl.a("ksadsdk_kv_perf_failed", str, bl.b("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bl.a("ksadsdk_kv_perf_success", str, bl.b("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        if (aVar.aWU / (r0 + aVar.aWV) > 0.10000000149011612d) {
            aTJ = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bl.l("kssdk_kv_mode", "downgrade", true);
        }
        if (aTJ) {
            Np();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences hc2 = bl.hc("ksadsdk_kv_perf_failed");
        int i10 = 0;
        if (hc2 == null) {
            aVar.aWU = 0;
            return;
        }
        Map<String, ?> all = hc2.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                i10 += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.aWU = i10;
        SharedPreferences.Editor edit = hc2.edit();
        edit.clear();
        edit.apply();
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences hc2 = bl.hc("ksadsdk_kv_perf_success");
        int i10 = 0;
        if (hc2 == null) {
            aVar.aWV = 0;
            return;
        }
        Map<String, ?> all = hc2.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                i10 += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.aWV = i10;
        SharedPreferences.Editor edit = hc2.edit();
        edit.clear();
        edit.apply();
    }

    public static void ed(int i10) {
        bl.a("kssdk_kv_mode", "mode", i10);
    }

    private static void transfer(int i10) {
        if (i10 == 0) {
            Nq();
        } else if (i10 == 1) {
            Nr();
        }
    }
}
