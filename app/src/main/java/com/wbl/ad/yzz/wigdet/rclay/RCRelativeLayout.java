package com.wbl.ad.yzz.wigdet.rclay;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.j.a;
import com.wbl.ad.yzz.wigdet.j.b;

/* loaded from: classes5.dex */
public class RCRelativeLayout extends RelativeLayout implements Checkable, a {

    /* renamed from: a */
    public b f34642a;

    public RCRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7845, this, canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7848, this, motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7847, this, canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7842, this, null);
    }

    public float getBottomLeftRadius() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-7841, this, null);
    }

    public float getBottomRightRadius() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-7844, this, null);
    }

    public int getStrokeColor() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7843, this, null);
    }

    public int getStrokeWidth() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7870, this, null);
    }

    public float getTopLeftRadius() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-7869, this, null);
    }

    public float getTopRightRadius() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-7872, this, null);
    }

    @Override // android.view.View
    public void invalidate() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7871, this, null);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7866, this, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7865, this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public void setBottomLeftRadius(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7868, this, Integer.valueOf(i2));
    }

    public void setBottomRightRadius(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7867, this, Integer.valueOf(i2));
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7862, this, Boolean.valueOf(z));
    }

    public void setClipBackground(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7861, this, Boolean.valueOf(z));
    }

    public void setOnCheckedChangeListener(b.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7864, this, aVar);
    }

    public void setRadius(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7863, this, Integer.valueOf(i2));
    }

    public void setRoundAsCircle(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7858, this, Boolean.valueOf(z));
    }

    @Override // com.wbl.ad.yzz.wigdet.j.a
    public void setStrokeColor(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7857, this, Integer.valueOf(i2));
    }

    public void setStrokeWidth(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7860, this, Integer.valueOf(i2));
    }

    public void setTopLeftRadius(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7859, this, Integer.valueOf(i2));
    }

    public void setTopRightRadius(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7822, this, Integer.valueOf(i2));
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7821, this, null);
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b bVar = new b();
        this.f34642a = bVar;
        bVar.a(context, attributeSet);
    }
}
