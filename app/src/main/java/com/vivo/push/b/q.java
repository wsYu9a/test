package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes4.dex */
public final class q extends v {

    /* renamed from: a */
    protected InsideNotificationItem f30919a;

    /* renamed from: b */
    private String f30920b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        String b2 = com.vivo.push.util.q.b(this.f30919a);
        this.f30920b = b2;
        aVar.a("notification_v1", b2);
    }

    public final InsideNotificationItem d() {
        return this.f30919a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f30920b)) {
            return this.f30920b;
        }
        InsideNotificationItem insideNotificationItem = this.f30919a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.q.b(insideNotificationItem);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a2 = aVar.a("notification_v1");
        this.f30920b = a2;
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        InsideNotificationItem a3 = com.vivo.push.util.q.a(this.f30920b);
        this.f30919a = a3;
        if (a3 != null) {
            a3.setMsgId(f());
        }
    }
}
