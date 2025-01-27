package com.aggmoread.sdk.b;

import android.util.Log;
import android.view.ViewGroup;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.splash.AMSplashAd;
import com.aggmoread.sdk.client.splash.AMSplashInteractionListener;
import com.aggmoread.sdk.t;
import java.util.Map;

/* loaded from: classes.dex */
public class o extends c implements AMSplashAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.s.a f4138b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.d.a.a.c.s.c f4139c;

    /* renamed from: d */
    private AMSplashInteractionListener f4140d;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.s.c {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void a() {
            Log.e(t.SDK_TAG, "onAdDismissed");
            if (o.this.f4140d != null) {
                o.this.f4140d.onAdClosed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.s.c
        public void e() {
            Log.e(t.SDK_TAG, "onAdSkip");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdClicked() {
            Log.e(t.SDK_TAG, "onAdClicked");
            if (o.this.f4140d != null) {
                o.this.f4140d.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdExposed() {
            Log.e(t.SDK_TAG, "onAdExposed");
            if (o.this.f4140d != null) {
                o.this.f4140d.onAdExposed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.s.c
        public void onAdTick(long j10) {
            Log.e(t.SDK_TAG, "onAdTick");
            if (o.this.f4140d != null) {
                o.this.f4140d.onAdTick(j10);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            if (o.this.f4140d != null) {
                o.this.f4140d.onAdError(new AMError(dVar.a(), dVar.b()));
            }
        }
    }

    public o(d dVar, com.aggmoread.sdk.z.d.a.a.c.s.a aVar) {
        super(aVar, dVar);
        this.f4138b = aVar;
        this.f4139c = new a();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4140d = null;
        this.f4139c = null;
        com.aggmoread.sdk.z.d.a.a.c.s.a aVar = this.f4138b;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    @Override // com.aggmoread.sdk.client.splash.AMSplashAd
    public void show(AMSplashInteractionListener aMSplashInteractionListener) {
        this.f4140d = aMSplashInteractionListener;
        this.f4138b.a(this.f4139c);
        this.f4138b.b();
    }

    @Override // com.aggmoread.sdk.client.splash.AMSplashAd
    public void showViewGroup(ViewGroup viewGroup, AMSplashInteractionListener aMSplashInteractionListener) {
        this.f4140d = aMSplashInteractionListener;
        this.f4138b.a(this.f4139c);
        this.f4138b.a(viewGroup);
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4138b.h();
    }
}
