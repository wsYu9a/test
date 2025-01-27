package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes.dex */
class cr implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cq f5759a;

    cr(cq cqVar) {
        this.f5759a = cqVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f5759a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
