package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;

/* loaded from: classes5.dex */
public final class j implements b {

    public static final class a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33712a;

        /* renamed from: b */
        public final /* synthetic */ c f33713b;

        public a(com.wbl.ad.yzz.network.b.b.b bVar, c cVar) {
            this.f33712a = bVar;
            this.f33713b = cVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10534, this, Integer.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10533, this, list);
        }
    }

    @Override // com.wbl.ad.yzz.network.c.e.b
    public void a(com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10536, this, dVar, context, bVar, str, cVar, cVar2);
    }
}
