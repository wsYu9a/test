package com.wbl.ad.yzz.adapter.c;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.comm.util.AdError;

/* loaded from: classes5.dex */
public final class c implements NativeADMediaListener {
    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16026, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16025, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16028, this, adError);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16027, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16022, this, Integer.valueOf(i2));
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16021, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16024, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16023, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16018, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16017, this, null);
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16020, this, null);
    }
}
