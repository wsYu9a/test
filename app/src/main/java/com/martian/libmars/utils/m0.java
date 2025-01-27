package com.martian.libmars.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes2.dex */
public class m0 {
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r7 = "_data"
            r3[r0] = r7
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3a
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r7)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3a
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3a
            r8.close()
            return r9
        L29:
            goto L34
        L2b:
            if (r8 == 0) goto L30
            r8.close()
        L30:
            return r0
        L31:
            r9 = move-exception
            goto L3c
        L33:
            r8 = r0
        L34:
            if (r8 == 0) goto L42
            r8.close()     // Catch: java.lang.Throwable -> L3a
            goto L42
        L3a:
            r9 = move-exception
            r0 = r8
        L3c:
            if (r0 == 0) goto L41
            r0.close()
        L41:
            throw r9
        L42:
            if (r8 == 0) goto L47
            r8.close()
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.utils.m0.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String b(final Context context, final Uri uri) {
        int i2 = Build.VERSION.SDK_INT;
        Uri uri2 = null;
        if (com.martian.libsupport.l.p() && DocumentsContract.isDocumentUri(context, uri)) {
            if (d(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if (c(uri)) {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
                }
                if (e(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if (MiConfigSingleton.u0.equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return a(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean c(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean d(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean e(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
