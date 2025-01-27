package com.bytedance.sdk.openadsdk.d.a.a.a.a;

import android.os.Bundle;
import com.bykv.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: classes2.dex */
public class a implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* renamed from: a */
    private final Bridge f8142a;

    public a(Bridge bridge) {
        this.f8142a = bridge == null ? b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        b a10 = b.a(1);
        a10.a(0, bundle);
        this.f8142a.call(123101, a10.b(), Void.class);
    }
}
