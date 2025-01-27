package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12543a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12544b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12545c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12546d;

    /* renamed from: e */
    @NonNull
    public final TextView f12547e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12548f;

    private q(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeTextView orderBack, @NonNull ThemeTextView orderMoney, @NonNull LinearLayout orderMoneyView, @NonNull TextView orderStatus, @NonNull ImageView orderStatusLogo) {
        this.f12543a = rootView;
        this.f12544b = orderBack;
        this.f12545c = orderMoney;
        this.f12546d = orderMoneyView;
        this.f12547e = orderStatus;
        this.f12548f = orderStatusLogo;
    }

    @NonNull
    public static q a(@NonNull View rootView) {
        int i2 = R.id.order_back;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.order_back);
        if (themeTextView != null) {
            i2 = R.id.order_money;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.order_money);
            if (themeTextView2 != null) {
                i2 = R.id.order_money_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.order_money_view);
                if (linearLayout != null) {
                    i2 = R.id.order_status;
                    TextView textView = (TextView) rootView.findViewById(R.id.order_status);
                    if (textView != null) {
                        i2 = R.id.order_status_logo;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.order_status_logo);
                        if (imageView != null) {
                            return new q((ThemeRelativeLayout) rootView, themeTextView, themeTextView2, linearLayout, textView, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_recharge_order, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12543a;
    }
}
