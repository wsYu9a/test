package com.google.zxing.datamatrix.decoder;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.FormatException;
import e6.j;
import g6.b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.text.Typography;
import m5.d;
import z5.c;
import z5.k;

/* loaded from: classes2.dex */
public final class DecodedBitStreamParser {

    /* renamed from: a */
    public static final char[] f10555a = {'*', '*', '*', b5.a.O, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b */
    public static final char[] f10556b;

    /* renamed from: c */
    public static final char[] f10557c;

    /* renamed from: d */
    public static final char[] f10558d;

    /* renamed from: e */
    public static final char[] f10559e;

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10560a;

        static {
            int[] iArr = new int[Mode.values().length];
            f10560a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10560a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10560a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10560a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10560a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', '$', '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', d.f28378d, ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
        f10556b = cArr;
        f10557c = new char[]{'*', '*', '*', b5.a.O, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f10558d = cArr;
        f10559e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', b5.a.N};
    }

    public static z5.d a(byte[] bArr) throws FormatException {
        c cVar = new c(bArr);
        StringBuilder sb2 = new StringBuilder(100);
        StringBuilder sb3 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            Mode mode2 = Mode.ASCII_ENCODE;
            if (mode == mode2) {
                mode = c(cVar, sb2, sb3);
            } else {
                int i10 = a.f10560a[mode.ordinal()];
                if (i10 == 1) {
                    e(cVar, sb2);
                } else if (i10 == 2) {
                    g(cVar, sb2);
                } else if (i10 == 3) {
                    b(cVar, sb2);
                } else if (i10 == 4) {
                    f(cVar, sb2);
                } else {
                    if (i10 != 5) {
                        throw FormatException.getFormatInstance();
                    }
                    d(cVar, sb2, arrayList);
                }
                mode = mode2;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb3.length() > 0) {
            sb2.append((CharSequence) sb3);
        }
        String sb4 = sb2.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new z5.d(bArr, sb4, arrayList, null);
    }

    public static void b(c cVar, StringBuilder sb2) throws FormatException {
        int d10;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d10 = cVar.d(8)) != 254) {
            h(d10, cVar.d(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0) {
                    sb2.append('\r');
                } else if (i11 == 1) {
                    sb2.append('*');
                } else if (i11 == 2) {
                    sb2.append(Typography.greater);
                } else if (i11 == 3) {
                    sb2.append(b5.a.O);
                } else if (i11 < 14) {
                    sb2.append((char) (i11 + 44));
                } else {
                    if (i11 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    sb2.append((char) (i11 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static Mode c(c cVar, StringBuilder sb2, StringBuilder sb3) throws FormatException {
        boolean z10 = false;
        do {
            int d10 = cVar.d(8);
            if (d10 == 0) {
                throw FormatException.getFormatInstance();
            }
            if (d10 <= 128) {
                if (z10) {
                    d10 += 128;
                }
                sb2.append((char) (d10 - 1));
                return Mode.ASCII_ENCODE;
            }
            if (d10 == 129) {
                return Mode.PAD_ENCODE;
            }
            if (d10 <= 229) {
                int i10 = d10 - 130;
                if (i10 < 10) {
                    sb2.append('0');
                }
                sb2.append(i10);
            } else {
                if (d10 == 230) {
                    return Mode.C40_ENCODE;
                }
                if (d10 == 231) {
                    return Mode.BASE256_ENCODE;
                }
                if (d10 == 232) {
                    sb2.append(b.f26171o);
                } else if (d10 != 233 && d10 != 234) {
                    if (d10 == 235) {
                        z10 = true;
                    } else if (d10 == 236) {
                        sb2.append(j.f25738l);
                        sb3.insert(0, j.f25740n);
                    } else if (d10 == 237) {
                        sb2.append(j.f25739m);
                        sb3.insert(0, j.f25740n);
                    } else {
                        if (d10 == 238) {
                            return Mode.ANSIX12_ENCODE;
                        }
                        if (d10 == 239) {
                            return Mode.TEXT_ENCODE;
                        }
                        if (d10 == 240) {
                            return Mode.EDIFACT_ENCODE;
                        }
                        if (d10 != 241 && d10 >= 242 && (d10 != 254 || cVar.a() != 0)) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    public static void d(c cVar, StringBuilder sb2, Collection<byte[]> collection) throws FormatException {
        int c10 = cVar.c();
        int i10 = c10 + 2;
        int i11 = i(cVar.d(8), c10 + 1);
        if (i11 == 0) {
            i11 = cVar.a() / 8;
        } else if (i11 >= 250) {
            i11 = ((i11 - 249) * 250) + i(cVar.d(8), i10);
            i10 = c10 + 3;
        }
        if (i11 < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            if (cVar.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i12] = (byte) i(cVar.d(8), i10);
            i12++;
            i10++;
        }
        collection.add(bArr);
        try {
            sb2.append(new String(bArr, k.f33695f));
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException("Platform does not support required encoding: " + e10);
        }
    }

    public static void e(c cVar, StringBuilder sb2) throws FormatException {
        int d10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (d10 = cVar.d(8)) != 254) {
            h(d10, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f10556b;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb2.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb2.append(c10);
                                }
                            } else if (i12 == 27) {
                                sb2.append(b.f26171o);
                            } else {
                                if (i12 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z10 = true;
                            }
                            i10 = 0;
                        } else {
                            if (i10 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z10) {
                                sb2.append((char) (i12 + 224));
                                z10 = false;
                                i10 = 0;
                            } else {
                                sb2.append((char) (i12 + 96));
                                i10 = 0;
                            }
                        }
                    } else if (z10) {
                        sb2.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb2.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr2 = f10555a;
                    if (i12 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c11 = cArr2[i12];
                    if (z10) {
                        sb2.append((char) (c11 + 128));
                        z10 = false;
                    } else {
                        sb2.append(c11);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void f(c cVar, StringBuilder sb2) {
        while (cVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int d10 = cVar.d(6);
                if (d10 == 31) {
                    int b10 = 8 - cVar.b();
                    if (b10 != 8) {
                        cVar.d(b10);
                        return;
                    }
                    return;
                }
                if ((d10 & 32) == 0) {
                    d10 |= 64;
                }
                sb2.append((char) d10);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void g(c cVar, StringBuilder sb2) throws FormatException {
        int d10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (d10 = cVar.d(8)) != 254) {
            h(d10, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f10558d;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb2.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb2.append(c10);
                                }
                            } else if (i12 == 27) {
                                sb2.append(b.f26171o);
                            } else {
                                if (i12 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z10 = true;
                            }
                            i10 = 0;
                        } else {
                            if (i10 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = f10559e;
                            if (i12 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c11 = cArr2[i12];
                            if (z10) {
                                sb2.append((char) (c11 + 128));
                                z10 = false;
                                i10 = 0;
                            } else {
                                sb2.append(c11);
                                i10 = 0;
                            }
                        }
                    } else if (z10) {
                        sb2.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb2.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr3 = f10557c;
                    if (i12 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c12 = cArr3[i12];
                    if (z10) {
                        sb2.append((char) (c12 + 128));
                        z10 = false;
                    } else {
                        sb2.append(c12);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void h(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    public static int i(int i10, int i11) {
        int i12 = i10 - (((i11 * TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }
}
