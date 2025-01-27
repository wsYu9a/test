package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static int f21836a = 8;

    /* renamed from: b */
    private static volatile c f21837b;

    /* renamed from: c */
    private a<Integer, Bitmap> f21838c;

    /* renamed from: com.ss.android.socialbase.appdownloader.e.c$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21839a;

        /* renamed from: b */
        final /* synthetic */ int f21840b;

        public AnonymousClass1(String str, int i10) {
            str = str;
            i10 = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayInputStream byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream2;
            Throwable th2;
            InputStream inputStream;
            Exception e10;
            IDownloadHttpConnection downloadWithConnection;
            int i10 = 4;
            i10 = 4;
            i10 = 4;
            i10 = 4;
            i10 = 4;
            try {
                try {
                    downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                } catch (Exception e11) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e10 = e11;
                    inputStream = null;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th2 = th3;
                    inputStream = null;
                }
                if (downloadWithConnection == null) {
                    DownloadUtils.safeClose(null, null, null, null);
                    return;
                }
                inputStream = downloadWithConnection.getInputStream();
                try {
                    byteArrayOutputStream = c.b(inputStream);
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (Exception e12) {
                        byteArrayInputStream2 = null;
                        e10 = e12;
                        byteArrayInputStream = null;
                    } catch (Throwable th4) {
                        byteArrayInputStream2 = null;
                        th2 = th4;
                        byteArrayInputStream = null;
                    }
                } catch (Exception e13) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e10 = e13;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th2 = th5;
                    byteArrayOutputStream = null;
                }
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e14) {
                    byteArrayInputStream2 = null;
                    e10 = e14;
                } catch (Throwable th6) {
                    byteArrayInputStream2 = null;
                    th2 = th6;
                    Closeable[] closeableArr = new Closeable[i10];
                    closeableArr[0] = inputStream;
                    closeableArr[1] = byteArrayOutputStream;
                    closeableArr[2] = byteArrayInputStream;
                    closeableArr[3] = byteArrayInputStream2;
                    DownloadUtils.safeClose(closeableArr);
                    throw th2;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                    int a10 = com.ss.android.socialbase.appdownloader.c.a(DownloadComponentManager.getAppContext(), 44.0f);
                    options.inSampleSize = c.a(a10, a10, options);
                    options.inJustDecodeBounds = false;
                    c.this.f21838c.put(Integer.valueOf(i10), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                    Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                    DownloadUtils.safeClose(closeableArr2);
                    i10 = closeableArr2;
                } catch (Exception e15) {
                    e10 = e15;
                    e10.printStackTrace();
                    Closeable[] closeableArr3 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                    DownloadUtils.safeClose(closeableArr3);
                    i10 = closeableArr3;
                }
            } catch (Throwable th7) {
                th2 = th7;
            }
        }
    }

    public static class a<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a */
        final int f21842a;

        public a(int i10, int i11) {
            super(i11, 0.75f, true);
            this.f21842a = i10;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f21842a;
        }
    }

    private c() {
        this.f21838c = null;
        int i10 = f21836a;
        this.f21838c = new a<>(i10, i10 / 2);
    }

    public static ByteArrayOutputStream b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static c a() {
        if (f21837b == null) {
            synchronized (c.class) {
                try {
                    if (f21837b == null) {
                        f21837b = new c();
                    }
                } finally {
                }
            }
        }
        return f21837b;
    }

    public Bitmap a(int i10) {
        return this.f21838c.get(Integer.valueOf(i10));
    }

    public void a(int i10, String str) {
        if (TextUtils.isEmpty(str) || a(i10) != null) {
            return;
        }
        DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1

            /* renamed from: a */
            final /* synthetic */ String f21839a;

            /* renamed from: b */
            final /* synthetic */ int f21840b;

            public AnonymousClass1(String str2, int i102) {
                str = str2;
                i10 = i102;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th2;
                InputStream inputStream;
                Exception e10;
                IDownloadHttpConnection downloadWithConnection;
                int i102 = 4;
                i102 = 4;
                i102 = 4;
                i102 = 4;
                i102 = 4;
                try {
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e11) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e10 = e11;
                        inputStream = null;
                    } catch (Throwable th3) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th2 = th3;
                        inputStream = null;
                    }
                    if (downloadWithConnection == null) {
                        DownloadUtils.safeClose(null, null, null, null);
                        return;
                    }
                    inputStream = downloadWithConnection.getInputStream();
                    try {
                        byteArrayOutputStream = c.b(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        } catch (Exception e12) {
                            byteArrayInputStream2 = null;
                            e10 = e12;
                            byteArrayInputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th2 = th4;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e13) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e10 = e13;
                        byteArrayOutputStream = null;
                    } catch (Throwable th5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th2 = th5;
                        byteArrayOutputStream = null;
                    }
                    try {
                        byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (Exception e14) {
                        byteArrayInputStream2 = null;
                        e10 = e14;
                    } catch (Throwable th6) {
                        byteArrayInputStream2 = null;
                        th2 = th6;
                        Closeable[] closeableArr = new Closeable[i102];
                        closeableArr[0] = inputStream;
                        closeableArr[1] = byteArrayOutputStream;
                        closeableArr[2] = byteArrayInputStream;
                        closeableArr[3] = byteArrayInputStream2;
                        DownloadUtils.safeClose(closeableArr);
                        throw th2;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int a10 = com.ss.android.socialbase.appdownloader.c.a(DownloadComponentManager.getAppContext(), 44.0f);
                        options.inSampleSize = c.a(a10, a10, options);
                        options.inJustDecodeBounds = false;
                        c.this.f21838c.put(Integer.valueOf(i10), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr2);
                        i102 = closeableArr2;
                    } catch (Exception e15) {
                        e10 = e15;
                        e10.printStackTrace();
                        Closeable[] closeableArr3 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr3);
                        i102 = closeableArr3;
                    }
                } catch (Throwable th7) {
                    th2 = th7;
                }
            }
        });
    }

    public static int a(int i10, int i11, BitmapFactory.Options options) {
        int i12 = options.outWidth;
        if (i12 > i10 || options.outHeight > i11) {
            return Math.min(Math.round(i12 / i10), Math.round(options.outHeight / i11));
        }
        return 1;
    }
}
