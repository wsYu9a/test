package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class d implements com.sigmob.sdk.downloader.c, b.InterfaceC0591b, com.sigmob.sdk.downloader.core.listener.assist.d {

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.core.listener.assist.b f19346a;

    public static class a implements e.b<b.c> {
        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
        /* renamed from: b */
        public b.c a(int i10) {
            return new b.c(i10);
        }
    }

    public d() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.b(new a()));
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void d(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
        this.f19346a.a(fVar, i10);
    }

    public d(com.sigmob.sdk.downloader.core.listener.assist.b bVar) {
        this.f19346a = bVar;
        bVar.a(this);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void b(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
        this.f19346a.a(fVar, i10, j10);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        this.f19346a.a(fVar, cVar, false);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z10) {
        this.f19346a.b(z10);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f19346a.a(fVar, cVar, true);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f19346a.a();
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z10) {
        this.f19346a.a(z10);
    }

    public void a(b.a aVar) {
        this.f19346a.a(aVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.f19346a.a(fVar, aVar, exc);
    }
}
