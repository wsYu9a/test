package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12441a;

    /* renamed from: b */
    @NonNull
    public final ListView f12442b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeImageView f12443c;

    /* renamed from: d */
    @Nullable
    public final RoundedLayout f12444d;

    private n6(@NonNull RelativeLayout rootView, @NonNull ListView timingListview, @NonNull ReaderThemeImageView timingWindowClose, @Nullable RoundedLayout vipShare) {
        this.f12441a = rootView;
        this.f12442b = timingListview;
        this.f12443c = timingWindowClose;
        this.f12444d = vipShare;
    }

    @NonNull
    public static n6 a(@NonNull View rootView) {
        int i2 = R.id.timing_listview;
        ListView listView = (ListView) rootView.findViewById(R.id.timing_listview);
        if (listView != null) {
            i2 = R.id.timing_window_close;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.timing_window_close);
            if (readerThemeImageView != null) {
                return new n6((RelativeLayout) rootView, listView, readerThemeImageView, (RoundedLayout) rootView.findViewById(R.id.vip_share));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static n6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_timing, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12441a;
    }
}
