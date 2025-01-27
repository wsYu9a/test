package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class DialogListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12165a;

    /* renamed from: b */
    @NonNull
    public final CheckBox f12166b;

    /* renamed from: c */
    @NonNull
    public final RadioButton f12167c;

    public DialogListItemBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull RadioButton radioButton) {
        this.f12165a = linearLayout;
        this.f12166b = checkBox;
        this.f12167c = radioButton;
    }

    @NonNull
    public static DialogListItemBinding a(@NonNull View view) {
        int i10 = R.id.dialog_check;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i10);
        if (checkBox != null) {
            i10 = R.id.dialog_item_radio;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i10);
            if (radioButton != null) {
                return new DialogListItemBinding((LinearLayout) view, checkBox, radioButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogListItemBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogListItemBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_list_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12165a;
    }
}
