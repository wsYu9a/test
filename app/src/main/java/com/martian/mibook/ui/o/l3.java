package com.martian.mibook.ui.o;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.mibook.lib.model.data.BookStoreCategories;

/* loaded from: classes4.dex */
public abstract class l3 extends BaseAdapter {

    /* renamed from: a */
    protected final Context f14546a;

    /* renamed from: b */
    protected final BookStoreCategories f14547b;

    /* renamed from: c */
    protected final boolean f14548c;

    public static class a {

        /* renamed from: a */
        TextView f14549a;

        /* renamed from: b */
        TextView f14550b;

        /* renamed from: c */
        LinearLayout f14551c;

        /* renamed from: d */
        ImageView f14552d;
    }

    public l3(Context context, BookStoreCategories bookStoreCategories, boolean containsAllBookCategory) {
        this.f14546a = context;
        this.f14547b = bookStoreCategories;
        this.f14548c = containsAllBookCategory;
    }

    public void a() {
        this.f14547b.addSecretCategory();
    }

    public void b() {
        this.f14547b.addUnCategory();
    }

    public BookStoreCategories c() {
        return this.f14547b;
    }

    public void d() {
        this.f14547b.removeSecretCategory();
    }

    public void e() {
        this.f14547b.removeUnCategory();
    }

    public void f() {
        this.f14547b.sortCategories();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14548c ? this.f14547b.getAllCategorySize() : this.f14547b.getCategorySizeWithUncategoried();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14548c ? this.f14547b.getCategoryItem(position) : this.f14547b.getCategoryItemWithUncategoried(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return (this.f14548c ? this.f14547b.getCategoryItem(position) : this.f14547b.getCategoryItemWithUncategoried(position)).hashCode();
    }
}
