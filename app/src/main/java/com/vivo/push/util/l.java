package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* loaded from: classes4.dex */
final class l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f31103a;

    /* renamed from: b */
    final /* synthetic */ k f31104b;

    l(k kVar, List list) {
        this.f31104b = kVar;
        this.f31103a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j2;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j3;
        int i2;
        r.a aVar;
        insideNotificationItem = this.f31104b.f31098b;
        if (insideNotificationItem != null) {
            w b2 = w.b();
            j2 = this.f31104b.f31099c;
            b2.a("com.vivo.push.notify_key", j2);
            context = this.f31104b.f31097a;
            List list = this.f31103a;
            insideNotificationItem2 = this.f31104b.f31098b;
            j3 = this.f31104b.f31099c;
            i2 = this.f31104b.f31101e;
            aVar = this.f31104b.f31102f;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j3, i2, aVar);
        }
    }
}
