package com.vivo.mobilead.unified.base.view.p;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.ad.e.d;
import com.vivo.ad.e.e;
import com.vivo.ad.model.f;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public abstract class d extends FrameLayout {

    /* renamed from: a */
    protected com.vivo.mobilead.unified.base.callback.b f29968a;

    /* renamed from: b */
    protected String f29969b;

    /* renamed from: c */
    protected int f29970c;

    /* renamed from: d */
    protected int f29971d;

    /* renamed from: e */
    protected int f29972e;

    /* renamed from: f */
    protected int f29973f;

    /* renamed from: g */
    protected int f29974g;

    /* renamed from: h */
    protected boolean f29975h;

    /* renamed from: i */
    protected e f29976i;

    class a implements d.InterfaceC0555d {
        a() {
        }

        @Override // com.vivo.ad.e.d.InterfaceC0555d
        public void a(String str, boolean z) {
            d.this.f29975h = z;
        }
    }

    public d(@NonNull Context context) {
        super(context);
    }

    protected String a(com.vivo.ad.model.b bVar) {
        f f2;
        return (bVar == null || (f2 = bVar.f()) == null) ? "" : f2.d();
    }

    public void a() {
    }

    public abstract void a(com.vivo.ad.model.b bVar, int i2);

    public void b() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f29970c = (int) motionEvent.getRawX();
            this.f29971d = (int) motionEvent.getRawY();
            this.f29972e = (int) motionEvent.getX();
            this.f29973f = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public abstract int getDefaultHeight();

    public abstract int getDefaultWidth();

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setBannerClickListener(com.vivo.mobilead.unified.base.callback.b bVar) {
        this.f29968a = bVar;
    }

    public void setSourceAppend(String str) {
        this.f29969b = str;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    protected e a(ViewGroup viewGroup, com.vivo.ad.model.b bVar) {
        e.g gVar = new e.g(getContext(), bVar, this.f29969b);
        gVar.a(new a());
        gVar.a(this.f29975h);
        e eVar = this.f29976i;
        if (eVar == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = m.a(getContext(), 15.0f);
            layoutParams.topMargin = m.a(getContext(), 3.0f);
            e b2 = gVar.b();
            this.f29976i = b2;
            b2.setId(y0.a());
            viewGroup.addView(this.f29976i, layoutParams);
        } else {
            eVar.a(gVar, this.f29975h);
        }
        return this.f29976i;
    }
}
