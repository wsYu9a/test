package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.shu.priory.config.AdKeys;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class bq implements ExpressResponse {

    /* renamed from: a */
    private Context f6930a;

    /* renamed from: b */
    private int f6931b = 1;

    /* renamed from: c */
    private ExpressResponse.ExpressInteractionListener f6932c;

    /* renamed from: d */
    private ExpressResponse.ExpressAdDownloadWindowListener f6933d;

    /* renamed from: e */
    private ExpressResponse.ExpressDislikeListener f6934e;

    /* renamed from: f */
    private ExpressResponse.ExpressCloseListener f6935f;

    /* renamed from: g */
    private final de f6936g;

    /* renamed from: h */
    private final a f6937h;

    /* renamed from: i */
    private ViewGroup f6938i;

    /* renamed from: j */
    private ExpressAdData f6939j;

    /* renamed from: k */
    private String f6940k;

    public bq(Context context, de deVar, a aVar) {
        this.f6930a = context;
        this.f6936g = deVar;
        this.f6937h = aVar;
    }

    public void a(int i10) {
        this.f6931b = i10;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f6932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (this.f6936g != null) {
            String str = this.f6940k;
            a aVar = this.f6937h;
            if (aVar != null) {
                str = aVar.I();
            }
            this.f6936g.a(str, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        de deVar;
        a aVar = this.f6937h;
        if (aVar == null || (deVar = this.f6936g) == null) {
            return;
        }
        deVar.a(aVar.I(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        de deVar = this.f6936g;
        if (deVar != null) {
            deVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f6932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f6934e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f6934e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f6932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f6933d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.f6931b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f6939j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.f6937h != null) {
            return AdKeys.REQUEST_ID.equals(str) ? this.f6937h.V() : this.f6937h.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f6937h;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f6938i == null && (aVar = this.f6937h) != null) {
            this.f6938i = this.f6936g.a(aVar);
        }
        return this.f6938i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getPECPM() {
        a aVar = this.f6937h;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f6937h;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f6933d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f6937h != null && System.currentTimeMillis() - this.f6937h.y() <= this.f6937h.G();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        de deVar = this.f6936g;
        if (deVar == null || (aVar = this.f6937h) == null) {
            return;
        }
        if (this.f6938i == null) {
            this.f6938i = deVar.a(aVar);
        }
        this.f6936g.a(this.f6938i, this.f6937h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f6935f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f6934e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f6933d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setExpectedSizePixel(int i10, int i11) {
        de deVar = this.f6936g;
        if (deVar != null) {
            deVar.a(i10, i11);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f6932c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i10) {
        de deVar = this.f6936g;
        if (deVar != null) {
            return deVar.a(this.f6938i, this.f6937h, i10);
        }
        return false;
    }

    public void a(String str) {
        this.f6940k = str;
    }

    public String a() {
        a aVar = this.f6937h;
        if (aVar != null) {
            return aVar.I();
        }
        return "";
    }

    public void b(String str) {
        de deVar;
        a aVar = this.f6937h;
        if (aVar != null && (deVar = this.f6936g) != null) {
            this.f6939j = new ExpressAdData(aVar, deVar.g());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f6934e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(View view, int i10, int i11) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f6932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i10, i11);
        }
    }

    public void b(boolean z10) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f6933d;
        if (expressAdDownloadWindowListener != null) {
            if (z10) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, String str, int i10) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f6932c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i10);
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f6935f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(boolean z10) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f6933d;
        if (expressAdDownloadWindowListener != null) {
            if (z10) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
