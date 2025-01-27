package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public abstract class j implements q {

    /* renamed from: i */
    protected final String f24473i;

    /* renamed from: j */
    protected final Context f24474j;
    protected final DownloadSetting zx;

    public j(Context context, DownloadSetting downloadSetting, String str) {
        this.f24474j = context;
        this.zx = downloadSetting;
        this.f24473i = str;
    }

    public boolean j() {
        if (this.f24474j == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (Logger.debug()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return zx().resolveActivity(this.f24474j.getPackageManager()) != null;
    }
}
