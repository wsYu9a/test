package zd;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class b extends gb.a {

    /* renamed from: e */
    public final BookManager f33769e;

    /* renamed from: f */
    public final int f33770f;

    /* renamed from: g */
    public final List<wb.b> f33771g;

    public b(BookManager bookManager, int i10) {
        super(bookManager.P().size() - 1);
        this.f33769e = bookManager;
        this.f33770f = i10;
        this.f33771g = l();
    }

    public final List<wb.b> l() {
        ArrayList arrayList = new ArrayList();
        for (wb.b bVar : this.f33769e.P().values()) {
            if (!(bVar instanceof hc.a) && bVar.J()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void m(String str, int i10, String str2, String str3) {
        k(this.f33771g.size());
        Iterator<wb.b> it = this.f33771g.iterator();
        while (it.hasNext()) {
            it.next().j(str, this.f33770f, this, false, i10, MiConfigSingleton.b2().p(), str2, str3);
        }
    }
}
