package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class d {
    protected String mErrorMessage = "";
    protected e mUploader;

    /* renamed from: com.kwad.sdk.crash.report.d$1 */
    final class AnonymousClass1 implements FileFilter {
        AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file.getName().endsWith(".dump");
        }
    }

    private void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "compressAndUpload");
        File zu = this.mUploader.zu();
        if (!zu.exists()) {
            zu.mkdir();
        }
        File file = new File(zu, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        com.kwad.sdk.core.d.b.d("ExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        m.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() <= 0) {
            q.N(file);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
        new JSONObject(hashMap);
        b(file, countDownLatch);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static void a(File file, ExceptionMessage exceptionMessage) {
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
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader3;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e4);
        }
    }

    @SuppressLint({"CheckResult"})
    private static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    private static String dS(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    protected abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        String dW = com.kwad.sdk.crash.utils.g.dW(file.getPath());
        File file2 = new File(dW + ".msg");
        File file3 = new File(dW + ".log");
        File file4 = new File(dW + ".blog");
        File file5 = new File(dW + ".jtrace");
        File file6 = new File(dW + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage a2 = a(file, file2, file3, dW);
            if (a2 == null) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        q.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "message.mCrashSource=" + a2.mCrashSource);
            if (a2.mCrashSource == 2) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        q.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a2, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", " java crash 不上传文件");
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        q.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.z(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                if (!it4.next().exists()) {
                    it4.remove();
                }
            }
            File file7 = new File(file.getParentFile().getParent(), "custom");
            if (file7.exists()) {
                for (File file8 : file7.listFiles()) {
                    if (!file8.isDirectory() && (file8.getName().startsWith(a2.mLogUUID) || file8.getName().startsWith(dS(a2.mLogUUID)))) {
                        arrayList.add(file8);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(a2, arrayList2, countDownLatch);
            try {
                q.delete(file.getPath());
                q.delete(file3.getPath());
                q.delete(file4.getPath());
                q.delete(file2.getPath());
                q.delete(file5.getPath());
                q.delete(file6.getPath());
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    q.delete(((File) it5.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.k(th5);
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        q.delete(((File) it6.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th6);
                }
            } catch (Throwable th7) {
                try {
                    q.delete(file.getPath());
                    q.delete(file3.getPath());
                    q.delete(file4.getPath());
                    q.delete(file2.getPath());
                    q.delete(file5.getPath());
                    q.delete(file6.getPath());
                    Iterator it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        q.delete(((File) it7.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    throw th7;
                } catch (Throwable th8) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th8);
                    throw th7;
                }
            }
        }
    }

    protected final void b(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                        if (z || !readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                            if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                if (readLine.contains("dvm_lock_sample")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                        sb2 = new StringBuilder();
                                        sb2.append(readLine);
                                        sb2.append("\n");
                                    } else {
                                        sb2 = new StringBuilder();
                                        sb2.append(exceptionMessage.mLockInfo);
                                        sb2.append(readLine);
                                        sb2.append("\n");
                                    }
                                    exceptionMessage.mLockInfo = sb2.toString();
                                } else if (readLine.contains("Long monitor")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                        sb3 = new StringBuilder();
                                        sb3.append(readLine);
                                        sb3.append("\n");
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(exceptionMessage.mMonitorInfo);
                                        sb3.append(readLine);
                                        sb3.append("\n");
                                    }
                                    exceptionMessage.mMonitorInfo = sb3.toString();
                                } else if (readLine.contains("Slow Looper")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                        sb4 = new StringBuilder();
                                        sb4.append(readLine);
                                        sb4.append("\n");
                                    } else {
                                        sb4 = new StringBuilder();
                                        sb4.append(exceptionMessage.mSlowLooper);
                                        sb4.append(readLine);
                                        sb4.append("\n");
                                    }
                                    exceptionMessage.mSlowLooper = sb4.toString();
                                } else if (readLine.contains("Slow Operation")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                        sb5 = new StringBuilder();
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    } else {
                                        sb5 = new StringBuilder();
                                        sb5.append(exceptionMessage.mSlowOperation);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                    exceptionMessage.mSlowOperation = sb5.toString();
                                }
                            }
                            if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                sb = new StringBuilder();
                                sb.append(readLine);
                                sb.append("\n");
                            } else {
                                sb = new StringBuilder();
                                sb.append(exceptionMessage.mGCInfo);
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            exceptionMessage.mGCInfo = sb.toString();
                        } else {
                            exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                            z = true;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"CheckResult"})
    public final void x(File file) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            AnonymousClass1() {
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
}
