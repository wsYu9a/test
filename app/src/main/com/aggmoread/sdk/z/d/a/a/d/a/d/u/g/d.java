package com.aggmoread.sdk.z.d.a.a.d.a.d.u.g;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends com.aggmoread.sdk.z.d.a.a.d.a.d.c implements NativeExpressMediaListener {

    /* renamed from: w */
    private static String f5703w = "AMEPTAGGDT";

    /* renamed from: s */
    private NativeExpressADView f5704s;

    /* renamed from: t */
    private AdData f5705t;

    /* renamed from: u */
    private WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5706u;

    /* renamed from: v */
    private com.aggmoread.sdk.z.d.a.a.c.o.a f5707v;

    public d(NativeExpressADView nativeExpressADView, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5704s = nativeExpressADView;
        if (nativeExpressADView != null) {
            AdData boundData = nativeExpressADView.getBoundData();
            this.f5705t = boundData;
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5308p, boundData, eVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5706u;
        return weakReference != null ? weakReference.get() : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public void b(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5704s, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        NativeExpressADView nativeExpressADView = this.f5704s;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
            this.f5704s = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        return this.f5705t.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5706u;
        if (weakReference != null && weakReference.get() != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5703w, "get ");
            return this.f5706u.get();
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d);
        aVar.addView(this.f5704s, new FrameLayout.LayoutParams(-1, -2));
        this.f5706u = new WeakReference<>(aVar);
        return aVar;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoCached(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoComplete(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.h(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.a(this, new i(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoInit(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.e(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoLoading(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.g(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPause(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.d(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoReady(NativeExpressADView nativeExpressADView, long j10) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.a(this, j10);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoStart(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.o.a aVar = this.f5707v;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        NativeExpressADView nativeExpressADView = this.f5704s;
        if (nativeExpressADView != null) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(nativeExpressADView, c());
            if (this.f5707v != null) {
                this.f5704s.setMediaListener(this);
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5703w, "render");
            this.f5704s.render();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.o.d
    public void a(com.aggmoread.sdk.z.d.a.a.c.o.a aVar) {
        this.f5707v = aVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5704s, i11, i10, str);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5309q = cVar;
    }
}
