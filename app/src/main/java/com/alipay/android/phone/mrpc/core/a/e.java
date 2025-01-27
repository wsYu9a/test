package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: c */
    public int f6349c;

    /* renamed from: d */
    public Object f6350d;

    public e(int i10, String str, Object obj) {
        super(str, obj);
        this.f6349c = i10;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.f6350d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f6350d != null) {
                arrayList.add(new BasicNameValuePair("extParam", l2.f.a(this.f6350d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f6347a));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6349c);
            arrayList.add(new BasicNameValuePair("id", sb2.toString()));
            Objects.toString(this.f6348b);
            Object obj = this.f6348b;
            arrayList.add(new BasicNameValuePair("requestData", obj == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : l2.f.a(obj)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e10) {
            StringBuilder sb3 = new StringBuilder("request  =");
            sb3.append(this.f6348b);
            sb3.append(":");
            sb3.append(e10);
            throw new RpcException(9, sb3.toString() == null ? "" : e10.getMessage(), e10);
        }
    }
}
