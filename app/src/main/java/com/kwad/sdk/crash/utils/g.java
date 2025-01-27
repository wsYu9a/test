package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.w;
import com.sigmob.sdk.base.mta.PointCategory;
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
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class g {
    private static final String TAG = "g";
    private static final File aMp = new File("/proc/self/fd");
    private static final File aMq = new File("/proc/self/task");

    /* renamed from: com.kwad.sdk.crash.utils.g$1 */
    public class AnonymousClass1 implements Comparator<ThreadInfo> {
        private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
            return threadInfo.mName.compareTo(threadInfo2.mName);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
            return a(threadInfo, threadInfo2);
        }
    }

    private g() {
    }

    public static void F(File file) {
        try {
            d.a(SystemUtil.el(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.f.ax, "-b", PointCategory.CRASH, "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.f.ax, "-d", "-f", file.getPath()}, 0);
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    public static void G(File file) {
        if (file == null) {
            return;
        }
        try {
            u.U(file);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    public static void H(File file) {
        try {
            u.Q(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String b10 = b(entry.getValue());
                            if (b10.isEmpty()) {
                                b10 = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(b10);
                            bufferedWriter2.newLine();
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e11) {
                        e = e11;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e14) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e14);
        }
    }

    public static void I(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = w.getField(w.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.el(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.el(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                w.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.el(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                w.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.el(19)) {
                Boolean bool5 = Boolean.TRUE;
                w.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.el(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            w.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.Jk().getContext())});
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    private static int JU() {
        File[] listFiles;
        File file = aMp;
        au.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    public static void a(ExceptionMessage exceptionMessage, int i10) {
        com.kwad.sdk.crash.h Jq = com.kwad.sdk.crash.e.Jk().Jq();
        if (Jq == null) {
            com.kwad.sdk.core.d.c.d(TTDownloadField.TT_TAG, "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = Jq.nQ().toString();
        }
    }

    private static double aF(long j10) {
        return BigDecimal.valueOf((j10 >> 20) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String aj(@NonNull String str, String str2) {
        au.gV(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    public static void b(@Nullable Throwable th2, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th2 != null) {
            b(th2, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th2, exceptionMessage);
        }
    }

    private static String bO(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStream)).getString(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID);
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return "";
        } catch (JSONException e11) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e11);
            return "";
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return "";
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static String bP(Context context) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.Jk().getSdkVersion() + "\n");
            sb2.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb2.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb2.append("DexPath: " + bQ(context) + "\n");
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
        return sb2.toString();
    }

    private static String bQ(Context context) {
        StringBuilder sb2 = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb3 = new StringBuilder("ClassLoader ");
            int i10 = 0;
            sb3.append(0);
            sb3.append(" : ");
            sb3.append(obj);
            sb2.append(sb3.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i10++;
                sb2.append("\nClassLoader " + i10 + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb2.append("\n====path: " + split[1] + ", length: " + fZ(split[1]));
                }
            }
        }
        return sb2.toString();
    }

    public static void d(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            u.Q(file);
            u.Q(file2);
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
                            } catch (FileNotFoundException e10) {
                                e = e10;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e11) {
                                e = e11;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e12) {
                        e = e12;
                    } catch (IOException e13) {
                        e = e13;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                    bufferedReader = null;
                } catch (IOException e15) {
                    e = e15;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e16) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e16);
        }
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.Jk().Jn();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.Jk().getSdkVersion();
    }

    public static String fX(String str) {
        return str.contains(p1.b.f29697h) ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String fY(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long fZ(String str) {
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

    private static String ga(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append("\n");
        }
        return sb2.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean q(@Nullable Throwable th2) {
        if (th2 == null) {
            return false;
        }
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        return th2 instanceof OutOfMemoryError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String r(Throwable th2) {
        String th3 = th2.toString();
        PrintWriter printWriter = null;
        try {
            try {
                StringWriter stringWriter = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter);
                    f.a(th2, printWriter);
                    th3 = stringWriter.toString();
                    b.closeQuietly(stringWriter);
                } catch (Exception e10) {
                    e = e10;
                    printWriter = stringWriter;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    b.closeQuietly(printWriter);
                    return th3;
                } catch (Throwable th4) {
                    th = th4;
                    printWriter = stringWriter;
                    b.closeQuietly(printWriter);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
            return th3;
        } catch (Throwable th5) {
            th = th5;
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
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.Jk().Jr();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.Jk().Jo()));
        exceptionMessage.mBuildConfigInfo = bP(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bO(context);
    }

    private static void b(@NonNull Throwable th2, @NonNull ExceptionMessage exceptionMessage) {
        String r10 = r(th2);
        if (th2 instanceof StackOverflowError) {
            r10 = ga(r10);
        }
        exceptionMessage.mCrashDetail = r10.replaceAll("[\n\t]", "#");
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!com.kwad.sdk.crash.d.aJZ.matcher(absolutePath).matches() && !com.kwad.sdk.crash.d.aKa.matcher(absolutePath).matches()) {
            Matcher matcher = com.kwad.sdk.crash.d.aKb.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.aKc.matcher(absolutePath);
            if (matcher.matches()) {
                exceptionMessage.mVirtualApp = matcher.group(1);
                return;
            } else if (matcher2.matches()) {
                exceptionMessage.mVirtualApp = matcher2.group(1);
                return;
            } else {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            }
        }
        exceptionMessage.mVirtualApp = context.getPackageName();
    }

    private static void a(Throwable th2, ExceptionMessage exceptionMessage) {
        if (q(th2) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.a OQ = SystemUtil.OQ();
        OQ.aVb = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        OQ.aUX = SystemUtil.OP();
        long pss = Debug.getPss();
        OQ.aVa = pss;
        memoryInfo.mTotalMB = (int) (OQ.aUX / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aJY / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (OQ.aVb / 1048576);
        memoryInfo.mVssMB = (int) (OQ.aUY / 1024);
        memoryInfo.mRssMB = (int) (OQ.aUZ / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = OQ.mThreadsCount;
        memoryInfo.mFdCount = JU();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.dp(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = aMp.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        memoryInfo.mFds.add(Os.readlink(file.getPath()));
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (OQ.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
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

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static boolean b(com.kwad.sdk.crash.model.b bVar) {
        boolean z10 = (bVar.aKD & 2) != 0;
        com.kwad.sdk.core.d.c.d(TAG, "isNativeOpen:" + z10);
        return z10;
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = aMq.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.J(new File(file, "comm"));
            } catch (IOException e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = aj(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = aF(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(1024L)) {
                diskInfo.mDataAvailableGB = aF(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = aF(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = aF(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) {
        String readLine;
        try {
            u.Q(file);
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
                            } catch (FileNotFoundException e10) {
                                e = e10;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e11) {
                                e = e11;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    b.closeQuietly(bufferedReader2);
                } catch (FileNotFoundException e12) {
                    e = e12;
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e14) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e14);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, boolean z10) {
        a(file, charSequence, Charset.defaultCharset(), z10);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z10) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z10);
    }

    private static void a(File file, String str, Charset charset, boolean z10) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = u.a(file, z10);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        } finally {
            b.closeQuietly(fileOutputStream);
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return false;
        }
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i10) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append("at ");
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        return sb2.substring(0);
    }

    public static boolean a(com.kwad.sdk.crash.model.b bVar) {
        boolean z10 = (bVar.aKD & 1) != 0;
        com.kwad.sdk.core.d.c.d(TAG, "isAnrOpen:" + z10);
        return z10;
    }
}
