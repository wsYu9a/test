package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ScanningBookTipsTopBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout recordSyncFloatView;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final LinearLayout scanningBookTipsView;

    @NonNull
    public final ThemeImageView scanningTipsClose;

    @NonNull
    public final ThemeTextView tvGoAuthorize;

    private ScanningBookTipsTopBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout2, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView) {
        this.rootView = linearLayout;
        this.recordSyncFloatView = themeLinearLayout;
        this.scanningBookTipsView = linearLayout2;
        this.scanningTipsClose = themeImageView;
        this.tvGoAuthorize = themeTextView;
    }

    @NonNull
    public static ScanningBookTipsTopBinding bind(@NonNull View view) {
        int i10 = R.id.record_sync_float_view;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R.id.scanning_tips_close;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.tv_go_authorize;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new ScanningBookTipsTopBinding(linearLayout, themeLinearLayout, linearLayout, themeImageView, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ScanningBookTipsTopBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ScanningBookTipsTopBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.scanning_book_tips_top, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
