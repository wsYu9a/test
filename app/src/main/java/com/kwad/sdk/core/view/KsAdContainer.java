package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.ac;

/* loaded from: classes2.dex */
public class KsAdContainer extends RelativeLayout {
    protected ac.a mTouchCoords;

    public KsAdContainer(Context context) {
        super(context);
        this.mTouchCoords = new ac.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchCoords = new ac.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTouchCoords = new ac.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ac.a aVar = new ac.a(getWidth(), getHeight());
            this.mTouchCoords = aVar;
            aVar.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.mTouchCoords.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public ac.a getTouchCoords() {
        return this.mTouchCoords;
    }
}
