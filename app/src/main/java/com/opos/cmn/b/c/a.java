package com.opos.cmn.b.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes4.dex */
public final class a {
    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("GZipTool", "safeClose", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static boolean a(InputStream inputStream, OutputStream outputStream) {
        boolean z = false;
        if (inputStream != null && outputStream != null) {
            ?? r1 = 0;
            GZIPOutputStream gZIPOutputStream = null;
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream, false);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (-1 == read) {
                                break;
                            }
                            gZIPOutputStream2.write(bArr, 0, read);
                        }
                        gZIPOutputStream2.finish();
                        gZIPOutputStream2.flush();
                        z = true;
                        a(gZIPOutputStream2);
                        r1 = bArr;
                    } catch (Exception e2) {
                        e = e2;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.opos.cmn.an.f.a.c("GZipTool", "compress", e);
                        r1 = gZIPOutputStream;
                        if (gZIPOutputStream != null) {
                            a(gZIPOutputStream);
                            r1 = gZIPOutputStream;
                        }
                        a(inputStream);
                        a(outputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        r1 = gZIPOutputStream2;
                        if (r1 != 0) {
                            a((Closeable) r1);
                        }
                        a(inputStream);
                        a(outputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                a(inputStream);
                a(outputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (a(byteArrayInputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static boolean b(InputStream inputStream, OutputStream outputStream) {
        boolean z = false;
        if (inputStream != null && outputStream != null) {
            ?? r1 = 0;
            GZIPInputStream gZIPInputStream = null;
            try {
                try {
                    GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = gZIPInputStream2.read(bArr);
                            if (-1 == read) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                        z = true;
                        a(gZIPInputStream2);
                        r1 = bArr;
                    } catch (Exception e2) {
                        e = e2;
                        gZIPInputStream = gZIPInputStream2;
                        com.opos.cmn.an.f.a.c("GZipTool", "decompress", e);
                        r1 = gZIPInputStream;
                        if (gZIPInputStream != null) {
                            a(gZIPInputStream);
                            r1 = gZIPInputStream;
                        }
                        a(inputStream);
                        a(outputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        r1 = gZIPInputStream2;
                        if (r1 != 0) {
                            a((Closeable) r1);
                        }
                        a(inputStream);
                        a(outputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                a(inputStream);
                a(outputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (b(byteArrayInputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }
}
