package com.bytedance.sdk.openadsdk.i.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.c.a.a.k;

/* loaded from: classes2.dex */
public class a implements Bridge {

    /* renamed from: a */
    private ValueSet f8206a = com.bykv.a.a.a.a.b.f7416a;

    /* renamed from: b */
    private final TTFeedAd.VideoAdListener f8207b;

    public a(TTFeedAd.VideoAdListener videoAdListener) {
        this.f8207b = videoAdListener;
    }

    public void a(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f8207b == null) {
            return null;
        }
        switch (i10) {
            case 161101:
                this.f8207b.onVideoLoad(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.f8207b.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.f8207b.onVideoAdPaused(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.f8207b.onVideoAdStartPlay(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.f8207b.onVideoAdContinuePlay(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.f8207b.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.f8207b.onVideoAdComplete(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        a(i10, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f8206a;
    }
}
