package com.shu.priory.utils;

import android.content.Context;
import com.shu.priory.config.SDKConstants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a */
    private static Context f17306a;

    /* renamed from: b */
    private static g f17307b;

    /* renamed from: c */
    private static File f17308c;

    /* renamed from: d */
    private static SimpleDateFormat f17309d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    private static String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(f17307b.getClass().getName())) {
                return "[" + f17309d.format(new Date()) + "]";
            }
        }
        return null;
    }

    public static void a(Object obj) {
        File file;
        if (f17306a == null || f17307b == null || (file = f17308c) == null || !file.exists()) {
            return;
        }
        String str = a() + " - " + obj.toString();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f17308c, true));
            bufferedWriter.write(str);
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "write:" + e10.getMessage());
        }
    }
}
