package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class o3 extends BaseAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14602a;

    /* renamed from: b */
    final List<String> f14603b;

    /* renamed from: c */
    private int f14604c = 0;

    public static class a {

        /* renamed from: a */
        TextView f14605a;
    }

    public o3(com.martian.libmars.activity.j1 activity, List<String> tags) {
        this.f14602a = activity;
        this.f14603b = tags;
    }

    public String a() {
        return (String) getItem(this.f14604c);
    }

    public int b() {
        return this.f14604c;
    }

    public void c(int index) {
        this.f14604c = index;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f14603b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14603b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int position, View convertView, ViewGroup parent) {
        a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14602a).inflate(R.layout.book_category_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14605a = (TextView) convertView.findViewById(R.id.tv_category_name);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        aVar.f14605a.setText((String) getItem(position));
        if (position == this.f14604c) {
            aVar.f14605a.setTextColor(ContextCompat.getColor(this.f14602a, R.color.theme_default));
        } else {
            aVar.f14605a.setTextColor(MiConfigSingleton.V3().r0());
        }
        return convertView;
    }
}
