package com.martian.mibook.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.umeng.analytics.pro.f;
import java.text.SimpleDateFormat;
import java.util.Locale;
import k9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001f\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/martian/mibook/mvvm/widget/MiClassicsHeader;", "Lcom/scwang/smart/refresh/header/ClassicsHeader;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "headerBackgroundColorType", "(Landroid/content/Context;Ljava/lang/Integer;)V", "", "a0", "Z", "()V", "onAttachedToWindow", "onDetachedFromWindow", "p", "R", "Ljava/lang/Integer;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MiClassicsHeader extends ClassicsHeader implements a {

    /* renamed from: R, reason: from kotlin metadata */
    @l
    public Integer headerBackgroundColorType;

    public MiClassicsHeader(@l Context context, @l AttributeSet attributeSet) {
        super(context);
        this.headerBackgroundColorType = 0;
        a0(context, attributeSet);
        Z();
    }

    private final void Z() {
        int j02 = ConfigSingleton.D().j0();
        TextView textView = this.f16638e;
        if (textView != null) {
            textView.setTextColor(j02);
        }
        TextView textView2 = this.f16660w;
        if (textView2 != null) {
            textView2.setTextColor(j02);
        }
        this.f16642i.a(j02);
        if (ConfigSingleton.D().A0()) {
            Integer num = this.headerBackgroundColorType;
            if (num != null && num.intValue() == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.night_background_card));
            } else {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.night_background));
            }
        } else {
            Integer num2 = this.headerBackgroundColorType;
            if (num2 != null && num2.intValue() == 1) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.light_grey_bg));
            } else {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
            }
        }
        this.f16639f.getLayoutParams().height = ConfigSingleton.i(18.0f);
        this.f16639f.getLayoutParams().width = ConfigSingleton.i(15.0f);
        this.E = this.B;
        H(50);
    }

    private final void a0(Context r82, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = r82 != null ? r82.obtainStyledAttributes(attributeSet, com.martian.mibook.R.styleable.MiClassicsHeader) : null;
        this.headerBackgroundColorType = obtainStyledAttributes != null ? Integer.valueOf(obtainStyledAttributes.getInt(com.martian.mibook.R.styleable.MiClassicsHeader_headerBackgroundColorType, 0)) : null;
        String string = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextPulling) : null;
        String string2 = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextRefreshing) : null;
        String string3 = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextFailed) : null;
        String string4 = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextFinish) : null;
        String string5 = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextRelease) : null;
        String string6 = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextSecondary) : null;
        String string7 = obtainStyledAttributes != null ? obtainStyledAttributes.getString(com.martian.mibook.R.styleable.MiClassicsHeader_headerTextUpdate) : null;
        if (!TextUtils.isEmpty(string)) {
            this.A = string;
        }
        if (!TextUtils.isEmpty(string2)) {
            this.B = string2;
        }
        if (!TextUtils.isEmpty(string3)) {
            this.F = string3;
        }
        if (!TextUtils.isEmpty(string4)) {
            this.E = string4;
        }
        if (!TextUtils.isEmpty(string5)) {
            this.D = string5;
        }
        if (!TextUtils.isEmpty(string6)) {
            this.H = string6;
        }
        if (!TextUtils.isEmpty(string7)) {
            this.G = string7;
            this.f16662y = new SimpleDateFormat(this.G, Locale.getDefault());
            T(this.f16659v);
        }
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
        TextView textView = this.f16638e;
        if (textView != null) {
            textView.setTextColor(j02);
        }
        TextView textView2 = this.f16660w;
        if (textView2 != null) {
            textView2.setTextColor(j02);
        }
        this.f16642i.a(j02);
        if (ConfigSingleton.D().A0()) {
            Integer num = this.headerBackgroundColorType;
            if (num != null && num.intValue() == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.night_background_card));
                return;
            } else {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.night_background));
                return;
            }
        }
        Integer num2 = this.headerBackgroundColorType;
        if (num2 != null && num2.intValue() == 1) {
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.light_grey_bg));
        } else {
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        }
    }

    public MiClassicsHeader(@l Context context, @l Integer num) {
        super(context);
        this.headerBackgroundColorType = num;
        Z();
    }

    public /* synthetic */ MiClassicsHeader(Context context, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? 0 : num);
    }
}
