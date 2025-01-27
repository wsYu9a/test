package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class n extends BaseAdapter {

    /* renamed from: a */
    private final j1 f14271a;

    /* renamed from: b */
    private final List<String> f14272b;

    /* renamed from: c */
    private String f14273c;

    public static class a {

        /* renamed from: a */
        TextView f14274a;

        /* renamed from: b */
        ImageView f14275b;
    }

    public n(j1 activity, String selectMode) {
        this.f14271a = activity;
        ArrayList arrayList = new ArrayList();
        this.f14272b = arrayList;
        arrayList.add(activity.getString(R.string.overlapped_slider));
        arrayList.add(activity.getString(R.string.sim_slider));
        arrayList.add(activity.getString(R.string.page_slider));
        arrayList.add(activity.getString(R.string.scroll_slider));
        arrayList.add(activity.getString(R.string.static_slider));
        this.f14273c = selectMode;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int position) {
        return this.f14272b.get(position);
    }

    public void b(String mode) {
        this.f14273c = mode;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14272b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14271a).inflate(R.layout.tingshu_clock_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14274a = (TextView) convertView.findViewById(R.id.clock_name);
            aVar.f14275b = (ImageView) convertView.findViewById(R.id.clock_icon);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        String item = getItem(position);
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        aVar.f14274a.setText(item);
        if (item.equalsIgnoreCase(this.f14273c)) {
            aVar.f14275b.setVisibility(0);
            aVar.f14275b.setColorFilter(r.getItemColorPrimary());
            aVar.f14274a.setTextColor(r.getItemColorPrimary());
        } else {
            aVar.f14275b.setVisibility(4);
            aVar.f14274a.setTextColor(r.getTextColorPrimary(this.f14271a));
        }
        return convertView;
    }
}
