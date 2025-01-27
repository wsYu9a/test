package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bf;
import java.util.HashMap;

/* loaded from: classes.dex */
class bi implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f5594a;

    /* renamed from: b */
    final /* synthetic */ bf.a f5595b;

    bi(bf.a aVar, IOAdEvent iOAdEvent) {
        this.f5595b = aVar;
        this.f5594a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.f5594a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f5594a.getType();
        if (w.J.equals(type)) {
            bf.this.a(this.f5594a);
            return;
        }
        if (w.M.equals(type)) {
            bf.this.n = this.f5594a.getMessage();
            bf.this.q();
            return;
        }
        if (w.N.equals(type)) {
            bf.this.e(this.f5594a);
            return;
        }
        if (w.O.equals(type)) {
            bf.this.f(this.f5594a);
            return;
        }
        if (w.W.equals(type)) {
            bf.this.g(this.f5594a);
            return;
        }
        String str = "";
        int i2 = 0;
        int i3 = 0;
        r5 = false;
        boolean z = false;
        if (w.r.equals(type)) {
            HashMap hashMap2 = (HashMap) this.f5594a.getData();
            if (hashMap2 != null) {
                str = (String) hashMap2.get("error_message");
                Object obj = hashMap2.get("error_code");
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                i2 = ((Integer) obj2).intValue();
            }
            bf.this.b(str, i2);
            return;
        }
        if (w.L.equals(type)) {
            HashMap hashMap3 = (HashMap) this.f5594a.getData();
            if (hashMap3 != null) {
                str = (String) hashMap3.get("error_message");
                Object obj3 = hashMap3.get("error_code");
                Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                i3 = ((Integer) obj4).intValue();
            }
            bf.this.a(i3, str);
            return;
        }
        if (w.H.equals(type)) {
            bf.this.h(this.f5594a);
            return;
        }
        if (w.X.equals(type)) {
            bf.this.d();
            return;
        }
        if (w.Y.equals(type)) {
            bf.this.d(this.f5594a);
            return;
        }
        if (w.aa.equals(type)) {
            bf.this.s();
            return;
        }
        if (w.ab.equals(type)) {
            IOAdEvent iOAdEvent2 = this.f5594a;
            if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                z = "1".equals((String) hashMap.get("serverVerify"));
            }
            bf.this.b(z);
            return;
        }
        if (w.ac.equals(type)) {
            bf.this.b_();
            return;
        }
        if (w.f5858ad.equals(type)) {
            bf.this.c_();
            return;
        }
        if (w.K.equals(type)) {
            bf.this.b(this.f5594a);
            return;
        }
        if (w.ae.equals(type)) {
            bf.this.a(this.f5594a.getMessage(), 1 == this.f5594a.getCode());
            return;
        }
        if (w.af.equals(type)) {
            bf.this.e(this.f5594a.getMessage());
            return;
        }
        if (w.ag.equals(type)) {
            bf.this.d(this.f5594a.getMessage());
            return;
        }
        if (w.D.equals(type)) {
            bf.this.f(this.f5594a.getMessage());
            return;
        }
        if (w.Z.equals(type)) {
            bf.this.t();
            return;
        }
        if (w.ah.equals(type)) {
            bf.this.b(this.f5594a.getMessage(), 1 == this.f5594a.getCode());
            return;
        }
        if (w.aj.equals(type)) {
            bf.this.c(this.f5594a);
            return;
        }
        if (w.ai.equals(type)) {
            bf.this.u();
            return;
        }
        if (w.al.equals(type)) {
            bf.this.i(this.f5594a);
        } else if (w.am.equals(type)) {
            bf.this.j(this.f5594a);
        } else if (w.ak.equals(type)) {
            bf.this.k(this.f5594a);
        }
    }
}
