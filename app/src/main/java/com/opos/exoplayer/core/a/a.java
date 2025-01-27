package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.vivo.ic.dm.Downloads;
import java.nio.ByteBuffer;
import okio.Utf8;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static final int[] f17509a = {1, 2, 3, 6};

    /* renamed from: b */
    private static final int[] f17510b = {48000, 44100, 32000};

    /* renamed from: c */
    private static final int[] f17511c = {24000, 22050, 16000};

    /* renamed from: d */
    private static final int[] f17512d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e */
    private static final int[] f17513e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, Downloads.Impl.STATUS_RUNNING, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f */
    private static final int[] f17514f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.opos.exoplayer.core.a.a$a */
    public static final class C0398a {

        /* renamed from: a */
        public final String f17515a;

        /* renamed from: b */
        public final int f17516b;

        /* renamed from: c */
        public final int f17517c;

        /* renamed from: d */
        public final int f17518d;

        /* renamed from: e */
        public final int f17519e;

        /* renamed from: f */
        public final int f17520f;

        private C0398a(String str, int i2, int i3, int i4, int i5, int i6) {
            this.f17515a = str;
            this.f17516b = i2;
            this.f17518d = i3;
            this.f17517c = i4;
            this.f17519e = i5;
            this.f17520f = i6;
        }

        /* synthetic */ C0398a(String str, int i2, int i3, int i4, int i5, int i6, AnonymousClass1 anonymousClass1) {
            this(str, i2, i3, i4, i5, i6);
        }
    }

    public static int a() {
        return 1536;
    }

    private static int a(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 >= 0) {
            int[] iArr = f17510b;
            if (i2 < iArr.length && i3 >= 0) {
                int[] iArr2 = f17514f;
                if (i4 < iArr2.length) {
                    int i5 = iArr[i2];
                    if (i5 == 44100) {
                        return (iArr2[i4] + (i3 % 2)) * 2;
                    }
                    int i6 = f17513e[i4];
                    return i5 == 32000 ? i6 * 6 : i6 * 4;
                }
            }
        }
        return -1;
    }

    public static int a(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f17509a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return a((bArr[4] & 192) >> 6, bArr[4] & Utf8.REPLACEMENT_BYTE);
    }

    public static Format a(com.opos.exoplayer.core.i.m mVar, String str, String str2, DrmInitData drmInitData) {
        int i2 = f17510b[(mVar.g() & Downloads.Impl.STATUS_RUNNING) >> 6];
        int g2 = mVar.g();
        int i3 = f17512d[(g2 & 56) >> 3];
        if ((g2 & 4) != 0) {
            i3++;
        }
        return Format.a(str, "audio/ac3", null, -1, -1, i3, i2, null, drmInitData, 0, str2);
    }

    public static C0398a a(com.opos.exoplayer.core.i.l lVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int c2;
        int i7;
        int i8;
        int i9;
        int b2 = lVar.b();
        lVar.b(40);
        boolean z = lVar.c(5) == 16;
        lVar.a(b2);
        if (z) {
            lVar.b(16);
            int c3 = lVar.c(2);
            lVar.b(3);
            int c4 = (lVar.c(11) + 1) * 2;
            int c5 = lVar.c(2);
            if (c5 == 3) {
                i8 = f17511c[lVar.c(2)];
                c2 = 3;
                i7 = 6;
            } else {
                c2 = lVar.c(2);
                i7 = f17509a[c2];
                i8 = f17510b[c5];
            }
            int i10 = i7 * 256;
            int c6 = lVar.c(3);
            boolean e2 = lVar.e();
            int i11 = f17512d[c6] + (e2 ? 1 : 0);
            lVar.b(10);
            if (lVar.e()) {
                lVar.b(8);
            }
            if (c6 == 0) {
                lVar.b(5);
                if (lVar.e()) {
                    lVar.b(8);
                }
            }
            if (c3 == 1 && lVar.e()) {
                lVar.b(16);
            }
            if (lVar.e()) {
                if (c6 > 2) {
                    lVar.b(2);
                }
                if ((c6 & 1) != 0 && c6 > 2) {
                    lVar.b(6);
                }
                if ((c6 & 4) != 0) {
                    lVar.b(6);
                }
                if (e2 && lVar.e()) {
                    lVar.b(5);
                }
                if (c3 == 0) {
                    if (lVar.e()) {
                        lVar.b(6);
                    }
                    if (c6 == 0 && lVar.e()) {
                        lVar.b(6);
                    }
                    if (lVar.e()) {
                        lVar.b(6);
                    }
                    int c7 = lVar.c(2);
                    if (c7 == 1) {
                        lVar.b(5);
                    } else if (c7 == 2) {
                        lVar.b(12);
                    } else if (c7 == 3) {
                        int c8 = lVar.c(5);
                        if (lVar.e()) {
                            lVar.b(5);
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                lVar.b(4);
                            }
                            if (lVar.e()) {
                                if (lVar.e()) {
                                    lVar.b(4);
                                }
                                if (lVar.e()) {
                                    lVar.b(4);
                                }
                            }
                        }
                        if (lVar.e()) {
                            lVar.b(5);
                            if (lVar.e()) {
                                lVar.b(7);
                                if (lVar.e()) {
                                    lVar.b(8);
                                }
                            }
                        }
                        lVar.b((c8 + 2) * 8);
                        lVar.f();
                    }
                    if (c6 < 2) {
                        if (lVar.e()) {
                            lVar.b(14);
                        }
                        if (c6 == 0 && lVar.e()) {
                            lVar.b(14);
                        }
                    }
                    if (lVar.e()) {
                        if (c2 == 0) {
                            lVar.b(5);
                        } else {
                            for (int i12 = 0; i12 < i7; i12++) {
                                if (lVar.e()) {
                                    lVar.b(5);
                                }
                            }
                        }
                    }
                }
            }
            if (lVar.e()) {
                lVar.b(5);
                if (c6 == 2) {
                    lVar.b(4);
                }
                if (c6 >= 6) {
                    lVar.b(2);
                }
                if (lVar.e()) {
                    lVar.b(8);
                }
                if (c6 == 0 && lVar.e()) {
                    lVar.b(8);
                }
                i9 = 3;
                if (c5 < 3) {
                    lVar.d();
                }
            } else {
                i9 = 3;
            }
            if (c3 == 0 && c2 != i9) {
                lVar.d();
            }
            if (c3 == 2 && (c2 == i9 || lVar.e())) {
                lVar.b(6);
            }
            str = (lVar.e() && lVar.c(6) == 1 && lVar.c(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = c3;
            i2 = c4;
            i3 = i8;
            i6 = i10;
            i4 = i11;
        } else {
            lVar.b(32);
            int c9 = lVar.c(2);
            int a2 = a(c9, lVar.c(6));
            lVar.b(8);
            int c10 = lVar.c(3);
            if ((c10 & 1) != 0 && c10 != 1) {
                lVar.b(2);
            }
            if ((c10 & 4) != 0) {
                lVar.b(2);
            }
            if (c10 == 2) {
                lVar.b(2);
            }
            str = "audio/ac3";
            i2 = a2;
            i3 = f17510b[c9];
            i4 = f17512d[c10] + (lVar.e() ? 1 : 0);
            i5 = -1;
            i6 = 1536;
        }
        return new C0398a(str, i5, i4, i3, i2, i6);
    }

    public static int b(ByteBuffer byteBuffer) {
        if (byteBuffer.getInt(byteBuffer.position() + 4) != -1167101192) {
            return 0;
        }
        return 40 << (byteBuffer.get(byteBuffer.position() + 8) & 7);
    }

    public static int b(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && bArr[7] == -70) {
            return 40 << (bArr[8] & 7);
        }
        return 0;
    }

    public static Format b(com.opos.exoplayer.core.i.m mVar, String str, String str2, DrmInitData drmInitData) {
        mVar.d(2);
        int i2 = f17510b[(mVar.g() & Downloads.Impl.STATUS_RUNNING) >> 6];
        int g2 = mVar.g();
        int i3 = f17512d[(g2 & 14) >> 1];
        if ((g2 & 1) != 0) {
            i3++;
        }
        if (((mVar.g() & 30) >> 1) > 0 && (2 & mVar.g()) != 0) {
            i3 += 2;
        }
        return Format.a(str, (mVar.b() <= 0 || (mVar.g() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", null, -1, -1, i3, i2, null, drmInitData, 0, str2);
    }
}
