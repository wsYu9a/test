package com.vivo.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class c extends LinearLayout {

    /* renamed from: a */
    private TextView f26999a;

    /* renamed from: b */
    private ImageView f27000b;

    /* renamed from: c */
    private ImageView f27001c;

    public c(Context context) {
        super(context);
        b();
    }

    private void b() {
        setOrientation(0);
        setGravity(16);
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 4.0f);
        int b3 = com.vivo.mobilead.util.m.b(getContext(), 2.0f);
        setPadding(b2, b3, b2, b3);
        TextView textView = new TextView(getContext());
        this.f26999a = textView;
        textView.setMaxLines(1);
        this.f26999a.setTextSize(1, 10.0f);
        addView(this.f26999a, new LinearLayout.LayoutParams(-2, -2));
    }

    public void a(Bitmap bitmap, String str, String str2) {
        b(bitmap, str, str2, false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setFeedbackIndicator(String str) {
        ImageView imageView = this.f27001c;
        if (imageView != null) {
            imageView.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), str));
        }
    }

    public void setTagBackground(GradientDrawable gradientDrawable) {
        setBackground(gradientDrawable);
    }

    public void setTagImageAlpha(float f2) {
        ImageView imageView = this.f27000b;
        if (imageView != null) {
            imageView.setAlpha(f2);
        }
    }

    public void setTextAlpha(float f2) {
        TextView textView = this.f26999a;
        if (textView != null) {
            textView.setAlpha(f2);
        }
    }

    public void a(Bitmap bitmap, String str, String str2, boolean z) {
        if (bitmap == null) {
            if (!TextUtils.isEmpty(str)) {
                if (w0.a(str)) {
                    if (str.length() > 4) {
                        str = str.substring(0, 4);
                    }
                } else if (str.length() > 8) {
                    str = str.substring(0, 8);
                }
                str2 = str + str2;
            }
            ImageView imageView = this.f27000b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (this.f27000b == null) {
                int b2 = com.vivo.mobilead.util.m.b(getContext(), 11.0f);
                ImageView imageView2 = new ImageView(getContext());
                this.f27000b = imageView2;
                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b2, b2);
                layoutParams.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 3.0f);
                addView(this.f27000b, 0, layoutParams);
            }
            this.f27000b.setImageBitmap(bitmap);
            this.f27000b.setVisibility(0);
            if (str2.length() > 6) {
                str2 = str2.substring(0, 6);
            }
            com.vivo.mobilead.util.m.b(getContext(), 14.0f);
        }
        if (z) {
            if (this.f27001c == null) {
                ImageView imageView3 = new ImageView(getContext());
                this.f27001c = imageView3;
                imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f27001c.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_feedback_arrow_down.png"));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 6.5f), com.vivo.mobilead.util.m.b(getContext(), 3.73f));
                layoutParams2.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 2.0f);
                addView(this.f27001c, layoutParams2);
            }
            this.f27001c.setVisibility(0);
            com.vivo.mobilead.util.m.b(getContext(), 8.5f);
        } else {
            ImageView imageView4 = this.f27001c;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        this.f26999a.setText(str2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public void b(Bitmap bitmap, String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        if (bitmap == null) {
            if (!TextUtils.isEmpty(str)) {
                str2 = str + str2;
            }
            ImageView imageView = this.f27000b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (this.f27000b == null) {
                int b2 = com.vivo.mobilead.util.m.b(getContext(), 11.0f);
                ImageView imageView2 = new ImageView(getContext());
                this.f27000b = imageView2;
                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b2, b2);
                layoutParams.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 3.0f);
                addView(this.f27000b, 0, layoutParams);
            }
            this.f27000b.setImageBitmap(bitmap);
            this.f27000b.setVisibility(0);
        }
        if (z) {
            if (this.f27001c == null) {
                ImageView imageView3 = new ImageView(getContext());
                this.f27001c = imageView3;
                imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f27001c.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_feedback_arrow_down_white.png"));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 6.67f), com.vivo.mobilead.util.m.b(getContext(), 4.0f));
                layoutParams2.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 2.67f);
                addView(this.f27001c, layoutParams2);
            }
            this.f27001c.setVisibility(0);
        } else {
            ImageView imageView4 = this.f27001c;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        if (str2.length() > 10) {
            str2 = str2.substring(0, 10) + "...";
        }
        this.f26999a.setText(str2);
    }

    public void a() {
        ImageView imageView = this.f27001c;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void a(int i2, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(fArr);
        setBackground(gradientDrawable);
    }

    public void a(int i2, int i3) {
        this.f26999a.setTextColor(i3);
        this.f26999a.setTextSize(1, i2);
    }
}
