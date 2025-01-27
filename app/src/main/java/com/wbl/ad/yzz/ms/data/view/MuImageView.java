package com.wbl.ad.yzz.ms.data.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class MuImageView extends AppCompatImageView {

    /* renamed from: a */
    public RectF f33107a;

    /* renamed from: b */
    public Path f33108b;

    /* renamed from: c */
    public Paint f33109c;

    /* renamed from: d */
    public int f33110d;

    /* renamed from: e */
    public float f33111e;

    public MuImageView(Context context) {
        super(context);
        this.f33107a = new RectF();
        this.f33108b = new Path();
        this.f33109c = new Paint();
        a();
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11999, this, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11994, this, canvas);
    }

    public MuImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33107a = new RectF();
        this.f33108b = new Path();
        this.f33109c = new Paint();
        a();
    }

    public MuImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33107a = new RectF();
        this.f33108b = new Path();
        this.f33109c = new Paint();
        a();
    }
}
