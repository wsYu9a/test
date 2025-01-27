package com.aggmoread.sdk.z.d.a.a.d.a.d.u.f;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends com.aggmoread.sdk.z.d.a.a.d.a.d.b implements NativeExpressMediaListener {

    /* renamed from: w */
    private static String f5691w = "AMDRAWTAGGDT";

    /* renamed from: t */
    private NativeExpressADView f5692t;

    /* renamed from: u */
    private AdData f5693u;

    /* renamed from: v */
    private WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5694v;

    public a(NativeExpressADView nativeExpressADView, d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5692t = nativeExpressADView;
        this.f5301s = dVar.f5874t;
        if (nativeExpressADView != null) {
            AdData boundData = nativeExpressADView.getBoundData();
            this.f5693u = boundData;
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5298p, boundData, eVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5694v;
        return weakReference != null ? weakReference.get() : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public void b(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5692t, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void destroy() {
        NativeExpressADView nativeExpressADView = this.f5692t;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
            this.f5692t = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public String getTitle() {
        return this.f5693u.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public View getView() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5694v;
        if (weakReference != null && weakReference.get() != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5691w, "get ");
            return this.f5694v.get();
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d.getApplicationContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        aVar.addView(this.f5692t, layoutParams);
        this.f5694v = new WeakReference<>(aVar);
        return aVar;
    }

    public com.aggmoread.sdk.z.d.a.a.c.n.b j() {
        return this.f5300r;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoCached(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoCached();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoComplete(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoComplete();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoInit(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoInit();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoLoading(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoLoading();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoPause(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoPause();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoReady(NativeExpressADView nativeExpressADView, long j10) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.a(j10);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
    public void onVideoStart(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoStart();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void render() {
        NativeExpressADView nativeExpressADView = this.f5692t;
        if (nativeExpressADView != null) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(nativeExpressADView, c());
            if (this.f5299q != null) {
                this.f5692t.setMediaListener(this);
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5691w, "render");
            this.f5692t.render();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
        this.f5301s = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5692t, i11, i10, str);
    }
}
