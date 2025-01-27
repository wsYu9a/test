package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.HistoryDuration;
import java.util.List;

/* loaded from: classes3.dex */
public class b extends com.martian.libmars.widget.recyclerview.e.c<HistoryDuration> {

    /* renamed from: g */
    private final Context f13807g;

    public b(Context context, List<HistoryDuration> datas) {
        super(context, R.layout.martian_income_list_item, datas);
        this.f13807g = context;
    }

    private void P(final com.martian.libmars.widget.recyclerview.d holder, final HistoryDuration historyDuration) {
        if (historyDuration == null) {
            return;
        }
        holder.W(R.id.martian_income_title, k.p(historyDuration.getType()) ? "金币收入" : historyDuration.getType());
        if (historyDuration.getCoins().intValue() >= 0) {
            int i2 = R.id.martian_income_num;
            holder.W(i2, "+" + historyDuration.getCoins() + "金币");
            holder.X(i2, ContextCompat.getColor(this.f13807g, R.color.bonus_red));
        } else {
            int i3 = R.id.martian_income_num;
            holder.W(i3, historyDuration.getCoins() + "金币");
            holder.X(i3, com.martian.libmars.d.h.F().p0());
        }
        holder.W(R.id.martian_income_time, com.martian.rpauth.d.i.d(historyDuration.getCreatedOn()));
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, HistoryDuration historyDuration) {
        P(helper, historyDuration);
    }
}
