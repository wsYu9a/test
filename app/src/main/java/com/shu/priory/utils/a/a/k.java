package com.shu.priory.utils.a.a;

import android.content.Context;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.a.a;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class k {

    /* renamed from: a */
    private Context f17286a;

    /* renamed from: b */
    private Object f17287b;

    /* renamed from: c */
    private Method f17288c;

    public k(Context context) {
        this.f17286a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f17287b = cls.newInstance();
            this.f17288c = cls.getMethod("getOAID", Context.class);
        } catch (Exception unused) {
        }
    }

    private String a(Context context, Method method) {
        Object obj = this.f17287b;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void a(a.InterfaceC0558a interfaceC0558a) {
        try {
            String a10 = a(this.f17286a, this.f17288c);
            if (interfaceC0558a != null) {
                interfaceC0558a.a(a10);
            }
        } catch (Throwable unused) {
            com.shu.priory.utils.h.a(SDKConstants.TAG, "not support oaid");
        }
    }
}
