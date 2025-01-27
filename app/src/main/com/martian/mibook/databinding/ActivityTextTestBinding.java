package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityTextTestBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout accountGromoreWeight;

    @NonNull
    private final ScrollView rootView;

    @NonNull
    public final ThemeTextView textId1;

    @NonNull
    public final ThemeTextView textId10;

    @NonNull
    public final ThemeTextView textId11;

    @NonNull
    public final ThemeTextView textId2;

    @NonNull
    public final ThemeTextView textId3;

    @NonNull
    public final ThemeTextView textId4;

    @NonNull
    public final ThemeTextView textId5;

    @NonNull
    public final ThemeTextView textId6;

    @NonNull
    public final ThemeTextView textId7;

    @NonNull
    public final ThemeTextView textId8;

    @NonNull
    public final ThemeTextView textId9;

    @NonNull
    public final ThemeTextView textSize;

    private ActivityTextTestBinding(@NonNull ScrollView scrollView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull ThemeTextView themeTextView7, @NonNull ThemeTextView themeTextView8, @NonNull ThemeTextView themeTextView9, @NonNull ThemeTextView themeTextView10, @NonNull ThemeTextView themeTextView11, @NonNull ThemeTextView themeTextView12) {
        this.rootView = scrollView;
        this.accountGromoreWeight = themeLinearLayout;
        this.textId1 = themeTextView;
        this.textId10 = themeTextView2;
        this.textId11 = themeTextView3;
        this.textId2 = themeTextView4;
        this.textId3 = themeTextView5;
        this.textId4 = themeTextView6;
        this.textId5 = themeTextView7;
        this.textId6 = themeTextView8;
        this.textId7 = themeTextView9;
        this.textId8 = themeTextView10;
        this.textId9 = themeTextView11;
        this.textSize = themeTextView12;
    }

    @NonNull
    public static ActivityTextTestBinding bind(@NonNull View view) {
        int i10 = R.id.account_gromore_weight;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.text_id_1;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.text_id_10;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.text_id_11;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null) {
                        i10 = R.id.text_id_2;
                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView4 != null) {
                            i10 = R.id.text_id_3;
                            ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView5 != null) {
                                i10 = R.id.text_id_4;
                                ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView6 != null) {
                                    i10 = R.id.text_id_5;
                                    ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView7 != null) {
                                        i10 = R.id.text_id_6;
                                        ThemeTextView themeTextView8 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView8 != null) {
                                            i10 = R.id.text_id_7;
                                            ThemeTextView themeTextView9 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView9 != null) {
                                                i10 = R.id.text_id_8;
                                                ThemeTextView themeTextView10 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView10 != null) {
                                                    i10 = R.id.text_id_9;
                                                    ThemeTextView themeTextView11 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView11 != null) {
                                                        i10 = R.id.text_size;
                                                        ThemeTextView themeTextView12 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeTextView12 != null) {
                                                            return new ActivityTextTestBinding((ScrollView) view, themeLinearLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, themeTextView6, themeTextView7, themeTextView8, themeTextView9, themeTextView10, themeTextView11, themeTextView12);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityTextTestBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTextTestBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_text_test, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.rootView;
    }
}
