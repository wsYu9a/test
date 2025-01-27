package com.google.zxing.pdf417.decoder.j;

import com.google.zxing.ChecksumException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private final b f8704a = b.f8705a;

    private int[] b(c cVar) throws ChecksumException {
        int e2 = cVar.e();
        int[] iArr = new int[e2];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f8704a.e() && i2 < e2; i3++) {
            if (cVar.b(i3) == 0) {
                iArr[i2] = this.f8704a.g(i3);
                i2++;
            }
        }
        if (i2 == e2) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int e2 = cVar2.e();
        int[] iArr2 = new int[e2];
        for (int i2 = 1; i2 <= e2; i2++) {
            iArr2[e2 - i2] = this.f8704a.i(i2, cVar2.c(i2));
        }
        c cVar3 = new c(this.f8704a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int g2 = this.f8704a.g(iArr[i3]);
            iArr3[i3] = this.f8704a.i(this.f8704a.j(0, cVar.b(g2)), this.f8704a.g(cVar3.b(g2)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i2) throws ChecksumException {
        if (cVar.e() < cVar2.e()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f2 = this.f8704a.f();
        c d2 = this.f8704a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = d2;
            c cVar5 = f2;
            f2 = cVar4;
            if (cVar.e() < i2 / 2) {
                int c2 = f2.c(0);
                if (c2 == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int g2 = this.f8704a.g(c2);
                return new c[]{f2.g(g2), cVar.g(g2)};
            }
            if (cVar.f()) {
                throw ChecksumException.getChecksumInstance();
            }
            c f3 = this.f8704a.f();
            int g3 = this.f8704a.g(cVar.c(cVar.e()));
            while (cVar2.e() >= cVar.e() && !cVar2.f()) {
                int e2 = cVar2.e() - cVar.e();
                int i3 = this.f8704a.i(cVar2.c(cVar2.e()), g3);
                f3 = f3.a(this.f8704a.b(e2, i3));
                cVar2 = cVar2.k(cVar.i(e2, i3));
            }
            d2 = f3.h(f2).k(cVar5).j();
        }
    }

    public int a(int[] iArr, int i2, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.f8704a, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int b2 = cVar.b(this.f8704a.c(i3));
            iArr3[i2 - i3] = b2;
            if (b2 != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c d2 = this.f8704a.d();
        if (iArr2 != null) {
            for (int i4 : iArr2) {
                int c2 = this.f8704a.c((iArr.length - 1) - i4);
                b bVar = this.f8704a;
                d2 = d2.h(new c(bVar, new int[]{bVar.j(0, c2), 1}));
            }
        }
        c[] d3 = d(this.f8704a.b(i2, 1), new c(this.f8704a, iArr3), i2);
        c cVar2 = d3[0];
        c cVar3 = d3[1];
        int[] b3 = b(cVar2);
        int[] c3 = c(cVar3, cVar2, b3);
        for (int i5 = 0; i5 < b3.length; i5++) {
            int length = (iArr.length - 1) - this.f8704a.h(b3[i5]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.f8704a.j(iArr[length], c3[i5]);
        }
        return b3.length;
    }
}
