package com.martian.mibook.lib.account.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TYActivityList {
    private List<TYActivity> activityList;

    public List<TYActivity> getActivityList() {
        if (this.activityList == null) {
            this.activityList = new ArrayList();
        }
        return this.activityList;
    }

    public void setActivityList(List<TYActivity> list) {
        this.activityList = list;
    }
}
