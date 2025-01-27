package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public class AppScoreView extends LinearLayout {
    private ImageView GJ;
    private ImageView GK;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView();
    }

    private void initView() {
        LinearLayout.inflate(getContext(), R.layout.ksad_app_score, this);
        this.GJ = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.GK = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f2) {
        ImageView imageView;
        int i2;
        ImageView imageView2;
        int i3;
        double d2 = f2;
        if (d2 > 4.5d) {
            ImageView imageView3 = this.GJ;
            i3 = R.drawable.ksad_star_checked;
            imageView3.setImageResource(i3);
            imageView2 = this.GK;
        } else if (d2 > 4.0d) {
            this.GJ.setImageResource(R.drawable.ksad_star_checked);
            imageView2 = this.GK;
            i3 = R.drawable.ksad_star_half;
        } else {
            if (d2 > 3.5d) {
                imageView = this.GJ;
                i2 = R.drawable.ksad_star_checked;
            } else {
                if (d2 <= 3.0d) {
                    if (d2 == 3.0d) {
                        ImageView imageView4 = this.GJ;
                        int i4 = R.drawable.ksad_star_unchecked;
                        imageView4.setImageResource(i4);
                        this.GK.setImageResource(i4);
                        return;
                    }
                    return;
                }
                imageView = this.GJ;
                i2 = R.drawable.ksad_star_half;
            }
            imageView.setImageResource(i2);
            imageView2 = this.GK;
            i3 = R.drawable.ksad_star_unchecked;
        }
        imageView2.setImageResource(i3);
    }
}
