package com.opos.exoplayer.core;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a */
    private final b f19188a;

    /* renamed from: b */
    private final a f19189b;

    /* renamed from: c */
    private final y f19190c;

    /* renamed from: d */
    private int f19191d;

    /* renamed from: e */
    private Object f19192e;

    /* renamed from: f */
    private Handler f19193f;

    /* renamed from: g */
    private int f19194g;

    /* renamed from: h */
    private long f19195h = C.TIME_UNSET;

    /* renamed from: i */
    private boolean f19196i = true;

    /* renamed from: j */
    private boolean f19197j;
    private boolean k;
    private boolean l;

    public interface a {
        void a(r rVar);
    }

    public interface b {
        void a(int i2, Object obj);
    }

    public r(a aVar, b bVar, y yVar, int i2, Handler handler) {
        this.f19189b = aVar;
        this.f19188a = bVar;
        this.f19190c = yVar;
        this.f19193f = handler;
        this.f19194g = i2;
    }

    public r a(int i2) {
        com.opos.exoplayer.core.i.a.b(!this.f19197j);
        this.f19191d = i2;
        return this;
    }

    public r a(@Nullable Object obj) {
        com.opos.exoplayer.core.i.a.b(!this.f19197j);
        this.f19192e = obj;
        return this;
    }

    public y a() {
        return this.f19190c;
    }

    public void a(boolean z) {
        synchronized (this) {
            this.k = z | this.k;
            this.l = true;
            notifyAll();
        }
    }

    public b b() {
        return this.f19188a;
    }

    public int c() {
        return this.f19191d;
    }

    public Object d() {
        return this.f19192e;
    }

    public Handler e() {
        return this.f19193f;
    }

    public long f() {
        return this.f19195h;
    }

    public int g() {
        return this.f19194g;
    }

    public boolean h() {
        return this.f19196i;
    }

    public r i() {
        com.opos.exoplayer.core.i.a.b(!this.f19197j);
        if (this.f19195h == C.TIME_UNSET) {
            com.opos.exoplayer.core.i.a.a(this.f19196i);
        }
        this.f19197j = true;
        this.f19189b.a(this);
        return this;
    }

    public boolean j() {
        boolean z;
        synchronized (this) {
            com.opos.exoplayer.core.i.a.b(this.f19197j);
            com.opos.exoplayer.core.i.a.b(this.f19193f.getLooper().getThread() != Thread.currentThread());
            while (!this.l) {
                wait();
            }
            z = this.k;
        }
        return z;
    }
}
