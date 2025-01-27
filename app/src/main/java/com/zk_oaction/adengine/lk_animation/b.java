package com.zk_oaction.adengine.lk_animation;

import android.os.SystemClock;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a */
    private long f34757a;

    /* renamed from: b */
    private boolean f34758b;

    /* renamed from: c */
    private boolean f34759c;

    /* renamed from: d */
    private boolean f34760d;

    /* renamed from: e */
    private long f34761e;

    public abstract long a();

    public abstract void b(long j2);

    public abstract boolean c(XmlPullParser xmlPullParser);

    public void d() {
        if (this.f34758b) {
            return;
        }
        this.f34758b = true;
        if (this.f34759c) {
            this.f34759c = false;
        } else {
            this.f34757a = SystemClock.uptimeMillis();
            b(0L);
        }
    }

    public void e() {
        this.f34758b = false;
        this.f34759c = true;
    }

    public void f() {
        if (this.f34758b) {
            this.f34758b = false;
            b(0L);
        }
    }

    public void g() {
        this.f34761e = SystemClock.uptimeMillis();
        this.f34760d = true;
    }

    public void h() {
        if (this.f34760d) {
            this.f34760d = false;
            this.f34757a += SystemClock.uptimeMillis() - this.f34761e;
        }
    }

    public void i() {
        if (this.f34758b) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f34757a;
            if (uptimeMillis >= a() || uptimeMillis < 0) {
                this.f34757a = SystemClock.uptimeMillis();
                uptimeMillis = 0;
            }
            b(uptimeMillis);
        }
    }
}
