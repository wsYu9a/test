package com.alipay.mobilesecuritysdk.a;

import java.math.BigDecimal;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private final int f5177a = 14400;

    /* renamed from: b */
    private final double f5178b = 180.0d;

    /* renamed from: c */
    private final double f5179c = -180.0d;

    /* renamed from: d */
    private final double f5180d = 90.0d;

    /* renamed from: e */
    private final double f5181e = -90.0d;

    /* renamed from: f */
    private List<f> f5182f;

    /* renamed from: g */
    private List<String> f5183g;

    /* renamed from: h */
    private String f5184h;

    /* renamed from: i */
    private String f5185i;

    /* renamed from: j */
    private String f5186j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    private String y(double d2) {
        return String.valueOf(new BigDecimal(d2).setScale(5, 4).doubleValue());
    }

    public String a() {
        return this.k;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.f5186j;
    }

    public String d() {
        return this.f5185i;
    }

    public String e() {
        return this.n;
    }

    public String f() {
        return this.o;
    }

    public String g() {
        return this.m;
    }

    public List<String> h() {
        return this.f5183g;
    }

    public String i() {
        return this.f5184h;
    }

    public List<f> j() {
        return this.f5182f;
    }

    public void k(String str) {
        this.k = str;
    }

    public void l(String str) {
        this.l = str;
    }

    public void m(double d2) {
        if (d2 >= 90.0d || d2 <= -90.0d) {
            return;
        }
        this.f5186j = y(d2);
    }

    public void n(int i2) {
        double d2 = i2;
        Double.isNaN(d2);
        m(d2 / 14400.0d);
    }

    public void o(String str) {
        this.f5186j = str;
    }

    public void p(double d2) {
        if (d2 >= 180.0d || d2 <= -180.0d) {
            return;
        }
        this.f5185i = y(d2);
    }

    public void q(int i2) {
        double d2 = i2;
        Double.isNaN(d2);
        p(d2 / 14400.0d);
    }

    public void r(String str) {
        this.f5185i = str;
    }

    public void s(String str) {
        this.n = str;
    }

    public void t(String str) {
        this.o = str;
    }

    public void u(String str) {
        this.m = str;
    }

    public void v(List<String> list) {
        this.f5183g = list;
    }

    public void w(String str) {
        this.f5184h = str;
    }

    public void x(List<f> list) {
        this.f5182f = list;
    }

    public boolean z() {
        if (com.alipay.mobilesecuritysdk.c.a.i(this.f5186j) || com.alipay.mobilesecuritysdk.c.a.i(this.f5185i)) {
            return (com.alipay.mobilesecuritysdk.c.a.i(this.k) || com.alipay.mobilesecuritysdk.c.a.i(this.l)) ? false : true;
        }
        return true;
    }
}
