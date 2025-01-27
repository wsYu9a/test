package com.martian.apptask.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AppTaskList {
    private List<AppTask> apps;

    public AppTaskList addAppTask(AppTask appTask) {
        if (this.apps == null) {
            this.apps = new ArrayList();
        }
        this.apps.add(appTask);
        return this;
    }

    public List<AppTask> getApps() {
        return this.apps;
    }

    public boolean isEmpty() {
        List<AppTask> list = this.apps;
        return list == null || list.isEmpty();
    }

    public void setApps(List<AppTask> list) {
        this.apps = list;
    }
}
