package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* loaded from: classes4.dex */
public final class i implements BaseNotifyLayoutAdapter {

    /* renamed from: a */
    private Resources f31088a;

    /* renamed from: b */
    private String f31089b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f31088a.getIdentifier("push_notify", "layout", this.f31089b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (j.f31092c) {
            resources = this.f31088a;
            str = this.f31089b;
            str2 = "notify_icon_rom30";
        } else if (j.f31091b) {
            resources = this.f31088a;
            str = this.f31089b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f31088a;
            str = this.f31089b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i2;
        try {
            i2 = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 > 0) {
            return this.f31088a.getColor(i2);
        }
        boolean z = j.f31092c;
        if (z) {
            return -1;
        }
        if (!j.f31091b) {
            return -16777216;
        }
        if (z) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f31089b = context.getPackageName();
        this.f31088a = context.getResources();
    }
}
