package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookStoreCategories;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.ttbookhd.R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class n3 extends l3 {

    /* renamed from: d */
    private final Set<String> f14581d;

    /* renamed from: e */
    private int f14582e;

    public n3(Context context, BookStoreCategories bookStoreCategories) {
        super(context, bookStoreCategories, true);
        this.f14581d = new HashSet();
        this.f14582e = 0;
    }

    private boolean i(String dirName) {
        return this.f14581d.contains(dirName);
    }

    public String g() {
        return (String) getItem(this.f14582e);
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(int position, View convertView, ViewGroup parent) {
        com.martian.mibook.e.q0 q0Var;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14546a).inflate(R.layout.book_category_item, (ViewGroup) null);
            q0Var = com.martian.mibook.e.q0.a(convertView);
            convertView.setTag(q0Var);
        } else {
            q0Var = (com.martian.mibook.e.q0) convertView.getTag();
        }
        String str = (String) getItem(position);
        if (position == this.f14582e) {
            q0Var.f12551c.setTextColor(ContextCompat.getColor(this.f14546a, MiConfigSingleton.V3().t0()));
        } else {
            q0Var.f12551c.setTextColor(MiConfigSingleton.V3().q0());
        }
        q0Var.f12550b.setVisibility(8);
        if (str.equals(BookStoreCategories.SECRETE_CATEGORY)) {
            q0Var.f12551c.setText(str);
        } else {
            int allCategoryBookSize = this.f14547b.getAllCategoryBookSize(position, str);
            if (position == 0) {
                allCategoryBookSize -= this.f14547b.getAllCategoryBookSize(2, BookStoreCategories.SECRETE_CATEGORY);
            }
            q0Var.f12551c.setText(str + " (" + allCategoryBookSize + "本)");
            if (i(str)) {
                q0Var.f12550b.setVisibility(0);
            } else {
                q0Var.f12550b.setVisibility(8);
            }
        }
        return convertView;
    }

    public int h() {
        return this.f14582e;
    }

    public void j(List<BookWrapper> bookWrappers) {
        d();
        b();
        l(bookWrappers);
        f();
        notifyDataSetChanged();
    }

    public void k(int index) {
        this.f14582e = index;
        notifyDataSetChanged();
    }

    public void l(List<BookWrapper> bookWrappers) {
        if (bookWrappers == null || bookWrappers.isEmpty()) {
            return;
        }
        for (BookWrapper bookWrapper : bookWrappers) {
            MiBookStoreItem miBookStoreItem = bookWrapper.item;
            if (miBookStoreItem != null && miBookStoreItem.hasUpdate()) {
                String dirName = bookWrapper.item.getDirName();
                if (com.martian.libsupport.k.p(dirName)) {
                    dirName = BookStoreCategories.BOOK_UNCATEGORIED;
                }
                if (!this.f14581d.contains(dirName)) {
                    this.f14581d.add(dirName);
                }
            }
        }
    }
}
