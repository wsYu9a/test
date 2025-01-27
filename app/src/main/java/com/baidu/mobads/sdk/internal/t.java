package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class t implements ICommonModuleObj {

    /* renamed from: a */
    private static volatile t f7249a;

    /* renamed from: b */
    private CustomNotification f7250b = new CustomNotification();

    /* renamed from: c */
    private com.baidu.mobads.sdk.internal.b.a f7251c = new com.baidu.mobads.sdk.internal.b.a();

    private t() {
    }

    public static t a() {
        if (f7249a == null) {
            synchronized (t.class) {
                try {
                    if (f7249a == null) {
                        f7249a = new t();
                    }
                } finally {
                }
            }
        }
        return f7249a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str)) {
            if (ICommonModuleObj.KEY_RESOURCES.equals(str)) {
                return this.f7251c;
            }
            return null;
        }
        if (jSONObject == null) {
            return null;
        }
        Context context = (Context) jSONObject.opt(com.umeng.analytics.pro.f.X);
        int optInt = jSONObject.optInt("version", 0);
        String optString = jSONObject.optString(URLPackage.KEY_CHANNEL_ID);
        String optString2 = jSONObject.optString("ticker");
        Bitmap bitmap = (Bitmap) jSONObject.opt("icon");
        String optString3 = jSONObject.optString("title");
        String optString4 = jSONObject.optString("content");
        String optString5 = jSONObject.optString("status");
        boolean optBoolean = jSONObject.optBoolean("autoCancel");
        int optInt2 = jSONObject.optInt("progress");
        boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int optInt3 = jSONObject.optInt("smallIcon");
        String optString6 = jSONObject.optString("action");
        PendingIntent pendingIntent = (PendingIntent) jSONObject.opt("pendingIntent");
        return optInt == 1 ? this.f7250b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, jSONObject.optString("action2"), (PendingIntent) jSONObject.opt("pendingIntent2")) : this.f7250b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
    }
}
