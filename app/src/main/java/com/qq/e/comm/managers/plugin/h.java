package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* loaded from: classes3.dex */
class h {

    /* renamed from: a */
    private static String f16604a = b.a("e_qq_com_plugin");

    /* renamed from: b */
    private static String f16605b = b.a("e_qq_com_dex");

    public static String a() {
        return "gdt_plugin";
    }

    public static void b(Context context) {
        try {
            File file = new File(context.getDir(f16604a, 0), "stub_ver");
            if (TextUtils.equals(a(file), SDKStatus.getSDKVersion())) {
                return;
            }
            a(SDKStatus.getSDKVersion(), file);
            a(context);
        } catch (Throwable th2) {
            GDTLogger.w(th2.getMessage(), th2);
        }
    }

    public static File c(Context context) {
        return context.getDir(f16605b, 0);
    }

    public static File d(Context context) {
        return new File(context.getDir(f16604a, 0), "update_lc");
    }

    public static File e(Context context) {
        return new File(context.getDir(f16604a, 0), "gdt_plugin.next");
    }

    public static File f(Context context) {
        return new File(context.getDir(f16604a, 0), "gdt_plugin.next.sig");
    }

    public static File g(Context context) {
        return new File(context.getDir(f16604a, 0), "gdt_plugin.jar");
    }

    public static File h(Context context) {
        return new File(context.getDir(f16604a, 0), "gdt_plugin.jar.sig");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    public static String a(File file) throws IOException {
        Throwable th2;
        ?? r12 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb2.append(readLine);
                            }
                            String sb3 = sb2.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb3;
                        } catch (IOException e10) {
                            throw e10;
                        }
                    } catch (IOException e11) {
                        throw e11;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                r12 = file;
                th2 = th4;
            }
        }
        return null;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(File file, boolean z10) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2, true);
            } else {
                file2.delete();
            }
        }
        if (z10) {
            file.delete();
        }
    }

    public static void a(String str, File file) throws IOException {
        OutputStreamWriter outputStreamWriter;
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
        try {
            outputStreamWriter.write(str);
            a(outputStreamWriter);
        } catch (Throwable th3) {
            th = th3;
            a(outputStreamWriter);
            throw th;
        }
    }

    public static boolean a(File file, Context context) {
        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    public static boolean a(File file, File file2, Context context, boolean z10) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z10) {
                return a(file2, context);
            }
            return true;
        }
        try {
            boolean a10 = a(new FileInputStream(file), file2);
            if (!z10) {
                return a10;
            }
            if (a10) {
                return a(file2, context);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(Context context) {
        try {
            File dir = context.getDir(f16604a, 0);
            if (new File(dir, "disdoat").exists()) {
                return;
            }
            a(context.getDir(f16605b, 0), false);
            a(new File(dir, "oat"), false);
        } catch (Throwable th2) {
            GDTLogger.w(th2.getMessage(), th2);
        }
    }
}
