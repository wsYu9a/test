package com.jd.ad.sdk.nativead;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface JADNativeInteractionListener {
    void onClick(View view);

    void onClose(@Nullable View view);

    void onExposure();
}
