package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.mibook.lib.model.data.BookStoreCategories;
import com.martian.mibook.ui.o.l3;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class m3 extends l3 {

    /* renamed from: d */
    private a f14565d;

    public interface a {
        void a(int position, String category);
    }

    public m3(Context context, BookStoreCategories bookStoreCategories) {
        super(context, bookStoreCategories, false);
    }

    /* renamed from: g */
    public /* synthetic */ void h(final int position, final String categoryName, View v) {
        a aVar = this.f14565d;
        if (aVar != null) {
            aVar.a(position, categoryName);
        }
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        l3.a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14546a).inflate(R.layout.dialog_store_item, (ViewGroup) null);
            aVar = new l3.a();
            aVar.f14551c = (LinearLayout) convertView.findViewById(R.id.tag_view);
            aVar.f14549a = (TextView) convertView.findViewById(R.id.dialog_item_title);
            TextView textView = (TextView) convertView.findViewById(R.id.dialog_item_shift);
            aVar.f14550b = textView;
            textView.setVisibility(0);
            convertView.setTag(aVar);
        } else {
            aVar = (l3.a) convertView.getTag();
        }
        final String str = (String) getItem(position);
        if (BookStoreCategories.SECRETE_CATEGORY.equalsIgnoreCase(str)) {
            aVar.f14549a.setText(str);
        } else {
            aVar.f14549a.setText(str + "(" + this.f14547b.getCategoryBookSizeWithUncategoried(str) + "本)");
        }
        aVar.f14550b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m3.this.h(position, str, view);
            }
        });
        return convertView;
    }

    public void i() {
        a();
        e();
        f();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return false;
    }

    public void j(a itemClickListener) {
        this.f14565d = itemClickListener;
    }
}
