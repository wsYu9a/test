package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e.b;
import com.opos.exoplayer.core.c.e.i;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class k extends i {

    /* renamed from: a */
    private a f18071a;

    /* renamed from: b */
    private int f18072b;

    /* renamed from: c */
    private boolean f18073c;

    /* renamed from: d */
    private b.d f18074d;

    /* renamed from: e */
    private b.C0403b f18075e;

    static final class a {

        /* renamed from: a */
        public final b.d f18076a;

        /* renamed from: b */
        public final b.C0403b f18077b;

        /* renamed from: c */
        public final byte[] f18078c;

        /* renamed from: d */
        public final b.c[] f18079d;

        /* renamed from: e */
        public final int f18080e;

        public a(b.d dVar, b.C0403b c0403b, byte[] bArr, b.c[] cVarArr, int i2) {
            this.f18076a = dVar;
            this.f18077b = c0403b;
            this.f18078c = bArr;
            this.f18079d = cVarArr;
            this.f18080e = i2;
        }
    }

    k() {
    }

    static int a(byte b2, int i2, int i3) {
        return (b2 >> i3) & (255 >>> (8 - i2));
    }

    private static int a(byte b2, a aVar) {
        return !aVar.f18079d[a(b2, aVar.f18080e, 1)].f18005a ? aVar.f18076a.f18015g : aVar.f18076a.f18016h;
    }

    static void a(m mVar, long j2) {
        mVar.b(mVar.c() + 4);
        mVar.f19048a[mVar.c() - 4] = (byte) (j2 & 255);
        mVar.f19048a[mVar.c() - 3] = (byte) ((j2 >>> 8) & 255);
        mVar.f19048a[mVar.c() - 2] = (byte) ((j2 >>> 16) & 255);
        mVar.f19048a[mVar.c() - 1] = (byte) ((j2 >>> 24) & 255);
    }

    public static boolean a(m mVar) {
        try {
            return b.a(1, mVar, true);
        } catch (o unused) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void a(boolean z) {
        super.a(z);
        if (z) {
            this.f18071a = null;
            this.f18074d = null;
            this.f18075e = null;
        }
        this.f18072b = 0;
        this.f18073c = false;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(m mVar, long j2, i.a aVar) {
        if (this.f18071a != null) {
            return false;
        }
        a c2 = c(mVar);
        this.f18071a = c2;
        if (c2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f18071a.f18076a.f18018j);
        arrayList.add(this.f18071a.f18078c);
        b.d dVar = this.f18071a.f18076a;
        aVar.f18065a = Format.a(null, "audio/vorbis", null, dVar.f18013e, -1, dVar.f18010b, (int) dVar.f18011c, arrayList, null, 0, null);
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(m mVar) {
        byte[] bArr = mVar.f19048a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(bArr[0], this.f18071a);
        long j2 = this.f18073c ? (this.f18072b + a2) / 4 : 0;
        a(mVar, j2);
        this.f18073c = true;
        this.f18072b = a2;
        return j2;
    }

    a c(m mVar) {
        if (this.f18074d == null) {
            this.f18074d = b.a(mVar);
        } else {
            if (this.f18075e != null) {
                byte[] bArr = new byte[mVar.c()];
                System.arraycopy(mVar.f19048a, 0, bArr, 0, mVar.c());
                return new a(this.f18074d, this.f18075e, bArr, b.a(mVar, this.f18074d.f18010b), b.a(r5.length - 1));
            }
            this.f18075e = b.b(mVar);
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void c(long j2) {
        super.c(j2);
        this.f18073c = j2 != 0;
        b.d dVar = this.f18074d;
        this.f18072b = dVar != null ? dVar.f18015g : 0;
    }
}
