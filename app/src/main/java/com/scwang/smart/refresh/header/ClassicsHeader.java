package com.scwang.smart.refresh.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.header.classics.R;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import pf.d;
import pf.e;
import pf.f;
import qf.b;
import uf.c;

/* loaded from: classes3.dex */
public class ClassicsHeader extends ClassicsAbstract<ClassicsHeader> implements d {
    public static final int I = R.id.srl_classics_update;
    public static String J = null;
    public static String K = null;
    public static String L = null;
    public static String M = null;
    public static String N = null;
    public static String O = null;
    public static String P = null;
    public static String Q = null;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;

    /* renamed from: u */
    public String f16658u;

    /* renamed from: v */
    public Date f16659v;

    /* renamed from: w */
    public TextView f16660w;

    /* renamed from: x */
    public SharedPreferences f16661x;

    /* renamed from: y */
    public DateFormat f16662y;

    /* renamed from: z */
    public boolean f16663z;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16664a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f16664a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16664a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16664a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16664a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16664a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16664a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16664a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract
    /* renamed from: Q */
    public ClassicsHeader u(@ColorInt int i10) {
        this.f16660w.setTextColor((16777215 & i10) | (-872415232));
        return (ClassicsHeader) super.u(i10);
    }

    public ClassicsHeader R(boolean z10) {
        TextView textView = this.f16660w;
        this.f16663z = z10;
        textView.setVisibility(z10 ? 0 : 8);
        e eVar = this.f16641h;
        if (eVar != null) {
            eVar.n(this);
        }
        return this;
    }

    public ClassicsHeader S(CharSequence charSequence) {
        this.f16659v = null;
        this.f16660w.setText(charSequence);
        return this;
    }

    public ClassicsHeader T(Date date) {
        this.f16659v = date;
        this.f16660w.setText(this.f16662y.format(date));
        if (this.f16661x != null && !isInEditMode()) {
            this.f16661x.edit().putLong(this.f16658u, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader U(float f10) {
        this.f16660w.setTextSize(f10);
        e eVar = this.f16641h;
        if (eVar != null) {
            eVar.n(this);
        }
        return this;
    }

    public ClassicsHeader V(int i10, float f10) {
        this.f16660w.setTextSize(i10, f10);
        e eVar = this.f16641h;
        if (eVar != null) {
            eVar.n(this);
        }
        return this;
    }

    public ClassicsHeader W(float f10) {
        TextView textView = this.f16660w;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = c.c(f10);
        textView.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader X(int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16660w.getLayoutParams();
        marginLayoutParams.topMargin = i10;
        this.f16660w.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader Y(DateFormat dateFormat) {
        this.f16662y = dateFormat;
        Date date = this.f16659v;
        if (date != null) {
            this.f16660w.setText(dateFormat.format(date));
        }
        return this;
    }

    @Override // tf.b, sf.i
    public void c(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ImageView imageView = this.f16639f;
        TextView textView = this.f16660w;
        switch (a.f16664a[refreshState2.ordinal()]) {
            case 1:
                textView.setVisibility(this.f16663z ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f16638e.setText(this.B);
                imageView.setVisibility(8);
                return;
            case 5:
                this.f16638e.setText(this.D);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.f16638e.setText(this.H);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.f16663z ? 4 : 8);
                this.f16638e.setText(this.C);
                return;
            default:
                return;
        }
        this.f16638e.setText(this.A);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, tf.b, pf.a
    public int o(@NonNull f fVar, boolean z10) {
        if (z10) {
            this.f16638e.setText(this.E);
            if (this.f16659v != null) {
                T(new Date());
            }
        } else {
            this.f16638e.setText(this.F);
        }
        return super.o(fVar, z10);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        FragmentManager supportFragmentManager;
        this.f16658u = "LAST_UPDATE_TIME";
        this.f16663z = true;
        View.inflate(context, R.layout.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f16639f = imageView;
        TextView textView = (TextView) findViewById(R.id.srl_classics_update);
        this.f16660w = textView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f16640g = imageView2;
        this.f16638e = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, c.c(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlDrawableMarginRight, c.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.f16647n = obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.f16647n);
        this.f16663z = obtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.f16663z);
        this.f30866c = b.f30071i[obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f30866c.f30072a)];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.f16639f.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else if (this.f16639f.getDrawable() == null) {
            kf.a aVar = new kf.a();
            this.f16642i = aVar;
            aVar.a(-10066330);
            this.f16639f.setImageDrawable(this.f16642i);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.f16640g.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else if (this.f16640g.getDrawable() == null) {
            p004if.b bVar = new p004if.b();
            this.f16643j = bVar;
            bVar.a(-10066330);
            this.f16640g.setImageDrawable(this.f16643j);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f16638e.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, c.c(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f16660w.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, c.c(12.0f)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor)) {
            super.I(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlAccentColor)) {
            u(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextPulling)) {
            this.A = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextPulling);
        } else {
            String str = J;
            if (str != null) {
                this.A = str;
            } else {
                this.A = context.getString(R.string.srl_header_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextLoading)) {
            this.C = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextLoading);
        } else {
            String str2 = L;
            if (str2 != null) {
                this.C = str2;
            } else {
                this.C = context.getString(R.string.srl_header_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRelease)) {
            this.D = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRelease);
        } else {
            String str3 = M;
            if (str3 != null) {
                this.D = str3;
            } else {
                this.D = context.getString(R.string.srl_header_release);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFinish)) {
            this.E = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFinish);
        } else {
            String str4 = N;
            if (str4 != null) {
                this.E = str4;
            } else {
                this.E = context.getString(R.string.srl_header_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFailed)) {
            this.F = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFailed);
        } else {
            String str5 = O;
            if (str5 != null) {
                this.F = str5;
            } else {
                this.F = context.getString(R.string.srl_header_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSecondary)) {
            this.H = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextSecondary);
        } else {
            String str6 = Q;
            if (str6 != null) {
                this.H = str6;
            } else {
                this.H = context.getString(R.string.srl_header_secondary);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRefreshing)) {
            this.B = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRefreshing);
        } else {
            String str7 = K;
            if (str7 != null) {
                this.B = str7;
            } else {
                this.B = context.getString(R.string.srl_header_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextUpdate)) {
            this.G = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextUpdate);
        } else {
            String str8 = P;
            if (str8 != null) {
                this.G = str8;
            } else {
                this.G = context.getString(R.string.srl_header_update);
            }
        }
        this.f16662y = new SimpleDateFormat(this.G, Locale.getDefault());
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.f16663z ? 0 : 8);
        this.f16638e.setText(isInEditMode() ? this.B : this.A);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && supportFragmentManager.getFragments().size() > 0) {
                T(new Date());
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f16658u += context.getClass().getName();
        this.f16661x = context.getSharedPreferences("ClassicsHeader", 0);
        T(new Date(this.f16661x.getLong(this.f16658u, System.currentTimeMillis())));
    }
}
