package com.bytedance.sdk.openadsdk.l.a.a.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: classes2.dex */
public class a implements Bridge {

    /* renamed from: a */
    private ValueSet f8218a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTNativeExpressAd.AdInteractionListener f8219b;

    public a(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f8219b = adInteractionListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.AdInteractionListener adInteractionListener = this.f8219b;
        if (adInteractionListener == null) {
            return null;
        }
        switch (i10) {
            case 151101:
                this.f8219b.onAdClicked((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151102:
                this.f8219b.onAdShow((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151103:
                this.f8219b.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 151104:
                this.f8219b.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2));
                break;
            case 151105:
                adInteractionListener.onAdDismiss();
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8218a;
    }
}
