package com.opos.exoplayer.core.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.a.e;
import com.opos.exoplayer.core.a.f;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.p;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes4.dex */
public class i extends com.opos.exoplayer.core.d.b implements com.opos.exoplayer.core.i.i {

    /* renamed from: b */
    private final e.a f17588b;

    /* renamed from: c */
    private final f f17589c;

    /* renamed from: d */
    private boolean f17590d;

    /* renamed from: e */
    private boolean f17591e;

    /* renamed from: f */
    private MediaFormat f17592f;

    /* renamed from: g */
    private int f17593g;

    /* renamed from: h */
    private int f17594h;

    /* renamed from: i */
    private int f17595i;

    /* renamed from: j */
    private int f17596j;
    private long k;
    private boolean l;
    private boolean m;

    private final class a implements f.c {
        private a() {
        }

        /* synthetic */ a(i iVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a() {
            i.this.v();
            i.this.m = true;
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i2) {
            i.this.f17588b.a(i2);
            i.this.b(i2);
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i2, long j2, long j3) {
            i.this.f17588b.a(i2, j2, j3);
            i.this.a(i2, j2, j3);
        }
    }

    public i(com.opos.exoplayer.core.d.c cVar, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, @Nullable Handler handler, @Nullable e eVar, @Nullable c cVar2, d... dVarArr) {
        this(cVar, bVar, z, handler, eVar, new g(cVar2, dVarArr));
    }

    public i(com.opos.exoplayer.core.d.c cVar, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, @Nullable Handler handler, @Nullable e eVar, f fVar) {
        super(1, cVar, bVar, z);
        this.f17588b = new e.a(handler, eVar);
        this.f17589c = fVar;
        fVar.a(new a());
    }

    private void D() {
        long a2 = this.f17589c.a(u());
        if (a2 != Long.MIN_VALUE) {
            if (!this.m) {
                a2 = Math.max(this.k, a2);
            }
            this.k = a2;
            this.m = false;
        }
    }

