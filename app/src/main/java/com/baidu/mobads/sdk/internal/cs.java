package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
class cs implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cq f5760a;

    cs(cq cqVar) {
        this.f5760a = cqVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f5760a.h();
        }
    }
}
