package com.czhj.volley;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class Header {

    /* renamed from: a, reason: collision with root package name */
    public final String f8722a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8723b;

    public Header(String str, String str2) {
        this.f8722a = str;
        this.f8723b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.f8722a, header.f8722a) && TextUtils.equals(this.f8723b, header.f8723b);
    }

    public final String getName() {
        return this.f8722a;
    }

    public final String getValue() {
        return this.f8723b;
    }

    public int hashCode() {
        return (this.f8722a.hashCode() * 31) + this.f8723b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f8722a + ",value=" + this.f8723b + "]";
    }
}
