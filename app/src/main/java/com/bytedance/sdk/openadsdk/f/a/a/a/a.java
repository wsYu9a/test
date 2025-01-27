package com.bytedance.sdk.openadsdk.f.a.a.a;

import com.bykv.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* loaded from: classes2.dex */
public class a implements Bridge {

    /* renamed from: a */
    private ValueSet f8189a = b.f7416a;

    /* renamed from: b */
    private final TTAdDislike.DislikeInteractionCallback f8190b;

    public a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f8190b = dislikeInteractionCallback;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.f8190b;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i10) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                this.f8190b.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), valueSet.booleanValue(2));
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8189a;
    }
}
