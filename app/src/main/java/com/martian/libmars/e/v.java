package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class v implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f10059a;

    /* renamed from: b */
    @NonNull
    public final u f10060b;

    /* renamed from: c */
    @NonNull
    public final ViewStub f10061c;

    private v(@NonNull LinearLayout rootView, @NonNull u libmarsActionBar, @NonNull ViewStub libmarsMainContainer) {
        this.f10059a = rootView;
        this.f10060b = libmarsActionBar;
        this.f10061c = libmarsMainContainer;
    }

    @NonNull
    public static v a(@NonNull View rootView) {
        int i2 = R.id.libmars_action_bar;
        View findViewById = rootView.findViewById(i2);
        if (findViewById != null) {
            u a2 = u.a(findViewById);
            int i3 = R.id.libmars_main_container;
            ViewStub viewStub = (ViewStub) rootView.findViewById(i3);
            if (viewStub != null) {
                return new v((LinearLayout) rootView, a2, viewStub);
            }
            i2 = i3;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static v c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_activity_backable, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10059a;
    }
}
