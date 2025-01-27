package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.martian.ttbook.b.c.a.a.e.i;
import com.martian.ttbook.sdk.client.AdExtras;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
public class d extends com.martian.ttbook.b.c.a.a.b.a.d.e implements NativeExpressMediaListener {
    private static String m = "GDTHTAG";
    private NativeExpressADView n;
    private AdData o;
    private com.martian.ttbook.b.c.a.a.b.a.c p;
    private WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> q;
    private com.martian.ttbook.b.c.a.a.c.l.a r;

    public d(NativeExpressADView nativeExpressADView, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.n = nativeExpressADView;
        this.p = dVar.t;
        if (nativeExpressADView != null) {
            this.o = nativeExpressADView.getBoundData();
            this.l.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(this.n));
            com.martian.ttbook.b.c.a.a.d.a.d.x.c.d(this.l, this.o, eVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        i.d(this.n, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void a(Activity activity) {
        render();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void b() {
        NativeExpressADView nativeExpressADView = this.n;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
            this.n = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.p = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public View getView() {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.q;
        if (weakReference != null && weakReference.get() != null) {
            com.martian.ttbook.b.c.a.a.e.d.g(m, "get ");
            return this.q.get();
        }
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15212c.f15670d);
        aVar.addView(this.n, new FrameLayout.LayoutParams(-1, -2));
        this.q = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.a
    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.q;
        return weakReference != null ? weakReference.get() : super.i();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoCached(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoComplete(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.h(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.j(this, new com.martian.ttbook.b.c.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoInit(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoLoading(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.g(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.i(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.d(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPause(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.e(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoReady(NativeExpressADView nativeExpressADView, long j2) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.k(this, j2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoStart(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.c.l.a aVar = this.r;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void render() {
        NativeExpressADView nativeExpressADView = this.n;
        if (nativeExpressADView != null) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(nativeExpressADView, this.p);
            if (this.r != null) {
                this.n.setMediaListener(this);
            }
            com.martian.ttbook.b.c.a.a.e.d.g(m, "render");
            this.n.render();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        i.c(this.n, i2);
    }
}
