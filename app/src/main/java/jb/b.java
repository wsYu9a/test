package jb;

import com.martian.mibook.lib.account.request.BonusPollParams;
import com.martian.mibook.lib.account.response.BonusPool;
import kb.c0;

/* loaded from: classes3.dex */
public abstract class b extends c0<BonusPollParams, BonusPool> {
    public b() {
        super(BonusPollParams.class, BonusPool.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(BonusPool bonusPool) {
        if (bonusPool == null) {
            return false;
        }
        return super.onPreDataReceived(bonusPool);
    }
}
