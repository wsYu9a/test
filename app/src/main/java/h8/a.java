package h8;

import android.text.TextUtils;
import ba.l;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import i8.g;
import java.net.URLEncoder;
import java.util.List;
import x8.k;
import z8.e;

/* loaded from: classes3.dex */
public abstract class a extends y8.b<String, AppTaskList> {
    private int adsCount = 1;
    private String position;
    private String uid;

    public int getAdsCount() {
        return this.adsCount;
    }

    public void setAdsCount(int i10) {
        this.adsCount = i10;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @Override // y8.b
    public k doInBackground(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "http://taoyuewenhua.net:8081/ads/miapps.txt";
            }
            StringBuilder sb2 = new StringBuilder(str);
            if (!str.endsWith("?")) {
                sb2.append("?");
            }
            for (String str2 : ConfigSingleton.U) {
                String g02 = ConfigSingleton.D().g0(str2);
                if (!TextUtils.isEmpty(g02)) {
                    String encode = URLEncoder.encode(g02, "UTF-8");
                    sb2.append(str2);
                    sb2.append("=");
                    sb2.append(encode);
                    sb2.append("&");
                }
            }
            sb2.append("&adsCount=");
            sb2.append(this.adsCount);
            if (!l.q(this.uid)) {
                sb2.append("&uid=");
                sb2.append(this.uid);
            }
            if (!l.q(this.position)) {
                this.position = URLEncoder.encode(this.position, "UTF-8");
                sb2.append("&position=");
                sb2.append(this.position);
            }
            return new x8.b((AppTaskList) GsonUtils.b().fromJson(e.b(sb2.toString(), null), AppTaskList.class));
        } catch (Exception unused) {
            return new x8.c(-1, "应用列表为空");
        }
    }

    @Override // y8.b, y8.a
    public boolean onPreDataReceived(AppTaskList appTaskList) {
        if (appTaskList.getApps() == null) {
            return false;
        }
        for (AppTask appTask : appTaskList.getApps()) {
            if (g.m(ConfigSingleton.D(), appTask.packageName)) {
                appTask.isInstalled = true;
            }
        }
        return super.onPreDataReceived((a) appTaskList);
    }

    @Override // y8.b
    public void onUDDataReceived(List<AppTaskList> list) {
    }
}
