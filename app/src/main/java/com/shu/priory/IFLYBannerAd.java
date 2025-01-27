package com.shu.priory;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYAdListener;
import com.shu.priory.utils.h;
import com.shu.priory.utils.i;
import com.shu.priory.view.AdLayout;
import com.shu.priory.view.BannerAdView;
import l5.c;

/* loaded from: classes3.dex */
public class IFLYBannerAd extends AdLayout {

    /* renamed from: a */
    public BannerAdView f16784a;

    private IFLYBannerAd(Context context, String str) {
        super(context);
        this.f16784a = new BannerAdView(context, this, str, this.f17403b);
    }

    public static synchronized IFLYBannerAd createBannerAd(Context context, String str) {
        synchronized (IFLYBannerAd.class) {
            if (!TextUtils.isEmpty(str) && context != null) {
                if (i.a(context)) {
                    return new IFLYBannerAd(context, str);
                }
                h.a(SDKConstants.TAG, "please check your uses-permission");
                return null;
            }
            h.a(SDKConstants.TAG, "Ad constructor parameters error!");
            return null;
        }
    }

    @Override // com.shu.priory.view.AdLayout
    public synchronized void destroy() {
        super.destroy();
        BannerAdView bannerAdView = this.f16784a;
        if (bannerAdView != null) {
            bannerAdView.k();
            this.f16784a = null;
        }
    }

    public double getPrice() {
        try {
            return this.f16784a.getPrice();
        } catch (Exception unused) {
            return c.f27899e;
        }
    }

    public synchronized void loadAd(IFLYAdListener iFLYAdListener) {
        BannerAdView bannerAdView = this.f16784a;
        if (bannerAdView != null) {
            bannerAdView.a(iFLYAdListener);
        }
    }

    public void setParameter(String str, Object obj) {
        BannerAdView bannerAdView = this.f16784a;
        if (bannerAdView != null) {
            bannerAdView.a(str, obj);
        }
    }

    public synchronized void showAd() {
        BannerAdView bannerAdView = this.f16784a;
        if (bannerAdView != null) {
            bannerAdView.f();
        }
    }
}
