package p6;

import com.google.zxing.ChecksumException;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public final b f29845a = b.f29846f;

    public int a(int[] iArr, int i10, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.f29845a, iArr);
        int[] iArr3 = new int[i10];
        boolean z10 = false;
        for (int i11 = i10; i11 > 0; i11--) {
            int b10 = cVar.b(this.f29845a.c(i11));
            iArr3[i10 - i11] = b10;
            if (b10 != 0) {
                z10 = true;
            }
        }
        if (!z10) {
            return 0;
        }
        c d10 = this.f29845a.d();
        if (iArr2 != null) {
            for (int i12 : iArr2) {
                int c10 = this.f29845a.c((iArr.length - 1) - i12);
                b bVar = this.f29845a;
                d10 = d10.h(new c(bVar, new int[]{bVar.j(0, c10), 1}));
            }
        }
        c[] d11 = d(this.f29845a.b(i10, 1), new c(this.f29845a, iArr3), i10);
        c cVar2 = d11[0];
        c cVar3 = d11[1];
        int[] b11 = b(cVar2);
        int[] c11 = c(cVar3, cVar2, b11);
        for (int i13 = 0; i13 < b11.length; i13++) {
            int length = (iArr.length - 1) - this.f29845a.h(b11[i13]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.f29845a.j(iArr[length], c11[i13]);
        }
        return b11.length;
    }

    public final int[] b(c cVar) throws ChecksumException {
        int e10 = cVar.e();
        int[] iArr = new int[e10];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f29845a.e() && i10 < e10; i11++) {
            if (cVar.b(i11) == 0) {
                iArr[i10] = this.f29845a.g(i11);
                i10++;
            }
        }
        if (i10 == e10) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    public final int[] c(c cVar, c cVar2, int[] iArr) {
        int e10 = cVar2.e();
        int[] iArr2 = new int[e10];
        for (int i10 = 1; i10 <= e10; i10++) {
            iArr2[e10 - i10] = this.f29845a.i(i10, cVar2.c(i10));
        }
        c cVar3 = new c(this.f29845a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int g10 = this.f29845a.g(iArr[i11]);
            iArr3[i11] = this.f29845a.i(this.f29845a.j(0, cVar.b(g10)), this.f29845a.g(cVar3.b(g10)));
        }
        return iArr3;
    }

    public final c[] d(c cVar, c cVar2, int i10) throws ChecksumException {
        if (cVar.e() < cVar2.e()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f10 = this.f29845a.f();
        c d10 = this.f29845a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = d10;
            c cVar5 = f10;
            f10 = cVar4;
            if (cVar.e() < i10 / 2) {
                int c10 = f10.c(0);
                if (c10 == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int g10 = this.f29845a.g(c10);
                return new c[]{f10.g(g10), cVar.g(g10)};
            }
            if (cVar.f()) {
                throw ChecksumException.getChecksumInstance();
            }
            c f11 = this.f29845a.f();
            int g11 = this.f29845a.g(cVar.c(cVar.e()));
            while (cVar2.e() >= cVar.e() && !cVar2.f()) {
                int e10 = cVar2.e() - cVar.e();
                int i11 = this.f29845a.i(cVar2.c(cVar2.e()), g11);
                f11 = f11.a(this.f29845a.b(e10, i11));
                cVar2 = cVar2.k(cVar.i(e10, i11));
            }
            d10 = f11.h(f10).k(cVar5).j();
        }
    }
}
