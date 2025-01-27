package com.bytedance.sdk.openadsdk.live.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* loaded from: classes2.dex */
public class b implements ILiveHostActionParam {

    /* renamed from: a */
    private Bridge f8229a;

    public b(Bridge bridge) {
        this.f8229a = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z10, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.f8229a;
        if (bridge != null) {
            bridge.call(1, com.bykv.a.a.a.a.b.a().a(0, z10).a(1, str).a(2, str2).a(3, map).b(), null);
        }
    }
}
