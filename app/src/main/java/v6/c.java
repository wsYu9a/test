package v6;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public static final int[] f31237a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b */
    public static final String f31238b = "ISO-8859-1";

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f31239a;

        static {
            int[] iArr = new int[Mode.values().length];
            f31239a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31239a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31239a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31239a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, z5.a aVar, String str2) throws WriterException {
        try {
            for (byte b10 : str.getBytes(str2)) {
                aVar.c(b10, 8);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new WriterException(e10);
        }
    }

    public static void b(CharSequence charSequence, z5.a aVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int r10 = r(charSequence.charAt(i10));
            if (r10 == -1) {
                throw new WriterException();
            }
            int i11 = i10 + 1;
            if (i11 < length) {
                int r11 = r(charSequence.charAt(i11));
                if (r11 == -1) {
                    throw new WriterException();
                }
                aVar.c((r10 * 45) + r11, 11);
                i10 += 2;
            } else {
                aVar.c(r10, 6);
                i10 = i11;
            }
        }
    }

    public static void c(String str, Mode mode, z5.a aVar, String str2) throws WriterException {
        int i10 = a.f31239a[mode.ordinal()];
        if (i10 == 1) {
            h(str, aVar);
            return;
        }
        if (i10 == 2) {
            b(str, aVar);
            return;
        }
        if (i10 == 3) {
            a(str, aVar, str2);
        } else if (i10 == 4) {
            e(str, aVar);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void d(CharacterSetECI characterSetECI, z5.a aVar) {
        aVar.c(Mode.ECI.getBits(), 4);
        aVar.c(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(java.lang.String r6, z5.a r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.c.e(java.lang.String, z5.a):void");
    }

    public static void f(int i10, t6.f fVar, Mode mode, z5.a aVar) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(fVar);
        int i11 = 1 << characterCountBits;
        if (i10 < i11) {
            aVar.c(i10, characterCountBits);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void g(Mode mode, z5.a aVar) {
        aVar.c(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, z5.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    public static int i(Mode mode, z5.a aVar, z5.a aVar2, t6.f fVar) {
        return aVar.l() + mode.getCharacterCountBits(fVar) + aVar2.l();
    }

    public static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    public static int k(z5.a aVar, ErrorCorrectionLevel errorCorrectionLevel, t6.f fVar, b bVar) throws WriterException {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            e.a(aVar, errorCorrectionLevel, fVar, i12, bVar);
            int j10 = j(bVar);
            if (j10 < i10) {
                i11 = i12;
                i10 = j10;
            }
        }
        return i11;
    }

    public static Mode l(String str) {
        return m(str, null);
    }

    public static Mode m(String str, String str2) {
        if ("Shift_JIS".equals(str2) && u(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else {
                if (r(charAt) == -1) {
                    return Mode.BYTE;
                }
                z10 = true;
            }
        }
        return z10 ? Mode.ALPHANUMERIC : z11 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static t6.f n(int i10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            t6.f i12 = t6.f.i(i11);
            if (x(i10, i12, errorCorrectionLevel)) {
                return i12;
            }
        }
        throw new WriterException("Data too big");
    }

    public static f o(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return p(str, errorCorrectionLevel, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static v6.f p(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<com.google.zxing.EncodeHintType, ?> r8) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "ISO-8859-1"
            if (r8 == 0) goto L15
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L15
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L16
        L15:
            r1 = r0
        L16:
            com.google.zxing.qrcode.decoder.Mode r2 = m(r6, r1)
            z5.a r3 = new z5.a
            r3.<init>()
            com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r2 != r4) goto L32
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
            com.google.zxing.common.CharacterSetECI r0 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r1)
            if (r0 == 0) goto L32
            d(r0, r3)
        L32:
            g(r2, r3)
            z5.a r0 = new z5.a
            r0.<init>()
            c(r6, r2, r0, r1)
            if (r8 == 0) goto L6a
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L6a
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            t6.f r8 = t6.f.i(r8)
            int r1 = i(r2, r3, r0, r8)
            boolean r1 = x(r1, r8, r7)
            if (r1 == 0) goto L62
            goto L6e
        L62:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L6a:
            t6.f r8 = v(r7, r2, r3, r0)
        L6e:
            z5.a r1 = new z5.a
            r1.<init>()
            r1.b(r3)
            if (r2 != r4) goto L7d
            int r6 = r0.m()
            goto L81
        L7d:
            int r6 = r6.length()
        L81:
            f(r6, r8, r2, r1)
            r1.b(r0)
            t6.f$b r6 = r8.f(r7)
            int r0 = r8.h()
            int r3 = r6.d()
            int r0 = r0 - r3
            w(r0, r1)
            int r3 = r8.h()
            int r6 = r6.c()
            z5.a r6 = t(r1, r3, r0, r6)
            v6.f r0 = new v6.f
            r0.<init>()
            r0.g(r7)
            r0.j(r2)
            r0.k(r8)
            int r1 = r8.e()
            v6.b r2 = new v6.b
            r2.<init>(r1, r1)
            int r1 = k(r6, r7, r8, r2)
            r0.h(r1)
            v6.e.a(r6, r7, r8, r1, r2)
            r0.i(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.c.p(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):v6.f");
    }

    public static byte[] q(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new b6.d(b6.a.f1288l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static int r(int i10) {
        int[] iArr = f31237a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public static void s(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 >= i12) {
            throw new WriterException("Block ID too large");
        }
        int i14 = i10 % i12;
        int i15 = i12 - i14;
        int i16 = i10 / i12;
        int i17 = i16 + 1;
        int i18 = i11 / i12;
        int i19 = i18 + 1;
        int i20 = i16 - i18;
        int i21 = i17 - i19;
        if (i20 != i21) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    public static z5.a t(z5.a aVar, int i10, int i11, int i12) throws WriterException {
        if (aVar.m() != i11) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < i12; i16++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            s(i10, i11, i12, i16, iArr, iArr2);
            int i17 = iArr[0];
            byte[] bArr = new byte[i17];
            aVar.t(i13 << 3, bArr, 0, i17);
            byte[] q10 = q(bArr, iArr2[0]);
            arrayList.add(new v6.a(bArr, q10));
            i14 = Math.max(i14, i17);
            i15 = Math.max(i15, q10.length);
            i13 += iArr[0];
        }
        if (i11 != i13) {
            throw new WriterException("Data bytes does not match offset");
        }
        z5.a aVar2 = new z5.a();
        for (int i18 = 0; i18 < i14; i18++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] a10 = ((v6.a) it.next()).a();
                if (i18 < a10.length) {
                    aVar2.c(a10[i18], 8);
                }
            }
        }
        for (int i19 = 0; i19 < i15; i19++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] b10 = ((v6.a) it2.next()).b();
                if (i19 < b10.length) {
                    aVar2.c(b10[i19], 8);
                }
            }
        }
        if (i10 == aVar2.m()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i10 + " and " + aVar2.m() + " differ.");
    }

    public static boolean u(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & 255;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static t6.f v(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, z5.a aVar, z5.a aVar2) throws WriterException {
        return n(i(mode, aVar, aVar2, n(i(mode, aVar, aVar2, t6.f.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void w(int i10, z5.a aVar) throws WriterException {
        int i11 = i10 << 3;
        if (aVar.l() > i11) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.l() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && aVar.l() < i11; i12++) {
            aVar.a(false);
        }
        int l10 = aVar.l() & 7;
        if (l10 > 0) {
            while (l10 < 8) {
                aVar.a(false);
                l10++;
            }
        }
        int m10 = i10 - aVar.m();
        for (int i13 = 0; i13 < m10; i13++) {
            aVar.c((i13 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.l() != i11) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static boolean x(int i10, t6.f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return fVar.h() - fVar.f(errorCorrectionLevel).d() >= (i10 + 7) / 8;
    }
}
