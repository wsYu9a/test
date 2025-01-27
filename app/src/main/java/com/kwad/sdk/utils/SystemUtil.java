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

/* loaded from: classes3.dex */
public final class SystemUtil {
    private static long aUT;
    private static long aUU;
    private static int aUV;
    private static LEVEL aUW;

    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        LEVEL(int i10) {
            this.value = i10;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static class a {
        public long aUX;
        public long aUY;
        public long aUZ;
        public long aVa;
        public long aVb;
        public int mThreadsCount;
    }

    public static long OP() {
        BufferedReader bufferedReader;
        Throwable th2;
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
                } catch (Throwable th3) {
                    th2 = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th2;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th4) {
            bufferedReader = null;
            th2 = th4;
        }
    }

    public static a OQ() {
        String ax;
        a aVar = new a();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", com.kuaishou.weapon.p0.t.f11211k);
            while (true) {
                try {
                    String readLine = randomAccessFile2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                            String ax2 = ax(readLine, "VmSize");
                            if (ax2 != null) {
                                aVar.aUY = Long.valueOf(ax2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String ax3 = ax(readLine, "VmRSS:");
                            if (ax3 != null) {
                                aVar.aUZ = Long.valueOf(ax3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (ax = ax(readLine, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(ax).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
        return aVar;
    }

    private static String ax(String str, String str2) {
        int length = str2.length();
        int i10 = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (i10 != -1) {
                    break;
                }
            } else if (i10 == -1) {
                i10 = length;
            }
            length++;
        }
        if (i10 == -1) {
            return null;
        }
        return length == -1 ? str.substring(i10) : str.substring(i10, length);
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i10 = 0; i10 <= 0; i10++) {
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

    public static void checkUiThread() {
    }

    /* renamed from: do */
    public static boolean m41do(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, com.kuaishou.weapon.p0.g.f11102c);
    }

    public static long dp(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static boolean el(int i10) {
        return getApiLevel() >= i10;
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return av.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return av.isInMainProcess(context);
    }
}
