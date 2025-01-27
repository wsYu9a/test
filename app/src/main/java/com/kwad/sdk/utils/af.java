package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class af {
    @WorkerThread
    public static String a(Context context, String str, ag.a aVar, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String am = ag.am(context, ag.a(str, aVar));
        String cP = ba.cP(context);
        if (!TextUtils.isEmpty(cP)) {
            am = am.replace("__MAC__", cP).replace("__MAC2__", ai.by(cP)).replace("__MAC3__", ai.by(cP.replace(":", "")));
        }
        String cN = ba.cN(context);
        if (!TextUtils.isEmpty(cN)) {
            am = am.replace("__IMEI__", cN).replace("__IMEI2__", ai.by(cN)).replace("__IMEI3__", ai.gL(cN));
        }
        String oaid = ba.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            am = am.replace("__OAID__", oaid).replace("__OAID2__", ai.by(oaid));
        }
        String cO = ba.cO(context);
        if (!TextUtils.isEmpty(cO)) {
            am = am.replace("__ANDROIDID2__", ai.by(cO)).replace("__ANDROIDID3__", ai.gL(cO)).replace("__ANDROIDID__", cO);
        }
        return ag.c(context, am, z10);
    }

    public static void f(AdTemplate adTemplate, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Context context = ServiceProvider.getContext();
        if (!TextUtils.isEmpty(ba.cP(context))) {
            if (str2.contains("__MAC__")) {
                arrayList.add("__MAC__");
            }
            if (str2.contains("__MAC2__")) {
                arrayList.add("__MAC2__");
            }
            if (str2.contains("__MAC3__")) {
                arrayList.add("__MAC3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "MAC", str, str2, (String) it.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(ba.cN(context))) {
            if (str2.contains("__IMEI__")) {
                arrayList.add("__IMEI__");
            }
            if (str2.contains("__IMEI2__")) {
                arrayList.add("__IMEI2__");
            }
            if (str2.contains("__IMEI3__")) {
                arrayList.add("__IMEI3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "IMEI", str, str2, (String) it2.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(ba.getOaid())) {
            if (str2.contains("__OAID__")) {
                arrayList.add("__OAID__");
            }
            if (str2.contains("__OAID2__")) {
                arrayList.add("__OAID2__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "OAID", str, str2, (String) it3.next());
                }
                arrayList.clear();
            }
        }
        if (TextUtils.isEmpty(ba.cO(context))) {
            return;
        }
        if (str2.contains("__ANDROIDID__")) {
            arrayList.add("__ANDROIDID__");
        }
        if (str2.contains("__ANDROIDID2__")) {
            arrayList.add("__ANDROIDID2__");
        }
        if (str2.contains("__ANDROIDID3__")) {
            arrayList.add("__ANDROIDID3__");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            com.kwad.sdk.commercial.j.a.a(adTemplate, "ANDROID", str, str2, (String) it4.next());
        }
        arrayList.clear();
    }
}
