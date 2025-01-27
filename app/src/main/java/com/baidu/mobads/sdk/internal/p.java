package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes2.dex */
class p implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ o f7228a;

    public p(o oVar) {
        this.f7228a = oVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bi.a(new q(this, iOAdEvent));
    }
}
