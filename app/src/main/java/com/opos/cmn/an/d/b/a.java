package com.opos.cmn.an.d.b;

import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class a {
    public static void a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public static boolean a() {
        boolean z;
        try {
            z = Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("FileTool", "isSdCardAvailable", e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("FileTool", "isSdCardAvailable=" + z);
        return z;
    }

    public static boolean a(File file) {
        boolean exists = file != null ? file.exists() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("isFileExists ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" =");
        sb.append(exists);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return exists;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.File r4, java.io.File r5) {
        /*
            java.lang.String r0 = "FileTool"
            if (r4 == 0) goto L11
            if (r5 == 0) goto L11
            boolean r1 = r4.renameTo(r5)     // Catch: java.lang.Exception -> Lb
            goto L12
        Lb:
            r1 = move-exception
            java.lang.String r2 = "rename"
            com.opos.cmn.an.f.a.c(r0, r2, r1)
        L11:
            r1 = 0
        L12:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "renameTo "
            r2.append(r3)
            java.lang.String r3 = "null"
            if (r4 == 0) goto L25
            java.lang.String r4 = r4.getAbsolutePath()
            goto L26
        L25:
            r4 = r3
        L26:
            r2.append(r4)
            if (r5 == 0) goto L2f
            java.lang.String r3 = r5.getAbsolutePath()
        L2f:
            r2.append(r3)
            java.lang.String r4 = " result="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.a(java.io.File, java.io.File):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.InputStream r7, java.io.File r8) {
        /*
            r0 = 1
            java.lang.String r1 = "FileTool"
            r2 = 0
            if (r7 == 0) goto L81
            if (r8 == 0) goto L81
            boolean r3 = a(r8)     // Catch: java.lang.Exception -> L79
            if (r3 != 0) goto L54
            java.lang.String r3 = d(r8)     // Catch: java.lang.Exception -> L79
            boolean r3 = b(r3)     // Catch: java.lang.Exception -> L79
            if (r3 != 0) goto L38
            boolean r3 = c(r8)     // Catch: java.lang.Exception -> L79
            if (r3 != 0) goto L38
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r7.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = "saveInputStream2File mkdirs fail="
            r7.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = r8.getAbsolutePath()     // Catch: java.lang.Exception -> L79
            r7.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L79
        L33:
            com.opos.cmn.an.f.a.b(r1, r7)     // Catch: java.lang.Exception -> L79
            goto La8
        L38:
            boolean r3 = f(r8)     // Catch: java.lang.Exception -> L79
            if (r3 != 0) goto L54
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r7.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = "saveInputStream2File createNewFile fail="
            r7.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = r8.getAbsolutePath()     // Catch: java.lang.Exception -> L79
            r7.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L79
            goto L33
        L54:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L73
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L73
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L71
        L5d:
            int r5 = r7.read(r4)     // Catch: java.lang.Throwable -> L71
            r6 = -1
            if (r6 == r5) goto L68
            r3.write(r4, r2, r5)     // Catch: java.lang.Throwable -> L71
            goto L5d
        L68:
            r3.flush()     // Catch: java.lang.Throwable -> L71
            a(r3)     // Catch: java.lang.Exception -> L6f
            goto L82
        L6f:
            r7 = move-exception
            goto L7b
        L71:
            r7 = move-exception
            goto L75
        L73:
            r7 = move-exception
            r3 = 0
        L75:
            a(r3)     // Catch: java.lang.Exception -> L79
            throw r7     // Catch: java.lang.Exception -> L79
        L79:
            r7 = move-exception
            r0 = 0
        L7b:
            java.lang.String r2 = "saveInputStream2File"
            com.opos.cmn.an.f.a.c(r1, r2, r7)
            goto L82
        L81:
            r0 = 0
        L82:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "saveInputStream2File "
            r7.append(r2)
            if (r8 == 0) goto L93
            java.lang.String r8 = r8.getAbsolutePath()
            goto L95
        L93:
            java.lang.String r8 = "null"
        L95:
            r7.append(r8)
            java.lang.String r8 = " result="
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.opos.cmn.an.f.a.b(r1, r7)
            r2 = r0
        La8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.a(java.io.InputStream, java.io.File):boolean");
    }

    public static boolean a(String str) {
        boolean exists = !com.opos.cmn.an.c.a.a(str) ? new File(str).exists() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("isFileExists ");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(" =");
        sb.append(exists);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return exists;
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("FileTool", "inputStream2Bytes", e2);
            }
        }
        return null;
    }

    public static String b() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        com.opos.cmn.an.f.a.b("FileTool", "getSdCardRootPath=" + absolutePath);
        return absolutePath;
    }

    public static boolean b(File file) {
        boolean z = file != null && file.exists() && file.isDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append("isFolderExist ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" =");
        sb.append(z);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.String r3) {
        /*
            boolean r0 = com.opos.cmn.an.c.a.a(r3)
            if (r0 != 0) goto L19
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L19
            boolean r0 = r0.isDirectory()
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isFileExists "
            r1.append(r2)
            if (r3 == 0) goto L27
            goto L29
        L27:
            java.lang.String r3 = "null"
        L29:
            r1.append(r3)
            java.lang.String r3 = " ="
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "FileTool"
            com.opos.cmn.an.f.a.b(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.b(java.lang.String):boolean");
    }

    public static long c() {
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j2 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("FileTool", "", e2);
            j2 = 0;
        }
        com.opos.cmn.an.f.a.b("FileTool", "getSDCardAvailableSize=" + j2);
        return j2;
    }

    public static String c(String str) {
        int lastIndexOf;
        String str2 = "";
        if (!com.opos.cmn.an.c.a.a(str) && (lastIndexOf = str.lastIndexOf(File.separator)) != -1) {
            str2 = str.substring(0, lastIndexOf);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderPath ");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(" folder path=");
        sb.append(str2);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return str2;
    }

    public static boolean c(File file) {
        File parentFile;
        boolean mkdirs = (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) ? false : parentFile.mkdirs();
        StringBuilder sb = new StringBuilder();
        sb.append("makeDirs ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" =");
        sb.append(mkdirs);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return mkdirs;
    }

    public static String d(File file) {
        return file != null ? c(file.getAbsolutePath()) : "";
    }

    public static boolean d(String str) {
        boolean delete = a(str) ? new File(str).delete() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("deleteFile ");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(" result=");
        sb.append(delete);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return delete;
    }

    public static long e(String str) {
        long h2 = !com.opos.cmn.an.c.a.a(str) ? h(new File(str)) : 0L;
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderOrFileSize filePath=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",size=");
        sb.append(h2);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return h2;
    }

    public static boolean e(File file) {
        boolean delete = a(file) ? file.delete() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("deleteFile ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" result=");
        sb.append(delete);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return delete;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(java.io.File r4) {
        /*
            java.lang.String r0 = "FileTool"
            if (r4 == 0) goto Lf
            boolean r1 = r4.createNewFile()     // Catch: java.io.IOException -> L9
            goto L10
        L9:
            r1 = move-exception
            java.lang.String r2 = "createNewFile"
            com.opos.cmn.an.f.a.c(r0, r2, r1)
        Lf:
            r1 = 0
        L10:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "createNewFile "
            r2.append(r3)
            if (r4 == 0) goto L21
            java.lang.String r4 = r4.getAbsolutePath()
            goto L23
        L21:
            java.lang.String r4 = "null"
        L23:
            r2.append(r4)
            java.lang.String r4 = " result="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.f(java.io.File):boolean");
    }

    public static boolean f(String str) {
        boolean mkdirs = !com.opos.cmn.an.c.a.a(str) ? new File(str).mkdirs() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("makeFolder ");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(" =");
        sb.append(mkdirs);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return mkdirs;
    }

    public static long g(File file) {
        long length = a(file) ? file.length() : 0L;
        StringBuilder sb = new StringBuilder();
        sb.append("getFileLength ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" length=");
        sb.append(length);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return length;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long h(java.io.File r5) {
        /*
            java.lang.String r0 = "FileTool"
            if (r5 == 0) goto L1a
            boolean r1 = r5.isDirectory()     // Catch: java.lang.Exception -> L14
            if (r1 == 0) goto Lf
            long r1 = j(r5)     // Catch: java.lang.Exception -> L14
            goto L1c
        Lf:
            long r1 = i(r5)     // Catch: java.lang.Exception -> L14
            goto L1c
        L14:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.c(r0, r2, r1)
        L1a:
            r1 = 0
        L1c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getFolderOrFileSize filePath="
            r3.append(r4)
            if (r5 == 0) goto L2d
            java.lang.String r5 = r5.getAbsolutePath()
            goto L2f
        L2d:
            java.lang.String r5 = "null"
        L2f:
            r3.append(r5)
            java.lang.String r5 = ",size="
            r3.append(r5)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.h(java.io.File):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long i(java.io.File r7) {
        /*
            r0 = 0
            java.lang.String r1 = ""
            java.lang.String r2 = "FileTool"
            r3 = 0
            if (r7 == 0) goto L3f
            boolean r5 = a(r7)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            if (r5 == 0) goto L3f
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            int r0 = r5.available()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
            long r3 = (long) r0
            r0 = r5
            goto L3f
        L1b:
            r7 = move-exception
            r0 = r5
            goto L34
        L1e:
            r0 = move-exception
            r6 = r5
            r5 = r0
            r0 = r6
            goto L26
        L23:
            r7 = move-exception
            goto L34
        L25:
            r5 = move-exception
        L26:
            com.opos.cmn.an.f.a.c(r2, r1, r5)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.lang.Exception -> L2f
            goto L44
        L2f:
            r0 = move-exception
            com.opos.cmn.an.f.a.c(r2, r1, r0)
            goto L44
        L34:
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.lang.Exception -> L3a
            goto L3e
        L3a:
            r0 = move-exception
            com.opos.cmn.an.f.a.c(r2, r1, r0)
        L3e:
            throw r7
        L3f:
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.lang.Exception -> L2f
        L44:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getFileSize file="
            r0.append(r1)
            if (r7 == 0) goto L55
            java.lang.String r7 = r7.getAbsolutePath()
            goto L57
        L55:
            java.lang.String r7 = "null"
        L57:
            r0.append(r7)
            java.lang.String r7 = ",size="
            r0.append(r7)
            r0.append(r3)
            java.lang.String r7 = r0.toString()
            com.opos.cmn.an.f.a.b(r2, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.i(java.io.File):long");
    }

    private static long j(File file) {
        long j2 = 0;
        if (file != null) {
            try {
                if (b(file)) {
                    File[] listFiles = file.listFiles();
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        j2 += listFiles[i2].isDirectory() ? j(listFiles[i2]) : i(listFiles[i2]);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("FileTool", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderSize file=");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(",size=");
        sb.append(j2);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return j2;
    }
}
