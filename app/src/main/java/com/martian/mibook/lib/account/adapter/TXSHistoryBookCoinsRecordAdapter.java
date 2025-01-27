package com.martian.mibook.lib.account.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ba.f;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MiHistoryBookCoins;
import java.util.List;

/* loaded from: classes3.dex */
public class TXSHistoryBookCoinsRecordAdapter extends CommonRecycleViewAdapter<MiHistoryBookCoins> {
    public TXSHistoryBookCoinsRecordAdapter(Activity activity, List<MiHistoryBookCoins> list) {
        super(activity, R.layout.history_coins_item, list);
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, MiHistoryBookCoins miHistoryBookCoins) {
        u(viewHolderHelper, miHistoryBookCoins);
    }

    public final void u(ViewHolderHelper viewHolderHelper, MiHistoryBookCoins miHistoryBookCoins) {
        if (miHistoryBookCoins == null) {
            return;
        }
        viewHolderHelper.A(R.id.tv_coins_title, miHistoryBookCoins.getBookCoinsType());
        TextView textView = (TextView) viewHolderHelper.g(R.id.tv_coins_num);
        if (miHistoryBookCoins.getBookCoins() == null) {
            textView.setVisibility(8);
        } else if (miHistoryBookCoins.getConsume()) {
            textView.setTextColor(ConfigSingleton.D().h0());
            textView.setText("-" + miHistoryBookCoins.getBookCoins() + this.f12822c.getResources().getString(R.string.txs_coin));
            textView.setTypeface(Typeface.DEFAULT);
        } else {
            textView.setTextColor(ContextCompat.getColor(this.f12822c, com.martian.libmars.R.color.bonus_red));
            textView.setText("+" + miHistoryBookCoins.getBookCoins() + this.f12822c.getResources().getString(R.string.txs_coin));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (miHistoryBookCoins.getCreatedOn() == null) {
            viewHolderHelper.E(R.id.tv_coins_time, false);
        } else {
            try {
                viewHolderHelper.A(R.id.tv_coins_time, f.h(miHistoryBookCoins.getCreatedOn().longValue()));
            } catch (Exception unused) {
            }
        }
    }
}
