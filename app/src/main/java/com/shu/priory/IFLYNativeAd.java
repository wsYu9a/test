package com.shu.priory;

import android.content.Context;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.e.a;
import com.shu.priory.listener.IFLYBaseAdListener;

/* loaded from: classes3.dex */
public class IFLYNativeAd {

    /* renamed from: a */
    private a f16786a;

    public IFLYNativeAd(Context context, String str, IFLYBaseAdListener<NativeDataRef> iFLYBaseAdListener) {
        this.f16786a = new a(context, str, iFLYBaseAdListener);
    }

    public void loadAd() {
        a aVar = this.f16786a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setParameter(String str, Object obj) {
        a aVar = this.f16786a;
        if (aVar != null) {
            aVar.a(str, obj);
        }
    }
}
