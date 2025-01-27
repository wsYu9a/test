package com.kwad.sdk.crash.handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class b {
    public static final String FILE_NAME_BASE = UUID.randomUUID().toString();
    private static final int REAL_TIME_UPLOAD_THRESHOLD = 2;
    public static File sBackupDir;
    protected File mDumpFile;
    protected f mExceptionListener;
    protected AtomicInteger mIndex = new AtomicInteger();
    protected File mJavaTraceFile;
    protected File mLogDir;
    protected File mLogFile;
    protected File mMemoryInfoFile;
    protected e mUploader;

    /* renamed from: com.kwad.sdk.crash.handler.b$1 */
    final class AnonymousClass1 implements FileFilter {
        AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file.getName().endsWith(".dump");
        }
    }

    public static void initBackupDir(File file) {
        sBackupDir = file;
        if (file.exists()) {
            return;
        }
        sBackupDir.mkdirs();
    }

    void backupLogFiles(File file) {
        File file2 = sBackupDir;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            sBackupDir.mkdirs();
        }
        try {
            q.e(file.getParentFile().getParentFile(), sBackupDir);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public f getCrashListener() {
        return this.mExceptionListener;
    }

    protected abstract int getCrashType();

    public final e getUploader() {
        return this.mUploader;
    }

    public void init(File file, f fVar, e eVar) {
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        StringBuilder sb = new StringBuilder();
        String str = FILE_NAME_BASE;
        sb.append(str);
        sb.append("-");
        sb.append(this.mIndex);
        sb.append(".dump");
        this.mDumpFile = new File(file2, sb.toString());
        this.mLogFile = new File(this.mLogDir, str + "-" + this.mIndex + ".log");
        this.mJavaTraceFile = new File(this.mLogDir, str + "-" + this.mIndex + ".jtrace");
        this.mMemoryInfoFile = new File(this.mLogDir, str + "-" + this.mIndex + ".minfo");
        this.mExceptionListener = fVar;
        this.mUploader = eVar;
    }

    protected abstract void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    void uploadRemainingExceptions() {
        File[] listFiles = this.mLogDir.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.handler.b.1
            AnonymousClass1() {
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
        } catch (InterruptedException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }
}
