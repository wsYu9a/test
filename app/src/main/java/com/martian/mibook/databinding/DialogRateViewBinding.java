package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogRateViewBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView dialogClose;

    @NonNull
    public final ThemeTextView dialogNotarize;

    @NonNull
    public final View dialogShadeView;

    @NonNull
    public final TextView dialogTitle;

    @NonNull
    public final LinearLayout dialogView;

    @NonNull
    public final View dialogViewBottom;

    @NonNull
    public final View dialogViewTop;

    @NonNull
    public final TextView rateDesc;

    @NonNull
    private final RelativeLayout rootView;

    private DialogRateViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull View view, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull View view2, @NonNull View view3, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.dialogClose = themeImageView;
        this.dialogNotarize = themeTextView;
        this.dialogShadeView = view;
        this.dialogTitle = textView;
        this.dialogView = linearLayout;
        this.dialogViewBottom = view2;
        this.dialogViewTop = view3;
        this.rateDesc = textView2;
    }

    @NonNull
    public static DialogRateViewBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.dialog_notarize;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_shade_view))) != null) {
                i10 = R.id.dialog_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.dialog_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_bottom))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_top))) != null) {
                        i10 = R.id.rate_desc;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            return new DialogRateViewBinding((RelativeLayout) view, themeImageView, themeTextView, findChildViewById, textView, linearLayout, findChildViewById2, findChildViewById3, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogRateViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogRateViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_rate_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
