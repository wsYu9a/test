package com.ss.android.downloadlib.lg;

import java.io.File;

/* loaded from: classes4.dex */
public class lg {
    public static long j(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return j(file, file.lastModified(), 0);
    }

    private static long j(File file, long j2, int i2) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j2 = Math.max(j2, file.lastModified());
            int i3 = i2 + 1;
            if (i3 >= 50) {
                return j2;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j2 = Math.max(j2, j(file2, j2, i3));
                }
            }
        }
        return j2;
    }
}
