package com.czhj.sdk.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class ImageManager {

    /* renamed from: h */
    public static ImageManager f8624h;

    /* renamed from: a */
    public Context f8625a;

    /* renamed from: b */
    public final String f8626b = "SigImageCache";

    /* renamed from: c */
    public ExecutorService f8627c = Executors.newFixedThreadPool(2, new BackgroundThreadFactory());

    /* renamed from: d */
    public LruCache<String, Bitmap> f8628d = new LruCache<>(4194304);

    /* renamed from: e */
    public Handler f8629e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    public File f8630f;

    /* renamed from: g */
    public ImageView f8631g;

    /* renamed from: com.czhj.sdk.common.utils.ImageManager$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f8632a;

        /* renamed from: b */
        public final /* synthetic */ BitmapLoadedListener f8633b;

        /* renamed from: com.czhj.sdk.common.utils.ImageManager$1$1 */
        public class RunnableC02531 implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Bitmap f8635a;

            public RunnableC02531(Bitmap bitmap) {
                decodeStream = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                bitmapLoadedListener.onBitmapLoaded(decodeStream);
            }
        }

        /* renamed from: com.czhj.sdk.common.utils.ImageManager$1$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                bitmapLoadedListener.onBitmapLoadFailed();
            }
        }

        public AnonymousClass1(String str, BitmapLoadedListener bitmapLoadedListener) {
            url = str;
            bitmapLoadedListener = bitmapLoadedListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    ImageManager.this.f8629e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.1.1

                        /* renamed from: a */
                        public final /* synthetic */ Bitmap f8635a;

                        public RunnableC02531(Bitmap decodeStream2) {
                            decodeStream = decodeStream2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            bitmapLoadedListener.onBitmapLoaded(decodeStream);
                        }
                    });
                    ImageManager.this.f8628d.put(url, decodeStream2);
                    String str = url;
                    decodeStream2.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(ImageManager.this.a(), Md5Util.md5(str.substring(str.lastIndexOf("/") + 1)))));
                }
            } catch (Exception unused) {
                ImageManager.this.f8629e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.1.2
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        bitmapLoadedListener.onBitmapLoadFailed();
                    }
                });
            }
        }
    }

    public interface BitmapLoadedListener {
        void onBitmapLoadFailed();

        void onBitmapLoaded(Bitmap bitmap);
    }

    public class RequestCreatorRunnable implements Runnable {

        /* renamed from: a */
        public String f8638a;

        /* renamed from: b */
        public int f8639b;

        /* renamed from: c */
        public int f8640c;

        /* renamed from: d */
        public ImageView f8641d;

        /* renamed from: com.czhj.sdk.common.utils.ImageManager$RequestCreatorRunnable$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Bitmap f8643a;

            public AnonymousClass1(Bitmap bitmap) {
                decodeStream = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestCreatorRunnable.this.f8641d.setImageBitmap(decodeStream);
            }
        }

        /* renamed from: com.czhj.sdk.common.utils.ImageManager$RequestCreatorRunnable$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                RequestCreatorRunnable requestCreatorRunnable = RequestCreatorRunnable.this;
                int i10 = requestCreatorRunnable.f8640c;
                if (i10 == 0 || (imageView = requestCreatorRunnable.f8641d) == null) {
                    return;
                }
                imageView.setImageResource(i10);
            }
        }

        public RequestCreatorRunnable(String str) {
            this.f8638a = StringUtil.getUrl(str);
        }

        public final Bitmap a() {
            String str = this.f8638a;
            File file = new File(ImageManager.this.a(), Md5Util.md5(str.substring(str.lastIndexOf("/") + 1)));
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        public final void b() {
            ImageManager.this.f8629e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.RequestCreatorRunnable.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView;
                    RequestCreatorRunnable requestCreatorRunnable = RequestCreatorRunnable.this;
                    int i10 = requestCreatorRunnable.f8640c;
                    if (i10 == 0 || (imageView = requestCreatorRunnable.f8641d) == null) {
                        return;
                    }
                    imageView.setImageResource(i10);
                }
            });
        }

        public RequestCreatorRunnable error(int i10) {
            this.f8640c = i10;
            return this;
        }

        public void into(ImageView imageView) {
            this.f8641d = imageView;
            int i10 = this.f8639b;
            if (i10 != 0 && imageView != null) {
                imageView.setImageResource(i10);
            }
            if (TextUtils.isEmpty(this.f8638a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) ImageManager.this.f8628d.get(this.f8638a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap a10 = a();
            if (a10 == null) {
                ImageManager.this.f8627c.submit(this);
            } else {
                imageView.setImageBitmap(a10);
                ImageManager.this.f8628d.put(this.f8638a, a10);
            }
        }

        public RequestCreatorRunnable placeholder(int i10) {
            this.f8639b = i10;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f8638a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    ImageManager.this.f8629e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.RequestCreatorRunnable.1

                        /* renamed from: a */
                        public final /* synthetic */ Bitmap f8643a;

                        public AnonymousClass1(Bitmap decodeStream2) {
                            decodeStream = decodeStream2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RequestCreatorRunnable.this.f8641d.setImageBitmap(decodeStream);
                        }
                    });
                    ImageManager.this.f8628d.put(this.f8638a, decodeStream2);
                    String str = this.f8638a;
                    decodeStream2.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(ImageManager.this.a(), Md5Util.md5(str.substring(str.lastIndexOf("/") + 1)))));
                } else {
                    b();
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e10) {
                e10.printStackTrace();
                b();
            }
        }
    }

    public ImageManager(Context context) {
        this.f8625a = context.getApplicationContext();
    }

    public static ImageManager with(Context context) {
        return a(context);
    }

    public void clearCache() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(a().getAbsolutePath()), 100);
            if (clearCacheFileByCount == null) {
                str = "native ad file list is null";
            } else {
                str = "native ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th2) {
            SigmobLog.e("clean native ad file error", th2);
        }
    }

    public ImageManager customCachePath(File file) {
        this.f8630f = file;
        return this;
    }

    public void getBitmap(String str, BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String url = StringUtil.getUrl(str);
        Bitmap bitmap = this.f8628d.get(url);
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        File file = new File(a(), Md5Util.md5(url.substring(url.lastIndexOf("/") + 1)));
        Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile == null) {
            this.f8627c.submit(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.1

                /* renamed from: a */
                public final /* synthetic */ String f8632a;

                /* renamed from: b */
                public final /* synthetic */ BitmapLoadedListener f8633b;

                /* renamed from: com.czhj.sdk.common.utils.ImageManager$1$1 */
                public class RunnableC02531 implements Runnable {

                    /* renamed from: a */
                    public final /* synthetic */ Bitmap f8635a;

                    public RunnableC02531(Bitmap decodeStream2) {
                        decodeStream = decodeStream2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        bitmapLoadedListener.onBitmapLoaded(decodeStream);
                    }
                }

                /* renamed from: com.czhj.sdk.common.utils.ImageManager$1$2 */
                public class AnonymousClass2 implements Runnable {
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        bitmapLoadedListener.onBitmapLoadFailed();
                    }
                }

                public AnonymousClass1(String url2, BitmapLoadedListener bitmapLoadedListener2) {
                    url = url2;
                    bitmapLoadedListener = bitmapLoadedListener2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(2000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            Bitmap decodeStream2 = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            ImageManager.this.f8629e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.1.1

                                /* renamed from: a */
                                public final /* synthetic */ Bitmap f8635a;

                                public RunnableC02531(Bitmap decodeStream22) {
                                    decodeStream = decodeStream22;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    bitmapLoadedListener.onBitmapLoaded(decodeStream);
                                }
                            });
                            ImageManager.this.f8628d.put(url, decodeStream22);
                            String str2 = url;
                            decodeStream22.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(ImageManager.this.a(), Md5Util.md5(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        ImageManager.this.f8629e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.1.2
                            public AnonymousClass2() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                bitmapLoadedListener.onBitmapLoadFailed();
                            }
                        });
                    }
                }
            });
        } else {
            this.f8628d.put(url2, decodeFile);
            bitmapLoadedListener2.onBitmapLoaded(decodeFile);
        }
    }

    public RequestCreatorRunnable load(String str) {
        return new RequestCreatorRunnable(str);
    }

    public final File a() {
        File file = this.f8630f;
        if (file != null && file.isDirectory() && this.f8630f.exists()) {
            return this.f8630f;
        }
        File file2 = Environment.getExternalStorageState().equals("mounted") ? new File(this.f8625a.getExternalCacheDir(), "SigImageCache") : new File(this.f8625a.getCacheDir(), "SigImageCache");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static ImageManager a(Context context) {
        if (f8624h == null) {
            synchronized (ImageManager.class) {
                try {
                    if (f8624h == null) {
                        f8624h = new ImageManager(context);
                    }
                } finally {
                }
            }
        }
        return f8624h;
    }
}
