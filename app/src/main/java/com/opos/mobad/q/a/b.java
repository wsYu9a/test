package com.opos.mobad.q.a;

import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.n.a;
import com.qq.e.comm.adevent.AdEventType;

/* loaded from: classes4.dex */
public class b {
    public static final com.opos.mobad.n.a a(Context context, int i2, AdItemData adItemData, a.InterfaceC0458a interfaceC0458a) {
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(context, i2, adItemData.P(), interfaceC0458a);
        return a2 != null ? a2 : new com.opos.mobad.q.a.f.c(context, adItemData, AdEventType.VIDEO_PRELOAD_ERROR, com.opos.mobad.r.a.d.a(adItemData.P()).a(context));
    }
}
