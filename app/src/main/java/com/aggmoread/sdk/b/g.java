package com.aggmoread.sdk.b;

import android.app.Activity;
import android.view.View;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.draw.AMDrawAd;
import com.aggmoread.sdk.client.draw.AMDrawAdInteractionListener;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends c implements AMDrawAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.n.a f4107b;

    /* renamed from: c */
    protected AMDrawAdInteractionListener f4108c;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.n.b {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onADCloseOverlay() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onADCloseOverlay();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onADLeftApplication() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onADLeftApplication();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onADOpenOverlay() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onADOpenOverlay();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onAdClicked() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onAdExposed() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onAdExposed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onRenderFail() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onRenderFail();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.b
        public void onRenderSuccess() {
            AMDrawAdInteractionListener aMDrawAdInteractionListener = g.this.f4108c;
            if (aMDrawAdInteractionListener != null) {
                aMDrawAdInteractionListener.onRenderSuccess();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
        }
    }

    public class b implements com.aggmoread.sdk.z.d.a.a.c.n.d {

        /* renamed from: a */
        final /* synthetic */ AMDrawAd.DrawVideoListener f4110a;

        public b(g gVar, AMDrawAd.DrawVideoListener drawVideoListener) {
            this.f4110a = drawVideoListener;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void a(long j10) {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void b() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void c() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void onVideoCached() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void onVideoComplete() {
            AMDrawAd.DrawVideoListener drawVideoListener = this.f4110a;
            if (drawVideoListener != null) {
                drawVideoListener.onVideoComplete();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void onVideoInit() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void onVideoLoading() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void onVideoPause() {
            AMDrawAd.DrawVideoListener drawVideoListener = this.f4110a;
            if (drawVideoListener != null) {
                drawVideoListener.onVideoPause();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void onVideoStart() {
            AMDrawAd.DrawVideoListener drawVideoListener = this.f4110a;
            if (drawVideoListener != null) {
                drawVideoListener.onVideoStart();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.d
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            AMDrawAd.DrawVideoListener drawVideoListener = this.f4110a;
            if (drawVideoListener != null) {
                drawVideoListener.onVideoError(new AMError(dVar.a(), dVar.b()));
            }
        }
    }

    public g(com.aggmoread.sdk.z.d.a.a.c.n.a aVar, d dVar) {
        super(aVar, dVar);
        this.f4107b = aVar;
        aVar.a(new a());
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4107b.h();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4107b.destroy();
        this.f4108c = null;
    }

    @Override // com.aggmoread.sdk.client.draw.AMDrawAd
    public View getView() {
        return this.f4107b.getView();
    }

    @Override // com.aggmoread.sdk.client.draw.AMDrawAd
    public void recycle() {
        this.f4107b.destroy();
    }

    @Override // com.aggmoread.sdk.client.draw.AMDrawAd
    public void render() {
        this.f4107b.render();
    }

    @Override // com.aggmoread.sdk.client.draw.AMDrawAd
    public void renderActivity(Activity activity) {
        this.f4107b.renderActivity(activity);
    }

    @Override // com.aggmoread.sdk.client.draw.AMDrawAd
    public void setInteractionListener(AMDrawAdInteractionListener aMDrawAdInteractionListener) {
        this.f4108c = aMDrawAdInteractionListener;
    }

    @Override // com.aggmoread.sdk.client.draw.AMDrawAd
    public void setVideoListener(AMDrawAd.DrawVideoListener drawVideoListener) {
        this.f4107b.a(new b(this, drawVideoListener));
    }
}
