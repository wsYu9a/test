package ng;

import pg.c;
import pg.d;

/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a */
    public pg.a f28930a;

    public b(pg.a aVar) {
        this.f28930a = aVar;
    }

    @Override // ng.a
    public void a(String str, c cVar) {
        this.f28930a.a(new d.a(str).f(20000).h(30000).b(3).c("User-Agent", sg.c.a()).d(), cVar);
    }
}
