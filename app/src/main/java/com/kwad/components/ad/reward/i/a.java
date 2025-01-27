package com.kwad.components.ad.reward.i;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.n;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.z;

/* loaded from: classes2.dex */
public final class a implements n {

    @Nullable
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.e.n
    public final boolean ho() {
        Context context = this.mContext;
        if (context == null) {
            return true;
        }
        z.c(this.mContext, context.getResources().getString(R.string.ksad_reward_playable_load_error_toast), 0L);
        return true;
    }
}
