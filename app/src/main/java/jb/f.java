package jb;

import com.martian.mibook.lib.account.request.MissionBonusParams;
import com.martian.mibook.lib.account.response.MissionBonusList;

/* loaded from: classes3.dex */
public abstract class f extends d<MissionBonusParams, MissionBonusList> {
    public f() {
        super(MissionBonusParams.class, MissionBonusList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(MissionBonusList missionBonusList) {
        if (missionBonusList == null || missionBonusList.getBonusList() == null || missionBonusList.getBonusList().size() == 0) {
            return false;
        }
        return super.onPreDataReceived(missionBonusList);
    }
}
