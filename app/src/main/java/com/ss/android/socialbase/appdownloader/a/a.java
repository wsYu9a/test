package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public abstract class a implements e {

    /* renamed from: a */
    protected final Context f21745a;

    /* renamed from: b */
    protected final DownloadSetting f21746b;

    /* renamed from: c */
    protected final String f21747c;

    public a(Context context, DownloadSetting downloadSetting, String str) {
        this.f21745a = context;
        this.f21746b = downloadSetting;
        this.f21747c = str;
    }

    public boolean a() {
        if (this.f21745a == null) {
            return false;
        }
        try {
        } catch (Throwable th2) {
            if (Logger.debug()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th2);
            }
        }
        return b().resolveActivity(this.f21745a.getPackageManager()) != null;
    }
}
