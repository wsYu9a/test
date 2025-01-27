package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* loaded from: classes.dex */
public final class o extends t {

    /* renamed from: b */
    public String f6389b;

    /* renamed from: c */
    public byte[] f6390c;

    /* renamed from: g */
    public boolean f6394g;

    /* renamed from: e */
    public ArrayList<Header> f6392e = new ArrayList<>();

    /* renamed from: f */
    public Map<String, String> f6393f = new HashMap();

    /* renamed from: d */
    public String f6391d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f6389b = str;
    }

    public final String a() {
        return this.f6389b;
    }

    public final String b(String str) {
        Map<String, String> map = this.f6393f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final String c() {
        return this.f6391d;
    }

    public final ArrayList<Header> d() {
        return this.f6392e;
    }

    public final boolean e() {
        return this.f6394g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        byte[] bArr = this.f6390c;
        if (bArr == null) {
            if (oVar.f6390c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.f6390c)) {
            return false;
        }
        String str = this.f6389b;
        String str2 = oVar.f6389b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Map<String, String> map = this.f6393f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f6393f.get("id").hashCode() + 31) * 31;
        String str = this.f6389b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f6389b, this.f6392e);
    }

    public final void a(String str) {
        this.f6391d = str;
    }

    public final byte[] b() {
        return this.f6390c;
    }

    public final void a(String str, String str2) {
        if (this.f6393f == null) {
            this.f6393f = new HashMap();
        }
        this.f6393f.put(str, str2);
    }

    public final void a(Header header) {
        this.f6392e.add(header);
    }

    public final void a(boolean z10) {
        this.f6394g = z10;
    }

    public final void a(byte[] bArr) {
        this.f6390c = bArr;
    }
}
