package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class LibmarsPopupwindowPrivacyBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12286a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12287b;

    /* renamed from: c */
    @NonNull
    public final TextView f12288c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12289d;

    /* renamed from: e */
    @NonNull
    public final ScrollView f12290e;

    /* renamed from: f */
    @NonNull
    public final TextView f12291f;

    public LibmarsPopupwindowPrivacyBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull ScrollView scrollView, @NonNull TextView textView2) {
        this.f12286a = relativeLayout;
        this.f12287b = themeTextView;
        this.f12288c = textView;
        this.f12289d = themeTextView2;
        this.f12290e = scrollView;
        this.f12291f = textView2;
    }

    @NonNull
    public static LibmarsPopupwindowPrivacyBinding a(@NonNull View view) {
        int i10 = R.id.privacy_agree;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.privacy_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.privacy_known;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.privacy_scroll_view;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i10);
                    if (scrollView != null) {
                        i10 = R.id.privacy_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            return new LibmarsPopupwindowPrivacyBinding((RelativeLayout) view, themeTextView, textView, themeTextView2, scrollView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsPopupwindowPrivacyBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsPopupwindowPrivacyBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_popupwindow_privacy, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12286a;
    }
}
