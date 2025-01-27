package com.google.zxing.u.c;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public static final int f8869a = 8;

    /* renamed from: b */
    private Mode f8870b;

    /* renamed from: c */
    private ErrorCorrectionLevel f8871c;

    /* renamed from: d */
    private g f8872d;

    /* renamed from: e */
    private int f8873e = -1;

    /* renamed from: f */
    private b f8874f;

    public static boolean f(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public ErrorCorrectionLevel a() {
        return this.f8871c;
    }

    public int b() {
        return this.f8873e;
    }

    public b c() {
        return this.f8874f;
    }

    public Mode d() {
        return this.f8870b;
    }

    public g e() {
        return this.f8872d;
    }

    public void g(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f8871c = errorCorrectionLevel;
    }

    public void h(int i2) {
        this.f8873e = i2;
    }

    public void i(b bVar) {
        this.f8874f = bVar;
    }

    public void j(Mode mode) {
        this.f8870b = mode;
    }

    public void k(g gVar) {
        this.f8872d = gVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f8870b);
        sb.append("\n ecLevel: ");
        sb.append(this.f8871c);
        sb.append("\n version: ");
        sb.append(this.f8872d);
        sb.append("\n maskPattern: ");
        sb.append(this.f8873e);
        if (this.f8874f == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f8874f);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
