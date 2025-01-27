package com.sigmob.sdk.downloader.core.listener.assist;

import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class a implements d, e.b<b> {

    /* renamed from: a */
    public final e<b> f19322a;

    /* renamed from: b */
    public InterfaceC0590a f19323b;

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.a$a */
    public interface InterfaceC0590a {
        void a(f fVar, int i10, long j10, long j11);

        void a(f fVar, long j10, long j11);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b bVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.b bVar);

        void a(f fVar, b bVar);
    }

    public static class b implements e.a {

        /* renamed from: a */
        public final int f19324a;

        /* renamed from: b */
        public Boolean f19325b;

        /* renamed from: c */
        public Boolean f19326c;

        /* renamed from: d */
        public volatile Boolean f19327d;

        /* renamed from: e */
        public int f19328e;

        /* renamed from: f */
        public long f19329f;

        /* renamed from: g */
        public final AtomicLong f19330g = new AtomicLong();

        public b(int i10) {
            this.f19324a = i10;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int a() {
            return this.f19324a;
        }

        public long b() {
            return this.f19329f;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.f19328e = cVar.b();
            this.f19329f = cVar.i();
            this.f19330g.set(cVar.j());
            if (this.f19325b == null) {
                this.f19325b = Boolean.FALSE;
            }
            if (this.f19326c == null) {
                this.f19326c = Boolean.valueOf(this.f19330g.get() > 0);
            }
            if (this.f19327d == null) {
                this.f19327d = Boolean.TRUE;
            }
        }
    }

    public a() {
        this.f19322a = new e<>(this);
    }

    public void a(f fVar) {
        b b10 = this.f19322a.b(fVar, fVar.n());
        if (b10 == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(b10.f19326c) && bool.equals(b10.f19327d)) {
            b10.f19327d = Boolean.FALSE;
        }
        InterfaceC0590a interfaceC0590a = this.f19323b;
        if (interfaceC0590a != null) {
            interfaceC0590a.a(fVar, b10.f19328e, b10.f19330g.get(), b10.f19329f);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: b */
    public b a(int i10) {
        return new b(i10);
    }

    public a(e<b> eVar) {
        this.f19322a = eVar;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z10) {
        this.f19322a.b(z10);
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        InterfaceC0590a interfaceC0590a;
        b b10 = this.f19322a.b(fVar, cVar);
        if (b10 == null) {
            return;
        }
        b10.a(cVar);
        if (b10.f19325b.booleanValue() && (interfaceC0590a = this.f19323b) != null) {
            interfaceC0590a.a(fVar, bVar);
        }
        Boolean bool = Boolean.TRUE;
        b10.f19325b = bool;
        b10.f19326c = Boolean.FALSE;
        b10.f19327d = bool;
    }

    public void b(f fVar) {
        b a10 = this.f19322a.a(fVar, null);
        InterfaceC0590a interfaceC0590a = this.f19323b;
        if (interfaceC0590a != null) {
            interfaceC0590a.a(fVar, a10);
        }
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        b b10 = this.f19322a.b(fVar, cVar);
        if (b10 == null) {
            return;
        }
        b10.a(cVar);
        Boolean bool = Boolean.TRUE;
        b10.f19325b = bool;
        b10.f19326c = bool;
        b10.f19327d = bool;
    }

    public void a(f fVar, long j10) {
        b b10 = this.f19322a.b(fVar, fVar.n());
        if (b10 == null) {
            return;
        }
        b10.f19330g.addAndGet(j10);
        InterfaceC0590a interfaceC0590a = this.f19323b;
        if (interfaceC0590a != null) {
            interfaceC0590a.a(fVar, b10.f19330g.get(), b10.f19329f);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f19322a.a();
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z10) {
        this.f19322a.a(z10);
    }

    public void a(InterfaceC0590a interfaceC0590a) {
        this.f19323b = interfaceC0590a;
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        b c10 = this.f19322a.c(fVar, fVar.n());
        InterfaceC0590a interfaceC0590a = this.f19323b;
        if (interfaceC0590a != null) {
            interfaceC0590a.a(fVar, aVar, exc, c10);
        }
    }
}
