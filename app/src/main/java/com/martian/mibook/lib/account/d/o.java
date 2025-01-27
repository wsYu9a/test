package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.request.TYBookRulesParams;
import com.martian.mibook.lib.account.response.TYBookRuleList;

/* loaded from: classes3.dex */
public abstract class o extends f<TYBookRulesParams, TYBookRuleList> {
    public o() {
        super(TYBookRulesParams.class, TYBookRuleList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYBookRuleList tyBookRuleList) {
        if (tyBookRuleList.getRules() == null) {
            return false;
        }
        return super.onPreDataReceived(tyBookRuleList);
    }
}
