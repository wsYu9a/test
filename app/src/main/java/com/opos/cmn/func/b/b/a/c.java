package com.opos.cmn.func.b.b.a;

import java.util.List;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public final boolean f17105a;

    /* renamed from: b */
    public final String f17106b;

    /* renamed from: c */
    public final String f17107c;

    /* renamed from: d */
    public final boolean f17108d;

    /* renamed from: e */
    public final List<String> f17109e;

    /* renamed from: f */
    public final b f17110f;

    public static class a {

        /* renamed from: b */
        private String f17112b;

        /* renamed from: c */
        private String f17113c;

        /* renamed from: e */
        private List<String> f17115e;

        /* renamed from: f */
        private b f17116f;

        /* renamed from: a */
        private boolean f17111a = true;

        /* renamed from: d */
        private boolean f17114d = true;

        public c a() {
            return new c(this);
        }
    }

    public interface b {
    }

    private c(a aVar) {
        this.f17105a = aVar.f17111a;
        this.f17106b = aVar.f17112b;
        this.f17107c = aVar.f17113c;
        this.f17108d = aVar.f17114d;
        this.f17109e = aVar.f17115e;
        this.f17110f = aVar.f17116f;
    }

    /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "HttpDnsConfig{enableHttpDns=" + this.f17105a + ", region='" + this.f17106b + "', appVersion='" + this.f17107c + "', enableDnUnit=" + this.f17108d + ", innerWhiteList=" + this.f17109e + ", accountCallback=" + this.f17110f + '}';
    }
}
