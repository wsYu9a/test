package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class f3 extends BaseAdapter {

    /* renamed from: a */
    private final a f14357a;

    /* renamed from: b */
    List<TYActivity> f14358b = new ArrayList();

    /* renamed from: c */
    private final com.martian.libmars.activity.j1 f14359c;

    public interface a {
        void a(TYActivity tyActivity);
    }

    public static class b {

        /* renamed from: a */
        ImageView f14360a;

        /* renamed from: b */
        TextView f14361b;

        /* renamed from: c */
        TextView f14362c;
    }

    public f3(com.martian.libmars.activity.j1 activity, a listener) {
        this.f14359c = activity;
        this.f14357a = listener;
    }

    /* renamed from: b */
    public /* synthetic */ void c(final TYActivity tyActivity, View v) {
        a aVar = this.f14357a;
        if (aVar != null) {
            aVar.a(tyActivity);
        }
    }

    public TYActivity a(int position) {
        return this.f14358b.get(position);
    }

    public void d(List<TYActivity> activities) {
        this.f14358b = activities;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14358b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14358b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        b bVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14359c).inflate(R.layout.bonus_activity_item, (ViewGroup) null);
            bVar = new b();
            bVar.f14360a = (ImageView) convertView.findViewById(R.id.activity_icon);
            bVar.f14361b = (TextView) convertView.findViewById(R.id.activity_title);
            bVar.f14362c = (TextView) convertView.findViewById(R.id.activity_desc);
            convertView.setTag(bVar);
        } else {
            bVar = (b) convertView.getTag();
        }
        final TYActivity tYActivity = (TYActivity) getItem(position);
        bVar.f14361b.setText(tYActivity.getTitle());
        bVar.f14362c.setText(tYActivity.getDesc());
        com.martian.libmars.utils.n0.k(this.f14359c, tYActivity.getIcon(), bVar.f14360a);
        convertView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f3.this.c(tYActivity, view);
            }
        });
        return convertView;
    }
}
