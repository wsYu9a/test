package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public class l extends a {
    public l(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String optString = this.f21746b.optString("s");
        String a10 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("ag"), optString);
        String a11 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("ah"), optString);
        String a12 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("ai"), optString);
        String a13 = com.ss.android.socialbase.appdownloader.f.c.a(this.f21746b.optString("aj"), optString);
        Intent intent = new Intent();
        intent.putExtra(a10, this.f21747c);
        intent.putExtra(a11, "*/*");
        intent.putExtra(a12, true);
        intent.setAction(a13);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
