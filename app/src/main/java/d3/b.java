package d3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class b {
    public static byte[] a(byte[] bArr) throws IOException {
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th3) {
                    gZIPOutputStream = null;
                    byteArrayInputStream2 = byteArrayInputStream;
                    th2 = th3;
                }
            } catch (Throwable th4) {
                gZIPOutputStream = null;
                byteArrayInputStream2 = byteArrayInputStream;
                th2 = th4;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th2 = th5;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                gZIPOutputStream.write(bArr2, 0, read);
            }
            gZIPOutputStream.flush();
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayInputStream.close();
            } catch (Exception unused) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            try {
                gZIPOutputStream.close();
            } catch (Exception unused3) {
            }
            return byteArray;
        } catch (Throwable th6) {
            th2 = th6;
            byteArrayInputStream2 = byteArrayInputStream;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (Exception unused4) {
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused5) {
                }
            }
            if (gZIPOutputStream == null) {
                throw th2;
            }
            try {
                gZIPOutputStream.close();
                throw th2;
            } catch (Exception unused6) {
                throw th2;
            }
        }
    }

    public static byte[] b(byte[] bArr) throws IOException {
        Throwable th2;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr2, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        } catch (Throwable th3) {
                            th2 = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                byteArrayInputStream.close();
                                throw th2;
                            } catch (Exception unused3) {
                                throw th2;
                            }
                        }
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused6) {
                    }
                    return byteArray;
                } catch (Throwable th4) {
                    th2 = th4;
                }
            } catch (Throwable th5) {
                th2 = th5;
                gZIPInputStream = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
