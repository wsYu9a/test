package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class AdBaseFrameLayout extends FrameLayout implements d, e {
    private static final ag.a aHa = new ag.a();
    private List<View.OnTouchListener> aGY;
    private c aGZ;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.aGY = new ArrayList();
        this.aGZ = new c();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (this.aGY.contains(onTouchListener)) {
            return;
        }
        this.aGY.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            com.kwad.sdk.service.c.gatherException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aGY.isEmpty()) {
            Iterator<View.OnTouchListener> it = this.aGY.iterator();
            while (it.hasNext()) {
                it.next().onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ag.a aVar = aHa;
            aVar.z(getWidth(), getHeight());
            aVar.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aHa.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public ag.a getTouchCoords() {
        return aHa;
    }

    @Override // com.kwad.sdk.core.view.d
    @NonNull
    public c getWindowFocusChangeHelper() {
        return this.aGZ;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        com.kwad.sdk.core.d.c.d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z10);
        this.aGZ.j(this, z10);
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGY = new ArrayList();
        this.aGZ = new c();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aGY = new ArrayList();
        this.aGZ = new c();
    }
}
