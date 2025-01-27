package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class o2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12467a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12468b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12469c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12470d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12471e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12472f;

    /* renamed from: g */
    @NonNull
    public final View f12473g;

    /* renamed from: h */
    @NonNull
    public final View f12474h;

    /* renamed from: i */
    @NonNull
    public final CheckBox f12475i;

    /* renamed from: j */
    @NonNull
    public final ThemeLinearLayout f12476j;

    @NonNull
    public final CheckBox k;

    @NonNull
    public final ThemeLinearLayout l;

    @NonNull
    public final View m;

    private o2(@NonNull RelativeLayout rootView, @NonNull ThemeLinearLayout dialogCheckView, @NonNull ThemeImageView dialogClose, @NonNull ThemeTextView dialogNotarize, @NonNull ThemeTextView dialogTitle, @NonNull ThemeLinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop, @NonNull CheckBox dialogWxCheck, @NonNull ThemeLinearLayout dialogWxView, @NonNull CheckBox dialogZfbCheck, @NonNull ThemeLinearLayout dialogZfbView, @NonNull View durationConversionView) {
        this.f12467a = rootView;
        this.f12468b = dialogCheckView;
        this.f12469c = dialogClose;
        this.f12470d = dialogNotarize;
        this.f12471e = dialogTitle;
        this.f12472f = dialogView;
        this.f12473g = dialogViewBottom;
        this.f12474h = dialogViewTop;
        this.f12475i = dialogWxCheck;
        this.f12476j = dialogWxView;
        this.k = dialogZfbCheck;
        this.l = dialogZfbView;
        this.m = durationConversionView;
    }

    @NonNull
    public static o2 a(@NonNull View rootView) {
        int i2 = R.id.dialog_check_view;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.dialog_check_view);
        if (themeLinearLayout != null) {
            i2 = R.id.dialog_close;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.dialog_close);
            if (themeImageView != null) {
                i2 = R.id.dialog_notarize;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.dialog_notarize);
                if (themeTextView != null) {
                    i2 = R.id.dialog_title;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.dialog_title);
                    if (themeTextView2 != null) {
                        i2 = R.id.dialog_view;
                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.dialog_view);
                        if (themeLinearLayout2 != null) {
                            i2 = R.id.dialog_view_bottom;
                            View findViewById = rootView.findViewById(R.id.dialog_view_bottom);
                            if (findViewById != null) {
                                i2 = R.id.dialog_view_top;
                                View findViewById2 = rootView.findViewById(R.id.dialog_view_top);
                                if (findViewById2 != null) {
                                    i2 = R.id.dialog_wx_check;
                                    CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.dialog_wx_check);
                                    if (checkBox != null) {
                                        i2 = R.id.dialog_wx_view;
                                        ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.dialog_wx_view);
                                        if (themeLinearLayout3 != null) {
                                            i2 = R.id.dialog_zfb_check;
                                            CheckBox checkBox2 = (CheckBox) rootView.findViewById(R.id.dialog_zfb_check);
                                            if (checkBox2 != null) {
                                                i2 = R.id.dialog_zfb_view;
                                                ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) rootView.findViewById(R.id.dialog_zfb_view);
                                                if (themeLinearLayout4 != null) {
                                                    i2 = R.id.duration_conversion_view;
                                                    View findViewById3 = rootView.findViewById(R.id.duration_conversion_view);
                                                    if (findViewById3 != null) {
                                                        return new o2((RelativeLayout) rootView, themeLinearLayout, themeImageView, themeTextView, themeTextView2, themeLinearLayout2, findViewById, findViewById2, checkBox, themeLinearLayout3, checkBox2, themeLinearLayout4, findViewById3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static o2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_recharge, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12467a;
    }
}
