package com.sigmob.sdk.base.common;

import android.os.Bundle;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class x extends o {

    /* renamed from: a */
    public o.b f18041a;

    /* renamed from: b */
    public BaseAdUnit f18042b;

    /* renamed from: c */
    public EventForwardingBroadcastReceiver f18043c;

    public x(o.b bVar) {
        this.f18041a = bVar;
    }

    public abstract void a(o.b bVar);

    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        this.f18042b = baseAdUnit;
        a(this.f18041a);
    }

    public abstract boolean a(BaseAdUnit baseAdUnit);

    public void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            h.d(baseAdUnit);
            baseAdUnit.destroy();
        }
        this.f18042b = null;
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.f18043c;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.b(eventForwardingBroadcastReceiver);
        }
    }

    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = new EventForwardingBroadcastReceiver(baseAdUnit, this.f18041a, baseAdUnit.getUuid());
        this.f18043c = eventForwardingBroadcastReceiver;
        eventForwardingBroadcastReceiver.a(eventForwardingBroadcastReceiver);
    }
}
