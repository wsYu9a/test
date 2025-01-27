package com.martian.mibook.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.activity.book.AuthorBooksActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentCommentsBinding;
import com.martian.mibook.fragment.AuthorBookListFragment;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import x8.c;
import xb.h;
import ya.e0;

/* loaded from: classes3.dex */
public class AuthorBookListFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public String f13602k;

    /* renamed from: l */
    public String f13603l;

    /* renamed from: m */
    public String f13604m;

    /* renamed from: n */
    public String f13605n;

    /* renamed from: o */
    public String f13606o;

    /* renamed from: p */
    public String f13607p;

    /* renamed from: q */
    public int f13608q = 0;

    /* renamed from: r */
    public int f13609r;

    /* renamed from: s */
    public TYBookItemListAdapter f13610s;

    /* renamed from: t */
    public FragmentCommentsBinding f13611t;

    /* renamed from: u */
    public MiBookManager.j0 f13612u;

    public class a extends h {
        public a() {
        }

        @Override // xb.h
        public void a(boolean z10) {
            if (z10) {
                AuthorBookListFragment authorBookListFragment = AuthorBookListFragment.this;
                authorBookListFragment.f0(authorBookListFragment.getString(R.string.loading));
            }
        }

        @Override // xb.h
        public void b(List<TYBookItem> list) {
            super.b(list);
            if (AuthorBooksActivity.I.equalsIgnoreCase(AuthorBookListFragment.this.f13607p)) {
                AuthorBookListFragment authorBookListFragment = AuthorBookListFragment.this;
                authorBookListFragment.g0(list, authorBookListFragment.f13603l);
            }
        }

        @Override // xb.h
        public void c(List<TYBookItem> list) {
            AuthorBookListFragment.this.b0(list);
        }

        @Override // xb.h
        public void d(c cVar) {
            AuthorBookListFragment.this.d0(cVar);
        }
    }

    public class b extends h {
        public b() {
        }

        @Override // xb.h
        public void a(boolean z10) {
            if (z10) {
                AuthorBookListFragment authorBookListFragment = AuthorBookListFragment.this;
                authorBookListFragment.f0(authorBookListFragment.getString(R.string.loading));
            }
        }

        @Override // xb.h
        public void c(List<TYBookItem> list) {
            Iterator<TYBookItem> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getSourceString().equals(AuthorBookListFragment.this.f13606o)) {
                    it.remove();
                }
            }
            AuthorBookListFragment.this.b0(list);
        }

        @Override // xb.h
        public void d(c cVar) {
            AuthorBookListFragment.this.d0(cVar);
        }
    }

    private void U() {
        if (r()) {
            if (AuthorBooksActivity.I.equalsIgnoreCase(this.f13607p) || AuthorBooksActivity.J.equalsIgnoreCase(this.f13607p)) {
                X();
            } else {
                Y();
            }
        }
    }

    public static /* synthetic */ int W(TYBookItem tYBookItem, TYBookItem tYBookItem2) {
        return tYBookItem.getBookName().compareTo(tYBookItem2.getBookName());
    }

    public static AuthorBookListFragment Z(String str, String str2, String str3) {
        AuthorBookListFragment authorBookListFragment = new AuthorBookListFragment();
        Bundle bundle = new Bundle();
        if (!l.q(str)) {
            bundle.putString(MiConfigSingleton.V0, str);
        }
        if (!l.q(str2)) {
            bundle.putString(MiConfigSingleton.U0, str2);
        }
        bundle.putString(AuthorBooksActivity.H, str3);
        authorBookListFragment.setArguments(bundle);
        return authorBookListFragment;
    }

    public static AuthorBookListFragment a0(String str, String str2, String str3, String str4, String str5, int i10) {
        AuthorBookListFragment authorBookListFragment = new AuthorBookListFragment();
        Bundle bundle = new Bundle();
        if (!l.q(str)) {
            bundle.putString(MiConfigSingleton.U0, str);
        }
        if (!l.q(str2)) {
            bundle.putString(e0.f33175s0, str2);
        }
        if (!l.q(str3)) {
            bundle.putString(e0.f33173r0, str3);
        }
        if (!l.q(str4)) {
            bundle.putString(e0.f33177t0, str4);
        }
        bundle.putString(AuthorBooksActivity.H, str5);
        bundle.putInt(MiConfigSingleton.W0, i10);
        authorBookListFragment.setArguments(bundle);
        return authorBookListFragment;
    }

    public void b0(List<TYBookItem> list) {
        if (getActivity() == null) {
            return;
        }
        H();
        y();
        this.f13611t.commentsIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        if (list == null || list.isEmpty()) {
            if (this.f13610s.getSize() > 0) {
                this.f13611t.commentsIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                return;
            }
            return;
        }
        if (this.f13610s.l().isRefresh()) {
            this.f13610s.a(list);
            this.f13610s.x(this.f13611t.commentsIrc);
        } else {
            this.f13610s.h(list);
        }
        this.f13608q++;
        MiBookManager.j0 j0Var = this.f13612u;
        if (j0Var != null) {
            j0Var.h();
        }
    }

    public void d0(c cVar) {
        if (getActivity() == null) {
            return;
        }
        H();
        e0(cVar);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (getActivity() == null) {
            return;
        }
        this.f13610s.l().setRefresh(true);
        this.f13608q = 0;
        U();
    }

    public final void X() {
        MiConfigSingleton.b2().M1().k1(this.f13602k, this.f13608q, new a(), this.f13604m, this.f13605n);
    }

    public final void Y() {
        if (this.f13612u == null) {
            MiBookManager.j0 j0Var = new MiBookManager.j0();
            this.f13612u = j0Var;
            j0Var.l(0);
            this.f13612u.n(AuthorBooksActivity.L.equalsIgnoreCase(this.f13607p) ? 8 : 3);
            this.f13612u.o(this.f13609r);
            this.f13612u.q(this.f13604m);
            this.f13612u.p(this.f13605n);
            this.f13612u.j(this.f13603l);
        }
        MiConfigSingleton.b2().M1().j1(this.f13612u, new b());
    }

    public void e0(c cVar) {
        if (getActivity() == null) {
            return;
        }
        TYBookItemListAdapter tYBookItemListAdapter = this.f13610s;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
            x(cVar);
            this.f13611t.commentsIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        } else {
            y();
            this.f13611t.commentsIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        }
    }

    public void f0(String str) {
        TYBookItemListAdapter tYBookItemListAdapter = this.f13610s;
        if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() > 0) {
            return;
        }
        z(str);
    }

    public final void g0(List<TYBookItem> list, String str) {
        Iterator<TYBookItem> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getBookName() == null) {
                it.remove();
            }
        }
        Collections.sort(list, new Comparator() { // from class: db.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int W;
                W = AuthorBookListFragment.W((TYBookItem) obj, (TYBookItem) obj2);
                return W;
            }
        });
        Iterator<TYBookItem> it2 = list.iterator();
        String str2 = "";
        while (it2.hasNext()) {
            String bookName = it2.next().getBookName();
            if (bookName.equals(str)) {
                it2.remove();
            } else if (bookName.equals(str2)) {
                it2.remove();
            } else {
                str2 = bookName;
            }
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (getActivity() == null) {
            return;
        }
        this.f13610s.l().setRefresh(this.f13610s.getSize() <= 0);
        this.f13611t.commentsIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        U();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f13602k = bundle.getString(MiConfigSingleton.V0);
            this.f13603l = bundle.getString(MiConfigSingleton.U0);
            this.f13605n = bundle.getString(e0.f33175s0);
            this.f13604m = bundle.getString(e0.f33173r0);
            this.f13606o = bundle.getString(e0.f33177t0);
            this.f13607p = bundle.getString(AuthorBooksActivity.H);
            this.f13609r = bundle.getInt(MiConfigSingleton.W0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13602k = arguments.getString(MiConfigSingleton.V0);
                this.f13603l = arguments.getString(MiConfigSingleton.U0);
                this.f13605n = arguments.getString(e0.f33175s0);
                this.f13604m = arguments.getString(e0.f33173r0);
                this.f13606o = arguments.getString(e0.f33177t0);
                this.f13607p = arguments.getString(AuthorBooksActivity.H);
                this.f13609r = arguments.getInt(MiConfigSingleton.W0);
            }
        }
        FragmentCommentsBinding bind = FragmentCommentsBinding.bind(t());
        this.f13611t = bind;
        bind.commentsIrc.setLayoutManager(new LinearLayoutManager(getActivity()));
        TYBookItemListAdapter tYBookItemListAdapter = new TYBookItemListAdapter(j());
        this.f13610s = tYBookItemListAdapter;
        this.f13611t.commentsIrc.setAdapter(tYBookItemListAdapter);
        this.f13611t.commentsIrc.setOnLoadMoreListener(this);
        this.f13611t.commentsIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        U();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return com.martian.mibook.R.layout.fragment_comments;
    }
}
