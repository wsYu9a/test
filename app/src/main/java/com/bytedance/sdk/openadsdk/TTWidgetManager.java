package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.c.a.a.q;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class TTWidgetManager {
    public static TTWidgetManager create(View view) {
        if (view == null) {
            return null;
        }
        Bridge bridge = view.getTag() instanceof Bridge ? (Bridge) view.getTag() : null;
        if (bridge == null) {
            return null;
        }
        return new q(bridge);
    }

    public abstract boolean updateWidgetWithType(int i10, JSONObject jSONObject);
}
