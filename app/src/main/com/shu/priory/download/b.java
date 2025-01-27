package com.shu.priory.download;

import android.content.Context;
import android.os.Environment;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import java.io.File;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private static final String f16934a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "IFlyAdDownload";

    public static String a(Context context) {
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + "IFlyAdDownload");
            if (!file.exists()) {
                file.mkdir();
            }
            long j10 = 0;
            for (File file2 : file.listFiles()) {
                j10 += file2.length();
            }
            if (j10 > 314572800) {
                a.a(context).b();
                for (File file3 : file.listFiles()) {
                    file3.delete();
                }
            }
            String absolutePath = file.getAbsolutePath();
            a(absolutePath);
            return absolutePath;
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "get pre path:" + th2.getMessage());
            return "";
        }
    }

    private static void a(String str) {
        try {
            new ProcessBuilder("chmod", "777", str).start();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
