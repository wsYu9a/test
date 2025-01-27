package com.opos.mobad.d.b;

import com.opos.mobad.d.e;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public final String f20449a;

    /* renamed from: b */
    public final String f20450b;

    /* renamed from: c */
    public final String f20451c;

    /* renamed from: d */
    public final String f20452d;

    /* renamed from: f */
    public int f20454f = 0;

    /* renamed from: g */
    public int f20455g = 0;

    /* renamed from: e */
    public final Set<e> f20453e = new HashSet();

    public a(String str, String str2, String str3, String str4) {
        this.f20449a = str2;
        this.f20450b = str3;
        this.f20451c = str4;
        this.f20452d = str;
    }

    public void a(e eVar) {
        if (eVar != null) {
            if (this.f20453e.size() > 0) {
                for (e eVar2 : this.f20453e) {
                    if (eVar2 != null && (eVar2 == eVar || eVar2.hashCode() == eVar.hashCode())) {
                        return;
                    }
                }
            }
            this.f20453e.add(eVar);
        }
    }

    public void b(e eVar) {
        if (eVar == null || this.f20453e.size() <= 0) {
            return;
        }
        this.f20453e.remove(eVar);
    }

    public String toString() {
        return "DownloadData{url='" + this.f20452d + "', md5='" + this.f20451c + "', appName='" + this.f20449a + "', pkgName='" + this.f20450b + "'}";
    }
}
