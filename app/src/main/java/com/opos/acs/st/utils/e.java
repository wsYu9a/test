package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import java.util.Map;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    private static String f16310a = "ReportErrorEngine";

    /* renamed from: c */
    private static volatile e f16311c;

    /* renamed from: d */
    private static byte[] f16312d = new byte[1];

    /* renamed from: b */
    private Context f16313b;

    private e(Context context) {
        if (context != null) {
            this.f16313b = context;
            RequestStatisticManager.getInstance().init(this.f16313b, new InitParams.Builder().build());
        }
    }

    public static e a(Context context) {
        if (f16311c == null) {
            synchronized (f16312d) {
                if (f16311c == null) {
                    f16311c = new e(context);
                }
            }
        }
        return f16311c;
    }

    public static void a(Map map) {
        try {
            String str = f16310a;
            StringBuilder sb = new StringBuilder("errorMap=");
            sb.append(map != null ? map : "null");
            d.a(str, sb.toString());
            StatisticEvent a2 = com.opos.acs.st.b.a.a(map);
            if (a2 != null) {
                try {
                    RequestStatisticManager.getInstance().report(a2);
                } catch (Exception e2) {
                    d.c(f16310a, "report error Exception", e2);
                }
            }
        } catch (Exception e3) {
            d.c(f16310a, "reportOneRecord error Exception", e3);
        }
    }

    public final void a() {
        boolean z;
        try {
            if ("WIFI".equalsIgnoreCase(h.a(this.f16313b))) {
                d.a(f16310a, "is wifi");
                z = true;
            } else {
                d.a(f16310a, "is not wifi");
                z = false;
            }
            if (z) {
                RequestStatisticManager.getInstance().reportCacheIfNeed();
            } else {
                d.a(f16310a, "is not wifi");
            }
        } catch (Exception e2) {
            d.c(f16310a, "report all error Exception", e2);
        }
    }
}
