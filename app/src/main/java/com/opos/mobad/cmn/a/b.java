package com.opos.mobad.cmn.a;

import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final EventDescription f20093a;

    /* renamed from: b */
    public final boolean f20094b;

    /* renamed from: c */
    public final long f20095c;

    /* renamed from: d */
    public final String f20096d;

    public static class a {

        /* renamed from: c */
        public String f20099c;

        /* renamed from: d */
        private EventDescription f20100d = null;

        /* renamed from: a */
        public boolean f20097a = false;

        /* renamed from: b */
        public long f20098b = 0;

        public a a(long j2) {
            this.f20098b = j2;
            return this;
        }

        public a a(EventDescription eventDescription) {
            this.f20100d = eventDescription;
            return this;
        }

        public a a(String str) {
            this.f20099c = str;
            return this;
        }

        public a a(boolean z) {
            this.f20097a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f20093a = aVar.f20100d;
        this.f20094b = aVar.f20097a;
        this.f20095c = aVar.f20098b;
        this.f20096d = aVar.f20099c;
    }
}
