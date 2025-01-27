package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class f2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11936a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11937b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11938c;

    /* renamed from: d */
    @NonNull
    public final View f11939d;

    private f2(@NonNull ThemeLinearLayout rootView, @NonNull ImageView ivCover, @NonNull ImageView ivCoverSelection, @NonNull View ivCoverShadow) {
        this.f11936a = rootView;
        this.f11937b = ivCover;
        this.f11938c = ivCoverSelection;
        this.f11939d = ivCoverShadow;
    }

    @NonNull
    public static f2 a(@NonNull View rootView) {
        int i2 = R.id.iv_cover;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_cover);
        if (imageView != null) {
            i2 = R.id.iv_cover_selection;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_cover_selection);
            if (imageView2 != null) {
                i2 = R.id.iv_cover_shadow;
                View findViewById = rootView.findViewById(R.id.iv_cover_shadow);
                if (findViewById != null) {
                    return new f2((ThemeLinearLayout) rootView, imageView, imageView2, findViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.cover_switch_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11936a;
    }
}
