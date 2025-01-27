package com.opos.exoplayer.core.c.b;

import com.opos.exoplayer.core.o;
import java.util.Stack;

/* loaded from: classes4.dex */
final class b implements c {

    /* renamed from: a */
    private final byte[] f17817a = new byte[8];

    /* renamed from: b */
    private final Stack<a> f17818b = new Stack<>();

    /* renamed from: c */
    private final f f17819c = new f();

    /* renamed from: d */
    private d f17820d;

    /* renamed from: e */
    private int f17821e;

    /* renamed from: f */
    private int f17822f;

    /* renamed from: g */
    private long f17823g;

    private static final class a {

        /* renamed from: a */
        private final int f17824a;

        /* renamed from: b */
        private final long f17825b;

        private a(int i2, long j2) {
            this.f17824a = i2;
            this.f17825b = j2;
        }

        /* synthetic */ a(int i2, long j2, AnonymousClass1 anonymousClass1) {
            this(i2, j2);
        }
    }

    b() {
    }

    private long a(com.opos.exoplayer.core.c.f fVar, int i2) {
        fVar.b(this.f17817a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (this.f17817a[i3] & 255);
        }
        return j2;
    }

    private double b(com.opos.exoplayer.core.c.f fVar, int i2) {
        return i2 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(a(fVar, i2));
    }

    private long b(com.opos.exoplayer.core.c.f fVar) {
        fVar.a();
        while (true) {
            fVar.c(this.f17817a, 0, 4);
            int a2 = f.a(this.f17817a[0]);
            if (a2 != -1 && a2 <= 4) {
                int a3 = (int) f.a(this.f17817a, a2, false);
                if (this.f17820d.b(a3)) {
                    fVar.b(a2);
                    return a3;
                }
            }
            fVar.b(1);
        }
    }

    private String c(com.opos.exoplayer.core.c.f fVar, int i2) {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        fVar.b(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public void a() {
        this.f17821e = 0;
        this.f17818b.clear();
        this.f17819c.a();
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public void a(d dVar) {
        this.f17820d = dVar;
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        com.opos.exoplayer.core.i.a.b(this.f17820d != null);
        while (true) {
            if (!this.f17818b.isEmpty() && fVar.c() >= this.f17818b.peek().f17825b) {
                this.f17820d.c(this.f17818b.pop().f17824a);
                return true;
            }
            if (this.f17821e == 0) {
                long a2 = this.f17819c.a(fVar, true, false, 4);
                if (a2 == -2) {
                    a2 = b(fVar);
                }
                if (a2 == -1) {
                    return false;
                }
                this.f17822f = (int) a2;
                this.f17821e = 1;
            }
            if (this.f17821e == 1) {
                this.f17823g = this.f17819c.a(fVar, false, true, 8);
                this.f17821e = 2;
            }
            int a3 = this.f17820d.a(this.f17822f);
            if (a3 != 0) {
                if (a3 == 1) {
                    long c2 = fVar.c();
                    this.f17818b.add(new a(this.f17822f, this.f17823g + c2));
                    this.f17820d.a(this.f17822f, c2, this.f17823g);
                } else if (a3 == 2) {
                    long j2 = this.f17823g;
                    if (j2 > 8) {
                        throw new o("Invalid integer size: " + this.f17823g);
                    }
                    this.f17820d.a(this.f17822f, a(fVar, (int) j2));
                } else if (a3 == 3) {
                    long j3 = this.f17823g;
                    if (j3 > 2147483647L) {
                        throw new o("String element size: " + this.f17823g);
                    }
                    this.f17820d.a(this.f17822f, c(fVar, (int) j3));
                } else if (a3 == 4) {
                    this.f17820d.a(this.f17822f, (int) this.f17823g, fVar);
                } else {
                    if (a3 != 5) {
                        throw new o("Invalid element type " + a3);
                    }
                    long j4 = this.f17823g;
                    if (j4 != 4 && j4 != 8) {
                        throw new o("Invalid float size: " + this.f17823g);
                    }
                    this.f17820d.a(this.f17822f, b(fVar, (int) j4));
                }
                this.f17821e = 0;
                return true;
            }
            fVar.b((int) this.f17823g);
            this.f17821e = 0;
        }
    }
}
