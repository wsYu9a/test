package com.shu.priory;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYAdListener;
import com.shu.priory.utils.h;
import com.shu.priory.utils.i;
import com.shu.priory.view.AdLayout;
import com.shu.priory.view.InterstitialAdView;
import l5.c;

/* loaded from: classes3.dex */
public class IFLYInterstitialAd extends AdLayout {

    /* renamed from: a */
    public InterstitialAdView f16785a;

    private IFLYInterstitialAd(Context context, String str) {
        super(context);
        this.f16785a = new InterstitialAdView(context, this, str, this.f17403b);
    }

    public static synchronized IFLYInterstitialAd createInterstitialAd(Context context, String str) {
        synchronized (IFLYInterstitialAd.class) {
            if (!TextUtils.isEmpty(str) && context != null) {
                if (i.a(context)) {
                    return new IFLYInterstitialAd(context, str);
                }
                h.a(SDKConstants.TAG, "please check your uses-permission");
                return null;
            }
            h.a(SDKConstants.TAG, "Ad constructor parameters error!");
            return null;
        }
    }

    @Override // com.shu.priory.view.AdLayout
    public void destroy() {
        super.destroy();
        InterstitialAdView interstitialAdView = this.f16785a;
        if (interstitialAdView != null) {
            interstitialAdView.k();
            this.f16785a = null;
        }
    }

    public double getPrice() {
        try {
            return this.f16785a.getPrice();
        } catch (Exception unused) {
            return c.f27899e;
        }
    }

    public synchronized void loadAd(IFLYAdListener iFLYAdListener) {
        InterstitialAdView interstitialAdView = this.f16785a;
        if (interstitialAdView != null) {
            interstitialAdView.a(iFLYAdListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setParameter(String str, Object obj) {
        InterstitialAdView interstitialAdView = this.f16785a;
        if (interstitialAdView != null) {
            interstitialAdView.a(str, obj);
        }
    }

    public synchronized void showAd() {
        InterstitialAdView interstitialAdView = this.f16785a;
        if (interstitialAdView != null) {
            interstitialAdView.f();
        }
    }
}
