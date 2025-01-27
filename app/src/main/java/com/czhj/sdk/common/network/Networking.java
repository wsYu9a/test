package com.czhj.sdk.common.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.SharedPreferencesUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.Cache;
import com.czhj.volley.ExecutorDelivery;
import com.czhj.volley.toolbox.BasicNetwork;
import com.czhj.volley.toolbox.FileDownloadNetwork;
import com.czhj.volley.toolbox.HurlStack;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.NoCache;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class Networking {

    /* renamed from: a */
    public static final String f8530a = "sigmob-volley-cache";

    /* renamed from: b */
    public static final String f8531b;

    /* renamed from: c */
    public static volatile SigmobRequestQueue f8532c;

    /* renamed from: d */
    public static volatile SigmobRequestQueue f8533d;

    /* renamed from: e */
    public static volatile SigmobRequestQueue f8534e;

    /* renamed from: f */
    public static volatile SigmobRequestQueue f8535f;

    /* renamed from: g */
    public static volatile String f8536g;

    /* renamed from: h */
    public static volatile String f8537h;

    /* renamed from: i */
    public static volatile MaxWidthImageLoader f8538i;

    /* renamed from: j */
    public static boolean f8539j;

    /* renamed from: k */
    public static HurlStack.UrlRewriter f8540k;

    /* renamed from: l */
    public static volatile Cache f8541l;

    /* renamed from: m */
    public static HashSet f8542m;

    /* renamed from: n */
    public static SigmobRequestQueue f8543n;

    /* renamed from: o */
    public static SigmobRequestQueue f8544o;

    /* renamed from: com.czhj.sdk.common.network.Networking$1 */
    public class AnonymousClass1 extends LruCache<String, Bitmap> {
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap != null ? bitmap.getRowBytes() * bitmap.getHeight() : super.sizeOf((AnonymousClass1) str, (String) null);
        }
    }

    /* renamed from: com.czhj.sdk.common.network.Networking$2 */
    public class AnonymousClass2 implements ImageLoader.ImageCache {

        /* renamed from: a */
        public final /* synthetic */ LruCache f8545a;

        public AnonymousClass2(LruCache lruCache) {
            lruCache = lruCache;
        }

        @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
        public Bitmap getBitmap(String str) {
            return (Bitmap) lruCache.get(str);
        }

        @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
        public void putBitmap(String str, Bitmap bitmap) {
            lruCache.put(str, bitmap);
        }
    }

    /* renamed from: com.czhj.sdk.common.network.Networking$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f8546a;

        public AnonymousClass3(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            String unused = Networking.f8536g = WebSettings.getDefaultUserAgent(context);
            SigmobLog.d("getUA time " + (System.currentTimeMillis() - currentTimeMillis));
            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(context).edit();
            edit.putString("user-agent-cache", Networking.f8536g);
            edit.apply();
        }
    }

    /* renamed from: com.czhj.sdk.common.network.Networking$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f8547a;

        public AnonymousClass4(Context context) {
            this.f8547a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    WebView webView = new WebView(this.f8547a);
                    webView.removeJavascriptInterface("searchBoxJavaBridge_");
                    webView.removeJavascriptInterface("accessibility");
                    webView.removeJavascriptInterface("accessibilityTraversal");
                    String unused = Networking.f8536g = webView.getSettings().getUserAgentString();
                    SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.f8547a).edit();
                    edit.putString("user-agent-cache", Networking.f8536g);
                    edit.apply();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    static {
        String property = System.getProperty("http.agent");
        f8531b = property;
        f8537h = property;
        f8539j = false;
        f8541l = null;
        f8542m = new HashSet();
    }

    public static void AddSigmobServerURL(String str) {
        f8542m.add(str);
    }

    public static SigmobRequestQueue b(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f8543n;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                try {
                    sigmobRequestQueue = f8543n;
                    if (sigmobRequestQueue == null) {
                        SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 5, Integer.MAX_VALUE, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
                        f8543n = sigmobRequestQueue2;
                        sigmobRequestQueue2.start();
                        sigmobRequestQueue = sigmobRequestQueue2;
                    }
                } finally {
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static HurlStack.UrlRewriter c(Context context) {
        if (f8540k == null) {
            f8540k = new PlayServicesUrlRewriter();
        }
        return f8540k;
    }

    public static SigmobRequestQueue getAdTrackerRetryQueue() {
        return f8544o;
    }

    public static String getBaseUrlScheme() {
        return b() ? "https" : "http";
    }

    public static SigmobRequestQueue getBuriedPointRequestQueue() {
        return f8534e;
    }

    public static String getCachedUserAgent() {
        String str = f8536g;
        return str == null ? f8531b : str;
    }

    public static SigmobRequestQueue getCommonRequestQueue() {
        return f8535f;
    }

    public static SigmobRequestQueue getDownloadRequestQueue() {
        return f8533d;
    }

    public static SigmobRequestQueue getRequestQueue() {
        return f8543n;
    }

    public static String getScheme() {
        return "https";
    }

    public static SigmobRequestQueue getSigRequestQueue() {
        return f8532c;
    }

    public static HashSet getSigmobServerURLS() {
        return f8542m;
    }

    public static HurlStack.UrlRewriter getUrlRewriter() {
        return f8540k;
    }

    public static String getUserAgent() {
        return TextUtils.isEmpty(f8536g) ? f8537h : f8536g;
    }

    public static void initialize(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context);
        initializeBuriedPointRequestQueue(context);
        initializeDownloadRequestQueue(context);
        b(context);
        initializeCommonRequestQueue(context);
        initializeImageLoader(context);
        initializeadTrackerReTryQueue(context);
    }

    public static SigmobRequestQueue initializeBuriedPointRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f8534e;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                try {
                    sigmobRequestQueue = f8534e;
                    if (sigmobRequestQueue == null) {
                        SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 1, 2);
                        f8534e = sigmobRequestQueue2;
                        sigmobRequestQueue2.start();
                        sigmobRequestQueue = sigmobRequestQueue2;
                    }
                } finally {
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue initializeCommonRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f8535f;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                try {
                    sigmobRequestQueue = f8535f;
                    if (sigmobRequestQueue == null) {
                        SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, 10);
                        f8535f = sigmobRequestQueue2;
                        sigmobRequestQueue2.start();
                        sigmobRequestQueue = sigmobRequestQueue2;
                    }
                } finally {
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue initializeDownloadRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f8533d;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                try {
                    sigmobRequestQueue = f8533d;
                    if (sigmobRequestQueue == null) {
                        SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new FileDownloadNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 1, 6);
                        f8533d = sigmobRequestQueue2;
                        sigmobRequestQueue2.start();
                        sigmobRequestQueue = sigmobRequestQueue2;
                    }
                } finally {
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static ImageLoader initializeImageLoader(Context context) {
        MaxWidthImageLoader maxWidthImageLoader = f8538i;
        if (maxWidthImageLoader == null) {
            synchronized (Networking.class) {
                try {
                    maxWidthImageLoader = f8538i;
                    if (maxWidthImageLoader == null) {
                        MaxWidthImageLoader maxWidthImageLoader2 = new MaxWidthImageLoader(getDownloadRequestQueue(), context, new ImageLoader.ImageCache() { // from class: com.czhj.sdk.common.network.Networking.2

                            /* renamed from: a */
                            public final /* synthetic */ LruCache f8545a;

                            public AnonymousClass2(LruCache lruCache) {
                                lruCache = lruCache;
                            }

                            @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
                            public Bitmap getBitmap(String str) {
                                return (Bitmap) lruCache.get(str);
                            }

                            @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
                            public void putBitmap(String str, Bitmap bitmap) {
                                lruCache.put(str, bitmap);
                            }
                        });
                        f8538i = maxWidthImageLoader2;
                        maxWidthImageLoader = maxWidthImageLoader2;
                    }
                } finally {
                }
            }
        }
        return maxWidthImageLoader;
    }

    public static void initializeMill(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context.getApplicationContext());
        b(context);
        initializeCommonRequestQueue(context);
        initializeBuriedPointRequestQueue(context);
    }

    public static SigmobRequestQueue initializeSigRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f8532c;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                try {
                    sigmobRequestQueue = f8532c;
                    if (sigmobRequestQueue == null) {
                        SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 5, 5);
                        f8532c = sigmobRequestQueue2;
                        sigmobRequestQueue2.start();
                        sigmobRequestQueue = sigmobRequestQueue2;
                    }
                } finally {
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static String initializeUserAgent(Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        String str = f8536g;
        if (str == null) {
            synchronized (Networking.class) {
                str = f8536g;
                if (str == null) {
                    try {
                        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.network.Networking.3

                            /* renamed from: a */
                            public final /* synthetic */ Context f8546a;

                            public AnonymousClass3(Context context2) {
                                context = context2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                long currentTimeMillis = System.currentTimeMillis();
                                String unused = Networking.f8536g = WebSettings.getDefaultUserAgent(context);
                                SigmobLog.d("getUA time " + (System.currentTimeMillis() - currentTimeMillis));
                                SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(context).edit();
                                edit.putString("user-agent-cache", Networking.f8536g);
                                edit.apply();
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return str;
    }

    public static void initializeUserAgentCache(Context context) {
        f8537h = SharedPreferencesUtil.getSharedPreferences(context).getString("user-agent-cache", f8531b);
    }

    public static void initializeV2(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context);
        initializeBuriedPointRequestQueue(context);
        initializeDownloadRequestQueue(context);
        initializeCommonRequestQueue(context);
        initializeadTrackerReTryQueue(context);
    }

    public static SigmobRequestQueue initializeadTrackerReTryQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue = f8544o;
        if (sigmobRequestQueue == null) {
            synchronized (Networking.class) {
                try {
                    sigmobRequestQueue = f8544o;
                    if (sigmobRequestQueue == null) {
                        BasicNetwork basicNetwork = new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000)));
                        if (f8541l == null) {
                            a(context);
                        }
                        SigmobRequestQueue sigmobRequestQueue2 = new SigmobRequestQueue(basicNetwork, 2, 10);
                        f8544o = sigmobRequestQueue2;
                        sigmobRequestQueue2.start();
                        sigmobRequestQueue = sigmobRequestQueue2;
                    }
                } finally {
                }
            }
        }
        return sigmobRequestQueue;
    }

    public static void useHttps(boolean z10) {
        f8539j = z10;
    }

    public static boolean b() {
        return f8539j;
    }

    public static Cache a(Context context) {
        if (f8541l == null) {
            f8541l = new NoCache();
        }
        return f8541l;
    }
}
