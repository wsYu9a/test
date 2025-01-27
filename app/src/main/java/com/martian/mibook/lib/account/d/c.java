package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.request.InvitationBonusParams;
import com.martian.mibook.lib.account.response.InvitationBonus;

/* loaded from: classes3.dex */
public abstract class c extends f<InvitationBonusParams, InvitationBonus> {
    public c() {
        super(InvitationBonusParams.class, InvitationBonus.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(InvitationBonus invitationBonus) {
        if (invitationBonus == null) {
            return false;
        }
        return super.onPreDataReceived(invitationBonus);
    }
}
