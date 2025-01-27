package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12993a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12994b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f12995c;

    private y5(@NonNull RelativeLayout rootView, @NonNull ImageView guideHandIcon, @NonNull RelativeLayout guideView) {
        this.f12993a = rootView;
        this.f12994b = guideHandIcon;
        this.f12995c = guideView;
    }

    @NonNull
    public static y5 a(@NonNull View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.guide_hand_icon);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.guide_hand_icon)));
        }
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        return new y5(relativeLayout, imageView, relativeLayout);
    }

    @NonNull
    public static y5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_first_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12993a;
    }
}
