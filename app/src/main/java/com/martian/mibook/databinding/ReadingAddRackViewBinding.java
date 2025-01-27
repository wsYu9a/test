package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ReadingAddRackViewBinding implements ViewBinding {

    @NonNull
    public final RoundedLayout readingAddRack;

    @NonNull
    private final RelativeLayout rootView;

    private ReadingAddRackViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull RoundedLayout roundedLayout) {
        this.rootView = relativeLayout;
        this.readingAddRack = roundedLayout;
    }

    @NonNull
    public static ReadingAddRackViewBinding bind(@NonNull View view) {
        int i10 = R.id.reading_add_rack;
        RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
        if (roundedLayout != null) {
            return new ReadingAddRackViewBinding((RelativeLayout) view, roundedLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingAddRackViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAddRackViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_add_rack_view, viewGroup, false);
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
