package com.bytedance.sdk.openadsdk.g.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.a.a.p;

/* loaded from: classes2.dex */
public class f implements Bridge {

    /* renamed from: a */
    private ValueSet f8201a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTAdNative.RewardVideoAdListener f8202b;

    public f(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f8202b = rewardVideoAdListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.f8202b;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i10) {
            case 124101:
                this.f8202b.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.f8202b.onRewardVideoAdLoad(new p((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.f8202b.onRewardVideoCached(new p((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8201a;
    }
}
