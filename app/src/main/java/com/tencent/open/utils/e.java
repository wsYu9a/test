package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.ss.android.download.api.constant.BaseConstants;
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
    private static Map<String, e> f25528a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private static String f25529b = null;

    /* renamed from: c */
    private Context f25530c;

    /* renamed from: d */
    private String f25531d;

    /* renamed from: e */
    private JSONObject f25532e = null;

    /* renamed from: f */
    private long f25533f = 0;

    /* renamed from: g */
    private int f25534g = 0;

    /* renamed from: h */
    private boolean f25535h = true;

    /* renamed from: com.tencent.open.utils.e$1 */
    class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ Bundle f25536a;

        AnonymousClass1(Bundle bundle) {
            bundle = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                e.this.a(i.d(HttpUtils.openUrl2(e.this.f25530c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f25555a));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.this.f25534g = 0;
        }
    }

    private e(Context context, String str) {
        this.f25530c = null;
        this.f25531d = null;
        this.f25530c = context.getApplicationContext();
        this.f25531d = str;
        a();
        b();
    }

    private void b() {
        if (this.f25534g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f25534g = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f25531d);
        bundle.putString("appid_for_getting_config", this.f25531d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.e.1

            /* renamed from: a */
            final /* synthetic */ Bundle f25536a;

            AnonymousClass1(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i.d(HttpUtils.openUrl2(e.this.f25530c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f25555a));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                e.this.f25534g = 0;
            }
        }.start();
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f25531d != null) {
                    str2 = str + "." + this.f25531d;
                } else {
                    str2 = str;
                }
                open = this.f25530c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f25530c.getAssets().open(str);
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
                        } catch (Throwable th) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private void d(String str) {
        if (this.f25535h) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.f25531d);
        }
    }

    public static e a(Context context, String str) {
        e eVar;
        synchronized (f25528a) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f25529b = str;
            }
            if (str == null && (str = f25529b) == null) {
                str = "0";
            }
            eVar = f25528a.get(str);
            if (eVar == null) {
                eVar = new e(context, str);
                f25528a.put(str, eVar);
            }
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return eVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f25532e.opt(str);
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
            this.f25532e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f25532e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f25531d != null) {
                str = str + "." + this.f25531d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f25530c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f25532e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f25533f >= optInt * BaseConstants.Time.HOUR) {
            b();
        }
    }

    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f25532e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f25533f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f25532e.optInt(str);
    }
}
