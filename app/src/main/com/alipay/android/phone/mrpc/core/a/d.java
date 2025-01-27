package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.lang.reflect.Type;
import org.json.JSONObject;
import p3.i;

/* loaded from: classes.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        try {
            String str = new String(this.f6346b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt(i.f29756a);
            if (i10 == 1000) {
                return this.f6345a == String.class ? jSONObject.optString(i.f29758c) : l2.e.b(jSONObject.optString(i.f29758c), this.f6345a);
            }
            throw new RpcException(Integer.valueOf(i10), jSONObject.optString("tips"));
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.f6346b));
            sb2.append(":");
            sb2.append(e10);
            throw new RpcException((Integer) 10, sb2.toString() == null ? "" : e10.getMessage());
        }
    }
}
