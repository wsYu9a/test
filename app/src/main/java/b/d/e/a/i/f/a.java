package b.d.e.a.i.f;

import android.view.ViewGroup;
import b.d.e.a.e;
import com.martian.ttbook.b.c.a.a.c.d;
import com.martian.ttbook.b.c.a.a.c.p.b;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.splash.SplashAdExtListener;
import com.martian.ttbook.sdk.client.splash.SplashAdListener;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends b.d.e.a.i.a {

    /* renamed from: e */
    private com.martian.ttbook.b.c.a.a.c.p.a f4523e;

    /* renamed from: b.d.e.a.i.f.a$a */
    class C0020a implements b {
        C0020a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(d dVar) {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdListener) {
                ((SplashAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.p.b
        public void onAdClicked() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdListener) {
                ((SplashAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdClicked();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.p.b
        public void onAdDismissed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdListener) {
                ((SplashAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.p.b
        public void onAdExposed() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdListener) {
                ((SplashAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdExposure();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.p.b
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.p.a> list) {
            if (list != null && list.size() > 0) {
                a.this.f4523e = list.get(0);
            }
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdExtListener) {
                ((SplashAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdLoaded(a.this);
            }
            if (((b.d.e.a.i.a) a.this).f4504d.isOnlyLoadAdData()) {
                return;
            }
            a.this.show();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.p.b
        public void onAdSkip() {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdExtListener) {
                ((SplashAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdSkip();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.p.b
        public void onAdTick(long j2) {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof SplashAdExtListener) {
                ((SplashAdExtListener) ((b.d.e.a.i.a) a.this).f4503c).onAdTick(j2);
            }
        }
    }

    public a(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        g(adRequest, this.f4501a);
    }

    private void g(AdRequest adRequest, e eVar) {
        eVar.a(adRequest.getSkipContainer()).a(adRequest.getTimeoutMs() == 0 ? 5000 : adRequest.getTimeoutMs());
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.a c() {
        return this.f4523e;
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new C0020a();
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.p.a aVar = this.f4523e;
        return aVar != null ? b.d.e.a.a.c(aVar.a()) : adExtras;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show() {
        com.martian.ttbook.b.c.a.a.c.p.a aVar = this.f4523e;
        if (aVar == null) {
            return false;
        }
        aVar.show();
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.c.p.a aVar = this.f4523e;
        if (aVar == null) {
            return false;
        }
        aVar.a(viewGroup);
        return true;
    }
}
