package com.martian.libmars.databinding;

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
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;

/* loaded from: classes3.dex */
public final class LibmarsActionBarBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12259a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12260b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12261c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12262d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f12263e;

    /* renamed from: f */
    @NonNull
    public final ViewStub f12264f;

    /* renamed from: g */
    @NonNull
    public final ThemeImageView f12265g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f12266h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12267i;

    /* renamed from: j */
    @NonNull
    public final ThemeView f12268j;

    /* renamed from: k */
    @NonNull
    public final RelativeLayout f12269k;

    /* renamed from: l */
    @NonNull
    public final Toolbar f12270l;

    public LibmarsActionBarBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ViewStub viewStub, @NonNull ThemeImageView themeImageView3, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView3, @NonNull ThemeView themeView, @NonNull RelativeLayout relativeLayout, @NonNull Toolbar toolbar) {
        this.f12259a = linearLayout;
        this.f12260b = themeTextView;
        this.f12261c = themeTextView2;
        this.f12262d = themeImageView;
        this.f12263e = themeImageView2;
        this.f12264f = viewStub;
        this.f12265g = themeImageView3;
        this.f12266h = themeLinearLayout;
        this.f12267i = themeTextView3;
        this.f12268j = themeView;
        this.f12269k = relativeLayout;
        this.f12270l = toolbar;
    }

    @NonNull
    public static LibmarsActionBarBinding a(@NonNull View view) {
        int i10 = R.id.actionbar_action;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.actionbar_action_custom;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.actionbar_action_icon;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.actionbar_back;
                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView2 != null) {
                        i10 = R.id.actionbar_container;
                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                        if (viewStub != null) {
                            i10 = R.id.actionbar_divider;
                            ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView3 != null) {
                                i10 = R.id.actionbar_root_view;
                                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout != null) {
                                    i10 = R.id.actionbar_title;
                                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView3 != null) {
                                        i10 = R.id.actionbar_top_view;
                                        ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
                                        if (themeView != null) {
                                            i10 = R.id.actionbar_view;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                            if (relativeLayout != null) {
                                                i10 = R.id.toolbar;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i10);
                                                if (toolbar != null) {
                                                    return new LibmarsActionBarBinding((LinearLayout) view, themeTextView, themeTextView2, themeImageView, themeImageView2, viewStub, themeImageView3, themeLinearLayout, themeTextView3, themeView, relativeLayout, toolbar);
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
    public static LibmarsActionBarBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsActionBarBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_action_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12259a;
    }
}
