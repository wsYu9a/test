package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.io.File;

/* loaded from: classes4.dex */
public class p0 extends RelativeLayout {

    /* renamed from: a */
    public ImageView f18834a;

    /* renamed from: b */
    public int f18835b;

    public class a implements ImageManager.BitmapLoadedListener {

        /* renamed from: a */
        public final /* synthetic */ String f18836a;

        public a(String str) {
            this.f18836a = str;
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            if (bitmap != null) {
                p0.this.f18834a.setImageBitmap(bitmap);
            } else {
                SigmobLog.d(String.format("%s returned null bitmap", this.f18836a));
            }
        }
    }

    public p0(Context context) {
        super(context);
        this.f18835b = Dips.dipsToIntPixels(22.0f, context);
        int dipsToIntPixels = Dips.dipsToIntPixels(15.0f, context);
        int i10 = this.f18835b / 2;
        a(dipsToIntPixels);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setStroke(1, -1);
        gradientDrawable.setCornerRadius(i10);
        gradientDrawable.setAlpha(102);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams);
    }

    public void b(int i10) {
        this.f18834a.setImageResource(i10);
    }

    public final void a(int i10) {
        this.f18834a = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, i10);
        layoutParams.addRule(13);
        this.f18834a.setImageBitmap(s.CLOSE_NEW.b());
        this.f18834a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f18834a.setImageAlpha(204);
        addView(this.f18834a, layoutParams);
    }

    public final void b(String str) {
        com.sigmob.sdk.base.common.h.o().getBitmap(str, new a(str));
    }

    public void a(Bitmap bitmap) {
        this.f18834a.setImageBitmap(bitmap);
    }

    public void a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://")) {
            b(str);
        } else if (lowerCase.startsWith("file://")) {
            try {
                this.f18834a.setImageURI(Uri.fromFile(new File(str)));
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
    }

    public void a(BaseAdUnit baseAdUnit) {
        ImageView imageView;
        s sVar;
        if (baseAdUnit == null || baseAdUnit.getEndcardCloseImage() != 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBackground(gradientDrawable);
            int i10 = this.f18835b;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, i10);
            layoutParams.addRule(13);
            this.f18834a.setLayoutParams(layoutParams);
            imageView = this.f18834a;
            sVar = s.CLOSE_OLD;
        } else {
            imageView = this.f18834a;
            sVar = s.CLOSE_NEW;
        }
        imageView.setImageBitmap(sVar.b());
    }
}
