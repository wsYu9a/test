package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.HistoryCoins;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MartianCoinsIncomeListAdapter extends BaseAdapter {

    /* renamed from: a */
    List<HistoryCoins> f13794a = new ArrayList();

    /* renamed from: b */
    private final Context f13795b;

    public static class a {

        /* renamed from: a */
        TextView f13796a;

        /* renamed from: b */
        TextView f13797b;

        /* renamed from: c */
        TextView f13798c;
    }

    public MartianCoinsIncomeListAdapter(Context context) {
        this.f13795b = context;
    }

    public void a(List<HistoryCoins> pages) {
        if (pages == null || this.f13794a == null) {
            return;
        }
        for (HistoryCoins historyCoins : pages) {
            if (historyCoins != null) {
                this.f13794a.add(historyCoins);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13794a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f13794a.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f13795b).inflate(R.layout.martian_income_list_item, (ViewGroup) null);
            aVar = new a();
            aVar.f13796a = (TextView) convertView.findViewById(R.id.martian_income_title);
            aVar.f13797b = (TextView) convertView.findViewById(R.id.martian_income_num);
            aVar.f13798c = (TextView) convertView.findViewById(R.id.martian_income_time);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        HistoryCoins historyCoins = (HistoryCoins) getItem(position);
        if (historyCoins == null) {
            return convertView;
        }
        if (TextUtils.isEmpty(historyCoins.getCtype())) {
            aVar.f13796a.setText("金币奖励");
        } else {
            aVar.f13796a.setText(historyCoins.getCtype());
        }
        if (historyCoins.getCoins() > 0) {
            aVar.f13797b.setTextColor(ContextCompat.getColor(this.f13795b, R.color.material_orange_600));
            aVar.f13797b.setText("+" + historyCoins.getCoins());
        } else {
            aVar.f13797b.setTextColor(ContextCompat.getColor(this.f13795b, R.color.martian_theme_alihb));
            aVar.f13797b.setText("" + historyCoins.getCoins());
        }
        aVar.f13798c.setText(com.martian.rpauth.d.i.d(historyCoins.getCreatedOn()));
        return convertView;
    }
}
