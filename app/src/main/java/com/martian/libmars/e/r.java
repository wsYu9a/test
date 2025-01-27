package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class r implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f10037a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f10038b;

    /* renamed from: c */
    @NonNull
    public final ImageView f10039c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f10040d;

    /* renamed from: e */
    @NonNull
    public final ImageView f10041e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f10042f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f10043g;

    private r(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView btOperate, @NonNull ImageView imgTipLogo, @NonNull LinearLayout tvLoading, @NonNull ImageView tvLoadingIcon, @NonNull ThemeTextView tvTips, @NonNull ThemeTextView tvTipsRetryHint) {
        this.f10037a = rootView;
        this.f10038b = btOperate;
        this.f10039c = imgTipLogo;
        this.f10040d = tvLoading;
        this.f10041e = tvLoadingIcon;
        this.f10042f = tvTips;
        this.f10043g = tvTipsRetryHint;
    }

    @NonNull
    public static r a(@NonNull View rootView) {
        int i2 = R.id.bt_operate;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.img_tip_logo;
            ImageView imageView = (ImageView) rootView.findViewById(i2);
            if (imageView != null) {
                i2 = R.id.tv_loading;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
                if (linearLayout != null) {
                    i2 = R.id.tv_loading_icon;
                    ImageView imageView2 = (ImageView) rootView.findViewById(i2);
                    if (imageView2 != null) {
                        i2 = R.id.tv_tips;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                        if (themeTextView2 != null) {
                            i2 = R.id.tv_tips_retry_hint;
                            ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                            if (themeTextView3 != null) {
                                return new r((ThemeLinearLayout) rootView, themeTextView, imageView, linearLayout, imageView2, themeTextView2, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static r c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_loading_tip, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f10037a;
    }
}
