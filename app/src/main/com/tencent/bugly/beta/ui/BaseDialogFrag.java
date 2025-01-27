package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.c;
import com.tencent.bugly.beta.utils.e;

/* loaded from: classes4.dex */
public abstract class BaseDialogFrag extends BaseFrag {
    protected ImageView mBannerImageView;
    protected LinearLayout mContentContainer;
    protected Context mContext;
    protected LinearLayout mCustomLayout;
    protected FrameLayout mFrameLayout;
    protected View mLayoutContainer;
    protected int mLayoutResId;
    protected TextView mLeftBtnTextView;
    protected ResBean mRes;
    protected TextView mRightBtnTextView;
    protected int mStyle;
    protected TextView mTitleTextView;

    /* renamed from: com.tencent.bugly.beta.ui.BaseDialogFrag$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ View.OnClickListener val$lListener;
        final /* synthetic */ String val$lText;
        final /* synthetic */ View.OnClickListener val$rListener;
        final /* synthetic */ String val$rText;

        public AnonymousClass1(String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2) {
            str = str;
            onClickListener = onClickListener;
            str2 = str2;
            onClickListener2 = onClickListener2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseDialogFrag baseDialogFrag = BaseDialogFrag.this;
            TextView textView = baseDialogFrag.mLeftBtnTextView;
            if (textView == null || baseDialogFrag.mRightBtnTextView == null) {
                return;
            }
            if (str != null) {
                textView.setVisibility(0);
                BaseDialogFrag baseDialogFrag2 = BaseDialogFrag.this;
                if (baseDialogFrag2.mStyle != 2) {
                    baseDialogFrag2.mLeftBtnTextView.setText(str);
                    BaseDialogFrag baseDialogFrag3 = BaseDialogFrag.this;
                    if (baseDialogFrag3.mLayoutResId == 0) {
                        baseDialogFrag3.mLeftBtnTextView.getViewTreeObserver().addOnPreDrawListener(new BetaOnPreDraw(2, Integer.valueOf(BaseDialogFrag.this.mStyle), BaseDialogFrag.this.mLeftBtnTextView, 1));
                    }
                }
                BaseDialogFrag.this.mLeftBtnTextView.setOnClickListener(onClickListener);
            }
            if (str2 != null) {
                BaseDialogFrag.this.mRightBtnTextView.setVisibility(0);
                BaseDialogFrag.this.mRightBtnTextView.setText(str2);
                BaseDialogFrag.this.mRightBtnTextView.setOnClickListener(onClickListener2);
                BaseDialogFrag baseDialogFrag4 = BaseDialogFrag.this;
                if (baseDialogFrag4.mLayoutResId == 0) {
                    baseDialogFrag4.mRightBtnTextView.getViewTreeObserver().addOnPreDrawListener(new BetaOnPreDraw(2, Integer.valueOf(BaseDialogFrag.this.mStyle), BaseDialogFrag.this.mRightBtnTextView, 1));
                }
                BaseDialogFrag.this.mRightBtnTextView.requestFocus();
            }
        }
    }

    /* renamed from: com.tencent.bugly.beta.ui.BaseDialogFrag$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Animation val$exitAnim;

        public AnonymousClass2(Animation animation) {
            alphaAnimation = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = BaseDialogFrag.this.mLayoutContainer;
            if (view != null) {
                view.startAnimation(alphaAnimation);
            }
        }
    }

    /* renamed from: com.tencent.bugly.beta.ui.BaseDialogFrag$3 */
    public class AnonymousClass3 implements Animation.AnimationListener {
        public AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = BaseDialogFrag.this.mLayoutContainer;
            if (view != null) {
                view.setVisibility(8);
            }
            BaseDialogFrag.super.close();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.tencent.bugly.beta.ui.BaseFrag
    public void close() {
        if (this.mLayoutContainer == null) {
            super.close();
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.BaseDialogFrag.2
            final /* synthetic */ Animation val$exitAnim;

            public AnonymousClass2(Animation alphaAnimation2) {
                alphaAnimation = alphaAnimation2;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = BaseDialogFrag.this.mLayoutContainer;
                if (view != null) {
                    view.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.bugly.beta.ui.BaseDialogFrag.3
            public AnonymousClass3() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view = BaseDialogFrag.this.mLayoutContainer;
                if (view != null) {
                    view.setVisibility(8);
                }
                BaseDialogFrag.super.close();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContext = getActivity();
        this.mRes = ResBean.f22088a;
        int i10 = this.mLayoutResId;
        if (i10 == 0) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            this.mLayoutContainer = relativeLayout;
            relativeLayout.setGravity(17);
            this.mLayoutContainer.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.mFrameLayout = new FrameLayout(this.mContext);
            this.mFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            this.mCustomLayout = linearLayout;
            linearLayout.setBackgroundColor(-1);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.mCustomLayout.setGravity(17);
            this.mCustomLayout.setLayoutParams(layoutParams);
            this.mCustomLayout.setMinimumWidth(a.a(this.mContext, 280.0f));
            this.mCustomLayout.setOrientation(1);
            if (this.mStyle == 2) {
                float a10 = a.a(this.mContext, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{a10, a10, a10, a10, a10, a10, a10, a10}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                this.mCustomLayout.setBackgroundDrawable(shapeDrawable);
            }
            TextView textView = new TextView(this.mContext);
            this.mTitleTextView = textView;
            textView.setGravity(16);
            this.mTitleTextView.setSingleLine();
            TextView textView2 = this.mTitleTextView;
            this.mRes.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            this.mTitleTextView.setTextSize(18.0f);
            this.mTitleTextView.setLayoutParams(layoutParams);
            this.mTitleTextView.setOnClickListener(null);
            this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            int a11 = a.a(this.mContext, 16.0f);
            this.mTitleTextView.setPadding(a11, 0, a11, 0);
            this.mTitleTextView.setTypeface(null, 1);
            this.mTitleTextView.setHeight(a.a(this.mContext, 42.0f));
            this.mTitleTextView.setTag(Beta.TAG_TITLE);
            TextView textView3 = new TextView(this.mContext);
            textView3.setBackgroundColor(-3355444);
            textView3.setHeight(1);
            ScrollView scrollView = new ScrollView(this.mContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, a.a(this.mContext, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.mContentContainer = new LinearLayout(this.mContext);
            this.mContentContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.mContentContainer.setOrientation(1);
            this.mContentContainer.setPadding(a11, a.a(this.mContext, 10.0f), a11, 0);
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setGravity(17);
            linearLayout2.setOrientation(0);
            int i11 = a11 / 2;
            linearLayout2.setPadding(i11, a11, i11, a11);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout2.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i11, 0, i11, 0);
            TextView textView4 = new TextView(this.mContext);
            this.mLeftBtnTextView = textView4;
            textView4.setSingleLine();
            this.mLeftBtnTextView.setGravity(17);
            this.mLeftBtnTextView.setTag(Beta.TAG_CANCEL_BUTTON);
            new RelativeLayout.LayoutParams(-2, -2);
            int a12 = a.a(this.mContext, 30.0f);
            if (this.mStyle == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a12, a12);
                layoutParams5.gravity = 53;
                this.mLeftBtnTextView.setLayoutParams(layoutParams5);
                this.mLeftBtnTextView.setTextSize((float) (a12 * 0.3d));
            } else {
                this.mLeftBtnTextView.setLayoutParams(layoutParams4);
                this.mLeftBtnTextView.setTextSize(16);
                TextView textView5 = this.mLeftBtnTextView;
                this.mRes.getClass();
                textView5.setTextColor(Color.parseColor("#757575"));
                this.mLeftBtnTextView.setPadding(a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f), a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f));
            }
            TextView textView6 = new TextView(this.mContext);
            this.mRightBtnTextView = textView6;
            textView6.setLayoutParams(layoutParams4);
            this.mRightBtnTextView.setGravity(17);
            this.mRightBtnTextView.setTextSize(16);
            TextView textView7 = this.mRightBtnTextView;
            this.mRes.getClass();
            textView7.setTextColor(Color.parseColor("#273238"));
            this.mRightBtnTextView.setSingleLine();
            this.mRightBtnTextView.setPadding(a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f), a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f));
            this.mRightBtnTextView.setTypeface(null, 1);
            this.mRightBtnTextView.setTag(Beta.TAG_CONFIRM_BUTTON);
            int a13 = a.a(this.mContext, 40.0f);
            scrollView.addView(this.mContentContainer);
            if (this.mStyle == 2) {
                FrameLayout frameLayout = new FrameLayout(this.mContext);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i12 = a12 / 2;
                int i13 = i12 - 5;
                this.mFrameLayout.setPadding(i12, i13, i13, i12);
                frameLayout.addView(this.mFrameLayout);
                frameLayout.addView(this.mLeftBtnTextView);
                ((RelativeLayout) this.mLayoutContainer).addView(frameLayout);
            } else {
                this.mLayoutContainer.setPadding(a13, a13, a13, a13);
                ((RelativeLayout) this.mLayoutContainer).addView(this.mFrameLayout);
                linearLayout2.addView(this.mLeftBtnTextView);
            }
            this.mCustomLayout.addView(this.mTitleTextView);
            this.mCustomLayout.addView(textView3);
            this.mCustomLayout.addView(scrollView);
            this.mFrameLayout.addView(this.mCustomLayout);
            linearLayout2.addView(this.mRightBtnTextView);
            this.mFrameLayout.addView(linearLayout2);
            if (this.mStyle == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Bitmap createBitmap = Bitmap.createBitmap(a12, a12, config);
                int i14 = a12 / 2;
                Canvas canvas = new Canvas(createBitmap);
                paint.setColor(-3355444);
                float f10 = i14;
                canvas.drawCircle(f10, f10, f10, paint);
                canvas.rotate(45.0f, f10, f10);
                paint.setColor(-7829368);
                int a14 = a.a(this.mContext, 0.8f);
                float f11 = 0.4f * f10;
                float f12 = i14 - a14;
                float f13 = 1.6f * f10;
                float f14 = i14 + a14;
                canvas.drawRect(f11, f12, f13, f14, paint);
                canvas.drawRect(f12, f11, f14, f13, paint);
                canvas.rotate(-45.0f);
                Bitmap createBitmap2 = Bitmap.createBitmap(a12, a12, config);
                Canvas canvas2 = new Canvas(createBitmap2);
                paint.setColor(-7829368);
                canvas2.drawCircle(f10, f10, f10, paint);
                canvas2.rotate(45.0f, f10, f10);
                paint.setColor(-3355444);
                canvas2.drawRect(f11, f12, f13, f14, paint);
                canvas2.drawRect(f12, f11, f14, f13, paint);
                canvas2.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                this.mLeftBtnTextView.setBackgroundDrawable(bitmapDrawable);
                this.mLeftBtnTextView.setOnTouchListener(new c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.mLayoutContainer.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.mLayoutContainer.startAnimation(alphaAnimation);
        } else {
            View inflate = layoutInflater.inflate(i10, (ViewGroup) null);
            this.mLayoutContainer = inflate;
            this.mBannerImageView = (ImageView) inflate.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.mTitleTextView = (TextView) this.mLayoutContainer.findViewWithTag(Beta.TAG_TITLE);
            this.mLeftBtnTextView = (TextView) this.mLayoutContainer.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            this.mRightBtnTextView = (TextView) this.mLayoutContainer.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        this.mLeftBtnTextView.setVisibility(8);
        this.mRightBtnTextView.setVisibility(8);
        this.mLeftBtnTextView.setFocusable(true);
        this.mRightBtnTextView.setFocusable(true);
        this.mRightBtnTextView.requestFocus();
        return this.mLayoutContainer;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mContext = null;
        this.mLayoutContainer = null;
        this.mFrameLayout = null;
        this.mCustomLayout = null;
        this.mTitleTextView = null;
        this.mBannerImageView = null;
        this.mLeftBtnTextView = null;
        this.mRightBtnTextView = null;
        this.mContentContainer = null;
    }

    public void setBtn(String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2) {
        e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.BaseDialogFrag.1
            final /* synthetic */ View.OnClickListener val$lListener;
            final /* synthetic */ String val$lText;
            final /* synthetic */ View.OnClickListener val$rListener;
            final /* synthetic */ String val$rText;

            public AnonymousClass1(String str3, View.OnClickListener onClickListener3, String str22, View.OnClickListener onClickListener22) {
                str = str3;
                onClickListener = onClickListener3;
                str2 = str22;
                onClickListener2 = onClickListener22;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseDialogFrag baseDialogFrag = BaseDialogFrag.this;
                TextView textView = baseDialogFrag.mLeftBtnTextView;
                if (textView == null || baseDialogFrag.mRightBtnTextView == null) {
                    return;
                }
                if (str != null) {
                    textView.setVisibility(0);
                    BaseDialogFrag baseDialogFrag2 = BaseDialogFrag.this;
                    if (baseDialogFrag2.mStyle != 2) {
                        baseDialogFrag2.mLeftBtnTextView.setText(str);
                        BaseDialogFrag baseDialogFrag3 = BaseDialogFrag.this;
                        if (baseDialogFrag3.mLayoutResId == 0) {
                            baseDialogFrag3.mLeftBtnTextView.getViewTreeObserver().addOnPreDrawListener(new BetaOnPreDraw(2, Integer.valueOf(BaseDialogFrag.this.mStyle), BaseDialogFrag.this.mLeftBtnTextView, 1));
                        }
                    }
                    BaseDialogFrag.this.mLeftBtnTextView.setOnClickListener(onClickListener);
                }
                if (str2 != null) {
                    BaseDialogFrag.this.mRightBtnTextView.setVisibility(0);
                    BaseDialogFrag.this.mRightBtnTextView.setText(str2);
                    BaseDialogFrag.this.mRightBtnTextView.setOnClickListener(onClickListener2);
                    BaseDialogFrag baseDialogFrag4 = BaseDialogFrag.this;
                    if (baseDialogFrag4.mLayoutResId == 0) {
                        baseDialogFrag4.mRightBtnTextView.getViewTreeObserver().addOnPreDrawListener(new BetaOnPreDraw(2, Integer.valueOf(BaseDialogFrag.this.mStyle), BaseDialogFrag.this.mRightBtnTextView, 1));
                    }
                    BaseDialogFrag.this.mRightBtnTextView.requestFocus();
                }
            }
        });
    }
}
