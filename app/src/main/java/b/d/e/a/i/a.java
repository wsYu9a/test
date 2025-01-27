package b.d.e.a.i;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import b.d.e.a.c;
import b.d.e.a.d;
import b.d.e.a.e;
import b.d.e.a.g;
import com.martian.ttbook.b.c.a.a.c.f;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.c.q.b;
import com.martian.ttbook.sdk.client.AdBiddingLossReason;
import com.martian.ttbook.sdk.client.AdController;
import com.martian.ttbook.sdk.client.AdDownloadConfirmListener;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.AdType;
import com.martian.ttbook.sdk.client.VideoAdEventListener;
import com.martian.ttbook.sdk.client.VideoSettings;

/* loaded from: classes4.dex */
public abstract class a implements g, AdController {

    /* renamed from: a */
    protected e f4501a;

    /* renamed from: b */
    protected f f4502b;

    /* renamed from: c */
    protected AdListeneable f4503c;

    /* renamed from: d */
    protected AdRequest f4504d;

    /* renamed from: b.d.e.a.i.a$a */
    static /* synthetic */ class C0016a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4505a;

        static {
            int[] iArr = new int[AdType.values().length];
            f4505a = iArr;
            try {
                iArr[AdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4505a[AdType.INFORMATION_FLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4505a[AdType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4505a[AdType.INTERSTITIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4505a[AdType.REWARD_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4505a[AdType.FULL_SCREEN_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4505a[AdType.MULTI.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4505a[AdType.REWARD_VIDEO_DOWNLOAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    protected a(AdRequest adRequest, AdListeneable adListeneable) {
        this.f4503c = adListeneable;
        this.f4504d = adRequest;
        this.f4501a = a(adRequest);
        adRequest.setRecycler(this);
    }

    private e a(AdRequest adRequest) {
        h hVar;
        AdType adType = adRequest.getAdType();
        Context activity = adRequest.getActivity();
        if (activity == null) {
            activity = adRequest.getContext();
        }
        e eVar = new e(d.a().b(activity));
        if (adRequest.getAdDownloadConfirmListener() != null) {
            eVar.c(new c(adRequest.getAdDownloadConfirmListener()));
        }
        if (adRequest.getVideoSettings() != null && adRequest.getVideoSettings() != VideoSettings.DEFAULT) {
            VideoSettings videoSettings = adRequest.getVideoSettings();
            b.C0342b c0342b = new b.C0342b();
            c0342b.a(videoSettings.getAutoPlayPolicy());
            c0342b.b(videoSettings.isAutoPlayMuted());
            c0342b.h(videoSettings.getVideoPlayPolicy());
            c0342b.e(videoSettings.isEnableDetailPage());
            c0342b.d(videoSettings.getMaxVideoDuration());
            c0342b.f(videoSettings.getMinVideoDuration());
            c0342b.g(videoSettings.isEnableUserControl());
            c0342b.i(videoSettings.isNeedCoverImage());
            c0342b.j(videoSettings.isNeedProgressBar());
            eVar.g(c0342b.c());
            VideoAdEventListener videoAdEventListener = videoSettings.getVideoAdEventListener();
            if (videoAdEventListener != null) {
                eVar.d(new b(videoAdEventListener));
            }
        }
        if (adRequest.getExtParameters() != null) {
            eVar.h(new com.martian.ttbook.b.c.a.a.a(adRequest.getExtParameters().getBundle(), adRequest.getExtParameters().getObjectMapping()));
        }
        eVar.b(adRequest.getAdRequestCount());
        eVar.b(adRequest.getCodeId());
        eVar.a(adRequest.isOnlyLoadAdData());
        eVar.a(adRequest.getAdContainer());
        switch (C0016a.f4505a[adType.ordinal()]) {
            case 1:
                hVar = h.SPLASH;
                break;
            case 2:
                hVar = h.INFORMATION_FLOW;
                break;
            case 3:
                hVar = h.BANNER;
                break;
            case 4:
                hVar = h.INTERSTITIAL;
                break;
            case 5:
                hVar = h.REWARD_VIDEO;
                break;
            case 6:
                hVar = h.FULL_SCREEN_VIDEO;
                break;
        }
        eVar.a(hVar);
        return eVar;
    }

    public f b() {
        if (this.f4502b == null) {
            this.f4501a.e(d());
            this.f4502b = this.f4501a.a();
        }
        return this.f4502b;
    }

    protected com.martian.ttbook.b.c.a.a.c.a c() {
        return null;
    }

    protected abstract com.martian.ttbook.b.c.a.a.c.e d();

    @Override // com.martian.ttbook.sdk.client.AdController
    public AdExtras getAdExtras() {
        return null;
    }

    @Override // b.d.e.a.g
    public boolean recycle() {
        return false;
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void sendLossNotification(AdBiddingLossReason adBiddingLossReason, int i2, String str) {
        com.martian.ttbook.b.c.a.a.c.a c2 = c();
        if (c2 != null) {
            c2.a(b.d.e.a.j.h.a(adBiddingLossReason), i2, str);
        }
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.c.a c2 = c();
        if (c2 != null) {
            c2.sendWinNotification(i2);
        }
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonFunction
    public void setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener) {
        com.martian.ttbook.b.c.a.a.c.a c2 = c();
        if (c2 != null) {
            c2.c(new c(adDownloadConfirmListener));
        }
    }

    @Override // com.martian.ttbook.sdk.client.AdController
    public boolean show() {
        return false;
    }

    @Override // com.martian.ttbook.sdk.client.AdController
    public boolean show(Activity activity) {
        return show();
    }

    @Override // com.martian.ttbook.sdk.client.AdController
    public boolean show(ViewGroup viewGroup) {
        return show();
    }
}
