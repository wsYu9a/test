package aj;

/* loaded from: classes4.dex */
public class c extends g {

    /* renamed from: k */
    public static final int f190k = 161;

    /* renamed from: l */
    public static final int f191l = 254;

    /* renamed from: m */
    public static final int f192m = 161;

    /* renamed from: n */
    public static final int f193n = 254;

    @Override // aj.b
    public int b(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        if (i11 < 161) {
            return -1;
        }
        return (((i11 - 161) * 94) + (bArr[i10 + 1] & 255)) - 161;
    }
}
