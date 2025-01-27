package com.vivo.google.android.exoplayer3;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public final class c4 extends w implements Comparable<c4> {

    /* renamed from: f */
    public long f27257f;

    public c4() {
        super(1);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull c4 c4Var) {
        long j2 = this.f28193d - c4Var.f28193d;
        if (j2 == 0) {
            return 0;
        }
        return j2 > 0 ? 1 : -1;
    }
}
