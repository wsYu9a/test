package com.vivo.mobilead.nativead;

import android.app.Activity;
import com.vivo.ad.model.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.util.x0;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a extends com.vivo.mobilead.a {

    /* renamed from: h */
    protected NativeAdListener f29600h;

    /* renamed from: i */
    protected NativeAdParams f29601i;

    public a(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams.getPositionId(), null);
        this.f29600h = nativeAdListener;
        this.f29601i = nativeAdParams;
    }

    public abstract void a();

    public void a(List<NativeResponse> list) {
        NativeAdListener nativeAdListener = this.f29600h;
        if (nativeAdListener != null) {
            nativeAdListener.onADLoaded(list);
        }
    }

    protected void b(NativeResponse nativeResponse) {
        NativeAdListener nativeAdListener = this.f29600h;
        if (nativeAdListener != null) {
            nativeAdListener.onAdShow(nativeResponse);
        }
    }

    protected void a(AdError adError) {
        if (adError != null) {
            x0.a("BaseNativeAdWrap", "AdFailure:" + adError);
        }
        NativeAdListener nativeAdListener = this.f29600h;
        if (nativeAdListener != null) {
            nativeAdListener.onNoAD(adError);
        }
    }

    protected void a(NativeResponse nativeResponse) {
        NativeAdListener nativeAdListener = this.f29600h;
        if (nativeAdListener != null) {
            nativeAdListener.onClick(nativeResponse);
        }
    }
}
