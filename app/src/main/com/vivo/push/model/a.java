package com.vivo.push.model;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private String f25070a;

    /* renamed from: b */
    private String f25071b;

    public a(String str, String str2) {
        this.f25070a = str;
        this.f25071b = str2;
    }

    public final String a() {
        return this.f25070a;
    }

    public final String b() {
        return this.f25071b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f25070a;
        if (str == null) {
            if (aVar.f25070a != null) {
                return false;
            }
        } else if (!str.equals(aVar.f25070a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f25070a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f25070a + "', mValue='" + this.f25071b + "'}";
    }
}
