package com.wbl.ad.yzz.dialog;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends PopupWindow {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@f.b.a.d View contentView, int i2, int i3, boolean z) {
        super(contentView, i2, i3, z);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
    }

    @Override // android.widget.PopupWindow
    public boolean isShowing() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14523, this, null);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i2, int i3, int i4) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14518, this, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
