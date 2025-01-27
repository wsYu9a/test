package com.aggmoread.sdk.z.d.a.a.d.a.d.w.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.d.a.a.d.a.d.c {

    /* renamed from: u */
    private static String f5820u = "AMHTAGGDT";

    /* renamed from: s */
    private com.aggmoread.sdk.z.b.k.c f5821s;

    /* renamed from: t */
    private WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5822t;

    public b(com.aggmoread.sdk.z.b.k.c cVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5821s = cVar;
        com.aggmoread.sdk.z.d.a.a.d.a.c cVar2 = dVar.f5874t;
        if (cVar != null) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.w.a.b(this.f5308p, cVar.b(), eVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5822t;
        return weakReference != null ? weakReference.get() : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        com.aggmoread.sdk.z.b.k.c cVar = this.f5821s;
        if (cVar != null) {
            cVar.g();
            this.f5821s = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        return this.f5821s.c();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5822t;
        if (weakReference != null && weakReference.get() != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5820u, "get ");
            return this.f5822t.get();
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d);
        aVar.addView(this.f5821s.a(), new FrameLayout.LayoutParams(-1, -2));
        this.f5822t = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        if (this.f5821s != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5820u, "render");
            this.f5821s.h();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.o.d
    public void a(com.aggmoread.sdk.z.d.a.a.c.o.a aVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
