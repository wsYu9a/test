package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes4.dex */
final class c implements g {

    /* renamed from: a */
    private final f f18019a = new f();

    /* renamed from: b */
    private final long f18020b;

    /* renamed from: c */
    private final long f18021c;

    /* renamed from: d */
    private final i f18022d;

    /* renamed from: e */
    private int f18023e;

    /* renamed from: f */
    private long f18024f;

    /* renamed from: g */
    private long f18025g;

    /* renamed from: h */
    private long f18026h;

    /* renamed from: i */
    private long f18027i;

    /* renamed from: j */
    private long f18028j;
    private long k;
    private long l;

    private class a implements l {
        private a() {
        }

        /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return true;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return c.this.f18022d.a(c.this.f18024f);
        }

        @Override // com.opos.exoplayer.core.c.l
        public l.a b(long j2) {
            if (j2 == 0) {
                return new l.a(new m(0L, c.this.f18020b));
            }
            long b2 = c.this.f18022d.b(j2);
            c cVar = c.this;
            return new l.a(new m(j2, cVar.a(cVar.f18020b, b2, 30000L)));
        }
    }

    public c(long j2, long j3, i iVar, int i2, long j4) {
        com.opos.exoplayer.core.i.a.a(j2 >= 0 && j3 > j2);
        this.f18022d = iVar;
        this.f18020b = j2;
        this.f18021c = j3;
        if (i2 != j3 - j2) {
            this.f18023e = 0;
        } else {
            this.f18024f = j4;
            this.f18023e = 3;
        }
    }

    public long a(long j2, long j3, long j4) {
        long j5 = this.f18021c;
        long j6 = this.f18020b;
        long j7 = ((((j5 - j6) * j3) / this.f18024f) - j4) + j2;
        if (j7 >= j6) {
            j6 = j7;
        }
        return j6 >= j5 ? j5 - 1 : j6;
    }

    @Override // com.opos.exoplayer.core.c.e.g
    public long a(long j2) {
        int i2 = this.f18023e;
        com.opos.exoplayer.core.i.a.a(i2 == 3 || i2 == 2);
        this.f18026h = j2 != 0 ? this.f18022d.b(j2) : 0L;
        this.f18023e = 2;
        b();
        return this.f18026h;
    }

    public long a(long j2, com.opos.exoplayer.core.c.f fVar) {
        long j3;
        if (this.f18027i != this.f18028j) {
            long c2 = fVar.c();
            if (!a(fVar, this.f18028j)) {
                long j4 = this.f18027i;
                if (j4 != c2) {
                    return j4;
                }
                throw new IOException("No ogg page can be found.");
            }
            this.f18019a.a(fVar, false);
            fVar.a();
            f fVar2 = this.f18019a;
            long j5 = fVar2.f18044c;
            long j6 = j2 - j5;
            int i2 = fVar2.f18049h + fVar2.f18050i;
            if (j6 >= 0 && j6 <= 72000) {
                fVar.b(i2);
                j3 = this.f18019a.f18044c;
                return -(j3 + 2);
            }
            if (j6 < 0) {
                this.f18028j = c2;
                this.l = j5;
            } else {
                long j7 = i2;
                long c3 = fVar.c() + j7;
                this.f18027i = c3;
                this.k = this.f18019a.f18044c;
                if ((this.f18028j - c3) + j7 < 100000) {
                    fVar.b(i2);
                }
            }
            long j8 = this.f18028j;
            long j9 = this.f18027i;
            if (j8 - j9 < 100000) {
                this.f18028j = j9;
                return j9;
            }
            long c4 = fVar.c() - ((j6 > 0 ? 1L : 2L) * i2);
            long j10 = this.f18028j;
            long j11 = this.f18027i;
            return Math.min(Math.max(c4 + ((j6 * (j10 - j11)) / (this.l - this.k)), j11), this.f18028j - 1);
        }
        j3 = this.k;
        return -(j3 + 2);
    }

    @Override // com.opos.exoplayer.core.c.e.g
    public long a(com.opos.exoplayer.core.c.f fVar) {
        int i2 = this.f18023e;
        if (i2 == 0) {
            long c2 = fVar.c();
            this.f18025g = c2;
            this.f18023e = 1;
            long j2 = this.f18021c - 65307;
            if (j2 > c2) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j3 = this.f18026h;
            long j4 = 0;
            if (j3 != 0) {
                long a2 = a(j3, fVar);
                if (a2 >= 0) {
                    return a2;
                }
                j4 = a(fVar, this.f18026h, -(a2 + 2));
            }
            this.f18023e = 3;
            return -(j4 + 2);
        }
        this.f18024f = c(fVar);
        this.f18023e = 3;
        return this.f18025g;
    }

    long a(com.opos.exoplayer.core.c.f fVar, long j2, long j3) {
        this.f18019a.a(fVar, false);
        while (true) {
            f fVar2 = this.f18019a;
            if (fVar2.f18044c >= j2) {
                fVar.a();
                return j3;
            }
            fVar.b(fVar2.f18049h + fVar2.f18050i);
            f fVar3 = this.f18019a;
            long j4 = fVar3.f18044c;
            fVar3.a(fVar, false);
            j3 = j4;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.g
    /* renamed from: a */
    public a c() {
        if (this.f18024f != 0) {
            return new a();
        }
        return null;
    }

    boolean a(com.opos.exoplayer.core.c.f fVar, long j2) {
        int i2;
        long min = Math.min(j2 + 3, this.f18021c);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i4 = 0;
            if (fVar.c() + i3 > min && (i3 = (int) (min - fVar.c())) < 4) {
                return false;
            }
            fVar.b(bArr, 0, i3, false);
            while (true) {
                i2 = i3 - 3;
                if (i4 < i2) {
                    if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        fVar.b(i4);
                        return true;
                    }
                    i4++;
                }
            }
            fVar.b(i2);
        }
    }

    public void b() {
        this.f18027i = this.f18020b;
        this.f18028j = this.f18021c;
        this.k = 0L;
        this.l = this.f18024f;
    }

    void b(com.opos.exoplayer.core.c.f fVar) {
        if (!a(fVar, this.f18021c)) {
            throw new EOFException();
        }
    }

    long c(com.opos.exoplayer.core.c.f fVar) {
        b(fVar);
        this.f18019a.a();
        while ((this.f18019a.f18043b & 4) != 4 && fVar.c() < this.f18021c) {
            this.f18019a.a(fVar, false);
            f fVar2 = this.f18019a;
            fVar.b(fVar2.f18049h + fVar2.f18050i);
        }
        return this.f18019a.f18044c;
    }
}
