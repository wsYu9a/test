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
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityTeenagerGuideBinding implements ViewBinding {

    @NonNull
    public final TextView intimateCivilization;

    @NonNull
    public final ImageView intimateIcon;

    @NonNull
    public final TextView intimateLink;

    @NonNull
    public final LinearLayout privacyIntimate;

    @NonNull
    private final ThemeRelativeLayout rootView;

    private ActivityTeenagerGuideBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout) {
        this.rootView = themeRelativeLayout;
        this.intimateCivilization = textView;
        this.intimateIcon = imageView;
        this.intimateLink = textView2;
        this.privacyIntimate = linearLayout;
    }

    @NonNull
    public static ActivityTeenagerGuideBinding bind(@NonNull View view) {
        int i10 = R.id.intimate_civilization;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.intimate_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.intimate_link;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView2 != null) {
                    i10 = R.id.privacy_intimate;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        return new ActivityTeenagerGuideBinding((ThemeRelativeLayout) view, textView, imageView, textView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityTeenagerGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTeenagerGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_teenager_guide, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
