package e6;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a */
    public final String f25713a;

    /* renamed from: b */
    public SymbolShapeHint f25714b;

    /* renamed from: c */
    public t5.c f25715c;

    /* renamed from: d */
    public t5.c f25716d;

    /* renamed from: e */
    public final StringBuilder f25717e;

    /* renamed from: f */
    public int f25718f;

    /* renamed from: g */
    public int f25719g;

    /* renamed from: h */
    public k f25720h;

    /* renamed from: i */
    public int f25721i;

    public h(String str) {
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = (char) (bytes[i10] & 255);
            if (c10 == '?' && str.charAt(i10) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c10);
        }
        this.f25713a = sb2.toString();
        this.f25714b = SymbolShapeHint.FORCE_NONE;
        this.f25717e = new StringBuilder(str.length());
        this.f25719g = -1;
    }

    public int a() {
        return this.f25717e.length();
    }

    public StringBuilder b() {
        return this.f25717e;
    }

    public char c() {
        return this.f25713a.charAt(this.f25718f);
    }

    public char d() {
        return this.f25713a.charAt(this.f25718f);
    }

    public String e() {
        return this.f25713a;
    }

    public int f() {
        return this.f25719g;
    }

    public int g() {
        return i() - this.f25718f;
    }

    public k h() {
        return this.f25720h;
    }

    public final int i() {
        return this.f25713a.length() - this.f25721i;
    }

    public boolean j() {
        return this.f25718f < i();
    }

    public void k() {
        this.f25719g = -1;
    }

    public void l() {
        this.f25720h = null;
    }

    public void m(t5.c cVar, t5.c cVar2) {
        this.f25715c = cVar;
        this.f25716d = cVar2;
    }

    public void n(int i10) {
        this.f25721i = i10;
    }

    public void o(SymbolShapeHint symbolShapeHint) {
        this.f25714b = symbolShapeHint;
    }

    public void p(int i10) {
        this.f25719g = i10;
    }

    public void q() {
        r(a());
    }

    public void r(int i10) {
        k kVar = this.f25720h;
        if (kVar == null || i10 > kVar.b()) {
            this.f25720h = k.o(i10, this.f25714b, this.f25715c, this.f25716d, true);
        }
    }

    public void s(char c10) {
        this.f25717e.append(c10);
    }

    public void t(String str) {
        this.f25717e.append(str);
    }
}
