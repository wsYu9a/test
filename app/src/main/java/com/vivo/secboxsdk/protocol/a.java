package com.vivo.secboxsdk.protocol;

/* loaded from: classes4.dex */
public abstract class a implements CryptoEntry {

    /* renamed from: a */
    private byte[] f31131a;

    /* renamed from: b */
    private int f31132b;

    /* renamed from: c */
    private int f31133c;

    /* renamed from: d */
    private String f31134d;

    /* renamed from: e */
    private byte[] f31135e;

    public a() {
    }

    public void a(int i2) {
        this.f31132b = i2;
    }

    protected final void a(byte[] bArr) {
    }

    public int b() {
        return this.f31132b;
    }

    public byte[] c() {
        return this.f31131a;
    }

    public String d() {
        return this.f31134d;
    }

    public int e() {
        return this.f31133c;
    }

    public a(byte b2) {
    }

    public void a(String str) {
        this.f31134d = str;
    }

    public void b(int i2) {
        this.f31133c = i2;
    }

    public void c(byte[] bArr) {
        this.f31135e = bArr;
    }

    public byte[] a() {
        return this.f31135e;
    }

    protected final void b(byte[] bArr) {
        this.f31131a = bArr;
    }
}
