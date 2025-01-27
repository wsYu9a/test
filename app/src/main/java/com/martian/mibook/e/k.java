package com.martian.mibook.e;

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
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12212a;

    /* renamed from: b */
    @NonNull
    public final TextView f12213b;

    /* renamed from: c */
    @NonNull
    public final TextView f12214c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12215d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12216e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f12217f;

    /* renamed from: g */
    @NonNull
    public final RelativeLayout f12218g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12219h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12220i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12221j;

    @NonNull
    public final ThemeTextView k;

    @NonNull
    public final RelativeLayout l;

    private k(@NonNull ThemeRelativeLayout rootView, @NonNull TextView enterHint, @NonNull TextView enterSkip, @NonNull ImageView genderFemaleMore, @NonNull LinearLayout genderGuide, @NonNull RelativeLayout genderGuideFemale, @NonNull RelativeLayout genderGuideMale, @NonNull LinearLayout genderGuideTitleView, @NonNull ImageView genderMaleMore, @NonNull ThemeTextView guideDesc, @NonNull ThemeTextView guideTitle, @NonNull RelativeLayout permissionGuide) {
        this.f12212a = rootView;
        this.f12213b = enterHint;
        this.f12214c = enterSkip;
        this.f12215d = genderFemaleMore;
        this.f12216e = genderGuide;
        this.f12217f = genderGuideFemale;
        this.f12218g = genderGuideMale;
        this.f12219h = genderGuideTitleView;
        this.f12220i = genderMaleMore;
        this.f12221j = guideDesc;
        this.k = guideTitle;
        this.l = permissionGuide;
    }

    @NonNull
    public static k a(@NonNull View rootView) {
        int i2 = R.id.enter_hint;
        TextView textView = (TextView) rootView.findViewById(R.id.enter_hint);
        if (textView != null) {
            i2 = R.id.enter_skip;
            TextView textView2 = (TextView) rootView.findViewById(R.id.enter_skip);
            if (textView2 != null) {
                i2 = R.id.gender_female_more;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.gender_female_more);
                if (imageView != null) {
                    i2 = R.id.gender_guide;
                    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.gender_guide);
                    if (linearLayout != null) {
                        i2 = R.id.gender_guide_female;
                        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.gender_guide_female);
                        if (relativeLayout != null) {
                            i2 = R.id.gender_guide_male;
                            RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.gender_guide_male);
                            if (relativeLayout2 != null) {
                                i2 = R.id.gender_guide_title_view;
                                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.gender_guide_title_view);
                                if (linearLayout2 != null) {
                                    i2 = R.id.gender_male_more;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.gender_male_more);
                                    if (imageView2 != null) {
                                        i2 = R.id.guide_desc;
                                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.guide_desc);
                                        if (themeTextView != null) {
                                            i2 = R.id.guide_title;
                                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.guide_title);
                                            if (themeTextView2 != null) {
                                                i2 = R.id.permission_guide;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) rootView.findViewById(R.id.permission_guide);
                                                if (relativeLayout3 != null) {
                                                    return new k((ThemeRelativeLayout) rootView, textView, textView2, imageView, linearLayout, relativeLayout, relativeLayout2, linearLayout2, imageView2, themeTextView, themeTextView2, relativeLayout3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_gender_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12212a;
    }
}
