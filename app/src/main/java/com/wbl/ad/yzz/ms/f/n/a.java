package com.wbl.ad.yzz.ms.f.n;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class a extends FrameLayout {

    /* renamed from: a */
    public b f33285a;

    public a(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11369, this, motionEvent);
    }

    public void setTouchPositionListener(b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11372, this, bVar);
    }
}
