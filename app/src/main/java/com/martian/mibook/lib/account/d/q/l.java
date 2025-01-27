package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.FinishExtraBonusParams;
import com.martian.mibook.lib.account.response.ExtraBonus;

/* loaded from: classes3.dex */
public abstract class l extends com.martian.mibook.lib.account.d.n<FinishExtraBonusParams, ExtraBonus> {
    public l(j1 activity) {
        super(activity, FinishExtraBonusParams.class, ExtraBonus.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(ExtraBonus extraBonus) {
        if (extraBonus == null) {
            return false;
        }
        return super.onPreDataReceived(extraBonus);
    }
}
