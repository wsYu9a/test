package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes2.dex */
class cz implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cx f7136a;

    public cz(cx cxVar) {
        this.f7136a = cxVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f7136a.z();
        }
    }
}
