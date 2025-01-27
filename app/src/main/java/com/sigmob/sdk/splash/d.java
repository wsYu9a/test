package com.sigmob.sdk.splash;

import android.content.Context;
import android.widget.RelativeLayout;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: classes4.dex */
public class d extends RelativeLayout {

    /* renamed from: a */
    public int f20309a;

    public d(Context context) {
        super(context);
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
        setVisibility(0);
    }

    public int getDuration() {
        return this.f20309a;
    }

    public boolean a(BaseAdUnit baseAdUnit) {
        return false;
    }

    public static d a(Context context, BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getMaterial().creative_type == null) {
            return null;
        }
        return baseAdUnit.getMaterial().creative_type.intValue() == m.CreativeTypeSplashVideo.b() ? new h(context, baseAdUnit) : new e(context);
    }
}
