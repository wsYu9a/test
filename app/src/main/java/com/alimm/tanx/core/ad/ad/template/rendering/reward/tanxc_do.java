package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: classes.dex */
public class tanxc_do {
    public static String tanxc_do(PlayerState playerState) {
        return (playerState == PlayerState.IDLE || playerState == PlayerState.INITIALIZED || playerState == PlayerState.PREPARING) ? "preparing" : playerState == PlayerState.PREPARED ? PointCategory.READY : playerState == PlayerState.STARTED ? "playing" : (playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) ? "pausing" : playerState == PlayerState.ERROR ? "error" : (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) ? PointCategory.END : "unknown";
    }

    public static String tanxc_do(PlayerBufferingState playerBufferingState) {
        if (playerBufferingState == PlayerBufferingState.BUFFERING_START) {
            return "buffering";
        }
        return "playing";
    }
}
