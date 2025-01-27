package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ScrollView f11816a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11817b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11818c;

    /* renamed from: d */
    @NonNull
    public final ThemeView f11819d;

    /* renamed from: e */
    @NonNull
    public final ImageView f11820e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f11821f;

    /* renamed from: g */
    @NonNull
    public final ThemeLinearLayout f11822g;

    /* renamed from: h */
    @NonNull
    public final ImageView f11823h;

    private d0(@NonNull ScrollView rootView, @NonNull ImageView rulesFirstCircleDot, @NonNull ThemeTextView rulesFirstTitle, @NonNull ThemeView rulesLine, @NonNull ImageView rulesSecondCircleDot, @NonNull ThemeTextView rulesSecondTitle, @NonNull ThemeLinearLayout rulesView, @NonNull ImageView wfDetailIcon) {
        this.f11816a = rootView;
        this.f11817b = rulesFirstCircleDot;
        this.f11818c = rulesFirstTitle;
        this.f11819d = rulesLine;
        this.f11820e = rulesSecondCircleDot;
        this.f11821f = rulesSecondTitle;
        this.f11822g = rulesView;
        this.f11823h = wfDetailIcon;
    }

    @NonNull
    public static d0 a(@NonNull View rootView) {
        int i2 = R.id.rules_first_circle_dot;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.rules_first_circle_dot);
        if (imageView != null) {
            i2 = R.id.rules_first_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.rules_first_title);
            if (themeTextView != null) {
                i2 = R.id.rules_line;
                ThemeView themeView = (ThemeView) rootView.findViewById(R.id.rules_line);
                if (themeView != null) {
                    i2 = R.id.rules_second_circle_dot;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.rules_second_circle_dot);
                    if (imageView2 != null) {
                        i2 = R.id.rules_second_title;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.rules_second_title);
                        if (themeTextView2 != null) {
                            i2 = R.id.rules_view;
                            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.rules_view);
                            if (themeLinearLayout != null) {
                                i2 = R.id.wf_detail_icon;
                                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.wf_detail_icon);
                                if (imageView3 != null) {
                                    return new d0((ScrollView) rootView, imageView, themeTextView, themeView, imageView2, themeTextView2, themeLinearLayout, imageView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_weixin_group_follow, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f11816a;
    }
}
