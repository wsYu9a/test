package com.czhj.devicehelper.cnadId;

import android.content.Context;
import android.provider.Settings;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class a {

    public static class b {

        /* renamed from: a */
        public static final a f8279a = new a();
    }

    public a() {
    }

    public final String a(Context context) {
        return Settings.System.getString(context.getContentResolver(), "ZHVzY2Lk");
    }

    public final String b(Context context) {
        String string = context.getSharedPreferences(context.getPackageName() + "_dna", 0).getString("ZHVzY2Lk", "NA");
        if (string.equals("NA")) {
            return null;
        }
        return string;
    }

    public final String c(Context context) {
        File file;
        try {
            file = new File("/sdcard/Android/ZHVzY2Lk");
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
        }
        if (!file.isDirectory() && file.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            String readLine = new BufferedReader(new InputStreamReader(fileInputStream)).readLine();
            r0 = readLine != null ? readLine : null;
            fileInputStream.close();
            return r0;
        }
        SigmobLog.e("The File doesn't not exist.");
        return null;
    }

    public String d(Context context) {
        String a10 = a(context);
        if (a10 != null) {
            return a10;
        }
        String b10 = b(context);
        return b10 != null ? b10 : c(context);
    }

    public /* synthetic */ a(C0243a c0243a) {
        this();
    }

    public static a a() {
        return b.f8279a;
    }
}
