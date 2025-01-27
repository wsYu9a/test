package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public class AppScoreView extends LinearLayout {
    private ImageView JS;
    private ImageView JT;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        View.inflate(getContext(), R.layout.ksad_app_score, this);
        this.JS = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.JT = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f10) {
        double d10 = f10;
        if (d10 > 4.5d) {
            this.JS.setImageResource(R.drawable.ksad_star_checked);
            this.JT.setImageResource(R.drawable.ksad_star_checked);
            return;
        }
        if (d10 > 4.0d) {
            this.JS.setImageResource(R.drawable.ksad_star_checked);
            this.JT.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d10 > 3.5d) {
            this.JS.setImageResource(R.drawable.ksad_star_checked);
            this.JT.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d10 > 3.0d) {
            this.JS.setImageResource(R.drawable.ksad_star_half);
            this.JT.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d10 == 3.0d) {
            this.JS.setImageResource(R.drawable.ksad_star_unchecked);
            this.JT.setImageResource(R.drawable.ksad_star_unchecked);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }
}
