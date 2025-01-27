package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a */
    private de f7184a;

    /* renamed from: b */
    private String f7185b;

    public interface a {
        void a();

        void a(int i10, String str, NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i10);

        void a(List<NativeResponse> list);

        void b();

        void b(int i10, String str, NativeResponse nativeResponse);

        void b(NativeResponse nativeResponse);

        void c();
    }

    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public g(Context context, String str, a aVar, boolean z10, int i10) {
        this(context, aVar, new de(context, str, "feed", z10, i10));
    }

    public void a() {
        de deVar = this.f7184a;
        if (deVar != null) {
            deVar.p();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public g(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z10, int i10) {
        de deVar = new de(context, str, "feed", z10, i10);
        this.f7184a = deVar;
        deVar.a(expressAdListener);
        this.f7184a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        de deVar = this.f7184a;
        if (deVar != null) {
            deVar.h(this.f7185b);
        }
        this.f7184a.a(requestParameters);
        this.f7184a.a();
    }

    public void a(b bVar) {
        de deVar = this.f7184a;
        if (deVar != null) {
            deVar.a(bVar);
        }
    }

    public void a(int i10) {
        de deVar = this.f7184a;
        if (deVar != null) {
            deVar.f6889r = i10;
        }
    }

    public g(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z10, int i10) {
        de deVar = new de(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z10, i10);
        this.f7184a = deVar;
        deVar.a(entryAdListener);
    }

    public void a(boolean z10) {
        de deVar = this.f7184a;
        if (deVar != null) {
            deVar.c(z10);
        }
    }

    public void b(String str) {
        this.f7185b = str;
    }

    public g(Context context, String str, a aVar, boolean z10, int i10, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f7184a = new de(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z10, i10);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f7184a = new de(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z10, i10);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f7184a = new de(context, str, "video", z10, i10);
            } else {
                this.f7184a = new de(context, str, "feed", z10, i10);
            }
        }
        this.f7184a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f7184a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f7184a.h(this.f7185b);
        this.f7184a.a(requestParameters);
        return this.f7184a.l();
    }

    public void a(String str) {
        de deVar = this.f7184a;
        if (deVar != null) {
            deVar.b(str);
        }
    }

    public g(Context context, a aVar, de deVar) {
        this.f7184a = deVar;
        deVar.a(aVar);
    }
}
