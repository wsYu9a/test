package com.bytedance.sdk.openadsdk.b.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* loaded from: classes2.dex */
public class c implements Bridge {

    /* renamed from: a */
    private ValueSet f8093a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final CSJSplashAd.SplashClickEyeListener f8094b;

    public c(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.f8094b = splashClickEyeListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.f8094b;
        if (splashClickEyeListener == null) {
            return null;
        }
        switch (i10) {
            case 113101:
                this.f8094b.onSplashClickEyeReadyToShow(new com.bytedance.sdk.openadsdk.c.a.a.b((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 113102:
                splashClickEyeListener.onSplashClickEyeClick();
                break;
            case 113103:
                splashClickEyeListener.onSplashClickEyeClose();
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8093a;
    }
}
