package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.u;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a */
    public final m f18892a;

    /* renamed from: b */
    public final boolean[] f18893b;

    /* renamed from: c */
    public final g f18894c;

    /* renamed from: d */
    public final Object f18895d;

    /* renamed from: e */
    public final u[] f18896e;

    public i(m mVar, boolean[] zArr, g gVar, Object obj, u[] uVarArr) {
        this.f18892a = mVar;
        this.f18893b = zArr;
        this.f18894c = gVar;
        this.f18895d = obj;
        this.f18896e = uVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null || iVar.f18894c.f18888a != this.f18894c.f18888a) {
            return false;
        }
        for (int i2 = 0; i2 < this.f18894c.f18888a; i2++) {
            if (!a(iVar, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i2) {
        return iVar != null && this.f18893b[i2] == iVar.f18893b[i2] && com.opos.exoplayer.core.i.u.a(this.f18894c.a(i2), iVar.f18894c.a(i2)) && com.opos.exoplayer.core.i.u.a(this.f18896e[i2], iVar.f18896e[i2]);
    }
}
