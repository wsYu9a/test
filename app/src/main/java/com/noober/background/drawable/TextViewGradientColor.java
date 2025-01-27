package com.noober.background.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import com.noober.background.R;

/* loaded from: classes3.dex */
public class TextViewGradientColor implements ITextViewOperator {
    private int endColor = -1;
    private int startColor = -1;
    private int orientation = 0;

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ TextView f16205b;

        public a(TextView textView) {
            this.f16205b = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16205b.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f16205b.getPaint().descent() - this.f16205b.getPaint().ascent(), TextViewGradientColor.this.startColor, TextViewGradientColor.this.endColor, Shader.TileMode.REPEAT));
            this.f16205b.invalidate();
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ TextView f16207b;

        public b(TextView textView) {
            this.f16207b = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16207b.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.f16207b.getMeasuredWidth(), 0.0f, TextViewGradientColor.this.startColor, TextViewGradientColor.this.endColor, Shader.TileMode.REPEAT));
            this.f16207b.invalidate();
        }
    }

    @Override // com.noober.background.drawable.ITextViewOperator
    public void invoke(Context context, AttributeSet attributeSet, TextView textView) {
        int i10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.bl_text);
        try {
        } catch (Exception unused) {
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
        if (obtainStyledAttributes.getIndexCount() == 0) {
            obtainStyledAttributes.recycle();
            return;
        }
        for (int i11 = 0; i11 < obtainStyledAttributes.getIndexCount(); i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.bl_text_bl_text_gradient_endColor) {
                this.endColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == R.styleable.bl_text_bl_text_gradient_startColor) {
                this.startColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == R.styleable.bl_text_bl_text_gradient_orientation) {
                this.orientation = obtainStyledAttributes.getInt(index, 0);
            }
        }
        int i12 = this.endColor;
        if (i12 != -1 || (i10 = this.startColor) == -1) {
            int i13 = this.startColor;
            if (i13 == -1 && i12 != -1) {
                textView.setTextColor(i12);
            } else if (i12 != -1 && i13 != -1) {
                if (this.orientation == 0) {
                    textView.post(new a(textView));
                } else {
                    textView.post(new b(textView));
                }
            }
        } else {
            textView.setTextColor(i10);
        }
        obtainStyledAttributes.recycle();
    }
}
