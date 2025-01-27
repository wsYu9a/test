package com.bytedance.sdk.openadsdk.live;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.callback.Callback;

/* loaded from: classes2.dex */
public class a implements Callback<Object> {

    /* renamed from: a */
    private Bridge f8224a;

    public a(Bridge bridge) {
        this.f8224a = bridge;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        Bridge bridge = this.f8224a;
        if (bridge != null) {
            bridge.call(1, com.bykv.a.a.a.a.b.a().a(0, obj).b(), null);
        }
    }
}
