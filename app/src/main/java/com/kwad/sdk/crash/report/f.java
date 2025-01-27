package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class f extends d {

    /* renamed from: com.kwad.sdk.crash.report.f$1 */
    public class AnonymousClass1 implements FileFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file.getName().endsWith(".dump");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void b(File file, ExceptionMessage exceptionMessage) {
        String readLine;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            readLine = bufferedReader3.readLine();
                            if (readLine == 0) {
                                break;
                            }
                            if (readLine.isEmpty()) {
                                arrayList.add(threadInfo);
                                threadInfo = new ThreadInfo();
                            } else {
                                if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                                    threadInfo.mName = readLine;
                                }
                                if (threadInfo.mTrace == null) {
                                    str = readLine;
                                } else {
                                    str = threadInfo.mTrace + readLine;
                                }
                                threadInfo.mTrace = str;
                                threadInfo.mTrace += "#";
                            }
                        }
                        memoryInfo.mJavaThreads = arrayList;
                        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader3);
                        bufferedReader = readLine;
                    } catch (IOException e10) {
                        e = e10;
                        bufferedReader2 = bufferedReader3;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e12);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.f.1
            public AnonymousClass1() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.sdk.crash.model.message.ExceptionMessage a(@androidx.annotation.NonNull java.io.File r8, java.io.File r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.f.a(java.io.File, java.io.File, java.lang.String):com.kwad.sdk.crash.model.message.ExceptionMessage");
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        String fX = com.kwad.sdk.crash.utils.g.fX(file.getPath());
        File file2 = new File(fX + ".msg");
        File file3 = new File(fX + ".log");
        File file4 = new File(fX + ".blog");
        File file5 = new File(fX + ".jtrace");
        File file6 = new File(fX + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage a10 = a(file, file3, fX);
            if (a10 == null) {
                try {
                    return;
                } catch (Throwable th2) {
                    return;
                }
            }
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", "message.mCrashSource=" + a10.mCrashSource);
            if (a10.mCrashSource == 2) {
                try {
                    u.delete(file.getPath());
                    u.delete(file3.getPath());
                    u.delete(file4.getPath());
                    u.delete(file2.getPath());
                    u.delete(file5.getPath());
                    u.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        u.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
                    return;
                }
            }
            this.mUploader.a(a10, countDownLatch);
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", " java crash 不上传文件");
            try {
                u.delete(file.getPath());
                u.delete(file3.getPath());
                u.delete(file4.getPath());
                u.delete(file2.getPath());
                u.delete(file5.getPath());
                u.delete(file6.getPath());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    u.delete(((File) it2.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.r(th5);
                try {
                    u.delete(file.getPath());
                    u.delete(file3.getPath());
                    u.delete(file4.getPath());
                    u.delete(file2.getPath());
                    u.delete(file5.getPath());
                    u.delete(file6.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        u.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th6);
                }
            } finally {
                try {
                    u.delete(file.getPath());
                    u.delete(file3.getPath());
                    u.delete(file4.getPath());
                    u.delete(file2.getPath());
                    u.delete(file5.getPath());
                    u.delete(file6.getPath());
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        u.delete(((File) it4.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th22) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th22);
                }
            }
        }
    }
}
