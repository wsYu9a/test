package com.opos.cmn.biz.a;

import android.content.Context;
import com.cdo.oaps.ad.af;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final String f16618a = "com." + com.opos.cmn.an.a.a.f16359c + ".market";

    /* renamed from: b */
    private static final String f16619b = "com." + com.opos.cmn.an.a.a.f16357a + ".market";

    /* renamed from: c */
    private static final String f16620c = "com." + com.opos.cmn.an.a.a.f16360d + ".browser";

    public static String a(Context context) {
        if (com.opos.cmn.an.h.d.a.d(context, af.f6508e)) {
            return af.f6508e;
        }
        String str = f16618a;
        if (com.opos.cmn.an.h.d.a.d(context, str)) {
            return str;
        }
        String str2 = f16619b;
        return com.opos.cmn.an.h.d.a.d(context, str2) ? str2 : "";
    }

    public static String b(Context context) {
        if (com.opos.cmn.an.h.d.a.d(context, "com.heytap.browser")) {
            return "com.heytap.browser";
        }
        String str = f16620c;
        return com.opos.cmn.an.h.d.a.d(context, str) ? str : com.opos.cmn.an.h.d.a.d(context, "com.nearme.browser") ? "com.nearme.browser" : com.opos.cmn.an.h.d.a.d(context, "com.android.browser") ? "com.android.browser" : "";
    }
}
