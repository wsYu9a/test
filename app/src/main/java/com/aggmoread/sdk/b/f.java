package com.aggmoread.sdk.b;

import android.view.ViewGroup;
import com.aggmoread.sdk.client.banner.AMBannerAd;
import com.aggmoread.sdk.client.banner.AMBannerAdInteractionListener;
import java.util.Map;

/* loaded from: classes.dex */
public class f extends c implements AMBannerAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.m.a f4103b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.d.a.a.c.m.c f4104c;

    /* renamed from: d */
    private AMBannerAdInteractionListener f4105d;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.m.c {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void a() {
            if (f.this.f4105d != null) {
                f.this.f4105d.onAdClosed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.m.c
        public void onADCloseOverlay() {
            if (f.this.f4105d != null) {
                f.this.f4105d.onADCloseOverlay();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.m.c
        public void onADLeftApplication() {
            if (f.this.f4105d != null) {
                f.this.f4105d.onADLeftApplication();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.m.c
        public void onADOpenOverlay() {
            if (f.this.f4105d != null) {
                f.this.f4105d.onADOpenOverlay();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdClicked() {
            if (f.this.f4105d != null) {
                f.this.f4105d.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdExposed() {
            if (f.this.f4105d != null) {
                f.this.f4105d.onAdExposed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.m.c
        public void onAdShow() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
        }
    }

    public f(com.aggmoread.sdk.z.d.a.a.c.m.a aVar, d dVar) {
        super(aVar, dVar);
        this.f4103b = aVar;
        this.f4104c = new a();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4103b.destroy();
    }

    @Override // com.aggmoread.sdk.client.banner.AMBannerAd
    public void show(AMBannerAdInteractionListener aMBannerAdInteractionListener) {
        this.f4105d = aMBannerAdInteractionListener;
        this.f4103b.a(this.f4104c);
        this.f4103b.b();
    }

    @Override // com.aggmoread.sdk.client.banner.AMBannerAd
    public void showInContainer(ViewGroup viewGroup, AMBannerAdInteractionListener aMBannerAdInteractionListener) {
        this.f4105d = aMBannerAdInteractionListener;
        this.f4103b.a(this.f4104c);
        this.f4103b.a(viewGroup);
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4103b.h();
    }
}
