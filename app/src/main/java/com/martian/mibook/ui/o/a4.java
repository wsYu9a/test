package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.martian.mibook.e.z6;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class a4 extends BaseAdapter {

    /* renamed from: a */
    private final Context f14287a;

    /* renamed from: b */
    private List<TYBookItem> f14288b;

    /* renamed from: c */
    private String f14289c;

    public a4(Context context, List<TYBookItem> books, String content) {
        this.f14287a = context;
        this.f14288b = books;
        this.f14289c = content;
    }

    private SpannableString b(String name) {
        return com.martian.libsupport.k.l(this.f14287a, name, this.f14289c, R.color.theme_default);
    }

    public String a() {
        return this.f14289c;
    }

    public void c(List<TYBookItem> books, String content) {
        this.f14288b = books;
        this.f14289c = content;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TYBookItem> list = this.f14288b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14288b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int position, View convertView, ViewGroup parent) {
        z6 z6Var;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14287a).inflate(R.layout.search_recommend_item, (ViewGroup) null);
            z6Var = z6.a(convertView);
            convertView.setTag(z6Var);
        } else {
            z6Var = (z6) convertView.getTag();
        }
        Book book = (Book) getItem(position);
        if (!com.martian.libsupport.k.p(book.getBookName()) && book.getBookName().contains(this.f14289c)) {
            z6Var.f13032b.setImageResource(R.drawable.page_mode);
            z6Var.f13033c.setText(b(book.getBookName()));
        } else if (com.martian.libsupport.k.p(book.getAuthor()) || !book.getAuthor().contains(this.f14289c)) {
            z6Var.f13032b.setImageResource(R.drawable.page_mode);
            z6Var.f13033c.setText(b(book.getBookName()));
        } else {
            z6Var.f13032b.setImageResource(R.drawable.search_author_icon);
            z6Var.f13033c.setText(b(book.getAuthor()));
        }
        return convertView;
    }
}
