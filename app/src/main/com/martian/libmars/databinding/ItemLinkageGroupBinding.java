package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class ItemLinkageGroupBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12200a;

    /* renamed from: b */
    @NonNull
    public final TextView f12201b;

    public ItemLinkageGroupBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f12200a = linearLayout;
        this.f12201b = textView;
    }

    @NonNull
    public static ItemLinkageGroupBinding a(@NonNull View view) {
        int i10 = R.id.tv_group;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            return new ItemLinkageGroupBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemLinkageGroupBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemLinkageGroupBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_linkage_group, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12200a;
    }
}
