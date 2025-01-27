package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.request.MissionBonusParams;
import com.martian.mibook.lib.account.response.MissionBonusList;

/* loaded from: classes3.dex */
public abstract class h extends f<MissionBonusParams, MissionBonusList> {
    public h() {
        super(MissionBonusParams.class, MissionBonusList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(MissionBonusList missionBonusList) {
        if (missionBonusList == null || missionBonusList.getBonusList() == null || missionBonusList.getBonusList().size() == 0) {
            return false;
        }
        return super.onPreDataReceived(missionBonusList);
    }
}
