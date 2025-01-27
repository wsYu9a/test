package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.q;

/* loaded from: classes4.dex */
public class i extends o {
    private ImageView L;

    public i(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.callback.c
    public void a(String str, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            a(false);
            return;
        }
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        p.a(p.a(bitmap, getMaterialContainerWidth() / 3, getMaterialContainerHeight() / 3), 3.0f, 50, new a());
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    protected void c(com.vivo.ad.model.b bVar, AdParams adParams) {
        String sourceAppend = adParams == null ? "" : adParams.getSourceAppend();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        this.f30040j.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        this.t = c();
        if (com.vivo.mobilead.util.d.e(bVar) == 4) {
            d k = k();
            this.H = k;
            this.t.addView(k, new LinearLayout.LayoutParams(this.H.getLayoutParams()));
            this.H.a(bVar, adParams != null ? adParams.getSourceAppend() : "", "4");
            this.t.setOnADWidgetClickListener(this.k);
            this.t.setTag(7);
        } else {
            ImageView b2 = b();
            this.L = b2;
            this.t.addView(b2, new LinearLayout.LayoutParams(-1, -1));
            this.t.setOnADWidgetClickListener(this.k);
            this.t.setTag(8);
        }
        linearLayout.addView(this.t, new LinearLayout.LayoutParams(getMaterialContainerWidth(), getMaterialContainerHeight()));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(com.vivo.mobilead.util.m.a(getContext(), 13.33f), 0, 0, 0);
        linearLayout.addView(linearLayout2, layoutParams);
        linearLayout2.addView(a(q.a(bVar) ? 1 : 2, com.vivo.mobilead.util.d.g(bVar)), new LinearLayout.LayoutParams(-2, -2));
        if (q.a(bVar)) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = com.vivo.mobilead.util.m.a(getContext(), this.q * 5.0f);
            linearLayout2.addView(a(bVar, sourceAppend, layoutParams2));
        }
        if (bVar.T() && bVar.y() != null) {
            linearLayout2.addView(a(bVar.y()), new LinearLayout.LayoutParams(-2, com.vivo.mobilead.util.m.a(getContext(), 16.0f)));
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(getContext(), 26.0f));
        layoutParams3.setMargins(0, com.vivo.mobilead.util.m.a(getContext(), this.q * 8.17f), 0, 0);
        this.f30040j.addView(a(bVar, adParams, true), layoutParams3);
        a(com.vivo.mobilead.util.d.f(bVar));
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerHeight() {
        return com.vivo.mobilead.util.m.a(getContext(), this.q * 82.0f);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerWidth() {
        return com.vivo.mobilead.util.m.a(getContext(), this.q * 109.33f);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    protected int[] getMinSize() {
        return new int[]{org.mozilla.universalchardet.prober.g.n, 100};
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    public void j() {
    }

    public i(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    class a implements p.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a(Bitmap bitmap) {
            if (i.this.t != null) {
                ImageView imageView = new ImageView(i.this.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(bitmap);
                i.this.t.addView(imageView, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            i.this.a(true);
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a() {
            i.this.a(true);
        }
    }
}
