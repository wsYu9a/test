package com.kwad.components.ad.a;

import android.app.Activity;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;

/* loaded from: classes.dex */
public interface a extends com.kwad.sdk.components.a {
    String getBidRequestToken(KsScene ksScene);

    String getBidRequestTokenV2(KsScene ksScene);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}
