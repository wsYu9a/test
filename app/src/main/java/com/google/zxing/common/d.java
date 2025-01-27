package com.google.zxing.common;

import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8295a;

    /* renamed from: b, reason: collision with root package name */
    private int f8296b;

    /* renamed from: c, reason: collision with root package name */
    private final String f8297c;

    /* renamed from: d, reason: collision with root package name */
    private final List<byte[]> f8298d;

    /* renamed from: e, reason: collision with root package name */
    private final String f8299e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f8300f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f8301g;

    /* renamed from: h, reason: collision with root package name */
    private Object f8302h;

    /* renamed from: i, reason: collision with root package name */
    private final int f8303i;

    /* renamed from: j, reason: collision with root package name */
    private final int f8304j;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f8298d;
    }

    public String b() {
        return this.f8299e;
    }

    public Integer c() {
        return this.f8301g;
    }

    public Integer d() {
        return this.f8300f;
    }

    public int e() {
        return this.f8296b;
    }

    public Object f() {
        return this.f8302h;
    }

    public byte[] g() {
        return this.f8295a;
    }

    public int h() {
        return this.f8303i;
    }

    public int i() {
        return this.f8304j;
    }

    public String j() {
        return this.f8297c;
    }

    public boolean k() {
        return this.f8303i >= 0 && this.f8304j >= 0;
    }

    public void l(Integer num) {
        this.f8301g = num;
    }

    public void m(Integer num) {
        this.f8300f = num;
    }

    public void n(int i2) {
        this.f8296b = i2;
    }

    public void o(Object obj) {
        this.f8302h = obj;
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.f8295a = bArr;
        this.f8296b = bArr == null ? 0 : bArr.length * 8;
        this.f8297c = str;
        this.f8298d = list;
        this.f8299e = str2;
        this.f8303i = i3;
        this.f8304j = i2;
    }
}
