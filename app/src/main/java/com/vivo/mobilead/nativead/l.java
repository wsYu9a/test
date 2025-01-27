package com.vivo.mobilead.nativead;

import android.app.Activity;
import com.vivo.ad.model.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.util.VOpenLog;
import java.util.List;

/* loaded from: classes4.dex */
public class l extends com.vivo.mobilead.nativead.a {
    private static final String k = "l";

    /* renamed from: j */
    private com.vivo.ad.nativead.b f29656j;

    class a implements NativeAdListener {
        a() {
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onADLoaded(List<NativeResponse> list) {
            l.this.a(list);
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onAdShow(NativeResponse nativeResponse) {
            l.this.b(nativeResponse);
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onClick(NativeResponse nativeResponse) {
            l.this.a(nativeResponse);
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                VOpenLog.d(l.k, "no ad:" + adError.getErrorCode() + " " + adError.getErrorMsg());
            }
            l.this.a(adError);
        }
    }

    public l(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams, nativeAdListener);
        this.f29656j = new com.vivo.ad.nativead.b(activity, nativeAdParams, new a());
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a() {
        com.vivo.ad.nativead.b bVar = this.f29656j;
        if (bVar != null) {
            bVar.a();
        }
    }
}
