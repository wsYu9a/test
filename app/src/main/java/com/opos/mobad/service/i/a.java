package com.opos.mobad.service.i;

import com.opos.cmn.i.n;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private String f23685a;

    /* renamed from: b */
    private StringBuilder f23686b = new StringBuilder();

    public a(String str) {
        this.f23685a = str;
    }

    public a a(float f2) {
        if (this.f23686b.length() > 0) {
            this.f23686b.append(this.f23685a);
        }
        this.f23686b.append(f2);
        return this;
    }

    public a a(int i2) {
        if (this.f23686b.length() > 0) {
            this.f23686b.append(this.f23685a);
        }
        this.f23686b.append(i2);
        return this;
    }

    public a a(a aVar) {
        if (this.f23686b.length() > 0) {
            this.f23686b.append(this.f23685a);
        }
        this.f23686b.append((CharSequence) aVar.f23686b);
        return this;
    }

    public a a(String str) {
        if (this.f23686b.length() > 0) {
            this.f23686b.append(this.f23685a);
        }
        this.f23686b.append(n.a(str));
        return this;
    }

    public String toString() {
        return this.f23686b.toString();
    }
}
