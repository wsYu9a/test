package com.czhj.sdk.logger;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class SigmobLog {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8694a = "com.sigmob";

    /* renamed from: b, reason: collision with root package name */
    public static final String f8695b = "sigmob";

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f8696c;

    /* renamed from: d, reason: collision with root package name */
    public static final SigmobLogHandler f8697d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f8698e = false;

    public static final class SigmobLogHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public static final Map<Level, Integer> f8699a;

        static {
            HashMap hashMap = new HashMap(7);
            f8699a = hashMap;
            hashMap.put(Level.FINEST, 2);
            hashMap.put(Level.FINER, 2);
            hashMap.put(Level.FINE, 2);
            hashMap.put(Level.CONFIG, 3);
            hashMap.put(Level.INFO, 3);
            hashMap.put(Level.WARNING, 5);
            hashMap.put(Level.SEVERE, 6);
        }

        public SigmobLogHandler() {
        }

        @Override // java.util.logging.Handler
        public void close() {
        }

        @Override // java.util.logging.Handler
        public void flush() {
        }

        @Override // java.util.logging.Handler
        public void publish(LogRecord logRecord) {
            if (isLoggable(logRecord)) {
                Map<Level, Integer> map = f8699a;
                int intValue = map.containsKey(logRecord.getLevel()) ? map.get(logRecord.getLevel()).intValue() : 2;
                String str = logRecord.getMessage() + "\n";
                Throwable thrown = logRecord.getThrown();
                if (thrown != null) {
                    str = str + Log.getStackTraceString(thrown);
                }
                Log.println(intValue, "sigmob", str);
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(f8694a);
        f8696c = logger;
        SigmobLogHandler sigmobLogHandler = new SigmobLogHandler();
        f8697d = sigmobLogHandler;
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        sigmobLogHandler.setLevel(Level.INFO);
        LogManager.getLogManager().addLogger(logger);
        a(logger, sigmobLogHandler);
    }

    public static void a(Logger logger, Handler handler) {
        for (Handler handler2 : logger.getHandlers()) {
            if (handler2.equals(handler)) {
                return;
            }
        }
        logger.addHandler(handler);
    }

    public static void addHandler(Handler handler) {
        a(f8696c, handler);
    }

    public static void b(String str, Throwable th2) {
        f8696c.log(Level.INFO, str, th2);
    }

    public static void c(String str) {
        a(str, (Throwable) null);
    }

    public static void d(String str) {
    }

    public static void dd(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        if (str2.length() > 3072) {
            while (str2.length() > 3072) {
                String substring = str2.substring(0, 3072);
                str2 = str2.replace(substring, "");
                Log.d(str, substring);
            }
        }
        Log.d(str, str2);
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e(str, null);
    }

    public static void i(String str) {
        b(str, null);
    }

    public static void setSdkHandlerLevel(Level level) {
        f8697d.setLevel(level);
    }

    public static void v(String str) {
        v(str, null);
    }

    public static void w(String str) {
        w(str, null);
    }

    public static void a(String str, Throwable th2) {
        f8696c.log(Level.FINEST, str, th2);
    }

    public static void d(String str, Throwable th2) {
    }

    public static void e(String str, Throwable th2) {
        f8696c.log(Level.SEVERE, str, th2);
    }

    public static void v(String str, Throwable th2) {
        f8696c.log(Level.FINE, str, th2);
    }

    public static void w(String str, Throwable th2) {
        f8696c.log(Level.WARNING, str, th2);
    }
}
