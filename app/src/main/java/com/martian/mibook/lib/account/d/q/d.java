package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.BindPhoneParams;
import com.martian.mibook.lib.account.response.TYBonus;

/* loaded from: classes3.dex */
public abstract class d extends com.martian.mibook.lib.account.d.n<BindPhoneParams, TYBonus> {
    public d(j1 activity) {
        super(activity, BindPhoneParams.class, TYBonus.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(TYBonus tyBonus) {
        if (tyBonus == null) {
            return false;
        }
        return super.onPreDataReceived(tyBonus);
    }
}
