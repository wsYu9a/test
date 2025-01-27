package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.ac;

/* loaded from: classes2.dex */
public final class ab {
    @WorkerThread
    public static String a(Context context, String str, ac.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String ag = ac.ag(context, ac.a(str, aVar));
        String cn = au.cn(context);
        if (!TextUtils.isEmpty(cn)) {
            ag = ag.replace("__MAC__", cn).replace("__MAC2__", ad.eC(cn)).replace("__MAC3__", ad.eC(cn.replace(":", "")));
        }
        String cl = au.cl(context);
        if (!TextUtils.isEmpty(cl)) {
            ag = ag.replace("__IMEI__", cl).replace("__IMEI2__", ad.eC(cl)).replace("__IMEI3__", ad.eD(cl));
        }
        String oaid = au.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            ag = ag.replace("__OAID__", oaid).replace("__OAID2__", ad.eC(oaid));
        }
        String cm = au.cm(context);
        if (!TextUtils.isEmpty(cm)) {
            ag = ag.replace("__ANDROIDID2__", ad.eC(cm)).replace("__ANDROIDID3__", ad.eD(cm)).replace("__ANDROIDID__", cm);
        }
        return ac.c(context, ag, z);
    }
}
