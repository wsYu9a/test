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
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11651a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f11652b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f11653c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f11654d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f11655e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f11656f;

    /* renamed from: g */
    @NonNull
    public final ThemeLinearLayout f11657g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f11658h;

    /* renamed from: i */
    @NonNull
    public final ImageView f11659i;

    /* renamed from: j */
    @NonNull
    public final IntervalCountdownTextView f11660j;

    @NonNull
    public final TextView k;

    @NonNull
    public final RelativeLayout l;

    private a(@NonNull ThemeLinearLayout rootView, @NonNull ThemeImageView bookshelfMainSearchIcon, @NonNull ThemeImageView bookshelfReadingHistory, @NonNull LinearLayout brClass, @NonNull ThemeImageView brHeaderBarMore, @NonNull ThemeLinearLayout brHeaderSetting, @NonNull ThemeLinearLayout brHeaderSettingView, @NonNull ThemeTextView brMyClass, @NonNull ImageView brMyClassDot, @NonNull IntervalCountdownTextView intervalCountdown, @NonNull TextView intervalGrab, @NonNull RelativeLayout intervalView) {
        this.f11651a = rootView;
        this.f11652b = bookshelfMainSearchIcon;
        this.f11653c = bookshelfReadingHistory;
        this.f11654d = brClass;
        this.f11655e = brHeaderBarMore;
        this.f11656f = brHeaderSetting;
        this.f11657g = brHeaderSettingView;
        this.f11658h = brMyClass;
        this.f11659i = brMyClassDot;
        this.f11660j = intervalCountdown;
        this.k = intervalGrab;
        this.l = intervalView;
    }

    @NonNull
    public static a a(@NonNull View rootView) {
        int i2 = R.id.bookshelf_main_search_icon;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bookshelf_main_search_icon);
        if (themeImageView != null) {
            i2 = R.id.bookshelf_reading_history;
            ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.bookshelf_reading_history);
            if (themeImageView2 != null) {
                i2 = R.id.br_class;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.br_class);
                if (linearLayout != null) {
                    i2 = R.id.br_header_bar_more;
                    ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(R.id.br_header_bar_more);
                    if (themeImageView3 != null) {
                        i2 = R.id.br_header_setting;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.br_header_setting);
                        if (themeLinearLayout != null) {
                            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView;
                            i2 = R.id.br_my_class;
                            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.br_my_class);
                            if (themeTextView != null) {
                                i2 = R.id.br_my_class_dot;
                                ImageView imageView = (ImageView) rootView.findViewById(R.id.br_my_class_dot);
                                if (imageView != null) {
                                    i2 = R.id.interval_countdown;
                                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) rootView.findViewById(R.id.interval_countdown);
                                    if (intervalCountdownTextView != null) {
                                        i2 = R.id.interval_grab;
                                        TextView textView = (TextView) rootView.findViewById(R.id.interval_grab);
                                        if (textView != null) {
                                            i2 = R.id.interval_view;
                                            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.interval_view);
                                            if (relativeLayout != null) {
                                                return new a(themeLinearLayout2, themeImageView, themeImageView2, linearLayout, themeImageView3, themeLinearLayout, themeLinearLayout2, themeTextView, imageView, intervalCountdownTextView, textView, relativeLayout);
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
    public static a c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.actionbar_bookrack, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11651a;
    }
}
