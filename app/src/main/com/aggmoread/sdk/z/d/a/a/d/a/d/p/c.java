package com.aggmoread.sdk.z.d.a.a.d.a.d.p;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.a;
import com.aggmoread.sdk.z.b.h.a;
import com.aggmoread.sdk.z.d.a.a.d.b.g;
import com.aggmoread.sdk.z.d.a.a.d.b.h;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.q;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b */
    private static c f5422b;

    /* renamed from: a */
    private boolean f5423a;

    public class a extends com.aggmoread.sdk.z.b.g.a {
        final /* synthetic */ h B;

        public a(c cVar, h hVar) {
            this.B = hVar;
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public String a() {
            h hVar = this.B;
            if (hVar != null && hVar.b() != null) {
                String h10 = this.B.b().h();
                if (!TextUtils.isEmpty(h10)) {
                    return h10;
                }
            }
            return com.aggmoread.sdk.z.d.a.a.e.c.d();
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public String i() {
            h hVar = this.B;
            if (hVar != null && hVar.b() != null) {
                String j10 = this.B.b().j();
                if (!TextUtils.isEmpty(j10)) {
                    return j10;
                }
            }
            return com.aggmoread.sdk.z.d.a.a.e.c.g();
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public String j() {
            h hVar = this.B;
            if (hVar != null && hVar.b() != null) {
                String i10 = this.B.b().i();
                if (!TextUtils.isEmpty(i10)) {
                    return i10;
                }
            }
            return com.aggmoread.sdk.z.d.a.a.e.c.j();
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public Location k() {
            h hVar = this.B;
            return (hVar == null || hVar.b() == null) ? super.k() : this.B.b().m();
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public String l() {
            h hVar = this.B;
            if (hVar != null && hVar.b() != null) {
                String n10 = this.B.b().n();
                if (!TextUtils.isEmpty(n10)) {
                    return n10;
                }
            }
            return super.l();
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public String p() {
            h hVar = this.B;
            if (hVar != null && hVar.b() != null) {
                String o10 = this.B.b().o();
                if (!TextUtils.isEmpty(o10)) {
                    return o10;
                }
            }
            return com.aggmoread.sdk.z.d.a.a.e.c.i();
        }

        @Override // com.aggmoread.sdk.z.b.g.a
        public String t() {
            h hVar = this.B;
            if (hVar != null && hVar.b() != null) {
                String p10 = this.B.b().p();
                if (!TextUtils.isEmpty(p10)) {
                    return p10;
                }
            }
            return com.aggmoread.sdk.z.d.a.a.e.c.r();
        }
    }

    public class b extends a.C0071a {
        public b(c cVar) {
        }

        @Override // com.aggmoread.sdk.z.b.g.a.C0071a
        public String a() {
            return com.aggmoread.sdk.z.d.a.a.e.c.m();
        }
    }

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f5422b == null) {
                    synchronized (c.class) {
                        try {
                            if (f5422b == null) {
                                f5422b = new c();
                            }
                        } finally {
                        }
                    }
                }
                cVar = f5422b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    private com.aggmoread.sdk.z.b.g.a b() {
        a aVar = new a(this, g.a());
        try {
            aVar.c(q.b(j.f6027q));
            aVar.a(q.a(j.f6027q));
            aVar.b(com.aggmoread.sdk.z.d.a.a.e.c.c(j.f6027q));
            aVar.j(com.aggmoread.sdk.z.d.a.a.e.c.d(j.f6027q));
            aVar.a(com.aggmoread.sdk.z.d.a.a.e.c.f(j.f6027q));
            aVar.g(com.aggmoread.sdk.z.d.a.a.e.c.p());
            aVar.b(com.aggmoread.sdk.z.d.a.a.e.c.e());
            aVar.c(com.aggmoread.sdk.z.d.a.a.e.c.f());
            aVar.k(com.aggmoread.sdk.z.d.a.a.e.c.v());
            aVar.c(com.aggmoread.sdk.z.d.a.a.e.c.s());
            aVar.i(String.valueOf(com.aggmoread.sdk.z.d.a.a.e.c.t()));
            aVar.b(com.aggmoread.sdk.z.d.a.a.e.c.k());
            aVar.a(com.aggmoread.sdk.z.d.a.a.e.c.h());
            aVar.a(com.aggmoread.sdk.z.d.a.a.e.c.a(j.f6027q));
            aVar.a(new b(this));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return aVar;
    }

    public void a(Context context) {
        d.a(j.f6028r.booleanValue());
        if (this.f5423a) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.c.x();
        com.aggmoread.sdk.z.d.a.a.e.c.A();
        com.aggmoread.sdk.z.b.h.a d10 = com.aggmoread.sdk.z.b.h.a.d();
        a.EnumC0075a enumC0075a = a.EnumC0075a.f4523b;
        this.f5423a = d10.a(context, enumC0075a, b(), null);
        com.aggmoread.sdk.z.b.g.h hVar = new com.aggmoread.sdk.z.b.g.h();
        hVar.f4512b = com.aggmoread.sdk.z.b.m.j.a("iVBORw0KGgoAAAANSUhEUgAAAGoAAAAkCAYAAABhc6+LAAAEgUlEQVRoge2az0sjZxjHH5M07mwybjIbpd2h2zAGyaEJXrLHCrm4oIcFD5LebI859WjRSy8iVDzFP2GDoJCDQvcSKXhKLsEcBMnMFmEuao0YaBoPUp50BnTezDi/k1nnA4HwPvO+82a+med9nud9x8AZIgDwGgBoAAgDQMCh+zwb7BZqHADeAsAEYfGxhJ1CxQAgCQBBwuJjGbuEQjf3nQNvqI+EHWvHK18k57Eq1FeSu/NFchirQrEAECJaPcDS0hJ1fn7+U6lUYp2eLd6jVqvNHR0dvSOMOrEi1AsAYIhWj5DP55mJiYnU8vLyzyiaXbMul8spZRvDMFQ6nf4QiURM38eKUAk9Lq/Vav14dXX1q/whLhiAmT5GKRaL4vHxcTkcDsd3dnaKdox5cHCQWVhYKIqiOHA8nudFolEnVoR6RbR4jMXFxaYoin9SFMXiQ7Y6+3Q63R+jUqlUCKNFzK4vIcn1jTS4JsTj8TjO8fT0lB80V57n+V6v1+10Ot1Bbmt6epoNh8P93zo7O/uJGEAC3efU1FTu4uKijm8rccGQhKKJlhFkZmYmR9N0/+FzHKc5wafsEqpCra+v/yB/bzQa8w9t0WgU80zI5XLvGo3GtLIv2imKirMsWyIGljArVJRoGVHu7u7aiUTiN6uzW11dVQ2c8G1KJpNzeC984Ph5aA+FQv0ggqbpN0obEolE2EAgoBlofNFCXV5etjiOI9yZGTY2Nq7Vum1vbxfwQW9tbf0+6Dp0qRhkVKvVSqFQaBED6MBMMIG1vJdE6zMF86NYLJbBoGSQSHZhRijPuD03wECj2+2Ka2trquuXHZhxfSMRSORyuZf1ev0fwuAyUiToqEhgUihLb5RdCeywRZLXHZACll6v9zdxkYQcTOTz+Q+iKHaJC3Ajb3z8NSbf+F0QhD+UqYBRoQL++vQ/19fXmHv1A4Pb21sRczHiosc0iZbHtBiGYYPBINVut9tKo1GholYr5Tc3N38RjQpomv46GAxqJtSZTOZFs9n8lzC4BCa1xWJRNe+xGzNCWSKVSn18qj/W+mKxWJIwPECPSHKi6QaYZ2WzWdVc6yn29vbE/f191bfSdaHcBJNL2T05DYokr1lmKBQKv2h1MyLUmHS6yDPgAq21yDvB4eFhyUhSi+UmjuPeEwYFRvKoiJeOfWFZB6MoXOgJowcx8uA95fZWVlb6paNOp0NEUF7EiFCeqJjLyHtD9XrdlTXKafQK5an1Cd1eIpH4HhNRJ/aGhoHeYIL20sFK3BvCarYgCI6XdpSo7TmpMTk5qau6r1co1/IRq+CJH4yi7u/vu5ubmzW376+256QGRqYqpkfoEQrPk+u+8bCZn5+fwymcnZ190kog7Yam6X49z+iekxye4x9My03rEeqtlbKRIAinFEV9JgwqhEKhMaN9HoKVj3K5XDO7QWcWPHOBxdSTkxNDe1K7u7v1bDbLV6tVzX5PCTAFAN8SrT6uoxX1Mb5Io4PaG/UGAL4hWn2GhlIoWjpP7qma3nNgTNoIpKXIzhdoFAGA/wDPNGiK1am5VQAAAABJRU5ErkJggg==");
        com.aggmoread.sdk.z.b.h.a.d().a(enumC0075a, hVar);
    }
}
