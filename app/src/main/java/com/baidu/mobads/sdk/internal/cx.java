package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
class cx implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cv f5768a;

    cx(cv cvVar) {
        this.f5768a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f5768a.y();
        }
    }
}
