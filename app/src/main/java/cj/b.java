package cj;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public m f2035a;

    /* renamed from: b */
    public int f2036b = 0;

    /* renamed from: c */
    public int f2037c;

    /* renamed from: d */
    public int f2038d;

    public b(m mVar) {
        this.f2035a = mVar;
    }

    public String a() {
        return this.f2035a.c();
    }

    public int b() {
        return this.f2037c;
    }

    public int c(byte b10) {
        int b11 = this.f2035a.b(b10);
        if (this.f2036b == 0) {
            this.f2038d = 0;
            this.f2037c = this.f2035a.a(b11);
        }
        int d10 = this.f2035a.d(b11, this.f2036b);
        this.f2036b = d10;
        this.f2038d++;
        return d10;
    }

    public void d() {
        this.f2036b = 0;
    }
}
