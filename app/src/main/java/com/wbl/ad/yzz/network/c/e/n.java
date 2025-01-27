package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* loaded from: classes5.dex */
public final class n implements b {

    public static final class a implements NativeADUnifiedListener {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33722a;

        /* renamed from: b */
        public final /* synthetic */ c f33723b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f33724c;

        public a(com.wbl.ad.yzz.network.b.b.b bVar, c cVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f33722a = bVar;
            this.f33723b = cVar;
            this.f33724c = dVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10547, this, list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10510, this, adError);
        }
    }

    @Override // com.wbl.ad.yzz.network.c.e.b
    public void a(com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10509, this, dVar, context, bVar, str, cVar, cVar2);
    }
}
