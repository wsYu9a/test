package com.google.zxing.datamatrix.encoder;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a */
    private final String f8393a;

    /* renamed from: b */
    private SymbolShapeHint f8394b;

    /* renamed from: c */
    private com.google.zxing.c f8395c;

    /* renamed from: d */
    private com.google.zxing.c f8396d;

    /* renamed from: e */
    private final StringBuilder f8397e;

    /* renamed from: f */
    int f8398f;

    /* renamed from: g */
    private int f8399g;

    /* renamed from: h */
    private k f8400h;

    /* renamed from: i */
    private int f8401i;

    h(String str) {
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.f8393a = sb.toString();
        this.f8394b = SymbolShapeHint.FORCE_NONE;
        this.f8397e = new StringBuilder(str.length());
        this.f8399g = -1;
    }

    private int i() {
        return this.f8393a.length() - this.f8401i;
    }

    public int a() {
        return this.f8397e.length();
    }

    public StringBuilder b() {
        return this.f8397e;
    }

    public char c() {
        return this.f8393a.charAt(this.f8398f);
    }

    public char d() {
        return this.f8393a.charAt(this.f8398f);
    }

    public String e() {
        return this.f8393a;
    }

    public int f() {
        return this.f8399g;
    }

    public int g() {
        return i() - this.f8398f;
    }

    public k h() {
        return this.f8400h;
    }

    public boolean j() {
        return this.f8398f < i();
    }

    public void k() {
        this.f8399g = -1;
    }

    public void l() {
        this.f8400h = null;
    }

    public void m(com.google.zxing.c cVar, com.google.zxing.c cVar2) {
        this.f8395c = cVar;
        this.f8396d = cVar2;
    }

    public void n(int i2) {
        this.f8401i = i2;
    }

    public void o(SymbolShapeHint symbolShapeHint) {
        this.f8394b = symbolShapeHint;
    }

    public void p(int i2) {
        this.f8399g = i2;
    }

    public void q() {
        r(a());
    }

    public void r(int i2) {
        k kVar = this.f8400h;
        if (kVar == null || i2 > kVar.b()) {
            this.f8400h = k.o(i2, this.f8394b, this.f8395c, this.f8396d, true);
        }
    }

    public void s(char c2) {
        this.f8397e.append(c2);
    }

    public void t(String str) {
        this.f8397e.append(str);
    }
}
