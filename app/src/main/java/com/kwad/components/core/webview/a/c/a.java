package com.kwad.components.core.webview.a.c;

import com.kwad.components.core.webview.a.d.e;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class a {
    private final Set<e> VG;

    /* renamed from: com.kwad.components.core.webview.a.c.a$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String gB;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.aQ(str);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.c.a$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String gB;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.aR(str);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.c.a$a */
    static class C0188a {
        private static final a VI = new a((byte) 0);
    }

    private a() {
        this.VG = new CopyOnWriteArraySet();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public void aQ(String str) {
        if (this.VG.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.VG).iterator();
        while (it.hasNext()) {
            ((e) it.next()).u(str);
        }
    }

    public void aR(String str) {
        if (this.VG.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.VG).iterator();
        while (it.hasNext()) {
            ((e) it.next()).ad(str);
        }
    }

    public static a rn() {
        return C0188a.VI;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.VG.add(eVar);
        }
    }

    public final void aS(String str) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.c.a.1
            final /* synthetic */ String gB;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.aQ(str);
            }
        });
    }

    public final void aT(String str) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.c.a.2
            final /* synthetic */ String gB;

            AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.aR(str);
            }
        });
    }

    public final void b(e eVar) {
        this.VG.remove(eVar);
    }

    public final void ro() {
        this.VG.clear();
    }
}
