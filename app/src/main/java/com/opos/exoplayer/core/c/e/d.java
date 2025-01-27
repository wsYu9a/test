package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e.i;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.ic.dm.Downloads;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
final class d extends i {

    /* renamed from: a */
    private com.opos.exoplayer.core.i.f f18030a;

    /* renamed from: b */
    private a f18031b;

    private class a implements g, l {

        /* renamed from: b */
        private long[] f18033b;

        /* renamed from: c */
        private long[] f18034c;

        /* renamed from: d */
        private long f18035d = -1;

        /* renamed from: e */
        private long f18036e = -1;

        public a() {
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(long j2) {
            long b2 = d.this.b(j2);
            this.f18036e = this.f18033b[u.a(this.f18033b, b2, true, true)];
            return b2;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(com.opos.exoplayer.core.c.f fVar) {
            long j2 = this.f18036e;
            if (j2 < 0) {
                return -1L;
            }
            long j3 = -(j2 + 2);
            this.f18036e = -1L;
            return j3;
        }

        public void a(m mVar) {
            mVar.d(1);
            int k = mVar.k() / 18;
            this.f18033b = new long[k];
            this.f18034c = new long[k];
            for (int i2 = 0; i2 < k; i2++) {
                this.f18033b[i2] = mVar.q();
                this.f18034c[i2] = mVar.q();
                mVar.d(2);
            }
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return true;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return d.this.f18030a.b();
        }

        @Override // com.opos.exoplayer.core.c.l
        public l.a b(long j2) {
            int a2 = u.a(this.f18033b, d.this.b(j2), true, true);
            long a3 = d.this.a(this.f18033b[a2]);
            com.opos.exoplayer.core.c.m mVar = new com.opos.exoplayer.core.c.m(a3, this.f18035d + this.f18034c[a2]);
            if (a3 >= j2 || a2 == this.f18033b.length - 1) {
                return new l.a(mVar);
            }
            int i2 = a2 + 1;
            return new l.a(mVar, new com.opos.exoplayer.core.c.m(d.this.a(this.f18033b[i2]), this.f18035d + this.f18034c[i2]));
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public l c() {
            return this;
        }

        public void c(long j2) {
            this.f18035d = j2;
        }
    }

    d() {
    }

    public static boolean a(m mVar) {
        return mVar.b() >= 5 && mVar.g() == 127 && mVar.m() == 1179402563;
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    private int c(m mVar) {
        int i2;
        int i3;
        int i4 = (mVar.f19048a[2] & 255) >> 4;
        switch (i4) {
            case 1:
                return Downloads.Impl.STATUS_RUNNING;
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = 576;
                i3 = i4 - 2;
                break;
            case 6:
            case 7:
                mVar.d(4);
                mVar.A();
                int g2 = i4 == 6 ? mVar.g() : mVar.h();
                mVar.c(0);
                return g2 + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = 256;
                i3 = i4 - 8;
                break;
            default:
                return -1;
        }
        return i2 << i3;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void a(boolean z) {
        super.a(z);
        if (z) {
            this.f18030a = null;
            this.f18031b = null;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(m mVar, long j2, i.a aVar) {
        byte[] bArr = mVar.f19048a;
        if (this.f18030a == null) {
            this.f18030a = new com.opos.exoplayer.core.i.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, mVar.c());
            copyOfRange[4] = (byte) (-128);
            List singletonList = Collections.singletonList(copyOfRange);
            int a2 = this.f18030a.a();
            com.opos.exoplayer.core.i.f fVar = this.f18030a;
            aVar.f18065a = Format.a(null, "audio/flac", null, -1, a2, fVar.f19022f, fVar.f19021e, singletonList, null, 0, null);
        } else if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
            a aVar2 = new a();
            this.f18031b = aVar2;
            aVar2.a(mVar);
        } else if (a(bArr)) {
            a aVar3 = this.f18031b;
            if (aVar3 == null) {
                return false;
            }
            aVar3.c(j2);
            aVar.f18066b = this.f18031b;
            return false;
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(m mVar) {
        if (a(mVar.f19048a)) {
            return c(mVar);
        }
        return -1L;
    }
}
