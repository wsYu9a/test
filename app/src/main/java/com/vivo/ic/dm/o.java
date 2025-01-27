package com.vivo.ic.dm;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import java.io.File;

/* loaded from: classes4.dex */
class o {

    /* renamed from: a */
    private static final String f28567a = Constants.PRE_TAG + "SpaceHelper";

    /* renamed from: b */
    private static final String f28568b = "/external_sd";

    /* renamed from: c */
    private static final String f28569c = "/sdcard1";

    /* renamed from: d */
    private static final long f28570d = 10485760;

    o() {
    }

    public static void a(Context context, String str, long j2) throws StopRequestException {
        File parentFile;
        if (str == null) {
            throw new IllegalArgumentException("path can't be null");
        }
        if (str.startsWith(context.getCacheDir().getPath())) {
            parentFile = context.getCacheDir();
        } else if (str.startsWith(Environment.getExternalStorageDirectory().getPath())) {
            parentFile = Environment.getExternalStorageDirectory();
        } else if (str.startsWith(Environment.getDownloadCacheDirectory().getPath())) {
            parentFile = Environment.getDownloadCacheDirectory();
        } else {
            if (!str.contains(f28568b) && !str.contains(f28569c)) {
                VLog.w(f28567a, "unhandled path, abort checkSpace of path " + str);
                return;
            }
            parentFile = new File(str).getParentFile();
            VLog.w(f28567a, "external sdcard, check path " + parentFile);
        }
        if (parentFile == null) {
            VLog.w(f28567a, "abort checkSpace of root is null");
            throw new StopRequestException(Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR, "abort checkSpace of root is null");
        }
        long a2 = a(parentFile);
        if (a2 < 0) {
            VLog.i(f28567a, "checkActualSpace ignore by get bytesAvailable error");
            return;
        }
        if (a2 < f28570d) {
            throw new StopRequestException(Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR, "space too low !! " + parentFile + " space left " + a2 + "b, stop downloading!");
        }
        if (a2 >= j2) {
            return;
        }
        throw new StopRequestException(Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR, "space not enough !! " + parentFile + " space left " + a2 + "b, targetBytes is " + j2);
    }

    public static void b(Context context, String str, long j2) throws StopRequestException {
        String str2 = f28567a;
        VLog.i(str2, "checkSpace of " + str + ", targetBytes is " + j2);
        if (j2 > 0) {
            a(context, str, j2);
            return;
        }
        VLog.w(str2, "abort check space because of  targetBytes: " + j2);
    }

    static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        long blockSize = statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
        VLog.i(f28567a, "available space (in bytes) in filesystem rooted at: " + file.getPath() + " is: " + blockSize);
        return blockSize;
    }
}
