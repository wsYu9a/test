package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.mibook.activity.book.YWCategoriesActivity;
import com.martian.mibook.activity.book.YWTagsActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class x3 extends BaseAdapter {

    /* renamed from: a */
    final List<TYCategoryTagItem> f14765a;

    /* renamed from: b */
    private final com.martian.libmars.activity.j1 f14766b;

    /* renamed from: c */
    private final int f14767c;

    /* renamed from: d */
    private final int f14768d;

    public static class a {

        /* renamed from: a */
        ImageView f14769a;

        /* renamed from: b */
        ImageView f14770b;

        /* renamed from: c */
        TextView f14771c;

        /* renamed from: d */
        LinearLayout f14772d;
    }

    public x3(com.martian.libmars.activity.j1 activity, List<TYCategoryTagItem> tyCategoryTagItemList, int freeType, int coverType) {
        this.f14766b = activity;
        this.f14765a = tyCategoryTagItemList;
        this.f14767c = freeType;
        this.f14768d = coverType;
    }

    /* renamed from: b */
    public /* synthetic */ void c(final TYCategoryTagItem tyCategoryTagItem, View v) {
        if (tyCategoryTagItem.getCategoryId() > 0) {
            YWCategoriesActivity.r2(this.f14766b, new YWCategory().setCategoryName(tyCategoryTagItem.getName()).setCategoryId(Integer.valueOf(tyCategoryTagItem.getCategoryId())), this.f14767c, -1, tyCategoryTagItem.getFrom() == null ? com.martian.mibook.f.f4.g0.s : tyCategoryTagItem.getFrom().intValue());
        } else {
            YWTagsActivity.r2(this.f14766b, tyCategoryTagItem.getName(), this.f14767c, tyCategoryTagItem.getFrom() == null ? com.martian.mibook.f.f4.j0.t : tyCategoryTagItem.getFrom().intValue());
        }
    }

    public TYCategoryTagItem a(int position) {
        return this.f14765a.get(position);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14765a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14765a.get(position);
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
            convertView = LayoutInflater.from(this.f14766b).inflate(R.layout.page_item_classification_yw, (ViewGroup) null);
            aVar = new a();
            aVar.f14769a = (ImageView) convertView.findViewById(R.id.tv_page_cover);
            aVar.f14770b = (ImageView) convertView.findViewById(R.id.tv_page_icon);
            aVar.f14771c = (TextView) convertView.findViewById(R.id.tv_page_name);
            aVar.f14772d = (LinearLayout) convertView.findViewById(R.id.category_root_view);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        final TYCategoryTagItem tYCategoryTagItem = (TYCategoryTagItem) getItem(position);
        aVar.f14771c.setText(tYCategoryTagItem.getName());
        if (this.f14768d == 3 || com.martian.libsupport.k.p(tYCategoryTagItem.getCoverUrl())) {
            aVar.f14769a.setVisibility(8);
            aVar.f14770b.setVisibility(8);
            aVar.f14771c.setGravity(17);
            aVar.f14771c.setTextSize(this.f14768d == 3 ? 14.0f : 16.0f);
        } else {
            aVar.f14771c.setGravity(5);
            aVar.f14771c.setTextSize(16.0f);
            if (this.f14768d == 1) {
                aVar.f14769a.setVisibility(0);
                aVar.f14770b.setVisibility(8);
                com.martian.libmars.utils.n0.p(this.f14766b, tYCategoryTagItem.getCoverUrl(), aVar.f14769a, MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
            } else {
                aVar.f14769a.setVisibility(8);
                aVar.f14770b.setVisibility(0);
                com.martian.libmars.utils.n0.k(this.f14766b, tYCategoryTagItem.getCoverUrl(), aVar.f14770b);
            }
        }
        aVar.f14772d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x3.this.c(tYCategoryTagItem, view);
            }
        });
        return convertView;
    }
}
