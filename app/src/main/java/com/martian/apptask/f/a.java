package com.martian.apptask.f;

import android.text.TextUtils;
import b.d.c.b.k;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.g.g;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libcomm.utils.e;
import com.martian.libmars.d.h;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a extends b.d.c.c.c<String, AppTaskList> {
    private int adsCount = 1;
    private String position;
    private String uid;

    public int getAdsCount() {
        return this.adsCount;
    }

    @Override // b.d.c.c.c
    public void onUDDataReceived(List<AppTaskList> appTaskLists) {
    }

    public void setAdsCount(int adsCount) {
        this.adsCount = adsCount;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override // b.d.c.c.c
    public k doInBackground(String s) {
        try {
            if (TextUtils.isEmpty(s)) {
                s = "http://taoyuewenhua.net:8081/ads/miapps.txt";
            }
            StringBuilder sb = new StringBuilder(s);
            if (!s.endsWith("?")) {
                sb.append("?");
            }
            for (String str : h.v) {
                String o0 = h.F().o0(str);
                if (!TextUtils.isEmpty(o0)) {
                    String encode = URLEncoder.encode(o0, "UTF-8");
                    sb.append(str);
                    sb.append("=");
                    sb.append(encode);
                    sb.append("&");
                }
            }
            sb.append("&adsCount=");
            sb.append(this.adsCount);
            if (!com.martian.libsupport.k.p(this.uid)) {
                sb.append("&uid=");
                sb.append(this.uid);
            }
            if (!com.martian.libsupport.k.p(this.position)) {
                this.position = URLEncoder.encode(this.position, "UTF-8");
                sb.append("&position=");
                sb.append(this.position);
            }
            return new b.d.c.b.b(GsonUtils.b().fromJson(e.b(sb.toString(), null), AppTaskList.class));
        } catch (Exception unused) {
            return new b.d.c.b.c(-1, "应用列表为空");
        }
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    public boolean onPreDataReceived(AppTaskList miAppList) {
        if (miAppList.getApps() == null) {
            return false;
        }
        for (AppTask appTask : miAppList.getApps()) {
            if (g.g(h.F(), appTask.packageName)) {
                appTask.isInstalled = true;
            }
        }
        return super.onPreDataReceived((a) miAppList);
    }
}
