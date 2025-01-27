package com.kwad.components.ad.reward.f;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.v;

/* loaded from: classes.dex */
public final class a implements l {

    @Nullable
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.d.l
    public final boolean gW() {
        Context context = this.mContext;
        if (context == null) {
            return true;
        }
        v.c(this.mContext, context.getResources().getString(R.string.ksad_reward_playable_load_error_toast), 0L);
        return true;
    }
}
