package com.bytedance.sdk.openadsdk.i.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: classes2.dex */
public class b implements Bridge {

    /* renamed from: a */
    private ValueSet f8208a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTFeedAd.VideoRewardListener f8209b;

    public b(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.f8209b = videoRewardListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8209b == null) {
            return null;
        }
        if (i10 == 163101) {
            this.f8209b.onFeedRewardCountDown(valueSet.intValue(0));
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8208a;
    }
}
