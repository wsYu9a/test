package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.R;
import com.kwad.sdk.j.k;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> AJ;
    private String qg;

    public RewardTaskStepView(Context context) {
        super(context);
        this.AJ = new ArrayList();
        kb();
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AJ = new ArrayList();
        kb();
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.AJ = new ArrayList();
        kb();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.AJ = new ArrayList();
        kb();
    }

    private void a(int i2, String str, String str2, boolean z) {
        ViewGroup viewGroup = (ViewGroup) k.a(getContext(), z ? R.layout.ksad_reward_task_step_item_checked : R.layout.ksad_reward_task_step_item_unchecked, this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i2, str2);
        }
        addView(viewGroup);
    }

    private void a(ViewGroup viewGroup, int i2, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.qg));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i2));
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void ai(boolean z) {
        DividerView dividerView = (DividerView) k.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z ? R.color.ksad_reward_main_color : R.color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void kb() {
        setOrientation(1);
    }

    private void kc() {
        int size = this.AJ.size();
        int i2 = 0;
        while (i2 < size) {
            c cVar = this.AJ.get(i2);
            int i3 = i2 + 1;
            a(i3, cVar.jo(), cVar.jp(), cVar.isCompleted());
            if (i2 < size - 1) {
                ai(this.AJ.get(i3).isCompleted());
            }
            i2 = i3;
        }
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.qg = str;
        this.AJ.clear();
        this.AJ.addAll(list);
        kc();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