    private static boolean b(String str) {
        if (u.f19078a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(u.f19080c)) {
            String str2 = u.f19079b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected int a(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format) {
        int i2;
        int i3;
        String str = format.f17496f;
        boolean z = true;
        if (!com.opos.exoplayer.core.i.j.a(str)) {
            return 0;
        }
        int i4 = u.f19078a >= 21 ? 32 : 0;
        boolean a2 = com.opos.exoplayer.core.a.a(bVar, format.f17499i);
        if (a2 && a(str) && cVar.a() != null) {
            return i4 | 8 | 4;
        }
        if ((!"audio/raw".equals(str) || this.f17589c.a(format.t)) && this.f17589c.a(2)) {
            DrmInitData drmInitData = format.f17499i;
            boolean z2 = false;
            if (drmInitData != null) {
                for (int i5 = 0; i5 < drmInitData.f18368b; i5++) {
                    z2 |= drmInitData.a(i5).f18373c;
                }
            }
            com.opos.exoplayer.core.d.a a3 = cVar.a(str, z2);
            if (a3 != null) {
                if (!a2) {
                    return 2;
                }
                if (u.f19078a >= 21 && (((i2 = format.s) != -1 && !a3.a(i2)) || ((i3 = format.r) != -1 && !a3.b(i3)))) {
                    z = false;
                }
                return (z ? 4 : 3) | i4 | 8;
            }
            if (z2 && cVar.a(str, false) != null) {
                return 2;
            }
        }
        return 1;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected com.opos.exoplayer.core.d.a a(com.opos.exoplayer.core.d.c cVar, Format format, boolean z) {
        com.opos.exoplayer.core.d.a a2;
        if (!a(format.f17496f) || (a2 = cVar.a()) == null) {
            this.f17590d = false;
            return super.a(cVar, format, z);
        }
        this.f17590d = true;
        return a2;
    }

    @Override // com.opos.exoplayer.core.i.i
    public p a(p pVar) {
        return this.f17589c.a(pVar);
    }

    protected void a(int i2, long j2, long j3) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r.b
    public void a(int i2, Object obj) {
        if (i2 == 2) {
            this.f17589c.a(((Float) obj).floatValue());
        } else if (i2 != 3) {
            super.a(i2, obj);
        } else {
            this.f17589c.a((b) obj);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(long j2, boolean z) {
        super.a(j2, z);
        this.f17589c.i();
        this.k = j2;
        this.l = true;
        this.m = true;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i2;
        int[] iArr;
        int i3;
        MediaFormat mediaFormat2 = this.f17592f;
        if (mediaFormat2 != null) {
            i2 = com.opos.exoplayer.core.i.j.f(mediaFormat2.getString("mime"));
            mediaFormat = this.f17592f;
        } else {
            i2 = this.f17593g;
        }
        int i4 = i2;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f17591e && integer == 6 && (i3 = this.f17594h) < 6) {
            iArr = new int[i3];
            for (int i5 = 0; i5 < this.f17594h; i5++) {
                iArr[i5] = i5;
            }
        } else {
            iArr = null;
        }
        try {
            this.f17589c.a(i4, integer, integer2, 0, iArr, this.f17595i, this.f17596j);
        } catch (f.a e2) {
            throw com.opos.exoplayer.core.h.a(e2, r());
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.b.e eVar) {
        if (!this.l || eVar.d_()) {
            return;
        }
        if (Math.abs(eVar.f17740c - this.k) > 500000) {
            this.k = eVar.f17740c;
        }
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.f17591e = b(aVar.f18335a);
        MediaFormat c2 = c(format);
        if (!this.f17590d) {
            mediaCodec.configure(c2, (Surface) null, mediaCrypto, 0);
            this.f17592f = null;
        } else {
            this.f17592f = c2;
            c2.setString("mime", "audio/raw");
            mediaCodec.configure(this.f17592f, (Surface) null, mediaCrypto, 0);
            this.f17592f.setString("mime", format.f17496f);
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(String str, long j2, long j3) {
        this.f17588b.a(str, j2, j3);
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(boolean z) {
        super.a(z);
        this.f17588b.a(((com.opos.exoplayer.core.d.b) this).f18342a);
        int i2 = q().f19199b;
        if (i2 != 0) {
            this.f17589c.b(i2);
        } else {
            this.f17589c.g();
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) {
        if (this.f17590d && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            ((com.opos.exoplayer.core.d.b) this).f18342a.f17734f++;
            this.f17589c.b();
            return true;
        }
        try {
            if (!this.f17589c.a(byteBuffer, j4)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i2, false);
            ((com.opos.exoplayer.core.d.b) this).f18342a.f17733e++;
            return true;
        } catch (f.b | f.d e2) {
            throw com.opos.exoplayer.core.h.a(e2, r());
        }
    }

    protected boolean a(String str) {
        int f2 = com.opos.exoplayer.core.i.j.f(str);
        return f2 != 0 && this.f17589c.a(f2);
    }

    protected void b(int i2) {
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void b(Format format) {
        super.b(format);
        this.f17588b.a(format);
        this.f17593g = "audio/raw".equals(format.f17496f) ? format.t : 2;
        this.f17594h = format.r;
        int i2 = format.u;
        if (i2 == -1) {
            i2 = 0;
        }
        this.f17595i = i2;
        int i3 = format.v;
        this.f17596j = i3 != -1 ? i3 : 0;
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.s
    public com.opos.exoplayer.core.i.i c() {
        return this;
    }

    @Override // com.opos.exoplayer.core.i.i
    public long d() {
        if (a_() == 2) {
            D();
        }
        return this.k;
    }

    @Override // com.opos.exoplayer.core.i.i
    public p e() {
        return this.f17589c.f();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void n() {
        super.n();
        this.f17589c.a();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void o() {
        this.f17589c.h();
        D();
        super.o();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void p() {
        try {
            this.f17589c.j();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.s
    public boolean t() {
        return this.f17589c.e() || super.t();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.s
    public boolean u() {
        return super.u() && this.f17589c.d();
    }

    protected void v() {
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void w() {
        try {
            this.f17589c.c();
        } catch (f.d e2) {
            throw com.opos.exoplayer.core.h.a(e2, r());
        }
    }
}
