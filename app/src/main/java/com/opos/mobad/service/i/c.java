package com.opos.mobad.service.i;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private StringBuilder f23687a = new StringBuilder();

    public int a() {
        return this.f23687a.length();
    }

    public c a(String str, String str2) {
        if (this.f23687a.length() > 0) {
            this.f23687a.append(";");
        }
        this.f23687a.append(str);
        this.f23687a.append(":");
        this.f23687a.append(str2);
        return this;
    }

    public String b() {
        return this.f23687a.toString();
    }
}
