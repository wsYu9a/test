package com.kwad.components.ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.ad.g.b;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.d;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: classes.dex */
public final class a extends d implements com.kwad.components.ad.a.a {

    /* renamed from: com.kwad.components.ad.a$1 */
    final class AnonymousClass1 implements DialogInterface.OnDismissListener {
        final /* synthetic */ KsExitInstallListener bJ;

        AnonymousClass1(KsExitInstallListener ksExitInstallListener) {
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
    final class AnonymousClass2 implements DialogInterface.OnClickListener {
        final /* synthetic */ KsExitInstallListener bJ;

        AnonymousClass2(KsExitInstallListener ksExitInstallListener) {
            ksExitInstallListener = ksExitInstallListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            KsExitInstallListener ksExitInstallListener = ksExitInstallListener;
            if (ksExitInstallListener == null || i2 != -1) {
                return;
            }
            ksExitInstallListener.onInstallClick();
        }
    }

    @Override // com.kwad.components.ad.a.a
    public final String getBidRequestToken(KsScene ksScene) {
        return c.a(SceneImpl.covert(ksScene));
    }

    @Override // com.kwad.components.ad.a.a
    public final String getBidRequestTokenV2(KsScene ksScene) {
        return c.getBidRequestTokenV2(ksScene);
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.a.a.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
        b.lE().init();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        return -100;
    }

    @Override // com.kwad.components.ad.a.a
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        if (KsAdSDKImpl.get().hasInitFinish()) {
            return com.kwad.sdk.kwai.kwai.a.a(activity, new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.a.1
                final /* synthetic */ KsExitInstallListener bJ;

                AnonymousClass1(KsExitInstallListener ksExitInstallListener2) {
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
                final /* synthetic */ KsExitInstallListener bJ;

                AnonymousClass2(KsExitInstallListener ksExitInstallListener2) {
                    ksExitInstallListener = ksExitInstallListener2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                    if (ksExitInstallListener2 == null || i2 != -1) {
                        return;
                    }
                    ksExitInstallListener2.onInstallClick();
                }
            });
        }
        return false;
    }
}
