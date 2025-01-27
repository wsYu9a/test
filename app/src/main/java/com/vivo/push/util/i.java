package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* loaded from: classes4.dex */
public final class i implements BaseNotifyLayoutAdapter {

    /* renamed from: a */
    private Resources f25124a;

    /* renamed from: b */
    private String f25125b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f25124a.getIdentifier("push_notify", "layout", this.f25125b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        if (j.f25128c) {
            resources = this.f25124a;
            str = "notify_icon_rom30";
        } else if (j.f25127b) {
            resources = this.f25124a;
            str = "notify_icon_rom20";
        } else {
            resources = this.f25124a;
            str = "notify_icon";
        }
        return resources.getIdentifier(str, "id", this.f25125b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i10;
        try {
            i10 = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            i10 = 0;
        }
        if (i10 > 0) {
            return this.f25124a.getColor(i10);
        }
        boolean z10 = j.f25128c;
        if (z10) {
            return -1;
        }
        if (!j.f25127b) {
            return -16777216;
        }
        if (z10) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f25125b = context.getPackageName();
        this.f25124a = context.getResources();
    }
}
