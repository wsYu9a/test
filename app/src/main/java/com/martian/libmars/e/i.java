package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class i implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9997a;

    /* renamed from: b */
    @NonNull
    public final ImageView f9998b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f9999c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f10000d;

    /* renamed from: e */
    @NonNull
    public final EditText f10001e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f10002f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f10003g;

    private i(@NonNull RelativeLayout rootView, @NonNull ImageView codeBg, @NonNull LinearLayout codeEditView, @NonNull ThemeTextView dialogCodeTitle, @NonNull EditText dialogEdit, @NonNull ThemeLinearLayout dialogView, @NonNull ThemeTextView getCaptcha) {
        this.f9997a = rootView;
        this.f9998b = codeBg;
        this.f9999c = codeEditView;
        this.f10000d = dialogCodeTitle;
        this.f10001e = dialogEdit;
        this.f10002f = dialogView;
        this.f10003g = getCaptcha;
    }

    @NonNull
    public static i a(@NonNull View rootView) {
        int i2 = R.id.code_bg;
        ImageView imageView = (ImageView) rootView.findViewById(i2);
        if (imageView != null) {
            i2 = R.id.code_edit_view;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
            if (linearLayout != null) {
                i2 = R.id.dialog_code_title;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView != null) {
                    i2 = R.id.dialog_edit;
                    EditText editText = (EditText) rootView.findViewById(i2);
                    if (editText != null) {
                        i2 = R.id.dialog_view;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                        if (themeLinearLayout != null) {
                            i2 = R.id.get_captcha;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                            if (themeTextView2 != null) {
                                return new i((RelativeLayout) rootView, imageView, linearLayout, themeTextView, editText, themeLinearLayout, themeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_verification_code, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9997a;
    }
}
