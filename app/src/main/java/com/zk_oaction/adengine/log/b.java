package com.zk_oaction.adengine.log;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    private static b f35199a;

    /* renamed from: b */
    private Context f35200b;

    /* renamed from: c */
    private Handler f35201c;

    /* renamed from: d */
    private HandlerThread f35202d;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                b.this.e((C0822b) message.obj);
            }
        }
    }

    /* renamed from: com.zk_oaction.adengine.log.b$b */
    private class C0822b {

        /* renamed from: a */
        Map f35204a;

        /* renamed from: b */
        String f35205b;

        /* renamed from: c */
        String f35206c;

        /* renamed from: d */
        int f35207d;

        /* renamed from: e */
        String f35208e;

        /* renamed from: f */
        String f35209f;

        /* renamed from: g */
        String f35210g;

        /* renamed from: h */
        long f35211h;

        /* renamed from: i */
        String f35212i;

        /* renamed from: j */
        String f35213j;

        private C0822b(b bVar) {
        }

        /* synthetic */ C0822b(b bVar, a aVar) {
            this(bVar);
        }
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread("postlog");
        this.f35202d = handlerThread;
        handlerThread.start();
        this.f35201c = new a(this.f35202d.getLooper());
    }

    public static b a() {
        if (f35199a == null) {
            f35199a = new b();
        }
        return f35199a;
    }

    private String b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                File[] listFiles = new File(str + "res_id_info").listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    return listFiles[0].getName();
                }
            }
        } catch (Throwable unused) {
        }
        return "no_res_id";
    }

    public void e(C0822b c0822b) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(c0822b.f35205b)) {
                c0822b.f35205b = b(c0822b.f35206c);
            }
            jSONObject.put("action_message", c0822b.f35212i);
            jSONObject.put("res_id", c0822b.f35205b);
            jSONObject.put("ad_id", c0822b.f35209f);
            jSONObject.put("user_id", c0822b.f35208e);
            jSONObject.put("action_time", c0822b.f35211h);
            jSONObject.put("res_type", c0822b.f35207d);
            jSONObject.put("scene", c0822b.f35210g);
            jSONObject.put("action", c0822b.f35213j);
            String aVar = new com.zk_oaction.adengine.log.a(this.f35200b, 3, "hd_log_info", jSONObject.toString(), c0822b.f35208e).toString();
            JSONObject jSONObject2 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2.put("appId", "adssdkdex");
                jSONObject2.put("timestamp", currentTimeMillis);
                jSONObject2.put("json", aVar);
            } catch (Exception unused) {
            }
            ZkViewSDK.b().g(c0822b.f35204a, jSONObject2.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(Context context) {
        if (this.f35200b != null) {
            return;
        }
        if (context instanceof Application) {
            this.f35200b = context;
        }
        if (this.f35200b == null) {
            this.f35200b = context.getApplicationContext();
        }
        if (this.f35200b == null) {
            this.f35200b = context;
        }
    }

    public void d(Context context, String str, String str2, String str3, String str4, String str5, int i2, long j2, String str6, String str7, Map map) {
        if (this.f35200b == null) {
            c(context);
        }
        C0822b c0822b = new C0822b(this, null);
        c0822b.f35204a = map;
        c0822b.f35205b = str3;
        c0822b.f35206c = str2;
        c0822b.f35208e = str5;
        c0822b.f35209f = str4;
        c0822b.f35207d = i2;
        c0822b.f35211h = j2;
        c0822b.f35212i = str;
        c0822b.f35210g = str6;
        c0822b.f35213j = str7;
        Message obtain = Message.obtain();
        obtain.obj = c0822b;
        obtain.what = 1;
        this.f35201c.sendMessage(obtain);
    }
}
