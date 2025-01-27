package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.f;

/* loaded from: classes5.dex */
class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ KWEGIDDFP f34687a;

    a(KWEGIDDFP kwegiddfp) {
        this.f34687a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Context unused;
        try {
            context = this.f34687a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f34687a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f34687a.mParamContext;
            int i2 = f.f34708c;
            if (Build.VERSION.SDK_INT >= 28) {
                f.a();
            }
            KWEGIDDFP kwegiddfp = this.f34687a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            c c2 = c.c();
            str = this.f34687a.mPkgName;
            c2.b(str);
            KWEGIDDFP kwegiddfp2 = this.f34687a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
