package com.opos.cmn.biz.web.b.a;

import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final com.opos.cmn.biz.web.b.a.a.b f16865a;

    /* renamed from: b */
    public final Map<String, Object> f16866b;

    /* renamed from: c */
    public final boolean f16867c;

    /* renamed from: d */
    public final com.opos.cmn.biz.web.b.a.a.a f16868d;

    public static class a {

        /* renamed from: a */
        private com.opos.cmn.biz.web.b.a.a.b f16869a;

        /* renamed from: b */
        private Map<String, Object> f16870b;

        /* renamed from: c */
        private boolean f16871c = true;

        /* renamed from: d */
        private com.opos.cmn.biz.web.b.a.a.a f16872d;

        public a a(com.opos.cmn.biz.web.b.a.a.a aVar) {
            this.f16872d = aVar;
            return this;
        }

        public a a(com.opos.cmn.biz.web.b.a.a.b bVar) {
            this.f16869a = bVar;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.f16870b = map;
            return this;
        }

        public a a(boolean z) {
            this.f16871c = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.f16865a = aVar.f16869a;
        this.f16866b = aVar.f16870b;
        this.f16867c = aVar.f16871c;
        this.f16868d = aVar.f16872d;
    }

    /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "WebViewInitParams{iWebActionListener=" + this.f16865a + ", jsInterfaceMap=" + this.f16866b + ", isShowTitle=" + this.f16867c + ", iReceivedSslErrorHandler=" + this.f16868d + '}';
    }
}
