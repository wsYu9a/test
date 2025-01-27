package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.vivo.mobilead.util.r;

/* loaded from: classes4.dex */
public class e extends TextView {

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            e.this.setTextSize(12.0f);
            e.this.setTextColor(-1);
            e.this.setGravity(17);
            e.this.a();
        }
    }

    public e(Context context) {
        this(context, null);
    }

    public void setCountText(long j2) {
        if (j2 <= 0) {
            return;
        }
        String a2 = r.a(j2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        setText(a2);
    }

    public e(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        float a2 = com.vivo.mobilead.util.m.a(getContext(), 30.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{a2, a2, a2, a2, a2, a2, a2, a2}, null, null));
        shapeDrawable.getPaint().setColor(1291845632);
        setBackground(shapeDrawable);
    }

    public e(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        post(new a());
    }
}
