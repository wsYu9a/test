package com.vivo.google.android.exoplayer3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.vivo.advv.virtualview.common.ExprCommon;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class l4 {

    /* renamed from: h */
    public static final byte[] f27670h = {0, 7, 8, 15};

    /* renamed from: i */
    public static final byte[] f27671i = {0, 119, -120, -1};

    /* renamed from: j */
    public static final byte[] f27672j = {0, ExprCommon.OPCODE_SUB_EQ, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a */
    public final Paint f27673a;

    /* renamed from: b */
    public final Paint f27674b;

    /* renamed from: c */
    public final Canvas f27675c;

    /* renamed from: d */
    public final b f27676d;

    /* renamed from: e */
    public final a f27677e;

    /* renamed from: f */
    public final h f27678f;

    /* renamed from: g */
    public Bitmap f27679g;

    public static final class a {

        /* renamed from: a */
        public final int f27680a;

        /* renamed from: b */
        public final int[] f27681b;

        /* renamed from: c */
        public final int[] f27682c;

        /* renamed from: d */
        public final int[] f27683d;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f27680a = i2;
            this.f27681b = iArr;
            this.f27682c = iArr2;
            this.f27683d = iArr3;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f27684a;

        /* renamed from: b */
        public final int f27685b;

        /* renamed from: c */
        public final int f27686c;

        /* renamed from: d */
        public final int f27687d;

        /* renamed from: e */
        public final int f27688e;

        /* renamed from: f */
        public final int f27689f;

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f27684a = i2;
            this.f27685b = i3;
            this.f27686c = i4;
            this.f27687d = i5;
            this.f27688e = i6;
            this.f27689f = i7;
        }
    }

    public static final class c {

        /* renamed from: a */
        public final int f27690a;

        /* renamed from: b */
        public final boolean f27691b;

        /* renamed from: c */
        public final byte[] f27692c;

        /* renamed from: d */
        public final byte[] f27693d;

        public c(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.f27690a = i2;
            this.f27691b = z;
            this.f27692c = bArr;
            this.f27693d = bArr2;
        }
    }

    public static final class d {

        /* renamed from: a */
        public final int f27694a;

        /* renamed from: b */
        public final int f27695b;

        /* renamed from: c */
        public final SparseArray<e> f27696c;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            this.f27694a = i3;
            this.f27695b = i4;
            this.f27696c = sparseArray;
        }
    }

    public static final class e {

        /* renamed from: a */
        public final int f27697a;

        /* renamed from: b */
        public final int f27698b;

        public e(int i2, int i3) {
            this.f27697a = i2;
            this.f27698b = i3;
        }
    }

    public static final class f {

        /* renamed from: a */
        public final int f27699a;

        /* renamed from: b */
        public final boolean f27700b;

        /* renamed from: c */
        public final int f27701c;

        /* renamed from: d */
        public final int f27702d;

        /* renamed from: e */
        public final int f27703e;

        /* renamed from: f */
        public final int f27704f;

        /* renamed from: g */
        public final int f27705g;

        /* renamed from: h */
        public final int f27706h;

        /* renamed from: i */
        public final int f27707i;

        /* renamed from: j */
        public final SparseArray<g> f27708j;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f27699a = i2;
            this.f27700b = z;
            this.f27701c = i3;
            this.f27702d = i4;
            this.f27703e = i6;
            this.f27704f = i7;
            this.f27705g = i8;
            this.f27706h = i9;
            this.f27707i = i10;
            this.f27708j = sparseArray;
        }
    }

    public static final class g {

        /* renamed from: a */
        public final int f27709a;

        /* renamed from: b */
        public final int f27710b;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f27709a = i4;
            this.f27710b = i5;
        }
    }

    public static final class h {

        /* renamed from: a */
        public final int f27711a;

        /* renamed from: b */
        public final int f27712b;

        /* renamed from: c */
        public final SparseArray<f> f27713c = new SparseArray<>();

        /* renamed from: d */
        public final SparseArray<a> f27714d = new SparseArray<>();

        /* renamed from: e */
        public final SparseArray<c> f27715e = new SparseArray<>();

        /* renamed from: f */
        public final SparseArray<a> f27716f = new SparseArray<>();

        /* renamed from: g */
        public final SparseArray<c> f27717g = new SparseArray<>();

        /* renamed from: h */
        public b f27718h;

        /* renamed from: i */
        public d f27719i;

        public h(int i2, int i3) {
            this.f27711a = i2;
            this.f27712b = i3;
        }
    }

    public l4(int i2, int i3) {
        Paint paint = new Paint();
        this.f27673a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f27674b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f27675c = new Canvas();
        this.f27676d = new b(719, 575, 0, 719, 0, 575);
        this.f27677e = new a(0, a(), b(), c());
        this.f27678f = new h(i2, i3);
    }

    public static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    public static a a(m6 m6Var, int i2) {
        int a2;
        int i3;
        int a3;
        int i4;
        int i5;
        int i6 = 8;
        int a4 = m6Var.a(8);
        m6Var.c(8);
        int i7 = 2;
        int i8 = i2 - 2;
        int[] a5 = a();
        int[] b2 = b();
        int[] c2 = c();
        while (i8 > 0) {
            int a6 = m6Var.a(i6);
            int a7 = m6Var.a(i6);
            int i9 = i8 - 2;
            int[] iArr = (a7 & 128) != 0 ? a5 : (a7 & 64) != 0 ? b2 : c2;
            if ((a7 & 1) != 0) {
                i4 = m6Var.a(i6);
                i5 = m6Var.a(i6);
                a2 = m6Var.a(i6);
                a3 = m6Var.a(i6);
                i3 = i9 - 4;
            } else {
                int a8 = m6Var.a(6) << i7;
                int a9 = m6Var.a(4) << 4;
                a2 = m6Var.a(4) << 4;
                i3 = i9 - 2;
                a3 = m6Var.a(i7) << 6;
                i4 = a8;
                i5 = a9;
            }
            if (i4 == 0) {
                i5 = 0;
                a2 = 0;
                a3 = 255;
            }
            double d2 = i4;
            double d3 = i5 - 128;
            Double.isNaN(d3);
            Double.isNaN(d2);
            double d4 = a2 - 128;
            Double.isNaN(d4);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d2);
            iArr[a6] = a((byte) (255 - (a3 & 255)), Util.constrainValue((int) (d2 + (1.402d * d3)), 0, 255), Util.constrainValue((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), Util.constrainValue((int) (d2 + (d4 * 1.772d)), 0, 255));
            i8 = i3;
            a4 = a4;
            i6 = 8;
            i7 = 2;
        }
        return new a(a4, a5, b2, c2);
    }

    public static c a(m6 m6Var) {
        byte[] bArr;
        int a2 = m6Var.a(16);
        m6Var.c(4);
        int a3 = m6Var.a(2);
        boolean d2 = m6Var.d();
        m6Var.c(1);
        byte[] bArr2 = null;
        if (a3 == 1) {
            m6Var.c(m6Var.a(8) * 16);
        } else if (a3 == 0) {
            int a4 = m6Var.a(16);
            int a5 = m6Var.a(16);
            if (a4 > 0) {
                bArr2 = new byte[a4];
                m6Var.a(bArr2, 0, a4);
            }
            if (a5 > 0) {
                bArr = new byte[a5];
                m6Var.a(bArr, 0, a5);
                return new c(a2, d2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(a2, d2, bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0103 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e A[LOOP:2: B:40:0x009f->B:51:0x012e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e5 A[LOOP:3: B:85:0x0150->B:96:0x01e5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l4.a(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static byte[] a(int i2, int i3, m6 m6Var) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) m6Var.a(i3);
        }
        return bArr;
    }

    public static int[] a() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = a(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i2] = a(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = a(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & 136;
                if (i3 == 0) {
                    iArr[i2] = a(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 8) {
                    iArr[i2] = a(127, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 128) {
                    iArr[i2] = a(255, ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + 127 + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = a(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }
}
