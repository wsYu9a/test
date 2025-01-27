package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.u;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class d {
    protected e mUploader;
    protected String mErrorMessage = "";
    private final ConcurrentHashMap<String, Pattern> aLG = new ConcurrentHashMap<>();

    /* renamed from: com.kwad.sdk.crash.report.d$1 */
    public class AnonymousClass1 implements FileFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException file =" + file.getName());
            return file.isDirectory();
        }
    }

    @SuppressLint({"CheckResult"})
    private static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    public static String fT(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    @SuppressLint({"CheckResult"})
    public void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            public AnonymousClass1() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException file =" + file2.getName());
                return file2.isDirectory();
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    public abstract ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final Pattern fS(String str) {
        if (!this.aLG.containsKey(str)) {
            if (str.equals(".*at\\s+(.*)\\.(.*)\\(((.*):(-?\\d+)|Native method)\\)") || str.equals(".*(Mterp|ExecuteMterp|(art::|_ZN3art11)(interpreter|.*Invoke)|art_?interpreter|art_?quick|ZN3art9ArtMethod6Invoke|art::ArtMethod::Invoke).*")) {
                this.aLG.put(str, Pattern.compile(str, 66));
            } else {
                this.aLG.put(str, Pattern.compile(str));
            }
        }
        return this.aLG.get(str);
    }

    public void a(File file, @Nullable CountDownLatch countDownLatch) {
        ArrayList arrayList;
        int i10 = 0;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadExceptionEventAndLog dumpFile=" + file.getPath());
        File file2 = new File(file, com.sigmob.sdk.archives.d.f17513c);
        File file3 = new File(file, b7.d.f1362o);
        File file4 = new File(file, "log");
        File file5 = new File(file, "logcat");
        File file6 = new File(file, "logcat_backup");
        File file7 = new File(file, "message_parsed");
        ArrayList arrayList2 = new ArrayList();
        try {
            ExceptionMessage a10 = a(file2, file3, file4, file5, file);
            if (a10 == null) {
                try {
                    u.delete(file2.getPath());
                    u.delete(file4.getPath());
                    u.delete(file6.getPath());
                    u.delete(file3.getPath());
                    u.delete(file7.getPath());
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        u.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    u.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    return;
                }
            }
            File file8 = new File(file, "anr_happened");
            if (file.getPath().contains("anr_log") && Build.VERSION.SDK_INT > 33 && !file8.exists()) {
                com.kwad.sdk.core.d.c.w("AnrAndNativeAdExceptionCollector", "not real anr");
                try {
                    u.delete(file2.getPath());
                    u.delete(file4.getPath());
                    u.delete(file6.getPath());
                    u.delete(file3.getPath());
                    u.delete(file7.getPath());
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        u.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    u.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "message.mCrashSource=" + a10.mCrashSource);
            if (a10.mCrashSource == 2) {
                try {
                    u.delete(file2.getPath());
                    u.delete(file4.getPath());
                    u.delete(file6.getPath());
                    u.delete(file3.getPath());
                    u.delete(file7.getPath());
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        u.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    u.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th4) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
                    return;
                }
            }
            this.mUploader.a(a10, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", " java crash 不上传文件");
                try {
                    u.delete(file2.getPath());
                    u.delete(file4.getPath());
                    u.delete(file6.getPath());
                    u.delete(file3.getPath());
                    u.delete(file7.getPath());
                    Iterator it4 = arrayList2.iterator();
                    while (it4.hasNext()) {
                        u.delete(((File) it4.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    u.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th5) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.F(file6);
            List<File> arrayList3 = new ArrayList<>();
            Collections.addAll(arrayList3, file4, file6);
            Iterator<File> it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                if (!it5.next().exists()) {
                    it5.remove();
                }
            }
            File file9 = new File(file2.getParentFile().getParent(), "custom");
            if (file9.exists()) {
                File[] listFiles = file9.listFiles();
                int length = listFiles.length;
                while (i10 < length) {
                    File file10 = listFiles[i10];
                    if (file10.isDirectory() || !(file10.getName().startsWith(a10.mLogUUID) || file10.getName().startsWith(fT(a10.mLogUUID)))) {
                        arrayList = arrayList2;
                    } else {
                        arrayList = arrayList2;
                        try {
                            arrayList.add(file10);
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                com.kwad.sdk.core.d.c.e("AnrAndNativeAdExceptionCollector", Log.getStackTraceString(th));
                                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                                com.kwad.sdk.crash.utils.g.r(th);
                                try {
                                    u.delete(file2.getPath());
                                    u.delete(file4.getPath());
                                    u.delete(file6.getPath());
                                    u.delete(file3.getPath());
                                    u.delete(file7.getPath());
                                    Iterator it6 = arrayList.iterator();
                                    while (it6.hasNext()) {
                                        u.delete(((File) it6.next()).getPath());
                                    }
                                    com.kwad.sdk.crash.utils.g.G(file);
                                    u.delete(file.getPath());
                                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                                    return;
                                } catch (Throwable th7) {
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th7);
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                }
                arrayList = arrayList2;
                arrayList3.addAll(arrayList);
            } else {
                arrayList = arrayList2;
            }
            a(a10, arrayList3, countDownLatch);
            try {
                u.delete(file2.getPath());
                u.delete(file4.getPath());
                u.delete(file6.getPath());
                u.delete(file3.getPath());
                u.delete(file7.getPath());
                Iterator it7 = arrayList.iterator();
                while (it7.hasNext()) {
                    u.delete(((File) it7.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.G(file);
                u.delete(file.getPath());
                com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th8) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th8);
            }
        } catch (Throwable th9) {
            th = th9;
            arrayList = arrayList2;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "compressAndUpload");
        File Jf = this.mUploader.Jf();
        if (!Jf.exists()) {
            Jf.mkdir();
        }
        File file = new File(Jf, exceptionMessage.mLogUUID + p1.a.f29680b);
        StringBuilder sb2 = new StringBuilder("compressAndUpload zipFile=");
        sb2.append(file.getPath());
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", sb2.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
        }
        o.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(hashMap);
            b(file, countDownLatch);
            return;
        }
        u.T(file);
    }

    public final void a(String str, Backtrace backtrace, boolean z10) {
        if (backtrace.getFrame() > 256) {
            return;
        }
        JavaBackTraceElement javaBackTraceElement = new JavaBackTraceElement(str, backtrace.getFrame());
        Matcher matcher = fS(".*at\\s+(.*)\\.(.*)\\(((.*):(-?\\d+)|Native method)\\)").matcher(str);
        if (matcher.lookingAt()) {
            javaBackTraceElement.setDeclaringClass(matcher.group(1));
            javaBackTraceElement.setMethodName(matcher.group(2));
            if (matcher.groupCount() >= 5) {
                String group = matcher.group(4);
                if (group != null) {
                    javaBackTraceElement.setFileName(group);
                } else {
                    javaBackTraceElement.setIsNative(true);
                }
                String group2 = matcher.group(5);
                if (group2 != null) {
                    try {
                        javaBackTraceElement.setLineNumber(Long.parseLong(group2));
                    } catch (NumberFormatException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        } else {
            backtrace.getFrame();
            if (str.startsWith("Caused by: ")) {
                javaBackTraceElement.setIsCausedBy(true);
            }
        }
        if (javaBackTraceElement.isTitle() || javaBackTraceElement.isCausedBy() || javaBackTraceElement.isNative()) {
            javaBackTraceElement.setNeedClustering(false);
        }
        backtrace.setFrame(backtrace.getFrame() + 1);
        backtrace.getBacktraces().add(javaBackTraceElement);
    }

    public final void a(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb2;
        StringBuilder sb3;
        String str;
        String str2;
        String str3;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z10 = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!z10 && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z10 = true;
                            } else {
                                if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                    if (readLine.contains("dvm_lock_sample")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                            sb3 = new StringBuilder();
                                            sb3.append(readLine);
                                            sb3.append("\n");
                                        } else {
                                            sb3 = new StringBuilder();
                                            sb3.append(exceptionMessage.mLockInfo);
                                            sb3.append(readLine);
                                            sb3.append("\n");
                                        }
                                        exceptionMessage.mLockInfo = sb3.toString();
                                    } else if (readLine.contains("Long monitor")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                            str = readLine + "\n";
                                        } else {
                                            str = exceptionMessage.mMonitorInfo + readLine + "\n";
                                        }
                                        exceptionMessage.mMonitorInfo = str;
                                    } else if (readLine.contains("Slow Looper")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                            str2 = readLine + "\n";
                                        } else {
                                            str2 = exceptionMessage.mSlowLooper + readLine + "\n";
                                        }
                                        exceptionMessage.mSlowLooper = str2;
                                    } else if (readLine.contains("Slow Operation")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                            str3 = readLine + "\n";
                                        } else {
                                            str3 = exceptionMessage.mSlowOperation + readLine + "\n";
                                        }
                                        exceptionMessage.mSlowOperation = str3;
                                    }
                                }
                                if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                    sb2 = new StringBuilder();
                                    sb2.append(readLine);
                                    sb2.append("\n");
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(exceptionMessage.mGCInfo);
                                    sb2.append(readLine);
                                    sb2.append("\n");
                                }
                                exceptionMessage.mGCInfo = sb2.toString();
                            }
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e11) {
                        e = e11;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
