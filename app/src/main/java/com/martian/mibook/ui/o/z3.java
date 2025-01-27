package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.content.ContextCompat;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.x6;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.ttbookhd.R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class z3 extends BaseAdapter {

    /* renamed from: a */
    private final List<TYBookItem> f14800a;

    /* renamed from: b */
    private final Context f14801b;

    /* renamed from: c */
    private final Set<String> f14802c = new HashSet();

    public z3(Context context, List<TYBookItem> bookItems) {
        this.f14801b = context;
        this.f14800a = bookItems;
    }

    public TYBookItem a(int position) {
        return this.f14800a.get(position);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TYBookItem> list = this.f14800a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14800a.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(int position, View convertView, ViewGroup parent) {
        x6 x6Var;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14801b).inflate(R.layout.search_rank_item, (ViewGroup) null);
            x6Var = x6.a(convertView);
            convertView.setTag(x6Var);
        } else {
            x6Var = (x6) convertView.getTag();
        }
        if (position == 0) {
            x6Var.f12948d.setTextColor(ContextCompat.getColor(this.f14801b, R.color.search_rank_1));
        } else if (position == 1) {
            x6Var.f12948d.setTextColor(ContextCompat.getColor(this.f14801b, R.color.search_rank_2));
        } else if (position == 2) {
            x6Var.f12948d.setTextColor(ContextCompat.getColor(this.f14801b, R.color.search_rank_3));
        } else {
            x6Var.f12948d.setTextColor(com.martian.libmars.d.h.F().r0());
        }
        x6Var.f12948d.setText((position + 1) + "");
        TYBookItem tYBookItem = (TYBookItem) getItem(position);
        x6Var.f12949e.setText(tYBookItem.getBookName());
        x6Var.f12949e.setBackgroundResource(R.color.transparent);
        x6Var.f12947c.setText(tYBookItem.getCategoryInfo());
        MiBookManager.d2(this.f14801b, tYBookItem, x6Var.f12946b);
        if (!this.f14802c.contains(tYBookItem.getSourceId())) {
            this.f14802c.add(tYBookItem.getSourceId());
            MiConfigSingleton.V3().l3().I1(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
        return convertView;
    }
}
