package b.i.a.a.a;

import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5056a = true;

    static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f5057a;

        /* renamed from: b, reason: collision with root package name */
        public int f5058b;

        a() {
        }
    }

    /* renamed from: b.i.a.a.a.b$b, reason: collision with other inner class name */
    static class C0057b extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f5059c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f5060d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private int f5061e;

        /* renamed from: f, reason: collision with root package name */
        private int f5062f;

        /* renamed from: g, reason: collision with root package name */
        private final int[] f5063g;

        public C0057b(int i2, byte[] bArr) {
            this.f5057a = bArr;
            this.f5063g = (i2 & 8) == 0 ? f5059c : f5060d;
            this.f5061e = 0;
            this.f5062f = 0;
        }

        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            int i4 = this.f5061e;
            if (i4 == 6) {
                return false;
            }
            int i5 = i3 + i2;
            int i6 = this.f5062f;
            byte[] bArr2 = this.f5057a;
            int[] iArr = this.f5063g;
            int i7 = i6;
            int i8 = 0;
            int i9 = i4;
            int i10 = i2;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5) {
                            break;
                        }
                        i7 = iArr[bArr[i10 + 3] & 255] | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 2] & 255] << 6);
                        if (i7 < 0) {
                            break;
                        }
                        bArr2[i8 + 2] = (byte) i7;
                        bArr2[i8 + 1] = (byte) (i7 >> 8);
                        bArr2[i8] = (byte) (i7 >> 16);
                        i8 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.f5061e = 6;
                                return false;
                            }
                        }
                        i7 = (i7 << 6) | i13;
                        i9++;
                    } else if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 == 4) {
                                if (i13 != -2) {
                                    if (i13 != -1) {
                                        this.f5061e = 6;
                                        return false;
                                    }
                                }
                                i9++;
                            } else if (i9 == 5 && i13 != -1) {
                                this.f5061e = 6;
                                return false;
                            }
                        } else if (i13 >= 0) {
                            i7 = (i7 << 6) | i13;
                            bArr2[i8 + 2] = (byte) i7;
                            bArr2[i8 + 1] = (byte) (i7 >> 8);
                            bArr2[i8] = (byte) (i7 >> 16);
                            i8 += 3;
                            i10 = i12;
                            i9 = 0;
                        } else if (i13 == -2) {
                            bArr2[i8 + 1] = (byte) (i7 >> 2);
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 += 2;
                            i10 = i12;
                            i9 = 5;
                        } else if (i13 != -1) {
                            this.f5061e = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        i7 = (i7 << 6) | i13;
                        i9++;
                    } else if (i13 == -2) {
                        bArr2[i8] = (byte) (i7 >> 4);
                        i8++;
                        i10 = i12;
                        i9 = 4;
                    } else if (i13 != -1) {
                        this.f5061e = 6;
                        return false;
                    }
                } else if (i13 >= 0) {
                    i9++;
                    i7 = i13;
                } else if (i13 != -1) {
                    this.f5061e = 6;
                    return false;
                }
                i10 = i12;
            }
            if (!z) {
                this.f5061e = i9;
                this.f5062f = i7;
                this.f5058b = i8;
                return true;
            }
            if (i9 == 1) {
                this.f5061e = 6;
                return false;
            }
            if (i9 == 2) {
                bArr2[i8] = (byte) (i7 >> 4);
                i8++;
            } else if (i9 == 3) {
                int i14 = i8 + 1;
                bArr2[i8] = (byte) (i7 >> 10);
                i8 = i14 + 1;
                bArr2[i14] = (byte) (i7 >> 2);
            } else if (i9 == 4) {
                this.f5061e = 6;
                return false;
            }
            this.f5061e = i9;
            this.f5058b = i8;
            return true;
        }
    }

    static class c extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final byte[] f5064c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: d, reason: collision with root package name */
        private static final byte[] f5065d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ boolean f5066e = true;

        /* renamed from: f, reason: collision with root package name */
        private final byte[] f5067f;

        /* renamed from: g, reason: collision with root package name */
        int f5068g;

        /* renamed from: h, reason: collision with root package name */
        private int f5069h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f5070i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f5071j;
        public final boolean k;
        private final byte[] l;

        public c(int i2, byte[] bArr) {
            this.f5057a = bArr;
            this.f5070i = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f5071j = z;
            this.k = (i2 & 4) != 0;
            this.l = (i2 & 8) == 0 ? f5064c : f5065d;
            this.f5067f = new byte[2];
            this.f5068g = 0;
            this.f5069h = z ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0094 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0178 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 517
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: b.i.a.a.a.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private b() {
    }

    public static byte[] a(String str, int i2) {
        return b(str.getBytes(), i2);
    }

    public static byte[] b(byte[] bArr, int i2) {
        return c(bArr, 0, bArr.length, i2);
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) {
        C0057b c0057b = new C0057b(i4, new byte[(i3 * 3) / 4]);
        if (!c0057b.a(bArr, i2, i3, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i5 = c0057b.f5058b;
        byte[] bArr2 = c0057b.f5057a;
        if (i5 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr3, 0, i5);
        return bArr3;
    }

    public static byte[] d(byte[] bArr, int i2) {
        return e(bArr, 0, bArr.length, i2);
    }

    public static byte[] e(byte[] bArr, int i2, int i3, int i4) {
        c cVar = new c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!cVar.f5070i) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (cVar.f5071j && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (cVar.k ? 2 : 1);
        }
        cVar.f5057a = new byte[i5];
        cVar.a(bArr, i2, i3, true);
        if (f5056a || cVar.f5058b == i5) {
            return cVar.f5057a;
        }
        throw new AssertionError();
    }

    public static String f(byte[] bArr, int i2) {
        try {
            return new String(d(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
