package com.opos.exoplayer.core.e;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.e.g;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public final class h implements com.opos.exoplayer.core.c.n {

    /* renamed from: a */
    private final com.opos.exoplayer.core.h.b f18489a;

    /* renamed from: b */
    private final int f18490b;

    /* renamed from: c */
    private final g f18491c;

    /* renamed from: d */
    private final g.a f18492d;

    /* renamed from: e */
    private final com.opos.exoplayer.core.i.m f18493e;

    /* renamed from: f */
    private b f18494f;

    /* renamed from: g */
    private b f18495g;

    /* renamed from: h */
    private b f18496h;

    /* renamed from: i */
    private Format f18497i;

    /* renamed from: j */
    private boolean f18498j;
    private Format k;
    private long l;
    private long m;
    private boolean n;
    private a o;

    public interface a {
        void a(Format format);
    }

    private static final class b {

        /* renamed from: a */
        public final long f18499a;

        /* renamed from: b */
        public final long f18500b;

        /* renamed from: c */
        public boolean f18501c;

        /* renamed from: d */
        @Nullable
        public com.opos.exoplayer.core.h.a f18502d;

        /* renamed from: e */
        @Nullable
        public b f18503e;

        public b(long j2, int i2) {
            this.f18499a = j2;
            this.f18500b = i2 + j2;
        }

        public int a(long j2) {
            return ((int) (j2 - this.f18499a)) + this.f18502d.f18900b;
        }

        public b a() {
            this.f18502d = null;
            b bVar = this.f18503e;
            this.f18503e = null;
            return bVar;
        }

        public void a(com.opos.exoplayer.core.h.a aVar, b bVar) {
            this.f18502d = aVar;
            this.f18503e = bVar;
            this.f18501c = true;
        }
    }

    public h(com.opos.exoplayer.core.h.b bVar) {
        this.f18489a = bVar;
        int c2 = bVar.c();
        this.f18490b = c2;
        this.f18491c = new g();
        this.f18492d = new g.a();
        this.f18493e = new com.opos.exoplayer.core.i.m(32);
        b bVar2 = new b(0L, c2);
        this.f18494f = bVar2;
        this.f18495g = bVar2;
        this.f18496h = bVar2;
    }

    private int a(int i2) {
        b bVar = this.f18496h;
        if (!bVar.f18501c) {
            bVar.a(this.f18489a.a(), new b(this.f18496h.f18500b, this.f18490b));
        }
        return Math.min(i2, (int) (this.f18496h.f18500b - this.m));
    }

    private static Format a(Format format, long j2) {
        if (format == null) {
            return null;
        }
        if (j2 == 0) {
            return format;
        }
        long j3 = format.w;
        return j3 != Long.MAX_VALUE ? format.a(j3 + j2) : format;
    }

    private void a(long j2) {
        while (true) {
            b bVar = this.f18495g;
            if (j2 < bVar.f18500b) {
                return;
            } else {
                this.f18495g = bVar.f18503e;
            }
        }
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        a(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.f18495g.f18500b - j2));
            b bVar = this.f18495g;
            byteBuffer.put(bVar.f18502d.f18899a, bVar.a(j2), min);
            i2 -= min;
            j2 += min;
            b bVar2 = this.f18495g;
            if (j2 == bVar2.f18500b) {
                this.f18495g = bVar2.f18503e;
            }
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        a(j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f18495g.f18500b - j2));
            b bVar = this.f18495g;
            System.arraycopy(bVar.f18502d.f18899a, bVar.a(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += min;
            b bVar2 = this.f18495g;
            if (j2 == bVar2.f18500b) {
                this.f18495g = bVar2.f18503e;
            }
        }
    }

    private void a(com.opos.exoplayer.core.b.e eVar, g.a aVar) {
        int i2;
        long j2 = aVar.f18487b;
        this.f18493e.a(1);
        a(j2, this.f18493e.f19048a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f18493e.f19048a[0];
        boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
        int i3 = b2 & ByteCompanionObject.MAX_VALUE;
        com.opos.exoplayer.core.b.b bVar = eVar.f17738a;
        if (bVar.f17717a == null) {
            bVar.f17717a = new byte[16];
        }
        a(j3, bVar.f17717a, i3);
        long j4 = j3 + i3;
        if (z) {
            this.f18493e.a(2);
            a(j4, this.f18493e.f19048a, 2);
            j4 += 2;
            i2 = this.f18493e.h();
        } else {
            i2 = 1;
        }
        com.opos.exoplayer.core.b.b bVar2 = eVar.f17738a;
        int[] iArr = bVar2.f17720d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar2.f17721e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i4 = i2 * 6;
            this.f18493e.a(i4);
            a(j4, this.f18493e.f19048a, i4);
            long j5 = i4;
            this.f18493e.c(0);
            for (int i5 = 0; i5 < i2; i5++) {
                iArr2[i5] = this.f18493e.h();
                iArr4[i5] = this.f18493e.u();
            }
            j4 += j5;
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.f18486a - ((int) (j4 - aVar.f18487b));
        }
        n.a aVar2 = aVar.f18488c;
        com.opos.exoplayer.core.b.b bVar3 = eVar.f17738a;
        bVar3.a(i2, iArr2, iArr4, aVar2.f18332b, bVar3.f17717a, aVar2.f18331a, aVar2.f18333c, aVar2.f18334d);
        long j6 = aVar.f18487b;
        int i6 = (int) (j4 - j6);
        aVar.f18487b = j6 + i6;
        aVar.f18486a -= i6;
    }

    private void a(b bVar) {
        if (bVar.f18501c) {
            b bVar2 = this.f18496h;
            boolean z = bVar2.f18501c;
            int i2 = (z ? 1 : 0) + (((int) (bVar2.f18499a - bVar.f18499a)) / this.f18490b);
            com.opos.exoplayer.core.h.a[] aVarArr = new com.opos.exoplayer.core.h.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = bVar.f18502d;
                bVar = bVar.a();
            }
            this.f18489a.a(aVarArr);
        }
    }

    private void b(int i2) {
        long j2 = this.m + i2;
        this.m = j2;
        b bVar = this.f18496h;
        if (j2 == bVar.f18500b) {
            this.f18496h = bVar.f18503e;
        }
    }

    private void b(long j2) {
        b bVar;
        if (j2 == -1) {
            return;
        }
        while (true) {
            bVar = this.f18494f;
            if (j2 < bVar.f18500b) {
                break;
            }
            this.f18489a.a(bVar.f18502d);
            this.f18494f = this.f18494f.a();
        }
        if (this.f18495g.f18499a < bVar.f18499a) {
            this.f18495g = bVar;
        }
    }

    @Override // com.opos.exoplayer.core.c.n
    public int a(com.opos.exoplayer.core.c.f fVar, int i2, boolean z) {
        int a2 = a(i2);
        b bVar = this.f18496h;
        int a3 = fVar.a(bVar.f18502d.f18899a, bVar.a(this.m), a2);
        if (a3 != -1) {
            b(a3);
            return a3;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z, boolean z2, long j2) {
        int a2 = this.f18491c.a(lVar, eVar, z, z2, this.f18497i, this.f18492d);
        if (a2 == -5) {
            this.f18497i = lVar.f19091a;
            return -5;
        }
        if (a2 != -4) {
            if (a2 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!eVar.c()) {
            if (eVar.f17740c < j2) {
                eVar.b(Integer.MIN_VALUE);
            }
            if (eVar.g()) {
                a(eVar, this.f18492d);
            }
            eVar.e(this.f18492d.f18486a);
            g.a aVar = this.f18492d;
            a(aVar.f18487b, eVar.f17739b, aVar.f18486a);
        }
        return -4;
    }

    public void a() {
        a(false);
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(long j2, int i2, int i3, int i4, n.a aVar) {
        if (this.f18498j) {
            a(this.k);
        }
        if (this.n) {
            if ((i2 & 1) == 0 || !this.f18491c.b(j2)) {
                return;
            } else {
                this.n = false;
            }
        }
        this.f18491c.a(j2 + this.l, i2, (this.m - i3) - i4, i3, aVar);
    }

    public void a(long j2, boolean z, boolean z2) {
        b(this.f18491c.b(j2, z, z2));
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(Format format) {
        Format a2 = a(format, this.l);
        boolean a3 = this.f18491c.a(a2);
        this.k = format;
        this.f18498j = false;
        a aVar = this.o;
        if (aVar == null || !a3) {
            return;
        }
        aVar.a(a2);
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(com.opos.exoplayer.core.i.m mVar, int i2) {
        while (i2 > 0) {
            int a2 = a(i2);
            b bVar = this.f18496h;
            mVar.a(bVar.f18502d.f18899a, bVar.a(this.m), a2);
            i2 -= a2;
            b(a2);
        }
    }

    public void a(boolean z) {
        this.f18491c.a(z);
        a(this.f18494f);
        b bVar = new b(0L, this.f18490b);
        this.f18494f = bVar;
        this.f18495g = bVar;
        this.f18496h = bVar;
        this.m = 0L;
        this.f18489a.b();
    }

    public int b() {
        return this.f18491c.a();
    }

    public int b(long j2, boolean z, boolean z2) {
        return this.f18491c.a(j2, z, z2);
    }

    public boolean c() {
        return this.f18491c.c();
    }

    public int d() {
        return this.f18491c.b();
    }

    public Format e() {
        return this.f18491c.d();
    }

    public long f() {
        return this.f18491c.e();
    }

    public void g() {
        this.f18491c.f();
        this.f18495g = this.f18494f;
    }

    public void h() {
        b(this.f18491c.h());
    }

    public int i() {
        return this.f18491c.g();
    }
}
