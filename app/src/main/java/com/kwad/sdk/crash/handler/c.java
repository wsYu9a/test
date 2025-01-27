package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class c extends b {

    public static class a {
        private static final c aKu = new c((byte) 0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c Jz() {
        return a.aKu;
    }

    public final void a(@NonNull Throwable th2, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th2, exceptionMessage, context, ((f) ServiceProvider.get(f.class)).zB());
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, com.kwad.sdk.crash.f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.Jk().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }

    private c() {
    }

    private void a(@NonNull Throwable th2, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context, boolean z10) {
        boolean z11;
        int andIncrement = this.mIndex.getAndIncrement();
        File file = this.mDumpDir;
        File file2 = this.mLogcatFile;
        File file3 = this.mJavaTraceFile;
        File file4 = this.mMemoryInfoFile;
        e uploader = getUploader();
        try {
            exceptionMessage.mCrashDetail = th2.toString();
            if (this.mLogDir.exists() || this.mLogDir.mkdirs()) {
                z11 = true;
            } else {
                exceptionMessage.mErrorMessage += "create " + Jz().mLogDir.getPath() + " failed!\n";
                z11 = false;
            }
            if (file == null || andIncrement != 0) {
                try {
                    file = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".dump");
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        exceptionMessage.mErrorMessage += th;
                        try {
                            String jSONObject = exceptionMessage.toJson().toString();
                            if (!z11) {
                                if (uploader != null) {
                                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                    CountDownLatch countDownLatch = z10 ? new CountDownLatch(1) : null;
                                    uploader.a(exceptionMessage, countDownLatch);
                                    exceptionMessage.toString();
                                    if (countDownLatch != null) {
                                        try {
                                            countDownLatch.await(5L, TimeUnit.SECONDS);
                                            return;
                                        } catch (InterruptedException unused) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            g.a(file, jSONObject);
                            g.H(file3);
                            g.F(file2);
                            if (com.kwad.sdk.crash.e.Jk().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                exceptionMessage.toString();
                                if (z10) {
                                    CountDownLatch countDownLatch2 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch2);
                                    try {
                                        countDownLatch2.await(5L, TimeUnit.SECONDS);
                                    } catch (InterruptedException unused2) {
                                    }
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.I(file4);
                            return;
                        } catch (Throwable th4) {
                            if (uploader != null) {
                                try {
                                    g.r(th4);
                                    return;
                                } catch (Exception unused3) {
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Throwable th5) {
                        try {
                            String jSONObject2 = exceptionMessage.toJson().toString();
                            if (!z11) {
                                if (uploader != null) {
                                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                    CountDownLatch countDownLatch3 = z10 ? new CountDownLatch(1) : null;
                                    uploader.a(exceptionMessage, countDownLatch3);
                                    exceptionMessage.toString();
                                    if (countDownLatch3 != null) {
                                        try {
                                            countDownLatch3.await(5L, TimeUnit.SECONDS);
                                            throw th5;
                                        } catch (InterruptedException | Exception unused4) {
                                            throw th5;
                                        }
                                    }
                                    throw th5;
                                }
                                throw th5;
                            }
                            g.a(file, jSONObject2);
                            g.H(file3);
                            g.F(file2);
                            if (com.kwad.sdk.crash.e.Jk().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                exceptionMessage.toString();
                                if (z10) {
                                    CountDownLatch countDownLatch4 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch4);
                                    try {
                                        countDownLatch4.await(5L, TimeUnit.SECONDS);
                                    } catch (InterruptedException unused5) {
                                    }
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.I(file4);
                            throw th5;
                        } catch (Throwable th6) {
                            if (uploader != null) {
                                g.r(th6);
                                throw th5;
                            }
                            throw th5;
                        }
                    }
                }
            }
            if (file2 == null || andIncrement != 0) {
                file2 = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".log");
            }
            if (file3 == null || andIncrement != 0) {
                file3 = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".jtrace");
            }
            if (file4 == null || andIncrement != 0) {
                file4 = new File(this.mLogDir, b.FILE_NAME_BASE + "-" + andIncrement + ".minfo");
            }
            g.b(th2, exceptionMessage, context);
            g.a(exceptionMessage, getCrashType());
            com.kwad.sdk.crash.f fVar = this.mExceptionListener;
            if (fVar != null) {
                fVar.a(getCrashType(), exceptionMessage);
            }
            try {
                String jSONObject3 = exceptionMessage.toJson().toString();
                if (!z11) {
                    if (uploader != null) {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                        CountDownLatch countDownLatch5 = z10 ? new CountDownLatch(1) : null;
                        uploader.a(exceptionMessage, countDownLatch5);
                        exceptionMessage.toString();
                        if (countDownLatch5 != null) {
                            try {
                                countDownLatch5.await(5L, TimeUnit.SECONDS);
                                return;
                            } catch (InterruptedException unused6) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                g.a(file, jSONObject3);
                g.H(file3);
                g.F(file2);
                if (com.kwad.sdk.crash.e.Jk().isDebug()) {
                    backupLogFiles(this.mLogDir);
                }
                if (uploader != null) {
                    exceptionMessage.toString();
                    if (z10) {
                        CountDownLatch countDownLatch6 = new CountDownLatch(1);
                        reportException(new File[]{file}, countDownLatch6);
                        try {
                            countDownLatch6.await(5L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused7) {
                        }
                    } else {
                        uploadRemainingExceptions();
                    }
                }
                g.I(file4);
            } catch (Throwable th7) {
                if (uploader != null) {
                    try {
                        g.r(th7);
                    } catch (Exception unused8) {
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
            z11 = true;
        }
    }
}
