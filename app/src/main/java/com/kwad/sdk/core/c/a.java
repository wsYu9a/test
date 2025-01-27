package com.kwad.sdk.core.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    public static SimpleDateFormat JQ = new SimpleDateFormat("yyyy-MM-dd");
    private static volatile a afU;

    private static boolean a(@NonNull f fVar) {
        long j2 = fVar.alK;
        if (j2 <= 0) {
            return false;
        }
        return JQ.format(new Date(j2)).equals(JQ.format(new Date()));
    }

    public static void am(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            b.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            an(adTemplate);
        }
    }

    private static void an(AdTemplate adTemplate) {
        f fVar;
        int cj = d.cj(adTemplate);
        int bV = d.bV(adTemplate);
        List vW = vW();
        if (vW != null && vW.size() != 0) {
            boolean z = false;
            Iterator it = vW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.adStyle == bV && fVar2.taskType == cj) {
                    fVar2.count++;
                    if (!a(fVar2)) {
                        fVar2.count = 1;
                        fVar2.T(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                fVar = new f(bV, cj, 1, System.currentTimeMillis());
            }
            t("ksadsdk_local_ad_task_info_adstyle_data", t.C(vW).toString());
            adTemplate.watched = true;
        }
        vW = new ArrayList();
        fVar = new f(bV, cj, 1, System.currentTimeMillis());
        vW.add(fVar);
        t("ksadsdk_local_ad_task_info_adstyle_data", t.C(vW).toString());
        adTemplate.watched = true;
    }

    @NonNull
    private static List<f> bb(int i2) {
        ArrayList arrayList = new ArrayList();
        List<f> vW = vW();
        if (vW != null && vW.size() != 0) {
            for (f fVar : vW) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void c(int i2, long j2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i2).putLong("reward_aggregation_min_interval", j2).apply();
    }

    private static String getString(String str) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    private static void t(String str, String str2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static a vU() {
        if (afU == null) {
            synchronized (a.class) {
                if (afU == null) {
                    afU = new a();
                }
            }
        }
        return afU;
    }

    public static boolean vV() {
        List<f> bb = bb(15);
        if (bb.size() == 0) {
            return true;
        }
        long j2 = -1;
        int i2 = 0;
        for (f fVar : bb) {
            i2 += fVar.count;
            long j3 = fVar.alK;
            if (j3 > j2) {
                j2 = j3;
            }
        }
        b.d("AdCounter", "onBind localCountCheck: allCount: " + i2 + ", lastShowTime: " + j2);
        if (i2 > vX()) {
            return false;
        }
        return j2 + (vY() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> vW() {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
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

    private static int vX() {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long vY() {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }
}
