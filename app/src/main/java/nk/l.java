package nk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.sntech.ads.api.event.SNEvent;
import com.sntech.net.DomainProvider;
import fh.a;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import ph.g;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: c */
    public static l f28971c;

    /* renamed from: a */
    public Context f28972a;

    /* renamed from: b */
    public String f28973b;

    public static l c() {
        if (f28971c == null) {
            synchronized (l.class) {
                try {
                    if (f28971c == null) {
                        f28971c = new l();
                    }
                } finally {
                }
            }
        }
        return f28971c;
    }

    public static /* synthetic */ void d(Looper looper, g.a aVar) {
        boolean f10 = a.f();
        if (looper != null) {
            new Handler(looper).post(new Runnable() { // from class: nk.k

                /* renamed from: c */
                public final /* synthetic */ boolean f28970c;

                public /* synthetic */ k(boolean f102) {
                    f10 = f102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.a.this.a(Boolean.valueOf(f10));
                }
            });
        } else {
            aVar.a(Boolean.valueOf(f102));
        }
    }

    public static void i(String str) {
        a.c(str, 0);
    }

    public static void l(String str, String str2, float f10, SNEvent.WithdrawChannel withdrawChannel, String str3) {
        String str4;
        StringBuilder sb2;
        String message;
        String str5 = a.f28934a;
        StringBuilder sb3 = new StringBuilder();
        MediaType mediaType = fh.d.f26044a;
        sb3.append(DomainProvider.baseUrl());
        sb3.append("wr");
        String sb4 = sb3.toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z2.b.f33617b, str);
            jSONObject.put("developer_user_id", str2);
            jSONObject.put("withdraw_amount", f10);
            jSONObject.put("withdraw_channel", withdrawChannel.toString());
            jSONObject.put("withdraw_order_id", str3);
            Response execute = fh.d.a().newCall(new Request.Builder().url(sb4).addHeader(m5.c.f28293b0, "gzip").post(RequestBody.create(mediaType, a.c.a(a.b(jSONObject).toString().getBytes()))).build()).execute();
            if (execute.isSuccessful()) {
                message = execute.body().string();
                if (!ph.g.c()) {
                    return;
                }
                str4 = a.f28934a;
                sb2 = new StringBuilder();
                sb2.append("response success: ");
            } else {
                if (!ph.g.c()) {
                    return;
                }
                str4 = a.f28934a;
                sb2 = new StringBuilder();
                sb2.append("response error: ");
                message = execute.message();
            }
            sb2.append(message);
            Log.d(str4, sb2.toString());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void p(SNEvent.AdPlatform adPlatform, String str, SNEvent.AdType adType, SNEvent.AdEvent adEvent, String str2) {
        String adPlatform2 = adPlatform.toString();
        String adType2 = adType.toString();
        String adEvent2 = adEvent.toString();
        String eventSource = SNEvent.EventSource.OFFICIAL.toString();
        String str3 = a.f28934a;
        HashMap hashMap = new HashMap();
        hashMap.put("show_id", str2);
        a.a(adPlatform2, str, adType2, adEvent2, eventSource, hashMap);
    }

    public final synchronized void e(View view, SNEvent.AdPlatform adPlatform, String str, SNEvent.AdType adType, SNEvent.AdEvent adEvent, double d10, String str2) {
        float f10;
        float f11;
        try {
            StringBuilder a10 = nh.b.a("localId-");
            a10.append(System.currentTimeMillis());
            this.f28973b = a10.toString();
            if (view != null) {
                f11 = view.getWidth();
                f10 = view.getHeight();
            } else {
                DisplayMetrics displayMetrics = this.f28972a.getResources().getDisplayMetrics();
                float f12 = displayMetrics.widthPixels;
                f10 = displayMetrics.heightPixels;
                f11 = f12;
            }
            new Thread(new Runnable() { // from class: nk.d

                /* renamed from: c */
                public final /* synthetic */ SNEvent.AdPlatform f28940c;

                /* renamed from: d */
                public final /* synthetic */ String f28941d;

                /* renamed from: e */
                public final /* synthetic */ SNEvent.AdType f28942e;

                /* renamed from: f */
                public final /* synthetic */ SNEvent.AdEvent f28943f;

                /* renamed from: g */
                public final /* synthetic */ float f28944g;

                /* renamed from: h */
                public final /* synthetic */ float f28945h;

                /* renamed from: i */
                public final /* synthetic */ double f28946i;

                /* renamed from: j */
                public final /* synthetic */ String f28947j;

                public /* synthetic */ d(SNEvent.AdPlatform adPlatform2, String str3, SNEvent.AdType adType2, SNEvent.AdEvent adEvent2, float f112, float f102, double d102, String str22) {
                    adPlatform = adPlatform2;
                    str = str3;
                    adType = adType2;
                    adEvent = adEvent2;
                    f11 = f112;
                    f10 = f102;
                    d10 = d102;
                    str2 = str22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    l.this.f(adPlatform, str, adType, adEvent, f11, f10, d10, str2);
                }
            }).start();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void f(SNEvent.AdPlatform adPlatform, String str, SNEvent.AdType adType, SNEvent.AdEvent adEvent, float f10, float f11, double d10, String str2) {
        String adPlatform2 = adPlatform.toString();
        String adType2 = adType.toString();
        String adEvent2 = adEvent.toString();
        String eventSource = SNEvent.EventSource.OFFICIAL.toString();
        String str3 = this.f28973b;
        String str4 = a.f28934a;
        HashMap hashMap = new HashMap();
        hashMap.put("client_ad_uuid", str3);
        hashMap.put("ecpm", Double.valueOf(d10));
        hashMap.put("show_id", str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f10);
            jSONObject.put("height", f11);
        } catch (JSONException e10) {
            if (ph.g.c()) {
                e10.printStackTrace();
            }
        }
        hashMap.put("ad_size", jSONObject);
        a.a(adPlatform2, str, adType2, adEvent2, eventSource, hashMap);
    }

    public final synchronized void g(SNEvent.AdPlatform adPlatform, String str, SNEvent.AdType adType, SNEvent.AdEvent adEvent, String str2) {
        new Thread(new Runnable() { // from class: nk.h

            /* renamed from: c */
            public final /* synthetic */ String f28957c;

            /* renamed from: d */
            public final /* synthetic */ SNEvent.AdType f28958d;

            /* renamed from: e */
            public final /* synthetic */ SNEvent.AdEvent f28959e;

            /* renamed from: f */
            public final /* synthetic */ String f28960f;

            public /* synthetic */ h(String str3, SNEvent.AdType adType2, SNEvent.AdEvent adEvent2, String str22) {
                str = str3;
                adType = adType2;
                adEvent = adEvent2;
                str2 = str22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.p(SNEvent.AdPlatform.this, str, adType, adEvent, str2);
            }
        }).start();
    }

    public final void j(String str, float f10, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        fh.d.f26047d.execute(new Runnable() { // from class: nk.j

            /* renamed from: b */
            public final /* synthetic */ String f28964b;

            /* renamed from: c */
            public final /* synthetic */ String f28965c;

            /* renamed from: d */
            public final /* synthetic */ float f28966d;

            /* renamed from: e */
            public final /* synthetic */ SNEvent.WithdrawChannel f28967e;

            /* renamed from: f */
            public final /* synthetic */ String f28968f;

            public /* synthetic */ j(String str3, String str4, float f102, SNEvent.WithdrawChannel withdrawChannel2, String str22) {
                userAgentString = str3;
                str = str4;
                f10 = f102;
                withdrawChannel = withdrawChannel2;
                str2 = str22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.l(userAgentString, str, f10, withdrawChannel, str2);
            }
        });
    }

    public final void n(g.a aVar) {
        fh.d.f26047d.execute(new Runnable() { // from class: nk.b

            /* renamed from: b */
            public final /* synthetic */ Looper f28936b;

            /* renamed from: c */
            public final /* synthetic */ g.a f28937c;

            public /* synthetic */ b(Looper looper, g.a aVar2) {
                myLooper = looper;
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.d(myLooper, aVar);
            }
        });
    }

    public final void q(SNEvent.UserEvent userEvent) {
        fh.d.f26047d.execute(new Runnable() { // from class: nk.f
            public /* synthetic */ f() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.e(SNEvent.UserEvent.this.toString(), null);
            }
        });
    }

    public final void r(String str) {
        fh.d.f26047d.execute(new Runnable() { // from class: nk.c

            /* renamed from: b */
            public final /* synthetic */ String f28938b;

            public /* synthetic */ c(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.i(str);
            }
        });
    }

    public final void s(String str, float f10, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: nk.e

            /* renamed from: c */
            public final /* synthetic */ String f28949c;

            /* renamed from: d */
            public final /* synthetic */ float f28950d;

            /* renamed from: e */
            public final /* synthetic */ SNEvent.WithdrawChannel f28951e;

            /* renamed from: f */
            public final /* synthetic */ String f28952f;

            public /* synthetic */ e(String str3, float f102, SNEvent.WithdrawChannel withdrawChannel2, String str22) {
                str = str3;
                f10 = f102;
                withdrawChannel = withdrawChannel2;
                str2 = str22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.this.j(str, f10, withdrawChannel, str2);
            }
        });
    }

    public final void t(String str, int i10, String... strArr) {
        fh.d.f26047d.execute(new Runnable() { // from class: nk.i

            /* renamed from: b */
            public final /* synthetic */ String f28961b;

            /* renamed from: c */
            public final /* synthetic */ int f28962c;

            /* renamed from: d */
            public final /* synthetic */ String[] f28963d;

            public /* synthetic */ i(String str2, int i102, String[] strArr2) {
                str = str2;
                i10 = i102;
                strArr = strArr2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.d(str, i10, strArr);
            }
        });
    }

    public final void u(String str, JSONObject jSONObject) {
        fh.d.f26047d.execute(new Runnable() { // from class: nk.g

            /* renamed from: b */
            public final /* synthetic */ String f28954b;

            /* renamed from: c */
            public final /* synthetic */ JSONObject f28955c;

            public /* synthetic */ g(String str2, JSONObject jSONObject2) {
                str = str2;
                jSONObject = jSONObject2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.e(str, jSONObject);
            }
        });
    }
}
