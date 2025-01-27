package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookShelfBatchBottomViewBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView batchDetail;

    @NonNull
    public final ThemeLinearLayout batchDetailView;

    @NonNull
    public final ThemeTextView bpCategory;

    @NonNull
    public final ThemeLinearLayout bpCategoryView;

    @NonNull
    public final TextView bpDelete;

    @NonNull
    public final ThemeLinearLayout bpDeleteView;

    @NonNull
    public final ThemeTextView bpFlagTop;

    @NonNull
    public final ThemeLinearLayout bpFlagTopView;

    @NonNull
    private final LinearLayout rootView;

    private BookShelfBatchBottomViewBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull TextView textView, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeTextView themeTextView3, @NonNull ThemeLinearLayout themeLinearLayout4) {
        this.rootView = linearLayout;
        this.batchDetail = themeTextView;
        this.batchDetailView = themeLinearLayout;
        this.bpCategory = themeTextView2;
        this.bpCategoryView = themeLinearLayout2;
        this.bpDelete = textView;
        this.bpDeleteView = themeLinearLayout3;
        this.bpFlagTop = themeTextView3;
        this.bpFlagTopView = themeLinearLayout4;
    }

    @NonNull
    public static BookShelfBatchBottomViewBinding bind(@NonNull View view) {
        int i10 = R.id.batch_detail;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.batch_detail_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.bp_category;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.bp_category_view;
                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout2 != null) {
                        i10 = R.id.bp_delete;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.bp_delete_view;
                            ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout3 != null) {
                                i10 = R.id.bp_flag_top;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.bp_flag_top_view;
                                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (themeLinearLayout4 != null) {
                                        return new BookShelfBatchBottomViewBinding((LinearLayout) view, themeTextView, themeLinearLayout, themeTextView2, themeLinearLayout2, textView, themeLinearLayout3, themeTextView3, themeLinearLayout4);
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
    public static BookShelfBatchBottomViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookShelfBatchBottomViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_shelf_batch_bottom_view, viewGroup, false);
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
