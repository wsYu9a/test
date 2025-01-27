package com.kwad.sdk.core.local;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ar;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class b {
    public static LocalWriteResult a(Context context, String str, byte[] bArr, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b(context, str, bArr, str2);
        }
        return a(context, bArr, str2 + p1.b.f29697h + MimeTypeMap.getSingleton().getExtensionFromMimeType(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.ContentResolver] */
    private static LocalWriteResult b(Context context, String str, byte[] bArr, String str2) {
        OutputStream outputStream;
        LocalWriteResult localWriteResult = LocalWriteResult.FAIL;
        ?? r12 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues contentValues = new ContentValues();
        ?? contentResolver = context.getContentResolver();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", str);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        contentValues.put("is_pending", (Integer) 1);
        Uri insert = contentResolver.insert(r12, contentValues);
        if (insert == null) {
            return localWriteResult;
        }
        Closeable closeable = null;
        try {
            try {
                outputStream = contentResolver.openOutputStream(insert);
            } catch (Exception e10) {
                e = e10;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                throw th;
            }
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                r12 = outputStream;
            } catch (Exception e11) {
                e = e11;
                c.printStackTraceOnly(e);
                r12 = outputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r12);
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                return LocalWriteResult.SUCCESS;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r12);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(insert, contentValues, null, null);
            return LocalWriteResult.SUCCESS;
        } catch (Throwable th3) {
            th = th3;
            closeable = r12;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private static LocalWriteResult a(Context context, byte[] bArr, String str) {
        Throwable th2;
        FileOutputStream fileOutputStream;
        Exception e10;
        LocalWriteResult localWriteResult;
        if (ar.ar(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (String) str));
                } catch (Exception e11) {
                    fileOutputStream = null;
                    e10 = e11;
                } catch (Throwable th3) {
                    str = 0;
                    th2 = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                    throw th2;
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    localWriteResult = LocalWriteResult.SUCCESS;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    str = fileOutputStream;
                } catch (Exception e12) {
                    e10 = e12;
                    LocalWriteResult localWriteResult2 = LocalWriteResult.FAIL;
                    c.printStackTraceOnly(e10);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    localWriteResult = localWriteResult2;
                    str = fileOutputStream;
                    return localWriteResult;
                }
                return localWriteResult;
            } catch (Throwable th4) {
                th2 = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th2;
            }
        }
        return LocalWriteResult.PERMISSION_DENIED;
    }
}
