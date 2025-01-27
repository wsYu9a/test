package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public class FlowAdFrameLayout extends FrameLayout {

    /* renamed from: b */
    public a f15812b;

    /* renamed from: c */
    public boolean f15813c;

    public interface a {
        void a();
    }

    public FlowAdFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        View findViewById = findViewById(R.id.mis_click_view);
        if (motionEvent.getAction() == 1 && (aVar = this.f15812b) != null) {
            aVar.a();
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (getHeight() - motionEvent.getY() > findViewById.getHeight()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f15813c) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            this.f15813c = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setAdTouchListener(a aVar) {
        this.f15812b = aVar;
    }

    public void setTouched(boolean z10) {
        this.f15813c = z10;
    }

    public FlowAdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlowAdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
