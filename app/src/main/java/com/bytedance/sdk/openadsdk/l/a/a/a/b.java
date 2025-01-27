package com.bytedance.sdk.openadsdk.l.a.a.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: classes2.dex */
public class b implements Bridge {

    /* renamed from: a */
    private ValueSet f8220a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTNativeExpressAd.ExpressAdInteractionListener f8221b;

    public b(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f8221b = expressAdInteractionListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8221b == null) {
            return null;
        }
        switch (i10) {
            case 151101:
                this.f8221b.onAdClicked((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151102:
                this.f8221b.onAdShow((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151103:
                this.f8221b.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 151104:
                this.f8221b.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2));
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8220a;
    }
}
