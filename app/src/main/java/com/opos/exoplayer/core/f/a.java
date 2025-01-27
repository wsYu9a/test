package com.opos.exoplayer.core.f;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final a f18552a = new a(-1, -16777216, 0, 0, -1, null);

    /* renamed from: b */
    public final int f18553b;

    /* renamed from: c */
    public final int f18554c;

    /* renamed from: d */
    public final int f18555d;

    /* renamed from: e */
    public final int f18556e;

    /* renamed from: f */
    public final int f18557f;

    /* renamed from: g */
    public final Typeface f18558g;

    public a(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        this.f18553b = i2;
        this.f18554c = i3;
        this.f18555d = i4;
        this.f18556e = i5;
        this.f18557f = i6;
        this.f18558g = typeface;
    }

    @TargetApi(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return u.f19078a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @TargetApi(19)
    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f18552a.f18553b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f18552a.f18554c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f18552a.f18555d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f18552a.f18556e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f18552a.f18557f, captionStyle.getTypeface());
    }
}
