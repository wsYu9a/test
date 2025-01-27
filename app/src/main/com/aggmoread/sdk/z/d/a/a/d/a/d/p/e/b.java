package com.aggmoread.sdk.z.d.a.a.d.a.d.p.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.d.a.a.d.a.d.c {

    /* renamed from: u */
    private static String f5426u = "AMHTAGGDT";

    /* renamed from: s */
    private com.aggmoread.sdk.z.b.k.c f5427s;

    /* renamed from: t */
    private WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5428t;

    public b(com.aggmoread.sdk.z.b.k.c cVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5427s = cVar;
        if (cVar != null) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.b(this.f5308p, cVar.b(), eVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5428t;
        return weakReference != null ? weakReference.get() : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        com.aggmoread.sdk.z.b.k.c cVar = this.f5427s;
        if (cVar != null) {
            cVar.g();
            this.f5427s = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        return this.f5427s.c();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5428t;
        if (weakReference != null && weakReference.get() != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5426u, "get ");
            return this.f5428t.get();
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d);
        aVar.addView(this.f5427s.a(), new FrameLayout.LayoutParams(-1, -2));
        this.f5428t = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        if (this.f5427s != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5426u, "render");
            this.f5427s.h();
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
