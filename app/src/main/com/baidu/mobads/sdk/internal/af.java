package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes2.dex */
class af implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ ae f6713a;

    public af(ae aeVar) {
        this.f6713a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6713a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
