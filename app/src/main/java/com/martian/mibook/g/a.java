package com.martian.mibook.g;

import com.martian.mibook.lib.model.d.h;
import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class a extends h {

    /* renamed from: b */
    private int f13369b;

    /* renamed from: a */
    private boolean f13368a = false;

    /* renamed from: c */
    final List<TYBookItem> f13370c = new ArrayList();

    /* renamed from: d */
    private int f13371d = 0;

    protected a(int aggSize) {
        this.f13369b = aggSize;
        h(true);
    }

    private void e(b.d.c.b.c errorResult) {
        if (this.f13371d == this.f13369b) {
            if (this.f13370c.isEmpty() && f()) {
                g(errorResult);
            } else {
                i(this.f13370c);
            }
            h(false);
        }
    }

    @Override // com.martian.mibook.lib.model.d.h
    public void a(boolean loading) {
    }

    @Override // com.martian.mibook.lib.model.d.h
    public void b(List<TYBookItem> books) {
    }

    @Override // com.martian.mibook.lib.model.d.h
    public final void c(List<TYBookItem> books) {
        if (books != null && !books.isEmpty()) {
            this.f13370c.addAll(j(books));
            b(this.f13370c);
        }
        this.f13371d++;
        e(new b.d.c.b.c(-1, "列表为空，点击重试"));
    }

    @Override // com.martian.mibook.lib.model.d.h
    public final void d(b.d.c.b.c errorResult) {
        this.f13368a = true;
        this.f13371d++;
        e(errorResult);
    }

    public boolean f() {
        return this.f13368a;
    }

    public abstract void g(b.d.c.b.c errorResult);

    public abstract void h(boolean loading);

    public abstract void i(List<TYBookItem> books);

    public abstract List<TYBookItem> j(List<TYBookItem> books);

    public void k(int aggSize) {
        this.f13369b = aggSize;
    }
}
