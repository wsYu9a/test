package com.martian.mibook.lib.account.response;

import java.util.List;

/* loaded from: classes3.dex */
public class MissionBonusList {
    public List<MissionItem> bonusList;

    public List<MissionItem> getBonusList() {
        return this.bonusList;
    }

    public boolean isEmpty() {
        List<MissionItem> list = this.bonusList;
        return list == null || list.isEmpty();
    }

    public void setBonusList(List<MissionItem> bonusList) {
        this.bonusList = bonusList;
    }
}
