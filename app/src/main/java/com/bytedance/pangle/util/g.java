package com.bytedance.pangle.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    static String f6333a = null;

    /* renamed from: b, reason: collision with root package name */
    static String f6334b = null;

    /* renamed from: c, reason: collision with root package name */
    static int f6335c = 8192;

    public static void a(String str) {
        a(new File(str));
    }

    public static String b(Context context) {
        File parentFile;
        if (f6334b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                f6334b = parentFile.getCanonicalPath();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return f6334b;
    }

    public static void a(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String a(Context context) {
        File parentFile;
        if (f6333a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            f6333a = parentFile.getAbsolutePath();
        }
        return f6333a;
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file2.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        return;
                    }
                    for (File file3 : listFiles) {
                        String str3 = file2 + File.separator + file3.getName();
                        if (file3.isDirectory()) {
                            a(file3.getAbsolutePath(), str3);
                        } else if (!new File(str3).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            byte[] bArr = new byte[f6335c];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                            }
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                        }
                    }
                    return;
                }
                throw new Exception("目标文件夹不是目录");
            }
            throw new Exception("源文件夹不是目录");
        }
        throw new Exception("文件夹不存在");
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j2, long j3, String str) {
        byte[] bArr;
        long j4 = 0;
        if (j2 < 0 || j3 < 0 || j2 > j3) {
            throw new IOException("invalid offsets  ".concat(String.valueOf(str)));
        }
        if (j2 == j3) {
            return;
        }
        randomAccessFile.seek(j2);
        long j5 = j3 - j2;
        int i2 = f6335c;
        if (j5 < i2) {
            bArr = new byte[(int) j5];
        } else {
            bArr = new byte[i2];
        }
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, read);
            j4 += read;
            if (j4 == j5) {
                return;
            }
            if (bArr.length + j4 > j5) {
                bArr = new byte[(int) (j5 - j4)];
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    return;
                }
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }
}
