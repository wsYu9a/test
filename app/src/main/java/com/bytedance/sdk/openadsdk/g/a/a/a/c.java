package com.bytedance.sdk.openadsdk.g.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.a.a.l;

/* loaded from: classes2.dex */
public class c implements Bridge {

    /* renamed from: a */
    private ValueSet f8195a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTAdNative.FullScreenVideoAdListener f8196b;

    public c(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f8196b = fullScreenVideoAdListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.f8196b;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i10) {
            case 132101:
                this.f8196b.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.f8196b.onFullScreenVideoAdLoad(new l((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.f8196b.onFullScreenVideoCached(new l((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8195a;
    }
}
