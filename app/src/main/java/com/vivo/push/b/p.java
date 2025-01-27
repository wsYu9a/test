package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes4.dex */
public final class p extends com.vivo.push.o {

    /* renamed from: a */
    private String f30914a;

    /* renamed from: b */
    private String f30915b;

    /* renamed from: c */
    private byte[] f30916c;

    /* renamed from: d */
    private long f30917d;

    /* renamed from: e */
    private InsideNotificationItem f30918e;

    public p(String str, long j2, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f30914a = str;
        this.f30917d = j2;
        this.f30918e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f30914a);
        aVar.a("notify_id", this.f30917d);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f30918e));
        aVar.a("open_pkg_name", this.f30915b);
        aVar.a("open_pkg_name_encode", this.f30916c);
    }

    public final String d() {
        return this.f30914a;
    }

    public final long e() {
        return this.f30917d;
    }

    public final InsideNotificationItem f() {
        return this.f30918e;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        this.f30914a = aVar.a("package_name");
        this.f30917d = aVar.b("notify_id", -1L);
        this.f30915b = aVar.a("open_pkg_name");
        this.f30916c = aVar.b("open_pkg_name_encode");
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f30918e = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f30918e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f30917d);
        }
    }

    public p() {
        super(5);
    }
}
