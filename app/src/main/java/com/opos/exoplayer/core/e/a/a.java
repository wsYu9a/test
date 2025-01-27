package com.opos.exoplayer.core.e.a;

import android.net.Uri;
import com.vivo.google.android.exoplayer3.C;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final a f18394a = new a(new long[0]);

    /* renamed from: b */
    public final int f18395b;

    /* renamed from: c */
    public final long[] f18396c;

    /* renamed from: d */
    public final C0408a[] f18397d;

    /* renamed from: e */
    public final long f18398e;

    /* renamed from: f */
    public final long f18399f;

    /* renamed from: com.opos.exoplayer.core.e.a.a$a */
    public static final class C0408a {

        /* renamed from: a */
        public final int f18403a;

        /* renamed from: b */
        public final Uri[] f18404b;

        /* renamed from: c */
        public final int[] f18405c;

        /* renamed from: d */
        public final long[] f18406d;

        public C0408a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C0408a(int i2, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.opos.exoplayer.core.i.a.a(iArr.length == uriArr.length);
            this.f18403a = i2;
            this.f18405c = iArr;
            this.f18404b = uriArr;
            this.f18406d = jArr;
        }

        public int a() {
            return a(-1);
        }

        public int a(int i2) {
            int i3 = i2 + 1;
            while (true) {
                int[] iArr = this.f18405c;
                if (i3 >= iArr.length || iArr[i3] == 0 || iArr[i3] == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public boolean b() {
            return this.f18403a == -1 || a() < this.f18403a;
        }
    }

    public a(long... jArr) {
        int length = jArr.length;
        this.f18395b = length;
        this.f18396c = Arrays.copyOf(jArr, length);
        this.f18397d = new C0408a[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.f18397d[i2] = new C0408a();
        }
        this.f18398e = 0L;
        this.f18399f = C.TIME_UNSET;
    }

    public int a(long j2) {
        int length = this.f18396c.length - 1;
        while (length >= 0) {
            long[] jArr = this.f18396c;
            if (jArr[length] != Long.MIN_VALUE && jArr[length] <= j2) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.f18397d[length].b()) {
            return -1;
        }
        return length;
    }

    public int b(long j2) {
        int i2 = 0;
        while (true) {
            long[] jArr = this.f18396c;
            if (i2 >= jArr.length || jArr[i2] == Long.MIN_VALUE || (j2 < jArr[i2] && this.f18397d[i2].b())) {
                break;
            }
            i2++;
        }
        if (i2 < this.f18396c.length) {
            return i2;
        }
        return -1;
    }
}
