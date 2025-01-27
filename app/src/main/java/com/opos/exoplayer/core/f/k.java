package com.opos.exoplayer.core.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.Format;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class k extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* renamed from: a */
    private final Handler f18813a;

    /* renamed from: b */
    private final j f18814b;

    /* renamed from: c */
    private final g f18815c;

    /* renamed from: d */
    private final com.opos.exoplayer.core.l f18816d;

    /* renamed from: e */
    private boolean f18817e;

    /* renamed from: f */
    private boolean f18818f;

    /* renamed from: g */
    private int f18819g;

    /* renamed from: h */
    private Format f18820h;

    /* renamed from: i */
    private e f18821i;

    /* renamed from: j */
    private h f18822j;
    private i k;
    private i l;
    private int m;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.f18747a);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.f18814b = (j) com.opos.exoplayer.core.i.a.a(jVar);
        this.f18813a = looper == null ? null : new Handler(looper, this);
        this.f18815c = gVar;
        this.f18816d = new com.opos.exoplayer.core.l();
    }

    private void a(List<b> list) {
        Handler handler = this.f18813a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    private void b(List<b> list) {
        this.f18814b.a(list);
    }

    private void v() {
        this.f18822j = null;
        this.m = -1;
        i iVar = this.k;
        if (iVar != null) {
            iVar.e();
            this.k = null;
        }
        i iVar2 = this.l;
        if (iVar2 != null) {
            iVar2.e();
            this.l = null;
        }
    }

    private void w() {
        v();
        this.f18821i.d();
        this.f18821i = null;
        this.f18819g = 0;
    }

    private void x() {
        w();
        this.f18821i = this.f18815c.b(this.f18820h);
    }

    private long y() {
        int i2 = this.m;
        if (i2 == -1 || i2 >= this.k.b()) {
            return Long.MAX_VALUE;
        }
        return this.k.a(this.m);
    }

    private void z() {
        a(Collections.emptyList());
    }

    @Override // com.opos.exoplayer.core.t
    public int a(Format format) {
        return this.f18815c.a(format) ? com.opos.exoplayer.core.a.a((com.opos.exoplayer.core.drm.b<?>) null, format.f17499i) ? 4 : 2 : com.opos.exoplayer.core.i.j.c(format.f17496f) ? 1 : 0;
    }

    @Override // com.opos.exoplayer.core.s
    public void a(long j2, long j3) {
        boolean z;
        if (this.f18818f) {
            return;
        }
        if (this.l == null) {
            this.f18821i.a(j2);
            try {
                this.l = this.f18821i.b();
            } catch (f e2) {
                throw com.opos.exoplayer.core.h.a(e2, r());
            }
        }
        if (a_() == 2) {
            if (this.k != null) {
                long y = y();
                z = false;
                while (y <= j2) {
                    this.m++;
                    y = y();
                    z = true;
                }
            } else {
                z = false;
            }
            i iVar = this.l;
            if (iVar != null) {
                if (iVar.c()) {
                    if (!z && y() == Long.MAX_VALUE) {
                        if (this.f18819g == 2) {
                            x();
                        } else {
                            v();
                            this.f18818f = true;
                        }
                    }
                } else if (((com.opos.exoplayer.core.b.f) this.l).f17742a <= j2) {
                    i iVar2 = this.k;
                    if (iVar2 != null) {
                        iVar2.e();
                    }
                    i iVar3 = this.l;
                    this.k = iVar3;
                    this.l = null;
                    this.m = iVar3.a(j2);
                    z = true;
                }
            }
            if (z) {
                a(this.k.b(j2));
            }
            if (this.f18819g != 2) {
                while (!this.f18817e) {
                    try {
                        if (this.f18822j == null) {
                            h a2 = this.f18821i.a();
                            this.f18822j = a2;
                            if (a2 == null) {
                                return;
                            }
                        }
                        if (this.f18819g == 1) {
                            this.f18822j.a_(4);
                            this.f18821i.a((e) this.f18822j);
                            this.f18822j = null;
                            this.f18819g = 2;
                            return;
                        }
                        int a3 = a(this.f18816d, (com.opos.exoplayer.core.b.e) this.f18822j, false);
                        if (a3 == -4) {
                            if (this.f18822j.c()) {
                                this.f18817e = true;
                            } else {
                                h hVar = this.f18822j;
                                hVar.f18759d = this.f18816d.f19091a.w;
                                hVar.h();
                            }
                            this.f18821i.a((e) this.f18822j);
                            this.f18822j = null;
                        } else if (a3 == -3) {
                            return;
                        }
                    } catch (f e3) {
                        throw com.opos.exoplayer.core.h.a(e3, r());
                    }
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(long j2, boolean z) {
        z();
        this.f18817e = false;
        this.f18818f = false;
        if (this.f18819g != 0) {
            x();
        } else {
            v();
            this.f18821i.c();
        }
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(Format[] formatArr, long j2) {
        Format format = formatArr[0];
        this.f18820h = format;
        if (this.f18821i != null) {
            this.f18819g = 1;
        } else {
            this.f18821i = this.f18815c.b(format);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((List<b>) message.obj);
        return true;
    }

    @Override // com.opos.exoplayer.core.a
    protected void p() {
        this.f18820h = null;
        z();
        w();
    }

    @Override // com.opos.exoplayer.core.s
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean u() {
        return this.f18818f;
    }
}
