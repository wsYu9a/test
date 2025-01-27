package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12628a;

    /* renamed from: b */
    @NonNull
    public final TextView f12629b;

    /* renamed from: c */
    @NonNull
    public final TextView f12630c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12631d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12632e;

    /* renamed from: f */
    @NonNull
    public final TextView f12633f;

    private r6(@NonNull LinearLayout rootView, @NonNull TextView remoteviewChapter, @NonNull TextView remoteviewContent, @NonNull ImageView remoteviewCover, @NonNull LinearLayout remoteviewMainView, @NonNull TextView remoteviewTitle) {
        this.f12628a = rootView;
        this.f12629b = remoteviewChapter;
        this.f12630c = remoteviewContent;
        this.f12631d = remoteviewCover;
        this.f12632e = remoteviewMainView;
        this.f12633f = remoteviewTitle;
    }

    @NonNull
    public static r6 a(@NonNull View rootView) {
        int i2 = R.id.remoteview_chapter;
        TextView textView = (TextView) rootView.findViewById(R.id.remoteview_chapter);
        if (textView != null) {
            i2 = R.id.remoteview_content;
            TextView textView2 = (TextView) rootView.findViewById(R.id.remoteview_content);
            if (textView2 != null) {
                i2 = R.id.remoteview_cover;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.remoteview_cover);
                if (imageView != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i2 = R.id.remoteview_title;
                    TextView textView3 = (TextView) rootView.findViewById(R.id.remoteview_title);
                    if (textView3 != null) {
                        return new r6(linearLayout, textView, textView2, imageView, linearLayout, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static r6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.remoteview_book_item_small, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12628a;
    }
}
