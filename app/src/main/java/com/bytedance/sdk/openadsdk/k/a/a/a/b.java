package com.bytedance.sdk.openadsdk.k.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b implements Bridge {

    /* renamed from: a */
    private ValueSet f8214a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTNativeAd.EasyPlayWidgetListener f8215b;

    public b(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.f8215b = easyPlayWidgetListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener = this.f8215b;
        if (easyPlayWidgetListener == null) {
            return null;
        }
        switch (i10) {
            case 144101:
                this.f8215b.onInfo((JSONObject) valueSet.objectValue(0, JSONObject.class));
                break;
            case 144102:
                return (T) easyPlayWidgetListener.getEstimatedInteractionArea();
            case 144103:
                this.f8215b.onCanRenderSuccess((JSONObject) valueSet.objectValue(0, JSONObject.class));
                break;
            case 144104:
                this.f8215b.onCanRenderFail((JSONObject) valueSet.objectValue(0, JSONObject.class));
                break;
            case 144105:
                easyPlayWidgetListener.onClose();
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8214a;
    }
}
