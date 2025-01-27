package com.opos.cmn.func.b.b.a;

import com.opos.cmn.func.b.b.a.a;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.c;
import com.opos.cmn.func.b.b.a.f;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public final b f17117a;

    /* renamed from: b */
    public final c f17118b;

    /* renamed from: c */
    public final com.opos.cmn.func.b.b.a.a f17119c;

    /* renamed from: d */
    public final f f17120d;

    /* renamed from: e */
    public final e f17121e;

    /* renamed from: f */
    public final boolean f17122f;

    public static class a {

        /* renamed from: a */
        private b f17123a;

        /* renamed from: b */
        private c f17124b;

        /* renamed from: c */
        private f f17125c;

        /* renamed from: d */
        private com.opos.cmn.func.b.b.a.a f17126d;

        /* renamed from: e */
        private e f17127e;

        /* renamed from: f */
        private boolean f17128f = true;

        public d a() {
            if (this.f17123a == null) {
                this.f17123a = new b.C0389b().a();
            }
            if (this.f17124b == null) {
                this.f17124b = new c.a().a();
            }
            if (this.f17125c == null) {
                this.f17125c = new f.a().a();
            }
            if (this.f17126d == null) {
                this.f17126d = new a.C0388a().a();
            }
            return new d(this);
        }
    }

    private d(a aVar) {
        this.f17117a = aVar.f17123a;
        this.f17118b = aVar.f17124b;
        this.f17120d = aVar.f17125c;
        this.f17119c = aVar.f17126d;
        this.f17121e = aVar.f17127e;
        this.f17122f = aVar.f17128f;
    }

    /* synthetic */ d(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "HttpExtConfig{cloudConfig=" + this.f17117a + ", httpDnsConfig=" + this.f17118b + ", appTraceConfig=" + this.f17119c + ", iPv6Config=" + this.f17120d + ", httpStatConfig=" + this.f17121e + ", closeNetLog=" + this.f17122f + '}';
    }
}
