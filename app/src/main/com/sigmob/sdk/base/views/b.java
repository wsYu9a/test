package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes4.dex */
public class b extends RelativeLayout {

    /* renamed from: d */
    public static float f18461d = 8.0f;

    /* renamed from: e */
    public static final float f18462e = 1.0f;

    /* renamed from: a */
    public final int f18463a;

    /* renamed from: b */
    public ImageView f18464b;

    /* renamed from: c */
    public TextView f18465c;

    public class a implements ImageManager.BitmapLoadedListener {
        public a() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, b.this.getContext());
            if (bitmap != null) {
                if (b.this.f18463a != 1 && bitmap.getWidth() > bitmap.getHeight() * 1.5f) {
                    ((RelativeLayout.LayoutParams) b.this.f18464b.getLayoutParams()).setMargins((-dipsToIntPixels) * (bitmap.getWidth() / bitmap.getHeight()), 0, 0, 0);
                }
                b.this.f18464b.setImageBitmap(bitmap);
            }
        }
    }

    public b(Context context, int i10) {
        super(context);
        this.f18463a = i10;
        ImageView imageView = new ImageView(context);
        this.f18464b = imageView;
        imageView.setId(ClientMetadata.generateViewId());
        TextView textView = new TextView(context);
        this.f18465c = textView;
        textView.setTextColor(Color.parseColor("#B9B9B9"));
        this.f18465c.setTextSize(1, 12.0f);
        int dipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, context));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, context));
        this.f18465c.setGravity(17);
        this.f18464b.setScaleType(ImageView.ScaleType.FIT_START);
        this.f18464b.setAdjustViewBounds(true);
        this.f18464b.setMaxWidth(Dips.dipsToIntPixels(40.0f, context));
        this.f18464b.setMinimumWidth(Dips.dipsToIntPixels(16.0f, context));
        if (i10 == 1) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            int i11 = dipsToIntPixels * 2;
            layoutParams2.setMargins(dipsToIntPixels, 0, 0, i11);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, dipsToIntPixels, i11);
        } else {
            layoutParams.setMargins(dipsToIntPixels, 0, 0, 0);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams2.addRule(1, this.f18464b.getId());
            layoutParams2.addRule(8, this.f18464b.getId());
        }
        this.f18464b.setBackgroundColor(Color.alpha(0));
        addView(this.f18464b, layoutParams);
        addView(this.f18465c, layoutParams2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f18464b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.f18464b.setImageBitmap(bitmap);
        }
    }

    public void b(String str) {
        try {
            this.f18465c.setText(str);
        } catch (Throwable th2) {
            SigmobLog.e("showAdText error", th2);
        }
    }

    public void a(String str) {
        com.sigmob.sdk.base.common.h.o().getBitmap(str, new a());
    }
}
