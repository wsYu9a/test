package com.ss.android.socialbase.appdownloader.q;

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
public class i {

    /* renamed from: j */
    private static int f24483j = 8;
    private static volatile i zx;

    /* renamed from: i */
    private j<Integer, Bitmap> f24484i;

    /* renamed from: com.ss.android.socialbase.appdownloader.q.i$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ String f24486j;
        final /* synthetic */ int zx;

        AnonymousClass1(String str, int i2) {
            str = str;
            i2 = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayInputStream byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream2;
            Throwable th;
            InputStream inputStream;
            Exception e2;
            IDownloadHttpConnection downloadWithConnection;
            int i2 = 4;
            i2 = 4;
            i2 = 4;
            i2 = 4;
            i2 = 4;
            try {
                try {
                    downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                } catch (Exception e3) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e2 = e3;
                    inputStream = null;
                } catch (Throwable th2) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th2;
                    inputStream = null;
                }
                if (downloadWithConnection == null) {
                    DownloadUtils.safeClose(null, null, null, null);
                    return;
                }
                inputStream = downloadWithConnection.getInputStream();
                try {
                    byteArrayOutputStream = i.zx(inputStream);
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        } catch (Exception e4) {
                            byteArrayInputStream2 = null;
                            e2 = e4;
                        } catch (Throwable th3) {
                            byteArrayInputStream2 = null;
                            th = th3;
                            Closeable[] closeableArr = new Closeable[i2];
                            closeableArr[0] = inputStream;
                            closeableArr[1] = byteArrayOutputStream;
                            closeableArr[2] = byteArrayInputStream;
                            closeableArr[3] = byteArrayInputStream2;
                            DownloadUtils.safeClose(closeableArr);
                            throw th;
                        }
                    } catch (Exception e5) {
                        byteArrayInputStream2 = null;
                        e2 = e5;
                        byteArrayInputStream = null;
                    } catch (Throwable th4) {
                        byteArrayInputStream2 = null;
                        th = th4;
                        byteArrayInputStream = null;
                    }
                } catch (Exception e6) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e2 = e6;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th5;
                    byteArrayOutputStream = null;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                    int j2 = com.ss.android.socialbase.appdownloader.i.j(DownloadComponentManager.getAppContext(), 44.0f);
                    options.inSampleSize = i.j(j2, j2, options);
                    options.inJustDecodeBounds = false;
                    i.this.f24484i.put(Integer.valueOf(i2), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                    Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                    DownloadUtils.safeClose(closeableArr2);
                    i2 = closeableArr2;
                } catch (Exception e7) {
                    e2 = e7;
                    e2.printStackTrace();
                    Closeable[] closeableArr3 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                    DownloadUtils.safeClose(closeableArr3);
                    i2 = closeableArr3;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    private static class j<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: j */
        final int f24487j;

        public j(int i2, int i3) {
            super(i3, 0.75f, true);
            this.f24487j = i2;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f24487j;
        }
    }

    private i() {
        this.f24484i = null;
        int i2 = f24483j;
        this.f24484i = new j<>(i2, i2 / 2);
    }

    public static ByteArrayOutputStream zx(InputStream inputStream) throws IOException {
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

    public static i j() {
        if (zx == null) {
            synchronized (i.class) {
                if (zx == null) {
                    zx = new i();
                }
            }
        }
        return zx;
    }

    public Bitmap j(int i2) {
        return this.f24484i.get(Integer.valueOf(i2));
    }

    public void j(int i2, String str) {
        if (TextUtils.isEmpty(str) || j(i2) != null) {
            return;
        }
        DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.q.i.1

            /* renamed from: j */
            final /* synthetic */ String f24486j;
            final /* synthetic */ int zx;

            AnonymousClass1(String str2, int i22) {
                str = str2;
                i2 = i22;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e2;
                IDownloadHttpConnection downloadWithConnection;
                int i22 = 4;
                i22 = 4;
                i22 = 4;
                i22 = 4;
                i22 = 4;
                try {
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e3) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e3;
                        inputStream = null;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th2;
                        inputStream = null;
                    }
                    if (downloadWithConnection == null) {
                        DownloadUtils.safeClose(null, null, null, null);
                        return;
                    }
                    inputStream = downloadWithConnection.getInputStream();
                    try {
                        byteArrayOutputStream = i.zx(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e2 = e4;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                                Closeable[] closeableArr = new Closeable[i22];
                                closeableArr[0] = inputStream;
                                closeableArr[1] = byteArrayOutputStream;
                                closeableArr[2] = byteArrayInputStream;
                                closeableArr[3] = byteArrayInputStream2;
                                DownloadUtils.safeClose(closeableArr);
                                throw th;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream2 = null;
                            e2 = e5;
                            byteArrayInputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e6) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e6;
                        byteArrayOutputStream = null;
                    } catch (Throwable th5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th5;
                        byteArrayOutputStream = null;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int j2 = com.ss.android.socialbase.appdownloader.i.j(DownloadComponentManager.getAppContext(), 44.0f);
                        options.inSampleSize = i.j(j2, j2, options);
                        options.inJustDecodeBounds = false;
                        i.this.f24484i.put(Integer.valueOf(i2), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr2);
                        i22 = closeableArr2;
                    } catch (Exception e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        Closeable[] closeableArr3 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr3);
                        i22 = closeableArr3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int j(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }
}
