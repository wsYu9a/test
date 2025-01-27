package com.kwad.components.core.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    private static volatile a PO;
    private com.kwad.sdk.utils.h PK;
    private List<WeakReference<OfflineOnAudioConflictListener>> PL = new ArrayList();
    private boolean PM = false;
    private boolean PN = false;

    /* renamed from: com.kwad.components.core.r.a$1 */
    final class AnonymousClass1 implements h.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            OfflineOnAudioConflictListener offlineOnAudioConflictListener;
            Iterator it = a.this.PL.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                    it.remove();
                } else {
                    offlineOnAudioConflictListener.onAudioBeOccupied();
                }
            }
            a.a(a.this, true);
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
            OfflineOnAudioConflictListener offlineOnAudioConflictListener;
            Iterator it = a.this.PL.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                    it.remove();
                } else {
                    offlineOnAudioConflictListener.onAudioBeReleased();
                }
            }
        }
    }

    private a(@NonNull Context context) {
        init(context);
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.PN = true;
        return true;
    }

    public static a aj(@NonNull Context context) {
        if (PO == null) {
            synchronized (a.class) {
                if (PO == null) {
                    PO = new a(context.getApplicationContext());
                }
            }
        }
        return PO;
    }

    private void init(Context context) {
        this.PM = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.PK = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.r.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                OfflineOnAudioConflictListener offlineOnAudioConflictListener;
                Iterator it = a.this.PL.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        offlineOnAudioConflictListener.onAudioBeOccupied();
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                OfflineOnAudioConflictListener offlineOnAudioConflictListener;
                Iterator it = a.this.PL.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        offlineOnAudioConflictListener.onAudioBeReleased();
                    }
                }
            }
        });
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.PL.add(new WeakReference<>(offlineOnAudioConflictListener));
    }

    public final boolean aL(boolean z) {
        com.kwad.sdk.utils.h hVar = this.PK;
        if (hVar == null) {
            return false;
        }
        if (!z && this.PM) {
            return false;
        }
        this.PM = true;
        this.PN = false;
        return hVar.CQ();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.PL.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean pI() {
        return this.PN;
    }

    public final boolean pJ() {
        return this.PM;
    }
}
