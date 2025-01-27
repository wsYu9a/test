package com.sigmob.sdk.mraid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.MimeTypes;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.martian.libmars.activity.PermissionActivity;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.e0;
import com.sigmob.sdk.base.common.n0;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.i;
import com.sigmob.sdk.mraid.p;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: k */
    public static final String f19482k = "mraid://open?url=";

    /* renamed from: a */
    public final BaseAdUnit f19483a;

    /* renamed from: b */
    public final PlacementType f19484b;

    /* renamed from: c */
    public final com.sigmob.sdk.mraid.i f19485c;

    /* renamed from: d */
    public String f19486d;

    /* renamed from: e */
    public h f19487e;

    /* renamed from: f */
    public p f19488f;

    /* renamed from: g */
    public n0 f19489g;

    /* renamed from: h */
    public boolean f19490h;

    /* renamed from: i */
    public final q f19491i;

    /* renamed from: j */
    public i f19492j;

    public class a extends q {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            b.this.c();
        }

        @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            b0.a("h5_error", "mraid1", i10, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, b.this.f19483a, (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            b0.a("h5_error", "mraid1", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, b.this.f19483a, (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            b.this.a(renderProcessGoneDetail);
            return true;
        }

        @Override // com.sigmob.sdk.mraid.q, com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (!TextUtils.isEmpty(b.this.f19483a.getVideoPath()) && str.endsWith(b.this.f19483a.getVideoPath()) && b.this.f19483a.isVideoExist()) {
                try {
                    return new WebResourceResponse(MimeTypes.VIDEO_MP4, "UTF-8", new FileInputStream(b.this.f19483a.getVideoPath()));
                } catch (FileNotFoundException e10) {
                    SigmobLog.e(e10.getMessage());
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return b.this.a(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            CharSequence description;
            SigmobLog.i("onReceivedError:" + webResourceError.toString());
            if (Build.VERSION.SDK_INT >= 23) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(webResourceRequest.getUrl());
                sb2.append(" error:");
                description = webResourceError.getDescription();
                sb2.append((Object) description);
                b0.a("h5_error", "mraid1", 0, sb2.toString(), (WindAdRequest) null, (LoadAdRequest) null, b.this.f19483a, (b0.g) null);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.b$b */
    public class C0593b extends WebChromeClient {
        public C0593b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return b.this.f19487e != null ? b.this.f19487e.a(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return b.this.f19487e != null ? b.this.f19487e.a(str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public class c implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f19495a;

        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b.this.f19489g.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if ((action == 0 || action == 1) && !view.hasFocus()) {
                view.requestFocus();
            }
            if (motionEvent.getAction() == 1) {
                b.this.f19486d = String.format("%d,%d,%d,%d", Integer.valueOf((int) this.f19495a.getRawX()), Integer.valueOf((int) this.f19495a.getRawY()), Integer.valueOf((int) motionEvent.getRawX()), Integer.valueOf((int) motionEvent.getRawY()));
                if (this.f19495a == null) {
                    this.f19495a = motionEvent;
                }
                b.this.f19483a.getMacroCommon().updateClickMarco(this.f19495a, motionEvent, true);
            } else if (motionEvent.getAction() == 0) {
                this.f19495a = MotionEvent.obtain(motionEvent);
            }
            return false;
        }
    }

    public class d implements p.a {
        public d() {
        }

        @Override // com.sigmob.sdk.mraid.p.a
        public void a(boolean z10) {
            if (b.this.f19487e != null) {
                b.this.f19487e.a(z10);
            }
        }
    }

    public class e implements i.a {

        /* renamed from: a */
        public final /* synthetic */ com.sigmob.sdk.mraid.g f19498a;

        public e(com.sigmob.sdk.mraid.g gVar) {
            this.f19498a = gVar;
        }

        @Override // com.sigmob.sdk.mraid.i.a
        public void a(com.sigmob.sdk.mraid.c cVar) {
            b.this.a(this.f19498a, cVar.getMessage());
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a */
        public static final /* synthetic */ int[] f19500a;

        static {
            int[] iArr = new int[com.sigmob.sdk.mraid.g.values().length];
            f19500a = iArr;
            try {
                iArr[com.sigmob.sdk.mraid.g.f19557b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19562g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19563h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19564i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19558c.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19559d.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19560e.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19561f.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19565j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19566k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19567l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19568m.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19569n.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19570o.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f19500a[com.sigmob.sdk.mraid.g.f19571p.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static class g {

        /* renamed from: a */
        public final WeakReference<b> f19501a;

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ JSONObject f19502a;

            public a(JSONObject jSONObject) {
                this.f19502a = jSONObject;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = this.f19502a.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equalsIgnoreCase("ext")) {
                        try {
                            try {
                                JSONObject jSONObject = new JSONObject(this.f19502a.optString(next));
                                Iterator<String> keys2 = jSONObject.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    hashMap.put(next2, jSONObject.optString(next2));
                                }
                            } catch (Exception unused) {
                                hashMap.put("ext", Base64.encodeToString(this.f19502a.getString("ext").getBytes(), 2));
                            }
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                    } else if (!next.equalsIgnoreCase("_ac_type")) {
                        try {
                            hashMap.put(next, this.f19502a.getString(next));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                hashMap.put("source", "js");
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.mraid.b$g$b */
        public class RunnableC0594b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f19504a;

            /* renamed from: b */
            public final /* synthetic */ b f19505b;

            public RunnableC0594b(String str, b bVar) {
                this.f19504a = str;
                this.f19505b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(this.f19504a);
                    this.f19505b.a(jSONObject.optString(NotificationCompat.CATEGORY_EVENT), jSONObject.optString("subEvent"), jSONObject.optJSONObject("args"));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                this.f19505b.d(this.f19504a);
            }
        }

        public g(b bVar) {
            this.f19501a = new WeakReference<>(bVar);
        }

        public BaseAdUnit a() {
            b b10 = b();
            if (b10 != null) {
                return b10.f19483a;
            }
            return null;
        }

        @JavascriptInterface
        public String addMacro(JSONObject jSONObject) {
            try {
                BaseAdUnit a10 = a();
                String string = jSONObject.has(PermissionActivity.f12046p) ? jSONObject.getString(PermissionActivity.f12046p) : null;
                String string2 = jSONObject.has("value") ? jSONObject.getString("value") : null;
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    a10.getMacroCommon().addMarcoKey(string, string2);
                    return b.a(200, "addMacro success", (Object) null);
                }
                return b.a(300, "key or value is empty", (Object) null);
            } catch (Throwable th2) {
                return b.a(500, "addMacro add fail " + th2.getMessage(), (Object) null);
            }
        }

        public b b() {
            return this.f19501a.get();
        }

        @JavascriptInterface
        public String excuteRewardAdTrack(JSONObject jSONObject) {
            try {
                BaseAdUnit a10 = a();
                String string = jSONObject.getString(NotificationCompat.CATEGORY_EVENT);
                int a11 = com.sigmob.sdk.base.network.f.a(a10, string, true);
                if (a11 == 0) {
                    return b.a(200, "excuteRewardAdTrack success", (Object) null);
                }
                if (a11 == -1) {
                    return b.a(300, "event is empty", (Object) null);
                }
                if (a11 == -2) {
                    return b.a(300, string + " can't find in trackers", (Object) null);
                }
                return b.a(400, "unknown error: " + a11, (Object) null);
            } catch (Throwable th2) {
                return b.a(500, "unknown error: " + th2.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (TextUtils.isEmpty(string)) {
                    return b.a(400, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th2) {
                return b.a(500, th2.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String getAppInfo(JSONObject jSONObject) {
            char c10;
            Object deviceId;
            int densityDpi;
            try {
                JSONObject jSONObject2 = new JSONObject();
                BaseAdUnit a10 = a();
                if (jSONObject != null && a10 != null && jSONObject.has("arguments")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("arguments");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        String string = jSONArray.getString(i10);
                        try {
                            switch (string.hashCode()) {
                                case -1776992973:
                                    if (string.equals("ad_source_logo")) {
                                        c10 = 20;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1590994477:
                                    if (string.equals("display_orientation")) {
                                        c10 = b5.a.O;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1581153970:
                                    if (string.equals("settlement_price_enc")) {
                                        c10 = g6.b.f26171o;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1534836170:
                                    if (string.equals("google_aid")) {
                                        c10 = 3;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1342627961:
                                    if (string.equals("bid_price")) {
                                        c10 = 27;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1295727824:
                                    if (string.equals("device_height")) {
                                        c10 = '\n';
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1152230954:
                                    if (string.equals("ad_type")) {
                                        c10 = 16;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -1093016302:
                                    if (string.equals("client_pixel")) {
                                        c10 = '\b';
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -918718184:
                                    if (string.equals("forbiden_parse_landingpage")) {
                                        c10 = r5.c.f30310b;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -901870406:
                                    if (string.equals("app_version")) {
                                        c10 = 5;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -702722614:
                                    if (string.equals("creative_type")) {
                                        c10 = 15;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -582019427:
                                    if (string.equals("device_width")) {
                                        c10 = '\t';
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -568274923:
                                    if (string.equals("screen_density")) {
                                        c10 = 11;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -516987305:
                                    if (string.equals("pkgname")) {
                                        c10 = '\r';
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -376724013:
                                    if (string.equals("sdk_version")) {
                                        c10 = 6;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -205033663:
                                    if (string.equals("is_override")) {
                                        c10 = g6.b.f26172p;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -41411609:
                                    if (string.equals("screenangle")) {
                                        c10 = 14;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case -19457365:
                                    if (string.equals(bt.T)) {
                                        c10 = '\f';
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 3556:
                                    if (string.equals(bt.f23628x)) {
                                        c10 = 0;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 116753:
                                    if (string.equals("vid")) {
                                        c10 = 23;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 3062218:
                                    if (string.equals("crid")) {
                                        c10 = 24;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 3236040:
                                    if (string.equals("imei")) {
                                        c10 = 1;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 37109963:
                                    if (string.equals(AdKeys.REQUEST_ID)) {
                                        c10 = 17;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 93029116:
                                    if (string.equals("appid")) {
                                        c10 = 19;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 549673881:
                                    if (string.equals("camp_id")) {
                                        c10 = 25;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 672836989:
                                    if (string.equals(bt.f23629y)) {
                                        c10 = 7;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 722989291:
                                    if (string.equals("android_id")) {
                                        c10 = 2;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1103406469:
                                    if (string.equals("clienttype")) {
                                        c10 = 4;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1127917191:
                                    if (string.equals("cust_id")) {
                                        c10 = JSONLexer.EOI;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1139668345:
                                    if (string.equals("adslot_id")) {
                                        c10 = 22;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1224358069:
                                    if (string.equals("placement_id")) {
                                        c10 = 18;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1437471655:
                                    if (string.equals("expired_time")) {
                                        c10 = '!';
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1753008747:
                                    if (string.equals("product_id")) {
                                        c10 = g6.b.f26170n;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 1765767291:
                                    if (string.equals("ad_source_channel")) {
                                        c10 = 21;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                default:
                                    c10 = 65535;
                                    break;
                            }
                            switch (c10) {
                                case 0:
                                    jSONObject2.put(string, 2);
                                    break;
                                case 1:
                                    deviceId = ClientMetadata.getInstance().getDeviceId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 2:
                                    deviceId = ClientMetadata.getInstance().getAndroidId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 3:
                                    deviceId = ClientMetadata.getInstance().getAdvertisingId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 4:
                                    deviceId = ClientMetadata.getDeviceModel();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 5:
                                    deviceId = ClientMetadata.getInstance().getAppVersion();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 6:
                                    deviceId = com.sigmob.sdk.base.k.f18179k;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 7:
                                    deviceId = ClientMetadata.getDeviceOsVersion();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case '\b':
                                    deviceId = String.format("%sx%s", Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().widthPixels), Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().heightPixels));
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case '\t':
                                    deviceId = ClientMetadata.getInstance().getDeviceScreenWidthDip();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case '\n':
                                    deviceId = ClientMetadata.getInstance().getDeviceScreenHeightDip();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 11:
                                    densityDpi = ClientMetadata.getInstance().getDensityDpi();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case '\f':
                                    densityDpi = ClientMetadata.getInstance().getActiveNetworkType();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case '\r':
                                    deviceId = ClientMetadata.getInstance().getAppPackageName();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 14:
                                    densityDpi = Math.abs(ClientMetadata.getInstance().getOrientationInt().intValue() - 1) * 90;
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case 15:
                                    densityDpi = a10.getCreativeType();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case 16:
                                    densityDpi = a10.getAd_type();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case 17:
                                    deviceId = a10.getRequestId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 18:
                                case 22:
                                    deviceId = a10.getAdslot_id();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 19:
                                    deviceId = WindAds.sharedAds().getAppId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 20:
                                    deviceId = a10.getAd_source_logo();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 21:
                                    deviceId = a10.getAd_source_channel();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 23:
                                    deviceId = a10.getAd().vid;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 24:
                                    deviceId = a10.getCrid();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 25:
                                    deviceId = a10.getCamp_id();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 26:
                                    deviceId = a10.getAd().cust_id;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 27:
                                    deviceId = a10.getAd().bid_price;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 28:
                                    deviceId = a10.getAd().product_id;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 29:
                                    deviceId = a10.getAd().settlement_price_enc;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 30:
                                    deviceId = a10.getAd().is_override;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 31:
                                    deviceId = a10.getAd().forbiden_parse_landingpage;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case ' ':
                                    densityDpi = a10.getDisplay_orientation();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case '!':
                                    deviceId = a10.getAd().expired_time;
                                    jSONObject2.put(string, deviceId);
                                    break;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                return b.a(200, "getAppInfo success ", jSONObject2);
            } catch (Throwable th2) {
                return b.a(500, "getAppInfo error: " + th2.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String hello(JSONObject jSONObject) {
            try {
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        @JavascriptInterface
        public String javascriptAddDcLog(JSONObject jSONObject) {
            try {
                if (jSONObject == null) {
                    return b.a(400, "not params", (Object) null);
                }
                if (!jSONObject.has("_ac_type")) {
                    return b.a(300, "_ac_type is empty", (Object) null);
                }
                b0.a(jSONObject.getString("_ac_type"), a(), (LoadAdRequest) null, new a(jSONObject));
                return b.a(200, "add dc log success", (Object) null);
            } catch (Throwable th2) {
                return b.a(500, th2.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String mraidJsLoaded() {
            b b10 = b();
            if (b10 == null || b10.f19487e == null) {
                return null;
            }
            b10.f19487e.h();
            return null;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            b b10 = b();
            SigmobLog.d("postMessage: raw " + str);
            if (b10 != null) {
                b10.f19488f.post(new RunnableC0594b(str, b10));
            }
        }

        @JavascriptInterface
        public String tracking(JSONObject jSONObject) {
            try {
                BaseAdUnit a10 = a();
                String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return b.a(300, "urls is empty", (Object) null);
                }
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    e0 e0Var = new e0(optJSONArray.optString(i10), optString, a10.getRequestId());
                    e0Var.setRetryNum(Integer.valueOf(a10.getTrackingRetryNum()));
                    e0Var.setSource("js");
                    com.sigmob.sdk.base.network.f.a((AdTracker) e0Var, a10, false);
                }
                return b.a(200, "tracking success", (Object) null);
            } catch (Throwable th2) {
                return b.a(500, "unknown error: " + th2.getMessage(), (Object) null);
            }
        }
    }

    public interface h {
        void a();

        void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10);

        void a(WindAdError windAdError);

        void a(String str, Map<String, String> map);

        void a(URI uri);

        void a(URI uri, int i10, String str);

        void a(URI uri, boolean z10) throws com.sigmob.sdk.mraid.c;

        void a(boolean z10);

        void a(boolean z10, k kVar) throws com.sigmob.sdk.mraid.c;

        boolean a(ConsoleMessage consoleMessage);

        boolean a(String str, JsResult jsResult);

        void b(String str, Map<String, String> map);

        void b(boolean z10);

        void c();

        void d();

        void f();

        void g();

        void h();

        void i();
    }

    public interface i {
        void a(String str, JSONObject jSONObject);

        void b(String str, JSONObject jSONObject);

        void c(String str, JSONObject jSONObject);

        void d(String str, JSONObject jSONObject);

        void e(String str, JSONObject jSONObject);
    }

    public interface j {
        void a(String str, Map<String, String> map);
    }

    public b(BaseAdUnit baseAdUnit, PlacementType placementType) {
        this(baseAdUnit, placementType, new com.sigmob.sdk.mraid.i());
    }

    public boolean f() {
        return this.f19490h;
    }

    public boolean g() {
        p pVar = this.f19488f;
        return pVar != null && pVar.j();
    }

    public void h() {
        c("bridge.notifyApkDownloadEndEvent();");
    }

    public void i() {
        c("bridge.notifyApkDownloadFailEvent();");
    }

    public void j() {
        c("bridge.notifyApkDownloadInstalledEvent();");
    }

    public void k() {
        c("bridge.notifyApkDownloadStartEvent();");
    }

    public void l() {
        c("mraidbridge.fireChangeEvent({\"hostSDKVersion\":4.19.1});");
    }

    public void m() {
        c("bridge.fireChangeEvent({\"osType\":2});");
    }

    public void n() {
        c("mraidbridge.notifyReadyEvent();");
    }

    public void o() {
        c("mraidbridge.startAd();");
    }

    public b(BaseAdUnit baseAdUnit, PlacementType placementType, com.sigmob.sdk.mraid.i iVar) {
        this.f19491i = new a();
        this.f19483a = baseAdUnit;
        this.f19484b = placementType;
        this.f19485c = iVar;
    }

    public void b(String str) {
        c("mraidbridge.fireVideoSrc(\"" + str + "\")");
    }

    public final void c() {
        if (this.f19490h) {
            return;
        }
        this.f19490h = true;
        h hVar = this.f19487e;
        if (hVar != null) {
            hVar.g();
        }
    }

    public boolean d() {
        return this.f19488f != null;
    }

    public boolean e() {
        n0 n0Var = this.f19489g;
        return n0Var != null && n0Var.a();
    }

    public final k f(String str) throws com.sigmob.sdk.mraid.c {
        if ("portrait".equals(str)) {
            return k.PORTRAIT;
        }
        if ("landscape".equals(str)) {
            return k.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return k.NONE;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid orientation: " + str);
    }

    public final int g(String str) throws com.sigmob.sdk.mraid.c {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new com.sigmob.sdk.mraid.c("Invalid numeric parameter: " + str);
        }
    }

    public final URI h(String str) throws com.sigmob.sdk.mraid.c {
        if (str == null) {
            throw new com.sigmob.sdk.mraid.c("Parameter cannot be null");
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            throw new com.sigmob.sdk.mraid.c("Invalid URL parameter: " + str);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void i(String str) {
        p pVar = this.f19488f;
        if (pVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        pVar.addJavascriptInterface(new g(this), "sigandroid");
        this.f19490h = false;
        this.f19488f.loadUrl(str);
    }

    public String b() {
        return this.f19486d;
    }

    public void c(String str) {
        if (this.f19488f == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.f8837s));
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        this.f19488f.evaluateJavascript(str, null);
    }

    public void d(String str) {
        c("mraidbridge.nativeCallCompleteV2(" + JSONObject.quote(str) + ")");
    }

    public final boolean e(String str) throws com.sigmob.sdk.mraid.c {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid boolean parameter: " + str);
    }

    public void b(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("currentTime", i10 / 1000.0f);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        c("mraidbridge.setvdPlayToEnd(" + jSONObject + ")");
    }

    public void c(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("state", i10);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        c("mraidbridge.setvdPlayStateChanged(" + jSONObject + ")");
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(p pVar) {
        this.f19488f = pVar;
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(pVar.getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(pVar.getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (this.f19484b == PlacementType.INTERSTITIAL) {
            pVar.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f19491i.a(this.f19483a.isDisablexRequestWith());
        this.f19491i.b(com.sigmob.sdk.base.l.w().g());
        this.f19488f.setScrollContainer(false);
        this.f19488f.setVerticalScrollBarEnabled(false);
        this.f19488f.setHorizontalScrollBarEnabled(false);
        this.f19488f.setBackgroundColor(0);
        this.f19488f.setAdUnit(this.f19483a);
        this.f19488f.a((o.a) null);
        this.f19488f.setWebViewClient(this.f19491i);
        this.f19488f.setWebChromeClient(new C0593b());
        this.f19489g = new n0(this.f19488f.getContext(), this.f19488f, this.f19483a);
        this.f19488f.setOnTouchListener(new c());
        this.f19488f.setVisibilityChangedListener(new d());
    }

    public void b(ValueCallback valueCallback) {
        a("mraidbridge.getPlayProgress();", valueCallback);
    }

    public void c(String str, String str2) {
        this.f19486d = String.format("%s,%s,%s,%s", str, str2, str, str2);
        this.f19483a.getMacroCommon().updateClickMarco(str, str2, str, str2);
        this.f19483a.getClickCommon().down = new TouchLocation(Integer.parseInt(str), Integer.parseInt(str2));
        this.f19483a.getClickCommon().up = new TouchLocation(Integer.parseInt(str), Integer.parseInt(str2));
    }

    public final int a(int i10, int i11, int i12) throws com.sigmob.sdk.mraid.c {
        if (i10 >= i11 && i10 <= i12) {
            return i10;
        }
        throw new com.sigmob.sdk.mraid.c("Integer parameter out of range: " + i10);
    }

    public final URI b(String str, String str2) throws com.sigmob.sdk.mraid.c {
        try {
            try {
                return str == null ? new URI(str2) : new URI(str);
            } catch (URISyntaxException unused) {
                throw new com.sigmob.sdk.mraid.c("Invalid URL parameter: " + str);
            }
        } catch (URISyntaxException unused2) {
            return new URI(str2);
        }
    }

    public static String a(String str) {
        if (str == null || str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined")) {
            return null;
        }
        return str;
    }

    public final String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    public void a() {
        p pVar = this.f19488f;
        if (pVar != null) {
            pVar.destroy();
            this.f19488f = null;
        }
    }

    public final void a(com.sigmob.sdk.mraid.g gVar, String str) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(gVar.b()) + ", " + JSONObject.quote(str) + ")");
    }

    public final void a(com.sigmob.sdk.mraid.g gVar) {
        c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(gVar.b()) + ")");
    }

    public final void a(String str, String str2, JSONObject jSONObject) {
        str.hashCode();
        switch (str) {
            case "motion":
                this.f19492j.b(str2, jSONObject);
                break;
            case "motionView":
                this.f19492j.e(str2, jSONObject);
                break;
            case "addSubview":
                this.f19492j.d(str2, jSONObject);
                break;
            case "vpaid":
                this.f19492j.a(str2, jSONObject);
                break;
            case "belowSubview":
                this.f19492j.c(str2, jSONObject);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    @android.annotation.TargetApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.webkit.RenderProcessGoneDetail r3) {
        /*
            r2 = this;
            if (r3 == 0) goto Lb
            boolean r3 = u7.a.a(r3)
            if (r3 == 0) goto Lb
            com.sigmob.windad.WindAdError r3 = com.sigmob.windad.WindAdError.RENDER_PROCESS_GONE_WITH_CRASH
            goto Ld
        Lb:
            com.sigmob.windad.WindAdError r3 = com.sigmob.windad.WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED
        Ld:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleRenderProcessGone "
            r0.append(r1)
            java.lang.String r1 = r3.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.czhj.sdk.logger.SigmobLog.e(r0)
            r2.a()
            com.sigmob.sdk.mraid.b$h r0 = r2.f19487e
            if (r0 == 0) goto L2f
            r0.a(r3)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.b.a(android.webkit.RenderProcessGoneDetail):void");
    }

    public boolean a(WebView webView, String str) {
        int i10;
        h hVar;
        try {
            new URI(str);
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (StringUtil.decode(StringUtil.f8837s).equals(scheme)) {
                if ("failLoad".equals(host) && this.f19484b == PlacementType.INLINE && (hVar = this.f19487e) != null) {
                    hVar.i();
                }
                return true;
            }
            if (BaseAdActivity.f20396c.equals(scheme)) {
                com.sigmob.sdk.mraid.g a10 = com.sigmob.sdk.mraid.g.a(host);
                try {
                    a(a10, ClientMetadata.getQueryParamMap(parse));
                } catch (Throwable th2) {
                    a(a10, th2.getMessage());
                }
                a(a10);
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("http")) {
                    webView.loadUrl(str);
                } else {
                    try {
                        List<String> list = this.f19483a.getAdSetting() != null ? this.f19483a.getAdSetting().scheme_white_list : null;
                        if (list != null && list.size() > 0) {
                            while (i10 < list.size()) {
                                String str2 = list.get(i10);
                                i10 = (str.startsWith(str2) || str2.equals(m5.h.f28447r)) ? 0 : i10 + 1;
                                u.a(this.f19488f.getContext(), Uri.parse(str));
                                return true;
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            return true;
        } catch (URISyntaxException unused) {
            SigmobLog.e("Invalid MRAID URL: " + str);
            a(com.sigmob.sdk.mraid.g.f19571p, "Mraid command sent an invalid URL");
            return true;
        }
    }

    public void a(String str, ValueCallback valueCallback) {
        if (this.f19488f == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.f8837s));
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        this.f19488f.evaluateJavascript(str, valueCallback);
    }

    public void a(Ad ad2, SlotAdSetting slotAdSetting) {
        String Serialize = JSONSerializer.Serialize(ad2, "ad", true);
        try {
            String Serialize2 = JSONSerializer.Serialize(slotAdSetting, null, true);
            JSONObject jSONObject = new JSONObject(Serialize);
            jSONObject.getJSONObject("ad").put("slotAdSetting", new JSONObject(Serialize2));
            c("bridge.fireChangeEvent(" + jSONObject.toString() + ");");
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void a(int i10) {
        c("bridge.notifyApkDownloadProcessEvent(" + i10 + ");");
    }

    public void a(AppInfo appInfo) {
        c("bridge.fireChangeEvent({" + appInfo.toString().replace("=", ":") + "});");
    }

    public void a(CurrentAppOrientation currentAppOrientation) {
        c("mraidbridge.fireChangeEvent({" + currentAppOrientation.toString().replace("=", ":") + "});");
    }

    public void a(MraidEnv mraidEnv) {
        c("mraidbridge.fireChangeEvent(" + JSONSerializer.Serialize(mraidEnv, bd.f23521a, true) + ");");
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
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(ExposureChange exposureChange) {
        c("mraidbridge.fireChangeEvent({" + exposureChange.toString().replace("=", ":") + "});");
    }

    public void a(Location location) {
        c("mraidbridge.setLocation(" + location.getLatitude() + "," + location.getLongitude() + ",\"" + location.getProvider() + "\");");
    }

    public void a(MaterialMeta materialMeta) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(materialMeta, ClickCommon.CLICK_AREA_MATERIAL, true) + ");");
    }

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
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(PlacementType placementType) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.toJavascriptString()) + ")");
    }

    public void a(RvAdSetting rvAdSetting) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(rvAdSetting, "rvSetting", false) + ");");
    }

    public void a(l lVar) {
        c("mraidbridge.setScreenSize(" + b(lVar.i()) + ");mraidbridge.setMaxSize(" + b(lVar.g()) + ");mraidbridge.setCurrentPosition(" + a(lVar.b()) + ");mraidbridge.setDefaultPosition(" + a(lVar.d()) + ")");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mraidbridge.notifySizeChangeEvent(");
        sb2.append(b(lVar.b()));
        sb2.append(")");
        c(sb2.toString());
    }

    public void a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        c("mraidbridge.setSupports(" + z10 + "," + z11 + "," + z12 + "," + z13 + "," + z14 + "," + z15 + "," + z16 + ")");
    }

    public void a(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("state", i10);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        c("mraidbridge.setvdLoadStateChanged(" + jSONObject + ")");
    }

    public void a(String str, int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("currentTime", i10 / 1000.0f);
            jSONObject.put("duration", i11 / 1000.0f);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        c("mraidbridge.setvdPlayCurrentTime(" + jSONObject + ")");
    }

    public void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("error", str2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        c("mraidbridge.setvdPlayError(" + jSONObject + ")");
    }

    public void a(String str, int i10, int i11, int i12) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("duration", i10 / 1000.0f);
            jSONObject.put("width", i11);
            jSONObject.put("height", i12);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        c("mraidbridge.setvdReadyToPlay(" + jSONObject + ")");
    }

    public void a(VideoItem videoItem) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(videoItem, "video", false) + ");");
    }

    public void a(ViewState viewState) {
        c("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    public void a(boolean z10) {
        c("mraidbridge.setIsViewable(" + z10 + ")");
    }

    public void a(ValueCallback valueCallback) {
        a("mraidbridge.getAdDuration();", valueCallback);
    }

    public final boolean a(String str, boolean z10) throws com.sigmob.sdk.mraid.c {
        return str == null ? z10 : e(str);
    }

    public final a.b a(String str, a.b bVar) throws com.sigmob.sdk.mraid.c {
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        if (str.equals("top-left")) {
            return a.b.TOP_LEFT;
        }
        if (str.equals("top-right")) {
            return a.b.TOP_RIGHT;
        }
        if (str.equals("center")) {
            return a.b.CENTER;
        }
        if (str.equals("bottom-left")) {
            return a.b.BOTTOM_LEFT;
        }
        if (str.equals("bottom-right")) {
            return a.b.BOTTOM_RIGHT;
        }
        if (str.equals("top-center")) {
            return a.b.TOP_CENTER;
        }
        if (str.equals("bottom-center")) {
            return a.b.BOTTOM_CENTER;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid close position: " + str);
    }

    public final URI a(String str, URI uri) throws com.sigmob.sdk.mraid.c {
        return str == null ? uri : h(str);
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

    public void a(com.sigmob.sdk.mraid.g gVar, Map<String, String> map) throws com.sigmob.sdk.mraid.c {
        if (this.f19487e == null) {
            throw new com.sigmob.sdk.mraid.c("Invalid state to execute this command");
        }
        if (this.f19488f == null) {
            throw new com.sigmob.sdk.mraid.c("The current WebView is being destroyed");
        }
        switch (f.f19500a[gVar.ordinal()]) {
            case 1:
                this.f19487e.a();
                return;
            case 2:
                this.f19487e.c();
                return;
            case 3:
                this.f19487e.f();
                return;
            case 4:
                this.f19487e.a(a(g(map.get("width")), 0, 100000), a(g(map.get("height")), 0, 100000), a(g(map.get("offsetX")), -100000, 100000), a(g(map.get("offsetY")), -100000, 100000), a(map.get("customClosePosition"), a.b.TOP_RIGHT), a(map.get("allowOffscreen"), true));
                return;
            case 5:
                this.f19487e.a(a(map.get("url"), (URI) null), a(map.get("shouldUseCustomClose"), false));
                return;
            case 6:
                this.f19487e.b(a(map.get("shouldUseCustomClose"), false));
                return;
            case 7:
                this.f19487e.a(b(map.get("url"), ""), 1, a(map.get("ext")));
                return;
            case 8:
                this.f19487e.d();
                return;
            case 9:
                this.f19487e.a(e(map.get("allowOrientationChange")), f(map.get(AdClickConstants.FORCE_ORIENTATION)));
                return;
            case 10:
                this.f19487e.a(h(map.get("uri")));
                return;
            case 11:
                this.f19485c.a(this.f19488f.getContext(), h(map.get("uri")).toString(), new e(gVar));
                return;
            case 12:
                this.f19485c.a(this.f19488f.getContext(), map);
                return;
            case 13:
                this.f19487e.b(map.get(NotificationCompat.CATEGORY_EVENT), map);
                return;
            case 14:
                this.f19487e.a(map.get(NotificationCompat.CATEGORY_EVENT), map);
                return;
            case 15:
                throw new com.sigmob.sdk.mraid.c("Unspecified MRAID Javascript command");
            default:
                return;
        }
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void a(Context context, String str) {
        p pVar = this.f19488f;
        if (pVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        pVar.addJavascriptInterface(new g(this), "sigandroid");
        this.f19490h = false;
        File a10 = com.sigmob.sdk.base.utils.d.a(str, Md5Util.md5(str) + ".html");
        if (a10 == null || TextUtils.isEmpty(a10.getAbsolutePath())) {
            this.f19488f.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "UTF-8", null);
            return;
        }
        this.f19488f.loadUrl("file://" + a10.getAbsolutePath());
    }

    public void a(h hVar) {
        this.f19487e = hVar;
    }

    public void a(i iVar) {
        this.f19492j = iVar;
    }

    public final String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }
}
