package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.TYCommission;
import java.util.List;

/* loaded from: classes3.dex */
public class f extends com.martian.libmars.widget.recyclerview.e.c<TYCommission> {

    /* renamed from: g */
    private final Context f13810g;

    public f(Context context, List<TYCommission> datas) {
        super(context, R.layout.history_coins_item, datas);
        this.f13810g = context;
    }

    private void P(final com.martian.libmars.widget.recyclerview.d holder, final TYCommission tyCommission) {
        if (tyCommission == null) {
            return;
        }
        if (!k.p(tyCommission.getType())) {
            holder.W(R.id.tv_coins_title, tyCommission.getType());
        }
        if (tyCommission.getCommission() == null) {
            int i2 = R.id.tv_coins_num;
            holder.X(i2, ContextCompat.getColor(this.f13810g, R.color.heavy_grey));
            holder.W(i2, "--");
        } else if (tyCommission.getCommission().intValue() < 0) {
            int i3 = R.id.tv_coins_num;
            holder.X(i3, com.martian.libmars.d.h.F().p0());
            holder.W(i3, com.martian.rpauth.d.i.m(tyCommission.getCommission()) + "元");
        } else {
            int i4 = R.id.tv_coins_num;
            holder.X(i4, ContextCompat.getColor(this.f13810g, R.color.bonus_red));
            holder.W(i4, "+" + com.martian.rpauth.d.i.m(tyCommission.getCommission()) + "元");
        }
        if (tyCommission.getCreatedOn() == null) {
            holder.a0(R.id.tv_coins_time, false);
        } else {
            try {
                holder.W(R.id.tv_coins_time, com.martian.libsupport.d.h(tyCommission.getCreatedOn().longValue()));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, TYCommission tyCommission) {
        P(helper, tyCommission);
    }
}
