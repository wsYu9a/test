package m6;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class e extends i {

    /* renamed from: f */
    public static final int f28496f = 8;

    /* renamed from: g */
    public static final int f28497g = 20;

    /* renamed from: h */
    public static final int f28498h = 16;

    /* renamed from: d */
    public final String f28499d;

    /* renamed from: e */
    public final String f28500e;

    public e(z5.a aVar, String str, String str2) {
        super(aVar);
        this.f28499d = str2;
        this.f28500e = str;
    }

    @Override // m6.j
    public String d() throws NotFoundException {
        if (c().l() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        j(sb2, 48, 20);
        k(sb2, 68);
        return sb2.toString();
    }

    @Override // m6.i
    public void h(StringBuilder sb2, int i10) {
        sb2.append('(');
        sb2.append(this.f28500e);
        sb2.append(i10 / 100000);
        sb2.append(')');
    }

    @Override // m6.i
    public int i(int i10) {
        return i10 % 100000;
    }

    public final void k(StringBuilder sb2, int i10) {
        int f10 = b().f(i10, 16);
        if (f10 == 38400) {
            return;
        }
        sb2.append('(');
        sb2.append(this.f28499d);
        sb2.append(')');
        int i11 = f10 % 32;
        int i12 = f10 / 32;
        int i13 = (i12 % 12) + 1;
        int i14 = i12 / 12;
        if (i14 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i14);
        if (i13 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i13);
        if (i11 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i11);
    }
}
