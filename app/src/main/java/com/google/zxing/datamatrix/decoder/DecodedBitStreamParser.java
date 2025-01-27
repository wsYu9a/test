package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.text.Typography;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {

    /* renamed from: a */
    private static final char[] f8360a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b */
    private static final char[] f8361b;

    /* renamed from: c */
    private static final char[] f8362c;

    /* renamed from: d */
    private static final char[] f8363d;

    /* renamed from: e */
    private static final char[] f8364e;

    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8365a;

        static {
            int[] iArr = new int[Mode.values().length];
            f8365a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8365a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8365a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8365a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8365a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
        f8361b = cArr;
        f8362c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f8363d = cArr;
        f8364e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    private DecodedBitStreamParser() {
    }

    static com.google.zxing.common.d a(byte[] bArr) throws FormatException {
        com.google.zxing.common.c cVar = new com.google.zxing.common.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            Mode mode2 = Mode.ASCII_ENCODE;
            if (mode == mode2) {
                mode = c(cVar, sb, sb2);
            } else {
                int i2 = a.f8365a[mode.ordinal()];
                if (i2 == 1) {
                    e(cVar, sb);
                } else if (i2 == 2) {
                    g(cVar, sb);
                } else if (i2 == 3) {
                    b(cVar, sb);
                } else if (i2 == 4) {
                    f(cVar, sb);
                } else {
                    if (i2 != 5) {
                        throw FormatException.getFormatInstance();
                    }
                    d(cVar, sb, arrayList);
                }
                mode = mode2;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new com.google.zxing.common.d(bArr, sb3, arrayList, null);
    }

    private static void b(com.google.zxing.common.c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append(Typography.greater);
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else {
                    if (i3 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    sb.append((char) (i3 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static Mode c(com.google.zxing.common.c cVar, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int d2 = cVar.d(8);
            if (d2 == 0) {
                throw FormatException.getFormatInstance();
            }
            if (d2 <= 128) {
                if (z) {
                    d2 += 128;
                }
                sb.append((char) (d2 - 1));
                return Mode.ASCII_ENCODE;
            }
            if (d2 == 129) {
                return Mode.PAD_ENCODE;
            }
            if (d2 <= 229) {
                int i2 = d2 - 130;
                if (i2 < 10) {
                    sb.append('0');
                }
                sb.append(i2);
            } else {
                if (d2 == 230) {
                    return Mode.C40_ENCODE;
                }
                if (d2 == 231) {
                    return Mode.BASE256_ENCODE;
                }
                if (d2 == 232) {
                    sb.append((char) 29);
                } else if (d2 != 233 && d2 != 234) {
                    if (d2 == 235) {
                        z = true;
                    } else if (d2 == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (d2 == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (d2 == 238) {
                            return Mode.ANSIX12_ENCODE;
                        }
                        if (d2 == 239) {
                            return Mode.TEXT_ENCODE;
                        }
                        if (d2 == 240) {
                            return Mode.EDIFACT_ENCODE;
                        }
                        if (d2 != 241 && d2 >= 242 && (d2 != 254 || cVar.a() != 0)) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void d(com.google.zxing.common.c cVar, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int c2 = cVar.c() + 1;
        int i2 = c2 + 1;
        int i3 = i(cVar.d(8), c2);
        if (i3 == 0) {
            i3 = cVar.a() / 8;
        } else if (i3 >= 250) {
            i3 = ((i3 - 249) * 250) + i(cVar.d(8), i2);
            i2++;
        }
        if (i3 < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            if (cVar.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i4] = (byte) i(cVar.d(8), i2);
            i4++;
            i2++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: " + e2);
        }
    }

    private static void e(com.google.zxing.common.c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f8361b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z) {
                                sb.append((char) (i4 + 224));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f8360a;
                    if (i4 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c3 = cArr2[i4];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(com.google.zxing.common.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int d2 = cVar.d(6);
                if (d2 == 31) {
                    int b2 = 8 - cVar.b();
                    if (b2 != 8) {
                        cVar.d(b2);
                        return;
                    }
                    return;
                }
                if ((d2 & 32) == 0) {
                    d2 |= 64;
                }
                sb.append((char) d2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(com.google.zxing.common.c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f8363d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = f8364e;
                            if (i4 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c3 = cArr2[i4];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f8362c;
                    if (i4 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c4 = cArr3[i4];
                    if (z) {
                        sb.append((char) (c4 + 128));
                        z = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static int i(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
