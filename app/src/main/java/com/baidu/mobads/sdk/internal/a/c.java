package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: classes.dex */
class c implements IOAdEventListener {

    /* renamed from: a */
    final /* synthetic */ a f5492a;

    /* renamed from: b */
    final /* synthetic */ b f5493b;

    c(b bVar, a aVar) {
        this.f5493b = bVar;
        this.f5492a = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || !b.f5486e.equals(iOAdEvent.getType()) || (data = iOAdEvent.getData()) == null || data.isEmpty()) {
            return;
        }
        Object obj = data.get("e_t");
        Object obj2 = data.get("e_n");
        Object obj3 = data.get("e_a");
        if ((obj instanceof String) && (obj2 instanceof String)) {
            data.put("e_r", this.f5492a.handleEvent((String) obj, (String) obj2, obj3 instanceof Object[] ? (Object[]) obj3 : null));
        }
    }
}
