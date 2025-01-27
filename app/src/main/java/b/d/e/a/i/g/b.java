package b.d.e.a.i.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import b.d.e.a.e;
import com.martian.ttbook.b.c.a.a.c.d;
import com.martian.ttbook.b.c.a.a.c.o.c;
import com.martian.ttbook.b.c.a.a.c.q.b;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.video.RewardVideoAdListener;
import com.martian.ttbook.sdk.client.video.RewardVideoAdListener2;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends b.d.e.a.i.a {

    /* renamed from: e */
    private com.martian.ttbook.b.c.a.a.c.o.a f4528e;

    /* renamed from: f */
    private AtomicBoolean f4529f;

    class a implements com.martian.ttbook.b.c.a.a.c.o.b {
        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(d dVar) {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void b() {
            if (((b.d.e.a.i.a) b.this).f4504d.isOnlyLoadAdData()) {
                return;
            }
            b.this.show();
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onAdClicked() {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdClicked();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onAdDismissed() {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onAdExposed() {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdExposure();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.o.a> list) {
            if (list != null && list.size() > 0) {
                b.this.f4528e = list.get(0);
            }
            if (b.this.f4528e == null) {
                if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                    ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdError(new AdError(-1, "广告请求失败！"));
                }
            } else {
                if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener2) {
                    ((RewardVideoAdListener2) ((b.d.e.a.i.a) b.this).f4503c).onAdLoaded(b.this);
                }
                if (((b.d.e.a.i.a) b.this).f4504d.isOnlyLoadAdData()) {
                    return;
                }
                b.this.show();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onAdShow() {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdShow();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onReward() {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onReward();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onReward(Map map) {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onReward();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.o.b
        public void onVideoComplete() {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof RewardVideoAdListener) {
                ((RewardVideoAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdVideoCompleted();
            }
        }
    }

    public b(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        this.f4529f = new AtomicBoolean();
        g(adRequest, this.f4501a);
    }

    private void g(AdRequest adRequest, e eVar) {
        eVar.g(new b.C0342b().b(!adRequest.isVolumnOn()).c());
        if (TextUtils.isEmpty(adRequest.getUserID())) {
            return;
        }
        c cVar = new c();
        cVar.h(adRequest.getUserID());
        cVar.b(adRequest.getRewardAmount());
        cVar.f(adRequest.getRewardName());
        cVar.d(adRequest.getCustomData());
        eVar.f(cVar);
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.a c() {
        return this.f4528e;
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new a();
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public AdExtras getAdExtras() {
        AdExtras adExtras = AdExtras.EMPTY;
        com.martian.ttbook.b.c.a.a.c.o.a aVar = this.f4528e;
        return aVar != null ? b.d.e.a.a.c(aVar.a()) : adExtras;
    }

    @Override // b.d.e.a.i.a, b.d.e.a.g
    public boolean recycle() {
        if (this.f4528e == null) {
            return true;
        }
        this.f4528e = null;
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show() {
        if (this.f4528e != null && this.f4529f.compareAndSet(false, true)) {
            this.f4528e.show();
        }
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(Activity activity) {
        if (this.f4528e != null && this.f4529f.compareAndSet(false, true)) {
            this.f4528e.show(activity);
        }
        return true;
    }

    @Override // b.d.e.a.i.a, com.martian.ttbook.sdk.client.AdController
    public boolean show(ViewGroup viewGroup) {
        return show();
    }
}
