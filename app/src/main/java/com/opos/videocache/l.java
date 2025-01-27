package com.opos.videocache;

import java.io.File;

/* loaded from: classes4.dex */
class l {

    /* renamed from: a */
    public final File f23819a;

    /* renamed from: b */
    public final com.opos.videocache.a.c f23820b;

    /* renamed from: c */
    public final com.opos.videocache.a.a f23821c;

    /* renamed from: d */
    public final com.opos.videocache.c.b f23822d;

    /* renamed from: e */
    public final com.opos.videocache.b.b f23823e;

    l(File file, com.opos.videocache.a.c cVar, com.opos.videocache.a.a aVar, com.opos.videocache.c.b bVar, com.opos.videocache.b.b bVar2) {
        this.f23819a = file;
        this.f23820b = cVar;
        this.f23821c = aVar;
        this.f23822d = bVar;
        this.f23823e = bVar2;
    }

    File a(String str) {
        return new File(this.f23819a, this.f23820b.a(str));
    }
}
