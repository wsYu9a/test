package com.opos.mobad.model.b;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private String f21530a;

    /* renamed from: b */
    private String f21531b;

    /* renamed from: c */
    private String f21532c;

    public String a() {
        return this.f21530a;
    }

    public void a(String str) {
        this.f21530a = str;
    }

    public String b() {
        return this.f21531b;
    }

    public void b(String str) {
        this.f21531b = str;
    }

    public String c() {
        return this.f21532c;
    }

    public void c(String str) {
        this.f21532c = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f21530a.equals(eVar.a()) && this.f21531b.equals(eVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f21530a.hashCode() * this.f21531b.hashCode();
    }

    public String toString() {
        return "FetchMaterialEntity{url='" + this.f21530a + "', md5='" + this.f21531b + "', savePath='" + this.f21532c + "'}";
    }
}
