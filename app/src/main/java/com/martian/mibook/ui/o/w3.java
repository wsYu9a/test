package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.activity.book.YWCategoriesActivity;
import com.martian.mibook.activity.book.YWTagsActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class w3 extends BaseAdapter {

    /* renamed from: a */
    final List<TYCategoryTagItem> f14749a;

    /* renamed from: b */
    private final com.martian.libmars.activity.j1 f14750b;

    /* renamed from: c */
    private final int f14751c;

    public static class a {

        /* renamed from: a */
        ImageView f14752a;

        /* renamed from: b */
        TextView f14753b;

        /* renamed from: c */
        TextView f14754c;

        /* renamed from: d */
        LinearLayout f14755d;

        /* renamed from: e */
        LinearLayout f14756e;
    }

    public w3(com.martian.libmars.activity.j1 activity, List<TYCategoryTagItem> tyCategoryTagItemList, int freeType) {
        this.f14750b = activity;
        this.f14749a = tyCategoryTagItemList;
        this.f14751c = freeType;
    }

    /* renamed from: b */
    public /* synthetic */ void c(final TYCategoryTagItem tyCategoryTagItem, View v) {
        if (tyCategoryTagItem.getCategoryId() > 0) {
            YWCategoriesActivity.r2(this.f14750b, new YWCategory().setCategoryName(tyCategoryTagItem.getName()).setCategoryId(Integer.valueOf(tyCategoryTagItem.getCategoryId())), this.f14751c, -1, tyCategoryTagItem.getFrom() == null ? com.martian.mibook.f.f4.g0.s : tyCategoryTagItem.getFrom().intValue());
        } else {
            YWTagsActivity.r2(this.f14750b, tyCategoryTagItem.getName(), this.f14751c, tyCategoryTagItem.getFrom() == null ? com.martian.mibook.f.f4.j0.t : tyCategoryTagItem.getFrom().intValue());
        }
    }

    public TYCategoryTagItem a(int position) {
        return this.f14749a.get(position);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14749a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14749a.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14750b).inflate(R.layout.page_item_classification_hot, (ViewGroup) null);
            aVar = new a();
            aVar.f14752a = (ImageView) convertView.findViewById(R.id.tv_page_cover);
            aVar.f14753b = (TextView) convertView.findViewById(R.id.tv_page_name);
            aVar.f14754c = (TextView) convertView.findViewById(R.id.tv_page_desc);
            aVar.f14755d = (LinearLayout) convertView.findViewById(R.id.tv_page_desc_view);
            aVar.f14756e = (LinearLayout) convertView.findViewById(R.id.category_hot_view);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        if (position % 2 == 0) {
            aVar.f14753b.setTextColor(ContextCompat.getColor(this.f14750b, R.color.theme_default));
            aVar.f14756e.setBackgroundResource(R.drawable.bg_category_hot_female);
            aVar.f14755d.setBackgroundResource(R.drawable.border_button_round_default);
        } else {
            aVar.f14753b.setTextColor(ContextCompat.getColor(this.f14750b, R.color.theme_default_blue));
            aVar.f14756e.setBackgroundResource(R.drawable.bg_category_hot_male);
            aVar.f14755d.setBackgroundResource(R.drawable.border_button_round_default_blue);
        }
        final TYCategoryTagItem tYCategoryTagItem = (TYCategoryTagItem) getItem(position);
        aVar.f14753b.setText(tYCategoryTagItem.getName());
        if (com.martian.libsupport.k.p(tYCategoryTagItem.getDesc())) {
            aVar.f14755d.setVisibility(8);
        } else {
            aVar.f14755d.setVisibility(0);
            aVar.f14754c.setText(tYCategoryTagItem.getDesc());
        }
        com.martian.libmars.utils.n0.p(this.f14750b, tYCategoryTagItem.getCoverUrl(), aVar.f14752a, MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
        convertView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w3.this.c(tYCategoryTagItem, view);
            }
        });
        return convertView;
    }
}
