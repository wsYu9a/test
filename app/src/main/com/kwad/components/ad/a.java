package com.kwad.components.ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.kwad.components.ad.adbit.c;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;

/* loaded from: classes2.dex */
public final class a extends e implements com.kwad.components.ad.b.b {

    /* renamed from: com.kwad.components.ad.a$1 */
    public class AnonymousClass1 implements DialogInterface.OnDismissListener {
        final /* synthetic */ KsExitInstallListener bx;

        public AnonymousClass1(KsExitInstallListener ksExitInstallListener) {
            ksExitInstallListener = ksExitInstallListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            KsExitInstallListener ksExitInstallListener = ksExitInstallListener;
            if (ksExitInstallListener != null) {
                ksExitInstallListener.onDialogClose();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.a$2 */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {
        final /* synthetic */ KsExitInstallListener bx;

        public AnonymousClass2(KsExitInstallListener ksExitInstallListener) {
            ksExitInstallListener = ksExitInstallListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            KsExitInstallListener ksExitInstallListener = ksExitInstallListener;
            if (ksExitInstallListener == null || i10 != -1) {
                return;
            }
            ksExitInstallListener.onInstallClick();
        }
    }

    @Override // com.kwad.components.ad.b.b
    public final String getBidRequestToken(KsScene ksScene) {
        return c.a(SceneImpl.covert(ksScene));
    }

    @Override // com.kwad.components.ad.b.b
    public final String getBidRequestTokenV2(KsScene ksScene) {
        return c.getBidRequestTokenV2(ksScene);
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.b.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        com.kwad.components.ad.k.c.mT().init();
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return -100;
    }

    @Override // com.kwad.components.ad.b.b
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        if (l.At().zE()) {
            return com.kwad.sdk.a.a.a.a(activity, new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.a.1
                final /* synthetic */ KsExitInstallListener bx;

                public AnonymousClass1(KsExitInstallListener ksExitInstallListener2) {
                    ksExitInstallListener = ksExitInstallListener2;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                    if (ksExitInstallListener2 != null) {
                        ksExitInstallListener2.onDialogClose();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.kwad.components.ad.a.2
                final /* synthetic */ KsExitInstallListener bx;

                public AnonymousClass2(KsExitInstallListener ksExitInstallListener2) {
                    ksExitInstallListener = ksExitInstallListener2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                    if (ksExitInstallListener2 == null || i10 != -1) {
                        return;
                    }
                    ksExitInstallListener2.onInstallClick();
                }
            });
        }
        return false;
    }
}
