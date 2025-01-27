package com.kwad.components.ad.reward.b;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {
    public static void a(b bVar, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null || bVar == null) {
            return;
        }
        try {
            rewardAdInteractionListener.onExtraRewardVerify(bVar.getType());
        } catch (Throwable unused) {
        }
    }

    public static boolean a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (rewardAdInteractionListener == null) {
            return false;
        }
        try {
            for (Method method : rewardAdInteractionListener.getClass().getMethods()) {
                if ("onExtraRewardVerify".equals(method.getName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static b gU() {
        return new b(1);
    }
}
