package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityEnterBinding implements ViewBinding {

    @NonNull
    public final ViewStub genderGuide;

    @NonNull
    public final ImageView iconLogo;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final FrameLayout splashContainer;

    private ActivityEnterBinding(@NonNull RelativeLayout relativeLayout, @NonNull ViewStub viewStub, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.genderGuide = viewStub;
        this.iconLogo = imageView;
        this.splashContainer = frameLayout;
    }

    @NonNull
    public static ActivityEnterBinding bind(@NonNull View view) {
        int i10 = R.id.gender_guide;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.icon_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.splash_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                if (frameLayout != null) {
                    return new ActivityEnterBinding((RelativeLayout) view, viewStub, imageView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityEnterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityEnterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_enter, viewGroup, false);
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
