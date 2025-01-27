package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class a {
    private static volatile a VH;
    private com.kwad.sdk.utils.i VD;
    private List<WeakReference<OfflineOnAudioConflictListener>> VE = new ArrayList();
    private boolean VF = false;
    private boolean VG = false;

    /* renamed from: com.kwad.components.core.s.a$1 */
    public class AnonymousClass1 implements i.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            Iterator it = a.this.VE.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference == null) {
                    it.remove();
                } else {
                    OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                    if (offlineOnAudioConflictListener != null) {
                        offlineOnAudioConflictListener.onAudioBeOccupied();
                    } else {
                        it.remove();
                    }
                }
            }
            a.a(a.this, true);
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
            Iterator it = a.this.VE.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference == null) {
                    it.remove();
                } else {
                    OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                    if (offlineOnAudioConflictListener != null) {
                        offlineOnAudioConflictListener.onAudioBeReleased();
                    } else {
                        it.remove();
                    }
                }
            }
        }
    }

    private a(@NonNull Context context) {
        init(context);
    }

    public static a av(@NonNull Context context) {
        if (VH == null) {
            synchronized (a.class) {
                try {
                    if (VH == null) {
                        VH = new a(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return VH;
    }

    private void init(Context context) {
        this.VF = false;
        com.kwad.sdk.utils.i iVar = new com.kwad.sdk.utils.i(context);
        this.VD = iVar;
        iVar.c(new i.a() { // from class: com.kwad.components.core.s.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.VE.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.VE.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final boolean aO(boolean z10) {
        com.kwad.sdk.utils.i iVar = this.VD;
        if (iVar == null) {
            return false;
        }
        if (!z10 && this.VF) {
            return false;
        }
        this.VF = true;
        this.VG = false;
        return iVar.MR();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.VE.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean sa() {
        return this.VG;
    }

    public final boolean sb() {
        return this.VF;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.VG = true;
        return true;
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.VE.add(new WeakReference<>(offlineOnAudioConflictListener));
    }
}
