package com.martian.ttbook.b.c.a.a.b.a.d.c.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.martian.ttbook.b.c.a.a.b.a.d.e;
import com.martian.ttbook.b.c.a.a.b.a.d.q;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends e {
    private static String m = "VVUNITAG";
    private VivoNativeExpressView n;
    private WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> o;
    private com.martian.ttbook.b.c.a.a.c.l.a p;

    class a implements q {
        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void a() {
            b.this.p.b(b.this);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void a(i iVar) {
            b.this.p.j(b.this, iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoComplete() {
            b.this.p.h(b.this);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoPause() {
            b.this.p.e(b.this);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoReady(long j2) {
            b.this.p.k(b.this, -1L);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoStart() {
            b.this.p.b(b.this);
        }
    }

    public b(VivoNativeExpressView vivoNativeExpressView, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.n = vivoNativeExpressView;
        if (vivoNativeExpressView != null) {
            com.martian.ttbook.b.c.a.a.b.a.d.c.b.k(this.l, com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(vivoNativeExpressView), eVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h(this.n, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void a(Activity activity) {
        render();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void b() {
        VivoNativeExpressView vivoNativeExpressView = this.n;
        if (vivoNativeExpressView != null) {
            vivoNativeExpressView.destroy();
            this.n = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public View getView() {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.o;
        if (weakReference != null && weakReference.get() != null) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "get ");
            return this.o.get();
        }
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15212c.f15670d);
        aVar.addView(this.n, new FrameLayout.LayoutParams(-1, -2));
        this.o = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.a
    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.o;
        return weakReference != null ? weakReference.get() : super.i();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void render() {
        VivoNativeExpressView vivoNativeExpressView = this.n;
        if (vivoNativeExpressView != null) {
            if (this.p != null) {
                vivoNativeExpressView.setMediaListener(com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().f(new a()));
            }
            com.martian.ttbook.b.c.a.a.e.d.g(m, "render");
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(this.n, i2);
    }
}
