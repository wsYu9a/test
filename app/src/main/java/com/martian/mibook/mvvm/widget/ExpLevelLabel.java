package com.martian.mibook.mvvm.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.mibook.R;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0006*\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/martian/mibook/mvvm/widget/ExpLevelLabel;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "level", "", "setLevel", "(I)V", "", "startColor", "endColor", "b", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "(I)I", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "labelView", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nExpLevelLabel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpLevelLabel.kt\ncom/martian/mibook/mvvm/widget/ExpLevelLabel\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,69:1\n262#2,2:70\n262#2,2:72\n*S KotlinDebug\n*F\n+ 1 ExpLevelLabel.kt\ncom/martian/mibook/mvvm/widget/ExpLevelLabel\n*L\n45#1:70,2\n50#1:72,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ExpLevelLabel extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final ImageView iconView;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final TextView labelView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpLevelLabel(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int a(int i10) {
        return (int) (i10 * getResources().getDisplayMetrics().density);
    }

    public final void b(String startColor, String endColor) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(startColor), Color.parseColor(endColor)});
        gradientDrawable.setCornerRadius(20.0f);
        this.labelView.setBackground(gradientDrawable);
    }

    @SuppressLint({"SetTextI18n"})
    public final void setLevel(int level) {
        this.labelView.setText("Lv" + level);
        Triple triple = level < 10 ? new Triple("#CCCCCC", "#E3E3E3", null) : level < 20 ? new Triple("#9DABC4", "#CCD8E8", null) : level < 30 ? new Triple("#8792CE", "#B7BFE8", Integer.valueOf(R.drawable.icon_user_level_20)) : level < 40 ? new Triple("#896EBE", "#A899D7", Integer.valueOf(R.drawable.icon_user_level_30)) : level < 50 ? new Triple("#EE634D", "#E4825B", Integer.valueOf(R.drawable.icon_user_level_40)) : new Triple("#424356", "#56576F", Integer.valueOf(R.drawable.icon_user_level_50));
        String str = (String) triple.component1();
        String str2 = (String) triple.component2();
        Integer num = (Integer) triple.component3();
        b(str, str2);
        if (level < 20 || num == null) {
            this.iconView.setVisibility(8);
            this.labelView.setPaddingRelative(a(4), 0, a(4), 0);
            ViewGroup.LayoutParams layoutParams = this.labelView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
        } else {
            this.iconView.setVisibility(0);
            this.iconView.setImageResource(num.intValue());
            this.labelView.setPaddingRelative(a(14), 0, a(4), 0);
            ViewGroup.LayoutParams layoutParams2 = this.labelView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(a(2));
        }
        this.labelView.requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpLevelLabel(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpLevelLabel(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.user_level_label, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.iconView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.label);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.labelView = (TextView) findViewById2;
    }

    public /* synthetic */ ExpLevelLabel(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
