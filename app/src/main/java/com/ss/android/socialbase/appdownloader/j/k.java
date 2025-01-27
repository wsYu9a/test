package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k extends j {

    /* renamed from: g */
    private String f24475g;
    private String q;

    public k(Context context, DownloadSetting downloadSetting, String str, String str2, String str3) {
        super(context, downloadSetting, str);
        this.f24475g = str2;
        this.q = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.j.q
    public Intent zx() {
        String str;
        String optString = this.zx.optString("s");
        String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("ak"), optString);
        String j3 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("am"), optString);
        String j4 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("an"), optString);
        String str2 = null;
        if (!TextUtils.isEmpty(j4) && j4.split(",").length == 2) {
            String[] split = j4.split(",");
            String j5 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("al"), optString);
            String j6 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("ao"), optString);
            if (!TextUtils.isEmpty(j6) && j6.split(",").length == 2) {
                String[] split2 = j6.split(",");
                JSONObject optJSONObject = this.zx.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
                    if (TextUtils.isEmpty(optString2) || !optString2.contains("%s")) {
                        str = this.q;
                    } else {
                        try {
                            str = String.format(optString2, this.q);
                        } catch (Throwable unused) {
                            str = this.q;
                        }
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = j5.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(j2);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(j3, this.f24475g);
                intent.putExtra(j5, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
