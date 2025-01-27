package com.bytedance.sdk.openadsdk.k.a.a.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* loaded from: classes2.dex */
public class c implements Bridge {

    /* renamed from: a */
    private ValueSet f8216a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTNativeAd.ExpressRenderListener f8217b;

    public c(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.f8217b = expressRenderListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8217b == null) {
            return null;
        }
        if (i10 == 142101) {
            this.f8217b.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8216a;
    }
}
