package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.List;

/* loaded from: classes5.dex */
public final class i implements b {

    public static final class a implements TTAdNative.FeedAdListener {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33709a;

        /* renamed from: b */
        public final /* synthetic */ c f33710b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f33711c;

        public a(com.wbl.ad.yzz.network.b.b.b bVar, c cVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f33709a = bVar;
            this.f33710b = cVar;
            this.f33711c = dVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10537, this, Integer.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10540, this, list);
        }
    }

    @Override // com.wbl.ad.yzz.network.c.e.b
    public void a(com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10539, this, dVar, context, bVar, str, cVar, cVar2);
    }
}
