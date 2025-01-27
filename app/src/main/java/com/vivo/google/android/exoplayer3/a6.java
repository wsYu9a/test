package com.vivo.google.android.exoplayer3;

import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes4.dex */
public class a6 implements Comparable<a6> {

    /* renamed from: a */
    public final String f27149a;

    /* renamed from: b */
    public final long f27150b;

    /* renamed from: c */
    public final long f27151c;

    /* renamed from: d */
    public final boolean f27152d;

    /* renamed from: e */
    public final File f27153e;

    /* renamed from: f */
    public final long f27154f;

    public a6(String str, long j2, long j3, long j4, File file) {
        this.f27149a = str;
        this.f27150b = j2;
        this.f27151c = j3;
        this.f27152d = file != null;
        this.f27153e = file;
        this.f27154f = j4;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull a6 a6Var) {
        if (!this.f27149a.equals(a6Var.f27149a)) {
            return this.f27149a.compareTo(a6Var.f27149a);
        }
        long j2 = this.f27150b - a6Var.f27150b;
        if (j2 == 0) {
            return 0;
        }
        return j2 < 0 ? -1 : 1;
    }
}
