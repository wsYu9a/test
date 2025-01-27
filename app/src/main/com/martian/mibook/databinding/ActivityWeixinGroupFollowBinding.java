package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityWeixinGroupFollowBinding implements ViewBinding {

    @NonNull
    private final ScrollView rootView;

    @NonNull
    public final ImageView rulesFirstCircleDot;

    @NonNull
    public final ThemeTextView rulesFirstTitle;

    @NonNull
    public final ThemeView rulesLine;

    @NonNull
    public final ImageView rulesSecondCircleDot;

    @NonNull
    public final ThemeTextView rulesSecondTitle;

    @NonNull
    public final ThemeLinearLayout rulesView;

    @NonNull
    public final ImageView wfDetailIcon;

    private ActivityWeixinGroupFollowBinding(@NonNull ScrollView scrollView, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeView themeView, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView3) {
        this.rootView = scrollView;
        this.rulesFirstCircleDot = imageView;
        this.rulesFirstTitle = themeTextView;
        this.rulesLine = themeView;
        this.rulesSecondCircleDot = imageView2;
        this.rulesSecondTitle = themeTextView2;
        this.rulesView = themeLinearLayout;
        this.wfDetailIcon = imageView3;
    }

    @NonNull
    public static ActivityWeixinGroupFollowBinding bind(@NonNull View view) {
        int i10 = R.id.rules_first_circle_dot;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.rules_first_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.rules_line;
                ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
                if (themeView != null) {
                    i10 = R.id.rules_second_circle_dot;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.rules_second_title;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.rules_view;
                            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout != null) {
                                i10 = R.id.wf_detail_icon;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView3 != null) {
                                    return new ActivityWeixinGroupFollowBinding((ScrollView) view, imageView, themeTextView, themeView, imageView2, themeTextView2, themeLinearLayout, imageView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityWeixinGroupFollowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityWeixinGroupFollowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_weixin_group_follow, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.rootView;
    }
}
