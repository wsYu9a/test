package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class a implements com.kwad.sdk.core.h.a, bx.a {
    private Set<c> afA;
    private final int afB;
    private final AtomicBoolean afz = new AtomicBoolean(false);
    protected final bx bO = new bx(this);
    private final View mRootView;

    /* renamed from: com.kwad.components.core.widget.a.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ c afC;

        public AnonymousClass1(c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (a.this.ad()) {
                cVar.bl();
            } else {
                cVar.bm();
            }
        }
    }

    public a(@NonNull View view, int i10) {
        this.mRootView = view;
        this.afB = i10;
    }

    private void ba(boolean z10) {
        Set<c> set = this.afA;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z10) {
                    cVar.bl();
                } else {
                    cVar.bm();
                }
            }
        }
    }

    private void jt() {
        if (this.afz.getAndSet(true)) {
            return;
        }
        ba(true);
    }

    private void uD() {
        if (ad()) {
            jt();
        } else {
            uG();
        }
    }

    private void uG() {
        if (this.afz.getAndSet(false)) {
            ba(false);
        }
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (message.what == 666) {
            uD();
            this.bO.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    public abstract boolean ad();

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void b(c cVar) {
        Set<c> set;
        am.checkUiThread();
        if (cVar == null || (set = this.afA) == null) {
            return;
        }
        set.remove(cVar);
    }

    @Override // com.kwad.sdk.core.h.a
    @CallSuper
    public final void release() {
        uF();
        Set<c> set = this.afA;
        if (set != null) {
            set.clear();
        }
    }

    public final void uE() {
        this.bO.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.bO.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    public final void uF() {
        uD();
        this.bO.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final boolean uH() {
        return this.afz.get();
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void a(c cVar) {
        am.checkUiThread();
        if (cVar == null) {
            return;
        }
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.core.widget.a.a.1
            final /* synthetic */ c afC;

            public AnonymousClass1(c cVar2) {
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (a.this.ad()) {
                    cVar.bl();
                } else {
                    cVar.bm();
                }
            }
        });
        if (this.afA == null) {
            this.afA = new HashSet();
        }
        this.afA.add(cVar2);
    }
}
