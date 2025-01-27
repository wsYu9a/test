package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bw;
import com.kwad.sdk.core.webview.a.b.b;
import com.kwad.sdk.core.webview.a.b.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.a.kwai.b> apQ = new ConcurrentHashMap();
    private static final Map<String, String> apR = new ConcurrentHashMap();

    private static String M(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void N(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        apR.put(str, str2);
    }

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.f.kwai.b bVar, b.a aVar, boolean z) {
        com.kwad.sdk.core.webview.a.kwai.b bVar2;
        StringBuilder sb;
        String sb2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e2);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVar2.apY)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            sb2 = "getFilePath from url fail";
        } else {
            if (c.m60do(bVar2.apU)) {
                BufferedInputStream eu = q.eu(bVar2.apY);
                if (eu != null) {
                    return a(eu, bVar2);
                }
                b(z, "getResource [" + str + "] inputStream is null");
                sb = new StringBuilder("inputStream is null,本地加载路径：");
                sb.append(bVar2.apY);
            } else {
                b(z, "mimetype为: " + bVar2.apU + "不在拦截范围的文件");
                sb = new StringBuilder("mimetype为: ");
                sb.append(bVar2.apU);
                sb.append("不在拦截范围的文件");
            }
            sb2 = sb.toString();
        }
        aVar.msg = sb2;
        return null;
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.a.kwai.b bVar) {
        String str = bVar.apU;
        if (Build.VERSION.SDK_INT < 21) {
            return new WebResourceResponse(str, "UTF-8", inputStream);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Access-Control-Allow-Origin", bVar.apX.apS);
        hashMap.put("Access-Control-Allow-Credentials", "true");
        hashMap.put("Timing-Allow-Origin", bVar.apX.apT);
        hashMap.put("content-type", str);
        hashMap.put("Date", bVar.apX.apV);
        hashMap.put("union-cache ", "1");
        return new WebResourceResponse(bVar.apU, "", bVar.status, bw.k, hashMap, inputStream);
    }

    private static com.kwad.sdk.core.webview.a.kwai.b a(Context context, com.kwad.sdk.f.kwai.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String dh = dh(bVar.atm);
            com.kwad.sdk.core.webview.a.kwai.b dg = !TextUtils.isEmpty(dh) ? dg(M(dh, str)) : null;
            if (dg != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return dg;
            }
            String A = com.kwad.sdk.core.webview.a.b.a.A(context, bVar.atn);
            if (A == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(A);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + A;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                String b2 = h.b(inputStreamReader);
                if (TextUtils.isEmpty(b2)) {
                    aVar.msg = "获取配置文件失败 mainfest文件不存在";
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.sdk.core.webview.a.kwai.b bVar2 = new com.kwad.sdk.core.webview.a.kwai.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse("https://" + next).getHost();
                    bVar2.apZ = host;
                    bVar2.apY = com.kwad.sdk.core.webview.a.b.a.z(context, bVar.atn) + "/" + next;
                    if (TextUtils.isEmpty(bVar2.apU)) {
                        bVar2.apU = URLConnection.getFileNameMap().getContentTypeFor(bVar2.apY);
                    }
                    a(next, bVar2);
                    dh = host;
                }
                N(bVar.atm, dh);
                com.kwad.sdk.core.webview.a.kwai.b dg2 = dg(M(dh, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return dg2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.a.kwai.b bVar) {
        apQ.put(String.valueOf(str.hashCode()), bVar);
    }

    private static void b(boolean z, String str) {
        if (z) {
            return;
        }
        com.kwad.sdk.core.d.b.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.a.kwai.b dg(String str) {
        return apQ.get(String.valueOf(str.hashCode()));
    }

    private static String dh(String str) {
        return apR.get(str);
    }
}
