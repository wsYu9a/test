package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class b {
    private final List<a> TW;

    public interface a {
        void rp();
    }

    /* renamed from: com.kwad.components.core.request.b$b */
    public static class C0444b {
        private static final b TX = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b rn() {
        return C0444b.TX;
    }

    public final void a(a aVar) {
        this.TW.add(aVar);
    }

    public final void b(a aVar) {
        this.TW.remove(aVar);
    }

    public final void ro() {
        for (a aVar : this.TW) {
            if (aVar != null) {
                try {
                    aVar.rp();
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        }
    }

    private b() {
        this.TW = new CopyOnWriteArrayList();
    }
}
