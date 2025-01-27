package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class s3 {

    /* renamed from: a */
    public Context f3361a;

    /* renamed from: b */
    public VlionAdapterADConfig f3362b;

    /* renamed from: c */
    public v3 f3363c;

    /* renamed from: d */
    public VlionBiddingActionListener f3364d;

    public s3(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3361a = context;
        this.f3362b = vlionAdapterADConfig;
    }

    public final void a(Activity activity) {
        if (activity != null) {
            try {
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                    v3 v3Var = this.f3363c;
                    if (v3Var != null) {
                        v3Var.a(activity);
                        return;
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = this.f3364d;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderFailure(20008, "vlionInterstitialAdManager is null");
                    }
                    VlionSDkManager.getInstance().upLoadCatchException(new Throwable("vlionInterstitialAdManager is null vlionBiddingListener"));
                    LogVlion.e("vlionInterstitialAdManager is null");
                    return;
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        }
        VlionBiddingActionListener vlionBiddingActionListener2 = this.f3364d;
        if (vlionBiddingActionListener2 != null) {
            vlionBiddingActionListener2.onAdRenderFailure(20008, "Context is null");
        }
        VlionSDkManager.getInstance().upLoadCatchException(new Throwable("VlionCustomInterstitialAd showInterstitial  context is null"));
        LogVlion.e("showInterstitial  context is null");
    }

    public final void a() {
        VlionCustomInterstitialActivity vlionCustomInterstitialActivity;
        try {
            v3 v3Var = this.f3363c;
            if (v3Var != null) {
                try {
                    f7 f7Var = v3Var.f3457e;
                    if (f7Var != null) {
                        f7Var.a();
                        v3Var.f3457e = null;
                    }
                    WeakReference<VlionCustomInterstitialActivity> weakReference = VlionCustomInterstitialActivity.H;
                    if (weakReference != null && (vlionCustomInterstitialActivity = weakReference.get()) != null) {
                        vlionCustomInterstitialActivity.finish();
                    }
                    if (v3Var.f3459g != null) {
                        v3Var.f3459g = null;
                    }
                    if (v3Var.f3458f != null) {
                        v3Var.f3458f = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f3363c = null;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener) {
        try {
            VlionAdapterADConfig vlionAdapterADConfig = this.f3362b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomInterstitialAd loadAd: vlionAdapterADConfig is null");
                if (vlionBiddingLoadListener != null) {
                    i1 i1Var = i1.f2918h;
                    vlionBiddingLoadListener.onAdLoadFailure(i1Var.f2920a, i1Var.f2921b);
                    return;
                }
                return;
            }
            i1 a10 = m1.a(vlionAdapterADConfig);
            if (a10 != null) {
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(a10.f2920a, a10.f2921b);
                    return;
                }
                return;
            }
            v3 v3Var = new v3(this.f3361a, this.f3362b);
            this.f3363c = v3Var;
            try {
                LogVlion.e("loadData=");
                f4.a(4, v3Var.f3458f, new t3(v3Var, vlionBiddingLoadListener));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
