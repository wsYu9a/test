package a3;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f51a = true;

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f52a;

        /* renamed from: b, reason: collision with root package name */
        public int f53b;
    }

    /* renamed from: a3.b$b, reason: collision with other inner class name */
    public static class C0001b extends a {

        /* renamed from: f, reason: collision with root package name */
        public static final int[] f54f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g, reason: collision with root package name */
        public static final int[] f55g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c, reason: collision with root package name */
        public int f56c;

        /* renamed from: d, reason: collision with root package name */
        public int f57d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f58e;

        public C0001b(int i10, byte[] bArr) {
            this.f52a = bArr;
            this.f58e = (i10 & 8) == 0 ? f54f : f55g;
            this.f56c = 0;
            this.f57d = 0;
        }

        public boolean a(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.f56c;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.f57d;
            byte[] bArr2 = this.f52a;
            int[] iArr = this.f58e;
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
                                this.f56c = 6;
                                return false;
                            }
                        }
                        i21 |= i15 << 6;
                    } else if (i17 == 2) {
                        if (i21 < 0) {
                            if (i21 == -2) {
                                bArr2[i16] = (byte) (i15 >> 4);
                                i16++;
                                i17 = 4;
                            } else if (i21 != -1) {
                                this.f56c = 6;
                                return false;
                            }
                        }
                        i21 |= i15 << 6;
                    } else if (i17 != 3) {
                        if (i17 != 4) {
                            if (i17 == 5 && i21 != -1) {
                                this.f56c = 6;
                                return false;
                            }
                        } else if (i21 == -2) {
                            i17++;
                        } else if (i21 != -1) {
                            this.f56c = 6;
                            return false;
                        }
                    } else if (i21 >= 0) {
                        int i22 = i21 | (i15 << 6);
                        bArr2[i16 + 2] = (byte) i22;
                        bArr2[i16 + 1] = (byte) (i22 >> 8);
                        bArr2[i16] = (byte) (i22 >> 16);
                        i16 += 3;
                        i15 = i22;
                        i17 = 0;
                    } else if (i21 == -2) {
                        bArr2[i16 + 1] = (byte) (i15 >> 2);
                        bArr2[i16] = (byte) (i15 >> 10);
                        i16 += 2;
                        i17 = 5;
                    } else if (i21 != -1) {
                        this.f56c = 6;
                        return false;
                    }
                    i17++;
                    i15 = i21;
                } else {
                    if (i21 < 0) {
                        if (i21 != -1) {
                            this.f56c = 6;
                            return false;
                        }
                    }
                    i17++;
                    i15 = i21;
                }
                i18 = i20;
            }
            if (!z10) {
                this.f56c = i17;
                this.f57d = i15;
                this.f53b = i16;
                return true;
            }
            if (i17 == 1) {
                this.f56c = 6;
                return false;
            }
            if (i17 == 2) {
                bArr2[i16] = (byte) (i15 >> 4);
                i16++;
            } else if (i17 == 3) {
                int i23 = i16 + 1;
                bArr2[i16] = (byte) (i15 >> 10);
                i16 += 2;
                bArr2[i23] = (byte) (i15 >> 2);
            } else if (i17 == 4) {
                this.f56c = 6;
                return false;
            }
            this.f56c = i17;
            this.f53b = i16;
            return true;
        }
    }

    public static class c extends a {

        /* renamed from: j, reason: collision with root package name */
        public static final byte[] f59j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.M, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.N, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.P, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.Q, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.O, 121, 122, com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, nf.c.f28888t, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        public static final byte[] f60k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.M, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.N, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.P, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.Q, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.O, 121, 122, com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, nf.c.f28888t, 57, 45, 95};

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ boolean f61l = true;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f62c;

        /* renamed from: d, reason: collision with root package name */
        public int f63d;

        /* renamed from: e, reason: collision with root package name */
        public int f64e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f65f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f66g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f67h;

        /* renamed from: i, reason: collision with root package name */
        public final byte[] f68i;

        public c(int i10, byte[] bArr) {
            this.f52a = bArr;
            this.f65f = (i10 & 1) == 0;
            boolean z10 = (i10 & 2) == 0;
            this.f66g = z10;
            this.f67h = (i10 & 4) != 0;
            this.f68i = (i10 & 8) == 0 ? f59j : f60k;
            this.f62c = new byte[2];
            this.f63d = 0;
            this.f64e = z10 ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01ca A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a3.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i10) {
        return b(bArr, 0, bArr.length, i10);
    }

    public static byte[] b(byte[] bArr, int i10, int i11, int i12) {
        C0001b c0001b = new C0001b(i12, new byte[(i11 * 3) / 4]);
        if (!c0001b.a(bArr, i10, i11, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i13 = c0001b.f53b;
        byte[] bArr2 = c0001b.f52a;
        if (i13 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i13];
        System.arraycopy(bArr2, 0, bArr3, 0, i13);
        return bArr3;
    }

    public static byte[] c(byte[] bArr, int i10) {
        return d(bArr, 0, bArr.length, i10);
    }

    @SuppressLint({"Assert"})
    public static byte[] d(byte[] bArr, int i10, int i11, int i12) {
        c cVar = new c(i12, null);
        int i13 = (i11 / 3) * 4;
        if (!cVar.f65f) {
            int i14 = i11 % 3;
            if (i14 == 1) {
                i13 += 2;
            } else if (i14 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (cVar.f66g && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (cVar.f67h ? 2 : 1);
        }
        cVar.f52a = new byte[i13];
        cVar.a(bArr, i10, i11, true);
        if (f51a || cVar.f53b == i13) {
            return cVar.f52a;
        }
        throw new AssertionError();
    }

    public static String e(byte[] bArr, int i10) {
        try {
            return new String(c(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
