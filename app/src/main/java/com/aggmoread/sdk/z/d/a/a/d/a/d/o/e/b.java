package com.aggmoread.sdk.z.d.a.a.d.a.d.o.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.d.a.a.d.a.d.c {

    /* renamed from: u */
    private static String f5398u = "AMHTAGGDT";

    /* renamed from: s */
    private com.aggmoread.sdk.z.b.k.c f5399s;

    /* renamed from: t */
    private WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5400t;

    public b(com.aggmoread.sdk.z.b.k.c cVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5399s = cVar;
        if (cVar != null) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.b(this.f5308p, cVar.b(), eVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5400t;
        return weakReference != null ? weakReference.get() : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        com.aggmoread.sdk.z.b.k.c cVar = this.f5399s;
        if (cVar != null) {
            cVar.g();
            this.f5399s = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        return this.f5399s.c();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5400t;
        if (weakReference != null && weakReference.get() != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5398u, "get ");
            return this.f5400t.get();
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d);
        aVar.addView(this.f5399s.a(), new FrameLayout.LayoutParams(-1, -2));
        this.f5400t = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        if (this.f5399s != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5398u, "render");
            this.f5399s.h();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.o.d
    public void a(com.aggmoread.sdk.z.d.a.a.c.o.a aVar) {
    }
}
