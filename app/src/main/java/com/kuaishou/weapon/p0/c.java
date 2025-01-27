package com.kuaishou.weapon.p0;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9152a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f9153b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f9154c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f9155d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f9156e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final int f9157f = 16;

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f9158g = true;

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f9159h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f9160a;

        /* renamed from: b, reason: collision with root package name */
        public int f9161b;

        a() {
        }

        public abstract int a(int i2);

        public abstract boolean a(byte[] bArr, int i2, int i3, boolean z);
    }

    static class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f9162c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f9163d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private static final int f9164e = -1;

        /* renamed from: f, reason: collision with root package name */
        private static final int f9165f = -2;

        /* renamed from: g, reason: collision with root package name */
        private int f9166g;

        /* renamed from: h, reason: collision with root package name */
        private int f9167h;

        /* renamed from: i, reason: collision with root package name */
        private final int[] f9168i;

        public b(int i2, byte[] bArr) {
            this.f9160a = bArr;
            this.f9168i = (i2 & 8) == 0 ? f9162c : f9163d;
            this.f9166g = 0;
            this.f9167h = 0;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i2) {
            return ((i2 * 3) / 4) + 10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0105, code lost:
        
            if (r5 != 4) goto L71;
         */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.b.a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.c$c, reason: collision with other inner class name */
    static class C0117c extends a {

        /* renamed from: c, reason: collision with root package name */
        public static final int f9169c = 19;

        /* renamed from: h, reason: collision with root package name */
        static final /* synthetic */ boolean f9170h = true;

        /* renamed from: i, reason: collision with root package name */
        private static final byte[] f9171i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f9172j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: d, reason: collision with root package name */
        int f9173d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f9174e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f9175f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f9176g;
        private final byte[] k;
        private int l;
        private final byte[] m;

        public C0117c(int i2, byte[] bArr) {
            this.f9160a = bArr;
            this.f9174e = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f9175f = z;
            this.f9176g = (i2 & 4) != 0;
            this.m = (i2 & 8) == 0 ? f9171i : f9172j;
            this.k = new byte[2];
            this.f9173d = 0;
            this.l = z ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i2) {
            return ((i2 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.C0117c.a(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(c(bArr, 0), str);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    return f9159h.matcher(str).matches();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static byte[] a(String str, int i2) {
        return a(str.getBytes(), i2);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length, 0);
    }

    public static byte[] a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, new byte[(i3 * 3) / 4]);
        if (!bVar.a(bArr, i2, i3, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i5 = bVar.f9161b;
        byte[] bArr2 = bVar.f9160a;
        if (i5 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr3, 0, i5);
        return bArr3;
    }

    public static String b(String str, int i2) {
        try {
            return new String(a(str.getBytes(), i2));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(byte[] bArr, int i2) {
        try {
            return new String(c(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String b(byte[] bArr, int i2, int i3, int i4) {
        try {
            return new String(c(bArr, i2, i3, i4), "US-ASCII");
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public static byte[] c(byte[] bArr, int i2) {
        try {
            return c(bArr, 0, bArr.length, i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) {
        C0117c c0117c = new C0117c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!c0117c.f9174e) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (c0117c.f9175f && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (c0117c.f9176g ? 2 : 1);
        }
        c0117c.f9160a = new byte[i5];
        c0117c.a(bArr, i2, i3, true);
        if (f9158g || c0117c.f9161b == i5) {
            return c0117c.f9160a;
        }
        throw new AssertionError();
    }
}
