package com.kwad.sdk.crash.handler;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

@Keep
/* loaded from: classes3.dex */
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    /* renamed from: com.kwad.sdk.crash.handler.NativeCrashHandler$1 */
    public class AnonymousClass1 implements MessageQueue.IdleHandler {
        final /* synthetic */ String aKv;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            com.kwad.sdk.core.d.c.d(NativeCrashHandler.TAG, "native install in idle" + NativeCrashHandler.this.mDumpDir.getPath());
            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
            return false;
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.NativeCrashHandler$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String aKv;

        public AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.e(NativeCrashHandler.TAG, "native install in main:" + NativeCrashHandler.this.mDumpDir.getPath());
            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
        }
    }

    public static class a {
        private static final NativeCrashHandler aKx = new NativeCrashHandler();
    }

    public /* synthetic */ NativeCrashHandler(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static native void doCrash();

    public static native void doFakeCrash();

    public static native void doMemoryCorruption();

    public static native void doNativeFdOverLimitCrash();

    public static NativeCrashHandler getInstance() {
        return a.aKx;
    }

    public static native void install(@NonNull String str, @NonNull String str2, int i10);

    @Keep
    public static synchronized void onCallFromNative(long j10) {
        synchronized (NativeCrashHandler.class) {
            com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative");
            b.isExceptionHappened.set(true);
            b.sCrashingPid = String.valueOf(Process.myPid());
            File file = getInstance().mLogDir;
            File file2 = getInstance().mLogcatFile;
            File file3 = getInstance().mMessageFile;
            File file4 = getInstance().mJavaTraceFile;
            File file5 = getInstance().mMemoryInfoFile;
            e uploader = getInstance().getUploader();
            try {
                if (!file.exists() && !file.mkdirs()) {
                    StringBuilder sb2 = new StringBuilder();
                    ExceptionMessage exceptionMessage = mMessage;
                    sb2.append(exceptionMessage.mErrorMessage);
                    sb2.append("create ");
                    sb2.append(file.getPath());
                    sb2.append(" failed!\n");
                    exceptionMessage.mErrorMessage = sb2.toString();
                    if (uploader != null) {
                        mMessage.toJson();
                    }
                }
                if (!getInstance().mDumpDir.exists() && !getInstance().mDumpDir.mkdirs()) {
                    StringBuilder sb3 = new StringBuilder();
                    ExceptionMessage exceptionMessage2 = mMessage;
                    sb3.append(exceptionMessage2.mErrorMessage);
                    sb3.append("create ");
                    sb3.append(getInstance().mDumpDir.getPath());
                    sb3.append(" failed!\n");
                    exceptionMessage2.mErrorMessage = sb3.toString();
                    if (uploader != null) {
                        mMessage.toJson();
                    }
                }
                if (file2 == null) {
                    file2 = new File(getInstance().mDumpDir, "logcat");
                }
                if (file3 == null) {
                    file3 = new File(getInstance().mDumpDir, b7.d.f1362o);
                }
                if (file4 == null) {
                    file4 = new File(getInstance().mDumpDir, "all_java_backtrace");
                }
                if (file5 == null) {
                    file5 = new File(getInstance().mDumpDir, "meminfo");
                }
                g.b(null, mMessage, com.kwad.sdk.crash.e.Jk().getContext());
                g.a(mMessage, getInstance().getCrashType());
                mMessage.mLogUUID = g.fX(getInstance().mDumpDir.getName());
                try {
                    com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                    g.a(file3, mMessage.toJson().toString());
                    g.H(file4);
                    getInstance().backupLogFiles(file);
                    g.a(uploader, TAG, getInstance().mDumpDir);
                    getInstance().uploadRemainingExceptions();
                    g.I(file5);
                    g.F(file2);
                    if (getInstance().mExceptionListener != null) {
                        getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    if (uploader != null) {
                        g.r(th2);
                    }
                }
            } catch (Throwable th3) {
                try {
                    StringBuilder sb4 = new StringBuilder();
                    ExceptionMessage exceptionMessage3 = mMessage;
                    sb4.append(exceptionMessage3.mErrorMessage);
                    sb4.append(th3);
                    exceptionMessage3.mErrorMessage = sb4.toString();
                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", Log.getStackTraceString(th3));
                    if (file3 != null) {
                        try {
                            com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                            g.a(file3, mMessage.toJson().toString());
                        } catch (Throwable th4) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
                            if (uploader != null) {
                                g.r(th4);
                                return;
                            }
                            return;
                        }
                    }
                    g.H(file4);
                    getInstance().backupLogFiles(file);
                    g.a(uploader, TAG, getInstance().mDumpDir);
                    getInstance().uploadRemainingExceptions();
                    g.I(file5);
                    g.F(file2);
                    if (getInstance().mExceptionListener != null) {
                        getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                    }
                } finally {
                    if (file3 != null) {
                        try {
                        } catch (Throwable th5) {
                        }
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 4;
    }

    public final void init(@NonNull File file, boolean z10, @NonNull String str, com.kwad.sdk.crash.report.c cVar) {
        MessageQueue queue;
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.b.IT()) {
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpDir = new File(file, b.FILE_NAME_BASE + "-native-0");
            this.mLogcatFile = new File(this.mDumpDir, "logcat");
            this.mMessageFile = new File(this.mDumpDir, b7.d.f1362o);
            this.mJavaTraceFile = new File(this.mDumpDir, "all_java_backtrace");
            this.mMemoryInfoFile = new File(this.mDumpDir, "meminfo");
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kwad.sdk.crash.handler.NativeCrashHandler.2
                        final /* synthetic */ String aKv;

                        public AnonymousClass2(String str2) {
                            str = str2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.c.e(NativeCrashHandler.TAG, "native install in main:" + NativeCrashHandler.this.mDumpDir.getPath());
                            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
                        }
                    });
                } else {
                    queue = Looper.getMainLooper().getQueue();
                    queue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.NativeCrashHandler.1
                        final /* synthetic */ String aKv;

                        public AnonymousClass1(String str2) {
                            str = str2;
                        }

                        @Override // android.os.MessageQueue.IdleHandler
                        public final boolean queueIdle() {
                            com.kwad.sdk.core.d.c.d(NativeCrashHandler.TAG, "native install in idle" + NativeCrashHandler.this.mDumpDir.getPath());
                            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
                            return false;
                        }
                    });
                }
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }

    private NativeCrashHandler() {
    }
}
