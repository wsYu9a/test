package com.opos.cmn.e.a.b;

import android.R;
import android.app.Activity;
import com.opos.cmn.e.a.b.b.c;
import com.opos.cmn.e.a.b.d.a;
import com.opos.cmn.e.a.b.e.b;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private c f16928a;

    /* renamed from: b */
    private com.opos.cmn.e.a.b.e.c f16929b;

    public a(Activity activity) {
        this.f16928a = new c(activity);
        b bVar = new b(activity, new a.C0384a().a(com.opos.cmn.an.h.f.a.a(activity) ? R.style.Theme.Translucent.NoTitleBar.Fullscreen : R.style.Theme.Translucent.NoTitleBar).a(false).b(false).a());
        this.f16929b = bVar;
        bVar.a(this.f16928a.b());
    }

    public void a() {
        if (this.f16929b.a()) {
            this.f16929b.c();
        }
    }

    public void a(String str, String str2, String str3, com.opos.cmn.e.a.b.c.a aVar) {
        this.f16928a.a((CharSequence) str);
        this.f16928a.b(str2);
        this.f16928a.a(str3);
        this.f16928a.a(aVar);
        this.f16929b.b();
    }
}
