package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class f implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f9960a;

    /* renamed from: b */
    @NonNull
    public final CheckBox f9961b;

    /* renamed from: c */
    @NonNull
    public final RadioButton f9962c;

    private f(@NonNull LinearLayout rootView, @NonNull CheckBox dialogCheck, @NonNull RadioButton dialogItemRadio) {
        this.f9960a = rootView;
        this.f9961b = dialogCheck;
        this.f9962c = dialogItemRadio;
    }

    @NonNull
    public static f a(@NonNull View rootView) {
        int i2 = R.id.dialog_check;
        CheckBox checkBox = (CheckBox) rootView.findViewById(i2);
        if (checkBox != null) {
            i2 = R.id.dialog_item_radio;
            RadioButton radioButton = (RadioButton) rootView.findViewById(i2);
            if (radioButton != null) {
                return new f((LinearLayout) rootView, checkBox, radioButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9960a;
    }
}
