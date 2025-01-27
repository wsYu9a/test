package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* loaded from: classes3.dex */
public final class b {
    public static final byte[] aQn = gv("IHDR");
    public static final byte[] aQo = gv("PLTE");
    public static final byte[] aQp = gv("IDAT");
    public static final byte[] aQq = gv("IEND");
    private static byte[] aQr = new byte[4096];
    public static Pattern aQs = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i10, int i11, boolean z10) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i10, i11);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        i(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception e10) {
                        e = e10;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                            return new byte[0];
                        } catch (Throwable th2) {
                            th = th2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception e12) {
                e = e12;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception e13) {
            e = e13;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
    }

    public static String d(byte[] bArr, int i10, int i11) {
        return new String(bArr, i10, i11, com.kwad.sdk.pngencrypt.n.aPV);
    }

    public static String e(byte[] bArr, int i10, int i11) {
        return new String(bArr, i10, i11, com.kwad.sdk.pngencrypt.n.aPW);
    }

    public static byte[] gv(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.aPV);
    }

    public static boolean gw(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean gx(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean gy(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aPV);
    }

    public static String j(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aPW);
    }

    private static void i(InputStream inputStream, OutputStream outputStream) {
        synchronized (aQr) {
            while (true) {
                try {
                    int read = inputStream.read(aQr);
                    if (read > 0) {
                        outputStream.write(aQr, 0, read);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static String i(byte[] bArr, int i10) {
        if (bArr != null && bArr.length >= 8) {
            return d(bArr, 4, 4);
        }
        return "?";
    }
}
