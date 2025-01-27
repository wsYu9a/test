package com.opos.cmn.biz.web.a.b;

import android.content.Context;
import android.webkit.WebResourceResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class c implements com.opos.cmn.biz.web.a.a.a {

    /* renamed from: a */
    private static final byte[] f16861a = new byte[0];

    /* renamed from: b */
    private static c f16862b;

    /* renamed from: c */
    private com.opos.cmn.biz.web.a.a.a f16863c = new com.opos.cmn.biz.web.a.a.b();

    private c() {
    }

    public static c a() {
        if (f16862b == null) {
            synchronized (f16861a) {
                if (f16862b == null) {
                    f16862b = new c();
                }
            }
        }
        return f16862b;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public WebResourceResponse a(String str) {
        return this.f16863c.a(str);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new Exception("init params error");
        }
        this.f16863c.a(context, bVar);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(List<a> list) {
        this.f16863c.a(list);
    }
}
