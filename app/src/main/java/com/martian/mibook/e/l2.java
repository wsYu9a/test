package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12287a;

    /* renamed from: b */
    @NonNull
    public final EditText f12288b;

    private l2(@NonNull LinearLayout rootView, @NonNull EditText etDialogContent) {
        this.f12287a = rootView;
        this.f12288b = etDialogContent;
    }

    @NonNull
    public static l2 a(@NonNull View rootView) {
        EditText editText = (EditText) rootView.findViewById(R.id.et_dialog_content);
        if (editText != null) {
            return new l2((LinearLayout) rootView, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.et_dialog_content)));
    }

    @NonNull
    public static l2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_edittext, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12287a;
    }
}
