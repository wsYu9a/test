package gb;

import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.ArrayList;
import java.util.List;
import xb.h;

/* loaded from: classes3.dex */
public abstract class a extends h {

    /* renamed from: b */
    public int f26204b;

    /* renamed from: a */
    public boolean f26203a = false;

    /* renamed from: c */
    public final List<TYBookItem> f26205c = new ArrayList();

    /* renamed from: d */
    public int f26206d = 0;

    public a(int i10) {
        this.f26204b = i10;
        h(true);
    }

    @Override // xb.h
    public final void c(List<TYBookItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f26205c.addAll(j(list));
            b(this.f26205c);
        }
        this.f26206d++;
        e(new x8.c(-1, "列表为空，点击重试"));
    }

    @Override // xb.h
    public final void d(x8.c cVar) {
        this.f26203a = true;
        this.f26206d++;
        e(cVar);
    }

    public final void e(x8.c cVar) {
        if (this.f26206d == this.f26204b) {
            if (this.f26205c.isEmpty() && f()) {
                g(cVar);
            } else {
                i(this.f26205c);
            }
            h(false);
        }
    }

    public boolean f() {
        return this.f26203a;
    }

    public abstract void g(x8.c cVar);

    public abstract void h(boolean z10);

    public abstract void i(List<TYBookItem> list);

    public abstract List<TYBookItem> j(List<TYBookItem> list);

    public void k(int i10) {
        this.f26204b = i10;
    }

    @Override // xb.h
    public void a(boolean z10) {
    }

    @Override // xb.h
    public void b(List<TYBookItem> list) {
    }
}
