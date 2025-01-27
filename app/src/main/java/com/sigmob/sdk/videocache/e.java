package com.sigmob.sdk.videocache;

import java.io.File;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public final File f20582a;

    /* renamed from: b */
    public final com.sigmob.sdk.videocache.file.c f20583b;

    /* renamed from: c */
    public final com.sigmob.sdk.videocache.file.a f20584c;

    /* renamed from: d */
    public final com.sigmob.sdk.videocache.sourcestorage.c f20585d;

    /* renamed from: e */
    public final com.sigmob.sdk.videocache.headers.b f20586e;

    public e(File file, com.sigmob.sdk.videocache.file.c cVar, com.sigmob.sdk.videocache.file.a aVar, com.sigmob.sdk.videocache.sourcestorage.c cVar2, com.sigmob.sdk.videocache.headers.b bVar) {
        this.f20582a = file;
        this.f20583b = cVar;
        this.f20584c = aVar;
        this.f20585d = cVar2;
        this.f20586e = bVar;
    }

    public File a(String str) {
        return new File(this.f20582a, this.f20583b.a(str));
    }
}
