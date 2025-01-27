package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;

/* loaded from: classes2.dex */
public class p implements TTRewardVideoAd {

    /* renamed from: a */
    private final Bridge f8114a;

    public p(Bridge bridge) {
        this.f8114a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.f8114a.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.f8114a.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f8114a.values().objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.f8114a.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, d10);
        a10.a(1, str);
        a10.a(2, str2);
        this.f8114a.call(210102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f8114a.call(210104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f8114a.call(120104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8114a.call(210103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.m.a.a.a.a(rewardAdInteractionListener));
        this.f8114a.call(120101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.m.a.a.a.b(rewardAdPlayAgainController));
        this.f8114a.call(120103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.m.a.a.a.a(rewardAdInteractionListener));
        this.f8114a.call(120102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, z10);
        this.f8114a.call(120107, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        this.f8114a.call(120105, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8114a.call(210101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, activity);
        a10.a(1, ritScenes);
        a10.a(2, str);
        this.f8114a.call(120106, a10.b(), Void.class);
    }
}
