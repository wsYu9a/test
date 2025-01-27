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
import com.baidu.mobads.sdk.internal.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class de extends bi {
    private int A;
    private RequestParameters B;
    private boolean C;
    private g.a D;
    private BaiduNativeManager.ExpressAdListener E;
    private BaiduNativeManager.EntryAdListener F;
    private g.b G;
    private int H;
    private int I;
    private int J;

    /* renamed from: a */
    private List<NativeResponse> f7154a;

    /* renamed from: t */
    private List<ExpressResponse> f7155t;

    /* renamed from: u */
    private List<EntryResponse> f7156u;

    /* renamed from: v */
    private int f7157v;

    /* renamed from: w */
    private boolean f7158w;

    /* renamed from: x */
    private String f7159x;

    /* renamed from: y */
    private String f7160y;

    /* renamed from: z */
    private int f7161z;

    public de(Context context, String str, String str2, boolean z10, int i10) {
        super(context);
        this.C = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.f7160y = str;
        this.f7159x = str2;
        this.f7158w = z10;
        this.f7157v = i10;
        this.f7161z = 600;
        this.A = 500;
    }

    public void a(g.a aVar) {
        this.D = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        a(jSONObject, hashMap);
    }

    public void c(boolean z10) {
        this.C = z10;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    public String e() {
        return this.f7159x;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i10 = 0;
        if (this.D != null && data != null && this.f7154a != null) {
            String str = (String) data.get("instanceInfo");
            while (i10 < this.f7154a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.D.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i10++;
            }
            return;
        }
        if (this.F == null || data == null || this.f7156u == null) {
            return;
        }
        String str2 = (String) data.get("instanceInfo");
        while (i10 < this.f7156u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f7156u.get(i10);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
            }
            i10++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        int i10 = 0;
        if (this.E != null && this.f7155t != null) {
            while (i10 < this.f7155t.size()) {
                bq bqVar = (bq) this.f7155t.get(i10);
                if (TextUtils.equals(bqVar.a(), str)) {
                    bqVar.a(bqVar);
                }
                i10++;
            }
            return;
        }
        if (this.f7154a != null) {
            while (i10 < this.f7154a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    xAdNativeResponse.onAdClose(xAdNativeResponse);
                }
                i10++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i10 = 0;
        if (this.D != null && !TextUtils.isEmpty(message) && this.f7154a != null) {
            while (i10 < this.f7154a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.b(xAdNativeResponse);
                }
                i10++;
            }
            return;
        }
        if (this.E != null && !TextUtils.isEmpty(message) && this.f7155t != null) {
            while (i10 < this.f7155t.size()) {
                bq bqVar = (bq) this.f7155t.get(i10);
                if (TextUtils.equals(message, bqVar.a())) {
                    bqVar.b();
                }
                i10++;
            }
            return;
        }
        if (this.F == null || TextUtils.isEmpty(message) || this.f7156u == null) {
            return;
        }
        while (i10 < this.f7156u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f7156u.get(i10);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i10++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.E == null || iOAdEvent == null || this.f7155t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i10 = 0; i10 < this.f7155t.size(); i10++) {
            bq bqVar = (bq) this.f7155t.get(i10);
            if (TextUtils.equals(bqVar.a(), str)) {
                bqVar.a(view, intValue, intValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.E == null || iOAdEvent == null || this.f7155t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i10 = 0; i10 < this.f7155t.size(); i10++) {
            bq bqVar = (bq) this.f7155t.get(i10);
            if (TextUtils.equals(bqVar.a(), str)) {
                bqVar.a(view, str2, intValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f7154a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                if (TextUtils.equals("dismiss", str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                } else if (TextUtils.equals("coupon_float_dismiss", str2)) {
                    xAdNativeResponse.onCouponFloatDismiss();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
    
        if (com.baidu.mobads.sdk.internal.bu.a(r16.f6880i, r9) != false) goto L222;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    @Override // com.baidu.mobads.sdk.internal.bi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.de.q():void");
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.E = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        int i10 = 0;
        if (this.E != null && this.f7155t != null) {
            while (i10 < this.f7155t.size()) {
                bq bqVar = (bq) this.f7155t.get(i10);
                if (TextUtils.equals(bqVar.a(), str)) {
                    if (TextUtils.equals("show", str2)) {
                        bqVar.d();
                    } else if (TextUtils.equals("click", str2)) {
                        Object obj = data.get(MediationConstant.KEY_REASON);
                        bqVar.b(obj instanceof String ? (String) obj : "");
                    } else if (TextUtils.equals("close", str2)) {
                        bqVar.e();
                    }
                }
                i10++;
            }
            return;
        }
        if (this.f7154a != null) {
            while (i10 < this.f7154a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    if (TextUtils.equals("show", str2)) {
                        xAdNativeResponse.onDislikeShow();
                    } else if (TextUtils.equals("click", str2)) {
                        Object obj2 = data.get(MediationConstant.KEY_REASON);
                        xAdNativeResponse.onDislikeClick(obj2 instanceof String ? (String) obj2 : "");
                    } else if (TextUtils.equals("close", str2)) {
                        xAdNativeResponse.onDislikeClose();
                    }
                }
                i10++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i10 = 0;
        if (this.D != null && !TextUtils.isEmpty(message) && this.f7154a != null) {
            while (i10 < this.f7154a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.a(xAdNativeResponse);
                }
                i10++;
            }
            return;
        }
        if (this.E != null && !TextUtils.isEmpty(message) && this.f7155t != null) {
            while (i10 < this.f7155t.size()) {
                bq bqVar = (bq) this.f7155t.get(i10);
                if (TextUtils.equals(message, bqVar.a())) {
                    bqVar.c();
                }
                i10++;
            }
            return;
        }
        if (this.F == null || TextUtils.isEmpty(message) || this.f7156u == null) {
            return;
        }
        while (i10 < this.f7156u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f7156u.get(i10);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i10++;
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.F = entryAdListener;
    }

    public void a(g.b bVar) {
        this.G = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        IAdInterListener iAdInterListener = this.f6884m;
        if (iAdInterListener == null) {
            this.f6885n = false;
        } else {
            this.f6885n = true;
            iAdInterListener.loadAd(j(), k());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(IOAdEvent iOAdEvent) {
        if (this.G == null || iOAdEvent == null || this.f7154a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.G.a(xAdNativeResponse);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f7154a != null) {
            for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.f7155t != null) {
            for (int i11 = 0; i11 < this.f7155t.size(); i11++) {
                bq bqVar = (bq) this.f7155t.get(i11);
                if (TextUtils.equals(str, bqVar.a())) {
                    bqVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f7156u == null) {
            return;
        }
        for (int i12 = 0; i12 < this.f7156u.size(); i12++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f7156u.get(i12);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f7161z = width;
            this.A = height;
        }
        this.B = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject j() {
        this.f6890s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f7159x);
            this.f6884m.createProdHandler(jSONObject2);
            this.f6884m.setAdContainer(this.f6879h);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f7159x);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f7160y);
            if (cq.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f6888q)) {
                jSONObject.put("appid", this.f6888q);
            }
            if ("video".equals(this.f7159x)) {
                jSONObject.put("at", "10");
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f7161z);
            jSONObject.put("h", "" + this.A);
            jSONObject.put("msa", 143);
            jSONObject = m.a(jSONObject, b(this.f6886o));
            jSONObject.put("opt", this.H);
            if (this.H == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f7157v);
            jSONObject.put("isCacheVideo", this.f7158w);
            jSONObject.put("cacheVideoOnlyWifi", this.C);
            RequestParameters requestParameters = this.B;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public String g() {
        return this.f7160y;
    }

    public void a(int i10) {
        this.H = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f7154a != null) {
            for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f7155t == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f7155t.size(); i11++) {
            bq bqVar = (bq) this.f7155t.get(i11);
            if (TextUtils.equals(str, bqVar.a())) {
                bqVar.h();
            }
        }
    }

    public void a(int i10, int i11) {
        this.I = i10;
        this.J = i11;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && this.f7154a != null) {
            for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z10);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f7155t == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f7155t.size(); i11++) {
            bq bqVar = (bq) this.f7155t.get(i11);
            if (TextUtils.equals(str, bqVar.a())) {
                bqVar.b(z10);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f7154a != null) {
            for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f7155t == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f7155t.size(); i11++) {
            bq bqVar = (bq) this.f7155t.get(i11);
            if (TextUtils.equals(str, bqVar.a())) {
                bqVar.g();
            }
        }
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.I());
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    public RequestParameters f() {
        return this.B;
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.I());
            hashMap.put(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(this.I));
            hashMap.put("h", Integer.valueOf(this.J));
            hashMap.put("container", viewGroup);
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a10 = m.a(map);
            if (this.f6886o == null) {
                this.f6886o = new HashMap<>();
            }
            if (a10.isEmpty()) {
                return;
            }
            for (String str : a10.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a10.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f6886o.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(View view, a aVar, int i10) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put("view", view);
            hashMap.put("code", Integer.valueOf(i10));
        } catch (JSONException e10) {
            bt.a().a(e10);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get(p3.i.f29758c);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, int i10, String str2) {
        if (this.D != null) {
            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.f6880i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.b(i10, str, xAdNativeResponse);
        }
        if (this.E != null) {
            bq bqVar = new bq(this.f6880i, this, null);
            bqVar.a(str2);
            this.E.onNativeFail(i10, str, bqVar);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i10, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i10, String str, String str2) {
        if (this.D != null) {
            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.f6880i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.a(i10, str, xAdNativeResponse);
        }
        if (this.E != null) {
            bq bqVar = new bq(this.f6880i, this, null);
            bqVar.a(str2);
            this.E.onNoAd(i10, str, bqVar);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i10, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && this.f7154a != null) {
            for (int i10 = 0; i10 < this.f7154a.size(); i10++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f7154a.get(i10);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z10);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f7155t == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f7155t.size(); i11++) {
            bq bqVar = (bq) this.f7155t.get(i11);
            if (TextUtils.equals(str, bqVar.a())) {
                bqVar.a(z10);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i10 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i10) < 150) {
                    hashMap2.put(str, str2);
                    i10 = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i10 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i10 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f6886o = hashMap2;
    }
}
