package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ItemSlideModeBinding implements ViewBinding {

    @NonNull
    public final ImageView ivMode;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final RoundedLayout roundLayout;

    @NonNull
    public final ReaderThemeTextView tvModeName;

    private ItemSlideModeBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeTextView readerThemeTextView) {
        this.rootView = linearLayout;
        this.ivMode = imageView;
        this.roundLayout = roundedLayout;
        this.tvModeName = readerThemeTextView;
    }

    @NonNull
    public static ItemSlideModeBinding bind(@NonNull View view) {
        int i10 = R.id.iv_mode;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.round_layout;
            RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
            if (roundedLayout != null) {
                i10 = R.id.tv_mode_name;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    return new ItemSlideModeBinding((LinearLayout) view, imageView, roundedLayout, readerThemeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemSlideModeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemSlideModeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_slide_mode, viewGroup, false);
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
