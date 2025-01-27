package b.d.e.a.i.e;

import android.app.Activity;
import android.view.ViewGroup;
import b.d.e.a.e;
import com.martian.ttbook.b.c.a.a.c.d;
import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.b.c.a.a.c.n.b;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.interstitial.InterstitialAdExtListener;
import com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends b.d.e.a.i.a {

    /* renamed from: e */
    private com.martian.ttbook.b.c.a.a.c.n.a f4521e;

    /* renamed from: b.d.e.a.i.e.a$a */
    class C0019a implements b {
        C0019a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(d dVar) {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdListener) {
                ((InterstitialAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void onAdClicked() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdListener) {
                ((InterstitialAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdClicked();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void onAdDismissed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdListener) {
                ((InterstitialAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void onAdExposed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdListener) {
                ((InterstitialAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdExposure();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.n.a> list) {
            if (list != null && list.size() > 0) {
                a.this.f4521e = list.get(0);
            }
            if (a.this.f4521e == null) {
                if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdExtListener) {
                    ((InterstitialAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(-1, "广告请求失败！"));
                }
            } else {
                if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdExtListener) {
                    ((InterstitialAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdLoaded(a.this);
                }
                if (((b.d.e.a.i.a) a.this).f4504d.isOnlyLoadAdData()) {
                    return;
                }
                a.this.show();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void onAdShow() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof InterstitialAdListener) {
                ((InterstitialAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdShow();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.n.b
        public void onAdVideoCompleted() {
        }
    }

    public a(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        h(adRequest, this.f4501a);
    }

    private int e(int i2) {
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        return 0;
                    }
                }
            }
        }
        return i3;
    }

    private void h(AdRequest adRequest, e eVar) {
        eVar.b(new g(adRequest.getAdSize().getAdWidth(), adRequest.getAdSize().getAdHeight()));
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.a c() {
        return this.f4521e;
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new C0019a();
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.n.a aVar = this.f4521e;
        if (aVar == null) {
            return adExtras;
        }
        b.d.e.a.a c2 = b.d.e.a.a.c(aVar.a());
        c2.b(AdExtras.EXTRA_AD_PATTERNTYPE, Integer.valueOf(e(this.f4521e.getAdPatternType())));
        return c2;
    }

    @Override // b.d.e.a.i.a, b.d.e.a.g
    public boolean recycle() {
        com.martian.ttbook.b.c.a.a.c.n.a aVar = this.f4521e;
        if (aVar == null) {
            return true;
        }
        aVar.b();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show() {
        com.martian.ttbook.b.c.a.a.c.n.a aVar = this.f4521e;
        if (aVar == null) {
            return false;
        }
        aVar.show();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(Activity activity) {
        com.martian.ttbook.b.c.a.a.c.n.a aVar = this.f4521e;
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
