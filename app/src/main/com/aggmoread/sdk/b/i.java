package com.aggmoread.sdk.b;

import android.app.Activity;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAd;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAdInteractionListener;
import java.util.Map;

/* loaded from: classes.dex */
public class i extends c implements AMFullScreenAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.p.b f4117b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.d.a.a.c.p.a f4118c;

    /* renamed from: d */
    private AMFullScreenAdInteractionListener f4119d;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.p.a {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void a() {
            if (i.this.f4119d != null) {
                i.this.f4119d.onAdClosed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.a
        public void onADLeftApplication() {
            if (i.this.f4119d != null) {
                i.this.f4119d.onADLeftApplication();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdClicked() {
            if (i.this.f4119d != null) {
                i.this.f4119d.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdExposed() {
            if (i.this.f4119d != null) {
                i.this.f4119d.onAdExposed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.a
        public void onAdShow() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.a
        public void onAdVideoCompleted() {
            if (i.this.f4119d != null) {
                i.this.f4119d.onAdVideoCompleted();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            if (i.this.f4119d != null) {
                i.this.f4119d.onAdError(new AMError(dVar.a(), dVar.b()));
            }
        }
    }

    public i(com.aggmoread.sdk.z.d.a.a.c.p.b bVar, d dVar) {
        super(bVar, dVar);
        this.f4117b = bVar;
        this.f4118c = new a();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4117b.destroy();
        this.f4119d = null;
        this.f4118c = null;
    }

    @Override // com.aggmoread.sdk.client.fullscreen.AMFullScreenAd
    public void show(Activity activity, AMFullScreenAdInteractionListener aMFullScreenAdInteractionListener) {
        this.f4119d = aMFullScreenAdInteractionListener;
        this.f4117b.a(this.f4118c);
        this.f4117b.a(activity);
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4117b.h();
    }

    @Override // com.aggmoread.sdk.client.fullscreen.AMFullScreenAd
    public void show(AMFullScreenAdInteractionListener aMFullScreenAdInteractionListener) {
        this.f4119d = aMFullScreenAdInteractionListener;
        this.f4117b.a(this.f4118c);
        this.f4117b.b();
    }
}
