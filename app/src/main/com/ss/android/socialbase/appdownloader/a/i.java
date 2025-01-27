package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: d */
    private String f21749d;

    /* renamed from: e */
    private String f21750e;

    public i(Context context, DownloadSetting downloadSetting, String str, String str2, String str3) {
        super(context, downloadSetting, str);
        this.f21749d = str2;
        this.f21750e = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String str;
        String optString = this.f21746b.optString("s");
        String a10 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("ak"), optString);
        String a11 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("am"), optString);
        String a12 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString(n3.a.f28755u), optString);
        String str2 = null;
        if (!TextUtils.isEmpty(a12) && a12.split(",").length == 2) {
            String[] split = a12.split(",");
            String a13 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("al"), optString);
            String a14 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("ao"), optString);
            if (!TextUtils.isEmpty(a14) && a14.split(",").length == 2) {
                String[] split2 = a14.split(",");
                JSONObject optJSONObject = this.f21746b.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
                    if (TextUtils.isEmpty(optString2) || !optString2.contains("%s")) {
                        str = this.f21750e;
                    } else {
                        try {
                            str = String.format(optString2, this.f21750e);
                        } catch (Throwable unused) {
                            str = this.f21750e;
                        }
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = a13.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(a10);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(a11, this.f21749d);
                intent.putExtra(a13, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
