package com.kwad.components.core.webview.tachikoma.d;

import com.kwad.components.core.webview.tachikoma.e.f;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class b {
    private final Set<f> aeb;

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aec;
        final /* synthetic */ String aed;

        public AnonymousClass1(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.r(str, str2);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.b$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ long NU;
        final /* synthetic */ String aec;
        final /* synthetic */ long aef;
        final /* synthetic */ long aeg;

        public AnonymousClass2(String str, long j10, long j11, long j12) {
            str = str;
            j10 = j10;
            j11 = j11;
            j12 = j12;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.b(str, j10, j11, j12);
        }
    }

    public static class a {
        private static final b aeh = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public void r(String str, String str2) {
        if (this.aeb.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.aeb).iterator();
        while (it.hasNext()) {
            ((f) it.next()).s(str2);
        }
    }

    public static b uj() {
        return a.aeh;
    }

    public final void b(f fVar) {
        this.aeb.remove(fVar);
    }

    public final void c(String str, long j10, long j11, long j12) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.d.b.2
            final /* synthetic */ long NU;
            final /* synthetic */ String aec;
            final /* synthetic */ long aef;
            final /* synthetic */ long aeg;

            public AnonymousClass2(String str2, long j102, long j112, long j122) {
                str = str2;
                j10 = j102;
                j11 = j112;
                j12 = j122;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.b(str, j10, j11, j12);
            }
        });
    }

    public final void s(String str, String str2) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.d.b.1
            final /* synthetic */ String aec;
            final /* synthetic */ String aed;

            public AnonymousClass1(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.r(str, str2);
            }
        });
    }

    public final void uk() {
        this.aeb.clear();
    }

    private b() {
        this.aeb = new CopyOnWriteArraySet();
    }

    public void b(String str, long j10, long j11, long j12) {
        if (this.aeb.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.aeb).iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(str, j10, j11, j12);
        }
    }

    public final void a(f fVar) {
        if (fVar != null) {
            this.aeb.add(fVar);
        }
    }
}
