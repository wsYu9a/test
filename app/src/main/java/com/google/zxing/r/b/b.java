package com.google.zxing.r.b;

import com.google.zxing.common.d;
import com.vivo.advv.virtualview.common.ExprCommon;
import java.text.DecimalFormat;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private static final char f8801a = 65520;

    /* renamed from: b */
    private static final char f8802b = 65521;

    /* renamed from: c */
    private static final char f8803c = 65522;

    /* renamed from: d */
    private static final char f8804d = 65523;

    /* renamed from: e */
    private static final char f8805e = 65524;

    /* renamed from: f */
    private static final char f8806f = 65525;

    /* renamed from: g */
    private static final char f8807g = 65526;

    /* renamed from: h */
    private static final char f8808h = 65527;

    /* renamed from: i */
    private static final char f8809i = 65528;

    /* renamed from: j */
    private static final char f8810j = 65529;
    private static final char k = 65530;
    private static final char l = 65531;
    private static final char m = 65532;
    private static final char n = 28;
    private static final char o = 29;
    private static final char p = 30;
    private static final String[] q = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private b() {
    }

    static d a(byte[] bArr, int i2) {
        String h2;
        StringBuilder sb = new StringBuilder(144);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                h2 = new DecimalFormat("0000000000".substring(0, g(bArr))).format(f(bArr));
            } else {
                h2 = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String format = decimalFormat.format(c(bArr));
            String format2 = decimalFormat.format(i(bArr));
            sb.append(e(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, h2 + o + format + o + format2 + o);
            } else {
                sb.insert(0, h2 + o + format + o + format2 + o);
            }
        } else if (i2 == 4) {
            sb.append(e(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(e(bArr, 1, 77));
        }
        return new d(bArr, sb.toString(), null, String.valueOf(i2));
    }

    private static int b(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    private static int c(byte[] bArr) {
        return d(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int d(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            i2 += b(bArr2[i3], bArr) << ((bArr2.length - i3) - 1);
        }
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String e(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i2;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (i4 < i2 + i3) {
            char charAt = q[i5].charAt(bArr[i4]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i7 = i5;
                    i5 = charAt - f8801a;
                    i6 = 1;
                    break;
                case 65525:
                    i6 = 2;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65526:
                    i6 = 3;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65527:
                    i5 = 0;
                    i6 = -1;
                    break;
                case 65528:
                    i5 = 1;
                    i6 = -1;
                    break;
                case 65529:
                    i6 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = bArr[i8] << ExprCommon.OPCODE_OR;
                    int i10 = i8 + 1;
                    int i11 = i9 + (bArr[i10] << ExprCommon.OPCODE_MUL_EQ);
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 12);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 6);
                    i4 = i14 + 1;
                    sb.append(new DecimalFormat("000000000").format(i15 + bArr[i4]));
                    break;
            }
            int i16 = i6 - 1;
            if (i6 == 0) {
                i5 = i7;
            }
            i4++;
            i6 = i16;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int f(byte[] bArr) {
        return d(bArr, new byte[]{33, 34, 35, 36, ExprCommon.OPCODE_ARRAY, 26, 27, 28, 29, 30, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_MOD_EQ, ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_OR, 13, 14, 15, 16, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_MUL_EQ, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static int g(byte[] bArr) {
        return d(bArr, new byte[]{39, 40, 41, 42, 31, g.s});
    }

    private static String h(byte[] bArr) {
        String[] strArr = q;
        return String.valueOf(new char[]{strArr[0].charAt(d(bArr, new byte[]{39, 40, 41, 42, 31, g.s})), strArr[0].charAt(d(bArr, new byte[]{33, 34, 35, 36, ExprCommon.OPCODE_ARRAY, 26})), strArr[0].charAt(d(bArr, new byte[]{27, 28, 29, 30, ExprCommon.OPCODE_DIV_EQ, ExprCommon.OPCODE_MOD_EQ})), strArr[0].charAt(d(bArr, new byte[]{ExprCommon.OPCODE_JMP, ExprCommon.OPCODE_JMP_C, ExprCommon.OPCODE_AND, ExprCommon.OPCODE_OR, 13, 14})), strArr[0].charAt(d(bArr, new byte[]{15, 16, ExprCommon.OPCODE_SUB_EQ, ExprCommon.OPCODE_MUL_EQ, 7, 8})), strArr[0].charAt(d(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    private static int i(byte[] bArr) {
        return d(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }
}
