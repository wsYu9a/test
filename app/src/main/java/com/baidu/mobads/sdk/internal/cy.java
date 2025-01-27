package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes2.dex */
class cy implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cx f7135a;

    public cy(cx cxVar) {
        this.f7135a = cxVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f7135a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
