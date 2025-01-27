package com.aggmoread.sdk.b;

import android.app.Activity;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.reward.AMRewardAd;
import com.aggmoread.sdk.client.reward.AMRewardInteractionListener;
import java.util.Map;

/* loaded from: classes.dex */
public class n extends c implements AMRewardAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.r.a f4134b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.d.a.a.c.r.d f4135c;

    /* renamed from: d */
    private AMRewardInteractionListener f4136d;

    public class a implements com.aggmoread.sdk.z.d.a.a.c.r.d {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void a() {
            if (n.this.f4136d != null) {
                n.this.f4136d.onAdClosed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdClicked() {
            if (n.this.f4136d != null) {
                n.this.f4136d.onAdClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.e
        public void onAdExposed() {
            if (n.this.f4136d != null) {
                n.this.f4136d.onAdExposed();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.d
        public void onAdShow() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.d
        public void onReward(Map map) {
            if (n.this.f4136d != null) {
                n.this.f4136d.onReward(map);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.d
        public void onVideoComplete() {
            if (n.this.f4136d != null) {
                n.this.f4136d.onVideoComplete();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            if (n.this.f4136d != null) {
                n.this.f4136d.onAdError(new AMError(dVar.a(), dVar.b()));
            }
        }
    }

    public n(com.aggmoread.sdk.z.d.a.a.c.r.a aVar, d dVar) {
        super(aVar, dVar);
        this.f4134b = aVar;
        this.f4135c = new a();
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4136d = null;
        this.f4135c = null;
        com.aggmoread.sdk.z.d.a.a.c.r.a aVar = this.f4134b;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    @Override // com.aggmoread.sdk.client.reward.AMRewardAd
    public void show(Activity activity, AMRewardInteractionListener aMRewardInteractionListener) {
        this.f4136d = aMRewardInteractionListener;
        this.f4134b.a(this.f4135c);
        this.f4134b.a(activity);
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4134b.h();
    }

    @Override // com.aggmoread.sdk.client.reward.AMRewardAd
    public void show(AMRewardInteractionListener aMRewardInteractionListener) {
        this.f4136d = aMRewardInteractionListener;
        this.f4134b.a(this.f4135c);
        this.f4134b.b();
    }
}
