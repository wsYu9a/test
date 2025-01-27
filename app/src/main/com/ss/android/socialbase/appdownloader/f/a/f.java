package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private int[] f21903a;

    /* renamed from: b */
    private int[] f21904b;

    private f() {
    }

    public static f a(d dVar) throws IOException {
        b.a(dVar, 1835009);
        int b10 = dVar.b();
        int b11 = dVar.b();
        int b12 = dVar.b();
        dVar.b();
        int b13 = dVar.b();
        int b14 = dVar.b();
        f fVar = new f();
        fVar.f21903a = dVar.b(b11);
        if (b12 != 0) {
            dVar.b(b12);
        }
        int i10 = (b14 == 0 ? b10 : b14) - b13;
        if (i10 % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i10 + ").");
        }
        fVar.f21904b = dVar.b(i10 / 4);
        if (b14 != 0) {
            int i11 = b10 - b14;
            if (i11 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i11 + ").");
            }
            dVar.b(i11 / 4);
        }
        return fVar;
    }

    public String a(int i10) {
        int[] iArr;
        if (i10 < 0 || (iArr = this.f21903a) == null || i10 >= iArr.length) {
            return null;
        }
        int i11 = iArr[i10];
        int a10 = a(this.f21904b, i11);
        StringBuilder sb2 = new StringBuilder(a10);
        while (a10 != 0) {
            i11 += 2;
            sb2.append((char) a(this.f21904b, i11));
            a10--;
        }
        return sb2.toString();
    }

    private static final int a(int[] iArr, int i10) {
        int i11 = iArr[i10 / 4];
        return (i10 % 4) / 2 == 0 ? i11 & 65535 : i11 >>> 16;
    }
}
