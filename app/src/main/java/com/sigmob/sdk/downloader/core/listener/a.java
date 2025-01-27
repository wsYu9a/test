package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.a;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class a implements com.sigmob.sdk.downloader.c, a.InterfaceC0590a, com.sigmob.sdk.downloader.core.listener.assist.d {

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.core.listener.assist.a f19321a;

    public a() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.a());
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void d(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
    }

    public a(com.sigmob.sdk.downloader.core.listener.assist.a aVar) {
        this.f19321a = aVar;
        aVar.a(this);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i10, long j10) {
        this.f19321a.a(fVar, j10);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z10) {
        this.f19321a.b(z10);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i10, int i11, Map<String, List<String>> map) {
        this.f19321a.a(fVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        this.f19321a.a(fVar, cVar, bVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f19321a.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f19321a.a();
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z10) {
        this.f19321a.a(z10);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.f19321a.a(fVar, aVar, exc);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar) {
        this.f19321a.b(fVar);
    }
}
