package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class k implements IVibratorUtil {
    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void cancelVibrate(Context context, Vibrator vibrator) {
        bi.b(context, vibrator);
    }

    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void vibrate(Context context, Vibrator vibrator, long j2) {
        bi.vibrate(context, vibrator, j2);
    }
}
