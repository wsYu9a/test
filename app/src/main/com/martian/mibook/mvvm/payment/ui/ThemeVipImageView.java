package com.martian.mibook.mvvm.payment.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.umeng.analytics.pro.f;
import k9.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/martian/mibook/mvvm/payment/ui/ThemeVipImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "p", "b", "I", "type", "", "value", "c", "Z", "()Z", "setVip", "(Z)V", "isVip", "d", "a", "setItemSelected", "isItemSelected", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ThemeVipImageView extends AppCompatImageView implements a {

    /* renamed from: b, reason: from kotlin metadata */
    public int type;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isVip;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isItemSelected;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThemeVipImageView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsItemSelected() {
        return this.isItemSelected;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ConfigSingleton.D().h(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        int i10 = this.type;
        if (i10 == 0) {
            setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), (this.isVip || ConfigSingleton.D().A0()) ? R.color.material_white : com.martian.libmars.R.color.day_text_color_primary), PorterDuff.Mode.SRC_IN));
            return;
        }
        if (i10 == 1) {
            setAlpha(ConfigSingleton.D().A0() ? 0.0f : 1.0f);
            if (this.isVip) {
                setImageResource(R.drawable.vip_bg_header_opened);
                return;
            } else {
                setImageResource(R.drawable.vip_bg_header);
                return;
            }
        }
        if (i10 == 2) {
            if (this.isVip) {
                setImageResource(R.drawable.vip_bg_dialog_header_opened);
                return;
            } else {
                setImageResource(R.drawable.vip_bg_dialog_header);
                return;
            }
        }
        if (i10 != 3) {
            setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), ConfigSingleton.D().A0() ? com.martian.libmars.R.color.night_background_card : com.martian.libmars.R.color.light_grey), PorterDuff.Mode.SRC_IN));
        } else if (this.isItemSelected) {
            setImageResource(R.drawable.icon_vip_checked);
            setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), this.isVip ? ConfigSingleton.D().A0() ? com.martian.libmars.R.color.night_text_color_primary : com.martian.libmars.R.color.vip_bg_opened_end_color : com.martian.libmars.R.color.vip_selector_color), PorterDuff.Mode.SRC_IN));
        } else {
            setImageResource(R.drawable.icon_vip_unchecked);
            setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), ConfigSingleton.D().A0() ? com.martian.libmars.R.color.night_text_color_thirdly : com.martian.libmars.R.color.day_text_color_thirdly), PorterDuff.Mode.SRC_IN));
        }
    }

    public final void setItemSelected(boolean z10) {
        this.isItemSelected = z10;
        p();
    }

    public final void setVip(boolean z10) {
        this.isVip = z10;
        p();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThemeVipImageView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ThemeVipImageView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThemeVipImageView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = -1;
        this.isVip = MiConfigSingleton.b2().K2();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ThemeVipImageView, i10, 0);
        try {
            this.type = obtainStyledAttributes.getInt(R.styleable.ThemeVipImageView_imageType, -1);
            obtainStyledAttributes.recycle();
            p();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
