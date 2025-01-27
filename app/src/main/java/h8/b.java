package h8;

import com.martian.apptask.data.AppTaskList;

/* loaded from: classes3.dex */
public abstract class b extends a {
    public void execute() {
        super.executeParallel("http://api.taoyuewenhua.net/redpaper/dv/get_header_ads.do");
    }

    public void execute(String str) {
        super.executeParallel(str);
    }

    @Override // h8.a, y8.b, y8.a
    public boolean onPreDataReceived(AppTaskList appTaskList) {
        if (appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
            return false;
        }
        return super.onPreDataReceived(appTaskList);
    }
}
