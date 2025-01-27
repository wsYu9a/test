package com.wbl.ad.yzz.ms.f.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a */
    public static OkHttpClient f33250a;

    /* renamed from: b */
    public static OkHttpClient f33251b;

    /* renamed from: c */
    public static Handler f33252c;

    public static class a implements Callback {

        /* renamed from: a */
        public final /* synthetic */ g f33253a;

        /* renamed from: com.wbl.ad.yzz.ms.f.m.i$a$a */
        public class RunnableC0766a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f33254a;

            public RunnableC0766a(IOException iOException) {
                this.f33254a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12244, this, null);
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ m f33256a;

            public b(m mVar) {
                this.f33256a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12243, this, null);
            }
        }

        public a(g gVar) {
            this.f33253a = gVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11310, this, call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11309, this, call, response);
        }
    }

    public static class b implements Callback {

        /* renamed from: a */
        public final /* synthetic */ g f33258a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f33259a;

            public a(IOException iOException) {
                this.f33259a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11312, this, null);
            }
        }

        /* renamed from: com.wbl.ad.yzz.ms.f.m.i$b$b */
        public class RunnableC0767b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ m f33261a;

            public RunnableC0767b(m mVar) {
                this.f33261a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11311, this, null);
            }
        }

        public b(g gVar) {
            this.f33258a = gVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11306, this, call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11305, this, call, response);
        }
    }

    public static class c implements Callback {

        /* renamed from: a */
        public final /* synthetic */ h f33263a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ IOException f33264a;

            public a(IOException iOException) {
                this.f33264a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11308, this, null);
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.ms.f.i.a f33266a;

            public b(com.wbl.ad.yzz.ms.f.i.a aVar) {
                this.f33266a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11307, this, null);
            }
        }

        public c(h hVar) {
            this.f33263a = hVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11302, this, call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11301, this, call, response);
        }
    }

    public static class d implements g<m> {
        /* renamed from: a */
        public void a2(m mVar) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11304, this, mVar);
        }

        @Override // com.wbl.ad.yzz.ms.f.m.g
        public void a(IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11303, this, iOException);
        }

        @Override // com.wbl.ad.yzz.ms.f.m.g
        public /* bridge */ /* synthetic */ void a(m mVar) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11298, this, mVar);
        }
    }

    static {
        MediaType.parse("text/x-markdown; charset=utf-8");
        MediaType.parse("image/png");
        MediaType.parse("audio/mp3");
        MediaType.parse("video/mp4");
        MediaType.parse("application/octet-stream");
        MediaType.parse("application/json; charset=utf-8");
        f33252c = new Handler(Looper.getMainLooper());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f33250a = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build();
        f33251b = new OkHttpClient.Builder().connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build();
    }

    public static /* synthetic */ Handler a() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11297, null, null);
    }

    public static String a(String str, int i2, String str2) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11300, null, str, Integer.valueOf(i2), str2);
    }

    public static void a(Context context, String str, h hVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11299, null, context, str, hVar);
    }

    public static void a(String str, Integer num, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11326, null, str, num, str2);
    }

    public static void a(String str, Map<String, String> map, g<m> gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11325, null, str, map, gVar);
    }

    public static void a(String str, Map<String, String> map, h hVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11328, null, str, map, hVar);
    }

    public static void a(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, g<m> gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11327, null, str, map, map2, map3, gVar);
    }

    public static void a(Request request, Callback callback) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11322, null, request, callback);
    }
}
