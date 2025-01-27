package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes.dex */
class ae implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ ad f5498a;

    ae(ad adVar) {
        this.f5498a = adVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f5498a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
