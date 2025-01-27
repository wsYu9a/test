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
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class bi extends Observable {

    /* renamed from: a */
    private static final String f6872a = "b_f";

    /* renamed from: b */
    public static final String f6873b = "XAbstractProdTemplate";

    /* renamed from: c */
    public static final String f6874c = "error_message";

    /* renamed from: d */
    public static final String f6875d = "error_code";

    /* renamed from: e */
    public static final String f6876e = "error_uniqueid";

    /* renamed from: f */
    protected static final String f6877f = "instanceInfo";

    /* renamed from: g */
    protected static final String f6878g = "showState";

    /* renamed from: h */
    protected RelativeLayout f6879h;

    /* renamed from: i */
    protected Context f6880i;

    /* renamed from: j */
    protected String f6881j;

    /* renamed from: o */
    public HashMap<String, String> f6886o;

    /* renamed from: p */
    public String f6887p;

    /* renamed from: q */
    public String f6888q;

    /* renamed from: k */
    protected bt f6882k = bt.a();

    /* renamed from: m */
    public IAdInterListener f6884m = null;

    /* renamed from: n */
    public boolean f6885n = true;

    /* renamed from: r */
    public int f6889r = -1;

    /* renamed from: s */
    protected long f6890s = 0;

    /* renamed from: l */
    public IOAdEventListener f6883l = new a();

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
            bi.a(new bl(this, iOAdEvent));
        }
    }

    public bi(Context context) {
        this.f6880i = context;
        aa.a().a(this.f6880i, new bj(this));
    }

    public abstract void a();

    public void a(IOAdEvent iOAdEvent) {
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e(IOAdEvent iOAdEvent) {
    }

    public void f(IOAdEvent iOAdEvent) {
    }

    public void g(String str) {
    }

    public void h(IOAdEvent iOAdEvent) {
    }

    public void i(IOAdEvent iOAdEvent) {
    }

    public void j(IOAdEvent iOAdEvent) {
    }

    public void k(IOAdEvent iOAdEvent) {
    }

    public String l() {
        JSONObject j10 = j();
        JSONObject k10 = k();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", j10);
        hashMap.put("ad_buss_param", k10);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void m() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.f6677h, new c.a());
            this.f6884m.addEventListener(z.G, this.f6883l);
            this.f6884m.addEventListener(z.I, this.f6883l);
            this.f6884m.addEventListener(z.K, this.f6883l);
            this.f6884m.addEventListener(z.L, this.f6883l);
            this.f6884m.addEventListener(z.V, this.f6883l);
            this.f6884m.addEventListener(z.f7389q, this.f6883l);
            this.f6884m.addEventListener(z.W, this.f6883l);
            this.f6884m.addEventListener(z.f7390r, this.f6883l);
            this.f6884m.addEventListener(z.M, this.f6883l);
            this.f6884m.addEventListener(z.N, this.f6883l);
            this.f6884m.addEventListener(z.J, this.f6883l);
            this.f6884m.addEventListener(z.C, this.f6883l);
            this.f6884m.addEventListener(z.f7364ab, this.f6883l);
            this.f6884m.addEventListener(z.f7365ac, this.f6883l);
            this.f6884m.addEventListener(z.f7366ad, this.f6883l);
            this.f6884m.addEventListener(z.Z, this.f6883l);
            this.f6884m.addEventListener(z.U, this.f6883l);
            this.f6884m.addEventListener(z.f7367ae, this.f6883l);
            this.f6884m.addEventListener(z.f7368af, this.f6883l);
            this.f6884m.addEventListener(z.f7369ag, this.f6883l);
            this.f6884m.addEventListener(z.f7370ah, this.f6883l);
            this.f6884m.addEventListener(z.f7371ai, this.f6883l);
            this.f6884m.addEventListener(z.f7372aj, this.f6883l);
            this.f6884m.addEventListener(z.f7373ak, this.f6883l);
            this.f6884m.addEventListener(z.al, this.f6883l);
            this.f6884m.addEventListener(z.f7363aa, this.f6883l);
            this.f6884m.addEventListener(z.am, this.f6883l);
            this.f6884m.addEventListener(z.X, this.f6883l);
            this.f6884m.addEventListener(z.an, this.f6883l);
            this.f6884m.addEventListener(z.ao, this.f6883l);
        }
    }

    public void n() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public View w() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void a(String str, boolean z10) {
    }

    public void b(IOAdEvent iOAdEvent) {
    }

    public void c(IOAdEvent iOAdEvent) {
    }

    public void d(IOAdEvent iOAdEvent) {
    }

    public void e(String str) {
    }

    public void f(String str) {
    }

    public void g(IOAdEvent iOAdEvent) {
        r();
    }

    public void h() {
        this.f6884m = (IAdInterListener) au.a(z.f7383k, bs.a(this.f6880i), (Class<?>[]) new Class[]{Context.class}, this.f6880i);
        if (this.f6885n) {
            return;
        }
        a();
    }

    public void i() {
        a("SDK未初始化", 1, "");
    }

    public JSONObject j() {
        return new JSONObject();
    }

    public JSONObject k() {
        return new JSONObject();
    }

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void b(String str, boolean z10) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            a("bidding id is empty", 2, "");
        }
        if (this.f6884m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        a("Initialization doesn't finish yet.", 1, "");
    }

    public void d(String str) {
    }

    public String i(String str) {
        IXAdContainerFactory c10;
        aa a10 = aa.a();
        if (a10 != null && (c10 = a10.c()) != null) {
            Object remoteParam = c10.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void b(boolean z10) {
    }

    public void a(Activity activity) {
        if (this.f6884m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.f6884m.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a("bidding data is empty", 2, "");
        }
        if (this.f6884m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        a("Initialization doesn't finish yet.", 1, "");
    }

    public void h(String str) {
        this.f6888q = str;
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void b(int i10) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i10);
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.f6884m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
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

    public void b(JSONObject jSONObject) {
        int i10 = this.f6889r;
        if (i10 >= 0 && jSONObject != null) {
            try {
                jSONObject.put(f6872a, i10);
            } catch (Throwable th2) {
                this.f6882k.a(th2);
            }
        }
        if (jSONObject != null) {
            try {
                jSONObject.put(d.f7138b, this.f6890s);
            } catch (Throwable th3) {
                this.f6882k.a(th3);
            }
        }
    }

    public void a(String str, boolean z10, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        try {
            if (k.a(z10, linkedHashMap, biddingListener)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", str);
                jSONObject.put(p3.i.f29758c, z10);
                try {
                    for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th2) {
                    ay.f(th2.getMessage());
                }
                IAdInterListener iAdInterListener = this.f6884m;
                if (iAdInterListener != null) {
                    iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.f6884m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void a(boolean z10) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z10);
        }
    }

    public boolean a(int i10, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i10, keyEvent);
        }
        return false;
    }

    public void a(int i10, String str, String str2) {
        r();
    }

    public void a(String str, int i10, String str2) {
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
                new Handler(Looper.getMainLooper()).post(new bk(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f6886o = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
