package com.martian.mibook.mvvm.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.umeng.analytics.pro.f;
import k9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB)\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J#\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/martian/mibook/mvvm/widget/MiClassicsFooter;", "Lcom/scwang/smart/refresh/footer/ClassicsFooter;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "footerBackgroundColorType", "", "isReaderTheme", "(Landroid/content/Context;Ljava/lang/Integer;Z)V", "", "Q", "()V", "onAttachedToWindow", "onDetachedFromWindow", "p", "R", "J", "Ljava/lang/Integer;", "K", "Z", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "L", "Landroid/graphics/Typeface;", "typeface", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class MiClassicsFooter extends ClassicsFooter implements a {

    /* renamed from: J, reason: from kotlin metadata */
    @l
    public Integer footerBackgroundColorType;

    /* renamed from: K, reason: from kotlin metadata */
    public boolean isReaderTheme;

    /* renamed from: L, reason: from kotlin metadata */
    public Typeface typeface;

    public MiClassicsFooter(@l Context context, @l AttributeSet attributeSet) {
        super(context);
        this.footerBackgroundColorType = 0;
        this.typeface = Typeface.DEFAULT;
        R(context, attributeSet);
        Q();
    }

    private final void Q() {
        p();
        this.f16639f.getLayoutParams().height = ConfigSingleton.i(18.0f);
        this.f16639f.getLayoutParams().width = ConfigSingleton.i(15.0f);
        this.f16655y = "";
        this.f16639f.setAlpha(0.0f);
        this.f16640g.setAlpha(0.0f);
        H(50);
    }

    public final void R(Context r32, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = r32 != null ? r32.obtainStyledAttributes(attributeSet, R.styleable.MiClassicsFooter) : null;
        this.footerBackgroundColorType = obtainStyledAttributes != null ? Integer.valueOf(obtainStyledAttributes.getInt(R.styleable.MiClassicsFooter_footerBackgroundColorType, 0)) : null;
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        int j02 = ConfigSingleton.D().j0();
        if (this.isReaderTheme) {
            TextView textView = this.f16638e;
            if (textView != null) {
                textView.setTextSize(14.0f);
            }
            j02 = MiConfigSingleton.b2().h2().q();
            Typeface g10 = MiConfigSingleton.b2().i2().g();
            if (this.typeface != g10) {
                this.typeface = g10;
                TextView textView2 = this.f16638e;
                if (textView2 != null) {
                    textView2.setTypeface(g10);
                }
                TextView textView3 = this.f16638e;
                if (textView3 != null) {
                    textView3.setIncludeFontPadding(g10 == Typeface.DEFAULT);
                }
            }
        }
        TextView textView4 = this.f16638e;
        if (textView4 != null) {
            textView4.setTextColor(j02);
        }
        this.f16642i.a(j02);
        if (ConfigSingleton.D().A0()) {
            Integer num = this.footerBackgroundColorType;
            if (num != null && num.intValue() == 3) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.transparent));
                return;
            }
            Integer num2 = this.footerBackgroundColorType;
            if (num2 != null && num2.intValue() == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.night_background_card));
                return;
            } else {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.night_background));
                return;
            }
        }
        Integer num3 = this.footerBackgroundColorType;
        if (num3 != null && num3.intValue() == 1) {
            setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.light_grey_bg));
            return;
        }
        Integer num4 = this.footerBackgroundColorType;
        if (num4 != null && num4.intValue() == 3) {
            setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.transparent));
        } else {
            setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.white));
        }
    }

    public MiClassicsFooter(@l Context context, @l Integer num, boolean z10) {
        super(context);
        this.footerBackgroundColorType = 0;
        this.typeface = Typeface.DEFAULT;
        this.footerBackgroundColorType = num;
        this.isReaderTheme = z10;
        Q();
    }

    public /* synthetic */ MiClassicsFooter(Context context, Integer num, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? 0 : num, (i10 & 4) != 0 ? false : z10);
    }
}
