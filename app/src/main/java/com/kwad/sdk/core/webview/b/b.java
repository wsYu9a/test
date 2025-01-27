package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bz;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.u;
import h3.e;
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

/* loaded from: classes3.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aIH = new ConcurrentHashMap();
    private static final Map<String, String> aII = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.g.a.b bVar, b.a aVar, boolean z10) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e10);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z10, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVar2.aIP)) {
            b(z10, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.fj(bVar2.aIL)) {
            b(z10, "mimetype为: " + bVar2.aIL + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVar2.aIL + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream gE = u.gE(bVar2.aIP);
        if (gE != null) {
            return a(gE, bVar2);
        }
        b(z10, "getResource [" + str + "] inputStream is null");
        StringBuilder sb2 = new StringBuilder("inputStream is null,本地加载路径：");
        sb2.append(bVar2.aIP);
        aVar.msg = sb2.toString();
        return null;
    }

    private static String ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ad(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aII.put(str, str2);
    }

    private static void b(boolean z10, String str) {
        if (z10) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b fb(String str) {
        return aIH.get(String.valueOf(str.hashCode()));
    }

    private static String fc(String str) {
        return aII.get(str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aIL;
        HashMap hashMap = new HashMap();
        hashMap.put(m5.c.T, bVar.aIO.aIJ);
        hashMap.put(m5.c.V, "true");
        hashMap.put(m5.c.I0, bVar.aIO.aIK);
        hashMap.put(e.f26401f, str);
        hashMap.put(m5.c.f28298d, bVar.aIO.aIM);
        hashMap.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aIL, "", bVar.status, bz.f6993k, hashMap, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.g.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String fc2 = fc(bVar.aMy);
            com.kwad.sdk.core.webview.b.a.b fb2 = !TextUtils.isEmpty(fc2) ? fb(ac(fc2, str)) : null;
            if (fb2 != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return fb2;
            }
            String J = com.kwad.sdk.core.webview.b.c.a.J(context, bVar.aMz);
            if (J == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(J);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + J;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            try {
                String b10 = h.b(inputStreamReader);
                if (TextUtils.isEmpty(b10)) {
                    aVar.msg = "获取配置文件失败 mainfest文件不存在";
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b10);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse("https://" + next).getHost();
                    bVar2.aIQ = host;
                    bVar2.aIP = com.kwad.sdk.core.webview.b.c.a.I(context, bVar.aMz) + "/" + next;
                    if (TextUtils.isEmpty(bVar2.aIL)) {
                        bVar2.aIL = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aIP);
                    }
                    a(next, bVar2);
                    fc2 = host;
                }
                ad(bVar.aMy, fc2);
                com.kwad.sdk.core.webview.b.a.b fb3 = fb(ac(fc2, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return fb3;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aIH.put(String.valueOf(str.hashCode()), bVar);
    }
}
