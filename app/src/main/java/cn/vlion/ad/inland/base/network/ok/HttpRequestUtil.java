package cn.vlion.ad.inland.base.network.ok;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.c6;
import cn.vlion.ad.inland.base.d6;
import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionConfigTrakers;
import cn.vlion.ad.inland.base.javabean.VlionDAClkBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionNetRespType;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.k0;
import cn.vlion.ad.inland.base.k5;
import cn.vlion.ad.inland.base.l0;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.network.VideoCallback;
import cn.vlion.ad.inland.base.network.VlionHttpCallBack;
import cn.vlion.ad.inland.base.network.VlionHttpNetCallBack;
import cn.vlion.ad.inland.base.s4;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.down.VlionAdDownStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogConstant;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bz;
import com.czhj.sdk.common.Constants;
import com.google.gson.Gson;
import com.shu.priory.config.AdKeys;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HttpRequestUtil {
    private static final String DEBUG_CONFIGTRAKERS_URL = "http://api-gray-v3.mentamob.com:8000/api/v1/config_trakers";
    public static final String IV = "0123abcdef456789";
    public static final String KEY = "00190b14bb360d960f731cb0409bfcc2";
    private static final String RELEASE_CONFIGTRAKERS_URL = "https://api-v3.mentamob.com/api/v1/config_trakers";
    public static Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static int TYPY_UNKNOWN = 0;
    public static int TYPY_JPEG = 1;
    public static int TYPY_PNG = 2;
    public static int TYPY_GIF = 3;
    public static int TYPY_WEBP = 4;
    public static int TYPY_SVG = 5;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpNetCallBack f3120a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f3121b;

        /* renamed from: c */
        public final /* synthetic */ String f3122c;

        /* renamed from: d */
        public final /* synthetic */ long f3123d;

        public a(VlionHttpNetCallBack vlionHttpNetCallBack, Throwable th2, String str, long j10) {
            this.f3120a = vlionHttpNetCallBack;
            this.f3121b = th2;
            this.f3122c = str;
            this.f3123d = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3120a == null || this.f3121b == null) {
                return;
            }
            this.f3120a.onFail(new VlionAdBaseError(10005, this.f3121b.getMessage()), new VlionADNetBodyParameter(this.f3122c, this.f3123d, 0, 10005, System.currentTimeMillis() - this.f3123d, VlionNetRespType.menta_config, false, this.f3121b.getMessage()));
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ImageCallback f3124a;

        public b(ImageCallback imageCallback) {
            this.f3124a = imageCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageCallback imageCallback = this.f3124a;
            if (imageCallback != null) {
                imageCallback.onFail(VlionAdBaseError.SERVER_URL_IS_EMPTY);
            }
        }
    }

    public class c implements Callback {

        /* renamed from: a */
        public final /* synthetic */ ImageCallback f3125a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f3126b;

        /* renamed from: c */
        public final /* synthetic */ String f3127c;

        /* renamed from: d */
        public final /* synthetic */ boolean f3128d;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f3129a;

            public a(IOException iOException) {
                this.f3129a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImageCallback imageCallback = c.this.f3125a;
                if (imageCallback != null && this.f3129a != null) {
                    imageCallback.onFail(new VlionAdBaseError(10006, this.f3129a.getMessage()));
                }
                StringBuilder a10 = l1.a("HttpRequestUtil -- 下载 失败 ---");
                a10.append(this.f3129a.getMessage());
                LogVlion.e(a10.toString());
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ k5 f3131a;

            public b(k5 k5Var) {
                this.f3131a = k5Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                k5 k5Var;
                try {
                    ImageCallback imageCallback = c.this.f3125a;
                    if (imageCallback != null && (k5Var = this.f3131a) != null) {
                        imageCallback.onSuccess(new VlionImageSuccessData(k5Var.getIntrinsicWidth(), this.f3131a.getIntrinsicHeight()));
                    }
                    LogVlion.e("HttpRequestUtil 成功返回 gif  ");
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        /* renamed from: cn.vlion.ad.inland.base.network.ok.HttpRequestUtil$c$c */
        public class RunnableC0027c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Bitmap f3133a;

            public RunnableC0027c(Bitmap bitmap) {
                this.f3133a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                Bitmap bitmap;
                try {
                    c cVar = c.this;
                    if (cVar.f3125a == null || (bitmap = this.f3133a) == null) {
                        str = "HttpRequestUtil 成功返回 bitmap  失败  " + c.this.f3127c;
                    } else {
                        ImageView imageView = cVar.f3126b;
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        if (c.this.f3128d) {
                            cn.vlion.ad.inland.base.u.b().a(c.this.f3127c, this.f3133a);
                        }
                        c.this.f3125a.onSuccess(new VlionImageSuccessData(this.f3133a.getWidth(), this.f3133a.getHeight()));
                        str = "HttpRequestUtil 成功返回 bitmap ";
                    }
                    LogVlion.e(str);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImageCallback imageCallback = c.this.f3125a;
                if (imageCallback != null) {
                    imageCallback.onFail(VlionAdBaseError.LOAD_BODY_NULL);
                }
            }
        }

        public class e implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f3136a;

            public e(IOException iOException) {
                this.f3136a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImageCallback imageCallback = c.this.f3125a;
                if (imageCallback == null || this.f3136a == null) {
                    return;
                }
                imageCallback.onFail(new VlionAdBaseError(10005, this.f3136a.getMessage()));
            }
        }

        public class f implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Throwable f3138a;

            public f(Throwable th2) {
                this.f3138a = th2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImageCallback imageCallback = c.this.f3125a;
                if (imageCallback == null || this.f3138a == null) {
                    return;
                }
                imageCallback.onFail(new VlionAdBaseError(10005, this.f3138a.getMessage()));
            }
        }

        public c(ImageView imageView, String str, ImageCallback imageCallback, boolean z10) {
            this.f3125a = imageCallback;
            this.f3126b = imageView;
            this.f3127c = str;
            this.f3128d = z10;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            HttpRequestUtil.mainHandler.post(new a(iOException));
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x015c A[Catch: all -> 0x00c2, IOException -> 0x00c5, TryCatch #4 {IOException -> 0x00c5, all -> 0x00c2, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x00b6, B:8:0x00bc, B:9:0x0151, B:10:0x0155, B:12:0x015c, B:14:0x0175, B:15:0x0189, B:16:0x01c1, B:20:0x0194, B:21:0x01b7, B:25:0x019a, B:27:0x01a9, B:30:0x00ce, B:32:0x00d4, B:34:0x00da, B:36:0x00de, B:38:0x00e4, B:40:0x00e8, B:42:0x00ee, B:44:0x00f2, B:47:0x00fd, B:49:0x0101, B:51:0x0105, B:53:0x010b, B:55:0x0111, B:57:0x0117, B:60:0x0120, B:62:0x0124, B:64:0x0128, B:66:0x012c, B:69:0x0138, B:71:0x013e, B:73:0x0144, B:75:0x014a, B:77:0x01c5), top: B:1:0x0000, inners: #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onResponse(okhttp3.Call r14, okhttp3.Response r15) {
            /*
                Method dump skipped, instructions count: 513
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.network.ok.HttpRequestUtil.c.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ImageCallback f3140a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f3141b;

        public d(ImageCallback imageCallback, Throwable th2) {
            this.f3140a = imageCallback;
            this.f3141b = th2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageCallback imageCallback = this.f3140a;
            if (imageCallback == null || this.f3141b == null) {
                return;
            }
            imageCallback.onFail(new VlionAdBaseError(10005, this.f3141b.getMessage()));
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f3142a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f3143b;

        /* renamed from: c */
        public final /* synthetic */ ImageCallback f3144c;

        public e(ImageView imageView, String str, ImageCallback imageCallback) {
            this.f3142a = str;
            this.f3143b = imageView;
            this.f3144c = imageCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Bitmap a10 = cn.vlion.ad.inland.base.u.b().a(this.f3142a);
                if (a10 == null) {
                    HttpRequestUtil.downloadBitmap(this.f3143b, this.f3142a, this.f3144c, true);
                    return;
                }
                ImageView imageView = this.f3143b;
                if (imageView != null) {
                    imageView.setImageBitmap(a10);
                }
                ImageCallback imageCallback = this.f3144c;
                if (imageCallback != null) {
                    imageCallback.onSuccess(new VlionImageSuccessData(a10.getWidth(), a10.getHeight()));
                }
                LogVlion.e("downloadBitmapNeedCache 缓存--- bitmap ");
            } catch (Throwable unused) {
                HttpRequestUtil.downloadBitmap(this.f3143b, this.f3142a, this.f3144c, true);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f3145a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f3146b;

        /* renamed from: c */
        public final /* synthetic */ ImageCallback f3147c;

        public f(ImageView imageView, String str, ImageCallback imageCallback) {
            this.f3145a = str;
            this.f3146b = imageView;
            this.f3147c = imageCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                k5 a10 = cn.vlion.ad.inland.base.v.a().a(this.f3145a);
                if (a10 == null) {
                    HttpRequestUtil.downloadBitmap(this.f3146b, this.f3145a, this.f3147c, true);
                    return;
                }
                ImageView imageView = this.f3146b;
                if (imageView != null) {
                    imageView.setImageDrawable(a10);
                    a10.f3044b = SystemClock.uptimeMillis();
                }
                ImageCallback imageCallback = this.f3147c;
                if (imageCallback != null) {
                    imageCallback.onSuccess(new VlionImageSuccessData(a10.getIntrinsicWidth(), a10.getIntrinsicHeight()));
                }
                LogVlion.e("downloadDrawableNeedCache 缓存--- drawable ");
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                HttpRequestUtil.downloadBitmap(this.f3146b, this.f3145a, this.f3147c, true);
            }
        }
    }

    public class g implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VideoCallback f3148a;

        public g(VideoCallback videoCallback) {
            this.f3148a = videoCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoCallback videoCallback = this.f3148a;
            if (videoCallback != null) {
                videoCallback.onFail(VlionAdBaseError.SERVER_URL_IS_EMPTY);
            }
        }
    }

    public class h implements Callback {

        /* renamed from: a */
        public final /* synthetic */ VideoCallback f3149a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f3150a;

            public a(IOException iOException) {
                this.f3150a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoCallback videoCallback = h.this.f3149a;
                if (videoCallback == null || this.f3150a == null) {
                    return;
                }
                videoCallback.onFail(new VlionAdBaseError(10006, this.f3150a.getMessage()));
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ ResponseBody f3152a;

            public b(ResponseBody responseBody) {
                this.f3152a = responseBody;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoCallback videoCallback = h.this.f3149a;
                if (videoCallback != null) {
                    videoCallback.onSuccess(this.f3152a);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoCallback videoCallback = h.this.f3149a;
                if (videoCallback != null) {
                    videoCallback.onFail(VlionAdBaseError.LOAD_BODY_NULL);
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Throwable f3155a;

            public d(Throwable th2) {
                this.f3155a = th2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoCallback videoCallback = h.this.f3149a;
                if (videoCallback == null || this.f3155a == null) {
                    return;
                }
                videoCallback.onFail(new VlionAdBaseError(10005, this.f3155a.getMessage()));
            }
        }

        public h(VideoCallback videoCallback) {
            this.f3149a = videoCallback;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            HttpRequestUtil.mainHandler.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            LogVlion.e("downloadVideo onResponse");
            try {
                ResponseBody body = response.body();
                if (body != null) {
                    HttpRequestUtil.mainHandler.post(new b(body));
                } else {
                    HttpRequestUtil.mainHandler.post(new c());
                }
            } catch (Throwable th2) {
                HttpRequestUtil.mainHandler.post(new d(th2));
                LogVlion.e("error " + th2);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VideoCallback f3157a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f3158b;

        public i(VideoCallback videoCallback, Throwable th2) {
            this.f3157a = videoCallback;
            this.f3158b = th2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoCallback videoCallback = this.f3157a;
            if (videoCallback == null || this.f3158b == null) {
                return;
            }
            videoCallback.onFail(new VlionAdBaseError(10005, this.f3158b.getMessage()));
        }
    }

    public class j implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ l0 f3159a;

        public j(l0 l0Var) {
            this.f3159a = l0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c6 a10 = c6.a();
            l0 l0Var = this.f3159a;
            synchronized (a10) {
                try {
                    VlionHandlerUtils.instant().post(new d6(a10, l0Var));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public class k implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpCallBack f3160a;

        public k(VlionHttpCallBack vlionHttpCallBack) {
            this.f3160a = vlionHttpCallBack;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3160a.onFail(VlionAdBaseError.SERVER_URL_IS_EMPTY);
        }
    }

    public class l implements Callback {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpCallBack f3161a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f3162a;

            public a(IOException iOException) {
                this.f3162a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VlionHttpCallBack vlionHttpCallBack = l.this.f3161a;
                if (vlionHttpCallBack != null) {
                    vlionHttpCallBack.onFail(new VlionAdBaseError(10004, this.f3162a.getMessage()));
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f3164a;

            public b(String str) {
                this.f3164a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VlionHttpCallBack vlionHttpCallBack = l.this.f3161a;
                if (vlionHttpCallBack != null) {
                    vlionHttpCallBack.onSuccess(this.f3164a);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VlionHttpCallBack vlionHttpCallBack = l.this.f3161a;
                if (vlionHttpCallBack != null) {
                    vlionHttpCallBack.onFail(VlionAdBaseError.NO_FILL_BODY);
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VlionHttpCallBack vlionHttpCallBack = l.this.f3161a;
                if (vlionHttpCallBack != null) {
                    vlionHttpCallBack.onFail(VlionAdBaseError.NO_FILL_BODY);
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                VlionHttpCallBack vlionHttpCallBack = l.this.f3161a;
                if (vlionHttpCallBack != null) {
                    vlionHttpCallBack.onFail(VlionAdBaseError.NO_FILL_BODY);
                }
            }
        }

        public l(VlionHttpCallBack vlionHttpCallBack) {
            this.f3161a = vlionHttpCallBack;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            StringBuilder a10 = l1.a("uploadReport onFailure ");
            a10.append(iOException.getMessage());
            LogVlion.e(a10.toString());
            HttpRequestUtil.mainHandler.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            Handler handler;
            Runnable eVar;
            if (response != null) {
                ResponseBody body = response.body();
                if (body != null) {
                    String string = body.string();
                    LogVlion.e("uploadReport  string = " + string + " response.code()=" + response.code());
                    if (response.code() == 200) {
                        HttpRequestUtil.mainHandler.post(new b(string));
                        return;
                    } else {
                        handler = HttpRequestUtil.mainHandler;
                        eVar = new c();
                    }
                } else {
                    handler = HttpRequestUtil.mainHandler;
                    eVar = new d();
                }
            } else {
                handler = HttpRequestUtil.mainHandler;
                eVar = new e();
            }
            handler.post(eVar);
        }
    }

    public class m implements Callback {

        /* renamed from: a */
        public final /* synthetic */ String f3169a;

        public m(String str) {
            this.f3169a = str;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            StringBuilder a10 = l1.a("submitBehaviorRetryAsyn sdkException onFailure:");
            a10.append(iOException.getMessage());
            LogVlion.e(a10.toString());
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            if (response != null) {
                try {
                    int code = response.code();
                    LogVlion.e("submitBehaviorRetryAsyn onResponse " + code + " url=" + this.f3169a);
                    if (code == 200) {
                        LogVlion.e("submitBehaviorRetryAsyn success ");
                    }
                } catch (Throwable th2) {
                    s4.a("submitBehaviorRetryAsyn sdkException Exception:", th2);
                }
            }
        }
    }

    public class n implements Callback {
        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            StringBuilder a10 = l1.a("sdkException sdkException onFailure:");
            a10.append(iOException.getMessage());
            LogVlion.e(a10.toString());
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            if (response == null || response.body() == null) {
                return;
            }
            StringBuilder a10 = l1.a("sdkException sdkException onResponse:");
            a10.append(response.body().string());
            LogVlion.e(a10.toString());
        }
    }

    public class o implements Callback {

        /* renamed from: a */
        public final /* synthetic */ VlionServiceConfig.AutoBean f3170a;

        /* renamed from: b */
        public final /* synthetic */ VlionServiceConfig.ScenesBean f3171b;

        /* renamed from: c */
        public final /* synthetic */ int f3172c;

        public o(VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean, int i10) {
            this.f3170a = autoBean;
            this.f3171b = scenesBean;
            this.f3172c = i10;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            StringBuilder a10 = l1.a("Down 策略 : submitBehaviordaAsyn sdkException onFailure:");
            a10.append(iOException.getMessage());
            LogVlion.e(a10.toString());
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            ResponseBody body;
            String string;
            VlionServiceConfig.ScenesBean scenesBean;
            boolean z10;
            StringBuilder sb2;
            if (response != null) {
                try {
                    int code = response.code();
                    LogVlion.e("Down 策略 : submitTrakersSync onResponse " + code);
                    if (code != 200 || (body = response.body()) == null || (string = body.string()) == null) {
                        return;
                    }
                    try {
                        VlionConfigTrakers vlionConfigTrakers = (VlionConfigTrakers) new Gson().fromJson(string, VlionConfigTrakers.class);
                        if (vlionConfigTrakers == null || this.f3170a == null || (scenesBean = this.f3171b) == null) {
                            return;
                        }
                        if (scenesBean.getNeedRta() == 0) {
                            LogVlion.e("Down 策略 : 包名：" + this.f3170a.getBundle() + " 不需要rta 结果 直接开始 打点 - =");
                            z10 = true;
                        } else {
                            if (this.f3171b.getNeedRta() == 1) {
                                if (VlionAdDownStrategyUtils.getInstance().getStrategyBeanCount(this.f3170a.getBundle() + this.f3170a.getPid() + this.f3171b.getId() + "_v_rta_time").longValue() + VlionServiceConfigParse.getInstance().getAutoAttribution().getRtaCacheTime() > VlionDateUtils.dateFormatMinute()) {
                                    long longValue = VlionAdDownStrategyUtils.getInstance().getStrategyBeanCount(this.f3170a.getBundle() + this.f3170a.getPid() + this.f3171b.getId() + "_v_rta").longValue();
                                    z10 = longValue == 1;
                                    sb2 = new StringBuilder();
                                    sb2.append("Down 策略 : 包名：");
                                    sb2.append(this.f3170a.getBundle());
                                    sb2.append(" 本地有缓存结果    - tesultRta==");
                                    sb2.append(longValue);
                                } else {
                                    VlionAdDownStrategyUtils.getInstance().setDownStrategyBean(this.f3170a.getBundle() + this.f3170a.getPid() + this.f3171b.getId() + "_v_rta_time", VlionDateUtils.dateFormatMinute());
                                    VlionAdDownStrategyUtils.getInstance().setDownStrategyBean(this.f3170a.getBundle() + this.f3170a.getPid() + this.f3171b.getId() + "_v_rta", vlionConfigTrakers.getRtaRes());
                                    z10 = vlionConfigTrakers.getRtaRes() == 1;
                                    sb2 = new StringBuilder();
                                    sb2.append("Down 策略 : 包名：");
                                    sb2.append(this.f3170a.getBundle());
                                    sb2.append(" 在线结果    - tesultRta==");
                                    sb2.append(vlionConfigTrakers.getRtaRes());
                                }
                                LogVlion.e(sb2.toString());
                            }
                        }
                        if (z10) {
                            Random random = new Random();
                            int nextInt = random.nextInt(100);
                            if (nextInt < this.f3171b.getsDropRate() * 100.0f) {
                                LogVlion.e("Down 策略 : 包名：" + this.f3170a.getBundle() + " 被丢弃-----------：+dropRatevalue =" + nextInt + "  total = " + (this.f3171b.getsDropRate() * 100.0f));
                                return;
                            }
                            LogVlion.e("Down 策略 : 包名：" + this.f3170a.getBundle() + " --------：+dropRatevalue =" + nextInt + "  totalDropRate = " + (this.f3171b.getsDropRate() * 100.0f));
                            VlionAdDownStrategyUtils vlionAdDownStrategyUtils = VlionAdDownStrategyUtils.getInstance();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.f3170a.getBundle());
                            sb3.append(this.f3170a.getPid());
                            sb3.append(this.f3171b.getId());
                            sb3.append("_v_st");
                            long longValue2 = vlionAdDownStrategyUtils.getStrategyBeanCount(sb3.toString()).longValue();
                            long j10 = 0;
                            if (longValue2 > this.f3171b.getSurlDayTimes()) {
                                LogVlion.e(LogConstant.TAG_DOWN_STRATEGY + this.f3170a.getBundle() + " 曝光次数  超过上限 今日不再执行  本地记录 ：" + longValue2 + "  服务器上限：" + this.f3171b.getSurlDayTimes());
                            } else if (vlionConfigTrakers.getImpTrackers() != null) {
                                for (Iterator<String> it = vlionConfigTrakers.getImpTrackers().iterator(); it.hasNext(); it = it) {
                                    j10 += this.f3171b.getSurlDelay();
                                    HttpRequestUtil.StartTimerMillisecond(j10, it.next(), true, this.f3172c, this.f3170a, this.f3171b);
                                }
                                VlionAdDownStrategyUtils.getInstance().setDownStrategyBean(this.f3170a.getBundle() + this.f3170a.getPid() + this.f3171b.getId() + "_v_st", longValue2 + 1);
                            }
                            int i10 = (int) (100.0f - (this.f3171b.getsDropRate() * 100.0f));
                            int nextInt2 = random.nextInt(i10);
                            float f10 = i10;
                            if (nextInt2 < this.f3171b.getcDropRate() * f10) {
                                LogVlion.e("Down 策略 : 包名：" + this.f3170a.getBundle() + " 被丢弃-----------：+click dropRatevalue =" + nextInt2 + " click total = " + i10 + "  click totalRatevalue = " + (f10 * this.f3171b.getcDropRate()));
                                return;
                            }
                            LogVlion.e("Down 策略 : 包名：" + this.f3170a.getBundle() + " --------click--：+dropRatevalue =" + nextInt2 + "  clicktotal = " + i10 + " click  totalRatevalue = " + (f10 * this.f3171b.getcDropRate()));
                            VlionAdDownStrategyUtils vlionAdDownStrategyUtils2 = VlionAdDownStrategyUtils.getInstance();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(this.f3170a.getBundle());
                            sb4.append(this.f3170a.getPid());
                            sb4.append(this.f3171b.getId());
                            sb4.append("_v_ct");
                            long longValue3 = vlionAdDownStrategyUtils2.getStrategyBeanCount(sb4.toString()).longValue();
                            if (longValue3 > this.f3171b.getCurlDayTimes()) {
                                LogVlion.e(LogConstant.TAG_DOWN_STRATEGY + this.f3170a.getBundle() + " 曝光次数  超过上限 今日不再执行  本地记录 ：" + longValue3 + "  服务器上限：" + this.f3171b.getCurlDayTimes());
                                return;
                            }
                            if (vlionConfigTrakers.getClkTrackers() != null) {
                                Iterator<String> it2 = vlionConfigTrakers.getClkTrackers().iterator();
                                while (it2.hasNext()) {
                                    j10 += this.f3171b.getCurlDelay();
                                    HttpRequestUtil.StartTimerMillisecond(j10, it2.next(), false, this.f3172c, this.f3170a, this.f3171b);
                                }
                                VlionAdDownStrategyUtils.getInstance().setDownStrategyBean(this.f3170a.getBundle() + this.f3170a.getPid() + this.f3171b.getId() + "_v_ct", longValue3 + 1);
                                if (this.f3171b.getDpSwitch() != 1 || TextUtils.isEmpty(this.f3170a.getDp())) {
                                    return;
                                }
                                long dpDelay = j10 + this.f3171b.getDpDelay();
                                HttpRequestUtil.StartdeeplinkTimerMilli(dpDelay, this.f3172c, this.f3170a, this.f3171b, dpDelay);
                            }
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                } catch (Throwable th3) {
                    s4.a("Down 策略 : submitBehaviordaAsyn sdkException Exception:", th3);
                }
            }
        }
    }

    public class p implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionServiceConfig.AutoBean f3173a;

        /* renamed from: b */
        public final /* synthetic */ VlionServiceConfig.ScenesBean f3174b;

        /* renamed from: c */
        public final /* synthetic */ int f3175c;

        /* renamed from: d */
        public final /* synthetic */ long f3176d;

        public p(VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean, int i10, long j10) {
            this.f3173a = autoBean;
            this.f3174b = scenesBean;
            this.f3175c = i10;
            this.f3176d = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i10;
            long j10;
            VlionDAClkBodyParameter vlionDAClkBodyParameter;
            try {
                if (this.f3173a != null) {
                    LogVlion.e("Down 策略 :  定时任务开始执行 打开： " + this.f3173a.getDp());
                    String bundle = this.f3173a.getBundle();
                    String type = this.f3173a.getExp().getType();
                    String adgroupid = this.f3173a.getAdgroupid();
                    String dp = this.f3173a.getDp();
                    String str = this.f3174b.getDpOpenRatio() + "";
                    if (cn.vlion.ad.inland.base.q.a((Context) VlionSDkManager.getInstance().getApplication(), this.f3173a.getDp())) {
                        cn.vlion.ad.inland.base.q.a(VlionSDkManager.getInstance().getApplication(), this.f3173a.getDp());
                        i10 = this.f3175c;
                        j10 = this.f3176d;
                        vlionDAClkBodyParameter = new VlionDAClkBodyParameter(dp, "0", str, "0", "", type, adgroupid);
                    } else {
                        i10 = this.f3175c;
                        j10 = this.f3176d;
                        vlionDAClkBodyParameter = new VlionDAClkBodyParameter(dp, "-1", str, "-1", "打开失败 ", type, adgroupid);
                    }
                    VlionADEventManager.submitDeeplink(i10, bundle, j10, vlionDAClkBodyParameter);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class q implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f3177a;

        /* renamed from: b */
        public final /* synthetic */ VlionServiceConfig.AutoBean f3178b;

        /* renamed from: c */
        public final /* synthetic */ String f3179c;

        /* renamed from: d */
        public final /* synthetic */ boolean f3180d;

        /* renamed from: e */
        public final /* synthetic */ int f3181e;

        /* renamed from: f */
        public final /* synthetic */ VlionServiceConfig.ScenesBean f3182f;

        public q(long j10, String str, boolean z10, int i10, VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean) {
            this.f3177a = j10;
            this.f3178b = autoBean;
            this.f3179c = str;
            this.f3180d = z10;
            this.f3181e = i10;
            this.f3182f = scenesBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("Down 策略 :  定时任务开始执行 111111111111111111111111 已延迟 " + this.f3177a + " 毫秒  包名： " + this.f3178b.getBundle());
                HttpRequestUtil.submitBehaviorDaSync(this.f3179c, this.f3180d, this.f3181e, this.f3178b, this.f3182f, this.f3177a);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class r implements Callback {

        /* renamed from: a */
        public final /* synthetic */ String f3183a;

        /* renamed from: b */
        public final /* synthetic */ boolean f3184b;

        /* renamed from: c */
        public final /* synthetic */ int f3185c;

        /* renamed from: d */
        public final /* synthetic */ String f3186d;

        /* renamed from: e */
        public final /* synthetic */ String f3187e;

        /* renamed from: f */
        public final /* synthetic */ String f3188f;

        /* renamed from: g */
        public final /* synthetic */ String f3189g;

        /* renamed from: h */
        public final /* synthetic */ String f3190h;

        /* renamed from: i */
        public final /* synthetic */ String f3191i;

        /* renamed from: j */
        public final /* synthetic */ long f3192j;

        public r(String str, boolean z10, int i10, String str2, String str3, String str4, String str5, String str6, String str7, long j10) {
            this.f3183a = str;
            this.f3184b = z10;
            this.f3185c = i10;
            this.f3186d = str2;
            this.f3187e = str3;
            this.f3188f = str4;
            this.f3189g = str5;
            this.f3190h = str6;
            this.f3191i = str7;
            this.f3192j = j10;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            StringBuilder a10 = l1.a("Down 策略 : submitBehaviordaAsyn sdkException onFailure:");
            a10.append(iOException.getMessage());
            LogVlion.e(a10.toString());
            VlionADEventManager.submitDaclk(this.f3184b, this.f3185c, this.f3186d, new VlionDAClkBodyParameter(this.f3187e, this.f3188f, this.f3189g, "10000", iOException.toString(), this.f3190h, this.f3191i), this.f3192j);
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            if (response != null) {
                try {
                    int code = response.code();
                    ResponseBody body = response.body();
                    String string = body != null ? body.string() : "";
                    LogVlion.e("Down 策略 : submitBehaviordaAsyn onResponse " + code + " url=" + this.f3183a);
                    if (code == 200) {
                        LogVlion.e("Down 策略 : submitBehaviordaAsyn success ");
                        VlionADEventManager.submitDaclk(this.f3184b, this.f3185c, this.f3186d, new VlionDAClkBodyParameter(this.f3187e, this.f3188f, this.f3189g, "0", string, this.f3190h, this.f3191i), this.f3192j);
                        return;
                    }
                    VlionADEventManager.submitDaclk(this.f3184b, this.f3185c, this.f3186d, new VlionDAClkBodyParameter(this.f3187e, this.f3188f, this.f3189g, code + "", string, this.f3190h, this.f3191i), this.f3192j);
                } catch (Throwable th2) {
                    s4.a("Down 策略 : submitBehaviordaAsyn sdkException Exception:", th2);
                    VlionADEventManager.submitDaclk(this.f3184b, this.f3185c, this.f3186d, new VlionDAClkBodyParameter(this.f3187e, this.f3188f, this.f3189g, "10005", th2.toString(), this.f3190h, this.f3191i), this.f3192j);
                }
            }
        }
    }

    public class s implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpCallBack f3193a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f3194b;

        public s(VlionHttpCallBack vlionHttpCallBack, Throwable th2) {
            this.f3193a = vlionHttpCallBack;
            this.f3194b = th2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VlionHttpCallBack vlionHttpCallBack = this.f3193a;
            if (vlionHttpCallBack != null) {
                vlionHttpCallBack.onFail(new VlionAdBaseError(10005, this.f3194b.getMessage()));
            }
        }
    }

    public class t implements Callback {
        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            StringBuilder a10 = l1.a("uploadAdEventAsyn sdkException onFailure:");
            a10.append(iOException.getMessage());
            LogVlion.e(a10.toString());
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            if (response != null) {
                try {
                    LogVlion.e("uploadAdEventAsyn  sendResult = " + response.code());
                    ResponseBody body = response.body();
                    if (body != null) {
                        LogVlion.e("uploadAdEventAsyn  string = " + body.string());
                        if (response.code() == 200) {
                            LogVlion.e("uploadAdEventAsyn  sendResult success ");
                        }
                    }
                } catch (Throwable th2) {
                    s4.a("uploadAdEventAsyn sdkException Exception:", th2);
                }
            }
        }
    }

    public class u implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f3195a;

        /* renamed from: b */
        public final /* synthetic */ long f3196b;

        /* renamed from: c */
        public final /* synthetic */ VlionHttpNetCallBack f3197c;

        public u(long j10, VlionHttpNetCallBack vlionHttpNetCallBack, String str) {
            this.f3195a = str;
            this.f3196b = j10;
            this.f3197c = vlionHttpNetCallBack;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String str = this.f3195a;
                long j10 = this.f3196b;
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.SERVER_URL_IS_EMPTY;
                VlionADNetBodyParameter vlionADNetBodyParameter = new VlionADNetBodyParameter(str, j10, 0, vlionAdBaseError.getErrorCode(), System.currentTimeMillis() - this.f3196b, VlionNetRespType.adx_api, false, vlionAdBaseError.getErrorMessage());
                VlionHttpNetCallBack vlionHttpNetCallBack = this.f3197c;
                if (vlionHttpNetCallBack != null) {
                    vlionHttpNetCallBack.onFail(vlionAdBaseError, vlionADNetBodyParameter);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class v implements Callback {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpNetCallBack f3198a;

        /* renamed from: b */
        public final /* synthetic */ String f3199b;

        /* renamed from: c */
        public final /* synthetic */ long f3200c;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f3201a;

            public a(IOException iOException) {
                this.f3201a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v vVar = v.this;
                if (vVar.f3198a == null || this.f3201a == null) {
                    return;
                }
                v.this.f3198a.onFail(new VlionAdBaseError(10004, this.f3201a.getMessage()), new VlionADNetBodyParameter(vVar.f3199b, vVar.f3200c, 0, 10004, System.currentTimeMillis() - v.this.f3200c, VlionNetRespType.adx_api, false, this.f3201a.getMessage()));
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f3203a;

            /* renamed from: b */
            public final /* synthetic */ int f3204b;

            /* renamed from: c */
            public final /* synthetic */ v f3205c;

            public b(int i10, v vVar, String str) {
                this.f3205c = vVar;
                this.f3203a = str;
                this.f3204b = i10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v vVar = this.f3205c;
                VlionADNetBodyParameter vlionADNetBodyParameter = new VlionADNetBodyParameter(vVar.f3199b, vVar.f3200c, this.f3203a.length(), this.f3204b, System.currentTimeMillis() - this.f3205c.f3200c, VlionNetRespType.adx_api, true, "");
                VlionHttpNetCallBack vlionHttpNetCallBack = this.f3205c.f3198a;
                if (vlionHttpNetCallBack != null) {
                    vlionHttpNetCallBack.onSuccess(this.f3203a, vlionADNetBodyParameter);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f3206a;

            /* renamed from: b */
            public final /* synthetic */ String f3207b;

            /* renamed from: c */
            public final /* synthetic */ v f3208c;

            public c(int i10, v vVar, String str) {
                this.f3208c = vVar;
                this.f3206a = i10;
                this.f3207b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v vVar = this.f3208c;
                if (vVar.f3198a != null) {
                    this.f3208c.f3198a.onFail(VlionAdBaseError.NO_FILL_BODY, new VlionADNetBodyParameter(vVar.f3199b, vVar.f3200c, 0, this.f3206a, System.currentTimeMillis() - this.f3208c.f3200c, VlionNetRespType.adx_api, false, this.f3207b));
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f3209a;

            public d(String str) {
                this.f3209a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v vVar = v.this;
                if (vVar.f3198a != null) {
                    String str = vVar.f3199b;
                    long j10 = vVar.f3200c;
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.NO_FILL_BODY;
                    v.this.f3198a.onFail(vlionAdBaseError, new VlionADNetBodyParameter(str, j10, 0, vlionAdBaseError.getErrorCode(), System.currentTimeMillis() - v.this.f3200c, VlionNetRespType.adx_api, false, this.f3209a));
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                v vVar = v.this;
                if (vVar.f3198a != null) {
                    String str = vVar.f3199b;
                    long j10 = vVar.f3200c;
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.NO_FILL_BODY;
                    v.this.f3198a.onFail(vlionAdBaseError, new VlionADNetBodyParameter(str, j10, 0, vlionAdBaseError.getErrorCode(), System.currentTimeMillis() - v.this.f3200c, VlionNetRespType.adx_api, false, "null == response"));
                }
            }
        }

        public class f implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Throwable f3212a;

            public f(Throwable th2) {
                this.f3212a = th2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                v vVar = v.this;
                if (vVar.f3198a == null || this.f3212a == null) {
                    return;
                }
                v.this.f3198a.onFail(new VlionAdBaseError(10005, this.f3212a.getMessage()), new VlionADNetBodyParameter(vVar.f3199b, vVar.f3200c, 0, 10005, System.currentTimeMillis() - v.this.f3200c, VlionNetRespType.adx_api, false, this.f3212a.getMessage()));
            }
        }

        public v(long j10, VlionHttpNetCallBack vlionHttpNetCallBack, String str) {
            this.f3198a = vlionHttpNetCallBack;
            this.f3199b = str;
            this.f3200c = j10;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            HttpRequestUtil.mainHandler.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            Handler handler;
            Runnable eVar;
            try {
                LogVlion.e("getAdData onResponse isSuccessful: " + response);
                if (response != null) {
                    String response2 = response.toString();
                    LogVlion.e("getAdData onResponse isSuccessful: " + response.isSuccessful());
                    LogVlion.e("getAdData onResponse response.body(): " + response.body());
                    Iterator<String> it = response.headers(m5.c.f28293b0).iterator();
                    while (it.hasNext()) {
                        LogVlion.e("getAdData onResponse headers=: " + it.next());
                    }
                    if (response.isSuccessful() && response.body() != null) {
                        String string = response.body().string();
                        LogVlion.e("getAdData onResponse body: " + string);
                        LogVlion.e("getAdData onResponse url: " + response.request().url());
                        int code = response.code();
                        if (TextUtils.isEmpty(string)) {
                            HttpRequestUtil.mainHandler.post(new c(code, this, response2));
                            return;
                        }
                        String decrypt = VlionAESUtils.decrypt(string, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                        LogVlion.e("getAdData onResponse 解密 body: " + decrypt);
                        HttpRequestUtil.mainHandler.post(new b(code, this, decrypt));
                        return;
                    }
                    handler = HttpRequestUtil.mainHandler;
                    eVar = new d(response2);
                } else {
                    handler = HttpRequestUtil.mainHandler;
                    eVar = new e();
                }
                handler.post(eVar);
            } catch (Throwable th2) {
                s4.a("getAdData Exception error: ", th2);
                HttpRequestUtil.mainHandler.post(new f(th2));
            }
        }
    }

    public class w implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpNetCallBack f3214a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f3215b;

        /* renamed from: c */
        public final /* synthetic */ String f3216c;

        /* renamed from: d */
        public final /* synthetic */ long f3217d;

        public w(VlionHttpNetCallBack vlionHttpNetCallBack, Throwable th2, String str, long j10) {
            this.f3214a = vlionHttpNetCallBack;
            this.f3215b = th2;
            this.f3216c = str;
            this.f3217d = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3214a == null || this.f3215b == null) {
                return;
            }
            this.f3214a.onFail(new VlionAdBaseError(10005, this.f3215b.getMessage()), new VlionADNetBodyParameter(this.f3216c, this.f3217d, 0, 10005, System.currentTimeMillis() - this.f3217d, VlionNetRespType.adx_api, false, this.f3215b.getMessage()));
        }
    }

    public class x implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpNetCallBack f3218a;

        /* renamed from: b */
        public final /* synthetic */ String f3219b;

        /* renamed from: c */
        public final /* synthetic */ long f3220c;

        public x(long j10, VlionHttpNetCallBack vlionHttpNetCallBack, String str) {
            this.f3218a = vlionHttpNetCallBack;
            this.f3219b = str;
            this.f3220c = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3218a != null) {
                String str = this.f3219b;
                long j10 = this.f3220c;
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.SERVER_URL_IS_EMPTY;
                this.f3218a.onFail(vlionAdBaseError, new VlionADNetBodyParameter(str, j10, 0, vlionAdBaseError.getErrorCode(), System.currentTimeMillis() - this.f3220c, VlionNetRespType.menta_config, false, vlionAdBaseError.getErrorMessage()));
            }
        }
    }

    public class y implements Callback {

        /* renamed from: a */
        public final /* synthetic */ VlionHttpNetCallBack f3221a;

        /* renamed from: b */
        public final /* synthetic */ String f3222b;

        /* renamed from: c */
        public final /* synthetic */ long f3223c;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f3224a;

            public a(IOException iOException) {
                this.f3224a = iOException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y yVar = y.this;
                if (yVar.f3221a == null || this.f3224a == null) {
                    return;
                }
                y.this.f3221a.onFail(new VlionAdBaseError(10004, this.f3224a.getMessage()), new VlionADNetBodyParameter(yVar.f3222b, yVar.f3223c, 0, 10004, System.currentTimeMillis() - y.this.f3223c, VlionNetRespType.menta_config, false, this.f3224a.getMessage()));
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f3226a;

            /* renamed from: b */
            public final /* synthetic */ int f3227b;

            /* renamed from: c */
            public final /* synthetic */ y f3228c;

            public b(int i10, y yVar, String str) {
                this.f3228c = yVar;
                this.f3226a = str;
                this.f3227b = i10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y yVar = this.f3228c;
                VlionADNetBodyParameter vlionADNetBodyParameter = new VlionADNetBodyParameter(yVar.f3222b, yVar.f3223c, this.f3226a.length(), this.f3227b, System.currentTimeMillis() - this.f3228c.f3223c, VlionNetRespType.menta_config, true, "");
                VlionHttpNetCallBack vlionHttpNetCallBack = this.f3228c.f3221a;
                if (vlionHttpNetCallBack != null) {
                    vlionHttpNetCallBack.onSuccess(this.f3226a, vlionADNetBodyParameter);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f3229a;

            /* renamed from: b */
            public final /* synthetic */ String f3230b;

            /* renamed from: c */
            public final /* synthetic */ y f3231c;

            public c(int i10, y yVar, String str) {
                this.f3231c = yVar;
                this.f3229a = i10;
                this.f3230b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y yVar = this.f3231c;
                if (yVar.f3221a != null) {
                    this.f3231c.f3221a.onFail(VlionAdBaseError.NO_FILL_BODY, new VlionADNetBodyParameter(yVar.f3222b, yVar.f3223c, 0, this.f3229a, System.currentTimeMillis() - this.f3231c.f3223c, VlionNetRespType.menta_config, false, this.f3230b));
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f3232a;

            public d(String str) {
                this.f3232a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y yVar = y.this;
                if (yVar.f3221a != null) {
                    String str = yVar.f3222b;
                    long j10 = yVar.f3223c;
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.NO_FILL_BODY;
                    y.this.f3221a.onFail(vlionAdBaseError, new VlionADNetBodyParameter(str, j10, 0, vlionAdBaseError.getErrorCode(), System.currentTimeMillis() - y.this.f3223c, VlionNetRespType.menta_config, false, this.f3232a));
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                y yVar = y.this;
                if (yVar.f3221a != null) {
                    String str = yVar.f3222b;
                    long j10 = yVar.f3223c;
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.NO_FILL_BODY;
                    y.this.f3221a.onFail(vlionAdBaseError, new VlionADNetBodyParameter(str, j10, 0, vlionAdBaseError.getErrorCode(), System.currentTimeMillis() - y.this.f3223c, VlionNetRespType.menta_config, false, "null == response"));
                }
            }
        }

        public class f implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Throwable f3235a;

            public f(Throwable th2) {
                this.f3235a = th2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y yVar = y.this;
                if (yVar.f3221a != null) {
                    y.this.f3221a.onFail(new VlionAdBaseError(10005, this.f3235a.getMessage()), new VlionADNetBodyParameter(yVar.f3222b, yVar.f3223c, 0, 10005, System.currentTimeMillis() - y.this.f3223c, VlionNetRespType.menta_config, false, this.f3235a.getMessage()));
                }
            }
        }

        public y(long j10, VlionHttpNetCallBack vlionHttpNetCallBack, String str) {
            this.f3221a = vlionHttpNetCallBack;
            this.f3222b = str;
            this.f3223c = j10;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            HttpRequestUtil.mainHandler.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            Handler handler;
            Runnable eVar;
            try {
                LogVlion.e("getData onResponse isSuccessful: " + response);
                if (response != null) {
                    String response2 = response.toString();
                    LogVlion.e("getData onResponse isSuccessful: " + response.isSuccessful());
                    LogVlion.e("getData onResponse response.body(): " + response.body());
                    LogVlion.e("getData onResponse headers: " + response.headers().toString());
                    ResponseBody body = response.body();
                    if (response.isSuccessful() && body != null) {
                        String string = body.string();
                        LogVlion.e("getData onResponse body: " + string);
                        LogVlion.e("getData onResponse url: " + response.request().url());
                        int code = response.code();
                        if (TextUtils.isEmpty(string)) {
                            HttpRequestUtil.mainHandler.post(new c(code, this, response2));
                            return;
                        } else {
                            HttpRequestUtil.mainHandler.post(new b(code, this, string));
                            return;
                        }
                    }
                    handler = HttpRequestUtil.mainHandler;
                    eVar = new d(response2);
                } else {
                    handler = HttpRequestUtil.mainHandler;
                    eVar = new e();
                }
                handler.post(eVar);
            } catch (Throwable th2) {
                s4.a("getData Exception error: ", th2);
                HttpRequestUtil.mainHandler.post(new f(th2));
            }
        }
    }

    public static void StartTimerMillisecond(long j10, String str, boolean z10, int i10, VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean) {
        try {
            LogVlion.e("Down 策略 : ------ 定时任务开始执行 111111111111111111 延迟------" + j10 + " 毫秒 ");
            VlionTimer.getInstance().startTimerMillisecond(j10, new q(j10, str, z10, i10, autoBean, scenesBean));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void StartdeeplinkTimerMilli(long j10, int i10, VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean, long j11) {
        try {
            LogVlion.e("Down 策略 : ------ 定时任务开始执行  延迟------" + j10 + " 毫秒 ");
            VlionTimer.getInstance().startTimerMillisecond(j10, new p(autoBean, scenesBean, i10, j11));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void downloadBitmap(ImageView imageView, String str, ImageCallback imageCallback) {
        downloadBitmap(imageView, str, imageCallback, false);
    }

    public static void downloadBitmapNeedCache(ImageView imageView, String str, ImageCallback imageCallback) {
        if (cn.vlion.ad.inland.base.u.b().a(str) != null) {
            mainHandler.post(new e(imageView, str, imageCallback));
        } else {
            downloadBitmap(imageView, str, imageCallback, true);
        }
    }

    public static void downloadDrawableNeedCache(ImageView imageView, String str, ImageCallback imageCallback) {
        if (cn.vlion.ad.inland.base.v.a().a(str) != null) {
            mainHandler.post(new f(imageView, str, imageCallback));
        } else {
            LogVlion.e("downloadDrawableNeedCache 缓存--- drawable 为 空 -- ");
            downloadBitmap(imageView, str, imageCallback, true);
        }
    }

    public static void downloadVideo(String str, VideoCallback videoCallback) {
        if (TextUtils.isEmpty(str)) {
            mainHandler.post(new g(videoCallback));
            return;
        }
        try {
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", VlionDeviceInfo.getInstance().getUserAgent(VlionSDkManager.getInstance().getApplication())).url(str).build()).enqueue(new h(videoCallback));
        } catch (Throwable th2) {
            s4.a("downloadVideo Exception e=", th2);
            mainHandler.post(new i(videoCallback, th2));
        }
    }

    public static void getData(String str, String str2, VlionHttpNetCallBack vlionHttpNetCallBack) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            mainHandler.post(new x(currentTimeMillis, vlionHttpNetCallBack, str));
            return;
        }
        try {
            LogVlion.e("getData url: " + str);
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", "").url(str).post(RequestBody.create(JSON, str2)).addHeader("x-trace", VlionServiceConfigParse.getInstance().getUuid()).build()).enqueue(new y(currentTimeMillis, vlionHttpNetCallBack, str));
        } catch (Throwable th2) {
            s4.a("getData Exception e=", th2);
            mainHandler.post(new a(vlionHttpNetCallBack, th2, str, currentTimeMillis));
        }
    }

    public static String getParameterJson(String str, int i10, int i11) {
        String str2 = "";
        try {
            Application application = VlionSDkManager.getInstance().getApplication();
            VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", VlionSDkManager.getInstance().getAppId());
            jSONObject.put("bundle", str);
            jSONObject.put("make", vlionDeviceInfo.getMake());
            jSONObject.put(bm.f6905j, vlionDeviceInfo.getMake());
            jSONObject.put(bt.f23628x, vlionDeviceInfo.getOs());
            jSONObject.put("imei", vlionDeviceInfo.getImei(application));
            jSONObject.put(AdKeys.OAID, vlionDeviceInfo.getOaid());
            jSONObject.put("android_id", vlionDeviceInfo.getAndroidId(application));
            jSONObject.put(bd.f23524d, vlionDeviceInfo.getUserAgent(application));
            jSONObject.put("need_rta", i10);
            jSONObject.put("is_duizhao", i11);
            jSONObject.put("sdk_ver", VlionSDkManager.getInstance().getSdkVersionName());
            jSONObject.put("os_ver", vlionDeviceInfo.getOsv());
            jSONObject.put(bm.f6904i, vlionDeviceInfo.getModel());
            jSONObject.put("package_name", VlionAppInfo.getInstance().getPackageName(application));
            String jSONObject2 = jSONObject.toString();
            LogVlion.e("Down 策略 : ParameterCoreUtil ====stringBuffer =" + jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("sd", k0.a(jSONObject2));
            str2 = jSONObject3.toString();
            LogVlion.e("Down 策略 :  == 加密==stringBuffer =" + str2);
            return str2;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return str2;
        }
    }

    public static String getUrlTrakers() {
        return VlionSDkManager.getInstance().isSdkDebug() ? DEBUG_CONFIGTRAKERS_URL : RELEASE_CONFIGTRAKERS_URL;
    }

    public static void getVlionAdData(String str, String str2, VlionHttpNetCallBack vlionHttpNetCallBack) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2)) {
            mainHandler.post(new u(currentTimeMillis, vlionHttpNetCallBack, str2));
            return;
        }
        try {
            LogVlion.e("getAdData url: " + str2.replace("http", "666").replace(p1.b.f29697h, "i"));
            LogVlion.e("getAdData:json=" + str);
            RequestBody create = RequestBody.create(JSON, VlionAESUtils.encrypt(str, KEY, IV));
            LogVlion.e("getAdData url: " + str2);
            Request.Builder post = new Request.Builder().addHeader("User-Agent", VlionDeviceInfo.getInstance().getUserAgent(VlionSDkManager.getInstance().getApplication())).url(str2).post(create);
            post.addHeader("SDK-ENCRYPT", bz.f6993k);
            cn.vlion.ad.inland.base.x.f3488a.newCall(post.build()).enqueue(new v(currentTimeMillis, vlionHttpNetCallBack, str2));
        } catch (Throwable th2) {
            s4.a("Exception e=", th2);
            mainHandler.post(new w(vlionHttpNetCallBack, th2, str2, currentTimeMillis));
        }
    }

    public static void sdkException(Context context, String str) {
        try {
            LogVlion.e("sdkException sdkException");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.TOKEN, "c313d08110f385ed5a66e41780f7a04e");
            jSONObject.put("errors", str);
            jSONObject.put(b7.b.f1305b0, VlionSDkManager.getInstance().getSdkVersionName());
            jSONObject.put("appName", VlionAppInfo.getInstance().getAppName(context));
            jSONObject.put("appPackage", VlionAppInfo.getInstance().getPackageName(context));
            jSONObject.put("platform", "android");
            LogVlion.e("sdkException sdkException vlionException=" + jSONObject.toString());
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().url("https://api-v3.mentamob.com/api/v1/error-report").post(RequestBody.create(JSON, jSONObject.toString())).build()).enqueue(new n());
        } catch (Throwable th2) {
            s4.a("sdkException sdkException Exception:", th2);
        }
    }

    public static void submitBehavior(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("submitBehavior onFailure url is empty");
            return;
        }
        if (str3 == null) {
            str3 = "";
        }
        LogVlion.e("submitBehavior url_header =" + str3);
        mainHandler.post(new j(new l0(str, str2, str3)));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:12|13|(4:(2:15|(8:17|18|19|20|21|22|23|25))|22|23|25)|35|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e9, code lost:
    
        r18 = r11;
        r23 = r15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void submitBehaviorDaSync(java.lang.String r19, boolean r20, int r21, cn.vlion.ad.inland.base.javabean.VlionServiceConfig.AutoBean r22, cn.vlion.ad.inland.base.javabean.VlionServiceConfig.ScenesBean r23, long r24) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.network.ok.HttpRequestUtil.submitBehaviorDaSync(java.lang.String, boolean, int, cn.vlion.ad.inland.base.javabean.VlionServiceConfig$AutoBean, cn.vlion.ad.inland.base.javabean.VlionServiceConfig$ScenesBean, long):void");
    }

    public static VlionADNetBodyParameter submitBehaviorRetry(l0 l0Var) {
        int length;
        LogVlion.e("submitBehaviorRetry");
        if (l0Var == null || TextUtils.isEmpty(l0Var.b())) {
            LogVlion.e("submitBehaviorRetry onFailure url is empty");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String b10 = l0Var.b();
        String a10 = l0Var.a();
        String b11 = l0Var.b();
        if (b11.contains("?")) {
            String[] split = b11.split("\\?");
            if (split.length > 0) {
                b11 = split[0];
            }
        }
        String str = b11;
        try {
            Request.Builder builder = new Request.Builder().addHeader("User-Agent", VlionDeviceInfo.getInstance().getUserAgent(VlionSDkManager.getInstance().getApplication())).url(b10).get();
            if (l0Var.c() != null) {
                for (int i10 = 0; i10 < l0Var.c().size(); i10++) {
                    String keyAt = l0Var.c().keyAt(i10);
                    String valueAt = l0Var.c().valueAt(i10);
                    builder.addHeader(keyAt, valueAt);
                    LogVlion.e("submitBehaviorRetry key -= " + keyAt + " value=" + valueAt);
                }
            }
            Response execute = cn.vlion.ad.inland.base.x.f3488a.newCall(builder.build()).execute();
            int code = execute.code();
            LogVlion.e("submitBehaviorRetry onResponse " + code + " url=" + b10);
            if (code != 200) {
                return new VlionADNetBodyParameter(str, currentTimeMillis, 0, code, System.currentTimeMillis() - currentTimeMillis, a10, false, "");
            }
            if (execute.body() != null) {
                try {
                    String string = execute.body().string();
                    if (!TextUtils.isEmpty(string)) {
                        length = string.length();
                        return new VlionADNetBodyParameter(str, currentTimeMillis, length, code, System.currentTimeMillis() - currentTimeMillis, a10, true, "");
                    }
                } catch (Throwable th2) {
                    return new VlionADNetBodyParameter(str, currentTimeMillis, 0, 10005, System.currentTimeMillis() - currentTimeMillis, a10, false, th2.getMessage() + "   url = " + b10);
                }
            }
            length = -1;
            return new VlionADNetBodyParameter(str, currentTimeMillis, length, code, System.currentTimeMillis() - currentTimeMillis, a10, true, "");
        } catch (Throwable th3) {
            LogVlion.e("submitBehaviorRetry Exception e=" + th3);
            return new VlionADNetBodyParameter(str, currentTimeMillis, 0, 10005, System.currentTimeMillis() - currentTimeMillis, a10, false, th3.getMessage());
        }
    }

    public static void submitBehaviorRetryAsyn(l0 l0Var) {
        LogVlion.e("submitBehaviorRetryAsyn");
        if (l0Var == null || TextUtils.isEmpty(l0Var.b())) {
            LogVlion.e("submitBehaviorRetryAsyn onFailure url is empty");
            return;
        }
        String b10 = l0Var.b();
        try {
            Request.Builder builder = new Request.Builder().addHeader("User-Agent", VlionDeviceInfo.getInstance().getUserAgent(VlionSDkManager.getInstance().getApplication())).url(b10).get();
            if (l0Var.c() != null) {
                for (int i10 = 0; i10 < l0Var.c().size(); i10++) {
                    String keyAt = l0Var.c().keyAt(i10);
                    String valueAt = l0Var.c().valueAt(i10);
                    builder.addHeader(keyAt, valueAt);
                    LogVlion.e("submitBehaviorRetryAsyn key -= " + keyAt + " value=" + valueAt);
                }
            }
            cn.vlion.ad.inland.base.x.f3488a.newCall(builder.build()).enqueue(new m(b10));
        } catch (Throwable th2) {
            s4.a("submitBehaviorRetryAsyn Exception e=", th2);
        }
    }

    public static void submitTrakersSync(VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean, int i10, int i11) {
        if (autoBean == null || scenesBean == null) {
            return;
        }
        try {
            LogVlion.e("Down 策略 :  submitTrakersSync id= " + scenesBean.getId());
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", VlionDeviceInfo.getInstance().getUserAgent(VlionSDkManager.getInstance().getApplication())).url(getUrlTrakers()).post(RequestBody.create(JSON, getParameterJson(autoBean.getBundle(), i10, i11))).build()).enqueue(new o(autoBean, scenesBean, i10));
        } catch (Throwable th2) {
            s4.a("submitBehaviordaAsyn Exception e=", th2);
        }
    }

    public static boolean uploadAdEvent(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("uploadAdEvent onFailure url is empty");
            return false;
        }
        try {
            RequestBody create = RequestBody.create(JSON, str2);
            LogVlion.e("uploadAdEvent url: " + str);
            LogVlion.e("uploadAdEvent adJson: " + str2);
            Response execute = cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", "").url(str).post(create).build()).execute();
            LogVlion.e("uploadAdEvent  sendResult = " + execute.code());
            ResponseBody body = execute.body();
            if (body != null) {
                LogVlion.e("uploadAdEvent  string = " + body.string() + " response.code() =" + execute.code());
                if (execute.code() == 200) {
                    return true;
                }
            }
        } catch (Throwable th2) {
            s4.a("uploadAdEvent Exception e=", th2);
        }
        return false;
    }

    public static void uploadAdEventAsyn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("uploadAdEventAsyn onFailure url is empty");
            return;
        }
        try {
            RequestBody create = RequestBody.create(JSON, str2);
            LogVlion.e("uploadAdEventAsyn url: " + str);
            LogVlion.e("uploadAdEventAsyn adJson: " + str2);
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", "").url(str).post(create).build()).enqueue(new t());
        } catch (Throwable th2) {
            s4.a("uploadAdEventAsyn Exception e=", th2);
        }
    }

    public static void uploadReport(String str, String str2, VlionHttpCallBack vlionHttpCallBack) {
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("uploadReport onFailure url is empty");
            mainHandler.post(new k(vlionHttpCallBack));
            return;
        }
        try {
            RequestBody create = RequestBody.create(JSON, str2);
            LogVlion.e("uploadReport url: " + str);
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", "").url(str).post(create).build()).enqueue(new l(vlionHttpCallBack));
        } catch (Throwable th2) {
            s4.a("uploadReport Exception e=", th2);
            mainHandler.post(new s(vlionHttpCallBack, th2));
        }
    }

    public static void downloadBitmap(ImageView imageView, String str, ImageCallback imageCallback, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            mainHandler.post(new b(imageCallback));
            return;
        }
        try {
            LogVlion.e("HttpRequestUtil 图片-url =" + str);
            cn.vlion.ad.inland.base.x.f3488a.newCall(new Request.Builder().addHeader("User-Agent", VlionDeviceInfo.getInstance().getUserAgent(VlionSDkManager.getInstance().getApplication())).url(str).build()).enqueue(new c(imageView, str, imageCallback, z10));
        } catch (Throwable th2) {
            s4.a("downloadBitmap Exception e=", th2);
            mainHandler.post(new d(imageCallback, th2));
        }
    }

    public static void submitBehavior(List<String> list, String str, String str2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        submitBehavior(it.next(), str, str2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
