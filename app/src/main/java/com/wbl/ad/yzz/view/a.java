package com.wbl.ad.yzz.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.e;

/* loaded from: classes5.dex */
public final class a extends GestureDetector {

    /* renamed from: a */
    @e
    public final InterfaceGestureDetectorOnGestureListenerC0795a f34395a;

    /* renamed from: com.wbl.ad.yzz.view.a$a */
    public interface InterfaceGestureDetectorOnGestureListenerC0795a extends GestureDetector.OnGestureListener {
        void a(@e MotionEvent motionEvent);
    }

    public a(@e Context context, @e InterfaceGestureDetectorOnGestureListenerC0795a interfaceGestureDetectorOnGestureListenerC0795a) {
        super(context, interfaceGestureDetectorOnGestureListenerC0795a);
        this.f34395a = interfaceGestureDetectorOnGestureListenerC0795a;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8406, this, motionEvent);
    }
}
