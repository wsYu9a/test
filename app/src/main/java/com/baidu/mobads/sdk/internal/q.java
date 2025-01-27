package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q implements ICommonModuleObj {

    /* renamed from: a */
    private static volatile q f5845a;

    /* renamed from: b */
    private CustomNotification f5846b = new CustomNotification();

    private q() {
    }

    public static q a() {
        if (f5845a == null) {
            synchronized (q.class) {
                if (f5845a == null) {
                    f5845a = new q();
                }
            }
        }
        return f5845a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        return this.f5846b.getCustomNotification((Context) jSONObject.opt("context"), jSONObject.optString("channelId"), jSONObject.optString("ticker"), (Bitmap) jSONObject.opt("icon"), jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optString("status"), jSONObject.optBoolean("autoCancel"), jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS), jSONObject.optInt("smallIcon"), jSONObject.optString("action"), (PendingIntent) jSONObject.opt("pendingIntent"));
    }
}
