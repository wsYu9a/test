package com.alimm.tanx.core.web.cache.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class FileUtil {
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                outputStream.close();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void deleteDirs(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    deleteDirs(file2.getAbsolutePath(), z10);
                } else {
                    file2.delete();
                }
            }
            if (z10) {
                file.delete();
            }
        }
    }
}
