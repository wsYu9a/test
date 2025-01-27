package com.jd.ad.sdk.jad_n_an;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.logger.Logger;
import qe.a;

/* loaded from: classes2.dex */
public class jad_n_na extends View {
    public View jad_n_an;
    public LinearLayout jad_n_bo;
    public ObjectAnimator jad_n_cp;
    public ObjectAnimator jad_n_dq;

    public class jad_n_an implements View.OnAttachStateChangeListener {
        public jad_n_an() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ObjectAnimator objectAnimator = jad_n_na.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            ObjectAnimator objectAnimator2 = jad_n_na.this.jad_n_dq;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ObjectAnimator objectAnimator = jad_n_na.this.jad_n_cp;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
            ObjectAnimator objectAnimator2 = jad_n_na.this.jad_n_dq;
            if (objectAnimator2 != null) {
                objectAnimator2.end();
            }
        }
    }

    public jad_n_na(Context context) {
        super(context);
        jad_n_an(context);
        jad_n_an();
    }

    public View getView() {
        return this.jad_n_an;
    }

    public final void jad_n_an(Context context) {
        try {
            View inflate = View.inflate(context, ResourceUtils.getResourceId(context, "jad_swipe_template", "layout"), null);
            this.jad_n_an = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(ResourceUtils.getResourceId(context, "liner_swipe_template", "id"));
            this.jad_n_bo = linearLayout;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f, -30.0f, 0.0f);
            this.jad_n_cp = ofFloat;
            ofFloat.setRepeatCount(4);
            this.jad_n_cp.setDuration(a.f30009d);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jad_n_bo, "alpha", 1.0f, 0.7f, 1.0f);
            this.jad_n_dq = ofFloat2;
            ofFloat2.setDuration(a.f30009d);
            this.jad_n_dq.setRepeatCount(4);
        } catch (Exception e10) {
            StringBuilder a10 = com.jd.ad.sdk.a.a.a("JADSwipeView initView error :");
            a10.append(Log.getStackTraceString(e10));
            Logger.w(a10.toString(), new Object[0]);
        }
    }

    public final void jad_n_an() {
        LinearLayout linearLayout;
        if (this.jad_n_an == null || (linearLayout = this.jad_n_bo) == null || this.jad_n_cp == null || this.jad_n_dq == null) {
            return;
        }
        linearLayout.addOnAttachStateChangeListener(new jad_n_an());
    }
}
