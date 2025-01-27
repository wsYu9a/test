package com.sntech.net;

import android.content.Context;
import androidx.annotation.Keep;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.k;
import com.sntech.net.NetCallback;
import com.sntech.net.NetClient;
import com.sntech.net.NetRequest;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kh.a;
import m5.c;
import nh.b;
import oh.a;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public class NetClient {
    private static String TAG = "NetClient";
    private static int sCachedThreadId;
    private static ExecutorService sExecutor;
    private static OkHttpClient sOkHttpClient;
    public static ScheduledExecutorService sScheduleExecutor;
    private static int sScheduledThreadId;

    private static OkHttpClient createHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
    }

    public static synchronized void init(Context context, String str, String str2) {
        synchronized (NetClient.class) {
            if (sOkHttpClient != null) {
                return;
            }
            a.f29195a = context;
            a.f29196b = str;
            a.f29197c = str2;
            sOkHttpClient = createHttpClient();
            sExecutor = Executors.newCachedThreadPool(new ThreadFactory() { // from class: fg.e
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread lambda$init$0;
                    lambda$init$0 = NetClient.lambda$init$0(runnable);
                    return lambda$init$0;
                }
            });
            sScheduleExecutor = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: fg.f
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread lambda$init$1;
                    lambda$init$1 = NetClient.lambda$init$1(runnable);
                    return lambda$init$1;
                }
            });
        }
    }

    public static /* synthetic */ Thread lambda$init$0(Runnable runnable) {
        StringBuilder a10 = b.a("pool_c_net_");
        int i10 = sCachedThreadId;
        sCachedThreadId = i10 + 1;
        a10.append(i10);
        return new Thread(runnable, a10.toString());
    }

    public static /* synthetic */ Thread lambda$init$1(Runnable runnable) {
        StringBuilder a10 = b.a("pool_s_net_");
        int i10 = sScheduledThreadId;
        sScheduledThreadId = i10 + 1;
        a10.append(i10);
        return new Thread(runnable, a10.toString());
    }

    public static /* synthetic */ void lambda$postEncryptAsync$3(NetRequest netRequest, NetCallback netCallback) {
        try {
            netCallback.onSuccess(postEncrypt(netRequest));
        } catch (Exception e10) {
            netCallback.onFailure(e10);
        }
    }

    public static /* synthetic */ void lambda$postEncryptAtFixedRate$2(NetRequest netRequest, NetCallback netCallback) {
        try {
            netCallback.onSuccess(postEncrypt(netRequest));
        } catch (Exception e10) {
            netCallback.onFailure(e10);
        }
    }

    public static /* synthetic */ void lambda$uploadAsync$4(NetRequest netRequest, String str, String str2, NetCallback netCallback) {
        try {
            netCallback.onSuccess(upload(netRequest, str, str2));
        } catch (Exception e10) {
            netCallback.onFailure(e10);
        }
    }

    @Keep
    public static String postEncrypt(NetRequest netRequest) {
        try {
            JSONObject b10 = kh.b.b(netRequest.getRequestJSON());
            byte[] a10 = a.C0726a.a(b10.toString().getBytes());
            String string = b10.getString(t.f11211k);
            Response execute = sOkHttpClient.newCall(new Request.Builder().url(HttpUrl.parse(netRequest.getUrl()).newBuilder().addQueryParameter(t.f11211k, string).build()).addHeader(c.f28293b0, "gzip").post(RequestBody.create(oh.a.f29199e, a10)).build()).execute();
            if (execute.isSuccessful()) {
                String a11 = kh.b.a(execute.body().string());
                if (netRequest.isCheckReqId() && !string.equals(new JSONObject(a11).optString(t.f11211k))) {
                    throw new Exception("ReqId changed!");
                }
                return a11;
            }
            Context context = oh.a.f29195a;
            throw new IOException("Unexpected code " + execute);
        } catch (Exception e10) {
            Context context2 = oh.a.f29195a;
            throw e10;
        }
    }

    @Keep
    public static void postEncryptAsync(NetRequest netRequest, NetCallback netCallback) {
        sExecutor.execute(new Runnable() { // from class: fg.c

            /* renamed from: c */
            public final /* synthetic */ NetCallback f26037c;

            public /* synthetic */ c(NetCallback netCallback2) {
                netCallback = netCallback2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NetClient.lambda$postEncryptAsync$3(NetRequest.this, netCallback);
            }
        });
    }

    @Keep
    public static NetFuture<?> postEncryptAtFixedRate(NetRequest netRequest, NetCallback netCallback, long j10, long j11, TimeUnit timeUnit) {
        return new NetFuture<>(sScheduleExecutor.scheduleWithFixedDelay(new Runnable() { // from class: fg.d

            /* renamed from: c */
            public final /* synthetic */ NetCallback f26039c;

            public /* synthetic */ d(NetCallback netCallback2) {
                netCallback = netCallback2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NetClient.lambda$postEncryptAtFixedRate$2(NetRequest.this, netCallback);
            }
        }, j10, j11, timeUnit));
    }

    @Keep
    public static String upload(NetRequest netRequest, String str, String str2) {
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(k.f18193y, str2, RequestBody.create(MediaType.parse("multipart/form-data"), new File(str)));
        if (netRequest.getRequestJSON() != null) {
            addFormDataPart.addFormDataPart("json", null, RequestBody.create(oh.a.f29199e, kh.b.b(netRequest.getRequestJSON()).toString().getBytes()));
        }
        Response execute = sOkHttpClient.newCall(new Request.Builder().addHeader(c.f28293b0, "gzip").url(netRequest.getUrl()).post(addFormDataPart.build()).build()).execute();
        if (execute.isSuccessful()) {
            return kh.b.a(execute.body().string());
        }
        throw new IOException("Unexpected code " + execute);
    }

    @Keep
    public static void uploadAsync(NetRequest netRequest, String str, String str2, NetCallback netCallback) {
        sExecutor.execute(new Runnable() { // from class: fg.b

            /* renamed from: c */
            public final /* synthetic */ String f26033c;

            /* renamed from: d */
            public final /* synthetic */ String f26034d;

            /* renamed from: e */
            public final /* synthetic */ NetCallback f26035e;

            public /* synthetic */ b(String str3, String str22, NetCallback netCallback2) {
                str = str3;
                str2 = str22;
                netCallback = netCallback2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NetClient.lambda$uploadAsync$4(NetRequest.this, str, str2, netCallback);
            }
        });
    }
}
