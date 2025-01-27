package com.ss.android.downloadlib.zx;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: com.ss.android.downloadlib.zx.zx$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24399j;
        final /* synthetic */ lg zx;

        /* renamed from: com.ss.android.downloadlib.zx.zx$1$1 */
        class C05051 implements y {
            C05051() {
            }

            @Override // com.ss.android.downloadlib.zx.y
            public void j(boolean z) {
                lgVar.j(z);
            }
        }

        AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar, lg lgVar) {
            zxVar = zxVar;
            lgVar = lgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.j(zxVar)) {
                lgVar.j(false);
            } else if (gv.j(zxVar)) {
                gv.j(zxVar, new y() { // from class: com.ss.android.downloadlib.zx.zx.1.1
                    C05051() {
                    }

                    @Override // com.ss.android.downloadlib.zx.y
                    public void j(boolean z) {
                        lgVar.j(z);
                    }
                });
            } else {
                lgVar.j(false);
            }
        }
    }

    public void j(@NonNull com.ss.android.downloadad.api.j.zx zxVar, @NonNull lg lgVar, int i2) {
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.zx.zx.1

            /* renamed from: j */
            final /* synthetic */ com.ss.android.downloadad.api.j.zx f24399j;
            final /* synthetic */ lg zx;

            /* renamed from: com.ss.android.downloadlib.zx.zx$1$1 */
            class C05051 implements y {
                C05051() {
                }

                @Override // com.ss.android.downloadlib.zx.y
                public void j(boolean z) {
                    lgVar.j(z);
                }
            }

            AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar2, lg lgVar2) {
                zxVar = zxVar2;
                lgVar = lgVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (k.j(zxVar)) {
                    lgVar.j(false);
                } else if (gv.j(zxVar)) {
                    gv.j(zxVar, new y() { // from class: com.ss.android.downloadlib.zx.zx.1.1
                        C05051() {
                        }

                        @Override // com.ss.android.downloadlib.zx.y
                        public void j(boolean z) {
                            lgVar.j(z);
                        }
                    });
                } else {
                    lgVar.j(false);
                }
            }
        }, i2);
    }
}
