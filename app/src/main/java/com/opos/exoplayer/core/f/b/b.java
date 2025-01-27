package com.opos.exoplayer.core.f.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import com.opos.exoplayer.core.i.l;
import com.opos.exoplayer.core.i.u;
import com.vivo.advv.virtualview.common.ExprCommon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a */
    private static final byte[] f18627a = {0, 7, 8, 15};

    /* renamed from: b */
    private static final byte[] f18628b = {0, 119, -120, -1};

    /* renamed from: c */
    private static final byte[] f18629c = {0, ExprCommon.OPCODE_SUB_EQ, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: d */
    private final Paint f18630d;

    /* renamed from: e */
    private final Paint f18631e;

    /* renamed from: f */
    private final Canvas f18632f;

    /* renamed from: g */
    private final C0412b f18633g;

    /* renamed from: h */
    private final a f18634h;

    /* renamed from: i */
    private final h f18635i;

    /* renamed from: j */
    private Bitmap f18636j;

    private static final class a {

        /* renamed from: a */
        public final int f18637a;

        /* renamed from: b */
        public final int[] f18638b;

        /* renamed from: c */
        public final int[] f18639c;

        /* renamed from: d */
        public final int[] f18640d;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f18637a = i2;
            this.f18638b = iArr;
            this.f18639c = iArr2;
            this.f18640d = iArr3;
        }
    }

    /* renamed from: com.opos.exoplayer.core.f.b.b$b */
    private static final class C0412b {

        /* renamed from: a */
        public final int f18641a;

        /* renamed from: b */
        public final int f18642b;

        /* renamed from: c */
        public final int f18643c;

        /* renamed from: d */
        public final int f18644d;

        /* renamed from: e */
        public final int f18645e;

        /* renamed from: f */
        public final int f18646f;

        public C0412b(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f18641a = i2;
            this.f18642b = i3;
            this.f18643c = i4;
            this.f18644d = i5;
            this.f18645e = i6;
            this.f18646f = i7;
        }
    }

    private static final class c {

        /* renamed from: a */
        public final int f18647a;

        /* renamed from: b */
        public final boolean f18648b;

        /* renamed from: c */
        public final byte[] f18649c;

        /* renamed from: d */
        public final byte[] f18650d;

        public c(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.f18647a = i2;
            this.f18648b = z;
            this.f18649c = bArr;
            this.f18650d = bArr2;
        }
    }

    private static final class d {

        /* renamed from: a */
        public final int f18651a;

        /* renamed from: b */
        public final int f18652b;

        /* renamed from: c */
        public final int f18653c;

        /* renamed from: d */
        public final SparseArray<e> f18654d;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            this.f18651a = i2;
            this.f18652b = i3;
            this.f18653c = i4;
            this.f18654d = sparseArray;
        }
    }

    private static final class e {

        /* renamed from: a */
        public final int f18655a;

        /* renamed from: b */
        public final int f18656b;

        public e(int i2, int i3) {
            this.f18655a = i2;
            this.f18656b = i3;
        }
    }

    private static final class f {

        /* renamed from: a */
        public final int f18657a;

        /* renamed from: b */
        public final boolean f18658b;

        /* renamed from: c */
        public final int f18659c;

        /* renamed from: d */
        public final int f18660d;

        /* renamed from: e */
        public final int f18661e;

        /* renamed from: f */
        public final int f18662f;

        /* renamed from: g */
        public final int f18663g;

        /* renamed from: h */
        public final int f18664h;

        /* renamed from: i */
        public final int f18665i;

        /* renamed from: j */
        public final int f18666j;
        public final SparseArray<g> k;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f18657a = i2;
            this.f18658b = z;
            this.f18659c = i3;
            this.f18660d = i4;
            this.f18661e = i5;
            this.f18662f = i6;
            this.f18663g = i7;
            this.f18664h = i8;
            this.f18665i = i9;
            this.f18666j = i10;
            this.k = sparseArray;
        }

        public void a(f fVar) {
            if (fVar == null) {
                return;
            }
            SparseArray<g> sparseArray = fVar.k;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    private static final class g {

        /* renamed from: a */
        public final int f18667a;

        /* renamed from: b */
        public final int f18668b;

        /* renamed from: c */
        public final int f18669c;

        /* renamed from: d */
        public final int f18670d;

        /* renamed from: e */
        public final int f18671e;

        /* renamed from: f */
        public final int f18672f;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f18667a = i2;
            this.f18668b = i3;
            this.f18669c = i4;
            this.f18670d = i5;
            this.f18671e = i6;
            this.f18672f = i7;
        }
    }

    private static final class h {

        /* renamed from: a */
        public final int f18673a;

        /* renamed from: b */
        public final int f18674b;

        /* renamed from: c */
        public final SparseArray<f> f18675c = new SparseArray<>();

        /* renamed from: d */
        public final SparseArray<a> f18676d = new SparseArray<>();

        /* renamed from: e */
        public final SparseArray<c> f18677e = new SparseArray<>();

        /* renamed from: f */
        public final SparseArray<a> f18678f = new SparseArray<>();

        /* renamed from: g */
        public final SparseArray<c> f18679g = new SparseArray<>();

        /* renamed from: h */
        public C0412b f18680h;

        /* renamed from: i */
        public d f18681i;

        public h(int i2, int i3) {
            this.f18673a = i2;
            this.f18674b = i3;
        }

        public void a() {
            this.f18675c.clear();
            this.f18676d.clear();
            this.f18677e.clear();
            this.f18678f.clear();
            this.f18679g.clear();
            this.f18680h = null;
            this.f18681i = null;
        }
    }

    public b(int i2, int i3) {
        Paint paint = new Paint();
        this.f18630d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f18631e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f18632f = new Canvas();
        this.f18633g = new C0412b(719, 575, 0, 719, 0, 575);
        this.f18634h = new a(0, b(), c(), d());
        this.f18635i = new h(i2, i3);
    }

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[LOOP:0: B:2:0x0009->B:13:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.exoplayer.core.i.l r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 2
            int r4 = r13.c(r3)
            r5 = 1
            if (r4 == 0) goto L14
            r11 = r2
        L12:
            r12 = 1
            goto L60
        L14:
            boolean r4 = r13.e()
            r6 = 3
            if (r4 == 0) goto L28
            int r4 = r13.c(r6)
            int r3 = r13.c(r3)
            int r4 = r4 + r6
        L24:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L60
        L28:
            boolean r4 = r13.e()
            if (r4 == 0) goto L31
            r11 = r2
            r4 = 0
            goto L12
        L31:
            int r4 = r13.c(r3)
            if (r4 == 0) goto L5d
            if (r4 == r5) goto L59
            if (r4 == r3) goto L4d
            if (r4 == r6) goto L40
            r11 = r2
            r4 = 0
            goto L5f
        L40:
            r4 = 8
            int r4 = r13.c(r4)
            int r3 = r13.c(r3)
            int r4 = r4 + 29
            goto L24
        L4d:
            r4 = 4
            int r4 = r13.c(r4)
            int r3 = r13.c(r3)
            int r4 = r4 + 12
            goto L24
        L59:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L60
        L5d:
            r4 = 0
            r11 = 1
        L5f:
            r12 = 0
        L60:
            if (r12 == 0) goto L7e
            if (r8 == 0) goto L7e
            if (r15 == 0) goto L68
            r4 = r15[r4]
        L68:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L7e:
            int r10 = r10 + r12
            if (r11 == 0) goto L82
            return r10
        L82:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.b.b.a(com.opos.exoplayer.core.i.l, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static C0412b a(l lVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        lVar.b(4);
        boolean e2 = lVar.e();
        lVar.b(3);
        int c2 = lVar.c(16);
        int c3 = lVar.c(16);
        if (e2) {
            int c4 = lVar.c(16);
            int c5 = lVar.c(16);
            int c6 = lVar.c(16);
            i3 = lVar.c(16);
            i2 = c5;
            i5 = c6;
            i4 = c4;
        } else {
            i2 = c2;
            i3 = c3;
            i4 = 0;
            i5 = 0;
        }
        return new C0412b(c2, c3, i4, i2, i5, i3);
    }

    private static d a(l lVar, int i2) {
        int c2 = lVar.c(8);
        int c3 = lVar.c(4);
        int c4 = lVar.c(2);
        lVar.b(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int c5 = lVar.c(8);
            lVar.b(8);
            i3 -= 6;
            sparseArray.put(c5, new e(lVar.c(16), lVar.c(16)));
        }
        return new d(c2, c3, c4, sparseArray);
    }

    private static void a(c cVar, a aVar, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr = i2 == 3 ? aVar.f18640d : i2 == 2 ? aVar.f18639c : aVar.f18638b;
        a(cVar.f18649c, iArr, i2, i3, i4, paint, canvas);
        a(cVar.f18650d, iArr, i2, i3, i4 + 1, paint, canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(l lVar, h hVar) {
        SparseArray sparseArray;
        a aVar;
        int i2;
        a aVar2;
        c cVar;
        int c2 = lVar.c(8);
        int c3 = lVar.c(16);
        int c4 = lVar.c(16);
        int c5 = lVar.c();
        if (c4 * 8 > lVar.a()) {
            com.opos.cmn.an.f.a.c("DvbParser", "Data field length exceeds limit");
            lVar.b(lVar.a());
            return;
        }
        switch (c2) {
            case 16:
                if (c3 == hVar.f18673a) {
                    d dVar = hVar.f18681i;
                    d a2 = a(lVar, c4);
                    if (a2.f18653c == 0) {
                        if (dVar != null && dVar.f18652b != a2.f18652b) {
                            hVar.f18681i = a2;
                            break;
                        }
                    } else {
                        hVar.f18681i = a2;
                        hVar.f18675c.clear();
                        hVar.f18676d.clear();
                        hVar.f18677e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f18681i;
                if (c3 == hVar.f18673a && dVar2 != null) {
                    f b2 = b(lVar, c4);
                    if (dVar2.f18653c == 0) {
                        b2.a(hVar.f18675c.get(b2.f18657a));
                    }
                    hVar.f18675c.put(b2.f18657a, b2);
                    break;
                }
                break;
            case 18:
                if (c3 == hVar.f18673a) {
                    a c6 = c(lVar, c4);
                    sparseArray = hVar.f18676d;
                    aVar = c6;
                } else if (c3 == hVar.f18674b) {
                    a c7 = c(lVar, c4);
                    sparseArray = hVar.f18678f;
                    aVar = c7;
                }
                i2 = aVar.f18637a;
                aVar2 = aVar;
                sparseArray.put(i2, aVar2);
                break;
            case 19:
                if (c3 == hVar.f18673a) {
                    c b3 = b(lVar);
                    sparseArray = hVar.f18677e;
                    cVar = b3;
                } else if (c3 == hVar.f18674b) {
                    c b4 = b(lVar);
                    sparseArray = hVar.f18679g;
                    cVar = b4;
                }
                i2 = cVar.f18647a;
                aVar2 = cVar;
                sparseArray.put(i2, aVar2);
                break;
            case 20:
                if (c3 == hVar.f18673a) {
                    hVar.f18680h = a(lVar);
                    break;
                }
                break;
        }
        lVar.d((c5 + c4) - lVar.c());
    }

    private static void a(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        l lVar = new l(bArr);
        int i5 = i3;
        int i6 = i4;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        while (lVar.a() != 0) {
            int c2 = lVar.c(8);
            if (c2 != 240) {
                switch (c2) {
                    case 16:
                        if (i2 == 3) {
                            if (bArr5 == null) {
                                bArr3 = f18628b;
                                bArr2 = bArr3;
                                i5 = a(lVar, iArr, bArr2, i5, i6, paint, canvas);
                                break;
                            } else {
                                bArr2 = bArr5;
                                i5 = a(lVar, iArr, bArr2, i5, i6, paint, canvas);
                            }
                        } else if (i2 == 2) {
                            bArr3 = bArr4 == null ? f18627a : bArr4;
                            bArr2 = bArr3;
                            i5 = a(lVar, iArr, bArr2, i5, i6, paint, canvas);
                        } else {
                            bArr2 = null;
                            i5 = a(lVar, iArr, bArr2, i5, i6, paint, canvas);
                        }
                    case 17:
                        i5 = b(lVar, iArr, i2 == 3 ? f18629c : null, i5, i6, paint, canvas);
                        break;
                    case 18:
                        i5 = c(lVar, iArr, null, i5, i6, paint, canvas);
                        continue;
                    default:
                        switch (c2) {
                            case 32:
                                bArr4 = a(4, 4, lVar);
                                break;
                            case 33:
                                bArr5 = a(4, 8, lVar);
                                break;
                            case 34:
                                bArr5 = a(16, 8, lVar);
                                break;
                            default:
                                continue;
                        }
                }
                lVar.f();
            } else {
                i6 += 2;
                i5 = i3;
            }
        }
    }

    private static byte[] a(int i2, int i3, l lVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) lVar.c(i3);
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0091 A[LOOP:0: B:2:0x0009->B:13:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(com.opos.exoplayer.core.i.l r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 4
            int r4 = r13.c(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L16
            r11 = r2
        L13:
            r12 = 1
            goto L71
        L16:
            boolean r4 = r13.e()
            r7 = 3
            if (r4 != 0) goto L2d
            int r3 = r13.c(r7)
            if (r3 == 0) goto L29
            int r5 = r3 + 2
            r11 = r2
            r12 = r5
            r4 = 0
            goto L71
        L29:
            r4 = 0
            r11 = 1
        L2b:
            r12 = 0
            goto L71
        L2d:
            boolean r4 = r13.e()
            if (r4 != 0) goto L40
            int r4 = r13.c(r5)
            int r5 = r13.c(r3)
            int r3 = r3 + r4
            r11 = r2
            r12 = r3
            r4 = r5
            goto L71
        L40:
            int r4 = r13.c(r5)
            if (r4 == 0) goto L6e
            if (r4 == r6) goto L6a
            if (r4 == r5) goto L5c
            if (r4 == r7) goto L4f
            r11 = r2
            r4 = 0
            goto L2b
        L4f:
            r4 = 8
            int r4 = r13.c(r4)
            int r3 = r13.c(r3)
            int r5 = r4 + 25
            goto L66
        L5c:
            int r4 = r13.c(r3)
            int r3 = r13.c(r3)
            int r5 = r4 + 9
        L66:
            r11 = r2
            r4 = r3
            r12 = r5
            goto L71
        L6a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L71
        L6e:
            r11 = r2
            r4 = 0
            goto L13
        L71:
            if (r12 == 0) goto L8d
            if (r8 == 0) goto L8d
            if (r15 == 0) goto L79
            r4 = r15[r4]
        L79:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L8d:
            int r10 = r10 + r12
            if (r11 == 0) goto L91
            return r10
        L91:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.b.b.b(com.opos.exoplayer.core.i.l, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static c b(l lVar) {
        byte[] bArr;
        int c2 = lVar.c(16);
        lVar.b(4);
        int c3 = lVar.c(2);
        boolean e2 = lVar.e();
        lVar.b(1);
        byte[] bArr2 = null;
        if (c3 == 1) {
            lVar.b(lVar.c(8) * 16);
        } else if (c3 == 0) {
            int c4 = lVar.c(16);
            int c5 = lVar.c(16);
            if (c4 > 0) {
                bArr2 = new byte[c4];
                lVar.b(bArr2, 0, c4);
            }
            if (c5 > 0) {
                bArr = new byte[c5];
                lVar.b(bArr, 0, c5);
                return new c(c2, e2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(c2, e2, bArr2, bArr);
    }

    private static f b(l lVar, int i2) {
        int c2;
        int c3;
        int c4 = lVar.c(8);
        lVar.b(4);
        boolean e2 = lVar.e();
        lVar.b(3);
        int i3 = 16;
        int c5 = lVar.c(16);
        int c6 = lVar.c(16);
        int c7 = lVar.c(3);
        int c8 = lVar.c(3);
        int i4 = 2;
        lVar.b(2);
        int c9 = lVar.c(8);
        int c10 = lVar.c(8);
        int c11 = lVar.c(4);
        int c12 = lVar.c(2);
        lVar.b(2);
        int i5 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int c13 = lVar.c(i3);
            int c14 = lVar.c(i4);
            int c15 = lVar.c(i4);
            int c16 = lVar.c(12);
            int i6 = c12;
            lVar.b(4);
            int c17 = lVar.c(12);
            i5 -= 6;
            if (c14 == 1 || c14 == 2) {
                i5 -= 2;
                c2 = lVar.c(8);
                c3 = lVar.c(8);
            } else {
                c2 = 0;
                c3 = 0;
            }
            sparseArray.put(c13, new g(c14, c15, c16, c17, c2, c3));
            c12 = i6;
            i4 = 2;
            i3 = 16;
        }
        return new f(c4, e2, c5, c6, c7, c8, c9, c10, c11, c12, sparseArray);
    }

    private static int[] b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int c(l lVar, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        boolean z;
        int c2;
        int i4 = i2;
        boolean z2 = false;
        while (true) {
            int c3 = lVar.c(8);
            if (c3 != 0) {
                z = z2;
                c2 = 1;
            } else if (lVar.e()) {
                z = z2;
                c2 = lVar.c(7);
                c3 = lVar.c(8);
            } else {
                int c4 = lVar.c(7);
                if (c4 != 0) {
                    z = z2;
                    c2 = c4;
                    c3 = 0;
                } else {
                    c3 = 0;
                    z = true;
                    c2 = 0;
                }
            }
            if (c2 != 0 && paint != null) {
                if (bArr != null) {
                    c3 = bArr[c3];
                }
                paint.setColor(iArr[c3]);
                canvas.drawRect(i4, i3, i4 + c2, i3 + 1, paint);
            }
            i4 += c2;
            if (z) {
                return i4;
            }
            z2 = z;
        }
    }

    private static a c(l lVar, int i2) {
        int i3;
        int c2;
        int c3;
        int i4;
        int i5;
        int i6 = 8;
        int c4 = lVar.c(8);
        lVar.b(8);
        int i7 = i2 - 2;
        int[] b2 = b();
        int[] c5 = c();
        int[] d2 = d();
        while (i7 > 0) {
            int c6 = lVar.c(i6);
            int c7 = lVar.c(i6);
            int i8 = i7 - 2;
            int[] iArr = (c7 & 128) != 0 ? b2 : (c7 & 64) != 0 ? c5 : d2;
            if ((c7 & 1) != 0) {
                i4 = lVar.c(i6);
                i5 = lVar.c(i6);
                c2 = lVar.c(i6);
                c3 = lVar.c(i6);
                i3 = i8 - 4;
            } else {
                int c8 = lVar.c(6) << 2;
                int c9 = lVar.c(4) << 4;
                i3 = i8 - 2;
                c2 = lVar.c(4) << 4;
                c3 = lVar.c(2) << 6;
                i4 = c8;
                i5 = c9;
            }
            if (i4 == 0) {
                i5 = 0;
                c2 = 0;
                c3 = 255;
            }
            double d3 = i4;
            double d4 = i5 - 128;
            Double.isNaN(d4);
            Double.isNaN(d3);
            int i9 = i3;
            double d5 = c2 - 128;
            Double.isNaN(d5);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d5);
            Double.isNaN(d3);
            iArr[c6] = a((byte) (255 - (c3 & 255)), u.a((int) (d3 + (1.402d * d4)), 0, 255), u.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), u.a((int) (d3 + (d5 * 1.772d)), 0, 255));
            b2 = b2;
            c4 = c4;
            i7 = i9;
            i6 = 8;
        }
        return new a(c4, b2, c5, d2);
    }

    private static int[] c() {
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

    private static int[] d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = a(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & 136;
                if (i3 == 0) {
                    iArr[i2] = a(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 64) == 0 ? 0 : 170) + ((i2 & 4) == 0 ? 0 : 85));
                } else if (i3 == 8) {
                    iArr[i2] = a(127, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 64) == 0 ? 0 : 170) + ((i2 & 4) == 0 ? 0 : 85));
                } else if (i3 == 128) {
                    iArr[i2] = a(255, ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 64) == 0 ? 0 : 85) + ((i2 & 4) == 0 ? 0 : 43) + 127);
                } else if (i3 == 136) {
                    iArr[i2] = a(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 64) == 0 ? 0 : 85) + ((i2 & 4) == 0 ? 0 : 43));
                }
            }
        }
        return iArr;
    }

    public List<com.opos.exoplayer.core.f.b> a(byte[] bArr, int i2) {
        int i3;
        SparseArray<g> sparseArray;
        l lVar = new l(bArr, i2);
        while (lVar.a() >= 48 && lVar.c(8) == 15) {
            a(lVar, this.f18635i);
        }
        h hVar = this.f18635i;
        if (hVar.f18681i == null) {
            return Collections.emptyList();
        }
        C0412b c0412b = hVar.f18680h;
        if (c0412b == null) {
            c0412b = this.f18633g;
        }
        Bitmap bitmap = this.f18636j;
        if (bitmap == null || c0412b.f18641a + 1 != bitmap.getWidth() || c0412b.f18642b + 1 != this.f18636j.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(c0412b.f18641a + 1, c0412b.f18642b + 1, Bitmap.Config.ARGB_8888);
            this.f18636j = createBitmap;
            this.f18632f.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = this.f18635i.f18681i.f18654d;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            e valueAt = sparseArray2.valueAt(i4);
            f fVar = this.f18635i.f18675c.get(sparseArray2.keyAt(i4));
            int i5 = valueAt.f18655a + c0412b.f18643c;
            int i6 = valueAt.f18656b + c0412b.f18645e;
            float f2 = i5;
            float f3 = i6;
            this.f18632f.clipRect(f2, f3, Math.min(fVar.f18659c + i5, c0412b.f18644d), Math.min(fVar.f18660d + i6, c0412b.f18646f), Region.Op.REPLACE);
            a aVar = this.f18635i.f18676d.get(fVar.f18663g);
            if (aVar == null && (aVar = this.f18635i.f18678f.get(fVar.f18663g)) == null) {
                aVar = this.f18634h;
            }
            SparseArray<g> sparseArray3 = fVar.k;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i7);
                g valueAt2 = sparseArray3.valueAt(i7);
                c cVar = this.f18635i.f18677e.get(keyAt);
                c cVar2 = cVar == null ? this.f18635i.f18679g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i3 = i7;
                    sparseArray = sparseArray3;
                    a(cVar2, aVar, fVar.f18662f, valueAt2.f18669c + i5, valueAt2.f18670d + i6, cVar2.f18648b ? null : this.f18630d, this.f18632f);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f18658b) {
                int i8 = fVar.f18662f;
                this.f18631e.setColor(i8 == 3 ? aVar.f18640d[fVar.f18664h] : i8 == 2 ? aVar.f18639c[fVar.f18665i] : aVar.f18638b[fVar.f18666j]);
                this.f18632f.drawRect(f2, f3, fVar.f18659c + i5, fVar.f18660d + i6, this.f18631e);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f18636j, i5, i6, fVar.f18659c, fVar.f18660d);
            int i9 = c0412b.f18641a;
            int i10 = c0412b.f18642b;
            arrayList.add(new com.opos.exoplayer.core.f.b(createBitmap2, f2 / i9, 0, f3 / i10, 0, fVar.f18659c / i9, fVar.f18660d / i10));
            this.f18632f.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public void a() {
        this.f18635i.a();
    }
}
