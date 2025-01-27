package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.InviterDurationRankParams;
import com.martian.mibook.lib.account.response.TYInviteeList;

/* loaded from: classes3.dex */
public abstract class z extends com.martian.mibook.lib.account.d.n<InviterDurationRankParams, TYInviteeList> {
    public z(j1 activity) {
        super(activity, InviterDurationRankParams.class, TYInviteeList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(TYInviteeList tyInviteeList) {
        if (tyInviteeList == null || tyInviteeList.getInvitees() == null) {
            return false;
        }
        return super.onPreDataReceived(tyInviteeList);
    }
}
