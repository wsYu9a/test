package com.alimm.tanx.core.web.cache.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import m5.c;
import okio.ByteString;
import okio.GzipSource;
import okio.Okio;
import p1.b;

/* loaded from: classes.dex */
public class OKHttpFile {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_METADATA = 0;

    public static InputStream getCacheFile(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String hex = ByteString.encodeUtf8(str.toString()).md5().hex();
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hex);
        sb2.append(b.f29697h);
        boolean z10 = false;
        sb2.append(0);
        File file2 = new File(absolutePath, sb2.toString());
        File file3 = new File(file.getAbsolutePath(), hex + b.f29697h + 1);
        if (file2.exists() && file3.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2), 1024);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.contains(c.f28293b0) && readLine.contains("gzip")) {
                            z10 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                return !z10 ? new FileInputStream(file3) : Okio.buffer(new GzipSource(Okio.source(file3))).inputStream();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }
}
