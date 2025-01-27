package com.aggmoread.sdk.z.d.a.a.e.r;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.m;

/* loaded from: classes.dex */
public abstract class c implements f {

    /* renamed from: c */
    protected com.aggmoread.sdk.z.d.a.a.d.b.e f6132c;

    /* renamed from: d */
    protected String f6133d;

    @Override // com.aggmoread.sdk.z.d.a.a.e.r.f
    public boolean a() {
        return b();
    }

    public String b(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        com.aggmoread.sdk.z.d.a.a.e.f fVar;
        if (eVar == null || (fVar = eVar.f5907c) == null) {
            return null;
        }
        return fVar.c(e.c.f5921b0);
    }

    public abstract String c();

    @Override // com.aggmoread.sdk.z.d.a.a.e.r.f
    public boolean a(ContextWrapper contextWrapper, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Object... objArr) {
        if (eVar != null && contextWrapper != null) {
            String b10 = b(eVar);
            if (TextUtils.isEmpty(b10)) {
                return false;
            }
            String c10 = c();
            if (TextUtils.isEmpty(c10)) {
                return false;
            }
            try {
                a.a(contextWrapper, b10, c10, eVar);
                this.f6132c = eVar;
                this.f6133d = b10;
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean b() {
        return (this.f6132c == null || TextUtils.isEmpty(this.f6133d)) ? false : true;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.e.r.f
    public boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        if (eVar == null) {
            return false;
        }
        return m.a(j.f6027q, eVar);
    }
}
