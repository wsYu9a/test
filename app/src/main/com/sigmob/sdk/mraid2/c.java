package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.martian.libmars.activity.PermissionActivity;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.e0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.d;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.m;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements i {

    /* renamed from: h */
    public static String f19697h = "Mraid2Bridge";

    /* renamed from: i */
    public static m f19698i;

    /* renamed from: j */
    public static HashMap<String, List<String>> f19699j = new HashMap<>();

    /* renamed from: a */
    public List<BaseAdUnit> f19700a;

    /* renamed from: b */
    public f f19701b;

    /* renamed from: c */
    public com.sigmob.sdk.mraid2.g f19702c;

    /* renamed from: d */
    public d.InterfaceC0605d f19703d;

    /* renamed from: e */
    public List<BaseAdUnit> f19704e;

    /* renamed from: f */
    public volatile boolean f19705f;

    /* renamed from: g */
    public boolean f19706g;

    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return c.this.f19703d != null ? c.this.f19703d.a(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            if (c.this.f19705f || c.this.f19706g || i10 <= 70) {
                return;
            }
            c.this.f19706g = true;
            c.this.a(h.f19792l, (ValueCallback) null);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.a(true);
                c.this.i();
                c cVar = c.this;
                cVar.a(cVar.f19702c.getAdSize());
                c.this.k();
                c.this.a(100);
                c cVar2 = c.this;
                c.this.a(cVar2.a((List<BaseAdUnit>) cVar2.f19700a));
            } catch (Throwable th2) {
                SigmobLog.e("handleMraidLoad", th2);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.mraid2.c$c */
    public class RunnableC0602c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ c f19709a;

        /* renamed from: b */
        public final /* synthetic */ String f19710b;

        public RunnableC0602c(c cVar, String str) {
            this.f19709a = cVar;
            this.f19710b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19709a.e(this.f19710b);
        }
    }

    public class d implements d.a {

        /* renamed from: a */
        public final /* synthetic */ c f19712a;

        /* renamed from: b */
        public final /* synthetic */ String f19713b;

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ List f19715a;

            public a(List list) {
                this.f19715a = list;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ad_count", String.valueOf(this.f19715a.size()));
                    hashMap.put(AdKeys.REQUEST_ID, ((BaseAdUnit) this.f19715a.get(0)).getRequestId());
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        }

        public d(c cVar, String str) {
            this.f19712a = cVar;
            this.f19713b = str;
        }

        @Override // com.sigmob.sdk.base.network.d.a
        public void a(int i10, String str, String str2, LoadAdRequest loadAdRequest) {
            Log.d(c.f19697h, "-----------onErrorResponse---------" + i10 + ":" + str);
            this.f19712a.a(this.f19713b, (BidResponse) null, i10, str);
            b0.a(PointCategory.RESPOND, "0", loadAdRequest);
        }

        @Override // com.sigmob.sdk.base.network.d.a
        public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
            if (list == null || list.size() <= 0) {
                return;
            }
            Log.d(c.f19697h, "-----------onSuccess---------" + list.size());
            c.this.f19704e.addAll(list);
            this.f19712a.a(this.f19713b, c.this.a(list), 0, (String) null);
            b0.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, new a(list));
        }
    }

    public static class e {

        /* renamed from: a */
        public final WeakReference<c> f19717a;

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ JSONObject f19718a;

            public a(JSONObject jSONObject) {
                this.f19718a = jSONObject;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = this.f19718a.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equalsIgnoreCase("_ac_type")) {
                        hashMap.put(next, this.f19718a.optString(next));
                    }
                }
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        }

        public class b implements m.a {

            public class a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ JSONObject f19721a;

                public a(JSONObject jSONObject) {
                    this.f19721a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    e.this.a().b(this.f19721a);
                }
            }

            public b() {
            }

            @Override // com.sigmob.sdk.mraid2.m.a
            public void a(JSONObject jSONObject) {
                if (e.this.a() == null || e.this.a().f() == null) {
                    return;
                }
                e.this.a().f().post(new a(jSONObject));
            }
        }

        /* renamed from: com.sigmob.sdk.mraid2.c$e$c */
        public class RunnableC0603c implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ c f19723a;

            /* renamed from: b */
            public final /* synthetic */ String f19724b;

            public RunnableC0603c(c cVar, String str) {
                this.f19723a = cVar;
                this.f19724b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = this.f19723a;
                cVar.a(cVar, this.f19724b);
            }
        }

        public e(c cVar) {
            this.f19717a = new WeakReference<>(cVar);
        }

        public c a() {
            return this.f19717a.get();
        }

        @JavascriptInterface
        public String addDclog(JSONObject jSONObject) {
            try {
                if (jSONObject == null) {
                    return c.a(400, "not params", (Object) null);
                }
                Log.d(c.f19697h, "----------addDclog----------" + jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject(h3.e.f26408m);
                if (optJSONObject == null || !optJSONObject.has("_ac_type")) {
                    return c.a(300, "_ac_type is empty", (Object) null);
                }
                String optString = optJSONObject.optString("_ac_type");
                BaseAdUnit a10 = a() != null ? a().a(jSONObject.optString("vid")) : null;
                b0.a(optString, a10, a10 == null ? a().d() : null, new a(optJSONObject));
                return c.a(200, "add dc log success", (Object) null);
            } catch (Throwable th2) {
                return c.a(500, th2.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (TextUtils.isEmpty(string)) {
                    return c.a(400, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th2) {
                return c.a(500, th2.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String getDeviceInfo() {
            try {
                Log.d(c.f19697h, "---------getDeviceInfo----------");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientType", ClientMetadata.getDeviceModel());
                jSONObject.put("osVersion", ClientMetadata.getDeviceOsVersion());
                jSONObject.put("appVersion", ClientMetadata.getInstance().getAppVersion());
                jSONObject.put("width", ClientMetadata.getInstance().getDisplayMetrics().widthPixels);
                jSONObject.put("height", ClientMetadata.getInstance().getDisplayMetrics().heightPixels);
                jSONObject.put("screenDensity", ClientMetadata.getInstance().getDensityDpi());
                jSONObject.put("networkType", ClientMetadata.getInstance().getActiveNetworkType());
                jSONObject.put(PushClientConstants.TAG_PKG_NAME, ClientMetadata.getInstance().getAppPackageName());
                jSONObject.put(TTDownloadField.TT_USERAGENT, Networking.getUserAgent());
                jSONObject.put("uid", ClientMetadata.getUid());
                jSONObject.put("udid", ClientMetadata.getInstance().getUDID());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("imei", ClientMetadata.getInstance().getDeviceId());
                jSONObject2.put("androidId", ClientMetadata.getInstance().getAndroidId());
                jSONObject2.put("googleId", ClientMetadata.getInstance().getAdvertisingId());
                jSONObject2.put(AdKeys.OAID, ClientMetadata.getInstance().getOAID());
                jSONObject.put("android", jSONObject2);
                return jSONObject.toString();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }

        @JavascriptInterface
        public String getUniqueId() {
            c a10 = a();
            if (a10 != null) {
                return a10.f().getUniqueId();
            }
            return null;
        }

        @JavascriptInterface
        public String handleMacro(JSONObject jSONObject) {
            String optString;
            JSONObject optJSONObject;
            char c10;
            if (jSONObject == null) {
                return null;
            }
            try {
                Log.d(c.f19697h, "-----------handleMacro---------" + jSONObject);
                optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
                optJSONObject = jSONObject.optJSONObject("args");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (optJSONObject == null) {
                return null;
            }
            String optString2 = optJSONObject.optString(PermissionActivity.f12046p);
            String optString3 = optJSONObject.optString("value");
            BaseAdUnit a10 = a() != null ? a().a(optJSONObject.optString("vid")) : null;
            switch (optString.hashCode()) {
                case -1253019733:
                    if (optString.equals("addMacro")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -759131257:
                    if (optString.equals("addAllMacros")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -750002817:
                    if (optString.equals("clearMacro")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -310745688:
                    if (optString.equals("removeMacro")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1959477782:
                    if (optString.equals("getMacro")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            if (c10 == 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("maps");
                if (optJSONObject2 != null) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        (a10 != null ? a10.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).addMarcoKey(next, optJSONObject2.optString(next));
                    }
                }
            } else {
                if (c10 == 1) {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        (a10 != null ? a10.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).addMarcoKey(optString2, optString3);
                    }
                    return null;
                }
                if (c10 == 2) {
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return a10 != null ? a10.getMacroCommon().getMarcoKey(optString2) : Sigmob.getInstance().getMacroCommon().getMarcoKey(optString2);
                }
                if (c10 != 3) {
                    if (c10 == 4) {
                        (a10 != null ? a10.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).clearMacro();
                    }
                } else {
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    (a10 != null ? a10.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).removeMarcoKey(optString2);
                }
            }
            return null;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Log.d(c.f19697h, "-----------postMessage---------" + str);
            c a10 = a();
            if (a10 == null || a10.f19702c == null) {
                return;
            }
            a10.f19702c.post(new RunnableC0603c(a10, str));
        }

        @JavascriptInterface
        public String storage(String str) {
            char c10;
            try {
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Log.d(c.f19697h, "-----------storage---------" + str);
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            JSONObject optJSONObject = jSONObject.optJSONObject("args");
            int optInt = optJSONObject.optInt("type");
            String optString2 = optJSONObject.optString(PermissionActivity.f12046p);
            String optString3 = optJSONObject.optString("value");
            if (optInt == 1 || optInt == 2) {
                if (c.f19698i == null) {
                    m unused = c.f19698i = new m(a().f19702c.getContext());
                }
                switch (optString.hashCode()) {
                    case -1106363674:
                        if (optString.equals(com.sigmob.sdk.videocache.sourcestorage.a.f20681d)) {
                            c10 = 4;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case -625809843:
                        if (optString.equals("addEventListener")) {
                            c10 = 5;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case -75439223:
                        if (optString.equals("getItem")) {
                            c10 = 1;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case 94746189:
                        if (optString.equals("clear")) {
                            c10 = 3;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case 1098253751:
                        if (optString.equals("removeItem")) {
                            c10 = 2;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case 1984670357:
                        if (optString.equals("setItem")) {
                            c10 = 0;
                            break;
                        }
                        c10 = 65535;
                        break;
                    default:
                        c10 = 65535;
                        break;
                }
                if (c10 == 0) {
                    c.f19698i.a(optInt, optString2, optString3);
                } else {
                    if (c10 == 1) {
                        return c.f19698i.a(optInt, optString2);
                    }
                    if (c10 == 2) {
                        c.f19698i.b(optInt, optString2);
                    } else if (c10 == 3) {
                        c.f19698i.a(optInt);
                    } else {
                        if (c10 == 4) {
                            return String.valueOf(c.f19698i.b(optInt));
                        }
                        if (c10 == 5) {
                            c.f19698i.a(optInt, optString2, new b());
                        }
                    }
                }
            }
            return null;
        }

        @JavascriptInterface
        public String tracking(JSONObject jSONObject) {
            String str;
            boolean z10;
            boolean z11;
            boolean z12;
            int i10;
            try {
                if (jSONObject == null) {
                    return c.a(400, "not params", (Object) null);
                }
                Log.d(c.f19697h, "---------tracking----------" + jSONObject);
                String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                JSONObject optJSONObject = jSONObject.optJSONObject(h3.e.f26408m);
                int i11 = 0;
                if (optJSONObject != null) {
                    z11 = optJSONObject.optBoolean("inQueue");
                    z12 = optJSONObject.optBoolean("statistic");
                    i10 = optJSONObject.optInt("retry");
                    str = optJSONObject.optString("vid");
                    z10 = optJSONObject.optBoolean("repeat");
                } else {
                    str = "";
                    z10 = false;
                    z11 = false;
                    z12 = false;
                    i10 = 0;
                }
                BaseAdUnit a10 = a() != null ? a().a(str) : null;
                String str2 = "js";
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    while (i11 < optJSONArray.length()) {
                        e0 e0Var = new e0(optJSONArray.optString(i11), optString, a10 != null ? a10.getRequestId() : "");
                        e0Var.setRetryNum(Integer.valueOf(i10));
                        e0Var.setSource(str2);
                        com.sigmob.sdk.base.network.f.a(e0Var, a10, z10, z11, z12, null);
                        i11++;
                        str2 = str2;
                    }
                    return c.a(200, "tracking success", (Object) null);
                }
                String str3 = "js";
                List<e0> adTracker = a10 != null ? a10.getAdTracker(optString) : null;
                if (adTracker != null) {
                    for (e0 e0Var2 : adTracker) {
                        e0Var2.setRetryNum(Integer.valueOf(i10));
                        String str4 = str3;
                        e0Var2.setSource(str4);
                        com.sigmob.sdk.base.network.f.a(e0Var2, a10, z10, z11, z12, null);
                        str3 = str4;
                    }
                }
                return c.a(300, "urls is empty", (Object) null);
            } catch (Throwable th2) {
                return c.a(500, "unknown error: " + th2.getMessage(), (Object) null);
            }
        }
    }

    public interface f {
        void a();

        void a(BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void a(String str);

        void a(String str, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b();

        void b(String str, JSONObject jSONObject);

        void b(JSONObject jSONObject);

        void c();

        void c(String str, JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d();

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);
    }

    public interface g {
        void a(com.sigmob.sdk.mraid2.g gVar, int i10, int i11);
    }

    public c(List<BaseAdUnit> list) {
        LinkedList linkedList = new LinkedList();
        this.f19704e = linkedList;
        this.f19706g = false;
        this.f19700a = list;
        linkedList.addAll(list);
    }

    public boolean h() {
        return this.f19705f;
    }

    public void i() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("orientation", ClientMetadata.getInstance().getOrientationInt());
            jSONObject2.put(PointCategory.LOCKED, true);
            jSONObject.put("orientation", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void j() {
        b("mraidbridge.fireReadyEvent();");
    }

    public void k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b7.b.f1305b0, com.sigmob.sdk.base.k.f18179k);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ")");
    }

    public void c() {
        if (f19698i != null) {
            f19698i = null;
        }
        if (this.f19702c != null) {
            this.f19702c = null;
        }
        a((f) null);
        a((d.InterfaceC0605d) null);
    }

    public final LoadAdRequest d() {
        List<BaseAdUnit> list = this.f19700a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f19700a.get(0).getAdRequest();
    }

    public List<BaseAdUnit> e() {
        return this.f19704e;
    }

    public com.sigmob.sdk.mraid2.g f() {
        return this.f19702c;
    }

    public final void g() {
        this.f19705f = true;
        this.f19702c.post(new b());
    }

    public void b(String str) {
        StringBuilder sb2;
        String str2;
        if (!this.f19705f) {
            sb2 = new StringBuilder();
            str2 = "MRAID JS Not Load attached:\n\t";
        } else {
            if (this.f19702c != null) {
                SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
                this.f19702c.a(str, (ValueCallback) null);
                return;
            }
            sb2 = new StringBuilder();
            str2 = "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t";
        }
        sb2.append(str2);
        sb2.append(str);
        SigmobLog.e(sb2.toString());
    }

    public void c(String str) {
        b("mraidbridge.nativeCallComplete(" + JSONObject.quote(str) + ")");
    }

    public void d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void e(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void f(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, "fire_" + str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject.put("wvFinished", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void b(JSONObject jSONObject) {
        b("mraidbridge.onStorageChanged(" + jSONObject.toString() + ");");
    }

    public void c(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("state", i10);
            jSONObject.put("vdPlayStateChanged", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public final void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("uniqId");
            String optString2 = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            List<String> list = f19699j.get(optString2);
            if (list == null) {
                list = new ArrayList<>();
                f19699j.put(optString + "~" + optString2, list);
            }
            list.add(this.f19702c.getUniqueId());
        }
    }

    public final void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("uniqId");
            String optString2 = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            List<String> list = f19699j.get(optString + "~" + optString2);
            if (list != null) {
                Iterator it = new CopyOnWriteArrayList(list).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str.equals(optString)) {
                        list.remove(str);
                    }
                }
            }
        }
    }

    public void b(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("currentTime", i10 / 1000.0f);
            jSONObject.put("vdPlayToEnd", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public final void c(JSONObject jSONObject) {
        HashMap<String, com.sigmob.sdk.mraid2.g> mraidWebViews;
        c mraidBridge;
        if (jSONObject != null) {
            String uniqueId = f().getUniqueId();
            String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            if (TextUtils.isEmpty(uniqueId) || TextUtils.isEmpty(optString)) {
                return;
            }
            List<String> list = f19699j.get(uniqueId + "~" + optString);
            if (list == null || list.size() <= 0 || (mraidWebViews = com.sigmob.sdk.mraid2.g.getMraidWebViews()) == null) {
                return;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                com.sigmob.sdk.mraid2.g gVar = mraidWebViews.get(it.next());
                if (gVar != null && (mraidBridge = gVar.getMraidBridge()) != null) {
                    mraidBridge.a(uniqueId, optString, jSONObject);
                }
            }
        }
    }

    public void b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("error", str2);
            jSONObject.put("vdPlayError", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(com.sigmob.sdk.mraid2.g gVar) {
        this.f19702c = gVar;
        gVar.setScrollContainer(false);
        this.f19702c.setVerticalScrollBarEnabled(false);
        this.f19702c.setHorizontalScrollBarEnabled(false);
        this.f19702c.setBackgroundColor(0);
        this.f19702c.setWebChromeClient(new a());
    }

    public final BidResponse a(List<BaseAdUnit> list) {
        Template build;
        List<MaterialMeta> list2;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Ad ad2 = list.get(i10).getAd();
            ArrayList arrayList2 = new ArrayList();
            if (ad2 != null && (list2 = ad2.materials) != null && list2.size() > 0) {
                MaterialMeta.Builder newBuilder = ad2.materials.get(0).newBuilder();
                Template template = newBuilder.main_template;
                if (template != null && template.type.intValue() == 2) {
                    Template build2 = newBuilder.main_template.newBuilder().context(null).build();
                    build2.templateId = newBuilder.main_template.templateId;
                    newBuilder.main_template(build2);
                }
                Template template2 = newBuilder.sub_template;
                if (template2 != null && template2.type.intValue() == 2) {
                    Template build3 = newBuilder.sub_template.newBuilder().context(null).build();
                    build3.templateId = newBuilder.sub_template.templateId;
                    newBuilder.sub_template(build3);
                }
                arrayList2.add(newBuilder.html_snippet(null).build());
                arrayList.add(ad2.newBuilder().materials(arrayList2).build());
            }
        }
        BidResponse.Builder builder = new BidResponse.Builder();
        if (list.get(0) != null) {
            if (list.get(0).scene != null) {
                if (list.get(0).scene.type.intValue() == 2) {
                    build = list.get(0).scene.newBuilder().context(null).build();
                    build.templateId = list.get(0).scene.templateId;
                } else {
                    build = list.get(0).scene.newBuilder().build();
                }
                builder.scene(build);
            }
            if (list.get(0).slotAdSetting != null) {
                builder.slot_ad_setting(list.get(0).slotAdSetting.newBuilder().build());
            }
            if (list.get(0).bidding_response != null) {
                builder.bidding_response(list.get(0).bidding_response.newBuilder().build());
            }
            builder.request_id(list.get(0).getRequestId());
            builder.uid(list.get(0).uid);
            builder.expiration_time(Integer.valueOf(list.get(0).expiration_time));
        }
        return builder.ads(arrayList).build();
    }

    public BaseAdUnit a(String str) {
        List<BaseAdUnit> list;
        if (!TextUtils.isEmpty(str) && (list = this.f19704e) != null && list.size() > 0) {
            for (int i10 = 0; i10 < this.f19704e.size(); i10++) {
                BaseAdUnit baseAdUnit = this.f19700a.get(i10);
                if (str.equals(baseAdUnit.getAd().vid)) {
                    return baseAdUnit;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d3 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:3:0x0008, B:6:0x003e, B:11:0x01a2, B:12:0x0490, B:15:0x01a7, B:16:0x01ac, B:17:0x01b1, B:26:0x01db, B:28:0x01df, B:29:0x01e4, B:31:0x01e8, B:32:0x01c0, B:35:0x01ca, B:38:0x01ed, B:40:0x01f1, B:43:0x0210, B:45:0x0214, B:46:0x0219, B:48:0x021d, B:49:0x0222, B:51:0x022a, B:54:0x0237, B:56:0x023f, B:59:0x024a, B:61:0x0252, B:64:0x025d, B:66:0x0261, B:69:0x0266, B:71:0x026a, B:72:0x026f, B:74:0x0273, B:75:0x0278, B:77:0x027c, B:78:0x0281, B:80:0x0285, B:83:0x028a, B:85:0x028e, B:86:0x0293, B:88:0x0297, B:89:0x029c, B:91:0x02a0, B:92:0x02a5, B:94:0x02ad, B:97:0x02b2, B:99:0x02b6, B:102:0x02bb, B:104:0x02bf, B:107:0x02c4, B:109:0x02c8, B:112:0x02cd, B:114:0x02d3, B:115:0x02da, B:117:0x02e0, B:118:0x02e4, B:120:0x02ea, B:122:0x02ef, B:124:0x02f9, B:126:0x02ff, B:127:0x0304, B:129:0x0326, B:131:0x032e, B:133:0x0351, B:134:0x0358, B:136:0x0360, B:138:0x039c, B:139:0x03a3, B:141:0x03d3, B:145:0x0371, B:146:0x038f, B:152:0x03a0, B:153:0x03d8, B:155:0x03e2, B:157:0x03e8, B:158:0x03ed, B:159:0x03f4, B:161:0x03fa, B:164:0x03ff, B:166:0x040e, B:167:0x0412, B:169:0x0418, B:171:0x0426, B:173:0x042e, B:176:0x045c, B:179:0x046e, B:184:0x047e, B:186:0x0484, B:187:0x048a, B:188:0x0494, B:190:0x0498, B:193:0x049c, B:196:0x004d, B:199:0x0058, B:202:0x0064, B:205:0x0070, B:208:0x007c, B:211:0x0088, B:214:0x0093, B:217:0x009f, B:220:0x00ab, B:223:0x00b4, B:226:0x00c0, B:229:0x00cc, B:232:0x00d8, B:235:0x00e3, B:238:0x00ef, B:241:0x00fb, B:244:0x0106, B:247:0x0112, B:250:0x011e, B:253:0x012a, B:256:0x0135, B:259:0x0140, B:262:0x014b, B:265:0x0156, B:268:0x0161, B:271:0x016b, B:274:0x0176, B:277:0x0181, B:280:0x018c), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01e4 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:3:0x0008, B:6:0x003e, B:11:0x01a2, B:12:0x0490, B:15:0x01a7, B:16:0x01ac, B:17:0x01b1, B:26:0x01db, B:28:0x01df, B:29:0x01e4, B:31:0x01e8, B:32:0x01c0, B:35:0x01ca, B:38:0x01ed, B:40:0x01f1, B:43:0x0210, B:45:0x0214, B:46:0x0219, B:48:0x021d, B:49:0x0222, B:51:0x022a, B:54:0x0237, B:56:0x023f, B:59:0x024a, B:61:0x0252, B:64:0x025d, B:66:0x0261, B:69:0x0266, B:71:0x026a, B:72:0x026f, B:74:0x0273, B:75:0x0278, B:77:0x027c, B:78:0x0281, B:80:0x0285, B:83:0x028a, B:85:0x028e, B:86:0x0293, B:88:0x0297, B:89:0x029c, B:91:0x02a0, B:92:0x02a5, B:94:0x02ad, B:97:0x02b2, B:99:0x02b6, B:102:0x02bb, B:104:0x02bf, B:107:0x02c4, B:109:0x02c8, B:112:0x02cd, B:114:0x02d3, B:115:0x02da, B:117:0x02e0, B:118:0x02e4, B:120:0x02ea, B:122:0x02ef, B:124:0x02f9, B:126:0x02ff, B:127:0x0304, B:129:0x0326, B:131:0x032e, B:133:0x0351, B:134:0x0358, B:136:0x0360, B:138:0x039c, B:139:0x03a3, B:141:0x03d3, B:145:0x0371, B:146:0x038f, B:152:0x03a0, B:153:0x03d8, B:155:0x03e2, B:157:0x03e8, B:158:0x03ed, B:159:0x03f4, B:161:0x03fa, B:164:0x03ff, B:166:0x040e, B:167:0x0412, B:169:0x0418, B:171:0x0426, B:173:0x042e, B:176:0x045c, B:179:0x046e, B:184:0x047e, B:186:0x0484, B:187:0x048a, B:188:0x0494, B:190:0x0498, B:193:0x049c, B:196:0x004d, B:199:0x0058, B:202:0x0064, B:205:0x0070, B:208:0x007c, B:211:0x0088, B:214:0x0093, B:217:0x009f, B:220:0x00ab, B:223:0x00b4, B:226:0x00c0, B:229:0x00cc, B:232:0x00d8, B:235:0x00e3, B:238:0x00ef, B:241:0x00fb, B:244:0x0106, B:247:0x0112, B:250:0x011e, B:253:0x012a, B:256:0x0135, B:259:0x0140, B:262:0x014b, B:265:0x0156, B:268:0x0161, B:271:0x016b, B:274:0x0176, B:277:0x0181, B:280:0x018c), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.sigmob.sdk.mraid2.c r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.c.a(com.sigmob.sdk.mraid2.c, java.lang.String):void");
    }

    public void a(String str, ValueCallback valueCallback) {
        if (this.f19702c == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        this.f19702c.a(str, valueCallback);
    }

    public void a(String str, BidResponse bidResponse, int i10, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (bidResponse == null) {
                jSONObject = new JSONObject();
                jSONObject.put(h3.e.f26408m, (Object) null);
            } else {
                jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse, h3.e.f26408m, true, true));
            }
            jSONObject.put("code", i10);
            jSONObject.put(b7.d.f1362o, str2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject3.put(b7.d.f1362o, jSONObject);
            jSONObject2.put("notify", jSONObject3);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    public void a(BidResponse bidResponse) {
        b("mraidbridge.fireChangeEvent(" + JSONSerializer.Serialize(bidResponse, "bidResponse", true, true) + ");");
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("bindData", jSONObject);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    public void a(String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Object opt = jSONObject.opt(h3.e.f26408m);
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NotificationCompat.CATEGORY_EVENT, str + "~" + str2);
            if (opt != null) {
                jSONObject3.put(h3.e.f26408m, opt);
            }
            jSONObject2.put("onChangeEvent", jSONObject3);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(int i10) {
        b("mraidbridge.fireChangeEvent({\"exposure\":" + i10 + "});");
    }

    @Override // com.sigmob.sdk.mraid2.i
    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str3);
            jSONObject2.put("uniqueId", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put(b7.d.f1362o, str2);
            }
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i10);
            jSONObject.put("index", i11);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.notifyPageChangeEvent(" + jSONObject + ");");
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        Context context;
        int i10;
        float f10;
        DisplayMetrics displayMetrics = this.f19702c.getContext().getResources().getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (gVar != null) {
                i10 = Dips.pixelsToIntDips(gVar.b(), this.f19702c.getContext());
                f10 = gVar.a();
                context = this.f19702c.getContext();
            } else {
                int pixelsToIntDips = Dips.pixelsToIntDips(displayMetrics.widthPixels, this.f19702c.getContext());
                float f11 = displayMetrics.heightPixels;
                context = this.f19702c.getContext();
                i10 = pixelsToIntDips;
                f10 = f11;
            }
            int pixelsToIntDips2 = Dips.pixelsToIntDips(f10, context);
            jSONObject2.put("width", i10);
            jSONObject2.put("height", pixelsToIntDips2);
            jSONObject.put("screenSize", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public final void a(String str, Map map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("state", i10);
            jSONObject.put("vdLoadStateChanged", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("currentTime", i10 / 1000.0f);
            jSONObject2.put("duration", i11 / 1000.0f);
            jSONObject.put("vdPlayCurrentTime", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, int i10, int i11, int i12) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("duration", i10 / 1000.0f);
            jSONObject2.put("width", i11);
            jSONObject2.put("height", i12);
            jSONObject.put("vdReadyToPlay", jSONObject2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", z10);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ")");
    }

    public void a(String str, int i10, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", i10);
            jSONObject2.put(b7.d.f1362o, str2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("uniqueId", str);
            jSONObject3.put("error", jSONObject2);
            jSONObject.put("wvError", jSONObject3);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public static String a(int i10, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(b7.d.f1362o, str);
            }
            if (obj != null) {
                jSONObject.put(h3.e.f26408m, obj);
            }
            return jSONObject.toString();
        } catch (Throwable th2) {
            return th2.getMessage();
        }
    }

    public void a(f fVar) {
        this.f19701b = fVar;
    }

    public void a(d.InterfaceC0605d interfaceC0605d) {
        this.f19703d = interfaceC0605d;
    }
}
