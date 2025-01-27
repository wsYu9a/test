package com.opos.mobad.service.j;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: a */
    private int f23725a;

    /* renamed from: b */
    private int f23726b;

    /* renamed from: c */
    private int f23727c;

    /* renamed from: d */
    private double f23728d;

    /* renamed from: e */
    private a f23729e;

    /* renamed from: f */
    private long f23730f;

    /* renamed from: g */
    private int f23731g;

    /* renamed from: h */
    private int f23732h;

    public interface a {
        void a(m mVar);
    }

    public m(int i2, int i3, int i4, double d2, a aVar) {
        this.f23725a = i2;
        this.f23726b = i3;
        this.f23727c = i4;
        this.f23728d = d2;
        this.f23729e = aVar;
    }

    public m(int i2, int i3, a aVar) {
        this(i2, 0, i3, 0.0d, aVar);
    }

    private void e() {
        int i2;
        int i3;
        if (SystemClock.elapsedRealtime() - this.f23730f >= this.f23725a && (i2 = this.f23731g) >= this.f23726b && (i3 = this.f23732h) >= this.f23727c) {
            double d2 = i2;
            double d3 = i3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (d2 / d3 >= this.f23728d) {
                this.f23729e.a(this);
                f();
            }
        }
    }

    private void f() {
        this.f23732h = 0;
        this.f23731g = 0;
        this.f23730f = SystemClock.elapsedRealtime();
    }

    public void a() {
        this.f23731g++;
        e();
    }

    public void a(int i2, int i3) {
        this.f23731g += i2;
        this.f23732h += i3;
        e();
    }

    public void b() {
        this.f23732h++;
        e();
    }

    public int c() {
        return this.f23731g;
    }

    public int d() {
        return this.f23732h;
    }
}
