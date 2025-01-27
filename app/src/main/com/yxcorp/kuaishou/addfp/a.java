package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.e;

/* loaded from: classes4.dex */
class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ KWEGIDDFP f25166a;

    public a(KWEGIDDFP kwegiddfp) {
        this.f25166a = kwegiddfp;
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
            context = this.f25166a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f25166a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f25166a.mParamContext;
            int i10 = e.f25186c;
            if (Build.VERSION.SDK_INT >= 28) {
                e.a();
            }
            KWEGIDDFP kwegiddfp = this.f25166a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            c c10 = c.c();
            str = this.f25166a.mPkgName;
            c10.b(str);
            KWEGIDDFP kwegiddfp2 = this.f25166a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
