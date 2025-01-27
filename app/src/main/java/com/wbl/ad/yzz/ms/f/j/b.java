package com.wbl.ad.yzz.ms.f.j;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    public static final ArrayList<String> f33202a;

    /* renamed from: b */
    public static boolean f33203b;

    public static class a implements Callback {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f33204a;

        public a(CountDownLatch countDownLatch) {
            this.f33204a = countDownLatch;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12261, this, call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12264, this, call, response);
        }
    }

    /* renamed from: com.wbl.ad.yzz.ms.f.j.b$b */
    public static class C0763b implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        public Context f33205a;

        /* renamed from: b */
        public boolean f33206b;

        /* renamed from: c */
        public Thread.UncaughtExceptionHandler f33207c;

        public C0763b(Context context, boolean z, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f33205a = context;
            this.f33206b = z;
            this.f33207c = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12263, this, thread, th);
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f33202a = arrayList;
        f33203b = true;
        arrayList.add("device_adid");
        arrayList.add("device_imsi");
        arrayList.add("device_imei");
        arrayList.add("device_geo_lon");
        arrayList.add("device_geo_lat");
        arrayList.add("device_battery_level");
        arrayList.add("device_mac");
        arrayList.add("secure");
        arrayList.add("device_apiLevel");
        arrayList.add("is_mobile");
        arrayList.add(am.ai);
        arrayList.add("device_oaid");
        arrayList.add("device_ssid");
        arrayList.add("device_wifi_mac");
    }

    public static void a(Context context, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12258, null, context, Boolean.valueOf(z));
    }

    public static void b(Context context, boolean z, Thread thread, Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12260, null, context, Boolean.valueOf(z), thread, th);
    }
}
