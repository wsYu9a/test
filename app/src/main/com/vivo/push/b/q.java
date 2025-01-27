package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes4.dex */
public final class q extends v {

    /* renamed from: a */
    protected InsideNotificationItem f24946a;

    /* renamed from: b */
    private String f24947b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        String b10 = com.vivo.push.util.q.b(this.f24946a);
        this.f24947b = b10;
        aVar.a("notification_v1", b10);
    }

    public final InsideNotificationItem d() {
        return this.f24946a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f24947b)) {
            return this.f24947b;
        }
        InsideNotificationItem insideNotificationItem = this.f24946a;
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
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a10 = aVar.a("notification_v1");
        this.f24947b = a10;
        if (TextUtils.isEmpty(a10)) {
            return;
        }
        InsideNotificationItem a11 = com.vivo.push.util.q.a(this.f24947b);
        this.f24946a = a11;
        if (a11 != null) {
            a11.setMsgId(f());
        }
    }
}
