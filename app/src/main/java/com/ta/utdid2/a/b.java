package com.ta.utdid2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import b.i.a.a.a.d;
import b.i.a.a.a.f;
import com.baidu.mobads.sdk.internal.ch;
import com.cdo.oaps.ad.OapsKey;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f24534a = "com.ta.utdid2.a.b";

    /* renamed from: b */
    private static b f24535b;

    /* renamed from: c */
    private Context f24536c;

    /* renamed from: d */
    private Object f24537d = new Object();

    public b(Context context) {
        this.f24536c = context;
    }

    public static synchronized b b(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f24535b == null) {
                f24535b = new b(context);
            }
            bVar = f24535b;
        }
        return bVar;
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MiConfigSingleton.t0)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(MiConfigSingleton.t0);
                if (!jSONObject2.has("action") || !jSONObject2.has(OapsKey.KEY_APP_ID)) {
                    return str2;
                }
                String string = jSONObject2.getString("action");
                return (string.equalsIgnoreCase("new") || string.equalsIgnoreCase("changed")) ? jSONObject2.getString(OapsKey.KEY_APP_ID) : str2;
            }
            if (!jSONObject.has("isError") || !jSONObject.has("status")) {
                return str2;
            }
            String string2 = jSONObject.getString("isError");
            String string3 = jSONObject.getString("status");
            if (!string2.equalsIgnoreCase("true")) {
                return str2;
            }
            if (!string3.equalsIgnoreCase(ch.f5707b) && !string3.equalsIgnoreCase("401")) {
                return str2;
            }
            if (d.f5072a) {
                Log.d(f24534a, "remove the AID, status:" + string3);
            }
            return "";
        } catch (JSONException e2) {
            Log.e(f24534a, e2.toString());
            return str2;
        } catch (Exception e3) {
            Log.e(f24534a, e3.toString());
            return str2;
        }
    }

    private static String i(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        try {
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        sb.append("http://hydra.alibaba.com/");
        sb.append(str);
        sb.append("/get_aid/");
        sb.append("?");
        sb.append("auth[token]=");
        sb.append(str2);
        sb.append("&type=");
        sb.append(b.b.a.b.b.f4204g);
        sb.append("&id=");
        sb.append(str3);
        sb.append("&aid=");
        sb.append(str4);
        return sb.toString();
    }

    public String f(String str, String str2, String str3, String str4) {
        String i2 = i(str, str2, str3, str4);
        int i3 = f.c(this.f24536c) ? 3000 : 1000;
        if (d.f5072a) {
            Log.d(f24534a, "url:" + i2 + "; timeout:" + i3);
        }
        a aVar = new a(new HttpPost(i2));
        aVar.start();
        try {
            synchronized (this.f24537d) {
                this.f24537d.wait(i3);
            }
        } catch (Exception e2) {
            Log.e(f24534a, e2.toString());
        }
        String c2 = aVar.c();
        if (d.f5072a) {
            Log.d(f24534a, "mLine:" + c2);
        }
        return e(c2, str4);
    }

    public void g(String str, String str2, String str3, String str4, b.j.a.b bVar) {
        String i2 = i(str, str2, str3, str4);
        if (d.f5072a) {
            Log.d(f24534a, "url:" + i2 + "; len:" + i2.length());
        }
        new a(new HttpPost(i2), bVar, str4, str, str2).start();
    }

    class a extends Thread {

        /* renamed from: a */
        HttpPost f24538a;

        /* renamed from: b */
        String f24539b;

        /* renamed from: c */
        b.j.a.b f24540c;

        /* renamed from: d */
        String f24541d;

        /* renamed from: e */
        String f24542e;

        /* renamed from: f */
        String f24543f;

        public a(HttpPost httpPost) {
            this.f24539b = "";
            this.f24543f = "";
            this.f24538a = httpPost;
        }

        public String c() {
            return this.f24539b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x006b, code lost:
        
            android.util.Log.e(com.ta.utdid2.a.b.f24534a, r0.toString());
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.b.a.run():void");
        }

        public a(HttpPost httpPost, b.j.a.b bVar, String str, String str2, String str3) {
            this.f24539b = "";
            this.f24543f = "";
            this.f24538a = httpPost;
            this.f24540c = bVar;
            this.f24541d = str;
            this.f24542e = str2;
            this.f24543f = str3;
        }
    }
}
