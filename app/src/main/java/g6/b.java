package g6;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sigmob.sdk.archives.tar.e;
import java.text.DecimalFormat;
import z5.d;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public static final char f26157a = 65520;

    /* renamed from: b */
    public static final char f26158b = 65521;

    /* renamed from: c */
    public static final char f26159c = 65522;

    /* renamed from: d */
    public static final char f26160d = 65523;

    /* renamed from: e */
    public static final char f26161e = 65524;

    /* renamed from: f */
    public static final char f26162f = 65525;

    /* renamed from: g */
    public static final char f26163g = 65526;

    /* renamed from: h */
    public static final char f26164h = 65527;

    /* renamed from: i */
    public static final char f26165i = 65528;

    /* renamed from: j */
    public static final char f26166j = 65529;

    /* renamed from: k */
    public static final char f26167k = 65530;

    /* renamed from: l */
    public static final char f26168l = 65531;

    /* renamed from: m */
    public static final char f26169m = 65532;

    /* renamed from: n */
    public static final char f26170n = 28;

    /* renamed from: o */
    public static final char f26171o = 29;

    /* renamed from: p */
    public static final char f26172p = 30;

    /* renamed from: q */
    public static final String[] f26173q = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    public static d a(byte[] bArr, int i10) {
        String h10;
        StringBuilder sb2 = new StringBuilder(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS);
        if (i10 == 2 || i10 == 3) {
            if (i10 == 2) {
                h10 = new DecimalFormat("0000000000".substring(0, g(bArr))).format(f(bArr));
            } else {
                h10 = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String format = decimalFormat.format(c(bArr));
            String format2 = decimalFormat.format(i(bArr));
            sb2.append(e(bArr, 10, 84));
            if (sb2.toString().startsWith("[)>\u001e01\u001d")) {
                sb2.insert(9, h10 + f26171o + format + f26171o + format2 + f26171o);
            } else {
                sb2.insert(0, h10 + f26171o + format + f26171o + format2 + f26171o);
            }
        } else if (i10 == 4) {
            sb2.append(e(bArr, 1, 93));
        } else if (i10 == 5) {
            sb2.append(e(bArr, 1, 77));
        }
        return new d(bArr, sb2.toString(), null, String.valueOf(i10));
    }

    public static int b(int i10, byte[] bArr) {
        int i11 = i10 - 1;
        return ((1 << (5 - (i11 % 6))) & bArr[i11 / 6]) == 0 ? 0 : 1;
    }

    public static int c(byte[] bArr) {
        return d(bArr, new byte[]{e.J, e.K, 43, 44, 45, 46, 47, e.E, 37, 38});
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i10 = 0;
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            i10 += b(bArr2[i11], bArr) << ((bArr2.length - i11) - 1);
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String e(byte[] bArr, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = i10;
        int i13 = 0;
        int i14 = -1;
        int i15 = 0;
        while (i12 < i10 + i11) {
            char charAt = f26173q[i13].charAt(bArr[i12]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i15 = i13;
                    i13 = charAt - f26157a;
                    i14 = 1;
                    break;
                case 65525:
                    i14 = 2;
                    i15 = i13;
                    i13 = 0;
                    break;
                case 65526:
                    i14 = 3;
                    i15 = i13;
                    i13 = 0;
                    break;
                case 65527:
                    i13 = 0;
                    i14 = -1;
                    break;
                case 65528:
                    i13 = 1;
                    i14 = -1;
                    break;
                case 65529:
                    i14 = -1;
                    break;
                case 65530:
                default:
                    sb2.append(charAt);
                    break;
                case 65531:
                    int i16 = (bArr[i12 + 1] << b5.a.B) + (bArr[i12 + 2] << b5.a.f1194u) + (bArr[i12 + 3] << 12) + (bArr[i12 + 4] << 6);
                    i12 += 5;
                    sb2.append(new DecimalFormat("000000000").format(i16 + bArr[i12]));
                    break;
            }
            int i17 = i14 - 1;
            if (i14 == 0) {
                i13 = i15;
            }
            i12++;
            i14 = i17;
        }
        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == 65532) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static int f(byte[] bArr) {
        return d(bArr, new byte[]{33, 34, 35, 36, b5.a.C, b5.a.D, b5.a.E, b5.a.F, b5.a.G, b5.a.H, 19, b5.a.f1197x, b5.a.f1198y, b5.a.f1199z, b5.a.A, b5.a.B, 13, 14, 15, 16, 17, b5.a.f1194u, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    public static int g(byte[] bArr) {
        return d(bArr, new byte[]{39, nf.c.f28885q, 41, 42, b5.a.I, 32});
    }

    public static String h(byte[] bArr) {
        String[] strArr = f26173q;
        return String.valueOf(new char[]{strArr[0].charAt(d(bArr, new byte[]{39, nf.c.f28885q, 41, 42, b5.a.I, 32})), strArr[0].charAt(d(bArr, new byte[]{33, 34, 35, 36, b5.a.C, b5.a.D})), strArr[0].charAt(d(bArr, new byte[]{b5.a.E, b5.a.F, b5.a.G, b5.a.H, 19, b5.a.f1197x})), strArr[0].charAt(d(bArr, new byte[]{b5.a.f1198y, b5.a.f1199z, b5.a.A, b5.a.B, 13, 14})), strArr[0].charAt(d(bArr, new byte[]{15, 16, 17, b5.a.f1194u, 7, 8})), strArr[0].charAt(d(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    public static int i(byte[] bArr) {
        return d(bArr, new byte[]{e.L, nf.c.f28888t, 57, 58, 59, 60, e.F, e.G, e.H, e.I});
    }
}
