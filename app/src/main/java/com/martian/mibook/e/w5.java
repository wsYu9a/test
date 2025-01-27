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
public final class w5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12896a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12897b;

    /* renamed from: c */
    @NonNull
    public final TextView f12898c;

    /* renamed from: d */
    @NonNull
    public final TextView f12899d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12900e;

    private w5(@NonNull LinearLayout rootView, @NonNull ImageView tvChapterPosition, @NonNull TextView tvChapterStatus, @NonNull TextView tvChapterTitle, @NonNull LinearLayout tvChapterView) {
        this.f12896a = rootView;
        this.f12897b = tvChapterPosition;
        this.f12898c = tvChapterStatus;
        this.f12899d = tvChapterTitle;
        this.f12900e = tvChapterView;
    }

    @NonNull
    public static w5 a(@NonNull View rootView) {
        int i2 = R.id.tv_chapter_position;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.tv_chapter_position);
        if (imageView != null) {
            i2 = R.id.tv_chapter_status;
            TextView textView = (TextView) rootView.findViewById(R.id.tv_chapter_status);
            if (textView != null) {
                i2 = R.id.tv_chapter_title;
                TextView textView2 = (TextView) rootView.findViewById(R.id.tv_chapter_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    return new w5(linearLayout, imageView, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_dir_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12896a;
    }
}
