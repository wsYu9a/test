package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.lib.account.response.RechargeItem;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class m4 extends BaseAdapter {

    /* renamed from: a */
    private final a f14566a;

    /* renamed from: b */
    private int f14567b = 0;

    /* renamed from: c */
    List<RechargeItem> f14568c = new ArrayList();

    /* renamed from: d */
    private final com.martian.libmars.activity.j1 f14569d;

    public interface a {
        void a(int position, int money);
    }

    public static class b {

        /* renamed from: a */
        View f14570a;

        /* renamed from: b */
        TextView f14571b;

        /* renamed from: c */
        TextView f14572c;
    }

    public m4(com.martian.libmars.activity.j1 activity, a listener) {
        this.f14569d = activity;
        this.f14566a = listener;
    }

    /* renamed from: c */
    public /* synthetic */ void d(final int position, final RechargeItem rechargeItem, View v) {
        a aVar = this.f14566a;
        if (aVar != null) {
            aVar.a(position, rechargeItem.getMoney());
        }
    }

    public void a(RechargeItem[] pages) {
        this.f14568c.addAll(Arrays.asList(pages));
    }

    public RechargeItem b(int position) {
        return this.f14568c.get(position);
    }

    public void e(List<RechargeItem> rechargeList) {
        this.f14568c = rechargeList;
    }

    public void f(int position) {
        this.f14567b = position;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14568c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14568c.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        b bVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14569d).inflate(R.layout.txs_recharge_coin_item, (ViewGroup) null);
            bVar = new b();
            bVar.f14570a = convertView.findViewById(R.id.iv_recharge_item);
            bVar.f14571b = (TextView) convertView.findViewById(R.id.iv_txs_money);
            bVar.f14572c = (TextView) convertView.findViewById(R.id.iv_txs_coins);
            convertView.setTag(bVar);
        } else {
            bVar = (b) convertView.getTag();
        }
        if (this.f14567b == position) {
            bVar.f14570a.setBackgroundResource(R.drawable.border_button_theme_default_middle);
            bVar.f14571b.setTextColor(ContextCompat.getColor(this.f14569d, R.color.white));
            bVar.f14572c.setTextColor(ContextCompat.getColor(this.f14569d, R.color.white));
        } else {
            if (com.martian.libmars.d.h.F().I0()) {
                bVar.f14570a.setBackgroundResource(R.drawable.border_background_withdraw_night);
            } else {
                bVar.f14570a.setBackgroundResource(R.drawable.border_background_withdraw_day);
            }
            bVar.f14571b.setTextColor(ContextCompat.getColor(this.f14569d, R.color.theme_default));
            bVar.f14572c.setTextColor(com.martian.libmars.d.h.F().r0());
        }
        final RechargeItem rechargeItem = (RechargeItem) getItem(position);
        bVar.f14571b.setText("¥" + com.martian.rpauth.d.i.n(Integer.valueOf(rechargeItem.getMoney())));
        bVar.f14572c.setText(rechargeItem.getTxsCoins() + this.f14569d.getString(R.string.txs_coin));
        bVar.f14570a.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m4.this.d(position, rechargeItem, view);
            }
        });
        return convertView;
    }
}
