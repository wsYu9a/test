package h8;

import android.text.TextUtils;
import ba.l;
import com.martian.apptask.data.AppTask;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import i8.g;
import java.net.URLEncoder;
import java.util.List;
import x8.k;
import z8.e;

/* loaded from: classes3.dex */
public abstract class c extends y8.b<String, AppTask> {
    private String uid;

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
            sb2.append(1);
            if (!l.q(this.uid)) {
                sb2.append("&uid=");
                sb2.append(this.uid);
            }
            return new x8.b((AppTask) GsonUtils.b().fromJson(e.b(sb2.toString(), null), AppTask.class));
        } catch (Exception unused) {
            return new x8.c(-1, "应用列表为空");
        }
    }

    @Override // y8.b, y8.a
    public boolean onPreDataReceived(AppTask appTask) {
        if (appTask == null) {
            return false;
        }
        if (g.m(ConfigSingleton.D(), appTask.packageName)) {
            appTask.isInstalled = true;
        }
        return super.onPreDataReceived((c) appTask);
    }

    @Override // y8.b
    public void onUDDataReceived(List<AppTask> list) {
    }
}
