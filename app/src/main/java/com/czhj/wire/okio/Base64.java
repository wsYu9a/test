package com.czhj.wire.okio;

import com.sigmob.sdk.archives.tar.e;
import java.io.UnsupportedEncodingException;
import nf.c;

/* loaded from: classes2.dex */
final class Base64 {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f8895a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, e.M, 77, 78, 79, 80, 81, 82, e.N, 84, 85, 86, 87, e.P, 89, 90, 97, 98, 99, 100, 101, 102, e.Q, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, e.O, 121, 122, e.E, e.F, e.G, e.H, e.I, e.J, e.K, e.L, c.f28888t, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f8896b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, e.M, 77, 78, 79, 80, 81, 82, e.N, 84, 85, 86, 87, e.P, 89, 90, 97, 98, 99, 100, 101, 102, e.Q, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, e.O, 121, 122, e.E, e.F, e.G, e.H, e.I, e.J, e.K, e.L, c.f28888t, 57, 45, 95};

    public static String a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) * 4) / 3];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 3) {
            bArr3[i10] = bArr2[(bArr[i11] & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i10 + 1] = bArr2[((bArr[i11] & 3) << 4) | ((bArr[i12] & 255) >> 4)];
            int i13 = i10 + 3;
            int i14 = (bArr[i12] & 15) << 2;
            int i15 = i11 + 2;
            bArr3[i10 + 2] = bArr2[i14 | ((bArr[i15] & 255) >> 6)];
            i10 += 4;
            bArr3[i13] = bArr2[bArr[i15] & okio.Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            bArr3[i10 + 1] = bArr2[(bArr[length] & 3) << 4];
            int i16 = i10 + 3;
            bArr3[i10 + 2] = kotlin.io.encoding.Base64.padSymbol;
            i10 += 4;
            bArr3[i16] = kotlin.io.encoding.Base64.padSymbol;
        } else if (length2 == 2) {
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            int i17 = (bArr[length] & 3) << 4;
            int i18 = length + 1;
            bArr3[i10 + 1] = bArr2[((bArr[i18] & 255) >> 4) | i17];
            int i19 = i10 + 3;
            bArr3[i10 + 2] = bArr2[(bArr[i18] & 15) << 2];
            i10 += 4;
            bArr3[i19] = kotlin.io.encoding.Base64.padSymbol;
        }
        try {
            return new String(bArr3, 0, i10, "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static byte[] decode(String str) {
        int i10;
        char charAt;
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char charAt2 = str.charAt(i15);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i10 = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i10 = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i10 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i10 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i10 = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i14 = (i14 << 6) | ((byte) i10);
            i12++;
            if (i12 % 4 == 0) {
                bArr[i13] = (byte) (i14 >> 16);
                int i16 = i13 + 2;
                bArr[i13 + 1] = (byte) (i14 >> 8);
                i13 += 3;
                bArr[i16] = (byte) i14;
            }
        }
        int i17 = i12 % 4;
        if (i17 == 1) {
            return null;
        }
        if (i17 == 2) {
            bArr[i13] = (byte) ((i14 << 12) >> 16);
            i13++;
        } else if (i17 == 3) {
            int i18 = i14 << 6;
            int i19 = i13 + 1;
            bArr[i13] = (byte) (i18 >> 16);
            i13 += 2;
            bArr[i19] = (byte) (i18 >> 8);
        }
        if (i13 == i11) {
            return bArr;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, 0, bArr2, 0, i13);
        return bArr2;
    }

    public static String encode(byte[] bArr) {
        return a(bArr, f8895a);
    }

    public static String encodeUrl(byte[] bArr) {
        return a(bArr, f8896b);
    }
}
