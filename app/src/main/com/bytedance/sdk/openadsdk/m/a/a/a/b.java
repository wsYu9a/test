package com.bytedance.sdk.openadsdk.m.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: classes2.dex */
public class b implements Bridge {

    /* renamed from: a */
    private ValueSet f8246a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTRewardVideoAd.RewardAdPlayAgainController f8247b;

    public b(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.f8247b = rewardAdPlayAgainController;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8247b == null) {
            return null;
        }
        if (i10 == 122101) {
            this.f8247b.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.d.a.a.a.a.a((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8246a;
    }
}
