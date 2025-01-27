package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.HashMap;

/* loaded from: classes.dex */
public class bn implements ExpressResponse {

    /* renamed from: a */
    private Context f5619a;

    /* renamed from: b */
    private int f5620b = 1;

    /* renamed from: c */
    private ExpressResponse.ExpressInteractionListener f5621c;

    /* renamed from: d */
    private ExpressResponse.ExpressAdDownloadWindowListener f5622d;

    /* renamed from: e */
    private ExpressResponse.ExpressDislikeListener f5623e;

    /* renamed from: f */
    private final dd f5624f;

    /* renamed from: g */
    private final a f5625g;

    /* renamed from: h */
    private ViewGroup f5626h;

    /* renamed from: i */
    private ExpressAdData f5627i;

    public bn(Context context, dd ddVar, a aVar) {
        this.f5619a = context;
        this.f5624f = ddVar;
        this.f5625g = aVar;
    }

    public void a(int i2) {
        this.f5620b = i2;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f5621c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        dd ddVar;
        a aVar = this.f5625g;
        if (aVar == null || (ddVar = this.f5624f) == null) {
            return;
        }
        ddVar.a(aVar.G(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        dd ddVar = this.f5624f;
        if (ddVar != null) {
            ddVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f5621c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f5623e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f5623e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f5621c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f5622d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.f5620b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f5627i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f5625g;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f5626h == null && (aVar = this.f5625g) != null) {
            this.f5626h = this.f5624f.a(aVar);
        }
        return this.f5626h;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f5625g;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f5625g != null && System.currentTimeMillis() - this.f5625g.y() <= this.f5625g.E();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        dd ddVar = this.f5624f;
        if (ddVar == null || (aVar = this.f5625g) == null) {
            return;
        }
        if (this.f5626h == null) {
            this.f5626h = ddVar.a(aVar);
        }
        this.f5624f.a(this.f5626h, this.f5625g);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f5623e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f5622d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f5621c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i2) {
        dd ddVar = this.f5624f;
        if (ddVar != null) {
            return ddVar.a(this.f5626h, this.f5625g, i2);
        }
        return false;
    }

    public String a() {
        a aVar = this.f5625g;
        return aVar != null ? aVar.G() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dd ddVar;
        a aVar = this.f5625g;
        if (aVar == null || (ddVar = this.f5624f) == null) {
            return;
        }
        ddVar.a(aVar.G(), false, str, hashMap);
    }

    public void b(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f5622d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, int i2, int i3) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f5621c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i2, i3);
        }
    }

    public void a(View view, String str, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f5621c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i2);
        }
    }

    public void a(String str) {
        dd ddVar;
        a aVar = this.f5625g;
        if (aVar != null && (ddVar = this.f5624f) != null) {
            this.f5627i = new ExpressAdData(aVar, ddVar.h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f5623e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f5622d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
