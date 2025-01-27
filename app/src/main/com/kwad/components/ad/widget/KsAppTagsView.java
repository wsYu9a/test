package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.n.m;
import java.util.List;

/* loaded from: classes2.dex */
public class KsAppTagsView extends LinearLayout {
    private int Kd;

    public KsAppTagsView(Context context) {
        super(context);
        this.Kd = 3;
    }

    public final void a(List<String> list, @LayoutRes int i10) {
        if (list == null) {
            return;
        }
        int i11 = 0;
        for (String str : list) {
            i11++;
            if (i11 > this.Kd) {
                return;
            } else {
                a(this, str, i10);
            }
        }
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public void setMaxCount(int i10) {
        this.Kd = i10;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kd = 3;
    }

    private static void a(LinearLayout linearLayout, String str, @LayoutRes int i10) {
        TextView textView = (TextView) m.a(linearLayout.getContext(), i10, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Kd = 3;
    }

    @RequiresApi(api = 21)
    public KsAppTagsView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.Kd = 3;
    }
}
