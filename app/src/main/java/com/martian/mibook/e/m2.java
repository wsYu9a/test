package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12346a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12347b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12348c;

    /* renamed from: d */
    @NonNull
    public final View f12349d;

    /* renamed from: e */
    @NonNull
    public final TextView f12350e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12351f;

    /* renamed from: g */
    @NonNull
    public final View f12352g;

    /* renamed from: h */
    @NonNull
    public final View f12353h;

    /* renamed from: i */
    @NonNull
    public final TextView f12354i;

    private m2(@NonNull RelativeLayout rootView, @NonNull ThemeImageView dialogClose, @NonNull ThemeTextView dialogNotarize, @NonNull View dialogShadeView, @NonNull TextView dialogTitle, @NonNull LinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop, @NonNull TextView rateDesc) {
        this.f12346a = rootView;
        this.f12347b = dialogClose;
        this.f12348c = dialogNotarize;
        this.f12349d = dialogShadeView;
        this.f12350e = dialogTitle;
        this.f12351f = dialogView;
        this.f12352g = dialogViewBottom;
        this.f12353h = dialogViewTop;
        this.f12354i = rateDesc;
    }

    @NonNull
    public static m2 a(@NonNull View rootView) {
        int i2 = R.id.dialog_close;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.dialog_close);
        if (themeImageView != null) {
            i2 = R.id.dialog_notarize;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.dialog_notarize);
            if (themeTextView != null) {
                i2 = R.id.dialog_shade_view;
                View findViewById = rootView.findViewById(R.id.dialog_shade_view);
                if (findViewById != null) {
                    i2 = R.id.dialog_title;
                    TextView textView = (TextView) rootView.findViewById(R.id.dialog_title);
                    if (textView != null) {
                        i2 = R.id.dialog_view;
                        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.dialog_view);
                        if (linearLayout != null) {
                            i2 = R.id.dialog_view_bottom;
                            View findViewById2 = rootView.findViewById(R.id.dialog_view_bottom);
                            if (findViewById2 != null) {
                                i2 = R.id.dialog_view_top;
                                View findViewById3 = rootView.findViewById(R.id.dialog_view_top);
                                if (findViewById3 != null) {
                                    i2 = R.id.rate_desc;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.rate_desc);
                                    if (textView2 != null) {
                                        return new m2((RelativeLayout) rootView, themeImageView, themeTextView, findViewById, textView, linearLayout, findViewById2, findViewById3, textView2);
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
    public static m2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_rate_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12346a;
    }
}
