package com.martian.ttbook.b.c.a.a.d.b;

/* loaded from: classes4.dex */
public class i implements com.martian.ttbook.b.c.a.a.c.d {

    /* renamed from: a */
    public int f15769a;

    /* renamed from: b */
    public String f15770b;

    /* renamed from: c */
    public Exception f15771c;

    public i(int i2, String str) {
        this.f15769a = i2;
        this.f15770b = str;
    }

    public i(int i2, String str, Exception exc) {
        this.f15769a = i2;
        this.f15770b = str;
        this.f15771c = exc;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.d
    public int a() {
        return this.f15769a;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.d
    public String b() {
        return this.f15770b;
    }

    public String toString() {
        return String.format("Error{code= %s,message= %s,exception= %s}", Integer.valueOf(this.f15769a), this.f15770b, this.f15771c);
    }
}
