package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.List;

/* loaded from: classes5.dex */
public final class h implements b {

    public static final class a implements BaiduNativeManager.FeedAdListener {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33706a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f33707b;

        /* renamed from: c */
        public final /* synthetic */ c f33708c;

        public a(com.wbl.ad.yzz.network.b.b.b bVar, com.wbl.ad.yzz.innerconfig.d.d dVar, c cVar) {
            this.f33706a = bVar;
            this.f33707b = dVar;
            this.f33708c = cVar;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10452, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10451, this, Integer.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10542, this, list);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10541, this, Integer.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10544, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10543, this, null);
        }
    }

    @Override // com.wbl.ad.yzz.network.c.e.b
    public void a(com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10538, this, dVar, context, bVar, str, cVar, cVar2);
    }
}
