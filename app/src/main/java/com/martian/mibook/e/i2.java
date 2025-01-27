package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12109a;

    /* renamed from: b */
    @NonNull
    public final EditText f12110b;

    /* renamed from: c */
    @NonNull
    public final TextView f12111c;

    private i2(@NonNull LinearLayout rootView, @NonNull EditText etBackupName, @NonNull TextView tvBackupSuffix) {
        this.f12109a = rootView;
        this.f12110b = etBackupName;
        this.f12111c = tvBackupSuffix;
    }

    @NonNull
    public static i2 a(@NonNull View rootView) {
        int i2 = R.id.et_backup_name;
        EditText editText = (EditText) rootView.findViewById(R.id.et_backup_name);
        if (editText != null) {
            i2 = R.id.tv_backup_suffix;
            TextView textView = (TextView) rootView.findViewById(R.id.tv_backup_suffix);
            if (textView != null) {
                return new i2((LinearLayout) rootView, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_backup_name, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12109a;
    }
}
