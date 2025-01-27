package b.d.e.a.i.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import b.d.e.a.e;
import com.martian.ttbook.b.c.a.a.c.d;
import com.martian.ttbook.b.c.a.a.c.o.c;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener;
import com.martian.ttbook.sdk.client.video.FullScreenVideoAdListenerExt;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends b.d.e.a.i.a {

    /* renamed from: e */
    private com.martian.ttbook.b.c.a.a.c.m.a f4525e;

    /* renamed from: b.d.e.a.i.g.a$a */
    class C0021a implements com.martian.ttbook.b.c.a.a.c.m.b {
        C0021a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(d dVar) {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void onAdClicked() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdClicked();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void onAdDismissed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void onAdExposed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdExposure();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.m.a> list) {
            if (list != null && list.size() > 0) {
                a.this.f4525e = list.get(0);
            }
            if (a.this.f4525e == null) {
                if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListenerExt) {
                    ((FullScreenVideoAdListenerExt) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(-1, "广告请求失败！"));
                }
            } else {
                if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListenerExt) {
                    ((FullScreenVideoAdListenerExt) ((b.d.e.a.i.a) a.this).f4503c).onAdLoaded(a.this);
                }
                if (((b.d.e.a.i.a) a.this).f4504d.isOnlyLoadAdData()) {
                    return;
                }
                a.this.show();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void onAdShow() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdShow();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.m.b
        public void onAdVideoCompleted() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FullScreenVideoAdListener) {
                ((FullScreenVideoAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdVideoCompleted();
            }
        }
    }

    class b implements com.martian.ttbook.b.c.a.a.c.b {

        /* renamed from: a */
        final /* synthetic */ AdRequest f4527a;

        b(a aVar, AdRequest adRequest) {
            this.f4527a = adRequest;
        }

        @Override // com.martian.ttbook.b.c.a.a.c.b
        public void onReward(Map<String, Object> map) {
            if (this.f4527a.getAdRewardListener() != null) {
                this.f4527a.getAdRewardListener().onReward(map);
            }
        }
    }

    public a(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        g(adRequest, this.f4501a);
    }

    private void g(AdRequest adRequest, e eVar) {
        if (TextUtils.isEmpty(adRequest.getUserID())) {
            return;
        }
        c cVar = new c();
        cVar.h(adRequest.getUserID());
        cVar.b(adRequest.getRewardAmount());
        cVar.f(adRequest.getRewardName());
        cVar.d(adRequest.getCustomData());
        cVar.c(new b(this, adRequest));
        eVar.f(cVar);
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.a c() {
        return this.f4525e;
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new C0021a();
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.m.a aVar = this.f4525e;
        return aVar != null ? b.d.e.a.a.c(aVar.a()) : adExtras;
    }

    @Override // b.d.e.a.i.a, b.d.e.a.g
    public boolean recycle() {
        com.martian.ttbook.b.c.a.a.c.m.a aVar = this.f4525e;
        if (aVar == null) {
            return true;
        }
        aVar.b();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show() {
        com.martian.ttbook.b.c.a.a.c.m.a aVar = this.f4525e;
        if (aVar == null) {
            return false;
        }
        aVar.show();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(Activity activity) {
        com.martian.ttbook.b.c.a.a.c.m.a aVar = this.f4525e;
        if (aVar == null) {
            return false;
        }
        aVar.show(activity);
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(ViewGroup viewGroup) {
        return show();
    }
}
