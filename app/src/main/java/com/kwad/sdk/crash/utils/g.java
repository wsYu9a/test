package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.s;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g {
    private static final File atd = new File("/proc/self/fd");
    private static final File ate = new File("/proc/self/task");

    /* renamed from: com.kwad.sdk.crash.utils.g$1 */
    static class AnonymousClass1 implements Comparator<ThreadInfo> {
        AnonymousClass1() {
        }

        private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
            return threadInfo.mName.compareTo(threadInfo2.mName);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
            return a(threadInfo, threadInfo2);
        }
    }

    public static void A(File file) {
        if (file == null) {
            return;
        }
        try {
            q.O(file);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static int Ak() {
        File[] listFiles;
        File file = atd;
        ao.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static void B(File file) {
        try {
            q.K(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String b2 = b(entry.getValue());
                            if (b2.isEmpty()) {
                                b2 = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(b2);
                            bufferedWriter2.newLine();
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e6);
        }
    }

    public static void C(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object d2 = s.d(s.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.ch(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.ch(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                s.a(d2, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.ch(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                s.a(d2, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.ch(19)) {
                Boolean bool5 = Boolean.TRUE;
                s.a(d2, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.ch(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            s.a(d2, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.zy().getContext())});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static String T(@NonNull String str, String str2) {
        ao.eK(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    private static double X(long j2) {
        return BigDecimal.valueOf((j2 >> 20) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i2) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    public static void a(ExceptionMessage exceptionMessage, int i2) {
        com.kwad.sdk.crash.h zE = com.kwad.sdk.crash.e.zy().zE();
        if (zE == null) {
            com.kwad.sdk.core.d.b.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = zE.mA().toString();
        }
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.zy().zF();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.zy().zC()));
        exceptionMessage.mBuildConfigInfo = bp(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bo(context);
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = X(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
                diskInfo.mDataAvailableGB = X(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = X(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = X(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        List<String> list;
        String canonicalPath;
        SystemUtil.a EB = SystemUtil.EB();
        EB.aAS = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        EB.aAO = SystemUtil.EA();
        long pss = Debug.getPss();
        EB.aAR = pss;
        memoryInfo.mTotalMB = (int) (EB.aAO / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aqZ / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (EB.aAS / 1048576);
        memoryInfo.mVssMB = (int) (EB.aAP / 1024);
        memoryInfo.mRssMB = (int) (EB.aAQ / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = EB.mThreadsCount;
        memoryInfo.mFdCount = Ak();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.cP(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = atd.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            list = memoryInfo.mFds;
                            canonicalPath = Os.readlink(file.getPath());
                        } else {
                            list = memoryInfo.mFds;
                            canonicalPath = file.getCanonicalPath();
                        }
                        list.add(canonicalPath);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (EB.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                AnonymousClass1() {
                }

                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = ate.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.D(new File(file, "comm"));
            } catch (IOException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = T(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) {
        String readLine;
        try {
            q.K(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    b.closeQuietly(bufferedReader2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e6);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void a(File file, CharSequence charSequence, boolean z) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    private static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = q.a(file, z);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        } finally {
            b.closeQuietly(fileOutputStream);
        }
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (j(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return false;
        }
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        String packageName;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (com.kwad.sdk.crash.d.ara.matcher(absolutePath).matches() || com.kwad.sdk.crash.d.arb.matcher(absolutePath).matches()) {
            packageName = context.getPackageName();
        } else {
            Matcher matcher = com.kwad.sdk.crash.d.arc.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.ard.matcher(absolutePath);
            if (matcher.matches()) {
                packageName = matcher.group(1);
            } else {
                if (!matcher2.matches()) {
                    exceptionMessage.mVirtualApp = absolutePath;
                    return;
                }
                packageName = matcher2.group(1);
            }
        }
        exceptionMessage.mVirtualApp = packageName;
    }

    public static void b(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            q.K(file);
            q.K(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter2.write(readLine);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    bufferedReader = null;
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e8) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e8);
        }
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String k = k(th);
        if (th instanceof StackOverflowError) {
            k = dZ(k);
        }
        exceptionMessage.mCrashDetail = k.replaceAll("[\n\t]", "#");
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    private static String bo(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStream)).getString(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return "";
        } catch (JSONException e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return "";
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static String bp(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.zy().getSdkVersion() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + bq(context) + "\n");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return sb.toString();
    }

    private static String bq(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i2 = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(obj);
            while (true) {
                sb.append(sb2.toString());
                if (classLoader.getParent() == null) {
                    break;
                }
                classLoader = classLoader.getParent();
                i2++;
                sb2 = new StringBuilder("\nClassLoader ");
                sb2.append(i2);
                sb2.append(" : ");
                sb2.append(classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + dY(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static String dW(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String dX(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long dY(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static String dZ(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        return sb.substring(0);
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.zy().zB();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.zy().getSdkVersion();
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean j(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String k(Throwable th) {
        String th2 = th.toString();
        PrintWriter printWriter = null;
        try {
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter);
                    f.a(th, printWriter);
                    th2 = stringWriter.toString();
                    b.closeQuietly(stringWriter);
                } catch (Exception e2) {
                    e = e2;
                    printWriter = stringWriter;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    b.closeQuietly(printWriter);
                    return th2;
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = stringWriter;
                    b.closeQuietly(printWriter);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            return th2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void z(File file) {
        try {
            d.a(SystemUtil.ch(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.d.ar, "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.d.ar, "-d", "-f", file.getPath()}, 0);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }
}
