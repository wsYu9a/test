package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ArchiveTagItemBinding implements ViewBinding {

    @NonNull
    private final ThemeTextView rootView;

    @NonNull
    public final ThemeTextView tvTagName;

    private ArchiveTagItemBinding(@NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeTextView;
        this.tvTagName = themeTextView2;
    }

    @NonNull
    public static ArchiveTagItemBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ThemeTextView themeTextView = (ThemeTextView) view;
        return new ArchiveTagItemBinding(themeTextView, themeTextView);
    }

    @NonNull
    public static ArchiveTagItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ArchiveTagItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.archive_tag_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeTextView getRoot() {
        return this.rootView;
    }
}
