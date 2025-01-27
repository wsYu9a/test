package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.wrapper_oaction.ZkViewSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class b extends a {
    private int N;

    public b(Context context, int i2, String str, HashMap<ZkViewSDK.KEY, Object> hashMap, int i3, Map map, ZkViewSDK.a aVar) {
        super(context, i2, str, hashMap, i3, map, aVar);
    }

    private void b0(int i2) {
        View view;
        if (i2 == 0 || (view = this.n) == null || view.getMeasuredWidth() == 0 || this.n.getMeasuredWidth() == i2) {
            return;
        }
        float measuredWidth = (i2 * 1.0f) / this.n.getMeasuredWidth();
        this.n.setScaleX(measuredWidth);
        this.n.setScaleY(measuredWidth);
    }

    @Override // com.zk_oaction.adengine.lk_sdkwrapper.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredWidth;
        int measuredHeight;
        if (getChildCount() == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        if (getParent() != null) {
            this.N = ((View) getParent()).getMeasuredWidth();
        }
        try {
            if (this.n != null) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                if (size >= 0 && size2 >= 0) {
                    float o = this.r.t().o();
                    float p = this.r.t().p();
                    float q = this.r.t().q();
                    z(size, size2);
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (p * o), 1073741824);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (o * q), 1073741824);
                    this.n.measure(makeMeasureSpec, makeMeasureSpec2);
                    ViewGroup viewGroup = (ViewGroup) this.n;
                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                        viewGroup.getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    Q();
                    if (this.N == 0 || this.n.getMeasuredWidth() == 0) {
                        measuredWidth = this.n.getMeasuredWidth();
                        measuredHeight = this.n.getMeasuredHeight();
                    } else {
                        b0(this.N);
                        measuredWidth = this.N;
                        measuredHeight = (int) (((this.N * 1.0f) / this.n.getMeasuredWidth()) * this.n.getMeasuredHeight());
                    }
                    setMeasuredDimension(measuredWidth, measuredHeight);
                    return;
                }
            }
            super.onMeasure(i2, i3);
        } catch (Throwable th) {
            super.onMeasure(i2, i3);
            l(th.getMessage());
        }
    }
}
