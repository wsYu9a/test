package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* loaded from: classes4.dex */
final class l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f25139a;

    /* renamed from: b */
    final /* synthetic */ k f25140b;

    public l(k kVar, List list) {
        this.f25140b = kVar;
        this.f25139a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j10;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j11;
        int i10;
        r.a aVar;
        insideNotificationItem = this.f25140b.f25134b;
        if (insideNotificationItem != null) {
            w b10 = w.b();
            j10 = this.f25140b.f25135c;
            b10.a("com.vivo.push.notify_key", j10);
            context = this.f25140b.f25133a;
            List list = this.f25139a;
            insideNotificationItem2 = this.f25140b.f25134b;
            j11 = this.f25140b.f25135c;
            i10 = this.f25140b.f25137e;
            aVar = this.f25140b.f25138f;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j11, i10, aVar);
        }
    }
}
