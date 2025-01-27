package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class f3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final NestedScrollView f11940a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11941b;

    /* renamed from: c */
    @NonNull
    public final com.martian.libmars.e.h0 f11942c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f11943d;

    /* renamed from: e */
    @NonNull
    public final CircleImageView f11944e;

    /* renamed from: f */
    @NonNull
    public final CircleImageView f11945f;

    /* renamed from: g */
    @NonNull
    public final CircleImageView f11946g;

    private f3(@NonNull NestedScrollView rootView, @NonNull LinearLayout commissionMissions, @NonNull com.martian.libmars.e.h0 commissionView, @NonNull LinearLayout martianTipsView, @NonNull CircleImageView rcHeaderOne, @NonNull CircleImageView rcHeaderThree, @NonNull CircleImageView rcHeaderTwo) {
        this.f11940a = rootView;
        this.f11941b = commissionMissions;
        this.f11942c = commissionView;
        this.f11943d = martianTipsView;
        this.f11944e = rcHeaderOne;
        this.f11945f = rcHeaderThree;
        this.f11946g = rcHeaderTwo;
    }

    @NonNull
    public static f3 a(@NonNull View rootView) {
        int i2 = R.id.commission_missions;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.commission_missions);
        if (linearLayout != null) {
            i2 = R.id.commission_view;
            View findViewById = rootView.findViewById(R.id.commission_view);
            if (findViewById != null) {
                com.martian.libmars.e.h0 a2 = com.martian.libmars.e.h0.a(findViewById);
                i2 = R.id.martian_tips_view;
                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.martian_tips_view);
                if (linearLayout2 != null) {
                    i2 = R.id.rc_header_one;
                    CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.rc_header_one);
                    if (circleImageView != null) {
                        i2 = R.id.rc_header_three;
                        CircleImageView circleImageView2 = (CircleImageView) rootView.findViewById(R.id.rc_header_three);
                        if (circleImageView2 != null) {
                            i2 = R.id.rc_header_two;
                            CircleImageView circleImageView3 = (CircleImageView) rootView.findViewById(R.id.rc_header_two);
                            if (circleImageView3 != null) {
                                return new f3((NestedScrollView) rootView, linearLayout, a2, linearLayout2, circleImageView, circleImageView2, circleImageView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_commission_income, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public NestedScrollView getRoot() {
        return this.f11940a;
    }
}
