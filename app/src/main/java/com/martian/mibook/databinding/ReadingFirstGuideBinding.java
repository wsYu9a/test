package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ReadingFirstGuideBinding implements ViewBinding {

    @NonNull
    public final ImageView guideHandIcon;

    @NonNull
    public final RelativeLayout guideView;

    @NonNull
    private final RelativeLayout rootView;

    private ReadingFirstGuideBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.guideHandIcon = imageView;
        this.guideView = relativeLayout2;
    }

    @NonNull
    public static ReadingFirstGuideBinding bind(@NonNull View view) {
        int i10 = R.id.guide_hand_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        RelativeLayout relativeLayout = (RelativeLayout) view;
        return new ReadingFirstGuideBinding(relativeLayout, imageView, relativeLayout);
    }

    @NonNull
    public static ReadingFirstGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingFirstGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_first_guide, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
