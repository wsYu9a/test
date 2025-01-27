package com.bytedance.sdk.openadsdk.c.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class b implements Bridge {

    /* renamed from: a */
    private ValueSet f8116a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTAdNative.CSJSplashAdListener f8117b;

    public b(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f8117b = cSJSplashAdListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8117b == null) {
            return null;
        }
        switch (i10) {
            case 114102:
                Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
                com.bytedance.sdk.openadsdk.c.a.a.b bVar = new com.bytedance.sdk.openadsdk.c.a.a.b(bridge);
                if (bridge != null) {
                    try {
                        if (bridge.values().intValue(1) >= 5700) {
                            this.f8117b.onSplashLoadSuccess(bVar);
                        } else {
                            Method declaredMethod = this.f8117b.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(this.f8117b, null);
                            }
                        }
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        break;
                    }
                }
                break;
            case 114103:
                this.f8117b.onSplashLoadFail(new com.bytedance.sdk.openadsdk.c.a.a.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.f8117b.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.c.a.a.b((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.f8117b.onSplashRenderFail(new com.bytedance.sdk.openadsdk.c.a.a.b((Bridge) valueSet.objectValue(0, Bridge.class)), new com.bytedance.sdk.openadsdk.c.a.a.a((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8116a;
    }
}
