package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.mibook.ui.FlowLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11890a;

    /* renamed from: b */
    @NonNull
    public final ThemeView f11891b;

    /* renamed from: c */
    @NonNull
    public final FlowLayout f11892c;

    /* renamed from: d */
    @NonNull
    public final FlowLayout f11893d;

    /* renamed from: e */
    @NonNull
    public final FlowLayout f11894e;

    /* renamed from: f */
    @NonNull
    public final FlowLayout f11895f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f11896g;

    private e2(@NonNull LinearLayout rootView, @NonNull ThemeView categoryDivider, @NonNull FlowLayout categoryFlowLayout, @NonNull FlowLayout categoryNumberWord, @NonNull FlowLayout categoryOrder, @NonNull FlowLayout categoryStatus, @NonNull LinearLayout categoryTopView) {
        this.f11890a = rootView;
        this.f11891b = categoryDivider;
        this.f11892c = categoryFlowLayout;
        this.f11893d = categoryNumberWord;
        this.f11894e = categoryOrder;
        this.f11895f = categoryStatus;
        this.f11896g = categoryTopView;
    }

    @NonNull
    public static e2 a(@NonNull View rootView) {
        int i2 = R.id.category_divider;
        ThemeView themeView = (ThemeView) rootView.findViewById(R.id.category_divider);
        if (themeView != null) {
            i2 = R.id.category_flowLayout;
            FlowLayout flowLayout = (FlowLayout) rootView.findViewById(R.id.category_flowLayout);
            if (flowLayout != null) {
                i2 = R.id.category_number_word;
                FlowLayout flowLayout2 = (FlowLayout) rootView.findViewById(R.id.category_number_word);
                if (flowLayout2 != null) {
                    i2 = R.id.category_order;
                    FlowLayout flowLayout3 = (FlowLayout) rootView.findViewById(R.id.category_order);
                    if (flowLayout3 != null) {
                        i2 = R.id.category_status;
                        FlowLayout flowLayout4 = (FlowLayout) rootView.findViewById(R.id.category_status);
                        if (flowLayout4 != null) {
                            LinearLayout linearLayout = (LinearLayout) rootView;
                            return new e2(linearLayout, themeView, flowLayout, flowLayout2, flowLayout3, flowLayout4, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.category_list_top, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11890a;
    }
}
