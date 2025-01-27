package com.zk_oaction.adengine.lk_animation;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class h extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.c f34795f;

    public h(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34795f = cVar;
        d();
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34795f.Q;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        this.f34795f.J.f(com.alipay.mobilesecuritysdk.deviceID.c.y, "" + (System.currentTimeMillis() % 3600000));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public boolean c(XmlPullParser xmlPullParser) {
        return false;
    }
}
