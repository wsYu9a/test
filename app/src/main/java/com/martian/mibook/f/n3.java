package com.martian.mibook.f;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.activity.book.AuthorBooksActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.ui.o.n4;
import com.martian.ttbookhd.R;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class n3 extends com.martian.libmars.f.h implements com.martian.libmars.widget.recyclerview.f.a {

    /* renamed from: j */
    private String f13215j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private int p = 0;
    private int q;
    private n4 r;
    private com.martian.mibook.e.e3 s;
    private MiBookManager.m0 t;

    class a extends com.martian.mibook.lib.model.d.h {
        a() {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
            if (loading) {
                n3 n3Var = n3.this;
                n3Var.I(n3Var.getString(R.string.loading));
            }
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
            super.b(books);
            if (AuthorBooksActivity.G.equalsIgnoreCase(n3.this.o)) {
                n3 n3Var = n3.this;
                n3Var.J(books, n3Var.k);
            }
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            n3.this.F(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            n3.this.G(errorResult);
        }
    }

    class b extends com.martian.mibook.lib.model.d.h {
        b() {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
            if (loading) {
                n3 n3Var = n3.this;
                n3Var.I(n3Var.getString(R.string.loading));
            }
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            Iterator<TYBookItem> it = books.iterator();
            while (it.hasNext()) {
                if (it.next().getSourceString().equals(n3.this.n)) {
                    it.remove();
                }
            }
            n3.this.F(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            n3.this.G(errorResult);
        }
    }

    private void B() {
        MiConfigSingleton.V3().l3().U1(this.f13215j, this.p, new a(), this.l, this.m);
    }

    private void C() {
        if (this.t == null) {
            MiBookManager.m0 m0Var = new MiBookManager.m0();
            this.t = m0Var;
            m0Var.l(0);
            this.t.n(AuthorBooksActivity.J.equalsIgnoreCase(this.o) ? 8 : 3);
            this.t.o(this.q);
            this.t.q(this.l);
            this.t.p(this.m);
            this.t.j(this.k);
        }
        MiConfigSingleton.V3().l3().T1(this.t, new b());
    }

    public static n3 D(String author, String bookname, String type) {
        n3 n3Var = new n3();
        Bundle bundle = new Bundle();
        if (!com.martian.libsupport.k.p(author)) {
            bundle.putString(MiConfigSingleton.N0, author);
        }
        if (!com.martian.libsupport.k.p(bookname)) {
            bundle.putString(MiConfigSingleton.L0, bookname);
        }
        bundle.putString(AuthorBooksActivity.F, type);
        n3Var.setArguments(bundle);
        return n3Var;
    }

    public static n3 E(String bookname, String sourceId, String sourceName, String sourceString, String type, int seed) {
        n3 n3Var = new n3();
        Bundle bundle = new Bundle();
        if (!com.martian.libsupport.k.p(bookname)) {
            bundle.putString(MiConfigSingleton.L0, bookname);
        }
        if (!com.martian.libsupport.k.p(sourceId)) {
            bundle.putString(MiConfigSingleton.F0, sourceId);
        }
        if (!com.martian.libsupport.k.p(sourceName)) {
            bundle.putString(MiConfigSingleton.D0, sourceName);
        }
        if (!com.martian.libsupport.k.p(sourceString)) {
            bundle.putString(MiConfigSingleton.G0, sourceString);
        }
        bundle.putString(AuthorBooksActivity.F, type);
        bundle.putInt(MiConfigSingleton.O0, seed);
        n3Var.setArguments(bundle);
        return n3Var;
    }

    public void F(List<TYBookItem> books) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        p();
        k();
        this.s.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        if (books == null || books.size() <= 0) {
            if (this.r.getSize() > 0) {
                this.s.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                return;
            }
            return;
        }
        if (this.r.E().isRefresh()) {
            this.r.a(books);
            this.r.Q(this.s.f11898b);
        } else {
            this.r.m(books);
        }
        this.p++;
        MiBookManager.m0 m0Var = this.t;
        if (m0Var != null) {
            m0Var.h();
        }
    }

    public void G(b.d.c.b.c errorResult) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        p();
        H(errorResult);
    }

    public void J(List<TYBookItem> books, String excludeBookName) {
        Iterator<TYBookItem> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getBookName() == null) {
                it.remove();
            }
        }
        Collections.sort(books, new Comparator() { // from class: com.martian.mibook.f.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareTo;
                compareTo = ((TYBookItem) obj).getBookName().compareTo(((TYBookItem) obj2).getBookName());
                return compareTo;
            }
        });
        Iterator<TYBookItem> it2 = books.iterator();
        String str = "";
        while (it2.hasNext()) {
            String bookName = it2.next().getBookName();
            if (bookName.equals(excludeBookName)) {
                it2.remove();
            } else if (bookName.equals(str)) {
                it2.remove();
            } else {
                str = bookName;
            }
        }
    }

    private void z() {
        if (f()) {
            if (AuthorBooksActivity.G.equalsIgnoreCase(this.o) || AuthorBooksActivity.H.equalsIgnoreCase(this.o)) {
                B();
            } else {
                C();
            }
        }
    }

    public void H(b.d.c.b.c errorResult) {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        n4 n4Var = this.r;
        if (n4Var == null || n4Var.getSize() <= 0) {
            j(errorResult);
            this.s.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            k();
            this.s.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        }
    }

    public void I(String title) {
        n4 n4Var = this.r;
        if (n4Var == null || n4Var.getSize() > 0) {
            return;
        }
        l(title);
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_comments;
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.r.E().setRefresh(true);
            this.p = 0;
            z();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.f.a
    public void onLoadMore(View loadMoreView) {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            this.r.E().setRefresh(this.r.getSize() <= 0);
            this.s.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        if (savedInstanceState != null) {
            this.f13215j = savedInstanceState.getString(MiConfigSingleton.N0);
            this.k = savedInstanceState.getString(MiConfigSingleton.L0);
            this.m = savedInstanceState.getString(MiConfigSingleton.F0);
            this.l = savedInstanceState.getString(MiConfigSingleton.D0);
            this.n = savedInstanceState.getString(MiConfigSingleton.G0);
            this.o = savedInstanceState.getString(AuthorBooksActivity.F);
            this.q = savedInstanceState.getInt(MiConfigSingleton.O0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13215j = arguments.getString(MiConfigSingleton.N0);
                this.k = arguments.getString(MiConfigSingleton.L0);
                this.m = arguments.getString(MiConfigSingleton.F0);
                this.l = arguments.getString(MiConfigSingleton.D0);
                this.n = arguments.getString(MiConfigSingleton.G0);
                this.o = arguments.getString(AuthorBooksActivity.F);
                this.q = arguments.getInt(MiConfigSingleton.O0);
            }
        }
        com.martian.mibook.e.e3 a2 = com.martian.mibook.e.e3.a(g());
        this.s = a2;
        a2.f11898b.setLayoutManager(new LinearLayoutManager(getContext()));
        n4 n4Var = new n4(a());
        this.r = n4Var;
        this.s.f11898b.setAdapter(n4Var);
        this.s.f11898b.setOnLoadMoreListener(this);
        this.s.f11898b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        z();
    }
}
