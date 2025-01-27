package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class LibmarsPopupwindowPermissionBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12281a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12282b;

    /* renamed from: c */
    @NonNull
    public final TextView f12283c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12284d;

    /* renamed from: e */
    @NonNull
    public final TextView f12285e;

    public LibmarsPopupwindowPermissionBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView2) {
        this.f12281a = relativeLayout;
        this.f12282b = themeTextView;
        this.f12283c = textView;
        this.f12284d = themeTextView2;
        this.f12285e = textView2;
    }

    @NonNull
    public static LibmarsPopupwindowPermissionBinding a(@NonNull View view) {
        int i10 = R.id.privacy_agree;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.privacy_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.privacy_known;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.privacy_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        return new LibmarsPopupwindowPermissionBinding((RelativeLayout) view, themeTextView, textView, themeTextView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsPopupwindowPermissionBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsPopupwindowPermissionBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_popupwindow_permission, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12281a;
    }
}
