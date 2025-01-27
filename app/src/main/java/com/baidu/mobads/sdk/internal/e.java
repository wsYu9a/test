package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private dd f5800a;

    /* renamed from: b */
    private String f5801b;

    public interface a {
        void a();

        void a(int i2, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i2);

        void a(List<NativeResponse> list);

        void b();

        void b(int i2, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public e(Context context, String str, a aVar, boolean z, int i2) {
        this(context, aVar, new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i2));
    }

    public void a() {
        dd ddVar = this.f5800a;
        if (ddVar != null) {
            ddVar.e();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public e(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i2) {
        dd ddVar = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i2);
        this.f5800a = ddVar;
        ddVar.a(expressAdListener);
        this.f5800a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dd ddVar = this.f5800a;
        if (ddVar != null) {
            ddVar.g(this.f5801b);
        }
        this.f5800a.a(requestParameters);
        this.f5800a.a();
    }

    public void a(b bVar) {
        dd ddVar = this.f5800a;
        if (ddVar != null) {
            ddVar.a(bVar);
        }
    }

    public void a(int i2) {
        dd ddVar = this.f5800a;
        if (ddVar != null) {
            ddVar.p = i2;
        }
    }

    public e(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i2) {
        dd ddVar = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z, i2);
        this.f5800a = ddVar;
        ddVar.a(entryAdListener);
    }

    public void a(boolean z) {
        dd ddVar = this.f5800a;
        if (ddVar != null) {
            ddVar.c(z);
        }
    }

    public void b(String str) {
        this.f5801b = str;
    }

    public e(Context context, String str, a aVar, boolean z, int i2, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f5800a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i2);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f5800a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i2);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f5800a = new dd(context, str, "video", z, i2);
            } else {
                this.f5800a = new dd(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i2);
            }
        }
        this.f5800a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f5800a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f5800a.g(this.f5801b);
        this.f5800a.a(requestParameters);
        return this.f5800a.m();
    }

    public void a(String str) {
        dd ddVar = this.f5800a;
        if (ddVar != null) {
            ddVar.b(str);
        }
    }

    public e(Context context, a aVar, dd ddVar) {
        this.f5800a = ddVar;
        ddVar.a(aVar);
    }
}
