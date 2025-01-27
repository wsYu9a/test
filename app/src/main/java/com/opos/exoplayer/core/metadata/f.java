package com.opos.exoplayer.core.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.l;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class f extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* renamed from: a */
    private final c f19105a;

    /* renamed from: b */
    private final e f19106b;

    /* renamed from: c */
    private final Handler f19107c;

    /* renamed from: d */
    private final l f19108d;

    /* renamed from: e */
    private final d f19109e;

    /* renamed from: f */
    private final Metadata[] f19110f;

    /* renamed from: g */
    private final long[] f19111g;

    /* renamed from: h */
    private int f19112h;

    /* renamed from: i */
    private int f19113i;

    /* renamed from: j */
    private a f19114j;
    private boolean k;

    public f(e eVar, Looper looper) {
        this(eVar, looper, c.f19096a);
    }

    public f(e eVar, Looper looper, c cVar) {
        super(4);
        this.f19106b = (e) com.opos.exoplayer.core.i.a.a(eVar);
        this.f19107c = looper == null ? null : new Handler(looper, this);
        this.f19105a = (c) com.opos.exoplayer.core.i.a.a(cVar);
        this.f19108d = new l();
        this.f19109e = new d();
        this.f19110f = new Metadata[5];
        this.f19111g = new long[5];
    }

    private void a(Metadata metadata) {
        Handler handler = this.f19107c;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            b(metadata);
        }
    }

    private void b(Metadata metadata) {
        this.f19106b.a(metadata);
    }

    private void v() {
        Arrays.fill(this.f19110f, (Object) null);
        this.f19112h = 0;
        this.f19113i = 0;
    }

    @Override // com.opos.exoplayer.core.t
    public int a(Format format) {
        if (this.f19105a.a(format)) {
            return com.opos.exoplayer.core.a.a((com.opos.exoplayer.core.drm.b<?>) null, format.f17499i) ? 4 : 2;
        }
        return 0;
    }

    @Override // com.opos.exoplayer.core.s
    public void a(long j2, long j3) {
        if (!this.k && this.f19113i < 5) {
            this.f19109e.a();
            if (a(this.f19108d, (com.opos.exoplayer.core.b.e) this.f19109e, false) == -4) {
                if (this.f19109e.c()) {
                    this.k = true;
                } else if (!this.f19109e.d_()) {
                    d dVar = this.f19109e;
                    dVar.f19097d = this.f19108d.f19091a.w;
                    dVar.h();
                    try {
                        int i2 = (this.f19112h + this.f19113i) % 5;
                        this.f19110f[i2] = this.f19114j.a(this.f19109e);
                        this.f19111g[i2] = this.f19109e.f17740c;
                        this.f19113i++;
                    } catch (b e2) {
                        throw h.a(e2, r());
                    }
                }
            }
        }
        if (this.f19113i > 0) {
            long[] jArr = this.f19111g;
            int i3 = this.f19112h;
            if (jArr[i3] <= j2) {
                a(this.f19110f[i3]);
                Metadata[] metadataArr = this.f19110f;
                int i4 = this.f19112h;
                metadataArr[i4] = null;
                this.f19112h = (i4 + 1) % 5;
                this.f19113i--;
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(long j2, boolean z) {
        v();
        this.k = false;
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(Format[] formatArr, long j2) {
        this.f19114j = this.f19105a.b(formatArr[0]);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((Metadata) message.obj);
        return true;
    }

    @Override // com.opos.exoplayer.core.a
    protected void p() {
        v();
        this.f19114j = null;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean u() {
        return this.k;
    }
}
