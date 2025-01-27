package com.bytedance.sdk.openadsdk.k.a.a.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.c.a.a.n;

/* loaded from: classes2.dex */
public class a implements Bridge {

    /* renamed from: a */
    private ValueSet f8212a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTNativeAd.AdInteractionListener f8213b;

    public a(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f8213b = adInteractionListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8213b == null) {
            return null;
        }
        switch (i10) {
            case 141101:
                this.f8213b.onAdClicked((View) valueSet.objectValue(0, View.class), new n((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141102:
                this.f8213b.onAdCreativeClick((View) valueSet.objectValue(0, View.class), new n((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141103:
                this.f8213b.onAdShow(new n((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8212a;
    }
}
