package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityGenderGuideBinding implements ViewBinding {

    @NonNull
    public final TextView enterHint;

    @NonNull
    public final TextView enterSkip;

    @NonNull
    public final ImageView genderFemaleMore;

    @NonNull
    public final LinearLayout genderGuide;

    @NonNull
    public final RelativeLayout genderGuideFemale;

    @NonNull
    public final RelativeLayout genderGuideMale;

    @NonNull
    public final LinearLayout genderGuideTitleView;

    @NonNull
    public final ImageView genderMaleMore;

    @NonNull
    public final ThemeTextView guideDesc;

    @NonNull
    public final ThemeTextView guideTitle;

    @NonNull
    public final RelativeLayout permissionGuide;

    @NonNull
    private final ThemeRelativeLayout rootView;

    private ActivityGenderGuideBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull RelativeLayout relativeLayout3) {
        this.rootView = themeRelativeLayout;
        this.enterHint = textView;
        this.enterSkip = textView2;
        this.genderFemaleMore = imageView;
        this.genderGuide = linearLayout;
        this.genderGuideFemale = relativeLayout;
        this.genderGuideMale = relativeLayout2;
        this.genderGuideTitleView = linearLayout2;
        this.genderMaleMore = imageView2;
        this.guideDesc = themeTextView;
        this.guideTitle = themeTextView2;
        this.permissionGuide = relativeLayout3;
    }

    @NonNull
    public static ActivityGenderGuideBinding bind(@NonNull View view) {
        int i10 = R.id.enter_hint;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.enter_skip;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView2 != null) {
                i10 = R.id.gender_female_more;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.gender_guide;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.gender_guide_female;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                        if (relativeLayout != null) {
                            i10 = R.id.gender_guide_male;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                            if (relativeLayout2 != null) {
                                i10 = R.id.gender_guide_title_view;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R.id.gender_male_more;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R.id.guide_desc;
                                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView != null) {
                                            i10 = R.id.guide_title;
                                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView2 != null) {
                                                i10 = R.id.permission_guide;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                if (relativeLayout3 != null) {
                                                    return new ActivityGenderGuideBinding((ThemeRelativeLayout) view, textView, textView2, imageView, linearLayout, relativeLayout, relativeLayout2, linearLayout2, imageView2, themeTextView, themeTextView2, relativeLayout3);
                                                }
                                            }
                                        }
                                    }
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
    public static ActivityGenderGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityGenderGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_gender_guide, viewGroup, false);
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
