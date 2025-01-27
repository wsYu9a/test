package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12815a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12816b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12817c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12818d;

    /* renamed from: e */
    @NonNull
    public final a2 f12819e;

    private v1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeImageView tvGenderFemale, @NonNull ThemeLinearLayout tvGenderItemRoot, @NonNull ThemeImageView tvGenderMale, @NonNull a2 tvGenderView) {
        this.f12815a = rootView;
        this.f12816b = tvGenderFemale;
        this.f12817c = tvGenderItemRoot;
        this.f12818d = tvGenderMale;
        this.f12819e = tvGenderView;
    }

    @NonNull
    public static v1 a(@NonNull View rootView) {
        int i2 = R.id.tv_gender_female;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.tv_gender_female);
        if (themeImageView != null) {
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
            i2 = R.id.tv_gender_male;
            ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.tv_gender_male);
            if (themeImageView2 != null) {
                i2 = R.id.tv_gender_view;
                View findViewById = rootView.findViewById(R.id.tv_gender_view);
                if (findViewById != null) {
                    return new v1(themeLinearLayout, themeImageView, themeLinearLayout, themeImageView2, a2.a(findViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static v1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_gender_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12815a;
    }
}
