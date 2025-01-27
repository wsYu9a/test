package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
class af implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ ad f5499a;

    af(ad adVar) {
        this.f5499a = adVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f5499a.w();
        }
    }
}
