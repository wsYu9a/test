package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes2.dex */
class cu implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cs f7121a;

    public cu(cs csVar) {
        this.f7121a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f7121a.g();
        }
    }
}
