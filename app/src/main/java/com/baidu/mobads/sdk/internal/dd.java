package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dd extends bf {
    private e.a A;
    private BaiduNativeManager.ExpressAdListener B;
    private BaiduNativeManager.EntryAdListener C;
    private e.b D;
    private int E;

    /* renamed from: a */
    private List<NativeResponse> f5779a;
    private List<ExpressResponse> q;
    private List<EntryResponse> r;
    private int s;
    private boolean t;
    private String u;
    private String v;
    private int w;
    private int x;
    private RequestParameters y;
    private boolean z;

    public dd(Context context, String str, String str2, boolean z, int i2) {
        super(context);
        this.s = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
        this.z = false;
        this.E = 0;
        this.v = str;
        this.u = str2;
        this.t = z;
        this.s = i2;
        this.w = 600;
        this.x = 500;
    }

    public void a(e.a aVar) {
        this.A = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z) {
        this.z = z;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i2 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f5779a != null) {
            while (i2 < this.f5779a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.a(xAdNativeResponse);
                }
                i2++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
            while (i2 < this.q.size()) {
                bn bnVar = (bn) this.q.get(i2);
                if (TextUtils.equals(message, bnVar.a())) {
                    bnVar.c();
                }
                i2++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.r == null) {
            return;
        }
        while (i2 < this.r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i2);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i2++;
        }
    }

    public String f() {
        return this.u;
    }

    public RequestParameters g() {
        return this.y;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i2 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f5779a != null) {
            while (i2 < this.f5779a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.b(xAdNativeResponse);
                }
                i2++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
            while (i2 < this.q.size()) {
                bn bnVar = (bn) this.q.get(i2);
                if (TextUtils.equals(message, bnVar.a())) {
                    bnVar.b();
                }
                i2++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.r == null) {
            return;
        }
        while (i2 < this.r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i2);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i2++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bn bnVar = (bn) this.q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                bnVar.a(view, intValue, intValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bn bnVar = (bn) this.q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                bnVar.a(view, str2, intValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f5779a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i2 = 0; i2 < this.f5779a.size(); i2++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str) && TextUtils.equals("dismiss", str2)) {
                xAdNativeResponse.onShakeViewDismiss();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.s);
            jSONObject.put("isCacheVideo", this.t);
            jSONObject.put("cacheVideoOnlyWifi", this.z);
            RequestParameters requestParameters = this.y;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
    
        if (com.baidu.mobads.sdk.internal.br.a(r16.f5588h, r9) != false) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    @Override // com.baidu.mobads.sdk.internal.bf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void q() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dd.q():void");
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.B = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bn bnVar = (bn) this.q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                if (TextUtils.equals("show", str2)) {
                    bnVar.d();
                } else if (TextUtils.equals("click", str2)) {
                    Object obj = data.get("reason");
                    bnVar.a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals("close", str2)) {
                    bnVar.e();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i2 = 0;
        if (this.A != null && data != null && this.f5779a != null) {
            String str = (String) data.get("instanceInfo");
            while (i2 < this.f5779a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i2++;
            }
            return;
        }
        if (this.C == null || data == null || this.r == null) {
            return;
        }
        String str2 = (String) data.get("instanceInfo");
        while (i2 < this.r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i2);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
            }
            i2++;
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.C = entryAdListener;
    }

    public void a(e.b bVar) {
        this.D = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener == null) {
            this.l = false;
        } else {
            this.l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(IOAdEvent iOAdEvent) {
        if (this.D == null || iOAdEvent == null || this.f5779a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i2 = 0; i2 < this.f5779a.size(); i2++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.D.a(xAdNativeResponse);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f5779a != null) {
            for (int i2 = 0; i2 < this.f5779a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.q != null) {
            for (int i3 = 0; i3 < this.q.size(); i3++) {
                bn bnVar = (bn) this.q.get(i3);
                if (TextUtils.equals(str, bnVar.a())) {
                    bnVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.r == null) {
            return;
        }
        for (int i4 = 0; i4 < this.r.size(); i4++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i4);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.w = width;
            this.x = height;
        }
        this.y = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.u);
            this.k.createProdHandler(jSONObject2);
            this.k.setAdContainer(this.f5587g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.u);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.v);
            if (cn.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if ("video".equals(this.u)) {
                jSONObject.put("at", "10");
                jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.w);
            jSONObject.put("h", "" + this.x);
            jSONObject.put("msa", org.mozilla.universalchardet.prober.n.a.q);
            jSONObject = j.a(jSONObject, b(this.m));
            jSONObject.put("opt", this.E);
            if (this.E == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.b(i2, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i2, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i2, str);
        }
    }

    public void a(int i2) {
        this.E = i2;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.G());
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f5779a != null) {
            for (int i2 = 0; i2 < this.f5779a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bn bnVar = (bn) this.q.get(i3);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.g();
            }
        }
    }

    public String h() {
        return this.v;
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a2 = j.a(map);
            if (this.m == null) {
                this.m = new HashMap<>();
            }
            if (a2.isEmpty()) {
                return;
            }
            for (String str : a2.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a2.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.m.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f5779a != null) {
            for (int i2 = 0; i2 < this.f5779a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bn bnVar = (bn) this.q.get(i3);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.b(z);
            }
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.G());
            hashMap.put("container", viewGroup);
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    public boolean a(View view, a aVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put("view", view);
            hashMap.put("code", Integer.valueOf(i2));
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.a(i2, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i2, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i2, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f5779a != null) {
            for (int i2 = 0; i2 < this.f5779a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f5779a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bn bnVar = (bn) this.q.get(i3);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.a(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i2 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i2) < 150) {
                    hashMap2.put(str, str2);
                    i2 = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i2 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i2 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.m = hashMap2;
    }
}
