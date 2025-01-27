package com.vivo.mobilead.unified.base.view.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.vivo.mobilead.unified.base.callback.h;

/* loaded from: classes4.dex */
public class c extends ImageView {

    /* renamed from: a */
    private float f30012a;

    /* renamed from: b */
    private float f30013b;

    /* renamed from: c */
    private float f30014c;

    /* renamed from: d */
    private float f30015d;

    /* renamed from: e */
    private h f30016e;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f30016e != null) {
                c.this.f30016e.a(view, c.this.f30012a, c.this.f30013b, c.this.f30014c, c.this.f30015d);
            }
        }
    }

    public c(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f30012a = motionEvent.getRawX();
            this.f30013b = motionEvent.getRawY();
            this.f30014c = motionEvent.getX();
            this.f30015d = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDownloadListener(h hVar) {
        this.f30016e = hVar;
    }

    public c(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOnClickListener(new a());
    }
}
