package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a */
    private ViewStatusListener f16496a;

    /* renamed from: b */
    private ViewStatus f16497b;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1 */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16498a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f16498a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16498a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f16497b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f16496a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f16497b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f16496a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f16497b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f16496a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z10);
        ViewStatusListener viewStatusListener = this.f16496a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i10);
        ViewStatusListener viewStatusListener = this.f16496a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i10);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f16496a = viewStatusListener;
        if (viewStatusListener != null) {
            int ordinal = this.f16497b.ordinal();
            if (ordinal == 1) {
                this.f16496a.onAttachToWindow();
            } else {
                if (ordinal != 2) {
                    return;
                }
                this.f16496a.onDetachFromWindow();
            }
        }
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16497b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16497b = ViewStatus.INIT;
    }
}
