package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class p extends j {
    public p(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    public static String j(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.j.q
    public Intent zx() {
        String optString = this.zx.optString("s");
        String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("bb"), optString);
        if (!TextUtils.isEmpty(j2) && j2.split(",").length == 2) {
            String j3 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("bc"), optString);
            if (!TextUtils.isEmpty(j3) && j3.split(",").length == 2) {
                String[] split = j2.split(",");
                String[] split2 = j3.split(",");
                String j4 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("bd"), optString);
                String j5 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("be"), optString);
                String j6 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("bf"), optString);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(j4, this.f24473i);
                Intent intent = new Intent();
                intent.setAction(j6);
                intent.setData(Uri.parse(j5 + j(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
