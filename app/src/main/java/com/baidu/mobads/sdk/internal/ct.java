package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes2.dex */
class ct implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ cs f7120a;

    public ct(cs csVar) {
        this.f7120a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f7120a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
