package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    private static HashSet<Integer> f24865a = new HashSet<>();

    /* renamed from: b */
    private String f24866b = null;

    /* renamed from: c */
    private Thread f24867c = null;

    /* renamed from: d */
    private String f24868d = null;

    /* renamed from: e */
    private Map<String, String> f24869e = null;

    private H5JavaScriptInterface() {
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i2 = 2; i2 < thread.getStackTrace().length; i2++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i2];
            if (!stackTraceElement.toString().contains("crashreport")) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        if (webViewInterface == null || f24865a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f24865a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f24867c = currentThread;
        h5JavaScriptInterface.f24868d = a(currentThread);
        h5JavaScriptInterface.f24869e = a(webViewInterface);
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
        String c2 = ca.c(str.getBytes());
        String str2 = this.f24866b;
        if (str2 != null && str2.equals(c2)) {
            X.e("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f24866b = c2;
        X.e("Handling JS exception ...", new Object[0]);
        a a2 = a(str);
        if (a2 == null) {
            X.e("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(a2.a());
        linkedHashMap.putAll(this.f24869e);
        linkedHashMap.put("Java Stack", this.f24868d);
        a(a2, this.f24867c, linkedHashMap);
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
                aVar.f24870a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                aVar.f24871b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.f24872c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                aVar.f24873d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(am.N);
                aVar.f24874e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f24875f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    X.e("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f24877h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                aVar.f24876g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    aVar.f24876g = aVar.f24876g.substring(indexOf2 + 1);
                }
                aVar.f24878i = jSONObject.getString("file");
                if (aVar.f24875f == null) {
                    return null;
                }
                long j2 = jSONObject.getLong("lineNumber");
                aVar.f24879j = j2;
                if (j2 < 0) {
                    return null;
                }
                long j3 = jSONObject.getLong("columnNumber");
                aVar.k = j3;
                if (j3 < 0) {
                    return null;
                }
                X.c("H5 crash information is following: ", new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("[projectRoot]: ");
                sb.append(aVar.f24870a);
                X.c(sb.toString(), new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[context]: ");
                sb2.append(aVar.f24871b);
                X.c(sb2.toString(), new Object[0]);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[url]: ");
                sb3.append(aVar.f24872c);
                X.c(sb3.toString(), new Object[0]);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[userAgent]: ");
                sb4.append(aVar.f24873d);
                X.c(sb4.toString(), new Object[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[language]: ");
                sb5.append(aVar.f24874e);
                X.c(sb5.toString(), new Object[0]);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[name]: ");
                sb6.append(aVar.f24875f);
                X.c(sb6.toString(), new Object[0]);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[message]: ");
                sb7.append(aVar.f24876g);
                X.c(sb7.toString(), new Object[0]);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("[stacktrace]: \n");
                sb8.append(aVar.f24877h);
                X.c(sb8.toString(), new Object[0]);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("[file]: ");
                sb9.append(aVar.f24878i);
                X.c(sb9.toString(), new Object[0]);
                StringBuilder sb10 = new StringBuilder();
                sb10.append("[lineNumber]: ");
                sb10.append(aVar.f24879j);
                X.c(sb10.toString(), new Object[0]);
                StringBuilder sb11 = new StringBuilder();
                sb11.append("[columnNumber]: ");
                sb11.append(aVar.k);
                X.c(sb11.toString(), new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f24875f, aVar.f24876g, aVar.f24877h, map);
        }
    }
}
