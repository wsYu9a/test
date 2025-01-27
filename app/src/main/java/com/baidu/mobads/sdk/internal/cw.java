package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes.dex */
class cw implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cv f5767a;

    cw(cv cvVar) {
        this.f5767a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f5767a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
