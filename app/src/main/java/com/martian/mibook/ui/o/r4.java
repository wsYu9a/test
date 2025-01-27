package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class r4 extends BaseAdapter {

    /* renamed from: a */
    final List<String> f14675a;

    /* renamed from: b */
    private int f14676b = 0;

    /* renamed from: c */
    private final Context f14677c;

    public static class a {

        /* renamed from: a */
        TextView f14678a;

        /* renamed from: b */
        View f14679b;
    }

    public r4(Context context, List<String> titles) {
        this.f14677c = context;
        this.f14675a = titles;
    }

    public boolean a() {
        return this.f14676b == 0;
    }

    public void b(int position) {
        this.f14676b = position;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f14675a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        List<String> list = this.f14675a;
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int position, View convertView, ViewGroup parent) {
        a aVar = convertView != null ? (a) convertView.getTag() : null;
        if (convertView == null || aVar == null) {
            convertView = LayoutInflater.from(this.f14677c).inflate(R.layout.withdraw_title_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14678a = (TextView) convertView.findViewById(R.id.withdraw_title);
            aVar.f14679b = convertView.findViewById(R.id.withdraw_line);
            convertView.setTag(aVar);
        }
        aVar.f14678a.setText((String) getItem(position));
        if (position == this.f14676b) {
            aVar.f14678a.setTextColor(ContextCompat.getColor(this.f14677c, R.color.bonus_red));
            aVar.f14679b.setVisibility(0);
        } else {
            aVar.f14678a.setTextColor(ContextCompat.getColor(this.f14677c, R.color.heavy_grey));
            aVar.f14679b.setVisibility(4);
        }
        return convertView;
    }
}
