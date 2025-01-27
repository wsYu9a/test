package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public final class ReadingRecordBatchBottomBinding implements ViewBinding {

    @NonNull
    public final ImageView ivDelete;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ThemeTextView rrAddBookstore;

    @NonNull
    public final ThemeLinearLayout rrAddBookstoreView;

    @NonNull
    public final TextView rrDelete;

    @NonNull
    public final ThemeLinearLayout rrDeleteView;

    private ReadingRecordBatchBottomBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull TextView textView, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = linearLayout;
        this.ivDelete = imageView;
        this.rrAddBookstore = themeTextView;
        this.rrAddBookstoreView = themeLinearLayout;
        this.rrDelete = textView;
        this.rrDeleteView = themeLinearLayout2;
    }

    @NonNull
    public static ReadingRecordBatchBottomBinding bind(@NonNull View view) {
        int i10 = R.id.iv_delete;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.rr_add_bookstore;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.rr_add_bookstore_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.rr_delete;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.rr_delete_view;
                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout2 != null) {
                            return new ReadingRecordBatchBottomBinding((LinearLayout) view, imageView, themeTextView, themeLinearLayout, textView, themeLinearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingRecordBatchBottomBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingRecordBatchBottomBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_record_batch_bottom, viewGroup, false);
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
