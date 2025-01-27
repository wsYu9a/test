package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libsupport.j;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class h3 extends BaseAdapter {

    /* renamed from: a */
    private final Context f14401a;

    /* renamed from: b */
    private final List<j.d> f14402b;

    /* renamed from: c */
    private int f14403c = 0;

    public h3(Context context, List<j.d> tags) {
        this.f14401a = context;
        this.f14402b = tags;
    }

    public void a(j.d groupCount) {
        this.f14402b.add(groupCount);
    }

    public j.d b(String tagName) {
        for (j.d dVar : this.f14402b) {
            if (dVar.f10608a.equals(tagName)) {
                return dVar;
            }
        }
        return null;
    }

    public j.d c(int position) {
        return this.f14402b.get(position);
    }

    public void d(int index) {
        this.f14403c = index;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<j.d> list = this.f14402b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14402b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return this.f14402b.get(position).hashCode();
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14401a).inflate(R.layout.archive_tag_item, (ViewGroup) null);
        }
        j.d dVar = (j.d) getItem(position);
        try {
            ((TextView) convertView).setTextSize(14.0f);
            ((TextView) convertView).setText(dVar.f10608a + " (" + dVar.f10609b + "本)");
            if (position == this.f14403c) {
                ((TextView) convertView).setTextColor(ContextCompat.getColor(this.f14401a, MiConfigSingleton.V3().t0()));
            } else {
                ((TextView) convertView).setTextColor(ContextCompat.getColor(this.f14401a, R.color.heavy_grey));
            }
        } catch (Exception unused) {
        }
        return convertView;
    }
}
