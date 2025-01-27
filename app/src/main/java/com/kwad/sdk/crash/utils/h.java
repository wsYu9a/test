package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class h {
    public static final char aMr = File.separatorChar;
    public static final String aMs;

    static {
        PrintWriter printWriter;
        Throwable th2;
        StringBuilderWriter stringBuilderWriter;
        Exception e10;
        String str;
        try {
            stringBuilderWriter = new StringBuilderWriter(4);
        } catch (Exception e11) {
            printWriter = null;
            e10 = e11;
            stringBuilderWriter = null;
        } catch (Throwable th3) {
            printWriter = null;
            th2 = th3;
            stringBuilderWriter = null;
        }
        try {
            printWriter = new PrintWriter(stringBuilderWriter);
        } catch (Exception e12) {
            printWriter = null;
            e10 = e12;
        } catch (Throwable th4) {
            printWriter = null;
            th2 = th4;
            b.closeQuietly(printWriter);
            b.closeQuietly(stringBuilderWriter);
            throw th2;
        }
        try {
            try {
                printWriter.println();
                str = stringBuilderWriter.toString();
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
            } catch (Throwable th5) {
                th2 = th5;
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
                throw th2;
            }
        } catch (Exception e13) {
            e10 = e13;
            e10.printStackTrace();
            b.closeQuietly(printWriter);
            b.closeQuietly(stringBuilderWriter);
            str = "\n";
            aMs = str;
        }
        aMs = str;
    }

    public static String J(File file) {
        return a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), a.UTF_8));
    }

    public static long K(File file) {
        try {
            if (!file.exists()) {
                return 0L;
            }
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long L(File file) {
        try {
            if (!file.exists()) {
                return 0L;
            }
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th2;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read == -1) {
                        String stringWriter3 = stringWriter.toString();
                        b.closeQuietly(reader);
                        b.closeQuietly(stringWriter);
                        return stringWriter3;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (Throwable th3) {
                th2 = th3;
                b.closeQuietly(reader);
                b.closeQuietly(stringWriter);
                throw th2;
            }
        } catch (Throwable th4) {
            stringWriter = stringWriter2;
            th2 = th4;
        }
    }

    public static String b(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th2;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th3) {
                th2 = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th2 = th4;
            bufferedReader = null;
        }
        try {
            String a10 = a(bufferedReader);
            b.closeQuietly(bufferedReader);
            b.closeQuietly(inputStreamReader);
            return a10;
        } catch (Throwable th5) {
            th2 = th5;
            b.closeQuietly(bufferedReader);
            b.closeQuietly(inputStreamReader);
            throw th2;
        }
    }

    public static String d(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static int g(InputStream inputStream, OutputStream outputStream) {
        long h10 = h(inputStream, outputStream);
        if (h10 > 2147483647L) {
            return -1;
        }
        return (int) h10;
    }

    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return K(new File(str));
    }

    public static long getTotalBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return L(new File(str));
    }

    private static long h(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static void k(String str, String str2, boolean z10) {
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                fileWriter.write(str2);
                fileWriter.flush();
                b.closeQuietly(fileWriter);
            } catch (Throwable unused) {
                b.closeQuietly(fileWriter);
            }
        } catch (Throwable unused2) {
            fileWriter = null;
        }
    }

    public static String K(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return a(inputStream, a.a(Charset.defaultCharset()));
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(a.a(charset)));
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    private static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    private static int a(Reader reader, Writer writer) {
        long b10 = b(reader, writer);
        if (b10 > 2147483647L) {
            return -1;
        }
        return (int) b10;
    }

    private static long a(Reader reader, Writer writer, char[] cArr) {
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j10;
            }
            writer.write(cArr, 0, read);
            j10 += read;
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    b.closeQuietly(inputStream);
                    b.closeQuietly(byteArrayOutputStream);
                    return str;
                }
            } catch (IOException unused) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th2) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                throw th2;
            }
        }
    }
}
