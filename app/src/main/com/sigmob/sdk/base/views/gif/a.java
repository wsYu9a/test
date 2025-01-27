package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static final int f18594a = 0;

    /* renamed from: b */
    public static final int f18595b = 1;

    /* renamed from: c */
    public static final int f18596c = 2;

    /* renamed from: d */
    public static final int f18597d = 3;

    /* renamed from: e */
    public static final int f18598e = -1;

    /* renamed from: f */
    public static final String f18599f = "a";

    /* renamed from: g */
    public static final int f18600g = 4096;

    /* renamed from: h */
    public static final int f18601h = 0;

    /* renamed from: i */
    public static final int f18602i = 1;

    /* renamed from: j */
    public static final int f18603j = 2;

    /* renamed from: k */
    public static final int f18604k = 3;

    /* renamed from: l */
    public static final int f18605l = -1;

    /* renamed from: m */
    public static final int f18606m = -1;

    /* renamed from: n */
    public static final int f18607n = 4;

    /* renamed from: o */
    public static final int f18608o = 16384;
    public d A;
    public final int[] B;
    public byte[] C;
    public short[] D;
    public Bitmap E;
    public ByteBuffer F;
    public int G;
    public boolean H;
    public int I;
    public byte[] J;
    public byte[] K;
    public int L;
    public int M;

    /* renamed from: p */
    public int[] f18609p;

    /* renamed from: q */
    public final InterfaceC0580a f18610q;

    /* renamed from: r */
    public byte[] f18611r;

    /* renamed from: s */
    public int f18612s;

    /* renamed from: t */
    public int f18613t;

    /* renamed from: u */
    public int f18614u;

    /* renamed from: v */
    public c f18615v;

    /* renamed from: w */
    public boolean f18616w;

    /* renamed from: x */
    public int f18617x;

    /* renamed from: y */
    public byte[] f18618y;

    /* renamed from: z */
    public int[] f18619z;

    /* renamed from: com.sigmob.sdk.base.views.gif.a$a */
    public interface InterfaceC0580a {
        Bitmap a(int i10, int i11, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        int[] a(int i10);

        byte[] b(int i10);
    }

    public a() {
        this(new f());
    }

    public boolean a() {
        if (this.f18615v.f18634d <= 0) {
            return false;
        }
        if (this.f18614u == f() - 1) {
            this.f18617x++;
        }
        c cVar = this.f18615v;
        int i10 = cVar.f18640j;
        if (i10 != -1 && this.f18617x > i10) {
            return false;
        }
        this.f18614u = (this.f18614u + 1) % cVar.f18634d;
        return true;
    }

    public void b() {
        this.f18615v = null;
        byte[] bArr = this.f18618y;
        if (bArr != null) {
            this.f18610q.a(bArr);
        }
        int[] iArr = this.f18619z;
        if (iArr != null) {
            this.f18610q.a(iArr);
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            this.f18610q.a(bitmap);
        }
        this.E = null;
        this.F = null;
        this.f18616w = false;
        byte[] bArr2 = this.f18611r;
        if (bArr2 != null) {
            this.f18610q.a(bArr2);
        }
        byte[] bArr3 = this.K;
        if (bArr3 != null) {
            this.f18610q.a(bArr3);
        }
    }

    public int c() {
        return this.F.limit() + this.f18618y.length + (this.f18619z.length * 4);
    }

    public int d() {
        return this.f18614u;
    }

    public ByteBuffer e() {
        return this.F;
    }

    public int f() {
        return this.f18615v.f18634d;
    }

    public final d g() {
        if (this.A == null) {
            this.A = new d();
        }
        return this.A;
    }

    public int h() {
        return this.f18615v.f18639i;
    }

    public int i() {
        return this.f18615v.f18640j;
    }

    public int j() {
        return this.f18617x;
    }

    public final Bitmap k() {
        Bitmap a10 = this.f18610q.a(this.f18613t, this.f18612s, this.f18616w ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        a(a10);
        return a10;
    }

    public int l() {
        int i10;
        if (this.f18615v.f18634d <= 0 || (i10 = this.f18614u) < 0) {
            return 0;
        }
        return a(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x0034, B:13:0x003d, B:15:0x0051, B:16:0x005d, B:19:0x0066, B:21:0x006a, B:25:0x0084, B:27:0x0088, B:28:0x0096, B:31:0x0062, B:33:0x009c, B:36:0x0010), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x000d, TRY_LEAVE, TryCatch #0 {all -> 0x000d, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x0034, B:13:0x003d, B:15:0x0051, B:16:0x005d, B:19:0x0066, B:21:0x006a, B:25:0x0084, B:27:0x0088, B:28:0x0096, B:31:0x0062, B:33:0x009c, B:36:0x0010), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084 A[Catch: all -> 0x000d, TRY_ENTER, TryCatch #0 {all -> 0x000d, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x0034, B:13:0x003d, B:15:0x0051, B:16:0x005d, B:19:0x0066, B:21:0x006a, B:25:0x0084, B:27:0x0088, B:28:0x0096, B:31:0x0062, B:33:0x009c, B:36:0x0010), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x0034, B:13:0x003d, B:15:0x0051, B:16:0x005d, B:19:0x0066, B:21:0x006a, B:25:0x0084, B:27:0x0088, B:28:0x0096, B:31:0x0062, B:33:0x009c, B:36:0x0010), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.graphics.Bitmap m() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.sigmob.sdk.base.views.gif.c r0 = r6.f18615v     // Catch: java.lang.Throwable -> Ld
            int r0 = r0.f18634d     // Catch: java.lang.Throwable -> Ld
            r1 = 1
            if (r0 <= 0) goto L10
            int r0 = r6.f18614u     // Catch: java.lang.Throwable -> Ld
            if (r0 >= 0) goto L34
            goto L10
        Ld:
            r0 = move-exception
            goto Lb4
        L10:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld
            r0.<init>()     // Catch: java.lang.Throwable -> Ld
            java.lang.String r2 = "unable to decode frame, frameCount="
            r0.append(r2)     // Catch: java.lang.Throwable -> Ld
            com.sigmob.sdk.base.views.gif.c r2 = r6.f18615v     // Catch: java.lang.Throwable -> Ld
            int r2 = r2.f18634d     // Catch: java.lang.Throwable -> Ld
            r0.append(r2)     // Catch: java.lang.Throwable -> Ld
            java.lang.String r2 = " framePointer="
            r0.append(r2)     // Catch: java.lang.Throwable -> Ld
            int r2 = r6.f18614u     // Catch: java.lang.Throwable -> Ld
            r0.append(r2)     // Catch: java.lang.Throwable -> Ld
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld
            com.czhj.sdk.logger.SigmobLog.d(r0)     // Catch: java.lang.Throwable -> Ld
            r6.I = r1     // Catch: java.lang.Throwable -> Ld
        L34:
            int r0 = r6.I     // Catch: java.lang.Throwable -> Ld
            r2 = 0
            if (r0 == r1) goto L9c
            r3 = 2
            if (r0 != r3) goto L3d
            goto L9c
        L3d:
            r0 = 0
            r6.I = r0     // Catch: java.lang.Throwable -> Ld
            com.sigmob.sdk.base.views.gif.c r3 = r6.f18615v     // Catch: java.lang.Throwable -> Ld
            java.util.List<com.sigmob.sdk.base.views.gif.b> r3 = r3.f18635e     // Catch: java.lang.Throwable -> Ld
            int r4 = r6.f18614u     // Catch: java.lang.Throwable -> Ld
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> Ld
            com.sigmob.sdk.base.views.gif.b r3 = (com.sigmob.sdk.base.views.gif.b) r3     // Catch: java.lang.Throwable -> Ld
            int r4 = r6.f18614u     // Catch: java.lang.Throwable -> Ld
            int r4 = r4 - r1
            if (r4 < 0) goto L5c
            com.sigmob.sdk.base.views.gif.c r5 = r6.f18615v     // Catch: java.lang.Throwable -> Ld
            java.util.List<com.sigmob.sdk.base.views.gif.b> r5 = r5.f18635e     // Catch: java.lang.Throwable -> Ld
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.Throwable -> Ld
            com.sigmob.sdk.base.views.gif.b r4 = (com.sigmob.sdk.base.views.gif.b) r4     // Catch: java.lang.Throwable -> Ld
            goto L5d
        L5c:
            r4 = r2
        L5d:
            int[] r5 = r3.f18628i     // Catch: java.lang.Throwable -> Ld
            if (r5 == 0) goto L62
            goto L66
        L62:
            com.sigmob.sdk.base.views.gif.c r5 = r6.f18615v     // Catch: java.lang.Throwable -> Ld
            int[] r5 = r5.f18636f     // Catch: java.lang.Throwable -> Ld
        L66:
            r6.f18609p = r5     // Catch: java.lang.Throwable -> Ld
            if (r5 != 0) goto L84
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld
            r0.<init>()     // Catch: java.lang.Throwable -> Ld
            java.lang.String r3 = "No Valid Color Table for frame #"
            r0.append(r3)     // Catch: java.lang.Throwable -> Ld
            int r3 = r6.f18614u     // Catch: java.lang.Throwable -> Ld
            r0.append(r3)     // Catch: java.lang.Throwable -> Ld
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld
            com.czhj.sdk.logger.SigmobLog.d(r0)     // Catch: java.lang.Throwable -> Ld
            r6.I = r1     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r6)
            return r2
        L84:
            boolean r1 = r3.f18630k     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L96
            int[] r1 = r6.B     // Catch: java.lang.Throwable -> Ld
            int r2 = r5.length     // Catch: java.lang.Throwable -> Ld
            java.lang.System.arraycopy(r5, r0, r1, r0, r2)     // Catch: java.lang.Throwable -> Ld
            int[] r1 = r6.B     // Catch: java.lang.Throwable -> Ld
            r6.f18609p = r1     // Catch: java.lang.Throwable -> Ld
            int r2 = r3.f18629j     // Catch: java.lang.Throwable -> Ld
            r1[r2] = r0     // Catch: java.lang.Throwable -> Ld
        L96:
            android.graphics.Bitmap r0 = r6.a(r3, r4)     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r6)
            return r0
        L9c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld
            r0.<init>()     // Catch: java.lang.Throwable -> Ld
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch: java.lang.Throwable -> Ld
            int r1 = r6.I     // Catch: java.lang.Throwable -> Ld
            r0.append(r1)     // Catch: java.lang.Throwable -> Ld
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld
            com.czhj.sdk.logger.SigmobLog.d(r0)     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r6)
            return r2
        Lb4:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Ld
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.m():android.graphics.Bitmap");
    }

    public int n() {
        return this.I;
    }

    public int o() {
        return this.f18615v.f18643m;
    }

    public final int p() {
        int i10;
        int q10 = q();
        if (q10 > 0) {
            try {
                if (this.f18611r == null) {
                    this.f18611r = this.f18610q.b(255);
                }
                int i11 = this.M;
                int i12 = this.L;
                int i13 = i11 - i12;
                if (i13 >= q10) {
                    System.arraycopy(this.K, i12, this.f18611r, 0, q10);
                    i10 = this.L + q10;
                } else if (this.F.remaining() + i13 >= q10) {
                    System.arraycopy(this.K, this.L, this.f18611r, 0, i13);
                    this.L = this.M;
                    r();
                    int i14 = q10 - i13;
                    System.arraycopy(this.K, 0, this.f18611r, i13, i14);
                    i10 = this.L + i14;
                } else {
                    this.I = 1;
                }
                this.L = i10;
            } catch (Exception e10) {
                SigmobLog.d("Error Reading Block", e10);
                this.I = 1;
            }
        }
        return q10;
    }

    public final int q() {
        try {
            r();
            byte[] bArr = this.K;
            int i10 = this.L;
            this.L = i10 + 1;
            return bArr[i10] & 255;
        } catch (Exception unused) {
            this.I = 1;
            return 0;
        }
    }

    public final void r() {
        if (this.M > this.L) {
            return;
        }
        if (this.K == null) {
            this.K = this.f18610q.b(16384);
        }
        this.L = 0;
        int min = Math.min(this.F.remaining(), 16384);
        this.M = min;
        this.F.get(this.K, 0, min);
    }

    public void s() {
        this.f18614u = -1;
    }

    public void t() {
        this.f18617x = 0;
    }

    public a(InterfaceC0580a interfaceC0580a) {
        this.B = new int[256];
        this.L = 0;
        this.M = 0;
        this.f18610q = interfaceC0580a;
        this.f18615v = new c();
    }

    public final int a(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.G + i10; i18++) {
            byte[] bArr = this.f18618y;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f18609p[bArr[i18] & 255];
            if (i19 != 0) {
                i16 += (i19 >> 24) & 255;
                i15 += (i19 >> 16) & 255;
                i14 += (i19 >> 8) & 255;
                i13 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.G + i20; i21++) {
            byte[] bArr2 = this.f18618y;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f18609p[bArr2[i21] & 255];
            if (i22 != 0) {
                i16 += (i22 >> 24) & 255;
                i15 += (i22 >> 16) & 255;
                i14 += (i22 >> 8) & 255;
                i13 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i16 / i17) << 24) | ((i15 / i17) << 16) | ((i14 / i17) << 8) | (i13 / i17);
    }

    public boolean b(int i10) {
        if (i10 < -1 || i10 >= f()) {
            return false;
        }
        this.f18614u = i10;
        return true;
    }

    public a(InterfaceC0580a interfaceC0580a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0580a, cVar, byteBuffer, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013e A[LOOP:5: B:64:0x013c->B:65:0x013e, LOOP_END] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v18, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.sigmob.sdk.base.views.gif.b r28) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.a(com.sigmob.sdk.base.views.gif.b):void");
    }

    public a(InterfaceC0580a interfaceC0580a, c cVar, ByteBuffer byteBuffer, int i10) {
        this(interfaceC0580a);
        a(cVar, byteBuffer, i10);
    }

    public final void a(int[] iArr, b bVar, int i10) {
        int i11 = bVar.f18627h;
        int i12 = this.G;
        int i13 = i11 / i12;
        int i14 = bVar.f18625f / i12;
        int i15 = bVar.f18626g / i12;
        int i16 = bVar.f18624e / i12;
        int i17 = this.f18613t;
        int i18 = (i14 * i17) + i16;
        int i19 = (i13 * i17) + i18;
        while (i18 < i19) {
            int i20 = i18 + i15;
            for (int i21 = i18; i21 < i20; i21++) {
                iArr[i21] = i10;
            }
            i18 += this.f18613t;
        }
    }

    public int a(int i10) {
        if (i10 >= 0) {
            c cVar = this.f18615v;
            if (i10 < cVar.f18634d) {
                return cVar.f18635e.get(i10).f18621b;
            }
        }
        return -1;
    }

    public int a(InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e10) {
                SigmobLog.d("Error reading data from stream", e10);
            }
        } else {
            this.I = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                SigmobLog.d("Error closing stream", e11);
            }
        }
        return this.I;
    }

    public synchronized int a(byte[] bArr) {
        try {
            c d10 = g().a(bArr).d();
            this.f18615v = d10;
            if (bArr != null) {
                a(d10, bArr);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.I;
    }

    public static void a(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i10) {
        try {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
            int highestOneBit = Integer.highestOneBit(i10);
            this.I = 0;
            this.f18615v = cVar;
            this.f18616w = false;
            this.f18614u = -1;
            t();
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.F = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.F.order(ByteOrder.LITTLE_ENDIAN);
            this.H = false;
            Iterator<b> it = cVar.f18635e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f18622c == 3) {
                    this.H = true;
                    break;
                }
            }
            this.G = highestOneBit;
            int i11 = cVar.f18643m;
            this.f18613t = i11 / highestOneBit;
            int i12 = cVar.f18639i;
            this.f18612s = i12 / highestOneBit;
            this.f18618y = this.f18610q.b(i11 * i12);
            this.f18619z = this.f18610q.a(this.f18613t * this.f18612s);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(c cVar, byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r3.f18632b == r18.f18629j) goto L182;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap a(com.sigmob.sdk.base.views.gif.b r18, com.sigmob.sdk.base.views.gif.b r19) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.gif.a.a(com.sigmob.sdk.base.views.gif.b, com.sigmob.sdk.base.views.gif.b):android.graphics.Bitmap");
    }
}
