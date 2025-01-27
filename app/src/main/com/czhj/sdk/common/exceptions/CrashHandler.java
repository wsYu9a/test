package com.czhj.sdk.common.exceptions;

import android.os.Process;
import android.text.TextUtils;
import com.czhj.sdk.common.mta.PointEntityCrash;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH = "crash";
    private static CrashHandler gInstance;
    private PointEntityCrash entityCrash = null;
    private Set<CrashHandlerListener> crashHandlerListenerSet = new HashSet();
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: com.czhj.sdk.common.exceptions.CrashHandler$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Throwable val$exc;

        public AnonymousClass1(Throwable th2) {
            th2 = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashHandler.this.writeCrash(th2);
        }
    }

    public interface CrashHandlerListener {
        void reportCrash(String str);
    }

    private CrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized CrashHandler getInstance() {
        CrashHandler crashHandler;
        synchronized (CrashHandler.class) {
            try {
                if (gInstance == null) {
                    synchronized (CrashHandler.class) {
                        gInstance = new CrashHandler();
                    }
                }
                crashHandler = gInstance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return crashHandler;
    }

    private boolean handleException(Throwable th2) {
        if (th2 == null) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.czhj.sdk.common.exceptions.CrashHandler.1
            final /* synthetic */ Throwable val$exc;

            public AnonymousClass1(Throwable th22) {
                th2 = th22;
            }

            @Override // java.lang.Runnable
            public void run() {
                CrashHandler.this.writeCrash(th2);
            }
        }).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return true;
        }
    }

    public void writeCrash(Throwable th2) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            do {
                th2.printStackTrace(printWriter);
                th2 = th2.getCause();
            } while (th2 != null);
            printWriter.close();
            String obj = stringWriter.toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            for (CrashHandlerListener crashHandlerListener : this.crashHandlerListenerSet) {
                if (crashHandlerListener != null) {
                    crashHandlerListener.reportCrash(obj);
                }
            }
        } catch (Exception e10) {
            e = e10;
            e.printStackTrace();
        } catch (Throwable th3) {
            e = th3;
            e.printStackTrace();
        }
    }

    public void add(CrashHandlerListener crashHandlerListener) {
        if (crashHandlerListener != null) {
            this.crashHandlerListenerSet.add(crashHandlerListener);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            handleException(th2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultCrashHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
