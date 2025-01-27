package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sigmob.sdk.base.k;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    private static HashSet<Integer> f22488a = new HashSet<>();

    /* renamed from: b */
    private String f22489b = null;

    /* renamed from: c */
    private Thread f22490c = null;

    /* renamed from: d */
    private String f22491d = null;

    /* renamed from: e */
    private Map<String, String> f22492e = null;

    private H5JavaScriptInterface() {
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n");
        for (int i10 = 2; i10 < thread.getStackTrace().length; i10++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i10];
            if (!stackTraceElement.toString().contains("crashreport")) {
                sb2.append(stackTraceElement.toString());
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        if (webViewInterface == null || f22488a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f22488a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f22490c = currentThread;
        h5JavaScriptInterface.f22491d = a(currentThread);
        h5JavaScriptInterface.f22492e = a(webViewInterface);
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        X.e("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            X.e("Payload from JS is null.", new Object[0]);
            return;
        }
        String c10 = ca.c(str.getBytes());
        String str2 = this.f22489b;
        if (str2 != null && str2.equals(c10)) {
            X.e("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f22489b = c10;
        X.e("Handling JS exception ...", new Object[0]);
        a a10 = a(str);
        if (a10 == null) {
            X.e("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(a10.a());
        linkedHashMap.putAll(this.f22492e);
        linkedHashMap.put("Java Stack", this.f22491d);
        a(a10, this.f22490c, linkedHashMap);
    }

    private static Map<String, String> a(CrashReport.WebViewInterface webViewInterface) {
        HashMap hashMap = new HashMap();
        hashMap.put("[WebView] ContentDescription", "" + ((Object) webViewInterface.getContentDescription()));
        return hashMap;
    }

    private a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                String string2 = jSONObject.getString("projectRoot");
                aVar.f22493a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString(f.X);
                aVar.f22494b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.f22495c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                aVar.f22496d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(bt.N);
                aVar.f22497e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f22498f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    X.e("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f22500h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                aVar.f22499g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    aVar.f22499g = aVar.f22499g.substring(indexOf2 + 1);
                }
                aVar.f22501i = jSONObject.getString(k.f18193y);
                if (aVar.f22498f == null) {
                    return null;
                }
                long j10 = jSONObject.getLong("lineNumber");
                aVar.f22502j = j10;
                if (j10 < 0) {
                    return null;
                }
                long j11 = jSONObject.getLong("columnNumber");
                aVar.f22503k = j11;
                if (j11 < 0) {
                    return null;
                }
                X.c("H5 crash information is following: ", new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[projectRoot]: ");
                sb2.append(aVar.f22493a);
                X.c(sb2.toString(), new Object[0]);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[context]: ");
                sb3.append(aVar.f22494b);
                X.c(sb3.toString(), new Object[0]);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[url]: ");
                sb4.append(aVar.f22495c);
                X.c(sb4.toString(), new Object[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[userAgent]: ");
                sb5.append(aVar.f22496d);
                X.c(sb5.toString(), new Object[0]);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[language]: ");
                sb6.append(aVar.f22497e);
                X.c(sb6.toString(), new Object[0]);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[name]: ");
                sb7.append(aVar.f22498f);
                X.c(sb7.toString(), new Object[0]);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("[message]: ");
                sb8.append(aVar.f22499g);
                X.c(sb8.toString(), new Object[0]);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("[stacktrace]: \n");
                sb9.append(aVar.f22500h);
                X.c(sb9.toString(), new Object[0]);
                StringBuilder sb10 = new StringBuilder();
                sb10.append("[file]: ");
                sb10.append(aVar.f22501i);
                X.c(sb10.toString(), new Object[0]);
                StringBuilder sb11 = new StringBuilder();
                sb11.append("[lineNumber]: ");
                sb11.append(aVar.f22502j);
                X.c(sb11.toString(), new Object[0]);
                StringBuilder sb12 = new StringBuilder();
                sb12.append("[columnNumber]: ");
                sb12.append(aVar.f22503k);
                X.c(sb12.toString(), new Object[0]);
                return aVar;
            } catch (Throwable th2) {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f22498f, aVar.f22499g, aVar.f22500h, map);
        }
    }
}
