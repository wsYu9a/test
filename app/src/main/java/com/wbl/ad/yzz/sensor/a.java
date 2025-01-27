package com.wbl.ad.yzz.sensor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: d */
    public static final Map<Context, a> f33801d = new HashMap();

    /* renamed from: a */
    public final C0777a f33802a = new C0777a();

    /* renamed from: b */
    public final Context f33803b;

    /* renamed from: c */
    public final DbAdapter f33804c;

    /* renamed from: com.wbl.ad.yzz.sensor.a$a */
    public class C0777a {

        /* renamed from: a */
        public final Object f33805a = new Object();

        /* renamed from: b */
        public Handler f33806b;

        /* renamed from: com.wbl.ad.yzz.sensor.a$a$a */
        public class HandlerC0778a extends Handler {
            public HandlerC0778a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10732, this, message);
            }
        }

        public C0777a() {
            try {
                HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
                handlerThread.start();
                this.f33806b = new HandlerC0778a(handlerThread.getLooper());
            } catch (Throwable th) {
                th.printStackTrace();
                this.f33806b = null;
            }
        }

        public void a(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10731, this, message);
        }

        public void a(Message message, long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10726, this, message, Long.valueOf(j2));
        }
    }

    public a(Context context, String str) {
        this.f33803b = context;
        this.f33804c = new DbAdapter(context, str);
    }

    public static a a(Context context, String str) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10725, null, context, str);
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        return (byte[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10728, null, inputStream);
    }

    public final String a(String str) throws IOException {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10727, this, str);
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10722, this, null);
    }

    public void a(String str, JSONObject jSONObject) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10721, this, str, jSONObject);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10724, this, null);
    }
}
