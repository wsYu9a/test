package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes4.dex */
public final class p extends com.vivo.push.o {

    /* renamed from: a */
    private String f24941a;

    /* renamed from: b */
    private String f24942b;

    /* renamed from: c */
    private byte[] f24943c;

    /* renamed from: d */
    private long f24944d;

    /* renamed from: e */
    private InsideNotificationItem f24945e;

    public p(String str, long j10, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f24941a = str;
        this.f24944d = j10;
        this.f24945e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f24941a);
        aVar.a("notify_id", this.f24944d);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f24945e));
        aVar.a("open_pkg_name", this.f24942b);
        aVar.a("open_pkg_name_encode", this.f24943c);
    }

    public final String d() {
        return this.f24941a;
    }

    public final long e() {
        return this.f24944d;
    }

    public final InsideNotificationItem f() {
        return this.f24945e;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f24941a = aVar.a("package_name");
        this.f24944d = aVar.b("notify_id", -1L);
        this.f24942b = aVar.a("open_pkg_name");
        this.f24943c = aVar.b("open_pkg_name_encode");
        String a10 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a10)) {
            this.f24945e = com.vivo.push.util.q.a(a10);
        }
        InsideNotificationItem insideNotificationItem = this.f24945e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f24944d);
        }
    }

    public p() {
        super(5);
    }
}
