package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

@Keep
/* loaded from: classes3.dex */
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.el(21);

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$1 */
    public class AnonymousClass1 implements MessageQueue.IdleHandler {
        public AnonymousClass1() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in Idle");
            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
            return false;
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in main:");
            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$3 */
    public class AnonymousClass3 extends FileObserver {
        public AnonymousClass3(String str, int i10) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i10, @Nullable String str) {
            if (str != null) {
                AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
            }
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnrHandler.getInstance().dumpAnr(null, AnrHandler.this.mIndex.getAndIncrement());
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ int aKq;

        public AnonymousClass5(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnrHandler.getInstance().dumpAnr(null, i10);
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$6 */
    public class AnonymousClass6 implements Printer {
        final /* synthetic */ StringBuilder aKr;

        public AnonymousClass6(StringBuilder sb2) {
            sb2 = sb2;
        }

        @Override // android.util.Printer
        public final void println(String str) {
            StringBuilder sb2 = sb2;
            sb2.append(str);
            sb2.append("\n");
        }
    }

    public static class a {
        private static final AnrHandler aKs = new AnrHandler();
    }

    public /* synthetic */ AnrHandler(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static boolean checkErrorState() {
        try {
            com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] start");
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) com.kwad.sdk.core.c.b.Fi().getApplication().getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] procs == null");
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "maybe received other apps ANR signal");
                    return false;
                }
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "error sate longMsg = " + processErrorStateInfo.longMsg);
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e(TAG, "[checkErrorState] error : " + th2.getMessage());
            return false;
        }
    }

    public synchronized void dumpAnr(@Nullable String str, int i10) {
        boolean z10;
        com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i10);
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        File file = new File(this.mDumpDir.toString() + "-" + i10);
        File file2 = getInstance().mLogDir;
        try {
            if (file2.exists() || file2.mkdirs()) {
                z10 = true;
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file2.getPath() + " failed!\n";
                z10 = false;
            }
            if (!file.exists() && !file.mkdirs()) {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + this.mDumpDir.getPath() + " failed!\n";
                z10 = false;
            }
            g.b(null, anrExceptionMessage, e.Jk().getContext());
            g.a(anrExceptionMessage, 3);
            File file3 = new File(file, com.sigmob.sdk.archives.d.f17513c);
            if (str != null && z10) {
                u.f(new File(str), file3);
            }
            g.F(new File(file, "logcat"));
            try {
                StringBuilder sb2 = new StringBuilder();
                Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.6
                    final /* synthetic */ StringBuilder aKr;

                    public AnonymousClass6(StringBuilder sb22) {
                        sb2 = sb22;
                    }

                    @Override // android.util.Printer
                    public final void println(String str2) {
                        StringBuilder sb22 = sb2;
                        sb22.append(str2);
                        sb22.append("\n");
                    }
                }, "");
                anrExceptionMessage.mMessageQueueDetail = sb22.substring(0, sb22.length() - 1);
            } catch (Exception e10) {
                anrExceptionMessage.mErrorMessage += Log.getStackTraceString(e10) + "\n";
            }
            try {
                anrExceptionMessage.mLogUUID = g.fX(file3.getName());
                g.a(new File(file, b7.d.f1362o), anrExceptionMessage.toJson().toString());
                getInstance().backupLogFiles(file2);
                com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
                if (uploader != null) {
                    anrExceptionMessage.toString();
                }
                g.a(uploader, TAG, file3);
                g.I(new File(file, "meminfo"));
            } catch (Throwable unused) {
            }
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
            }
            getInstance().uploadRemainingExceptions();
            notifyJavaDumpDone();
            getAnrReason(str, file);
        } catch (Throwable th2) {
            anrExceptionMessage.mErrorMessage += th2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    private static void getAnrReason(@Nullable String str, File file) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        com.kwad.sdk.core.d.c.d(TAG, "ANR getAnrReasonInner");
        getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < 10000) {
                    return;
                } else {
                    sLastTime = lastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.Jk().getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return;
        }
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < TRY_TIMES; i10++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = it.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (Build.VERSION.SDK_INT > 33 && !z10 && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().pid == Process.myPid()) {
                            break;
                        }
                    } else {
                        com.kwad.sdk.core.d.c.i(TAG, "anr did happen on android14");
                        g.a(new File(file, "anr_happened"), (CharSequence) "anr did happen", false);
                        z10 = true;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(500L);
        }
        if (processErrorStateInfo != null && processErrorStateInfo.pid == MY_PID) {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            File file2 = new File(file, "anr_reason");
            com.kwad.sdk.core.d.c.i(TAG, "anr reason: " + anrReason.toJson().toString());
            g.a(file2, anrReason.toJson().toString());
        }
    }

    public static AnrHandler getInstance() {
        return a.aKs;
    }

    @Keep
    public static synchronized String getMainThreadStackTrace() {
        String sb2;
        synchronized (AnrHandler.class) {
            try {
                StringBuilder sb3 = new StringBuilder();
                for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                    sb3.append("  at ");
                    sb3.append(stackTraceElement);
                    sb3.append("\n");
                }
                sb3.append("\n");
                sb2 = sb3.toString();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th2));
                return "";
            }
        }
        return sb2;
    }

    public static native boolean getStackTraceCrashOccured();

    public static native void install(String str, int i10);

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        if (r1.getPackageName().equals(r0.getPackageName()) == false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isANRForeground() {
        /*
            r8 = this;
            com.kwad.sdk.crash.e r0 = com.kwad.sdk.crash.e.Jk()
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            r2 = 0
            if (r1 != 0) goto L14
            return r2
        L14:
            int r3 = android.os.Process.myPid()
            r4 = 10
            java.util.List r4 = r1.getRunningServices(r4)
            r5 = 1
            if (r4 == 0) goto L3a
            java.util.Iterator r4 = r4.iterator()
        L25:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L3a
            java.lang.Object r6 = r4.next()
            android.app.ActivityManager$RunningServiceInfo r6 = (android.app.ActivityManager.RunningServiceInfo) r6
            boolean r7 = r6.foreground
            if (r7 == 0) goto L25
            int r6 = r6.pid
            if (r6 != r3) goto L25
            return r5
        L3a:
            java.lang.String r3 = "keyguard"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.KeyguardManager r3 = (android.app.KeyguardManager) r3
            if (r3 == 0) goto L4b
            boolean r3 = r3.isKeyguardLocked()
            if (r3 == 0) goto L4b
            return r2
        L4b:
            java.util.List r1 = r1.getRunningTasks(r5)
            if (r1 == 0) goto L76
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L76
            java.lang.Object r1 = r1.get(r2)
            android.app.ActivityManager$RunningTaskInfo r1 = (android.app.ActivityManager.RunningTaskInfo) r1
            android.content.ComponentName r3 = g4.a.a(r1)
            if (r3 == 0) goto L75
            android.content.ComponentName r1 = g4.a.a(r1)
            java.lang.String r1 = r1.getPackageName()
            java.lang.String r0 = r0.getPackageName()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L76
        L75:
            return r2
        L76:
            com.kwad.sdk.core.c.b.Fi()
            boolean r0 = com.kwad.sdk.core.c.b.isAppOnForeground()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.AnrHandler.isANRForeground():boolean");
    }

    @Keep
    public static boolean isRealNotResponding(int i10) {
        com.kwad.sdk.core.d.c.d(TAG, "judge isRealNotResponding");
        try {
            b.isExceptionHappened.set(true);
            b.sCrashingPid = String.valueOf(Process.myPid());
            h.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.5
                final /* synthetic */ int aKq;

                public AnonymousClass5(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, i10);
                }
            });
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public static native void notifyJavaDumpDone();

    @Keep
    public static void onCallFromNative(int i10) {
    }

    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.c.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            h.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, AnrHandler.this.mIndex.getAndIncrement());
                }
            });
        }
    }

    private boolean parseTraceFile(String str) {
        int i10;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            i10 = -1;
                            break;
                        }
                        if (PID_PATTERN.matcher(readLine).matches()) {
                            i10 = Integer.parseInt(readLine.split("\\s")[2]);
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z10 = i10 == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z10;
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.d.c.d(TAG, "ANR watchTraceFile");
        AnonymousClass3 anonymousClass3 = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
            public AnonymousClass3(String str, int i10) {
                super(str, 8);
            }

            @Override // android.os.FileObserver
            public final void onEvent(int i10, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = anonymousClass3;
        try {
            anonymousClass3.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        MessageQueue queue;
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.IT()) {
            com.kwad.sdk.core.d.c.d(TAG, "ANR init ");
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = this.mLogDir;
            StringBuilder sb2 = new StringBuilder();
            String str = b.FILE_NAME_BASE;
            sb2.append(str);
            sb2.append("-anr");
            this.mDumpDir = new File(file2, sb2.toString());
            new File(this.mLogDir, str);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                        public AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in main:");
                            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
                        }
                    });
                } else {
                    queue = Looper.getMainLooper().getQueue();
                    queue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
                        public AnonymousClass1() {
                        }

                        @Override // android.os.MessageQueue.IdleHandler
                        public final boolean queueIdle() {
                            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in Idle");
                            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
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
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }

    private AnrHandler() {
    }
}
