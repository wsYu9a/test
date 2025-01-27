package zi;

import zi.b;

/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: m */
    public static final int f33819m = 164;

    /* renamed from: n */
    public static final int f33820n = 161;

    /* renamed from: o */
    public static final int f33821o = 243;

    /* renamed from: p */
    public static final int f33822p = 142;

    /* renamed from: q */
    public static final int f33823q = 143;

    /* renamed from: r */
    public static final int f33824r = 161;

    /* renamed from: s */
    public static final int f33825s = 254;

    @Override // zi.b
    public int b(byte[] bArr, int i10) {
        int i11;
        if ((bArr[i10] & 255) != 164 || (i11 = bArr[i10 + 1] & 255) < 161 || i11 > 243) {
            return -1;
        }
        return i11 - 161;
    }

    @Override // zi.b
    public void c(b.a aVar, byte[] bArr, int i10) {
        int i11;
        aVar.f33838a = -1;
        aVar.f33839b = 1;
        int i12 = bArr[i10] & 255;
        if (i12 == 142 || (i12 >= 161 && i12 <= 254)) {
            aVar.f33839b = 2;
        } else if (i12 == 143) {
            aVar.f33839b = 3;
        }
        if (i12 != 164 || (i11 = bArr[i10 + 1] & 255) < 161 || i11 > 243) {
            return;
        }
        aVar.f33838a = i11 - 161;
    }
}
