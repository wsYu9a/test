package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class v3 extends BaseAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14737a;

    /* renamed from: b */
    private final String[] f14738b;

    public static class a {

        /* renamed from: a */
        TextView f14739a;
    }

    public v3(com.martian.libmars.activity.j1 activity, String[] menuStrings) {
        this.f14737a = activity;
        this.f14738b = menuStrings;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14738b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14738b[position];
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int position, View convertView, ViewGroup parent) {
        a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14737a).inflate(R.layout.dialog_store_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14739a = (TextView) convertView.findViewById(R.id.dialog_item_title);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        aVar.f14739a.setText(this.f14738b[position]);
        return convertView;
    }
}
