package com.opos.mobad.service.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: com.opos.mobad.service.c.e$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f23561a;

        AnonymousClass1(File file) {
            file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.c(file);
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear succ");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "clear temp fail", e2);
            }
        }
    }

    public static void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str + "_dirty");
                if (file2.exists()) {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "rn but exists");
                    c(file2);
                }
                if (file.renameTo(file2)) {
                    b(file2);
                } else {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "rn fail");
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear temp fail", th);
        }
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "prepare failed!zipPath or destPath is empty!";
        } else {
            if (new File(str).exists()) {
                File a2 = f.a(context, str);
                if (a2 == null) {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "prepare but null dirFile!");
                    return false;
                }
                String absolutePath = a2.getAbsolutePath();
                if (!a2.exists()) {
                    a2.mkdirs();
                } else if (a2.listFiles().length > 0) {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "file has exist");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean a3 = a(str, absolutePath);
                if (!a3) {
                    a(absolutePath);
                }
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "prepare result:", Boolean.valueOf(a3), "zipPath =", str, ",destPath:", absolutePath, ",costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return a3;
            }
            str2 = "prepare failed!zipPath not exist";
        }
        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", str2);
        return false;
    }

    private static boolean a(String str, String str2) {
        if (!com.opos.cmn.an.c.a.a(str) && !com.opos.cmn.an.c.a.a(str2)) {
            File file = new File(str);
            if (file.exists()) {
                ZipInputStream zipInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                            try {
                                ZipInputStream zipInputStream2 = Build.VERSION.SDK_INT >= 24 ? new ZipInputStream(checkedInputStream, Charset.forName("gbk")) : new ZipInputStream(checkedInputStream);
                                boolean a2 = a(zipInputStream2, new File(str2));
                                fileInputStream.close();
                                try {
                                    zipInputStream2.close();
                                    return a2;
                                } catch (Exception e2) {
                                    com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e2);
                                    return a2;
                                }
                            } finally {
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused) {
                                }
                                throw th2;
                            }
                        }
                    } catch (Exception e3) {
                        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e3);
                        if (0 != 0) {
                            try {
                                zipInputStream.close();
                            } catch (Exception e4) {
                                com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e4);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    if (0 != 0) {
                        try {
                            zipInputStream.close();
                        } catch (Exception e5) {
                            com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e5);
                        }
                    }
                    throw th3;
                }
            } else {
                com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "zip file not exist!" + file.getAbsolutePath());
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        throw new java.lang.Exception("Entry is outside of the target dir: " + r1.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.util.zip.ZipInputStream r6, java.io.File r7) {
        /*
            java.lang.String r0 = "Dynamic-ZipTool"
            if (r6 == 0) goto L88
            if (r7 == 0) goto L88
        L6:
            java.util.zip.ZipEntry r1 = r6.getNextEntry()     // Catch: java.lang.Exception -> L82
            if (r1 == 0) goto L80
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82
            r2.<init>()     // Catch: java.lang.Exception -> L82
            r2.append(r7)     // Catch: java.lang.Exception -> L82
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Exception -> L82
            r2.append(r3)     // Catch: java.lang.Exception -> L82
            java.lang.String r3 = r1.getName()     // Catch: java.lang.Exception -> L82
            r2.append(r3)     // Catch: java.lang.Exception -> L82
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L82
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L82
            r3.<init>(r2)     // Catch: java.lang.Exception -> L82
            java.lang.String r4 = r7.getCanonicalPath()     // Catch: java.lang.Exception -> L82
            java.lang.String r5 = r3.getCanonicalPath()     // Catch: java.lang.Exception -> L82
            boolean r4 = r5.startsWith(r4)     // Catch: java.lang.Exception -> L82
            if (r4 == 0) goto L65
            boolean r1 = r1.isDirectory()     // Catch: java.lang.Exception -> L82
            if (r1 == 0) goto L5e
            boolean r1 = r3.exists()     // Catch: java.lang.Exception -> L82
            if (r1 != 0) goto L61
            boolean r1 = r3.mkdirs()     // Catch: java.lang.Exception -> L82
            if (r1 != 0) goto L61
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82
            r1.<init>()     // Catch: java.lang.Exception -> L82
            java.lang.String r3 = "file.mkdirs() failed filepath="
            r1.append(r3)     // Catch: java.lang.Exception -> L82
            r1.append(r2)     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L82
            com.opos.cmn.an.f.a.b(r0, r1)     // Catch: java.lang.Exception -> L82
            goto L61
        L5e:
            b(r6, r3)     // Catch: java.lang.Exception -> L82
        L61:
            r6.closeEntry()     // Catch: java.lang.Exception -> L82
            goto L6
        L65:
            java.lang.Exception r6 = new java.lang.Exception     // Catch: java.lang.Exception -> L82
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82
            r7.<init>()     // Catch: java.lang.Exception -> L82
            java.lang.String r2 = "Entry is outside of the target dir: "
            r7.append(r2)     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> L82
            r7.append(r1)     // Catch: java.lang.Exception -> L82
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L82
            r6.<init>(r7)     // Catch: java.lang.Exception -> L82
            throw r6     // Catch: java.lang.Exception -> L82
        L80:
            r6 = 1
            goto L89
        L82:
            r6 = move-exception
            java.lang.String r7 = ""
            com.opos.cmn.an.f.a.d(r0, r7, r6)
        L88:
            r6 = 0
        L89:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.c.e.a(java.util.zip.ZipInputStream, java.io.File):boolean");
    }

    private static void b(File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.c.e.1

            /* renamed from: a */
            final /* synthetic */ File f23561a;

            AnonymousClass1(File file2) {
                file = file2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.c(file);
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear succ");
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("", "clear temp fail", e2);
                }
            }
        });
    }

    private static void b(ZipInputStream zipInputStream, File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (zipInputStream == null || file == null) {
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "parentFile.mkdirs() failed filepath=" + file.getAbsolutePath());
            }
            if (!file.createNewFile()) {
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "destFile.createNewFile() failed filepath=" + file.getAbsolutePath());
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
    }

    public static void c(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                for (File file2 : listFiles) {
                    c(file2);
                }
            }
        }
        file.delete();
    }
}
