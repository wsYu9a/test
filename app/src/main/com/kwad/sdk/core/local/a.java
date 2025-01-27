package com.kwad.sdk.core.local;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static volatile a azj;
    public static ThreadLocal<SimpleDateFormat> azk = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        @Nullable
        private static SimpleDateFormat Fp() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        public final /* synthetic */ SimpleDateFormat initialValue() {
            return Fp();
        }
    };

    /* renamed from: com.kwad.sdk.core.local.a$1 */
    public class AnonymousClass1 extends ThreadLocal<SimpleDateFormat> {
        @Nullable
        private static SimpleDateFormat Fp() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        public final /* synthetic */ SimpleDateFormat initialValue() {
            return Fp();
        }
    }

    public static a Fk() {
        if (azj == null) {
            synchronized (a.class) {
                try {
                    if (azj == null) {
                        azj = new a();
                    }
                } finally {
                }
            }
        }
        return azj;
    }

    public static boolean Fl() {
        List<f> df2 = df(15);
        if (df2.size() == 0) {
            return true;
        }
        long j10 = -1;
        int i10 = 0;
        for (f fVar : df2) {
            i10 += fVar.count;
            long j11 = fVar.aEb;
            if (j11 > j10) {
                j10 = j11;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i10 + ", lastShowTime: " + j10);
        if (i10 > Fn()) {
            return false;
        }
        return j10 + (Fo() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> Fm() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int Fn() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Fo() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static void Q(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static boolean a(@NonNull f fVar) {
        long j10 = fVar.aEb;
        if (j10 <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = azk.get();
        return simpleDateFormat.format(new Date(j10)).equals(simpleDateFormat.format(new Date()));
    }

    public static void cc(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            cd(adTemplate);
        }
    }

    private static void cd(AdTemplate adTemplate) {
        int ej2 = e.ej(adTemplate);
        int dV = e.dV(adTemplate);
        List Fm = Fm();
        if (Fm != null && Fm.size() != 0) {
            Iterator it = Fm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Fm.add(new f(dV, ej2, 1, System.currentTimeMillis()));
                    break;
                }
                f fVar = (f) it.next();
                if (fVar.adStyle == dV && fVar.taskType == ej2) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.aA(System.currentTimeMillis());
                    }
                }
            }
        } else {
            Fm = new ArrayList();
            Fm.add(new f(dV, ej2, 1, System.currentTimeMillis()));
        }
        Q("ksadsdk_local_ad_task_info_adstyle_data", x.N(Fm).toString());
        adTemplate.watched = true;
    }

    @NonNull
    private static List<f> df(int i10) {
        ArrayList arrayList = new ArrayList();
        List<f> Fm = Fm();
        if (Fm != null && Fm.size() != 0) {
            for (f fVar : Fm) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void e(int i10, long j10) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i10).putLong("reward_aggregation_min_interval", j10).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th2) {
            c.printStackTrace(th2);
            return null;
        }
    }
}
