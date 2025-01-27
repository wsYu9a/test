package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.ClockInfo;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class o4 extends BaseAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14606a;

    /* renamed from: b */
    private final List<ClockInfo> f14607b;

    public static class a {

        /* renamed from: a */
        TextView f14608a;

        /* renamed from: b */
        ImageView f14609b;
    }

    public o4(com.martian.libmars.activity.j1 activity, int index) {
        this.f14606a = activity;
        ArrayList arrayList = new ArrayList();
        this.f14607b = arrayList;
        arrayList.add(new ClockInfo(0, "不限时", index == 0));
        arrayList.add(new ClockInfo(1, "15分钟", index == 1));
        arrayList.add(new ClockInfo(2, "30分钟", index == 2));
        arrayList.add(new ClockInfo(3, "60分钟", index == 3));
        arrayList.add(new ClockInfo(4, "90分钟", index == 4));
        arrayList.add(new ClockInfo(5, "120分钟", index == 5));
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public ClockInfo getItem(int position) {
        return this.f14607b.get(position);
    }

    public void b(int index) {
        for (ClockInfo clockInfo : this.f14607b) {
            clockInfo.setChecked(clockInfo.getIdx() == index);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14607b.size();
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
            convertView = LayoutInflater.from(this.f14606a).inflate(R.layout.tingshu_clock_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14608a = (TextView) convertView.findViewById(R.id.clock_name);
            aVar.f14609b = (ImageView) convertView.findViewById(R.id.clock_icon);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        ClockInfo item = getItem(position);
        aVar.f14608a.setText(item.getName());
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        if (item.isChecked()) {
            aVar.f14609b.setVisibility(0);
            aVar.f14609b.setColorFilter(r.getItemColorPrimary());
            aVar.f14608a.setTextColor(r.getItemColorPrimary());
        } else {
            aVar.f14609b.setVisibility(4);
            aVar.f14608a.setTextColor(r.getTextColorPrimary(this.f14606a));
        }
        return convertView;
    }
}
