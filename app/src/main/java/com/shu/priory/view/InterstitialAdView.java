package com.shu.priory.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shu.priory.c.a;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.param.c;
import com.shu.priory.utils.a;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class InterstitialAdView extends AdView {

    /* renamed from: u */
    private Context f17441u;

    /* renamed from: v */
    private final String f17442v;

    /* renamed from: com.shu.priory.view.InterstitialAdView$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterstitialAdView.this.f17419l.a();
            InterstitialAdView.this.f17418k.onAdClose();
        }
    }

    /* renamed from: com.shu.priory.view.InterstitialAdView$2 */
    public class AnonymousClass2 implements a.InterfaceC0551a {

        /* renamed from: a */
        final /* synthetic */ ImageView f17444a;

        public AnonymousClass2(ImageView imageView) {
            imageView = imageView;
        }

        @Override // com.shu.priory.c.a.InterfaceC0551a
        public void imageLoad(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public InterstitialAdView(Context context) {
        super(context);
        this.f17442v = "close_widget";
    }

    private void a(ImageView imageView) {
        new com.shu.priory.c.a(this.f17441u.getApplicationContext(), this.f17415h.I).a(new a.InterfaceC0551a() { // from class: com.shu.priory.view.InterstitialAdView.2

            /* renamed from: a */
            final /* synthetic */ ImageView f17444a;

            public AnonymousClass2(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // com.shu.priory.c.a.InterfaceC0551a
            public void imageLoad(Bitmap bitmap) {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        });
    }

    @Override // com.shu.priory.view.AdView
    public void i() {
        com.shu.priory.g.a aVar = this.f17415h;
        if (aVar == null || TextUtils.isEmpty(aVar.I)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            h.a(SDKConstants.TAG, "adview parent is null");
            return;
        }
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            if ("close_widget".equals(viewGroup.getChildAt(i10).getTag())) {
                return;
            }
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f10 = displayMetrics.density;
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - 40;
        int i11 = (int) (f10 * 25.0f);
        int i12 = (int) (i11 * 0.3d);
        ImageView imageView = new ImageView(this.f17441u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i11, i11);
        layoutParams.topMargin = i12;
        layoutParams.leftMargin = (min - i11) - i12;
        imageView.setTag("close_widget");
        viewGroup.addView(imageView, layoutParams);
        a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.shu.priory.view.InterstitialAdView.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InterstitialAdView.this.f17419l.a();
                InterstitialAdView.this.f17418k.onAdClose();
            }
        });
    }

    @Override // com.shu.priory.view.AdView
    public void j() {
        int min = Math.min(c.e(this.f17441u), c.f(this.f17441u)) - 40;
        int adHeight = (this.f17413f.getAdHeight() * min) / this.f17413f.getAdWidth();
        h.a(SDKConstants.TAG, "InterstitialAdView adWidth=" + min + ", adHeight=" + adHeight);
        this.f17410c.setGravity(17);
        a(min, adHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public InterstitialAdView(Context context, RelativeLayout relativeLayout, String str, com.shu.priory.listener.a aVar) {
        super(context, relativeLayout, str, a.EnumC0557a.INTERSTITIAL, aVar);
        this.f17442v = "close_widget";
        this.f17441u = context.getApplicationContext();
    }
}
