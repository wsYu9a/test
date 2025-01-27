package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

@RequiresApi(api = 26)
/* loaded from: classes4.dex */
public class zx extends j {
    public zx(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.j.q
    public Intent zx() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f24474j.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        return intent;
    }
}
