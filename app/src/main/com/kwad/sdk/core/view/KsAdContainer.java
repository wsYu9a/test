package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.ag;

/* loaded from: classes3.dex */
public class KsAdContainer extends RelativeLayout {
    protected ag.a aHa;

    public KsAdContainer(Context context) {
        super(context);
        this.aHa = new ag.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ag.a aVar = new ag.a(getWidth(), getHeight());
            this.aHa = aVar;
            aVar.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aHa.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public ag.a getTouchCoords() {
        return this.aHa;
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHa = new ag.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aHa = new ag.a();
    }
}
