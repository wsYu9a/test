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
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12312a;

    /* renamed from: b */
    @Nullable
    public final ReaderThemeTextView f12313b;

    /* renamed from: c */
    @NonNull
    public final ListView f12314c;

    /* renamed from: d */
    @NonNull
    public final RoundedLayout f12315d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeImageView f12316e;

    private l6(@NonNull RelativeLayout rootView, @Nullable ReaderThemeTextView closeAdsTitle, @NonNull ListView slideModeListview, @NonNull RoundedLayout vipShare, @NonNull ReaderThemeImageView windowClose) {
        this.f12312a = rootView;
        this.f12313b = closeAdsTitle;
        this.f12314c = slideModeListview;
        this.f12315d = vipShare;
        this.f12316e = windowClose;
    }

    @NonNull
    public static l6 a(@NonNull View rootView) {
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.close_ads_title);
        int i2 = R.id.slide_mode_listview;
        ListView listView = (ListView) rootView.findViewById(R.id.slide_mode_listview);
        if (listView != null) {
            i2 = R.id.vip_share;
            RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.vip_share);
            if (roundedLayout != null) {
                i2 = R.id.window_close;
                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.window_close);
                if (readerThemeImageView != null) {
                    return new l6((RelativeLayout) rootView, readerThemeTextView, listView, roundedLayout, readerThemeImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_slide_mode, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12312a;
    }
}
