package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class a {
    private String TH;
    private long TI;
    private long TJ;
    private long TK;
    private boolean TL;

    @Nullable
    private c TM;

    /* renamed from: com.kwad.components.core.proxy.a.a$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.TK = SystemClock.uptimeMillis();
            a.this.report();
        }
    }

    public a(@Nullable c cVar) {
        this.TM = cVar;
    }

    public final void G(long j10) {
        this.TI = j10;
        this.TJ = SystemClock.uptimeMillis();
    }

    public final void ax(String str) {
        this.TH = str;
    }

    public final void report() {
        b bVar = new b();
        bVar.TH = this.TH;
        long j10 = this.TI;
        bVar.TP = j10 != 0 ? this.TJ - j10 : 0L;
        long j11 = this.TJ;
        bVar.TQ = j11 != 0 ? this.TK - j11 : 0L;
        bVar.TO = j10 != 0 ? this.TK - j10 : 0L;
        com.kwad.components.core.o.a.ri().a(bVar);
        com.kwad.sdk.core.d.c.d("PageMonitor", bVar.toString());
    }

    public final void rh() {
        if (this.TL) {
            return;
        }
        this.TL = true;
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.proxy.a.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.TK = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.TM;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }
}
