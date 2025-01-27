package com.sigmob.sdk.base;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public class h extends WebViewClient {

    /* renamed from: e */
    public static final String f18146e = "Set-Cookie";

    /* renamed from: f */
    public static final String f18147f = "Referer";

    /* renamed from: g */
    public static final String f18148g = "mraid.js";

    /* renamed from: h */
    public static final String f18149h = "mraid2.js";

    /* renamed from: i */
    public static final String f18150i = "Cookie";

    /* renamed from: a */
    public CookieManager f18151a = new CookieManager();

    /* renamed from: b */
    public boolean f18152b = false;

    /* renamed from: c */
    public boolean f18153c = false;

    /* renamed from: d */
    public String f18154d;

    public void a(boolean z10) {
    }

    public void b(boolean z10) {
        this.f18153c = z10;
    }

    public final WebResourceResponse c(String str) {
        Uri parse;
        String host;
        String lastPathSegment;
        try {
            parse = Uri.parse(str);
            host = parse.getHost();
            lastPathSegment = parse.getLastPathSegment();
        } catch (Throwable th2) {
            SigmobLog.e("useWebResourceCache ", th2);
        }
        if (host != null && !a(str) && parse.getScheme().startsWith("http") && !host.equals(com.sigmob.sdk.videocache.h.f20606j) && TextUtils.isEmpty(parse.getQueryParameter("no-cache")) && (lastPathSegment.endsWith(".js") || lastPathSegment.endsWith(".css"))) {
            File file = new File(com.sigmob.sdk.base.utils.d.k(), lastPathSegment);
            String str2 = lastPathSegment.endsWith(".js") ? "text/javascript" : lastPathSegment.endsWith(".css") ? "text/css" : null;
            if (file.exists()) {
                WebResourceResponse webResourceResponse = new WebResourceResponse(str2, "UTF-8", new FileInputStream(file));
                HashMap hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-store");
                webResourceResponse.setResponseHeaders(hashMap);
                return webResourceResponse;
            }
            return null;
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        super.onReceivedError(webView, i10, str, str2);
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponse;
        File a10;
        try {
            webResourceResponse = a(webResourceRequest.getUrl());
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        } catch (Throwable unused) {
            webResourceResponse = null;
        }
        if (this.f18153c && (webResourceResponse = c(webResourceRequest.getUrl().toString())) != null) {
            return webResourceResponse;
        }
        if ((this.f18152b || (this.f18153c && !b.a(webResourceRequest.getUrl().toString()))) && !a(webResourceRequest.getUrl().toString())) {
            webResourceResponse = b.a(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
        }
        if (webResourceResponse == null) {
            webResourceResponse = super.shouldInterceptRequest(webView, webResourceRequest);
        }
        if (this.f18153c && webResourceResponse != null && (a10 = a(webResourceResponse, webResourceRequest.getUrl().toString())) != null && a10.exists()) {
            try {
                return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), new FileInputStream(a10));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponse;
    }

    public static WebResourceResponse a(Uri uri) {
        if (!uri.getScheme().startsWith(k.f18193y)) {
            return null;
        }
        try {
            return new WebResourceResponse("text/html", "utf-8", new FileInputStream(uri.getPath()));
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.f18154d = parse.getScheme() + "://" + parse.getHost() + "/" + parse.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponse;
        File a10;
        try {
            webResourceResponse = a(Uri.parse(str));
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        } catch (Throwable unused) {
            webResourceResponse = null;
        }
        if (this.f18153c && (webResourceResponse = c(str)) != null) {
            return webResourceResponse;
        }
        if ((this.f18152b || (this.f18153c && !b.a(str))) && !a(str)) {
            webResourceResponse = b.a(str, "GET", null);
        }
        if (webResourceResponse == null) {
            webResourceResponse = super.shouldInterceptRequest(webView, str);
        }
        if (this.f18153c && webResourceResponse != null && (a10 = a(webResourceResponse, str)) != null && a10.exists()) {
            try {
                return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), new FileInputStream(a10));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponse;
    }

    public static void a(HttpURLConnection httpURLConnection, CookieManager cookieManager) {
        if (cookieManager == null || httpURLConnection == null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        SigmobLog.d("headerFields : " + headerFields.toString());
        List<String> list = headerFields.get("Set-Cookie");
        if (list != null) {
            for (String str : list) {
                try {
                    List<HttpCookie> parse = HttpCookie.parse(str);
                    if (parse != null) {
                        SigmobLog.d("{0} -- Reading Cookies from the response :" + httpURLConnection.getURL().toString());
                        SigmobLog.d("{0} -- Reading Cookies from the response :" + parse.get(0));
                        for (HttpCookie httpCookie : parse) {
                            SigmobLog.d(httpCookie.toString());
                            android.webkit.CookieManager.getInstance().setCookie(httpURLConnection.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                        }
                    }
                } catch (NullPointerException unused) {
                    SigmobLog.e(MessageFormat.format("{0} -- Null header for the cookie : {1}", httpURLConnection.getURL().toString(), str.toString()));
                }
            }
            android.webkit.CookieManager.getInstance().flush();
        }
    }

    public static boolean a(String str) {
        Uri parse = Uri.parse(str.toLowerCase(Locale.US));
        return "mraid.js".equals(parse.getLastPathSegment()) || "mraid2.js".equals(parse.getLastPathSegment());
    }

    public static File a(WebResourceResponse webResourceResponse, String str) {
        try {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (b.a(str)) {
                return null;
            }
            File file = new File(com.sigmob.sdk.base.utils.d.k(), lastPathSegment);
            FileUtil.writeToCache(webResourceResponse.getData(), file.getAbsolutePath());
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }
}
