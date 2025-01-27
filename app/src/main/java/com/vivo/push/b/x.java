package com.vivo.push.b;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class x extends com.vivo.push.o {

    /* renamed from: a */
    private HashMap<String, String> f30930a;

    /* renamed from: b */
    private long f30931b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f30930a = hashMap;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f30930a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f30931b);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f30930a = (HashMap) aVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f30931b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f30931b);
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "ReporterCommand（" + this.f30931b + ")";
    }

    public x(long j2) {
        this();
        this.f30931b = j2;
    }

    public final void d() {
        if (this.f30930a == null) {
            com.vivo.push.util.p.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.f30931b);
        sb.append(",msgId:");
        String str = this.f30930a.get(com.heytap.mcssdk.n.d.n);
        if (TextUtils.isEmpty(str)) {
            str = this.f30930a.get("message_id");
        }
        sb.append(str);
        com.vivo.push.util.p.d("ReporterCommand", sb.toString());
    }
}
