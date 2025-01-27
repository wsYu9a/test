package com.bytedance.sdk.openadsdk.c.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class a implements Bridge {

    /* renamed from: a */
    private ValueSet f8118a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTAdInteractionListener f8119b;

    public a(TTAdInteractionListener tTAdInteractionListener) {
        this.f8119b = tTAdInteractionListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8119b == null) {
            return null;
        }
        if (i10 == 100101) {
            this.f8119b.onAdEvent(valueSet.intValue(0), (Map) valueSet.objectValue(1, Map.class));
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8118a;
    }
}
