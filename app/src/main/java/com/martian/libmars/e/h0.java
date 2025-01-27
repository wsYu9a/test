package com.martian.libmars.e;

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
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.CountUpTextView;

/* loaded from: classes2.dex */
public final class h0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f9987a;

    /* renamed from: b */
    @NonNull
    public final TextView f9988b;

    /* renamed from: c */
    @NonNull
    public final ImageView f9989c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f9990d;

    /* renamed from: e */
    @NonNull
    public final ImageView f9991e;

    /* renamed from: f */
    @NonNull
    public final TextView f9992f;

    /* renamed from: g */
    @NonNull
    public final CountUpTextView f9993g;

    /* renamed from: h */
    @NonNull
    public final ThemeImageView f9994h;

    /* renamed from: i */
    @NonNull
    public final ThemeImageView f9995i;

    /* renamed from: j */
    @NonNull
    public final TextView f9996j;

    @NonNull
    public final TextView k;

    @NonNull
    public final RelativeLayout l;

    private h0(@NonNull LinearLayout rootView, @NonNull TextView martianDesc, @NonNull ImageView martianIcon, @NonNull ThemeLinearLayout martianMore, @NonNull ImageView martianMoreIcon, @NonNull TextView martianMoreName, @NonNull CountUpTextView martianNum, @NonNull ThemeImageView martianQueryIcon, @NonNull ThemeImageView martianText, @NonNull TextView martianTitle, @NonNull TextView martianUnit, @NonNull RelativeLayout martianView) {
        this.f9987a = rootView;
        this.f9988b = martianDesc;
        this.f9989c = martianIcon;
        this.f9990d = martianMore;
        this.f9991e = martianMoreIcon;
        this.f9992f = martianMoreName;
        this.f9993g = martianNum;
        this.f9994h = martianQueryIcon;
        this.f9995i = martianText;
        this.f9996j = martianTitle;
        this.k = martianUnit;
        this.l = martianView;
    }

    @NonNull
    public static h0 a(@NonNull View rootView) {
        int i2 = R.id.martian_desc;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = R.id.martian_icon;
            ImageView imageView = (ImageView) rootView.findViewById(i2);
            if (imageView != null) {
                i2 = R.id.martian_more;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                if (themeLinearLayout != null) {
                    i2 = R.id.martian_more_icon;
                    ImageView imageView2 = (ImageView) rootView.findViewById(i2);
                    if (imageView2 != null) {
                        i2 = R.id.martian_more_name;
                        TextView textView2 = (TextView) rootView.findViewById(i2);
                        if (textView2 != null) {
                            i2 = R.id.martian_num;
                            CountUpTextView countUpTextView = (CountUpTextView) rootView.findViewById(i2);
                            if (countUpTextView != null) {
                                i2 = R.id.martian_query_icon;
                                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
                                if (themeImageView != null) {
                                    i2 = R.id.martian_text;
                                    ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(i2);
                                    if (themeImageView2 != null) {
                                        i2 = R.id.martian_title;
                                        TextView textView3 = (TextView) rootView.findViewById(i2);
                                        if (textView3 != null) {
                                            i2 = R.id.martian_unit;
                                            TextView textView4 = (TextView) rootView.findViewById(i2);
                                            if (textView4 != null) {
                                                i2 = R.id.martian_view;
                                                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(i2);
                                                if (relativeLayout != null) {
                                                    return new h0((LinearLayout) rootView, textView, imageView, themeLinearLayout, imageView2, textView2, countUpTextView, themeImageView, themeImageView2, textView3, textView4, relativeLayout);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_money_withdraw_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9987a;
    }
}
