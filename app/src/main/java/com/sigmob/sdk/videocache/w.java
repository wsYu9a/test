package com.sigmob.sdk.videocache;

import android.content.Context;
import android.os.Environment;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a */
    public static final String f20688a = "video-cache";

    public static File a(Context context, boolean z10) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File a10 = (z10 && "mounted".equals(str)) ? a(context) : null;
        if (a10 == null) {
            a10 = context.getCacheDir();
        }
        if (a10 != null) {
            return a10;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        SigmobLog.w("Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }

    public static File b(Context context) {
        return new File(a(context, true), "video-cache");
    }

    public static File a(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "SigmobAndroid"), h3.e.f26408m), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        SigmobLog.w("Unable to create external cache directory");
        return null;
    }
}
