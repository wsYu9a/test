package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class SystemUtil {
    private static long aAK;
    private static long aAL;
    private static int aAM;
    private static LEVEL aAN;

    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        LEVEL(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static class a {
        public long aAO;
        public long aAP;
        public long aAQ;
        public long aAR;
        public long aAS;
        public int mThreadsCount;
    }

    public static long EA() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static a EB() {
        String ai;
        a aVar = new a();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", com.kuaishou.weapon.p0.t.k);
            while (true) {
                try {
                    String readLine = randomAccessFile2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                            String ai2 = ai(readLine, "VmSize");
                            if (ai2 != null) {
                                aVar.aAP = Long.valueOf(ai2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String ai3 = ai(readLine, "VmRSS:");
                            if (ai3 != null) {
                                aVar.aAQ = Long.valueOf(ai3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (ai = ai(readLine, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(ai).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    return aVar;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return aVar;
    }

    private static String ai(String str, String str2) {
        int length = str2.length();
        int i2 = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (i2 != -1) {
                    break;
                }
            } else if (i2 == -1) {
                i2 = length;
            }
            length++;
        }
        if (i2 == -1) {
            return null;
        }
        return length == -1 ? str.substring(i2) : str.substring(i2, length);
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static boolean cO(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, com.kuaishou.weapon.p0.g.f9318c);
    }

    public static long cP(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static boolean ch(int i2) {
        return getApiLevel() >= i2;
    }

    public static void checkUiThread() {
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return ap.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return ap.isInMainProcess(context);
    }
}
