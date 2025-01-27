package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.CountUpTextView;

/* loaded from: classes3.dex */
public final class MartianMoneyWithdrawViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12315a;

    /* renamed from: b */
    @NonNull
    public final TextView f12316b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12317c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12318d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12319e;

    /* renamed from: f */
    @NonNull
    public final TextView f12320f;

    /* renamed from: g */
    @NonNull
    public final CountUpTextView f12321g;

    /* renamed from: h */
    @NonNull
    public final ThemeImageView f12322h;

    /* renamed from: i */
    @NonNull
    public final ThemeImageView f12323i;

    /* renamed from: j */
    @NonNull
    public final TextView f12324j;

    /* renamed from: k */
    @NonNull
    public final TextView f12325k;

    /* renamed from: l */
    @NonNull
    public final RelativeLayout f12326l;

    public MartianMoneyWithdrawViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull CountUpTextView countUpTextView, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout) {
        this.f12315a = linearLayout;
        this.f12316b = textView;
        this.f12317c = imageView;
        this.f12318d = themeLinearLayout;
        this.f12319e = imageView2;
        this.f12320f = textView2;
        this.f12321g = countUpTextView;
        this.f12322h = themeImageView;
        this.f12323i = themeImageView2;
        this.f12324j = textView3;
        this.f12325k = textView4;
        this.f12326l = relativeLayout;
    }

    @NonNull
    public static MartianMoneyWithdrawViewBinding a(@NonNull View view) {
        int i10 = R.id.martian_desc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.martian_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.martian_more;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.martian_more_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.martian_more_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.martian_num;
                            CountUpTextView countUpTextView = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
                            if (countUpTextView != null) {
                                i10 = R.id.martian_query_icon;
                                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (themeImageView != null) {
                                    i10 = R.id.martian_text;
                                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (themeImageView2 != null) {
                                        i10 = R.id.martian_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.martian_unit;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.martian_view;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                if (relativeLayout != null) {
                                                    return new MartianMoneyWithdrawViewBinding((LinearLayout) view, textView, imageView, themeLinearLayout, imageView2, textView2, countUpTextView, themeImageView, themeImageView2, textView3, textView4, relativeLayout);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianMoneyWithdrawViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MartianMoneyWithdrawViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_money_withdraw_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12315a;
    }
}
