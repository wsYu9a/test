package com.kwad.sdk.utils;

import android.view.MotionEvent;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import java.util.List;

/* loaded from: classes3.dex */
public final class b {
    public static boolean a(ag.a aVar, List<Integer> list) {
        int abs = Math.abs(aVar.NK() - aVar.NM());
        int abs2 = Math.abs(aVar.NL() - aVar.NN());
        if (list == null || list.isEmpty() || list.size() < 2) {
            return abs > 20 || abs2 > 20;
        }
        int atan2 = (int) ((Math.atan2(abs2, abs) * 180.0d) / 3.141592653589793d);
        return atan2 > list.get(0).intValue() && atan2 < list.get(1).intValue();
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, AdTemplate adTemplate) {
        boolean z10 = false;
        if (adTemplate == null || !com.kwad.sdk.core.response.b.d.dQ(adTemplate)) {
            return false;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        float abs = Math.abs(motionEvent2.getRawX() - motionEvent.getRawX());
        float abs2 = Math.abs(motionEvent2.getRawY() - motionEvent.getRawY());
        List<Integer> U = com.kwad.sdk.core.response.b.a.U(eb2);
        if (U == null || U.isEmpty() || U.size() < 2) {
            return abs > 20.0f || abs2 > 20.0f;
        }
        int atan2 = (int) ((Math.atan2(abs2, abs) * 180.0d) / 3.141592653589793d);
        if (atan2 > U.get(0).intValue() && atan2 < U.get(1).intValue()) {
            z10 = true;
        }
        if (z10) {
            adTemplate.swipeAngle = atan2;
        }
        return z10;
    }
}
