package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.mobads.sdk.internal.bu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class a {
    @Nullable
    @WorkerThread
    public static byte[] es(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileMD5Digest(new File(str));
    }

    @Nullable
    @WorkerThread
    public static String getFileMD5(File file) {
        try {
            byte[] fileMD5Digest = getFileMD5Digest(file);
            if (fileMD5Digest != null && fileMD5Digest.length != 0) {
                return ad.toHexString(fileMD5Digest, 0, fileMD5Digest.length);
            }
            return null;
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.e("FileMD5Utils", "cannot calculate md5 of file", e2);
            return null;
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] getFileMD5Digest(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("FileMD5Utils", "getting file md5 digest error.", e2);
            return null;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
        }
    }
}
