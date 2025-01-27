package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.martian.libsupport.j;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class i3 extends BaseAdapter {

    /* renamed from: a */
    private final Context f14417a;

    /* renamed from: b */
    private final List<j.d> f14418b;

    /* renamed from: c */
    private a f14419c;

    public interface a {
        void a(int position);
    }

    public static class b {

        /* renamed from: a */
        TextView f14420a;

        /* renamed from: b */
        TextView f14421b;
    }

    public i3(Context context, List<j.d> tags) {
        this.f14417a = context;
        this.f14418b = tags;
    }

    /* renamed from: d */
    public /* synthetic */ void e(final int position, View v) {
        a aVar = this.f14419c;
        if (aVar != null) {
            aVar.a(position);
        }
    }

    public void a(j.d groupCount) {
        this.f14418b.add(groupCount);
    }

    public j.d b(String tagName) {
        for (j.d dVar : this.f14418b) {
            if (dVar.f10608a.equals(tagName)) {
                return dVar;
            }
        }
        return null;
    }

    public j.d c(int position) {
        return this.f14418b.get(position);
    }

    public void f(a itemClickListener) {
        this.f14419c = itemClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<j.d> list = this.f14418b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14418b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return this.f14418b.get(position).hashCode();
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        b bVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14417a).inflate(R.layout.dialog_store_item, (ViewGroup) null);
            bVar = new b();
            bVar.f14420a = (TextView) convertView.findViewById(R.id.dialog_item_title);
            TextView textView = (TextView) convertView.findViewById(R.id.dialog_item_shift);
            bVar.f14421b = textView;
            textView.setVisibility(0);
            convertView.setTag(bVar);
        } else {
            bVar = (b) convertView.getTag();
        }
        j.d dVar = (j.d) getItem(position);
        bVar.f14420a.setText(dVar.f10608a + "(" + dVar.f10609b + "本)");
        bVar.f14421b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i3.this.e(position, view);
            }
        });
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return false;
    }
}
