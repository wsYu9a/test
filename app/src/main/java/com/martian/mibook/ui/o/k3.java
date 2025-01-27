package com.martian.mibook.ui.o;

import android.widget.GridView;
import android.widget.ListAdapter;
import com.martian.mibook.activity.book.YWCategoriesActivity;
import com.martian.mibook.activity.book.YWTagsActivity;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.ui.TagItemLayout;
import com.martian.ttbookhd.R;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class k3 extends com.martian.libmars.widget.recyclerview.e.c<TYCategoryTagGroup> {

    /* renamed from: g */
    public static final int f14525g = 0;

    /* renamed from: h */
    public static final int f14526h = 1;

    /* renamed from: i */
    public static final int f14527i = -1;

    /* renamed from: j */
    public static final int f14528j = 3;
    private final com.martian.libmars.activity.j1 k;
    private int l;
    private TYCategoryTagGroup m;

    public k3(com.martian.libmars.activity.j1 activity, final List<TYCategoryTagGroup> datas) {
        super(activity, R.layout.page_item_category_tag, datas);
        this.l = 1;
        this.k = activity;
        Iterator<TYCategoryTagGroup> it = datas.iterator();
        while (it.hasNext()) {
            TYCategoryTagGroup next = it.next();
            if (next == null || next.getItems() == null || next.getItems().isEmpty()) {
                it.remove();
            }
        }
        if (datas.isEmpty()) {
            return;
        }
        this.m = datas.get(datas.size() - 1);
    }

    private TYCategoryTagGroup P() {
        if (getItemCount() > 0) {
            return get(getItemCount() - 1);
        }
        return null;
    }

    /* renamed from: Q */
    public /* synthetic */ void R(TYCategoryTagItem tagItem, int position) {
        if (tagItem.getCategoryId() > 0) {
            YWCategoriesActivity.r2(this.k, new YWCategory().setCategoryName(tagItem.getName()).setCategoryId(Integer.valueOf(tagItem.getCategoryId())), this.l, -1, tagItem.getFrom() == null ? com.martian.mibook.f.f4.g0.s : tagItem.getFrom().intValue());
        } else {
            YWTagsActivity.r2(this.k, tagItem.getName(), this.l, tagItem.getFrom() == null ? com.martian.mibook.f.f4.j0.t : tagItem.getFrom().intValue());
        }
    }

    private void S(final com.martian.libmars.widget.recyclerview.d holder, final TYCategoryTagGroup tyCategoryTagGroup) {
        w3 w3Var = new w3(this.k, tyCategoryTagGroup.getItems(), this.l);
        GridView gridView = (GridView) holder.getView(R.id.category_item);
        gridView.setVisibility(0);
        gridView.setNumColumns(2);
        gridView.setHorizontalSpacing(com.martian.libmars.d.h.b(8.0f));
        gridView.setVerticalSpacing(com.martian.libmars.d.h.b(8.0f));
        gridView.setAdapter((ListAdapter) w3Var);
        ((TagItemLayout) holder.getView(R.id.hot_tags)).setVisibility(8);
    }

    private void U(final com.martian.libmars.widget.recyclerview.d holder, final TYCategoryTagGroup tyCategoryTagGroup) {
        TagItemLayout tagItemLayout = (TagItemLayout) holder.getView(R.id.hot_tags);
        ((GridView) holder.getView(R.id.category_item)).setVisibility(8);
        tagItemLayout.setVisibility(0);
        tagItemLayout.setData(tyCategoryTagGroup.getItems());
        tagItemLayout.setOnItemTitleClickListener(new TagItemLayout.a() { // from class: com.martian.mibook.ui.o.h
            @Override // com.martian.mibook.ui.TagItemLayout.a
            public final void a(TYCategoryTagItem tYCategoryTagItem, int i2) {
                k3.this.R(tYCategoryTagItem, i2);
            }
        });
    }

    private void V(final com.martian.libmars.widget.recyclerview.d holder, final TYCategoryTagGroup tyCategoryTagGroup) {
        x3 x3Var = new x3(this.k, tyCategoryTagGroup.getItems(), this.l, tyCategoryTagGroup.getLayoutType());
        GridView gridView = (GridView) holder.getView(R.id.category_item);
        gridView.setVisibility(0);
        gridView.setNumColumns(tyCategoryTagGroup.getLayoutType() != 3 ? 2 : 3);
        gridView.setHorizontalSpacing(com.martian.libmars.d.h.b(8.0f));
        gridView.setVerticalSpacing(com.martian.libmars.d.h.b(8.0f));
        gridView.setAdapter((ListAdapter) x3Var);
        ((TagItemLayout) holder.getView(R.id.hot_tags)).setVisibility(8);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, TYCategoryTagGroup tyCategoryTagGroup) {
        if (tyCategoryTagGroup == null || tyCategoryTagGroup.getItems() == null || tyCategoryTagGroup.getItems().isEmpty()) {
            helper.a0(R.id.grid_item_root, false);
            return;
        }
        if (com.martian.libsupport.k.p(tyCategoryTagGroup.getName())) {
            helper.a0(R.id.category_title, false);
        } else {
            helper.a0(R.id.category_title, true);
            helper.W(R.id.category_title, tyCategoryTagGroup.getName());
        }
        GridView gridView = (GridView) helper.getView(R.id.category_item);
        TYCategoryTagGroup tYCategoryTagGroup = this.m;
        if (tYCategoryTagGroup == null || !tYCategoryTagGroup.getName().equalsIgnoreCase(tyCategoryTagGroup.getName())) {
            gridView.setPadding(0, 0, 0, 0);
        } else {
            gridView.setPadding(0, 0, 0, com.martian.libmars.d.h.b(62.0f));
        }
        if (tyCategoryTagGroup.getLayoutType() == -1) {
            U(helper, tyCategoryTagGroup);
        } else if (tyCategoryTagGroup.getLayoutType() == 0) {
            S(helper, tyCategoryTagGroup);
        } else {
            V(helper, tyCategoryTagGroup);
        }
    }

    public void T(int type) {
        this.l = type;
    }
}
