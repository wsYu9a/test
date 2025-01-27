package com.martian.libmars.utils;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes2.dex */
public class u0 {
    public static Bitmap a(String url) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2 = null;
        try {
            URL url2 = new URL(url);
            byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = url2.openStream();
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Bitmap i2 = i0.i(byteArrayOutputStream.toByteArray(), 1);
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            return i2;
        } catch (IOException unused3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static Bitmap b(String url, int reqWidth, int reqHeight) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            URL url2 = new URL(url);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = url2.openStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                Bitmap j2 = i0.j(byteArrayOutputStream.toByteArray(), reqWidth, reqHeight);
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                return j2;
            } catch (IOException unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] c(String url) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2 = null;
        try {
            URL url2 = new URL(url);
            byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = url2.openStream();
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            return byteArray;
        } catch (IOException unused3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }
}
