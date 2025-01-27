package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.d.q.m0;
import com.martian.mibook.lib.account.request.BonusPollParams;
import com.martian.mibook.lib.account.response.BonusPool;

/* loaded from: classes3.dex */
public abstract class b extends m0<BonusPollParams, BonusPool> {
    public b() {
        super(BonusPollParams.class, BonusPool.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(BonusPool bonusPool) {
        if (bonusPool == null) {
            return false;
        }
        return super.onPreDataReceived(bonusPool);
    }
}
