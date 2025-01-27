package com.vivo.ad.nativead;

import com.vivo.ad.model.AdError;
import com.vivo.mobilead.util.VOpenLog;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements NativeAdListener {

    /* renamed from: a */
    private NativeAdListener f26988a;

    public e(NativeAdListener nativeAdListener) {
        this.f26988a = nativeAdListener;
    }

    @Override // com.vivo.ad.nativead.NativeAdListener
    public void onADLoaded(List<NativeResponse> list) {
        try {
            this.f26988a.onADLoaded(list);
        } catch (Throwable th) {
            VOpenLog.w("SafeNativeAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.ad.nativead.NativeAdListener
    public void onAdShow(NativeResponse nativeResponse) {
        try {
            this.f26988a.onAdShow(nativeResponse);
        } catch (Throwable th) {
            VOpenLog.w("SafeNativeAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.ad.nativead.NativeAdListener
    public void onClick(NativeResponse nativeResponse) {
        try {
            this.f26988a.onClick(nativeResponse);
        } catch (Throwable th) {
            VOpenLog.w("SafeNativeAdListener", "" + th.getMessage());
        }
    }

    @Override // com.vivo.ad.nativead.NativeAdListener
    public void onNoAD(AdError adError) {
        try {
            this.f26988a.onNoAD(adError);
        } catch (Throwable th) {
            VOpenLog.w("SafeNativeAdListener", "" + th.getMessage());
        }
    }
}
