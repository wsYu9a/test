package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;

/* loaded from: classes4.dex */
public abstract class e extends d implements c.a {

    public static class b implements e.b<c.b> {
        public b() {
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
        /* renamed from: b */
        public c.b a(int i10) {
            return new c.b(i10);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public e() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.c());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0591b
    public final void a(com.sigmob.sdk.downloader.f fVar, int i10, com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0591b
    public final void c(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
    }

    public e(com.sigmob.sdk.downloader.core.listener.assist.c cVar) {
        super(new com.sigmob.sdk.downloader.core.listener.assist.b(new b()));
        cVar.a(this);
        a(cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0591b
    public final void a(com.sigmob.sdk.downloader.f fVar, long j10) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0591b
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z10, b.c cVar2) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0591b
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b.c cVar) {
    }
}
