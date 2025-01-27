package com.czhj.volley.toolbox;

import com.czhj.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class HttpResponse {

    /* renamed from: a */
    public final int f8780a;

    /* renamed from: b */
    public final List<Header> f8781b;

    /* renamed from: c */
    public final int f8782c;

    /* renamed from: d */
    public final InputStream f8783d;

    public HttpResponse(int i10, List<Header> list) {
        this(i10, list, -1, null);
    }

    public final InputStream getContent() {
        return this.f8783d;
    }

    public final int getContentLength() {
        return this.f8782c;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.f8781b);
    }

    public final int getStatusCode() {
        return this.f8780a;
    }

    public HttpResponse(int i10, List<Header> list, int i11, InputStream inputStream) {
        this.f8780a = i10;
        this.f8781b = list;
        this.f8782c = i11;
        this.f8783d = inputStream;
    }
}
