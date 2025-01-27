package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;

/* loaded from: classes4.dex */
public class c extends com.vivo.push.o {

    /* renamed from: a */
    private String f24921a;

    /* renamed from: b */
    private String f24922b;

    /* renamed from: c */
    private long f24923c;

    /* renamed from: d */
    private int f24924d;

    /* renamed from: e */
    private int f24925e;

    /* renamed from: f */
    private String f24926f;

    public c(int i10, String str) {
        super(i10);
        this.f24923c = -1L;
        this.f24924d = -1;
        this.f24921a = null;
        this.f24922b = str;
    }

    public final void a(int i10) {
        this.f24925e = i10;
    }

    public final void b(String str) {
        this.f24921a = str;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a(ExposeManager.UtArgsNames.reqId, this.f24921a);
        aVar.a("package_name", this.f24922b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.f24924d);
        if (TextUtils.isEmpty(this.f24926f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f24926f);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.f24921a = aVar.a(ExposeManager.UtArgsNames.reqId);
        this.f24922b = aVar.a("package_name");
        this.f24923c = aVar.b("sdk_version", 0L);
        this.f24924d = aVar.b("PUSH_APP_STATUS", 0);
        this.f24926f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f24925e;
    }

    public final void g() {
        this.f24926f = null;
    }

    public final String h() {
        return this.f24921a;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.f24924d == -1) {
            String str = this.f24922b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                str = a();
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.f24924d = com.vivo.push.util.t.b(context, str);
            if (!TextUtils.isEmpty(this.f24926f)) {
                this.f24924d = 2;
            }
        }
        return this.f24924d;
    }
}
