package com.sigmob.windad.Splash;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.sdk.splash.g;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.umeng.analytics.pro.k;
import java.util.Map;

/* loaded from: classes4.dex */
public final class WindSplashAD extends j implements WindSplashADListener, AdLifecycleManager.LifecycleListener {
    public AdStatus adStatus;

    /* renamed from: j */
    public WindSplashADListener f20835j;

    /* renamed from: k */
    public ViewGroup f20836k;

    /* renamed from: l */
    public int f20837l;

    /* renamed from: m */
    public RelativeLayout f20838m;

    /* renamed from: n */
    public boolean f20839n;

    /* renamed from: o */
    public boolean f20840o;

    /* renamed from: p */
    public boolean f20841p;

    /* renamed from: q */
    public g f20842q;

    /* renamed from: r */
    public Handler f20843r;

    /* renamed from: com.sigmob.windad.Splash.WindSplashAD$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WindSplashAD.this.f20842q.a(WindSplashAD.this.f20838m);
        }
    }

    /* renamed from: com.sigmob.windad.Splash.WindSplashAD$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WindAdError f20845a;

        /* renamed from: b */
        public final /* synthetic */ String f20846b;

        public AnonymousClass2(WindAdError windAdError, String str) {
            windAdError = windAdError;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WindSplashAD.this.f20835j != null) {
                WindSplashAD.this.f20840o = true;
                WindSplashAD.this.f20835j.onSplashAdLoadFail(windAdError, str);
            }
        }
    }

    /* renamed from: com.sigmob.windad.Splash.WindSplashAD$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f20848a;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WindSplashAD.this.f20835j != null) {
                WindSplashAD.this.f20835j.onSplashAdLoadSuccess(str);
            }
            if (WindSplashAD.this.f20841p) {
                WindSplashAD.this.i();
            }
        }
    }

    /* renamed from: com.sigmob.windad.Splash.WindSplashAD$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WindAdError f20850a;

        /* renamed from: b */
        public final /* synthetic */ String f20851b;

        public AnonymousClass4(WindAdError windAdError, String str) {
            windAdError = windAdError;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WindSplashAD.this.f20835j != null) {
                WindSplashAD.this.f20835j.onSplashAdLoadFail(windAdError, str);
            }
        }
    }

    /* renamed from: com.sigmob.windad.Splash.WindSplashAD$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WindAdError f20853a;

        /* renamed from: b */
        public final /* synthetic */ String f20854b;

        public AnonymousClass5(WindAdError windAdError, String str) {
            windAdError = windAdError;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WindSplashAD.this.f20835j != null) {
                WindSplashAD.this.f20835j.onSplashAdShowError(windAdError, str);
            }
        }
    }

    /* renamed from: com.sigmob.windad.Splash.WindSplashAD$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WindAdError f20856a;

        public AnonymousClass6(WindAdError windAdError) {
            windAdError = windAdError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WindSplashAD.this.f20835j != null) {
                WindSplashAD.this.f20835j.onSplashAdLoadFail(windAdError, WindSplashAD.this.b());
            }
        }
    }

    public WindSplashAD(WindSplashAdRequest windSplashAdRequest, WindSplashADListener windSplashADListener) {
        super(windSplashAdRequest, false);
        this.adStatus = AdStatus.AdStatusNone;
        this.f20837l = 5;
        this.f20840o = false;
        this.f20835j = windSplashADListener;
        this.f20843r = new Handler(Looper.getMainLooper());
        this.f20842q = new g(windSplashAdRequest, this);
        this.f20837l = windSplashAdRequest.getFetchDelay();
        this.f20839n = windSplashAdRequest.isDisableAutoHideAd();
    }

    public void destroy() {
        WindAdRequest windAdRequest = this.f18160e;
        SigmobLog.i(String.format("splash ad  %s is Destroy", windAdRequest != null ? windAdRequest.getPlacementId() : "null"));
        g gVar = this.f20842q;
        if (gVar != null) {
            gVar.a();
            this.f20843r.removeCallbacksAndMessages(null);
            RelativeLayout relativeLayout = this.f20838m;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                this.f20838m.removeAllViews();
                this.f20838m = null;
            }
            ViewGroup viewGroup = this.f20836k;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f20836k = null;
            }
            this.f20835j = null;
            this.f20836k = null;
        }
    }

    public final boolean g() {
        if (!loadAdFilter()) {
            return false;
        }
        AdLifecycleManager.getInstance().addLifecycleListener(this);
        this.adStatus = AdStatus.AdStatusLoading;
        if (!this.f20842q.k()) {
            d();
        }
        this.f20842q.a(getBid_token(), getBidFloor(), getCurrency(), this.f20837l, false);
        return true;
    }

    @Override // com.sigmob.sdk.base.j
    public String getEcpm() {
        g gVar = this.f20842q;
        if (gVar != null) {
            return gVar.h();
        }
        return null;
    }

    public final void h() {
        if (this.f20839n) {
            return;
        }
        RelativeLayout relativeLayout = this.f20838m;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            this.f20838m.removeAllViews();
            this.f20838m = null;
        }
        ViewGroup viewGroup = this.f20836k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f20836k = null;
        }
    }

    public final void i() {
        if (this.f20842q == null) {
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, b());
            return;
        }
        f();
        RelativeLayout relativeLayout = this.f20838m;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.f20843r.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WindSplashAD.this.f20842q.a(WindSplashAD.this.f20838m);
            }
        });
        this.adStatus = AdStatus.AdStatusPlaying;
    }

    public boolean isReady() {
        return this.adStatus == AdStatus.AdStatusReady && this.f20842q.k();
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd() {
        this.f20841p = false;
        super.loadAd();
        return g();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd();
        this.f20836k = viewGroup;
        this.f20841p = true;
        g();
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onCreate(Activity activity) {
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onDestroy(Activity activity) {
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onPause(Activity activity) {
        g gVar = this.f20842q;
        if (gVar != null) {
            gVar.a(activity);
        }
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onResume(Activity activity) {
        g gVar = this.f20842q;
        if (gVar != null) {
            gVar.b(activity);
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClick(String str) {
        WindSplashADListener windSplashADListener = this.f20835j;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClick(str);
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClose(String str) {
        this.adStatus = AdStatus.AdStatusClose;
        WindSplashADListener windSplashADListener = this.f20835j;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdClose(str);
        }
        h();
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadFail(WindAdError windAdError, String str) {
        this.adStatus = AdStatus.AdStatusNone;
        this.f20843r.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.4

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20850a;

            /* renamed from: b */
            public final /* synthetic */ String f20851b;

            public AnonymousClass4(WindAdError windAdError2, String str2) {
                windAdError = windAdError2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.f20835j != null) {
                    WindSplashAD.this.f20835j.onSplashAdLoadFail(windAdError, str);
                }
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadSuccess(String str) {
        this.adStatus = AdStatus.AdStatusReady;
        this.f20843r.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.3

            /* renamed from: a */
            public final /* synthetic */ String f20848a;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.f20835j != null) {
                    WindSplashAD.this.f20835j.onSplashAdLoadSuccess(str);
                }
                if (WindSplashAD.this.f20841p) {
                    WindSplashAD.this.i();
                }
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShow(String str) {
        WindSplashADListener windSplashADListener = this.f20835j;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdShow(str);
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShowError(WindAdError windAdError, String str) {
        this.adStatus = AdStatus.AdStatusNone;
        this.f20843r.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.5

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20853a;

            /* renamed from: b */
            public final /* synthetic */ String f20854b;

            public AnonymousClass5(WindAdError windAdError2, String str2) {
                windAdError = windAdError2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.f20835j != null) {
                    WindSplashAD.this.f20835j.onSplashAdShowError(windAdError, str);
                }
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdSkip(String str) {
        WindSplashADListener windSplashADListener = this.f20835j;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdSkip(str);
        }
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onStart(Activity activity) {
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onStop(Activity activity) {
    }

    public void show(ViewGroup viewGroup) {
        if (this.f20841p) {
            return;
        }
        if (this.adStatus != AdStatus.AdStatusReady) {
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, b());
        } else if (viewGroup == null) {
            onSplashAdShowError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL, b());
        } else {
            this.f20836k = viewGroup;
            i();
        }
    }

    public final void e() {
        Activity b10;
        ViewGroup viewGroup = this.f20836k;
        if (viewGroup == null || (b10 = e.b(viewGroup)) == null) {
            return;
        }
        Window window = b10.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = k.f23995b;
        window.setAttributes(attributes);
        window.addFlags(1024);
    }

    public final void f() {
        if (this.f20836k != null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f20836k.getContext());
            this.f20838m = relativeLayout;
            relativeLayout.setVisibility(4);
            this.f20838m.setId(ClientMetadata.generateViewId());
            this.f20836k.addView(this.f20838m, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.sigmob.sdk.base.j
    public boolean loadAd(String str) {
        super.loadAd(str);
        return g();
    }

    public void loadAndShow(String str, ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd(str);
        this.f20836k = viewGroup;
        this.f20841p = true;
        g();
    }

    @Override // com.sigmob.sdk.base.j
    public void a(String str, String str2) {
        g gVar = this.f20842q;
        if (gVar != null) {
            gVar.a(str, str2);
        }
    }

    @Override // com.sigmob.sdk.base.j
    public Map<String, BiddingResponse> a() {
        g gVar = this.f20842q;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.j
    public void a(WindAdError windAdError) {
        this.adStatus = AdStatus.AdStatusNone;
        this.f20843r.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.6

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20856a;

            public AnonymousClass6(WindAdError windAdError2) {
                windAdError = windAdError2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.f20835j != null) {
                    WindSplashAD.this.f20835j.onSplashAdLoadFail(windAdError, WindSplashAD.this.b());
                }
            }
        });
    }

    public final void a(WindAdError windAdError, String str) {
        SigmobLog.e("onSplashError: " + windAdError + " :placementId: " + str);
        if (this.f20840o) {
            return;
        }
        this.f20843r.removeMessages(1);
        this.f20843r.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD.2

            /* renamed from: a */
            public final /* synthetic */ WindAdError f20845a;

            /* renamed from: b */
            public final /* synthetic */ String f20846b;

            public AnonymousClass2(WindAdError windAdError2, String str2) {
                windAdError = windAdError2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WindSplashAD.this.f20835j != null) {
                    WindSplashAD.this.f20840o = true;
                    WindSplashAD.this.f20835j.onSplashAdLoadFail(windAdError, str);
                }
            }
        });
        h();
    }
}
