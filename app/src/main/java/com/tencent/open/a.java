package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.f;
import com.vivo.ic.webview.BridgeUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    protected HashMap<String, b> f25393a = new HashMap<>();

    public static class b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.a.C0530a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.b.call(java.lang.String, java.util.List, com.tencent.open.a$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f25393a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0530a c0530a) {
        f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        b bVar = this.f25393a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0530a);
        } else {
            f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0530a != null) {
                c0530a.a();
            }
        }
    }

    /* renamed from: com.tencent.open.a$a */
    public static class C0530a {

        /* renamed from: a */
        protected WeakReference<WebView> f25404a;

        /* renamed from: b */
        protected long f25405b;

        /* renamed from: c */
        protected String f25406c;

        public C0530a(WebView webView, long j2, String str) {
            this.f25404a = new WeakReference<>(webView);
            this.f25405b = j2;
            this.f25406c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f25404a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                obj2 = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) ? obj.toString() : obj instanceof Boolean ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f25405b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView = this.f25404a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f25405b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f25404a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals(BridgeUtils.BRIDGE_SCHEME)) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        C0530a c0530a = new C0530a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, c0530a);
        return true;
    }
}
