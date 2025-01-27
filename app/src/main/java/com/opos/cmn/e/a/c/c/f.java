package com.opos.cmn.e.a.c.c;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public class f extends b implements e {
    public f(Context context, com.opos.cmn.e.a.c.a aVar) {
        super(context, aVar);
        if (com.opos.cmn.e.a.d.a.a()) {
            this.f16996c = new com.opos.cmn.e.a.c.d.d(this.f16994a, this);
        }
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a() {
        com.opos.cmn.e.a.c.d.c cVar;
        if (!com.opos.cmn.e.a.d.a.a() || (cVar = this.f16996c) == null) {
            return;
        }
        cVar.a();
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a(View view, String str, Object... objArr) {
        com.opos.cmn.e.a.c.a aVar = this.f16995b;
        if (aVar != null) {
            aVar.a(view, str, objArr);
        }
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a(View view, int[] iArr, String str, Object... objArr) {
        com.opos.cmn.e.a.c.a aVar = this.f16995b;
        if (aVar != null) {
            aVar.a(view, iArr, str, objArr);
        }
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a(String str, boolean z, Object... objArr) {
        com.opos.cmn.e.a.c.d.c cVar;
        if (!com.opos.cmn.e.a.d.a.a() || (cVar = this.f16996c) == null) {
            return;
        }
        cVar.a(str, z, objArr);
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void b() {
        com.opos.cmn.e.a.c.d.c cVar;
        if (!com.opos.cmn.e.a.d.a.a() || (cVar = this.f16996c) == null) {
            return;
        }
        cVar.b();
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void b(View view, int[] iArr, String str, Object... objArr) {
        com.opos.cmn.e.a.c.a aVar = this.f16995b;
        if (aVar != null) {
            aVar.b(view, iArr, str, objArr);
        }
    }
}
