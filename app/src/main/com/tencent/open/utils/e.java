package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static Map<String, e> f23262a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private static String f23263b = null;

    /* renamed from: c */
    private Context f23264c;

    /* renamed from: d */
    private String f23265d;

    /* renamed from: e */
    private JSONObject f23266e = null;

    /* renamed from: f */
    private long f23267f = 0;

    /* renamed from: g */
    private int f23268g = 0;

    /* renamed from: h */
    private boolean f23269h = true;

    /* renamed from: com.tencent.open.utils.e$1 */
    public class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ Bundle f23270a;

        public AnonymousClass1(Bundle bundle) {
            bundle = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                e.this.a(i.d(HttpUtils.openUrl2(e.this.f23264c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f23289a));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            e.this.f23268g = 0;
        }
    }

    private e(Context context, String str) {
        this.f23264c = null;
        this.f23265d = null;
        this.f23264c = context.getApplicationContext();
        this.f23265d = str;
        a();
        b();
    }

    private void b() {
        if (this.f23268g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f23268g = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f23265d);
        bundle.putString("appid_for_getting_config", this.f23265d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.e.1

            /* renamed from: a */
            final /* synthetic */ Bundle f23270a;

            public AnonymousClass1(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i.d(HttpUtils.openUrl2(e.this.f23264c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f23289a));
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                e.this.f23268g = 0;
            }
        }.start();
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f23265d != null) {
                    str2 = str + p1.b.f29697h + this.f23265d;
                } else {
                    str2 = str;
                }
                open = this.f23264c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f23264c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Throwable th2) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                            throw th2;
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e13) {
            e13.printStackTrace();
            return "";
        }
    }

    private void d(String str) {
        if (this.f23269h) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.f23265d);
        }
    }

    public static e a(Context context, String str) {
        e eVar;
        synchronized (f23262a) {
            try {
                com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    f23263b = str;
                }
                if (str == null && (str = f23263b) == null) {
                    str = "0";
                }
                eVar = f23262a.get(str);
                if (eVar == null) {
                    eVar = new e(context, str);
                    f23262a.put(str, eVar);
                }
                com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance end");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f23266e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.f23266e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f23266e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f23265d != null) {
                str = str + p1.b.f29697h + this.f23265d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f23264c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f23266e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f23267f >= optInt * 3600000) {
            b();
        }
    }

    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f23266e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f23267f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f23266e.optInt(str);
    }
}
