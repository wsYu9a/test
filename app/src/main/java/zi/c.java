package zi;

import zi.b;

/* loaded from: classes4.dex */
public class c extends b {

    /* renamed from: m */
    public static final int f33840m = 130;

    /* renamed from: n */
    public static final int f33841n = 159;

    /* renamed from: o */
    public static final int f33842o = 241;

    /* renamed from: p */
    public static final int f33843p = 129;

    /* renamed from: q */
    public static final int f33844q = 159;

    /* renamed from: r */
    public static final int f33845r = 224;

    /* renamed from: s */
    public static final int f33846s = 239;

    @Override // zi.b
    public int b(byte[] bArr, int i10) {
        int i11;
        if ((bArr[i10] & 255) != 130 || (i11 = bArr[i10 + 1] & 255) < 159 || i11 > 241) {
            return -1;
        }
        return i11 - 159;
    }

    @Override // zi.b
    public void c(b.a aVar, byte[] bArr, int i10) {
        int i11;
        aVar.f33838a = -1;
        aVar.f33839b = 1;
        int i12 = bArr[i10] & 255;
        if ((i12 >= 129 && i12 <= 159) || (i12 >= 224 && i12 <= 239)) {
            aVar.f33839b = 2;
        }
        if (i12 != 130 || (i11 = bArr[i10 + 1] & 255) < 159 || i11 > 241) {
            return;
        }
        aVar.f33838a = i11 - 159;
    }
}
