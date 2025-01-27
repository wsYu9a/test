package com.opos.exoplayer.core.f.c;

import android.graphics.Bitmap;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class a extends c {

    /* renamed from: a */
    private final m f18684a;

    /* renamed from: b */
    private final C0413a f18685b;

    /* renamed from: com.opos.exoplayer.core.f.c.a$a */
    private static final class C0413a {

        /* renamed from: a */
        private final m f18686a = new m();

        /* renamed from: b */
        private final int[] f18687b = new int[256];

        /* renamed from: c */
        private boolean f18688c;

        /* renamed from: d */
        private int f18689d;

        /* renamed from: e */
        private int f18690e;

        /* renamed from: f */
        private int f18691f;

        /* renamed from: g */
        private int f18692g;

        /* renamed from: h */
        private int f18693h;

        /* renamed from: i */
        private int f18694i;

        public void a(m mVar, int i2) {
            if (i2 % 5 != 2) {
                return;
            }
            mVar.d(2);
            Arrays.fill(this.f18687b, 0);
            int i3 = i2 / 5;
            int i4 = 0;
            while (i4 < i3) {
                int g2 = mVar.g();
                int g3 = mVar.g();
                int g4 = mVar.g();
                int g5 = mVar.g();
                int g6 = mVar.g();
                double d2 = g3;
                double d3 = g4 - 128;
                Double.isNaN(d3);
                Double.isNaN(d2);
                int i5 = (int) ((1.402d * d3) + d2);
                int i6 = i4;
                double d4 = g5 - 128;
                Double.isNaN(d4);
                Double.isNaN(d2);
                Double.isNaN(d3);
                int i7 = (int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d));
                Double.isNaN(d4);
                Double.isNaN(d2);
                int[] iArr = this.f18687b;
                iArr[g2] = u.a((int) (d2 + (d4 * 1.772d)), 0, 255) | (u.a(i7, 0, 255) << 8) | (g6 << 24) | (u.a(i5, 0, 255) << 16);
                i4 = i6 + 1;
            }
            this.f18688c = true;
        }

        public void b(m mVar, int i2) {
            int k;
            if (i2 < 4) {
                return;
            }
            mVar.d(3);
            int i3 = i2 - 4;
            if ((mVar.g() & 128) != 0) {
                if (i3 < 7 || (k = mVar.k()) < 4) {
                    return;
                }
                this.f18693h = mVar.h();
                this.f18694i = mVar.h();
                this.f18686a.a(k - 4);
                i3 -= 7;
            }
            int d2 = this.f18686a.d();
            int c2 = this.f18686a.c();
            if (d2 >= c2 || i3 <= 0) {
                return;
            }
            int min = Math.min(i3, c2 - d2);
            mVar.a(this.f18686a.f19048a, d2, min);
            this.f18686a.c(min + d2);
        }

        public void c(m mVar, int i2) {
            if (i2 < 19) {
                return;
            }
            this.f18689d = mVar.h();
            this.f18690e = mVar.h();
            mVar.d(11);
            this.f18691f = mVar.h();
            this.f18692g = mVar.h();
        }

        public com.opos.exoplayer.core.f.b a() {
            if (this.f18689d == 0 || this.f18690e == 0 || this.f18693h == 0 || this.f18694i == 0 || this.f18686a.c() == 0 || this.f18686a.d() != this.f18686a.c() || !this.f18688c) {
                return null;
            }
            this.f18686a.c(0);
            int i2 = this.f18693h * this.f18694i;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int g2 = this.f18686a.g();
                if (g2 != 0) {
                    iArr[i3] = this.f18687b[g2];
                    i3++;
                } else {
                    int g3 = this.f18686a.g();
                    if (g3 != 0) {
                        int g4 = ((g3 & 64) == 0 ? g3 & 63 : ((g3 & 63) << 8) | this.f18686a.g()) + i3;
                        Arrays.fill(iArr, i3, g4, (g3 & 128) == 0 ? 0 : this.f18687b[this.f18686a.g()]);
                        i3 = g4;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.f18693h, this.f18694i, Bitmap.Config.ARGB_8888);
            float f2 = this.f18691f;
            int i4 = this.f18689d;
            float f3 = f2 / i4;
            float f4 = this.f18692g;
            int i5 = this.f18690e;
            return new com.opos.exoplayer.core.f.b(createBitmap, f3, 0, f4 / i5, 0, this.f18693h / i4, this.f18694i / i5);
        }

        public void b() {
            this.f18689d = 0;
            this.f18690e = 0;
            this.f18691f = 0;
            this.f18692g = 0;
            this.f18693h = 0;
            this.f18694i = 0;
            this.f18686a.a(0);
            this.f18688c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f18684a = new m();
        this.f18685b = new C0413a();
    }

    private static com.opos.exoplayer.core.f.b a(m mVar, C0413a c0413a) {
        int c2 = mVar.c();
        int g2 = mVar.g();
        int h2 = mVar.h();
        int d2 = mVar.d() + h2;
        com.opos.exoplayer.core.f.b bVar = null;
        if (d2 > c2) {
            mVar.c(c2);
        } else {
            if (g2 != 128) {
                switch (g2) {
                    case 20:
                        c0413a.a(mVar, h2);
                        break;
                    case 21:
                        c0413a.b(mVar, h2);
                        break;
                    case 22:
                        c0413a.c(mVar, h2);
                        break;
                }
            } else {
                bVar = c0413a.a();
                c0413a.b();
            }
            mVar.c(d2);
        }
        return bVar;
    }

    @Override // com.opos.exoplayer.core.f.c
    protected d a(byte[] bArr, int i2, boolean z) {
        this.f18684a.a(bArr, i2);
        this.f18685b.b();
        ArrayList arrayList = new ArrayList();
        while (this.f18684a.b() >= 3) {
            com.opos.exoplayer.core.f.b a2 = a(this.f18684a, this.f18685b);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
