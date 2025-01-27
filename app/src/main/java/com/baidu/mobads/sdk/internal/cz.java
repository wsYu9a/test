package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* loaded from: classes.dex */
class cz implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ RelativeLayout f5770a;

    /* renamed from: b */
    final /* synthetic */ cv f5771b;

    cz(cv cvVar, RelativeLayout relativeLayout) {
        this.f5771b = cvVar;
        this.f5770a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.f5771b.f5588h);
            hashMap.put("banner_container", this.f5770a);
            hashMap.put("entry", Integer.valueOf(this.f5771b.D));
            hashMap.put("channelId", Integer.valueOf(this.f5771b.E));
            hashMap.put("novel_id", this.f5771b.F);
            hashMap.put("isnight", Boolean.valueOf(this.f5771b.w()));
            this.f5771b.a(cv.u, hashMap);
        }
    }
}
