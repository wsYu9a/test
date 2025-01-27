package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes2.dex */
class ag implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ ae f6714a;

    public ag(ae aeVar) {
        this.f6714a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6714a.x();
        }
    }
}
