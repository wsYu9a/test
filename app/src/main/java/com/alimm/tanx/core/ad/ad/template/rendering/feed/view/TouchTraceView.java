package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.alimm.tanx.core.utils.LogUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: classes.dex */
public class TouchTraceView extends View {
    private float tanxc_byte;
    private float tanxc_case;
    private float tanxc_char;
    Context tanxc_do;
    private int tanxc_else;
    float tanxc_for;
    private final boolean tanxc_goto;
    InteractionCallBack tanxc_if;
    private final Paint tanxc_int;
    private final int tanxc_long;
    private final Path tanxc_new;
    private final int tanxc_this;
    private float tanxc_try;

    public interface InteractionCallBack {
        void onInteractionEnd(int i10, int i11, int i12);

        void onInteractionStart();
    }

    public TouchTraceView(Context context, AttributeSet attributeSet, InteractionCallBack interactionCallBack) {
        super(context, attributeSet);
        this.tanxc_else = 3;
        this.tanxc_goto = false;
        this.tanxc_long = 55;
        this.tanxc_this = 120;
        this.tanxc_for = 0.56f;
        this.tanxc_do = context;
        this.tanxc_new = new Path();
        Paint paint = new Paint();
        this.tanxc_int = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10.0f);
        this.tanxc_if = interactionCallBack;
    }

    private int tanxc_do(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f11;
        float f15 = f12 - f13;
        return (int) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("TouchTraceView", "onDraw");
        canvas.drawPath(this.tanxc_new, this.tanxc_int);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.tanxc_for), 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            LogUtils.d("TouchTraceView", "ACTION_DOWN");
            this.tanxc_case = x10;
            this.tanxc_char = y10;
            this.tanxc_new.moveTo(x10, y10);
            InteractionCallBack interactionCallBack = this.tanxc_if;
            if (interactionCallBack != null) {
                interactionCallBack.onInteractionStart();
            }
        } else {
            if (actionMasked == 1) {
                LogUtils.d("TouchTraceView", "ACTION_UP");
                LogUtils.d("touch--->", "x: " + (x10 - this.tanxc_case) + " y:" + (y10 - this.tanxc_char));
                this.tanxc_new.reset();
                requestLayout();
                InteractionCallBack interactionCallBack2 = this.tanxc_if;
                float f10 = this.tanxc_case;
                float f11 = this.tanxc_char;
                interactionCallBack2.onInteractionEnd((int) (x10 - f10), (int) (y10 - f11), tanxc_do(x10, f10, y10, f11));
                return true;
            }
            if (actionMasked != 2) {
                LogUtils.d("TouchTraceView", DownloadSettingKeys.BugFix.DEFAULT);
                this.tanxc_new.reset();
            } else {
                LogUtils.d("TouchTraceView", "ACTION_MOVE");
                this.tanxc_new.quadTo(this.tanxc_try, this.tanxc_byte, x10, y10);
            }
        }
        invalidate();
        this.tanxc_try = x10;
        this.tanxc_byte = y10;
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        Path path;
        super.onVisibilityAggregated(z10);
        LogUtils.d("TouchTraceView", "onVisibilityAggregated:" + z10);
        if (z10 || (path = this.tanxc_new) == null) {
            return;
        }
        path.reset();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        Path path;
        super.onWindowFocusChanged(z10);
        if (!z10 && (path = this.tanxc_new) != null) {
            path.reset();
        }
        LogUtils.d("TouchTraceView", "onWindowFocusChanged:" + z10);
    }

    public void tanxc_do(float f10) {
        this.tanxc_for = f10;
    }
}
