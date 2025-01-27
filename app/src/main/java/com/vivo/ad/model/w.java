package com.vivo.ad.model;

/* loaded from: classes4.dex */
public class w {

    /* renamed from: a */
    private boolean f26934a;

    /* renamed from: b */
    private double f26935b;

    /* renamed from: c */
    private double f26936c;

    /* renamed from: d */
    private double f26937d;

    /* renamed from: e */
    private double f26938e;

    public w(d dVar) {
        if (dVar != null) {
            this.f26934a = dVar.j();
            if (dVar.f() != null) {
                this.f26935b = r3.a();
                this.f26936c = r3.e();
            }
        }
    }

    public void a(double d2) {
        this.f26937d = d2;
    }

    public void b(double d2) {
        this.f26938e = d2;
    }

    public double c() {
        return this.f26937d;
    }

    public double d() {
        return this.f26938e;
    }

    public boolean e() {
        return this.f26934a && this.f26937d > 0.0d && this.f26938e > 0.0d;
    }

    public String toString() {
        return "ShakeReportData{isShakeType=" + this.f26934a + ", sensorAngle=" + this.f26937d + ", sensorSpeed=" + this.f26938e + ", cfgAngle=" + this.f26935b + ", cfgSpeed=" + this.f26936c + '}';
    }

    public double a() {
        return this.f26935b;
    }

    public double b() {
        return this.f26936c;
    }
}
