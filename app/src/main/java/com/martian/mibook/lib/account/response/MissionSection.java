package com.martian.mibook.lib.account.response;

import java.util.List;

/* loaded from: classes3.dex */
public class MissionSection {
    public List<MissionItem> missionItems;
    public String title;

    public List<MissionItem> getMissionItems() {
        return this.missionItems;
    }

    public String getTitle() {
        return this.title;
    }

    public void setMissionItems(List<MissionItem> missionItems) {
        this.missionItems = missionItems;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
