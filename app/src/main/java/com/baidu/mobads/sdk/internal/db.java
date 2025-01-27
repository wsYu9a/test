package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;

/* loaded from: classes2.dex */
class db implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ RelativeLayout f7140a;

    /* renamed from: b */
    final /* synthetic */ cx f7141b;

    public db(cx cxVar, RelativeLayout relativeLayout) {
        this.f7141b = cxVar;
        this.f7140a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z10) {
        if (z10) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.f7141b.f6880i);
            hashMap.put("banner_container", this.f7140a);
            hashMap.put("entry", Integer.valueOf(this.f7141b.G));
            hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7141b.H));
            hashMap.put("novel_id", this.f7141b.I);
            hashMap.put("isnight", Boolean.valueOf(this.f7141b.x()));
            this.f7141b.a(cx.f7132x, hashMap);
        }
    }
}
