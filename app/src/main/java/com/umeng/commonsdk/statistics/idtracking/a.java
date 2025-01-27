package com.umeng.commonsdk.statistics.idtracking;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    private final int f26328a = 10;

    /* renamed from: b */
    private final int f26329b = 100;

    /* renamed from: c */
    private final String f26330c;

    /* renamed from: d */
    private List<com.umeng.commonsdk.statistics.proto.a> f26331d;

    /* renamed from: e */
    private com.umeng.commonsdk.statistics.proto.b f26332e;

    public a(String str) {
        this.f26330c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f26332e;
        String b2 = bVar == null ? null : bVar.b();
        int h2 = bVar == null ? 0 : bVar.h();
        String a2 = a(f());
        if (a2 == null || a2.equals(b2)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a2);
        bVar.a(System.currentTimeMillis());
        bVar.a(h2 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f26330c);
        aVar.c(a2);
        aVar.b(b2);
        aVar.a(bVar.e());
        if (this.f26331d == null) {
            this.f26331d = new ArrayList(2);
        }
        this.f26331d.add(aVar);
        if (this.f26331d.size() > 10) {
            this.f26331d.remove(0);
        }
        this.f26332e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f26330c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f26332e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f26332e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f26331d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f26332e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f26331d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || EnvironmentCompat.MEDIA_UNKNOWN.equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f26332e = cVar.c().get(this.f26330c);
        List<com.umeng.commonsdk.statistics.proto.a> h2 = cVar.h();
        if (h2 == null || h2.size() <= 0) {
            return;
        }
        if (this.f26331d == null) {
            this.f26331d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h2) {
            if (this.f26330c.equals(aVar.f26391a)) {
                this.f26331d.add(aVar);
            }
        }
    }
}
