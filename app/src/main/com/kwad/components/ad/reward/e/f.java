package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class f {
    private static final HashMap<String, f> sU = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.i.d pU;
    private KsRewardVideoAd.RewardAdInteractionListener sV;

    @Nullable
    private static f I(String str) {
        return sU.get(str);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener J(String str) {
        f I = I(str);
        if (I != null) {
            return I.sV;
        }
        return null;
    }

    public static void K(String str) {
        f I = I(str);
        if (I != null) {
            I.sV = I.mInteractionListener;
        }
    }

    public static com.kwad.components.core.i.d L(String str) {
        f I = I(str);
        if (I != null) {
            return I.pU;
        }
        return null;
    }

    public static void M(String str) {
        f I = I(str);
        if (I != null) {
            I.destroy();
            sU.put(str, null);
        }
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.pU = dVar;
        fVar.sV = rewardAdInteractionListener;
        sU.put(str, fVar);
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.sV = null;
        com.kwad.components.core.i.d dVar = this.pU;
        if (dVar != null) {
            dVar.destroy();
            this.pU = null;
        }
    }
}
