package com.opos.exoplayer.core.g;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a */
    public final int f18888a;

    /* renamed from: b */
    private final f[] f18889b;

    /* renamed from: c */
    private int f18890c;

    public g(f... fVarArr) {
        this.f18889b = fVarArr;
        this.f18888a = fVarArr.length;
    }

    public f a(int i2) {
        return this.f18889b[i2];
    }

    public f[] a() {
        return (f[]) this.f18889b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f18889b, ((g) obj).f18889b);
    }

    public int hashCode() {
        if (this.f18890c == 0) {
            this.f18890c = Arrays.hashCode(this.f18889b) + 527;
        }
        return this.f18890c;
    }
}
