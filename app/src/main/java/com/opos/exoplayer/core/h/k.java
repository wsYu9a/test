package com.opos.exoplayer.core.h;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.opos.exoplayer.core.h.d;

/* loaded from: classes4.dex */
public final class k implements d, t<Object> {

    /* renamed from: a */
    private final Handler f18933a;

    /* renamed from: b */
    private final d.a f18934b;

    /* renamed from: c */
    private final com.opos.exoplayer.core.i.q f18935c;

    /* renamed from: d */
    private final com.opos.exoplayer.core.i.b f18936d;

    /* renamed from: e */
    private int f18937e;

    /* renamed from: f */
    private long f18938f;

    /* renamed from: g */
    private long f18939g;

    /* renamed from: h */
    private long f18940h;

    /* renamed from: i */
    private long f18941i;

    /* renamed from: j */
    private long f18942j;

    /* renamed from: com.opos.exoplayer.core.h.k$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f18943a;

        /* renamed from: b */
        final /* synthetic */ long f18944b;

        /* renamed from: c */
        final /* synthetic */ long f18945c;

        AnonymousClass1(int i2, long j2, long j3) {
            i2 = i2;
            j2 = j2;
            j3 = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f18934b.a(i2, j2, j3);
        }
    }

    public k() {
        this(null, null);
    }

    public k(Handler handler, d.a aVar) {
        this(handler, aVar, 2000);
    }

    public k(Handler handler, d.a aVar, int i2) {
        this(handler, aVar, i2, com.opos.exoplayer.core.i.b.f19008a);
    }

    public k(Handler handler, d.a aVar, int i2, com.opos.exoplayer.core.i.b bVar) {
        this.f18933a = handler;
        this.f18934b = aVar;
        this.f18935c = new com.opos.exoplayer.core.i.q(i2);
        this.f18936d = bVar;
        this.f18942j = -1L;
    }

    private void a(int i2, long j2, long j3) {
        Handler handler = this.f18933a;
        if (handler == null || this.f18934b == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.opos.exoplayer.core.h.k.1

            /* renamed from: a */
            final /* synthetic */ int f18943a;

            /* renamed from: b */
            final /* synthetic */ long f18944b;

            /* renamed from: c */
            final /* synthetic */ long f18945c;

            AnonymousClass1(int i22, long j22, long j32) {
                i2 = i22;
                j2 = j22;
                j3 = j32;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f18934b.a(i2, j2, j3);
            }
        });
    }

    @Override // com.opos.exoplayer.core.h.d
    public long a() {
        long j2;
        synchronized (this) {
            j2 = this.f18942j;
        }
        return j2;
    }

    @Override // com.opos.exoplayer.core.h.t
    public void a(Object obj) {
        synchronized (this) {
            com.opos.exoplayer.core.i.a.b(this.f18937e > 0);
            long a2 = this.f18936d.a();
            int i2 = (int) (a2 - this.f18938f);
            this.f18940h += i2;
            long j2 = this.f18941i;
            long j3 = this.f18939g;
            this.f18941i = j2 + j3;
            if (i2 > 0) {
                this.f18935c.a((int) Math.sqrt(j3), (8000 * j3) / r7);
                if (this.f18940h >= 2000 || this.f18941i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    float a3 = this.f18935c.a(0.5f);
                    this.f18942j = Float.isNaN(a3) ? -1L : (long) a3;
                }
            }
            a(i2, this.f18939g, this.f18942j);
            int i3 = this.f18937e - 1;
            this.f18937e = i3;
            if (i3 > 0) {
                this.f18938f = a2;
            }
            this.f18939g = 0L;
        }
    }

    @Override // com.opos.exoplayer.core.h.t
    public void a(Object obj, int i2) {
        synchronized (this) {
            this.f18939g += i2;
        }
    }

    @Override // com.opos.exoplayer.core.h.t
    public void a(Object obj, i iVar) {
        synchronized (this) {
            if (this.f18937e == 0) {
                this.f18938f = this.f18936d.a();
            }
            this.f18937e++;
        }
    }
}
