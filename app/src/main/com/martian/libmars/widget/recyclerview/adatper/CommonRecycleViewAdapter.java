package com.martian.libmars.widget.recyclerview.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.libmars.widget.recyclerview.bean.PageBean;
import java.util.ArrayList;
import java.util.List;
import s9.c;
import t9.a;

/* loaded from: classes3.dex */
public abstract class CommonRecycleViewAdapter<T> extends RecyclerView.Adapter<ViewHolderHelper> implements a<T> {

    /* renamed from: c */
    public Context f12822c;

    /* renamed from: d */
    public int f12823d;

    /* renamed from: e */
    public List<T> f12824e;

    /* renamed from: f */
    public LayoutInflater f12825f;

    /* renamed from: g */
    public c<T> f12826g;

    /* renamed from: h */
    public final PageBean f12827h;

    public CommonRecycleViewAdapter(Context context, int i10) {
        this.f12824e = new ArrayList();
        this.f12822c = context;
        this.f12825f = LayoutInflater.from(context);
        this.f12823d = i10;
        this.f12827h = new PageBean();
    }

    @Override // t9.a
    public void a(List<T> list) {
        this.f12824e.clear();
        this.f12824e.addAll(list);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void add(T t10) {
        this.f12824e.add(t10);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void b(int i10) {
        this.f12824e.remove(i10);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void c(List<T> list) {
        this.f12824e.removeAll(list);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void clear() {
        if (this.f12824e.size() > 0) {
            this.f12824e.clear();
            notifyDataSetChanged();
        }
    }

    @Override // t9.a
    public boolean contains(T t10) {
        return this.f12824e.contains(t10);
    }

    @Override // t9.a
    public void d(int i10, T t10) {
        this.f12824e.add(i10, t10);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void f(int i10, List<T> list) {
        this.f12824e.addAll(i10, list);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void g(int i10, T t10) {
        this.f12824e.set(i10, t10);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public T get(int i10) {
        if (i10 < 0 || i10 >= this.f12824e.size()) {
            return null;
        }
        return this.f12824e.get(i10);
    }

    @Override // t9.a
    public List<T> getAll() {
        return this.f12824e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.f12824e.size();
    }

    @Override // t9.a
    public int getSize() {
        return this.f12824e.size();
    }

    @Override // t9.a
    public void h(List<T> list) {
        this.f12824e.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void k(ViewHolderHelper viewHolderHelper, T t10);

    public PageBean l() {
        return this.f12827h;
    }

    public int m(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    public final /* synthetic */ void n(ViewHolderHelper viewHolderHelper, ViewGroup viewGroup, View view) {
        int m10;
        if (this.f12826g == null || m(viewHolderHelper) - 2 < 0 || m10 >= this.f12824e.size()) {
            return;
        }
        this.f12826g.a(viewGroup, view, this.f12824e.get(m10), m10);
    }

    public final /* synthetic */ boolean o(ViewHolderHelper viewHolderHelper, ViewGroup viewGroup, View view) {
        int m10;
        if (this.f12826g == null || m(viewHolderHelper) - 2 < 0 || m10 >= this.f12824e.size()) {
            return false;
        }
        return this.f12826g.b(viewGroup, view, this.f12824e.get(m10), m10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(ViewHolderHelper viewHolderHelper, int i10) {
        viewHolderHelper.F(i10);
        k(viewHolderHelper, this.f12824e.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: q */
    public ViewHolderHelper onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        ViewHolderHelper b10 = ViewHolderHelper.b(this.f12822c, viewGroup, this.f12823d);
        r(viewGroup, b10);
        return b10;
    }

    public void r(ViewGroup viewGroup, ViewHolderHelper viewHolderHelper) {
        viewHolderHelper.c().setOnClickListener(new View.OnClickListener() { // from class: r9.a

            /* renamed from: c */
            public final /* synthetic */ ViewHolderHelper f30363c;

            /* renamed from: d */
            public final /* synthetic */ ViewGroup f30364d;

            public /* synthetic */ a(ViewHolderHelper viewHolderHelper2, ViewGroup viewGroup2) {
                viewHolderHelper = viewHolderHelper2;
                viewGroup = viewGroup2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonRecycleViewAdapter.this.n(viewHolderHelper, viewGroup, view);
            }
        });
        viewHolderHelper2.c().setOnLongClickListener(new View.OnLongClickListener() { // from class: r9.b

            /* renamed from: c */
            public final /* synthetic */ ViewHolderHelper f30366c;

            /* renamed from: d */
            public final /* synthetic */ ViewGroup f30367d;

            public /* synthetic */ b(ViewHolderHelper viewHolderHelper2, ViewGroup viewGroup2) {
                viewHolderHelper = viewHolderHelper2;
                viewGroup = viewGroup2;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean o10;
                o10 = CommonRecycleViewAdapter.this.o(viewHolderHelper, viewGroup, view);
                return o10;
            }
        });
    }

    @Override // t9.a
    public void remove(T t10) {
        this.f12824e.remove(t10);
        notifyDataSetChanged();
    }

    @Override // t9.a
    public void replace(T t10, T t11) {
        g(this.f12824e.indexOf(t10), t11);
    }

    public void s(c<T> cVar) {
        this.f12826g = cVar;
    }

    public CommonRecycleViewAdapter(Context context, int i10, List<T> list) {
        this.f12824e = new ArrayList();
        this.f12822c = context;
        this.f12825f = LayoutInflater.from(context);
        this.f12823d = i10;
        this.f12824e = list;
        this.f12827h = new PageBean();
    }
}
