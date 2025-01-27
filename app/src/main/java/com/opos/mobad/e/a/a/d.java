package com.opos.mobad.e.a.a;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes4.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098 A[Catch: Exception -> 0x0094, TryCatch #7 {Exception -> 0x0094, blocks: (B:56:0x0090, B:45:0x0098, B:47:0x009d), top: B:55:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d A[Catch: Exception -> 0x0094, TRY_LEAVE, TryCatch #7 {Exception -> 0x0094, blocks: (B:56:0x0090, B:45:0x0098, B:47:0x009d), top: B:55:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.zip.ZipInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "unzipFile"
            boolean r1 = com.opos.cmn.an.c.a.a(r7)
            if (r1 != 0) goto Lba
            boolean r1 = com.opos.cmn.an.c.a.a(r8)
            if (r1 != 0) goto Lba
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r7 = r1.exists()
            java.lang.String r2 = "ZipTool"
            if (r7 == 0) goto La5
            r7 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.util.zip.CheckedInputStream r1 = new java.util.zip.CheckedInputStream     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            java.util.zip.CRC32 r4 = new java.util.zip.CRC32     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r5 = 24
            if (r4 < r5) goto L3e
            java.lang.String r4 = "gbk"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r5.<init>(r1, r4)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r7 = r5
            goto L44
        L3e:
            java.util.zip.ZipInputStream r4 = new java.util.zip.ZipInputStream     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r4.<init>(r1)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r7 = r4
        L44:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r4.<init>(r8)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            boolean r8 = a(r7, r4)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L89
            r3.close()     // Catch: java.lang.Exception -> L58
            r1.close()     // Catch: java.lang.Exception -> L58
            r7.close()     // Catch: java.lang.Exception -> L58
            goto Lbb
        L58:
            r7 = move-exception
            com.opos.cmn.an.f.a.d(r2, r0, r7)
            goto Lbb
        L5e:
            r8 = move-exception
            goto L6f
        L60:
            r8 = move-exception
            r1 = r7
            r7 = r3
            goto L69
        L64:
            r8 = move-exception
            r1 = r7
            goto L6f
        L67:
            r8 = move-exception
            r1 = r7
        L69:
            r3 = r8
            r8 = r1
            goto L8e
        L6c:
            r8 = move-exception
            r1 = r7
            r3 = r1
        L6f:
            com.opos.cmn.an.f.a.d(r2, r0, r8)     // Catch: java.lang.Throwable -> L89
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.lang.Exception -> L78
            goto L7a
        L78:
            r7 = move-exception
            goto L85
        L7a:
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.lang.Exception -> L78
        L7f:
            if (r7 == 0) goto Lba
            r7.close()     // Catch: java.lang.Exception -> L78
            goto Lba
        L85:
            com.opos.cmn.an.f.a.d(r2, r0, r7)
            goto Lba
        L89:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L8e:
            if (r7 == 0) goto L96
            r7.close()     // Catch: java.lang.Exception -> L94
            goto L96
        L94:
            r7 = move-exception
            goto La1
        L96:
            if (r1 == 0) goto L9b
            r1.close()     // Catch: java.lang.Exception -> L94
        L9b:
            if (r8 == 0) goto La4
            r8.close()     // Catch: java.lang.Exception -> L94
            goto La4
        La1:
            com.opos.cmn.an.f.a.d(r2, r0, r7)
        La4:
            throw r3
        La5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "zip file not exist!"
            r7.<init>(r8)
            java.lang.String r8 = r1.getAbsolutePath()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.opos.cmn.an.f.a.d(r2, r7)
        Lba:
            r8 = 0
        Lbb:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.e.a.a.d.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
    
        throw new java.lang.Exception("Entry is outside of the target dir: " + r1.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.util.zip.ZipInputStream r6, java.io.File r7) {
        /*
            java.lang.String r0 = "ZipTool"
        L2:
            java.util.zip.ZipEntry r1 = r6.getNextEntry()     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto L72
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L74
            r2.<init>()     // Catch: java.lang.Exception -> L74
            r2.append(r7)     // Catch: java.lang.Exception -> L74
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Exception -> L74
            r2.append(r3)     // Catch: java.lang.Exception -> L74
            java.lang.String r3 = r1.getName()     // Catch: java.lang.Exception -> L74
            r2.append(r3)     // Catch: java.lang.Exception -> L74
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L74
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L74
            r3.<init>(r2)     // Catch: java.lang.Exception -> L74
            java.lang.String r4 = r7.getCanonicalPath()     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = r3.getCanonicalPath()     // Catch: java.lang.Exception -> L74
            boolean r4 = r5.startsWith(r4)     // Catch: java.lang.Exception -> L74
            if (r4 == 0) goto L5a
            boolean r1 = r1.isDirectory()     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto L53
            boolean r1 = r3.exists()     // Catch: java.lang.Exception -> L74
            if (r1 != 0) goto L56
            boolean r1 = r3.mkdirs()     // Catch: java.lang.Exception -> L74
            if (r1 != 0) goto L56
            java.lang.String r1 = "file.mkdirs() failed filepath="
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L74
            java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Exception -> L74
            com.opos.cmn.an.f.a.b(r0, r1)     // Catch: java.lang.Exception -> L74
            goto L56
        L53:
            b(r6, r3)     // Catch: java.lang.Exception -> L74
        L56:
            r6.closeEntry()     // Catch: java.lang.Exception -> L74
            goto L2
        L5a:
            java.lang.Exception r6 = new java.lang.Exception     // Catch: java.lang.Exception -> L74
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L74
            java.lang.String r2 = "Entry is outside of the target dir: "
            r7.<init>(r2)     // Catch: java.lang.Exception -> L74
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> L74
            r7.append(r1)     // Catch: java.lang.Exception -> L74
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L74
            r6.<init>(r7)     // Catch: java.lang.Exception -> L74
            throw r6     // Catch: java.lang.Exception -> L74
        L72:
            r6 = 1
            goto L7b
        L74:
            r6 = move-exception
            java.lang.String r7 = ""
            com.opos.cmn.an.f.a.d(r0, r7, r6)
            r6 = 0
        L7b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.e.a.a.d.a(java.util.zip.ZipInputStream, java.io.File):boolean");
    }

    private static void b(ZipInputStream zipInputStream, File file) {
        FileOutputStream fileOutputStream;
        if (zipInputStream == null) {
            return;
        }
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    com.opos.cmn.an.f.a.b("ZipTool", "parentFile.mkdirs() failed filepath=" + file.getAbsolutePath());
                }
                if (!file.createNewFile()) {
                    com.opos.cmn.an.f.a.b("ZipTool", "destFile.createNewFile() failed filepath=" + file.getAbsolutePath());
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (-1 == read) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("ZipTool", "", e2);
        }
    }
}
