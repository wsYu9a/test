package com.aggmoread.sdk.b;

import android.app.Activity;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAd;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener;
import java.util.Map;

/* loaded from: classes.dex */
public class j extends c implements AMInterstitialAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.q.b f4121b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.d.a.a.c.q.a f4122c;

    /* renamed from: d */
    private AMInterstitialAdInteractionListener f4123d;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.q.a {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void a() {
            if (j.this.f4123d != null) {
                j.this.f4123d.onAdClosed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.a
        public void onADLeftApplication() {
            if (j.this.f4123d != null) {
                j.this.f4123d.onADLeftApplication();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdClicked() {
            if (j.this.f4123d != null) {
                j.this.f4123d.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdExposed() {
            if (j.this.f4123d != null) {
                j.this.f4123d.onAdExposed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.a
        public void onAdShow() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.a
        public void onAdVideoCompleted() {
            if (j.this.f4123d != null) {
                j.this.f4123d.onAdVideoCompleted();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            if (j.this.f4123d != null) {
                j.this.f4123d.onAdError(new AMError(dVar.a(), dVar.b()));
            }
        }
    }

    public j(com.aggmoread.sdk.z.d.a.a.c.q.b bVar, d dVar) {
        super(bVar, dVar);
        this.f4121b = bVar;
        this.f4122c = new a();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4121b.destroy();
        this.f4123d = null;
        this.f4122c = null;
    }

    @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAd
    public void show(Activity activity, AMInterstitialAdInteractionListener aMInterstitialAdInteractionListener) {
        this.f4123d = aMInterstitialAdInteractionListener;
        this.f4121b.a(this.f4122c);
        this.f4121b.a(activity);
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4121b.h();
    }

    @Override // com.aggmoread.sdk.client.interstitial.AMInterstitialAd
    public void show(AMInterstitialAdInteractionListener aMInterstitialAdInteractionListener) {
        this.f4123d = aMInterstitialAdInteractionListener;
        this.f4121b.a(this.f4122c);
        this.f4121b.b();
    }
}
