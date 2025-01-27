package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ReadingRecordSyncBottomBinding implements ViewBinding {

    @NonNull
    public final LinearLayout readingRecordSyncView;

    @NonNull
    public final ThemeTextView recordSync;

    @NonNull
    public final ThemeImageView recordSyncClose;

    @NonNull
    public final ThemeLinearLayout recordSyncFloatView;

    @NonNull
    public final RelativeLayout recordSyncView;

    @NonNull
    private final LinearLayout rootView;

    private ReadingRecordSyncBottomBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.readingRecordSyncView = linearLayout2;
        this.recordSync = themeTextView;
        this.recordSyncClose = themeImageView;
        this.recordSyncFloatView = themeLinearLayout;
        this.recordSyncView = relativeLayout;
    }

    @NonNull
    public static ReadingRecordSyncBottomBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.record_sync;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.record_sync_close;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.record_sync_float_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.record_sync_view;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                    if (relativeLayout != null) {
                        return new ReadingRecordSyncBottomBinding(linearLayout, linearLayout, themeTextView, themeImageView, themeLinearLayout, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingRecordSyncBottomBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingRecordSyncBottomBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_record_sync_bottom, viewGroup, false);
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
