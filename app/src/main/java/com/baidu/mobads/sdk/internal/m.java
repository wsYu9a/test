package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
class m implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ l f5830a;

    m(l lVar) {
        this.f5830a = lVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bf.a(new n(this, iOAdEvent));
    }
}
