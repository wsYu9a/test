package com.opos.exoplayer.core.e;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a */
    public static final m f18516a = new m(new l[0]);

    /* renamed from: b */
    public final int f18517b;

    /* renamed from: c */
    private final l[] f18518c;

    /* renamed from: d */
    private int f18519d;

    public m(l... lVarArr) {
        this.f18518c = lVarArr;
        this.f18517b = lVarArr.length;
    }

    public int a(l lVar) {
        for (int i2 = 0; i2 < this.f18517b; i2++) {
            if (this.f18518c[i2] == lVar) {
                return i2;
            }
        }
        return -1;
    }

    public l a(int i2) {
        return this.f18518c[i2];
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            m mVar = (m) obj;
            if (this.f18517b != mVar.f18517b || !Arrays.equals(this.f18518c, mVar.f18518c)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.f18519d == 0) {
            this.f18519d = Arrays.hashCode(this.f18518c);
        }
        return this.f18519d;
    }
}
