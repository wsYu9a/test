package b.d.e.a.i.c;

import android.view.ViewGroup;
import b.d.e.a.e;
import com.martian.ttbook.b.c.a.a.c.d;
import com.martian.ttbook.b.c.a.a.c.k.b;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.banner.BannerAdExtListener;
import com.martian.ttbook.sdk.client.banner.BannerAdListener;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends b.d.e.a.i.a {

    /* renamed from: e */
    private com.martian.ttbook.b.c.a.a.c.k.a f4507e;

    /* renamed from: b.d.e.a.i.c.a$a */
    class C0017a implements b {
        C0017a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(d dVar) {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdListener) {
                ((BannerAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void d() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void e() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void onAdClicked() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdListener) {
                ((BannerAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdClicked();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void onAdDismissed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdListener) {
                ((BannerAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void onAdExposed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdListener) {
                ((BannerAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdExposure();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.k.a> list) {
            if (list != null && list.size() > 0) {
                a.this.f4507e = list.get(0);
            }
            if (a.this.f4507e == null) {
                if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdExtListener) {
                    ((BannerAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(-1, "广告请求失败！"));
                }
            } else {
                if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdExtListener) {
                    ((BannerAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdLoaded(a.this);
                }
                if (((b.d.e.a.i.a) a.this).f4504d.isOnlyLoadAdData()) {
                    return;
                }
                a.this.show();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.k.b
        public void onAdShow() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof BannerAdListener) {
                ((BannerAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdShow();
            }
        }
    }

    public a(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        g(adRequest, this.f4501a);
    }

    private void g(AdRequest adRequest, e eVar) {
        eVar.c(adRequest.getRefresh());
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.a c() {
        return this.f4507e;
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new C0017a();
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.k.a aVar = this.f4507e;
        return aVar != null ? b.d.e.a.a.c(aVar.a()) : adExtras;
    }

    @Override // b.d.e.a.i.a, b.d.e.a.g
    public boolean recycle() {
        com.martian.ttbook.b.c.a.a.c.k.a aVar = this.f4507e;
        if (aVar == null) {
            return true;
        }
        aVar.b();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show() {
        com.martian.ttbook.b.c.a.a.c.k.a aVar = this.f4507e;
        if (aVar == null) {
            return false;
        }
        aVar.show();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.c.k.a aVar = this.f4507e;
        if (aVar == null) {
            return false;
        }
        aVar.a(viewGroup);
        return true;
    }
}
