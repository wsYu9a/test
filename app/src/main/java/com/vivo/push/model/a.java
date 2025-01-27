package com.vivo.push.model;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private String f31034a;

    /* renamed from: b */
    private String f31035b;

    public a(String str, String str2) {
        this.f31034a = str;
        this.f31035b = str2;
    }

    public final String a() {
        return this.f31034a;
    }

    public final String b() {
        return this.f31035b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f31034a;
        if (str == null) {
            if (aVar.f31034a != null) {
                return false;
            }
        } else if (!str.equals(aVar.f31034a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f31034a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f31034a + "', mValue='" + this.f31035b + "'}";
    }
}
