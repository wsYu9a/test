package a3;

/* loaded from: classes.dex */
public class e {

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int[] f69a;

        /* renamed from: b, reason: collision with root package name */
        public int f70b;

        /* renamed from: c, reason: collision with root package name */
        public int f71c;

        public b() {
            this.f69a = new int[256];
        }
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b();
        for (int i10 = 0; i10 < 256; i10++) {
            bVar.f69a[i10] = i10;
        }
        bVar.f70b = 0;
        bVar.f71c = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 256; i13++) {
            try {
                char charAt = str.charAt(i11);
                int[] iArr = bVar.f69a;
                int i14 = iArr[i13];
                i12 = ((charAt + i14) + i12) % 256;
                iArr[i13] = iArr[i12];
                iArr[i12] = i14;
                i11 = (i11 + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return bVar;
    }

    public static byte[] b(byte[] bArr) {
        b a10;
        if (bArr == null || (a10 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return c(bArr, a10);
    }

    public static byte[] c(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i10 = bVar.f70b;
        int i11 = bVar.f71c;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            i10 = (i10 + 1) % 256;
            int[] iArr = bVar.f69a;
            int i13 = iArr[i10];
            i11 = (i11 + i13) % 256;
            iArr[i10] = iArr[i11];
            iArr[i11] = i13;
            int i14 = (iArr[i10] + i13) % 256;
            bArr[i12] = (byte) (iArr[i14] ^ bArr[i12]);
        }
        bVar.f70b = i10;
        bVar.f71c = i11;
        return bArr;
    }
}
