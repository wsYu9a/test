package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookrackBatchTopViewBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bpDone;

    @NonNull
    public final ThemeTextView bpSelectAll;

    @NonNull
    public final ThemeTextView bpTitle;

    @NonNull
    public final ThemeLinearLayout brHeaderSetting;

    @NonNull
    private final ThemeLinearLayout rootView;

    private BookrackBatchTopViewBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = themeLinearLayout;
        this.bpDone = themeTextView;
        this.bpSelectAll = themeTextView2;
        this.bpTitle = themeTextView3;
        this.brHeaderSetting = themeLinearLayout2;
    }

    @NonNull
    public static BookrackBatchTopViewBinding bind(@NonNull View view) {
        int i10 = R.id.bp_done;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bp_select_all;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.bp_title;
                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView3 != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                    return new BookrackBatchTopViewBinding(themeLinearLayout, themeTextView, themeTextView2, themeTextView3, themeLinearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookrackBatchTopViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookrackBatchTopViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bookrack_batch_top_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
