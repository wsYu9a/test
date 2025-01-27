package t6;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import z5.k;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public static final char[] f30731a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: b */
    public static final int f30732b = 1;

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8 A[LOOP:0: B:2:0x001d->B:45:0x00e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static z5.d a(byte[] r17, t6.f r18, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.b.a(byte[], t6.f, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):z5.d");
    }

    public static void b(z5.c cVar, StringBuilder sb2, int i10, boolean z10) throws FormatException {
        while (i10 > 1) {
            if (cVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int d10 = cVar.d(11);
            sb2.append(h(d10 / 45));
            sb2.append(h(d10 % 45));
            i10 -= 2;
        }
        if (i10 == 1) {
            if (cVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(cVar.d(6)));
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        }
                    }
                    sb2.setCharAt(length, g6.b.f26171o);
                }
            }
        }
    }

    public static void c(z5.c cVar, StringBuilder sb2, int i10, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if ((i10 << 3) > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) cVar.d(8);
        }
        try {
            sb2.append(new String(bArr, characterSetECI == null ? k.a(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void d(z5.c cVar, StringBuilder sb2, int i10) throws FormatException {
        if (i10 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int d10 = cVar.d(13);
            int i12 = (d10 % 96) | ((d10 / 96) << 8);
            int i13 = i12 + (i12 < 959 ? 41377 : 42657);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        try {
            sb2.append(new String(bArr, k.f33692c));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void e(z5.c cVar, StringBuilder sb2, int i10) throws FormatException {
        if (i10 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int d10 = cVar.d(13);
            int i12 = (d10 % 192) | ((d10 / 192) << 8);
            int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        try {
            sb2.append(new String(bArr, k.f33691b));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void f(z5.c cVar, StringBuilder sb2, int i10) throws FormatException {
        while (i10 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int d10 = cVar.d(10);
            if (d10 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(d10 / 100));
            sb2.append(h((d10 / 10) % 10));
            sb2.append(h(d10 % 10));
            i10 -= 3;
        }
        if (i10 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int d11 = cVar.d(7);
            if (d11 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(d11 / 10));
            sb2.append(h(d11 % 10));
            return;
        }
        if (i10 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int d12 = cVar.d(4);
            if (d12 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(d12));
        }
    }

    public static int g(z5.c cVar) throws FormatException {
        int d10 = cVar.d(8);
        if ((d10 & 128) == 0) {
            return d10 & 127;
        }
        if ((d10 & 192) == 128) {
            return cVar.d(8) | ((d10 & 63) << 8);
        }
        if ((d10 & 224) == 192) {
            return cVar.d(16) | ((d10 & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static char h(int i10) throws FormatException {
        char[] cArr = f30731a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.getFormatInstance();
    }
}
