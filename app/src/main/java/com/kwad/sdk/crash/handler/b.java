package com.kwad.sdk.crash.handler;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class b {
    private static final int REAL_TIME_UPLOAD_THRESHOLD = 2;
    public static final String TAG = "ANR_Native_ExceptionHandler";
    public static File sBackupDir;
    protected File mDumpDir;
    protected f mExceptionListener;
    protected AtomicInteger mIndex = new AtomicInteger();
    protected File mJavaTraceFile;
    protected File mLogDir;
    protected File mLogcatFile;
    protected File mMemoryInfoFile;
    protected File mMessageFile;
    protected e mUploader;
    public static final String FILE_NAME_BASE = getBaseDir();
    public static AtomicBoolean isExceptionHappened = new AtomicBoolean(false);
    public static String sCrashingPid = "#####";

    /* renamed from: com.kwad.sdk.crash.handler.b$1 */
    public class AnonymousClass1 implements FileFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file.getName().endsWith(".dump");
        }
    }

    private static String getBaseDir() {
        try {
            Context context = com.kwad.sdk.crash.e.Jk().getContext();
            if (context == null) {
                com.kwad.sdk.core.d.c.e(TAG, "getBaseDir() but getInstance().getContext() is null");
                context = w.By();
            }
            if (context == null) {
                com.kwad.sdk.core.d.c.e(TAG, "getBaseDir() but context is null");
                return UUID.randomUUID().toString();
            }
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName) && !SystemUtil.isInMainProcess(context)) {
                if (processName != null) {
                    if (processName.startsWith(context.getPackageName() + ":")) {
                        processName = processName.substring(context.getPackageName().length() + 1);
                    }
                }
                return processName + "-" + Process.myPid() + "-" + UUID.randomUUID().toString();
            }
            processName = "main";
            return processName + "-" + Process.myPid() + "-" + UUID.randomUUID().toString();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.T(TAG, Log.getStackTraceString(th2));
            return UUID.randomUUID().toString();
        }
    }

    public static void initBackupDir(File file) {
        sBackupDir = file;
        if (file.exists()) {
            return;
        }
        sBackupDir.mkdirs();
    }

    public void backupLogFiles(File file) {
        File file2 = sBackupDir;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            sBackupDir.mkdirs();
        }
        try {
            u.g(file.getParentFile().getParentFile(), sBackupDir);
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    public f getCrashListener() {
        return this.mExceptionListener;
    }

    public abstract int getCrashType();

    public final e getUploader() {
        return this.mUploader;
    }

    public void init(File file, f fVar, e eVar) {
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        StringBuilder sb2 = new StringBuilder();
        String str = FILE_NAME_BASE;
        sb2.append(str);
        sb2.append("-");
        sb2.append(this.mIndex);
        sb2.append(".dump");
        this.mDumpDir = new File(file2, sb2.toString());
        this.mLogcatFile = new File(this.mLogDir, str + "-" + this.mIndex + ".log");
        this.mJavaTraceFile = new File(this.mLogDir, str + "-" + this.mIndex + ".jtrace");
        this.mMemoryInfoFile = new File(this.mLogDir, str + "-" + this.mIndex + ".minfo");
        this.mExceptionListener = fVar;
        this.mUploader = eVar;
    }

    public abstract void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void uploadRemainingExceptions() {
        File[] listFiles = this.mLogDir.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.handler.b.1
            public AnonymousClass1() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file.getName().endsWith(".dump");
            }
        });
        if (listFiles == null || listFiles.length <= 2) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(listFiles.length);
        reportException(listFiles, countDownLatch);
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }
}
