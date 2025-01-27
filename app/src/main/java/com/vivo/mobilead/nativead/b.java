package com.vivo.mobilead.nativead;

import android.app.Activity;
import com.vivo.ad.model.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.nativead.a {

    /* renamed from: j */
    private com.vivo.ad.nativead.b f29602j;
    private List<NativeResponse> k;

    class a implements NativeAdListener {
        a() {
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onADLoaded(List<NativeResponse> list) {
            b.this.k.addAll(list);
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onAdShow(NativeResponse nativeResponse) {
            b.this.b(nativeResponse);
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onClick(NativeResponse nativeResponse) {
            b.this.a(nativeResponse);
        }

        @Override // com.vivo.ad.nativead.NativeAdListener
        public void onNoAD(AdError adError) {
        }
    }

    public b(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams, nativeAdListener);
        this.k = new ArrayList();
        this.f29602j = new com.vivo.ad.nativead.b(activity, nativeAdParams, new a());
    }

    @Override // com.vivo.mobilead.a
    public void b(String str) {
        com.vivo.ad.nativead.b bVar = this.f29602j;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a() {
        com.vivo.ad.nativead.b bVar = this.f29602j;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a(List<NativeResponse> list) {
        super.a(this.k);
    }

    @Override // com.vivo.mobilead.a
    public void a(com.vivo.mobilead.g.b bVar) {
        com.vivo.ad.nativead.b bVar2 = this.f29602j;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }
}
