package com.umeng.commonsdk.framework;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bi;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import m5.d;
import p1.b;

/* loaded from: classes4.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static String mDefaultEnvelopeDir = bd.b().b(bd.f23521a);
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    /* renamed from: com.umeng.commonsdk.framework.UMFrUtils$1 */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.UMFrUtils$2 */
    public static class AnonymousClass2 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r2.getPackageManager().checkPermission(r8, r2.getPackageName()) == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(r7, r8)).intValue() == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean checkPermission(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L4c
            android.content.Context r2 = r7.getApplicationContext()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 < r4) goto L39
            java.lang.String r3 = "android.content.Context"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "checkSelfPermission"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L34
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r1] = r6     // Catch: java.lang.Throwable -> L34
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L34
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L34
            r4[r1] = r8     // Catch: java.lang.Throwable -> L34
            java.lang.Object r7 = r3.invoke(r7, r4)     // Catch: java.lang.Throwable -> L34
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Throwable -> L34
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> L34
            if (r7 != 0) goto L31
            goto L32
        L31:
            r0 = 0
        L32:
            r1 = r0
            goto L4c
        L34:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r2, r7)
            goto L4c
        L39:
            android.content.pm.PackageManager r7 = r2.getPackageManager()     // Catch: java.lang.Throwable -> L48
            java.lang.String r3 = r2.getPackageName()     // Catch: java.lang.Throwable -> L48
            int r7 = r7.checkPermission(r8, r3)     // Catch: java.lang.Throwable -> L48
            if (r7 != 0) goto L31
            goto L32
        L48:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r2, r7)
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    try {
                        if (file.isDirectory() && (list = file.list()) != null) {
                            return list.length;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    String processName2 = getProcessName(Process.myPid());
                    if (!TextUtils.isEmpty(processName2)) {
                        sCurrentProcessName = processName2;
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th2);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j10, long j11) {
        return (j10 < j11 ? j11 - j10 : j10 - j11) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + b.f29697h + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } finally {
                return mDefaultEnvelopeDirPath;
            }
        }
        return mDefaultEnvelopeDirPath;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(File file2, File file22) {
                            long lastModified = file2.lastModified() - file22.lastModified();
                            if (lastModified > 0) {
                                return 1;
                            }
                            return lastModified == 0 ? 0 : -1;
                        }
                    });
                    return listFiles[0];
                }
                return null;
            } finally {
            }
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j10;
        synchronized (mEnvelopeBuildTimeLock) {
            j10 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j10;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j10;
        synchronized (mEnvelopeBuildTimeLock) {
            j10 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j10;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String b10 = bd.b().b(bd.B);
                String replace = currentProcessName.replace(d.f28378d, '_');
                ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return b10 + replace;
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
        return mDefaultEnvelopeDir;
    }

    private static String getProcessName(int i10) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i10 + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return readLine;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static String getSubProcessName(Context context) {
        String str;
        str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(":");
            str = indexOf >= 0 ? currentProcessName.substring(indexOf + 1) : "";
            if (indexOf < 0) {
                String packageName = context.getPackageName();
                return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th2);
        }
        return str;
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        File[] listFiles;
        String str = uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL ? "i" : "a";
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = bt.aJ;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = "h";
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        File file = new File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                listFiles = file.listFiles();
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            } finally {
            }
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().startsWith(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, g.f11101b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th2);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                if (file != null) {
                    try {
                        if (file.exists()) {
                            return file.delete();
                        }
                    } catch (Throwable th2) {
                        UMCrashManager.reportCrash(appContext, th2);
                    }
                }
                return true;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i10) {
        File[] listFiles;
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                listFiles = file.listFiles();
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            } finally {
            }
            if (listFiles != null && listFiles.length > i10) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file22) {
                        long lastModified = file2.lastModified() - file22.lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        return lastModified == 0 ? 0 : -1;
                    }
                });
                if (listFiles.length > i10) {
                    for (int i11 = 0; i11 < listFiles.length - i10; i11++) {
                        if (!listFiles[i11].delete()) {
                            ULog.d("--->>> remove [" + i11 + "] file fail.");
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + File.separator + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.close();
                            boolean a10 = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                            boolean b10 = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                            if (a10) {
                                updateLastSuccessfulBuildTime(context);
                            }
                            if (b10) {
                                updateLastInstantBuildTime(context);
                            }
                            return 0;
                        } catch (IOException e10) {
                            e = e10;
                            fileOutputStream = fileOutputStream2;
                            UMCrashManager.reportCrash(context, e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    UMCrashManager.reportCrash(context, th2);
                                }
                            }
                            return 101;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th4) {
                                    UMCrashManager.reportCrash(context, th4);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
        if (TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + bi.f10814j + legacyEnvelopeDir);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                try {
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    UMCrashManager.reportCrash(context, th3);
                    return;
                }
            }
            try {
                String envelopeDirPath = getEnvelopeDirPath(context);
                for (int i10 = 0; i10 < listFiles.length; i10++) {
                    listFiles[i10].renameTo(new File(envelopeDirPath + File.separator + listFiles[i10].getName()));
                }
                if (file.isDirectory()) {
                    file.delete();
                    return;
                }
                return;
            } catch (Throwable th4) {
                UMCrashManager.reportCrash(context, th4);
                return;
            }
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            FileChannel fileChannel = null;
            try {
                try {
                    fileChannel = new RandomAccessFile(str, t.f11211k).getChannel();
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                    bArr = new byte[(int) fileChannel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                } catch (IOException e10) {
                    UMCrashManager.reportCrash(appContext, e10);
                    throw e10;
                }
            } finally {
                try {
                    fileChannel.close();
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(appContext, th2);
                }
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
