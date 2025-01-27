package com.opos.mobad.model.d;

/* loaded from: classes4.dex */
public class p {

    /* renamed from: a */
    private StringBuilder f21635a = new StringBuilder();

    public p a(String str, int i2) {
        this.f21635a.append(str);
        this.f21635a.append(":");
        this.f21635a.append(i2);
        this.f21635a.append(";");
        return this;
    }

    public p a(String str, String str2) {
        this.f21635a.append(str);
        this.f21635a.append(":");
        this.f21635a.append(str2);
        this.f21635a.append(";");
        return this;
    }

    public String a() {
        return this.f21635a.toString();
    }
}
