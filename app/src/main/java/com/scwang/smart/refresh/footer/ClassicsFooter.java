package com.scwang.smart.refresh.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.footer.classics.R;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import pf.c;
import pf.f;
import qf.b;

/* loaded from: classes3.dex */
public class ClassicsFooter extends ClassicsAbstract<ClassicsFooter> implements c {
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    public static String I;
    public String A;
    public boolean B;

    /* renamed from: u */
    public String f16651u;

    /* renamed from: v */
    public String f16652v;

    /* renamed from: w */
    public String f16653w;

    /* renamed from: x */
    public String f16654x;

    /* renamed from: y */
    public String f16655y;

    /* renamed from: z */
    public String f16656z;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16657a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f16657a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16657a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16657a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16657a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16657a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16657a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    @Override // tf.b, pf.c
    public boolean a(boolean z10) {
        if (this.B == z10) {
            return true;
        }
        this.B = z10;
        ImageView imageView = this.f16639f;
        if (z10) {
            this.f16638e.setText(this.A);
            imageView.setVisibility(8);
            return true;
        }
        this.f16638e.setText(this.f16651u);
        imageView.setVisibility(0);
        return true;
    }

    @Override // tf.b, sf.i
    public void c(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ImageView imageView = this.f16639f;
        if (this.B) {
            return;
        }
        switch (a.f16657a[refreshState2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.f16638e.setText(this.f16653w);
                return;
            case 5:
                this.f16638e.setText(this.f16652v);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.f16638e.setText(this.f16654x);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.f16638e.setText(this.f16651u);
        imageView.animate().rotation(180.0f);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, tf.b, pf.a
    public int o(@NonNull f fVar, boolean z10) {
        super.o(fVar, z10);
        if (this.B) {
            return 0;
        }
        this.f16638e.setText(z10 ? this.f16655y : this.f16656z);
        return this.f16647n;
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, tf.b, pf.a
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.f30866c == b.f30068f) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.B = false;
        View.inflate(context, R.layout.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f16639f = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f16640g = imageView2;
        this.f16638e = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, uf.c.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.f16647n = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.f16647n);
        this.f30866c = b.f30071i[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f30866c.f30072a)];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.f16639f.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow));
        } else if (this.f16639f.getDrawable() == null) {
            kf.a aVar = new kf.a();
            this.f16642i = aVar;
            aVar.a(-10066330);
            this.f16639f.setImageDrawable(this.f16642i);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.f16640g.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress));
        } else if (this.f16640g.getDrawable() == null) {
            p004if.b bVar = new p004if.b();
            this.f16643j = bVar;
            bVar.a(-10066330);
            this.f16640g.setImageDrawable(this.f16643j);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.f16638e.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, uf.c.c(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.I(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlAccentColor)) {
            super.u(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextPulling)) {
            this.f16651u = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextPulling);
        } else {
            String str = C;
            if (str != null) {
                this.f16651u = str;
            } else {
                this.f16651u = context.getString(R.string.srl_footer_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRelease)) {
            this.f16652v = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRelease);
        } else {
            String str2 = D;
            if (str2 != null) {
                this.f16652v = str2;
            } else {
                this.f16652v = context.getString(R.string.srl_footer_release);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextLoading)) {
            this.f16653w = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextLoading);
        } else {
            String str3 = E;
            if (str3 != null) {
                this.f16653w = str3;
            } else {
                this.f16653w = context.getString(R.string.srl_footer_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRefreshing)) {
            this.f16654x = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRefreshing);
        } else {
            String str4 = F;
            if (str4 != null) {
                this.f16654x = str4;
            } else {
                this.f16654x = context.getString(R.string.srl_footer_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFinish)) {
            this.f16655y = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFinish);
        } else {
            String str5 = G;
            if (str5 != null) {
                this.f16655y = str5;
            } else {
                this.f16655y = context.getString(R.string.srl_footer_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFailed)) {
            this.f16656z = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFailed);
        } else {
            String str6 = H;
            if (str6 != null) {
                this.f16656z = str6;
            } else {
                this.f16656z = context.getString(R.string.srl_footer_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextNothing)) {
            this.A = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextNothing);
        } else {
            String str7 = I;
            if (str7 != null) {
                this.A = str7;
            } else {
                this.A = context.getString(R.string.srl_footer_nothing);
            }
        }
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.f16638e.setText(isInEditMode() ? this.f16653w : this.f16651u);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }
}
