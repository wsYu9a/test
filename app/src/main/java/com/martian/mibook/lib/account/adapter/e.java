package com.martian.mibook.lib.account.adapter;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MiHistoryBookCoins;
import java.util.List;

/* loaded from: classes3.dex */
public class e extends com.martian.libmars.widget.recyclerview.e.c<MiHistoryBookCoins> {
    public e(j1 activity, final List<MiHistoryBookCoins> datas) {
        super(activity, R.layout.history_coins_item, datas);
    }

    private void P(final com.martian.libmars.widget.recyclerview.d holder, final MiHistoryBookCoins historyBookCoins) {
        if (historyBookCoins == null) {
            return;
        }
        holder.W(R.id.tv_coins_title, historyBookCoins.getBookCoinsType());
        TextView textView = (TextView) holder.getView(R.id.tv_coins_num);
        if (historyBookCoins.getBookCoins() == null) {
            textView.setVisibility(8);
        } else if (historyBookCoins.getConsume()) {
            textView.setTextColor(com.martian.libmars.d.h.F().p0());
            textView.setText("-" + historyBookCoins.getBookCoins() + this.f10474a.getResources().getString(R.string.txs_coin));
            textView.setTypeface(Typeface.DEFAULT);
        } else {
            textView.setTextColor(ContextCompat.getColor(this.f10474a, R.color.bonus_red));
            textView.setText("+" + historyBookCoins.getBookCoins() + this.f10474a.getResources().getString(R.string.txs_coin));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (historyBookCoins.getCreatedOn() == null) {
            holder.a0(R.id.tv_coins_time, false);
        } else {
            try {
                holder.W(R.id.tv_coins_time, com.martian.libsupport.d.h(historyBookCoins.getCreatedOn().longValue()));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, MiHistoryBookCoins historyBookCoins) {
        P(helper, historyBookCoins);
    }
}
