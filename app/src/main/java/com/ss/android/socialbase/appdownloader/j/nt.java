package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public class nt extends j {
    public nt(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.j.q
    public Intent zx() {
        String optString = this.zx.optString("s");
        String j2 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("ag"), optString);
        String j3 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("ah"), optString);
        String j4 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("ai"), optString);
        String j5 = com.ss.android.socialbase.appdownloader.gv.i.j(this.zx.optString("aj"), optString);
        Intent intent = new Intent();
        intent.putExtra(j2, this.f24473i);
        intent.putExtra(j3, "*/*");
        intent.putExtra(j4, true);
        intent.setAction(j5);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(32768);
        return intent;
    }
}
