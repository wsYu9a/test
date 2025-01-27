package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class cr extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7114a = "ContainerView";

    /* renamed from: b, reason: collision with root package name */
    private a f7115b;

    public interface a {
        void dispatchTouchEvent(MotionEvent motionEvent);

        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i10, KeyEvent keyEvent);

        void onLayoutComplete(int i10, int i11);

        void onWindowFocusChanged(boolean z10);

        void onWindowVisibilityChanged(int i10);
    }

    public cr(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f7115b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f7115b;
        if (aVar != null) {
            aVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f7115b;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f7115b;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        a aVar = this.f7115b;
        if (aVar != null) {
            return aVar.onKeyDown(i10, keyEvent);
        }
        super.onKeyDown(i10, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        a aVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || (aVar = this.f7115b) == null) {
            return;
        }
        aVar.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        a aVar = this.f7115b;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        a aVar = this.f7115b;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i10);
        }
    }
}
