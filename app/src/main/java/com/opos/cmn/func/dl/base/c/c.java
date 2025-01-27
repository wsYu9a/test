package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.func.dl.base.c.d;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c implements d {

    /* renamed from: a */
    public static final String f17287a = "c";

    /* renamed from: b */
    private com.opos.cmn.func.b.b.e f17288b;

    /* renamed from: c */
    private Map<String, String> f17289c = new HashMap();

    public static final class a implements d.a {
        @Override // com.opos.cmn.func.dl.base.c.d.a
        public final d a() {
            return new c();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        com.opos.cmn.func.b.b.e eVar = this.f17288b;
        if (eVar != null) {
            return eVar.f17170c;
        }
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        Map<String, String> map = bVar.f17286a;
        if (map != null) {
            this.f17289c.putAll(map);
        }
        this.f17288b = com.opos.cmn.func.b.b.b.a().a(context, new d.a().b(str).a(this.f17289c).a("GET").a());
        return a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        com.opos.cmn.func.b.b.e eVar = this.f17288b;
        return eVar != null ? eVar.f17173f.a(str) : "";
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.f17289c.put(str, str2);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        com.opos.cmn.func.b.b.e eVar = this.f17288b;
        return eVar != null ? eVar.f17169b : "";
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        com.opos.cmn.func.b.b.e eVar = this.f17288b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        com.opos.cmn.func.b.b.e eVar = this.f17288b;
        if (eVar != null) {
            return eVar.f17168a;
        }
        return -1;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        com.opos.cmn.func.b.b.e eVar = this.f17288b;
        if (eVar != null) {
            return eVar.f17171d;
        }
        return -1L;
    }
}
