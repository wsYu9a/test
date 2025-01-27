package com.aggmoread.sdk.b;

import android.app.Activity;
import android.view.View;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.feedlist.AMExpressAd;
import com.aggmoread.sdk.client.feedlist.AMExpressInteractionListener;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends c implements AMExpressAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.o.d f4111b;

    /* renamed from: c */
    protected AMExpressInteractionListener f4112c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.d.a.a.c.o.b f4113d;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.o.b {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void a() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onAdClosed(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.b
        public void onADCloseOverlay() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onADCloseOverlay(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.b
        public void onADLeftApplication() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onADLeftApplication(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.b
        public void onADOpenOverlay() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onADOpenOverlay(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdClicked() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onAdClicked(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdExposed() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onAdExposed(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.b
        public void onRenderFail() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onRenderFail(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.b
        public void onRenderSuccess() {
            h hVar = h.this;
            AMExpressInteractionListener aMExpressInteractionListener = hVar.f4112c;
            if (aMExpressInteractionListener != null) {
                aMExpressInteractionListener.onRenderSuccess(hVar);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
        }
    }

    public class b implements com.aggmoread.sdk.z.d.a.a.c.o.a {

        /* renamed from: a */
        final /* synthetic */ AMExpressAd.ExpressMediaListener f4115a;

        public b(AMExpressAd.ExpressMediaListener expressMediaListener) {
            this.f4115a = expressMediaListener;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void a(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoLoading(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void b(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoCached(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void c(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoPageOpen(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void d(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoPause(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void e(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoInit(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void f(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoStart(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void g(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoPageClose(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void h(com.aggmoread.sdk.z.d.a.a.c.o.d dVar) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoComplete(h.this);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void a(com.aggmoread.sdk.z.d.a.a.c.o.d dVar, long j10) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoReady(h.this, j10);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.a
        public void a(com.aggmoread.sdk.z.d.a.a.c.o.d dVar, com.aggmoread.sdk.z.d.a.a.c.d dVar2) {
            AMExpressAd.ExpressMediaListener expressMediaListener = this.f4115a;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoError(h.this, new AMError(dVar2.a(), dVar2.b()));
            }
        }
    }

    public h(com.aggmoread.sdk.z.d.a.a.c.o.d dVar, d dVar2) {
        super(dVar, dVar2);
        this.f4111b = dVar;
        this.f4113d = new a();
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4111b.h();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4111b.destroy();
        this.f4113d = null;
        this.f4112c = null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMExpressAd
    public View getView() {
        return this.f4111b.getView();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMExpressAd
    public void recycle() {
        this.f4111b.destroy();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMExpressAd
    public void render() {
        this.f4111b.render();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMExpressAd
    public void renderActivity(Activity activity) {
        this.f4111b.renderActivity(activity);
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMExpressAd
    public void setInteractionListener(AMExpressInteractionListener aMExpressInteractionListener) {
        this.f4112c = aMExpressInteractionListener;
        this.f4111b.a(this.f4113d);
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMExpressAd
    public void setMediaListener(AMExpressAd.ExpressMediaListener expressMediaListener) {
        this.f4111b.a(new b(expressMediaListener));
    }
}
