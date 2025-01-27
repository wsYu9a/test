package com.martian.libmars.widget.recyclerview.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.widget.recyclerview.bean.PageBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class c<T> extends RecyclerView.Adapter<com.martian.libmars.widget.recyclerview.d> implements com.martian.libmars.widget.recyclerview.g.a<T> {

    /* renamed from: a */
    protected Context f10474a;

    /* renamed from: b */
    protected int f10475b;

    /* renamed from: c */
    protected List<T> f10476c;

    /* renamed from: d */
    protected LayoutInflater f10477d;

    /* renamed from: e */
    protected com.martian.libmars.widget.recyclerview.f.c<T> f10478e;

    /* renamed from: f */
    private final PageBean f10479f;

    public c(Context context, int layoutId) {
        this.f10476c = new ArrayList();
        this.f10474a = context;
        this.f10477d = LayoutInflater.from(context);
        this.f10475b = layoutId;
        this.f10479f = new PageBean();
    }

    /* renamed from: G */
    public /* synthetic */ void H(com.martian.libmars.widget.recyclerview.d dVar, ViewGroup viewGroup, View view) {
        int F;
        if (this.f10478e == null || F(dVar) - 2 < 0 || F >= this.f10476c.size()) {
            return;
        }
        this.f10478e.a(viewGroup, view, this.f10476c.get(F), F);
    }

    /* renamed from: I */
    public /* synthetic */ boolean J(com.martian.libmars.widget.recyclerview.d dVar, ViewGroup viewGroup, View view) {
        int F;
        if (this.f10478e == null || F(dVar) - 2 < 0 || F >= this.f10476c.size()) {
            return false;
        }
        return this.f10478e.b(viewGroup, view, this.f10476c.get(F), F);
    }

    public PageBean E() {
        return this.f10479f;
    }

    protected int F(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: K */
    public void onBindViewHolder(com.martian.libmars.widget.recyclerview.d holder, int position) {
        holder.b0(position);
        b(holder, this.f10476c.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: L */
    public com.martian.libmars.widget.recyclerview.d onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        com.martian.libmars.widget.recyclerview.d b2 = com.martian.libmars.widget.recyclerview.d.b(this.f10474a, parent, this.f10475b);
        M(parent, b2);
        return b2;
    }

    protected void M(final ViewGroup parent, final com.martian.libmars.widget.recyclerview.d viewHolder) {
        viewHolder.B().setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.widget.recyclerview.e.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.H(viewHolder, parent, view);
            }
        });
        viewHolder.B().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.libmars.widget.recyclerview.e.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return c.this.J(viewHolder, parent, view);
            }
        });
    }

    public void N(com.martian.libmars.widget.recyclerview.f.c<T> onItemClickListener) {
        this.f10478e = onItemClickListener;
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void a(List<T> elements) {
        if (this.f10476c.size() > 0) {
            this.f10476c.clear();
        }
        this.f10476c.addAll(elements);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void add(T elem) {
        this.f10476c.add(elem);
        notifyDataSetChanged();
    }

    public abstract void b(com.martian.libmars.widget.recyclerview.d helper, T t);

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void clear() {
        if (this.f10476c.size() > 0) {
            this.f10476c.clear();
            notifyDataSetChanged();
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public boolean contains(T elem) {
        return this.f10476c.contains(elem);
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void g(int index) {
        this.f10476c.remove(index);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public T get(int position) {
        if (position < 0 || position >= this.f10476c.size()) {
            return null;
        }
        return this.f10476c.get(position);
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public List<T> getAll() {
        return this.f10476c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10476c.size();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public int getSize() {
        return this.f10476c.size();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void h(List<T> elements) {
        this.f10476c.removeAll(elements);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void i(int location, T elem) {
        this.f10476c.add(location, elem);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void k(int location, List<T> elements) {
        this.f10476c.addAll(location, elements);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void l(int index, T elem) {
        this.f10476c.set(index, elem);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void m(List<T> elements) {
        this.f10476c.addAll(elements);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void remove(T elem) {
        this.f10476c.remove(elem);
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.g.a
    public void replace(T oldElem, T newElem) {
        l(this.f10476c.indexOf(oldElem), newElem);
    }

    public c(Context context, int layoutId, List<T> mDatass) {
        this.f10476c = new ArrayList();
        this.f10474a = context;
        this.f10477d = LayoutInflater.from(context);
        this.f10475b = layoutId;
        this.f10476c = mDatass;
        this.f10479f = new PageBean();
    }
}
