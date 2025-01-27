package com.czhj.devicehelper.oaId.helpers;

import android.content.Context;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a */
    public Context f8347a;

    /* renamed from: b */
    public Class f8348b;

    /* renamed from: c */
    public Object f8349c;

    /* renamed from: d */
    public Method f8350d;

    /* renamed from: e */
    public Method f8351e;

    /* renamed from: f */
    public Method f8352f;

    /* renamed from: g */
    public Method f8353g;

    public k(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f8348b = cls;
            this.f8349c = cls.newInstance();
            this.f8347a = context;
            this.f8351e = this.f8348b.getMethod("getOAID", Context.class);
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
        }
    }

    public String a() {
        return a(this.f8347a, this.f8351e);
    }

    public final String a(Context context, Method method) {
        Object obj = this.f8349c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }
        return null;
    }
}
