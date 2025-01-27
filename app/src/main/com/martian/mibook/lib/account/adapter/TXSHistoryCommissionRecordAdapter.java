package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.TYCommission;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class TXSHistoryCommissionRecordAdapter extends CommonRecycleViewAdapter<TYCommission> {

    /* renamed from: i */
    public final Context f13901i;

    public TXSHistoryCommissionRecordAdapter(Context context, List<TYCommission> list) {
        super(context, R.layout.history_coins_item, list);
        this.f13901i = context;
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, TYCommission tYCommission) {
        u(viewHolderHelper, tYCommission);
    }

    public final void u(ViewHolderHelper viewHolderHelper, TYCommission tYCommission) {
        if (tYCommission == null) {
            return;
        }
        if (!l.q(tYCommission.getType())) {
            viewHolderHelper.A(R.id.tv_coins_title, tYCommission.getType());
        }
        if (tYCommission.getCommission() == null) {
            viewHolderHelper.B(R.id.tv_coins_num, ContextCompat.getColor(this.f13901i, com.martian.libmars.R.color.heavy_grey));
            viewHolderHelper.A(R.id.tv_coins_num, "--");
        } else if (tYCommission.getCommission().intValue() < 0) {
            viewHolderHelper.B(R.id.tv_coins_num, ConfigSingleton.D().h0());
            viewHolderHelper.A(R.id.tv_coins_num, f.n(tYCommission.getCommission()) + "元");
        } else {
            viewHolderHelper.B(R.id.tv_coins_num, ContextCompat.getColor(this.f13901i, com.martian.libmars.R.color.bonus_red));
            viewHolderHelper.A(R.id.tv_coins_num, "+" + f.n(tYCommission.getCommission()) + "元");
        }
        if (tYCommission.getCreatedOn() == null) {
            viewHolderHelper.E(R.id.tv_coins_time, false);
            return;
        }
        try {
            viewHolderHelper.A(R.id.tv_coins_time, ba.f.h(tYCommission.getCreatedOn().longValue()));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
