package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class o1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12457a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12458b;

    /* renamed from: c */
    @NonNull
    public final ThemeView f12459c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12460d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12461e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12462f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12463g;

    /* renamed from: h */
    @NonNull
    public final TextView f12464h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12465i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12466j;

    private o1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout brHeaderMission, @NonNull ThemeView brMissionDivider, @NonNull LinearLayout brMissionLeft, @NonNull ImageView brMissionPlaceHolder, @NonNull ThemeLinearLayout brMissionPlaceHolderView, @NonNull LinearLayout brMissionRight, @NonNull TextView brMissionRightButton, @NonNull ThemeTextView brMissionRightDesc, @NonNull ThemeTextView brMissionRightTitle) {
        this.f12457a = rootView;
        this.f12458b = brHeaderMission;
        this.f12459c = brMissionDivider;
        this.f12460d = brMissionLeft;
        this.f12461e = brMissionPlaceHolder;
        this.f12462f = brMissionPlaceHolderView;
        this.f12463g = brMissionRight;
        this.f12464h = brMissionRightButton;
        this.f12465i = brMissionRightDesc;
        this.f12466j = brMissionRightTitle;
    }

    @NonNull
    public static o1 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        int i2 = R.id.br_mission_divider;
        ThemeView themeView = (ThemeView) rootView.findViewById(R.id.br_mission_divider);
        if (themeView != null) {
            i2 = R.id.br_mission_left;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.br_mission_left);
            if (linearLayout != null) {
                i2 = R.id.br_mission_place_holder;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.br_mission_place_holder);
                if (imageView != null) {
                    i2 = R.id.br_mission_place_holder_view;
                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.br_mission_place_holder_view);
                    if (themeLinearLayout2 != null) {
                        i2 = R.id.br_mission_right;
                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.br_mission_right);
                        if (linearLayout2 != null) {
                            i2 = R.id.br_mission_right_button;
                            TextView textView = (TextView) rootView.findViewById(R.id.br_mission_right_button);
                            if (textView != null) {
                                i2 = R.id.br_mission_right_desc;
                                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.br_mission_right_desc);
                                if (themeTextView != null) {
                                    i2 = R.id.br_mission_right_title;
                                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.br_mission_right_title);
                                    if (themeTextView2 != null) {
                                        return new o1((ThemeLinearLayout) rootView, themeLinearLayout, themeView, linearLayout, imageView, themeLinearLayout2, linearLayout2, textView, themeTextView, themeTextView2);
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
    public static o1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_mission, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12457a;
    }
}
