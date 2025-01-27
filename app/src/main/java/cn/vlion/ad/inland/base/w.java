package cn.vlion.ad.inland.base;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class w implements Thread.UncaughtExceptionHandler {

    /* renamed from: c */
    public static w f3475c = new w();

    /* renamed from: a */
    public Thread.UncaughtExceptionHandler f3476a;

    /* renamed from: b */
    public Context f3477b;

    public w() {
        new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
    }

    public static String a(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            Throwable cause = th2.getCause();
            int i10 = 0;
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
                i10++;
                if (i10 > 3) {
                    break;
                }
            }
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable th3) {
            s4.a("CatchException: throwableInfo: ", th3);
            return "";
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        StringBuilder a10 = l1.a("MentaExceptionHandler: uncaughtException:");
        a10.append(th2.getLocalizedMessage());
        LogVlion.e(a10.toString());
        try {
            String a11 = a(th2);
            LogVlion.e("MentaExceptionHandler: result: " + a11);
            if (!TextUtils.isEmpty(a11) && a11.contains("cn.vlion.ad.inland")) {
                HttpRequestUtil.sdkException(this.f3477b, "Vlion Crash:" + a11);
                SystemClock.sleep(1000L);
            }
        } catch (Throwable unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3476a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
