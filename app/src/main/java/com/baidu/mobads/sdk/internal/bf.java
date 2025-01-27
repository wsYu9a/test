package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class bf extends Observable {

    /* renamed from: a */
    private static final String f5581a = "b_f";

    /* renamed from: b */
    public static final String f5582b = "XAbstractProdTemplate";

    /* renamed from: c */
    public static final String f5583c = "error_message";

    /* renamed from: d */
    public static final String f5584d = "error_code";

    /* renamed from: e */
    protected static final String f5585e = "instanceInfo";

    /* renamed from: f */
    protected static final String f5586f = "showState";

    /* renamed from: g */
    protected RelativeLayout f5587g;

    /* renamed from: h */
    protected Context f5588h;
    public HashMap<String, String> m;
    public String n;
    public String o;

    /* renamed from: i */
    protected bq f5589i = bq.a();
    public IAdInterListener k = null;
    public boolean l = true;
    public int p = -1;

    /* renamed from: j */
    public IOAdEventListener f5590j = new a();

    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent == null) {
                return null;
            }
            String message = iOAdEvent.getMessage();
            return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bf.a(new bi(this, iOAdEvent));
        }
    }

    public bf(Context context) {
        this.f5588h = context;
        z.a().a(this.f5588h, new bg(this));
    }

    public abstract void a();

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    protected void a(IOAdEvent iOAdEvent) {
    }

    protected void a(String str, boolean z) {
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    protected void b(IOAdEvent iOAdEvent) {
    }

    protected void b(String str, boolean z) {
    }

    protected void b(boolean z) {
    }

    protected void b_() {
    }

    protected void c(IOAdEvent iOAdEvent) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.k == null) {
            b("Initialization doesn't finish yet.", 1);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bid_id", str);
        a("load_bidding_ad", (Map<String, Object>) hashMap);
    }

    protected void c_() {
    }

    protected void d() {
    }

    protected void d(IOAdEvent iOAdEvent) {
    }

    protected void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    protected void e(IOAdEvent iOAdEvent) {
    }

    protected void e(String str) {
    }

    protected void f(IOAdEvent iOAdEvent) {
    }

    protected void f(String str) {
    }

    protected void g(IOAdEvent iOAdEvent) {
        r();
    }

    public String h(String str) {
        IXAdContainerFactory c2;
        z a2 = z.a();
        if (a2 != null && (c2 = a2.c()) != null) {
            Object remoteParam = c2.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    protected void h(IOAdEvent iOAdEvent) {
    }

    public void i() {
        this.k = (IAdInterListener) ar.a(w.k, bp.a(this.f5588h), (Class<?>[]) new Class[]{Context.class}, this.f5588h);
        if (this.l) {
            return;
        }
        a();
    }

    protected void i(IOAdEvent iOAdEvent) {
    }

    public void j() {
        b("SDK未初始化", 1);
    }

    protected void j(IOAdEvent iOAdEvent) {
    }

    public JSONObject k() {
        return new JSONObject();
    }

    protected void k(IOAdEvent iOAdEvent) {
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject k = k();
        JSONObject l = l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", k);
        hashMap.put("ad_buss_param", l);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.b.f5486e, new b.a());
            this.k.addEventListener(w.H, this.f5590j);
            this.k.addEventListener(w.J, this.f5590j);
            this.k.addEventListener(w.L, this.f5590j);
            this.k.addEventListener(w.M, this.f5590j);
            this.k.addEventListener(w.W, this.f5590j);
            this.k.addEventListener(w.r, this.f5590j);
            this.k.addEventListener(w.X, this.f5590j);
            this.k.addEventListener(w.s, this.f5590j);
            this.k.addEventListener(w.N, this.f5590j);
            this.k.addEventListener(w.O, this.f5590j);
            this.k.addEventListener(w.K, this.f5590j);
            this.k.addEventListener(w.D, this.f5590j);
            this.k.addEventListener(w.ac, this.f5590j);
            this.k.addEventListener(w.f5858ad, this.f5590j);
            this.k.addEventListener(w.aa, this.f5590j);
            this.k.addEventListener(w.V, this.f5590j);
            this.k.addEventListener(w.ae, this.f5590j);
            this.k.addEventListener(w.af, this.f5590j);
            this.k.addEventListener(w.ag, this.f5590j);
            this.k.addEventListener(w.ah, this.f5590j);
            this.k.addEventListener(w.ai, this.f5590j);
            this.k.addEventListener(w.aj, this.f5590j);
            this.k.addEventListener(w.ab, this.f5590j);
            this.k.addEventListener(w.ak, this.f5590j);
            this.k.addEventListener(w.Y, this.f5590j);
            this.k.addEventListener(w.al, this.f5590j);
            this.k.addEventListener(w.am, this.f5590j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    protected void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    protected void s() {
    }

    protected void t() {
    }

    protected void u() {
    }

    public View v() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void g(String str) {
        this.o = str;
    }

    public void a(Activity activity) {
        if (this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void b(int i2) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i2);
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    protected void b(String str, int i2) {
        r();
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map);
        } catch (Exception unused) {
            return null;
        }
    }

    protected void b(JSONObject jSONObject) {
        int i2 = this.p;
        if (i2 < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f5581a, i2);
        } catch (Throwable th) {
            this.f5589i.a(th);
        }
    }

    public void a(String str, boolean z, String str2) {
        a(str, z, str2, null);
    }

    public void a(String str, boolean z, String str2, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z);
            jSONObject.put("replacement", str2);
            if (hashMap != null) {
                try {
                    for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th) {
                    av.f(th.getMessage());
                }
            }
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i2, keyEvent);
        }
        return false;
    }

    protected void a(int i2, String str) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bh(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.m = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
