package com.kuaishou.weapon.p0;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10865a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10866b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10867c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10868d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f10869e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final int f10870f = 16;

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f10871g = true;

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f10872h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f10873a;

        /* renamed from: b, reason: collision with root package name */
        public int f10874b;

        public abstract int a(int i10);

        public abstract boolean a(byte[] bArr, int i10, int i11, boolean z10);
    }

    public static class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f10875c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f10876d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private static final int f10877e = -1;

        /* renamed from: f, reason: collision with root package name */
        private static final int f10878f = -2;

        /* renamed from: g, reason: collision with root package name */
        private int f10879g;

        /* renamed from: h, reason: collision with root package name */
        private int f10880h;

        /* renamed from: i, reason: collision with root package name */
        private final int[] f10881i;

        public b(int i10, byte[] bArr) {
            this.f10873a = bArr;
            this.f10881i = (i10 & 8) == 0 ? f10875c : f10876d;
            this.f10879g = 0;
            this.f10880h = 0;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i10) {
            return ((i10 * 3) / 4) + 10;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public boolean a(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.f10879g;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.f10880h;
            byte[] bArr2 = this.f10873a;
            int[] iArr = this.f10881i;
            int i15 = i14;
            int i16 = 0;
            int i17 = i12;
            int i18 = i10;
            while (i18 < i13) {
                if (i17 == 0) {
                    while (true) {
                        int i19 = i18 + 4;
                        if (i19 > i13 || (i15 = (iArr[bArr[i18] & 255] << 18) | (iArr[bArr[i18 + 1] & 255] << 12) | (iArr[bArr[i18 + 2] & 255] << 6) | iArr[bArr[i18 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i16 + 2] = (byte) i15;
                        bArr2[i16 + 1] = (byte) (i15 >> 8);
                        bArr2[i16] = (byte) (i15 >> 16);
                        i16 += 3;
                        i18 = i19;
                    }
                    if (i18 >= i13) {
                        break;
                    }
                }
                int i20 = i18 + 1;
                int i21 = iArr[bArr[i18] & 255];
                if (i17 != 0) {
                    if (i17 == 1) {
                        if (i21 < 0) {
                            if (i21 != -1) {
                                this.f10879g = 6;
                                return false;
                            }
                        }
                        i15 = (i15 << 6) | i21;
                        i17++;
                    } else if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 == 4) {
                                if (i21 != -2) {
                                    if (i21 != -1) {
                                        this.f10879g = 6;
                                        return false;
                                    }
                                }
                                i17++;
                            } else if (i17 == 5 && i21 != -1) {
                                this.f10879g = 6;
                                return false;
                            }
                        } else if (i21 >= 0) {
                            i15 = (i15 << 6) | i21;
                            bArr2[i16 + 2] = (byte) i15;
                            bArr2[i16 + 1] = (byte) (i15 >> 8);
                            bArr2[i16] = (byte) (i15 >> 16);
                            i16 += 3;
                            i18 = i20;
                            i17 = 0;
                        } else if (i21 == -2) {
                            bArr2[i16 + 1] = (byte) (i15 >> 2);
                            bArr2[i16] = (byte) (i15 >> 10);
                            i16 += 2;
                            i18 = i20;
                            i17 = 5;
                        } else if (i21 != -1) {
                            this.f10879g = 6;
                            return false;
                        }
                    } else if (i21 >= 0) {
                        i15 = (i15 << 6) | i21;
                        i17++;
                    } else if (i21 == -2) {
                        bArr2[i16] = (byte) (i15 >> 4);
                        i16++;
                        i18 = i20;
                        i17 = 4;
                    } else if (i21 != -1) {
                        this.f10879g = 6;
                        return false;
                    }
                } else if (i21 >= 0) {
                    i17++;
                    i15 = i21;
                } else if (i21 != -1) {
                    this.f10879g = 6;
                    return false;
                }
                i18 = i20;
            }
            if (!z10) {
                this.f10879g = i17;
                this.f10880h = i15;
                this.f10874b = i16;
                return true;
            }
            if (i17 == 1) {
                this.f10879g = 6;
                return false;
            }
            if (i17 == 2) {
                bArr2[i16] = (byte) (i15 >> 4);
                i16++;
            } else if (i17 == 3) {
                int i22 = i16 + 1;
                bArr2[i16] = (byte) (i15 >> 10);
                i16 += 2;
                bArr2[i22] = (byte) (i15 >> 2);
            } else if (i17 == 4) {
                this.f10879g = 6;
                return false;
            }
            this.f10879g = i17;
            this.f10874b = i16;
            return true;
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.c$c, reason: collision with other inner class name */
    public static class C0360c extends a {

        /* renamed from: c, reason: collision with root package name */
        public static final int f10882c = 19;

        /* renamed from: h, reason: collision with root package name */
        static final /* synthetic */ boolean f10883h = true;

        /* renamed from: i, reason: collision with root package name */
        private static final byte[] f10884i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.M, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.N, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.P, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.Q, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.O, 121, 122, com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, nf.c.f28888t, 57, 43, 47};

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f10885j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.M, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.N, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.P, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.Q, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.O, 121, 122, com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, nf.c.f28888t, 57, 45, 95};

        /* renamed from: d, reason: collision with root package name */
        int f10886d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10887e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f10888f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f10889g;

        /* renamed from: k, reason: collision with root package name */
        private final byte[] f10890k;

        /* renamed from: l, reason: collision with root package name */
        private int f10891l;

        /* renamed from: m, reason: collision with root package name */
        private final byte[] f10892m;

        public C0360c(int i10, byte[] bArr) {
            this.f10873a = bArr;
            this.f10887e = (i10 & 1) == 0;
            boolean z10 = (i10 & 2) == 0;
            this.f10888f = z10;
            this.f10889g = (i10 & 4) != 0;
            this.f10892m = (i10 & 8) == 0 ? f10884i : f10885j;
            this.f10890k = new byte[2];
            this.f10886d = 0;
            this.f10891l = z10 ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i10) {
            return ((i10 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01cc A[ADDED_TO_REGION] */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 514
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.C0360c.a(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }

    public static byte[] a(String str, int i10) {
        return a(str.getBytes(), i10);
    }

    public static String b(String str, int i10) {
        try {
            return new String(a(str.getBytes(), i10));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] c(byte[] bArr, int i10) {
        try {
            return c(bArr, 0, bArr.length, i10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(byte[] bArr, int i10, int i11, int i12) {
        C0360c c0360c = new C0360c(i12, null);
        int i13 = (i11 / 3) * 4;
        if (!c0360c.f10887e) {
            int i14 = i11 % 3;
            if (i14 == 1) {
                i13 += 2;
            } else if (i14 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (c0360c.f10888f && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (c0360c.f10889g ? 2 : 1);
        }
        c0360c.f10873a = new byte[i13];
        c0360c.a(bArr, i10, i11, true);
        if (f10871g || c0360c.f10874b == i13) {
            return c0360c.f10873a;
        }
        throw new AssertionError();
    }

    public static byte[] a(byte[] bArr, int i10) {
        return a(bArr, 0, bArr.length, i10);
    }

    public static String b(byte[] bArr, int i10) {
        try {
            return new String(c(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static byte[] a(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, new byte[(i11 * 3) / 4]);
        if (bVar.a(bArr, i10, i11, true)) {
            int i13 = bVar.f10874b;
            byte[] bArr2 = bVar.f10873a;
            if (i13 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr2, 0, bArr3, 0, i13);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String b(byte[] bArr, int i10, int i11, int i12) {
        try {
            return new String(c(bArr, i10, i11, i12), "US-ASCII");
        } catch (Throwable th2) {
            throw new AssertionError(th2);
        }
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(c(bArr, 0), str);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    return f10872h.matcher(str).matches();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
