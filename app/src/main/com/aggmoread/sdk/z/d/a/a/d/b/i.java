package com.aggmoread.sdk.z.d.a.a.d.b;

/* loaded from: classes.dex */
public class i implements com.aggmoread.sdk.z.d.a.a.c.d {

    /* renamed from: a */
    public int f6008a;

    /* renamed from: b */
    public String f6009b;

    /* renamed from: c */
    public Exception f6010c;

    public i(int i10, String str) {
        this.f6008a = i10;
        this.f6009b = str;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.d
    public int a() {
        return this.f6008a;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.d
    public String b() {
        return this.f6009b;
    }

    public String toString() {
        return String.format("{ErrorCode= %s,ErrMsg= %s,ErrExcep= %s}", Integer.valueOf(this.f6008a), this.f6009b, this.f6010c);
    }

    public i(int i10, String str, Exception exc) {
        this.f6008a = i10;
        this.f6009b = str;
        this.f6010c = exc;
    }
}
