package com.vivo.push.b;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class x extends com.vivo.push.o {

    /* renamed from: a */
    private HashMap<String, String> f24957a;

    /* renamed from: b */
    private long f24958b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f24957a = hashMap;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f24957a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f24958b);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f24957a = (HashMap) aVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f24958b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f24958b);
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "ReporterCommand（" + this.f24958b + ")";
    }

    public x(long j10) {
        this();
        this.f24958b = j10;
    }

    public final void d() {
        if (this.f24957a == null) {
            com.vivo.push.util.p.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb2 = new StringBuilder("report message reportType:");
        sb2.append(this.f24958b);
        sb2.append(",msgId:");
        String str = this.f24957a.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.f24957a.get("message_id");
        }
        sb2.append(str);
        com.vivo.push.util.p.d("ReporterCommand", sb2.toString());
    }
}
