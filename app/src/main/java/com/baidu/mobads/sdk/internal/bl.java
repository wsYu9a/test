package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bi;
import java.util.HashMap;

/* loaded from: classes2.dex */
class bl implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f6894a;

    /* renamed from: b */
    final /* synthetic */ bi.a f6895b;

    public bl(bi.a aVar, IOAdEvent iOAdEvent) {
        this.f6895b = aVar;
        this.f6894a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        String str;
        String str2;
        IOAdEvent iOAdEvent = this.f6894a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f6894a.getType();
        if (z.I.equals(type)) {
            bi.this.a(this.f6894a);
            return;
        }
        if (z.L.equals(type)) {
            bi.this.f6887p = this.f6894a.getMessage();
            bi.this.q();
            return;
        }
        if (z.M.equals(type)) {
            bi.this.e(this.f6894a);
            return;
        }
        if (z.N.equals(type)) {
            bi.this.f(this.f6894a);
            return;
        }
        if (z.V.equals(type)) {
            bi.this.g(this.f6894a);
            return;
        }
        String str3 = "";
        int i10 = 0;
        int i11 = 0;
        r6 = false;
        boolean z10 = false;
        if (z.f7389q.equals(type)) {
            HashMap hashMap2 = (HashMap) this.f6894a.getData();
            if (hashMap2 != null) {
                str3 = (String) hashMap2.get("error_message");
                Object obj = hashMap2.get("error_code");
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                i10 = ((Integer) obj2).intValue();
                bi.this.f6881j = (String) hashMap2.get(bi.f6876e);
                str2 = bi.this.f6881j;
            } else {
                str2 = "";
            }
            bi.this.a(str3, i10, str2);
            return;
        }
        if (z.K.equals(type)) {
            HashMap hashMap3 = (HashMap) this.f6894a.getData();
            if (hashMap3 != null) {
                str3 = (String) hashMap3.get("error_message");
                Object obj3 = hashMap3.get("error_code");
                Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                i11 = ((Integer) obj4).intValue();
                bi.this.f6881j = (String) hashMap3.get(bi.f6876e);
                str = bi.this.f6881j;
            } else {
                str = "";
            }
            bi.this.a(i11, str3, str);
            return;
        }
        if (z.G.equals(type)) {
            bi.this.h(this.f6894a);
            return;
        }
        if (z.W.equals(type)) {
            bi.this.d();
            return;
        }
        if (z.X.equals(type)) {
            bi.this.d(this.f6894a);
            return;
        }
        if (z.Z.equals(type)) {
            bi.this.s();
            return;
        }
        if (z.f7363aa.equals(type)) {
            IOAdEvent iOAdEvent2 = this.f6894a;
            if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                z10 = "1".equals((String) hashMap.get("serverVerify"));
            }
            bi.this.b(z10);
            return;
        }
        if (z.f7364ab.equals(type)) {
            bi.this.b();
            return;
        }
        if (z.f7365ac.equals(type)) {
            bi.this.c();
            return;
        }
        if (z.f7366ad.equals(type)) {
            bi.this.c();
            return;
        }
        if (z.J.equals(type)) {
            bi.this.b(this.f6894a);
            return;
        }
        if (z.f7367ae.equals(type)) {
            bi.this.a(this.f6894a.getMessage(), 1 == this.f6894a.getCode());
            return;
        }
        if (z.f7368af.equals(type)) {
            bi.this.e(this.f6894a.getMessage());
            return;
        }
        if (z.f7369ag.equals(type)) {
            bi.this.f(this.f6894a.getMessage());
            return;
        }
        if (z.f7370ah.equals(type)) {
            bi.this.d(this.f6894a.getMessage());
            return;
        }
        if (z.C.equals(type)) {
            bi.this.g(this.f6894a.getMessage());
            return;
        }
        if (z.Y.equals(type)) {
            bi.this.t();
            return;
        }
        if (z.f7371ai.equals(type)) {
            bi.this.b(this.f6894a.getMessage(), 1 == this.f6894a.getCode());
            return;
        }
        if (z.al.equals(type)) {
            bi.this.c(this.f6894a);
            return;
        }
        if (z.f7372aj.equals(type)) {
            bi.this.u();
            return;
        }
        if (z.f7373ak.equals(type)) {
            bi.this.v();
            return;
        }
        if (z.an.equals(type)) {
            bi.this.i(this.f6894a);
        } else if (z.ao.equals(type)) {
            bi.this.j(this.f6894a);
        } else if (z.am.equals(type)) {
            bi.this.k(this.f6894a);
        }
    }
}
