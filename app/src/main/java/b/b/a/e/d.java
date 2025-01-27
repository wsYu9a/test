package b.b.a.e;

import android.content.Context;
import android.text.TextUtils;
import b.b.a.c.e;
import b.b.a.c.f;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.protocol.g;
import com.alipay.sdk.protocol.h;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private int f4271a = 0;

    /* renamed from: b */
    private b.b.a.c.c f4272b;

    public d() {
    }

    public d(b.b.a.c.c cVar) {
        this.f4272b = cVar;
    }

    private String b(Context context, String str, String str2, b.b.a.c.c cVar, f fVar) throws NetErrorException {
        try {
            try {
                a aVar = c.f4270a;
                if (aVar == null) {
                    c.f4270a = new a(context, str);
                } else if (!TextUtils.equals(str, aVar.f4266b)) {
                    c.f4270a.f4266b = str;
                }
                HttpResponse b2 = cVar != null ? c.f4270a.b(str2, cVar) : c.f4270a.b(str2, null);
                StatusLine statusLine = b2.getStatusLine();
                fVar.f4244c = statusLine.getStatusCode();
                fVar.f4245d = statusLine.getReasonPhrase();
                b.b.a.c.c cVar2 = this.f4272b;
                Header[] headers = b2.getHeaders("Msp-Param");
                if (cVar2 != null && headers.length > 0) {
                    cVar2.f4225b = headers;
                }
                return c.a(b2);
            } catch (Exception unused) {
                throw new NetErrorException();
            }
        } finally {
            c.f4270a = null;
        }
    }

    private static String c(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                char[] cArr = new char[2048];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private JSONObject d(Context context, e eVar, f fVar) throws NetErrorException {
        int i2;
        double random;
        double d2;
        String valueOf;
        Random random2 = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < 24; i3++) {
            int nextInt = random2.nextInt(3);
            if (nextInt == 0) {
                random = Math.random() * 25.0d;
                d2 = 65.0d;
            } else if (nextInt == 1) {
                random = Math.random() * 25.0d;
                d2 = 97.0d;
            } else if (nextInt == 2) {
                valueOf = String.valueOf(new Random().nextInt(10));
                stringBuffer.append(valueOf);
            }
            valueOf = String.valueOf((char) Math.round(random + d2));
            stringBuffer.append(valueOf);
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            String b2 = b(context, eVar.f4235a.f4218a, eVar.a(stringBuffer2).toString(), eVar.f4239e.get(), fVar);
            fVar.f4246e = Calendar.getInstance().getTimeInMillis();
            if (!eVar.f4240f) {
                JSONObject g2 = g(b2, fVar);
                String str = "respData:" + g2.toString();
                return g2;
            }
            JSONObject g3 = g(b2, fVar);
            if (fVar.f4244c == 1000 && (i2 = this.f4271a) < 3) {
                this.f4271a = i2 + 1;
                return d(context, eVar, fVar);
            }
            this.f4271a = 0;
            String b3 = b.b.a.d.e.b(stringBuffer2, g3.optString("res_data"));
            String str2 = "respData:" + b3;
            return new JSONObject(b3);
        } catch (NetErrorException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new NetErrorException();
        }
    }

    private JSONObject e(Context context, e eVar, f fVar, String str, String str2) throws JSONException, NetErrorException {
        int i2;
        JSONObject g2 = g(str2, fVar);
        if (fVar.f4244c == 1000 && (i2 = this.f4271a) < 3) {
            this.f4271a = i2 + 1;
            return d(context, eVar, fVar);
        }
        this.f4271a = 0;
        String b2 = b.b.a.d.e.b(str, g2.optString("res_data"));
        String str3 = "respData:" + b2;
        return new JSONObject(b2);
    }

    private static JSONObject f(f fVar, String str) throws JSONException {
        JSONObject g2 = g(str, fVar);
        String str2 = "respData:" + g2.toString();
        return g2;
    }

    private static JSONObject g(String str, f fVar) throws JSONException {
        JSONObject optJSONObject = new JSONObject(str).optJSONObject(MiConfigSingleton.t0);
        if (optJSONObject == null) {
            fVar.f4244c = 503;
            fVar.f4245d = "";
            return null;
        }
        fVar.f4244c = optJSONObject.optInt("code", 503);
        fVar.f4245d = optJSONObject.optString("error_msg", "");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
        if (optJSONObject2 == null) {
            return null;
        }
        if (fVar.f4244c == 1000) {
            String optString = optJSONObject2.optString("public_key");
            if (!TextUtils.isEmpty(optString)) {
                b.b.a.f.a.a().f4275c.e(optString);
            }
        }
        b.b.a.c.a aVar = new b.b.a.c.a();
        aVar.f4220c = optJSONObject2.optString("next_api_name");
        aVar.f4221d = optJSONObject2.optString("next_api_version");
        aVar.f4219b = optJSONObject2.optString("next_namespace");
        aVar.f4218a = optJSONObject2.optString("next_request_url");
        fVar.l = aVar;
        return optJSONObject2;
    }

    private static void h(JSONObject jSONObject) {
        String optString = jSONObject.optString("public_key");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        b.b.a.f.a.a().f4275c.e(optString);
    }

    public final com.alipay.sdk.protocol.c a(Context context, e eVar, boolean z) throws NetErrorException {
        f fVar = new f();
        JSONObject d2 = d(context, eVar, fVar);
        if (d2.optBoolean("gzip")) {
            JSONObject optJSONObject = d2.optJSONObject(b.b.a.b.c.f4210c);
            if (optJSONObject != null && optJSONObject.has("quickpay")) {
                try {
                    byte[] g2 = b.b.a.c.b.g(b.b.a.d.a.d(optJSONObject.optString("quickpay")));
                    if (TextUtils.equals(b.b.a.d.c.b(g2), d2.optString("md5"))) {
                        d2.put(b.b.a.b.c.f4210c, new JSONObject(new String(g2, "utf-8")));
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            fVar.k = false;
        }
        String str = "responsestring decoded " + d2;
        com.alipay.sdk.protocol.c cVar = new com.alipay.sdk.protocol.c(eVar, fVar);
        cVar.b(d2);
        if (z) {
            return cVar;
        }
        new g();
        h a2 = g.a(cVar);
        if (a2 != null) {
            cVar = a2;
        }
        f fVar2 = cVar.f5418b;
        JSONObject jSONObject = cVar.f5419c;
        b.b.a.c.a aVar = cVar.f5417a.f4235a;
        b.b.a.c.a aVar2 = fVar2.l;
        if (TextUtils.isEmpty(aVar2.f4220c)) {
            aVar2.f4220c = aVar.f4220c;
        }
        if (TextUtils.isEmpty(aVar2.f4221d)) {
            aVar2.f4221d = aVar.f4221d;
        }
        if (TextUtils.isEmpty(aVar2.f4219b)) {
            aVar2.f4219b = aVar.f4219b;
        }
        if (TextUtils.isEmpty(aVar2.f4218a)) {
            aVar2.f4218a = aVar.f4218a;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("reflected_data");
        if (optJSONObject2 != null) {
            String str2 = "session = " + optJSONObject2.optString(com.umeng.analytics.pro.d.aw, "");
            cVar.f5418b.f4250i = optJSONObject2;
        } else if (jSONObject.has(com.umeng.analytics.pro.d.aw)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.umeng.analytics.pro.d.aw, jSONObject.optString(com.umeng.analytics.pro.d.aw));
                String str3 = com.alipay.sdk.tid.b.a().f5438b;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put(b.b.a.b.b.f4200c, str3);
                }
                fVar2.f4250i = jSONObject2;
            } catch (JSONException unused2) {
            }
        }
        fVar2.f4247f = jSONObject.optString("end_code", "0");
        fVar2.f4251j = jSONObject.optString("user_id", "");
        String optString = jSONObject.optString("result");
        try {
            optString = URLDecoder.decode(jSONObject.optString("result"), "UTF-8");
        } catch (UnsupportedEncodingException unused3) {
        }
        fVar2.f4248g = optString;
        fVar2.f4249h = jSONObject.optString("memo", "");
        return cVar;
    }
}
