package com.martian.ttbook.b.c.a.a.b.a.d.z;

import android.content.Context;
import b.d.e.c.a.d;
import com.martian.ttbook.b.c.a.a.d.b.g;
import com.martian.ttbook.b.c.a.a.d.b.h;
import com.martian.ttbook.b.c.a.a.d.b.j;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static b f15545a;

    /* renamed from: b */
    private boolean f15546b;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f15545a == null) {
                synchronized (b.class) {
                    if (f15545a == null) {
                        f15545a = new b();
                    }
                }
            }
            bVar = f15545a;
        }
        return bVar;
    }

    private b.d.e.c.a.f.a c() {
        b.d.e.c.a.f.a aVar = new b.d.e.c.a.f.a();
        try {
            aVar.b(com.martian.ttbook.b.c.a.a.e.b.l());
            aVar.d(com.martian.ttbook.b.c.a.a.e.b.q());
            aVar.f(com.martian.ttbook.b.c.a.a.e.b.r());
            aVar.j(com.martian.ttbook.b.c.a.a.e.b.w());
            h b2 = g.b();
            if (b2 != null) {
                aVar.h(b2.c());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public void b(Context context) {
        d.i(j.r.booleanValue());
        if (this.f15546b) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.b.C();
        com.martian.ttbook.b.c.a.a.e.b.D();
        this.f15546b = com.martian.ttbook.b.a.g.a.f().c(context, c(), null);
        b.d.e.c.a.f.g gVar = new b.d.e.c.a.f.g();
        gVar.f4617c = com.martian.ttbook.b.a.k.j.a("iVBORw0KGgoAAAANSUhEUgAAAGoAAAAkCAYAAABhc6+LAAAEgUlEQVRoge2az0sjZxjHH5M07mwybjIbpd2h2zAGyaEJXrLHCrm4oIcFD5LebI859WjRSy8iVDzFP2GDoJCDQvcSKXhKLsEcBMnMFmEuao0YaBoPUp50BnTezDi/k1nnA4HwPvO+82a+med9nud9x8AZIgDwGgBoAAgDQMCh+zwb7BZqHADeAsAEYfGxhJ1CxQAgCQBBwuJjGbuEQjf3nQNvqI+EHWvHK18k57Eq1FeSu/NFchirQrEAECJaPcDS0hJ1fn7+U6lUYp2eLd6jVqvNHR0dvSOMOrEi1AsAYIhWj5DP55mJiYnU8vLyzyiaXbMul8spZRvDMFQ6nf4QiURM38eKUAk9Lq/Vav14dXX1q/whLhiAmT5GKRaL4vHxcTkcDsd3dnaKdox5cHCQWVhYKIqiOHA8nudFolEnVoR6RbR4jMXFxaYoin9SFMXiQ7Y6+3Q63R+jUqlUCKNFzK4vIcn1jTS4JsTj8TjO8fT0lB80V57n+V6v1+10Ot1Bbmt6epoNh8P93zo7O/uJGEAC3efU1FTu4uKijm8rccGQhKKJlhFkZmYmR9N0/+FzHKc5wafsEqpCra+v/yB/bzQa8w9t0WgU80zI5XLvGo3GtLIv2imKirMsWyIGljArVJRoGVHu7u7aiUTiN6uzW11dVQ2c8G1KJpNzeC984Ph5aA+FQv0ggqbpN0obEolE2EAgoBlofNFCXV5etjiOI9yZGTY2Nq7Vum1vbxfwQW9tbf0+6Dp0qRhkVKvVSqFQaBED6MBMMIG1vJdE6zMF86NYLJbBoGSQSHZhRijPuD03wECj2+2Ka2trquuXHZhxfSMRSORyuZf1ev0fwuAyUiToqEhgUihLb5RdCeywRZLXHZACll6v9zdxkYQcTOTz+Q+iKHaJC3Ajb3z8NSbf+F0QhD+UqYBRoQL++vQ/19fXmHv1A4Pb21sRczHiosc0iZbHtBiGYYPBINVut9tKo1GholYr5Tc3N38RjQpomv46GAxqJtSZTOZFs9n8lzC4BCa1xWJRNe+xGzNCWSKVSn18qj/W+mKxWJIwPECPSHKi6QaYZ2WzWdVc6yn29vbE/f191bfSdaHcBJNL2T05DYokr1lmKBQKv2h1MyLUmHS6yDPgAq21yDvB4eFhyUhSi+UmjuPeEwYFRvKoiJeOfWFZB6MoXOgJowcx8uA95fZWVlb6paNOp0NEUF7EiFCeqJjLyHtD9XrdlTXKafQK5an1Cd1eIpH4HhNRJ/aGhoHeYIL20sFK3BvCarYgCI6XdpSo7TmpMTk5qau6r1co1/IRq+CJH4yi7u/vu5ubmzW376+256QGRqYqpkfoEQrPk+u+8bCZn5+fwymcnZ190kog7Yam6X49z+iekxye4x9My03rEeqtlbKRIAinFEV9JgwqhEKhMaN9HoKVj3K5XDO7QWcWPHOBxdSTkxNDe1K7u7v1bDbLV6tVzX5PCTAFAN8SrT6uoxX1Mb5Io4PaG/UGAL4hWn2GhlIoWjpP7qma3nNgTNoIpKXIzhdoFAGA/wDPNGiK1am5VQAAAABJRU5ErkJggg==");
        com.martian.ttbook.b.a.g.a.f().b(gVar);
    }
}
