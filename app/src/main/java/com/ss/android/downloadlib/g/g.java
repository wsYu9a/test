package com.ss.android.downloadlib.g;

import java.io.File;

/* loaded from: classes4.dex */
public class g {
    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return a(file, file.lastModified(), 0);
    }

    private static long a(File file, long j10, int i10) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j10 = Math.max(j10, file.lastModified());
            int i11 = i10 + 1;
            if (i11 >= 50) {
                return j10;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j10 = Math.max(j10, a(file2, j10, i11));
                }
            }
        }
        return j10;
    }
}
