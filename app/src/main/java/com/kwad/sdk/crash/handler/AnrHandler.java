package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
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
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Keep
/* loaded from: classes2.dex */
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
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.ch(21);

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$1 */
    final class AnonymousClass1 extends FileObserver {
        AnonymousClass1(String str, int i2) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i2, @Nullable String str) {
            if (str != null) {
                AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
            }
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$2 */
    static class AnonymousClass2 implements Printer {
        final /* synthetic */ StringBuilder arp;

        AnonymousClass2(StringBuilder sb) {
            sb = sb;
        }

        @Override // android.util.Printer
        public final void println(String str) {
            StringBuilder sb = sb;
            sb.append(str);
            sb.append("\n");
        }
    }

    /* renamed from: com.kwad.sdk.crash.handler.AnrHandler$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ File arq;

        AnonymousClass3(File file) {
            file = file;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnrHandler.getAnrReasonInner(null, file);
        }
    }

    static class a {
        private static final AnrHandler arr = new AnrHandler();
    }

    private AnrHandler() {
    }

    /* synthetic */ AnrHandler(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static synchronized void dumpAnr(@Nullable String str, int i2) {
        synchronized (AnrHandler.class) {
            com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i2);
            AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
            File file = getInstance().mLogDir;
            boolean z = true;
            try {
                if (!file.exists() && !file.mkdirs()) {
                    com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnr create dir failed.");
                    anrExceptionMessage.mErrorMessage += "create " + file.getPath() + " failed!\n";
                    z = false;
                }
                if (str != null && z) {
                    StringBuilder sb = new StringBuilder();
                    getInstance();
                    String str2 = b.FILE_NAME_BASE;
                    sb.append(str2);
                    sb.append("-");
                    sb.append(i2);
                    sb.append(".dump");
                    q.d(new File(str), new File(file, sb.toString()));
                    StringBuilder sb2 = new StringBuilder();
                    getInstance();
                    sb2.append(str2);
                    sb2.append("-");
                    sb2.append(i2);
                    sb2.append(".log");
                    g.z(new File(file, sb2.toString()));
                }
                g.b(null, anrExceptionMessage, e.zy().getContext());
                g.a(anrExceptionMessage, 3);
                if (getInstance().mExceptionListener != null) {
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
                }
            } catch (Throwable th) {
                try {
                    anrExceptionMessage.mErrorMessage += th;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                } finally {
                    dumpAnrReason(str, i2, anrExceptionMessage, z);
                }
            }
        }
    }

    private static void dumpAnrReason(@Nullable String str, int i2, @NonNull AnrExceptionMessage anrExceptionMessage, boolean z) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnrReason tracePath=" + str + " index=" + i2 + " dirReady=" + z);
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        try {
            File file = getInstance().mLogDir;
            StringBuilder sb = new StringBuilder();
            Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                final /* synthetic */ StringBuilder arp;

                AnonymousClass2(StringBuilder sb2) {
                    sb = sb2;
                }

                @Override // android.util.Printer
                public final void println(String str2) {
                    StringBuilder sb2 = sb;
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }, "");
            anrExceptionMessage.mMessageQueueDetail = sb2.substring(0, sb2.length() - 1);
            String jSONObject = anrExceptionMessage.toJson().toString();
            StringBuilder sb2 = new StringBuilder();
            getInstance();
            String str2 = b.FILE_NAME_BASE;
            sb2.append(str2);
            sb2.append("-");
            sb2.append(i2);
            sb2.append(".dump");
            File file2 = new File(file, sb2.toString());
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(str2);
                sb3.append("-");
                sb3.append(i2);
                sb3.append(".msg");
                File file3 = new File(file, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(str2);
                sb4.append("-");
                sb4.append(i2);
                sb4.append(".minfo");
                File file4 = new File(file, sb4.toString());
                g.a(file3, jSONObject);
                getInstance().backupLogFiles(file);
                if (uploader != null) {
                    new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
                }
                g.a(uploader, TAG, file2);
                getInstance().uploadRemainingExceptions();
                g.C(file4);
            } else if (uploader != null) {
                if (str != null) {
                    uploader.a(anrExceptionMessage, null);
                }
                new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
            }
            StringBuilder sb5 = new StringBuilder();
            getInstance();
            sb5.append(str2);
            sb5.append("-");
            sb5.append(i2);
            sb5.append(".anr");
            getAnrReason(str, new File(file, sb5.toString()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            if (uploader != null) {
                g.k(th);
            }
        }
    }

    private static void getAnrReason(@Nullable String str, File file) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR getAnrReason");
        if (str == null) {
            com.kwad.sdk.utils.g.schedule(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
                final /* synthetic */ File arq;

                AnonymousClass3(File file2) {
                    file = file2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getAnrReasonInner(null, file);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } else {
            getAnrReasonInner(str, file2);
        }
    }

    public static void getAnrReasonInner(@Nullable String str, File file) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR getAnrReasonInner");
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < PARSE_TRACE_INTERVAL) {
                    return;
                } else {
                    sLastTime = lastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.zy().getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        if (activityManager == null) {
            return;
        }
        for (int i2 = 0; i2 < TRY_TIMES; i2++) {
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
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(500L);
        }
        if (processErrorStateInfo == null) {
            return;
        }
        if (processErrorStateInfo.pid != MY_PID) {
            if (uploader != null) {
                new StringBuilder("other process anr:\n").append(processErrorStateInfo.shortMsg);
            }
        } else {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            g.a(file, anrReason.toJson().toString());
        }
    }

    public static AnrHandler getInstance() {
        return a.arr;
    }

    public static native void install(String str, int i2);

    @Keep
    public static void onCallFromNative(int i2) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR onCallFromNative index=" + i2);
        dumpAnr(null, i2);
    }

    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            dumpAnr(str, this.mIndex.getAndIncrement());
        }
    }

    private boolean parseTraceFile(String str) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                int i2 = -1;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (PID_PATTERN.matcher(readLine).matches()) {
                            i2 = Integer.parseInt(readLine.split("\\s")[2]);
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
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z = i2 == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException | IOException unused3) {
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.d.b.d(TAG, "ANR watchTraceFile");
        AnonymousClass1 anonymousClass1 = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
            AnonymousClass1(String str, int i2) {
                super(str, 8);
            }

            @Override // android.os.FileObserver
            public final void onEvent(int i2, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = anonymousClass1;
        try {
            anonymousClass1.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.zi()) {
            com.kwad.sdk.core.d.b.d(TAG, "ANR init");
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = new File(this.mLogDir, b.FILE_NAME_BASE);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                install(file2.getPath(), Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }
}
