package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class DialogSingleChoiceBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12177a;

    /* renamed from: b */
    @NonNull
    public final RadioGroup f12178b;

    /* renamed from: c */
    @NonNull
    public final View f12179c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12180d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12181e;

    /* renamed from: f */
    @NonNull
    public final View f12182f;

    /* renamed from: g */
    @NonNull
    public final View f12183g;

    public DialogSingleChoiceBinding(@NonNull RelativeLayout relativeLayout, @NonNull RadioGroup radioGroup, @NonNull View view, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view2, @NonNull View view3) {
        this.f12177a = relativeLayout;
        this.f12178b = radioGroup;
        this.f12179c = view;
        this.f12180d = themeTextView;
        this.f12181e = themeLinearLayout;
        this.f12182f = view2;
        this.f12183g = view3;
    }

    @NonNull
    public static DialogSingleChoiceBinding a(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_radio_group;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i10);
        if (radioGroup != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_shade_view))) != null) {
            i10 = R.id.dialog_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.dialog_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_bottom))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_top))) != null) {
                    return new DialogSingleChoiceBinding((RelativeLayout) view, radioGroup, findChildViewById, themeTextView, themeLinearLayout, findChildViewById2, findChildViewById3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogSingleChoiceBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSingleChoiceBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_single_choice, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12177a;
    }
}
