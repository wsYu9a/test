package com.martian.apptask.f;

import com.martian.apptask.data.AppTaskList;

/* loaded from: classes2.dex */
public abstract class b extends a {
    public void execute() {
        super.execute("http://api.taoyuewenhua.net/redpaper/dv/get_header_ads.do");
    }

    public void execute(String addr) {
        super.execute(addr);
    }

    @Override // com.martian.apptask.f.a, b.d.c.c.c, b.d.c.c.b
    public boolean onPreDataReceived(AppTaskList miAppList) {
        if (miAppList.getApps() == null || miAppList.getApps().isEmpty()) {
            return false;
        }
        return super.onPreDataReceived(miAppList);
    }
}
