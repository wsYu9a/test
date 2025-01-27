package com.vivo.google.android.exoplayer3;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class q5 {

    /* renamed from: a */
    public final Uri f27969a;

    /* renamed from: b */
    public final byte[] f27970b;

    /* renamed from: c */
    public final long f27971c;

    /* renamed from: d */
    public final long f27972d;

    /* renamed from: e */
    public final long f27973e;

    /* renamed from: f */
    public final String f27974f;

    /* renamed from: g */
    public final int f27975g;

    public q5(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
    }

    public q5(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        boolean z = true;
        g1.a(j2 >= 0);
        g1.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        g1.a(z);
        this.f27969a = uri;
        this.f27970b = bArr;
        this.f27971c = j2;
        this.f27972d = j3;
        this.f27973e = j4;
        this.f27974f = str;
        this.f27975g = i2;
    }

    public boolean a(int i2) {
        return (this.f27975g & i2) == i2;
    }

    public String toString() {
        return "DataSpec[" + this.f27969a + ", " + Arrays.toString(this.f27970b) + ", " + this.f27971c + ", " + this.f27972d + ", " + this.f27973e + ", " + this.f27974f + ", " + this.f27975g + "]";
    }
}
