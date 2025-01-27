package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: classes4.dex */
public class c extends IOException {

    /* renamed from: a */
    public static final c f19267a = new a();

    public class a extends c {
        public a() {
            super(null);
        }

        @Override // java.lang.Throwable
        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    }

    public c() {
        super("Interrupted");
    }

    public /* synthetic */ c(a aVar) {
        this();
    }
}
