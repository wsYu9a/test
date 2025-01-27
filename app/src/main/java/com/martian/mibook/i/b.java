package com.martian.mibook.i;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class b extends com.martian.mibook.g.a {

    /* renamed from: e */
    private final BookManager f13384e;

    /* renamed from: f */
    private final int f13385f;

    /* renamed from: g */
    private final List<com.martian.mibook.lib.model.c.b> f13386g;

    public b(BookManager bookMgr, int page) {
        super(bookMgr.c0().size() - 1);
        this.f13384e = bookMgr;
        this.f13385f = page;
        this.f13386g = l();
    }

    private List<com.martian.mibook.lib.model.c.b> l() {
        ArrayList arrayList = new ArrayList();
        for (com.martian.mibook.lib.model.c.b bVar : this.f13384e.c0().values()) {
            if (!(bVar instanceof com.martian.mibook.lib.yuewen.c.a) && bVar.H()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void m(String keyword, int searchType, String sourceName, String sourceId) {
        k(this.f13386g.size());
        Iterator<com.martian.mibook.lib.model.c.b> it = this.f13386g.iterator();
        while (it.hasNext()) {
            it.next().s(keyword, this.f13385f, this, false, searchType, MiConfigSingleton.V3().k(), sourceName, sourceId);
        }
    }
}
