package com.opos.mobad.interstitial;

import android.app.Activity;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.interstitial.a.j;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;

/* loaded from: classes4.dex */
public class c {
    private static com.opos.mobad.activity.webview.b a(Activity activity, String str, a.C0457a c0457a) {
        if (c0457a.f21744b.R() == 0 || !com.opos.mobad.o.e.b.a(c0457a.f21745c.b())) {
            return null;
        }
        String m = c0457a.f21745c.m();
        return new com.opos.mobad.activity.webview.b(activity, new WebDataHepler(c0457a.f21744b, str, -1 != f.c(m) ? f.a(c0457a.f21744b, m, str) : "", m, "", null, 1, false, false));
    }

    public static final a a(Activity activity, String str, com.opos.mobad.q.a.b.c cVar, h hVar, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.q.a.b.d dVar, a.C0457a c0457a, int i2) {
        if (c0457a == null) {
            return null;
        }
        if (c0457a.f21744b.S() == 1 && hVar.a(activity)) {
            com.opos.cmn.an.f.a.b("PresenterFactory", "do show as activity");
            return new e(activity.getApplicationContext(), str, hVar, aVar, dVar, cVar, c0457a, i2);
        }
        com.opos.cmn.an.f.a.b("PresenterFactory", "do show as dialog");
        return new d(activity, str, aVar, new j(), dVar, a(activity, str, c0457a), cVar, c0457a, i2);
    }
}
