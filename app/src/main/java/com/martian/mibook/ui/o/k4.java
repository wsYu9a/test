package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.lib.yuewen.response.TYSearchRank;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class k4 extends BaseAdapter {

    /* renamed from: a */
    final List<TYSearchRank> f14529a;

    /* renamed from: b */
    private final Context f14530b;

    public static class a {

        /* renamed from: a */
        TextView f14531a;

        /* renamed from: b */
        TextView f14532b;
    }

    public k4(Context context, List<TYSearchRank> tySearchRanks) {
        this.f14530b = context;
        this.f14529a = tySearchRanks;
    }

    public void a(List<TYSearchRank> ranks) {
        if (ranks != null) {
            this.f14529a.addAll(ranks);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TYSearchRank> list = this.f14529a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        List<TYSearchRank> list = this.f14529a;
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
            convertView = LayoutInflater.from(this.f14530b).inflate(R.layout.search_rank_list_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14531a = (TextView) convertView.findViewById(R.id.search_index);
            aVar.f14532b = (TextView) convertView.findViewById(R.id.search_keyword);
            convertView.setTag(aVar);
        }
        TYSearchRank tYSearchRank = (TYSearchRank) getItem(position);
        if (tYSearchRank == null) {
            return null;
        }
        if (position == 0) {
            aVar.f14531a.setBackgroundColor(ContextCompat.getColor(this.f14530b, R.color.search_rank_1));
        } else if (position == 1) {
            aVar.f14531a.setBackgroundColor(ContextCompat.getColor(this.f14530b, R.color.search_rank_2));
        } else if (position == 2) {
            aVar.f14531a.setBackgroundColor(ContextCompat.getColor(this.f14530b, R.color.search_rank_3));
        } else {
            aVar.f14531a.setBackgroundColor(ContextCompat.getColor(this.f14530b, R.color.search_rank_4));
        }
        aVar.f14531a.setText(String.valueOf(position + 1));
        aVar.f14532b.setText(tYSearchRank.getKeyword());
        return convertView;
    }
}
