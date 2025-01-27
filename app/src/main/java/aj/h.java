package aj;

/* loaded from: classes4.dex */
public class h extends g {

    /* renamed from: k */
    public static final int f214k = 129;

    /* renamed from: l */
    public static final int f215l = 159;

    /* renamed from: m */
    public static final int f216m = 224;

    /* renamed from: n */
    public static final int f217n = 239;

    /* renamed from: o */
    public static final int f218o = 64;

    /* renamed from: p */
    public static final int f219p = 128;

    @Override // aj.b
    public int b(byte[] bArr, int i10) {
        int i11;
        int i12 = bArr[i10] & 255;
        if (i12 >= 129 && i12 <= 159) {
            i11 = i12 - 129;
        } else {
            if (i12 < 224 || i12 > 239) {
                return -1;
            }
            i11 = i12 - 193;
        }
        int i13 = i11 * 188;
        int i14 = bArr[i10 + 1] & 255;
        int i15 = i13 + (i14 - 64);
        return i14 >= 128 ? i15 - 1 : i15;
    }
}
