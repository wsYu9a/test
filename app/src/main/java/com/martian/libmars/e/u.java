package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;

/* loaded from: classes2.dex */
public final class u implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f10049a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f10050b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f10051c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f10052d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f10053e;

    /* renamed from: f */
    @NonNull
    public final ViewStub f10054f;

    /* renamed from: g */
    @NonNull
    public final ThemeImageView f10055g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f10056h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f10057i;

    /* renamed from: j */
    @NonNull
    public final ThemeView f10058j;

    @NonNull
    public final RelativeLayout k;

    @NonNull
    public final Toolbar l;

    private u(@NonNull LinearLayout rootView, @NonNull ThemeTextView actionbarAction, @NonNull ThemeTextView actionbarActionCustom, @NonNull ThemeImageView actionbarActionIcon, @NonNull ThemeImageView actionbarBack, @NonNull ViewStub actionbarContainer, @NonNull ThemeImageView actionbarDivider, @NonNull ThemeLinearLayout actionbarRootView, @NonNull ThemeTextView actionbarTitle, @NonNull ThemeView actionbarTopView, @NonNull RelativeLayout actionbarView, @NonNull Toolbar toolbar) {
        this.f10049a = rootView;
        this.f10050b = actionbarAction;
        this.f10051c = actionbarActionCustom;
        this.f10052d = actionbarActionIcon;
        this.f10053e = actionbarBack;
        this.f10054f = actionbarContainer;
        this.f10055g = actionbarDivider;
        this.f10056h = actionbarRootView;
        this.f10057i = actionbarTitle;
        this.f10058j = actionbarTopView;
        this.k = actionbarView;
        this.l = toolbar;
    }

    @NonNull
    public static u a(@NonNull View rootView) {
        int i2 = R.id.actionbar_action;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.actionbar_action_custom;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView2 != null) {
                i2 = R.id.actionbar_action_icon;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
                if (themeImageView != null) {
                    i2 = R.id.actionbar_back;
                    ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(i2);
                    if (themeImageView2 != null) {
                        i2 = R.id.actionbar_container;
                        ViewStub viewStub = (ViewStub) rootView.findViewById(i2);
                        if (viewStub != null) {
                            i2 = R.id.actionbar_divider;
                            ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(i2);
                            if (themeImageView3 != null) {
                                i2 = R.id.actionbar_root_view;
                                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                                if (themeLinearLayout != null) {
                                    i2 = R.id.actionbar_title;
                                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                                    if (themeTextView3 != null) {
                                        i2 = R.id.actionbar_top_view;
                                        ThemeView themeView = (ThemeView) rootView.findViewById(i2);
                                        if (themeView != null) {
                                            i2 = R.id.actionbar_view;
                                            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(i2);
                                            if (relativeLayout != null) {
                                                i2 = R.id.toolbar;
                                                Toolbar toolbar = (Toolbar) rootView.findViewById(i2);
                                                if (toolbar != null) {
                                                    return new u((LinearLayout) rootView, themeTextView, themeTextView2, themeImageView, themeImageView2, viewStub, themeImageView3, themeLinearLayout, themeTextView3, themeView, relativeLayout, toolbar);
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
    public static u c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_action_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10049a;
    }
}
