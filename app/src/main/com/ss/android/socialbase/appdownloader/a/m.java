package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class m extends a {
    public m(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    public static String a(Map<String, String> map) {
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

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String optString = this.f21746b.optString("s");
        String a10 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("bb"), optString);
        if (!TextUtils.isEmpty(a10) && a10.split(",").length == 2) {
            String a11 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("bc"), optString);
            if (!TextUtils.isEmpty(a11) && a11.split(",").length == 2) {
                String[] split = a10.split(",");
                String[] split2 = a11.split(",");
                String a12 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("bd"), optString);
                String a13 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("be"), optString);
                String a14 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("bf"), optString);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(a12, this.f21747c);
                Intent intent = new Intent();
                intent.setAction(a14);
                intent.setData(Uri.parse(a13 + a(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
