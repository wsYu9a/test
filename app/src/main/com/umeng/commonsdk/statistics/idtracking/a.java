package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    private final int f24649a = 10;

    /* renamed from: b */
    private final int f24650b = 100;

    /* renamed from: c */
    private final String f24651c;

    /* renamed from: d */
    private List<com.umeng.commonsdk.statistics.proto.a> f24652d;

    /* renamed from: e */
    private com.umeng.commonsdk.statistics.proto.b f24653e;

    public a(String str) {
        this.f24651c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f24653e;
        String b10 = bVar == null ? null : bVar.b();
        int h10 = bVar == null ? 0 : bVar.h();
        String a10 = a(f());
        if (a10 == null || a10.equals(b10)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a10);
        bVar.a(System.currentTimeMillis());
        bVar.a(h10 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f24651c);
        aVar.c(a10);
        aVar.b(b10);
        aVar.a(bVar.e());
        if (this.f24652d == null) {
            this.f24652d = new ArrayList(2);
        }
        this.f24652d.add(aVar);
        if (this.f24652d.size() > 10) {
            this.f24652d.remove(0);
        }
        this.f24653e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f24651c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f24653e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f24653e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f24652d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f24653e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f24652d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f24653e = cVar.c().get(this.f24651c);
        List<com.umeng.commonsdk.statistics.proto.a> h10 = cVar.h();
        if (h10 == null || h10.size() <= 0) {
            return;
        }
        if (this.f24652d == null) {
            this.f24652d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h10) {
            if (this.f24651c.equals(aVar.f24719a)) {
                this.f24652d.add(aVar);
            }
        }
    }
}
