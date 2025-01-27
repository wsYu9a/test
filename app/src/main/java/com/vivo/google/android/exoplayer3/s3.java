package com.vivo.google.android.exoplayer3;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class s3 {

    /* renamed from: a */
    public final int f28044a;

    /* renamed from: b */
    public final Format[] f28045b;

    /* renamed from: c */
    public int f28046c;

    public s3(Format... formatArr) {
        g1.b(formatArr.length > 0);
        this.f28045b = formatArr;
        this.f28044a = formatArr.length;
    }

    public int a(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f28045b;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public Format a(int i2) {
        return this.f28045b[i2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s3.class != obj.getClass()) {
            return false;
        }
        s3 s3Var = (s3) obj;
        return this.f28044a == s3Var.f28044a && Arrays.equals(this.f28045b, s3Var.f28045b);
    }

    public int hashCode() {
        if (this.f28046c == 0) {
            this.f28046c = Arrays.hashCode(this.f28045b) + 527;
        }
        return this.f28046c;
    }
}
