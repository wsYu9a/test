package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.k;
import com.vivo.ic.dm.Downloads;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a */
    private static final char[] f8752a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: b */
    private static final int f8753b = 1;

    private c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea A[LOOP:0: B:2:0x001d->B:46:0x00ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.zxing.common.d a(byte[] r17, com.google.zxing.qrcode.decoder.g r18, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.c.a(byte[], com.google.zxing.qrcode.decoder.g, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.common.d");
    }

    private static void b(com.google.zxing.common.c cVar, StringBuilder sb, int i2, boolean z) throws FormatException {
        while (i2 > 1) {
            if (cVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int d2 = cVar.d(11);
            sb.append(h(d2 / 45));
            sb.append(h(d2 % 45));
            i2 -= 2;
        }
        if (i2 == 1) {
            if (cVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(cVar.d(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(com.google.zxing.common.c cVar, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if ((i2 << 3) > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) cVar.d(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? k.a(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void d(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int d2 = cVar.d(13);
            int i4 = (d2 % 96) | ((d2 / 96) << 8);
            int i5 = i4 + (i4 < 959 ? 41377 : 42657);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, k.f8328c));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void e(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int d2 = cVar.d(13);
            int i4 = (d2 % Downloads.Impl.STATUS_RUNNING) | ((d2 / Downloads.Impl.STATUS_RUNNING) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, k.f8327b));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void f(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int d2 = cVar.d(10);
            if (d2 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(d2 / 100));
            sb.append(h((d2 / 10) % 10));
            sb.append(h(d2 % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int d3 = cVar.d(7);
            if (d3 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(d3 / 10));
            sb.append(h(d3 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int d4 = cVar.d(4);
            if (d4 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(d4));
        }
    }

    private static int g(com.google.zxing.common.c cVar) throws FormatException {
        int d2 = cVar.d(8);
        if ((d2 & 128) == 0) {
            return d2 & 127;
        }
        if ((d2 & Downloads.Impl.STATUS_RUNNING) == 128) {
            return cVar.d(8) | ((d2 & 63) << 8);
        }
        if ((d2 & 224) == 192) {
            return cVar.d(16) | ((d2 & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char h(int i2) throws FormatException {
        char[] cArr = f8752a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.getFormatInstance();
    }
}
