package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.R;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> CS;

    /* renamed from: rx */
    private String f11890rx;

    public RewardTaskStepView(Context context) {
        super(context);
        this.CS = new ArrayList();
        kA();
    }

    private void ae(boolean z10) {
        DividerView dividerView = (DividerView) m.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z10 ? R.color.ksad_reward_main_color : R.color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void kA() {
        setOrientation(1);
    }

    private void kB() {
        int size = this.CS.size();
        int i10 = 0;
        while (i10 < size) {
            c cVar = this.CS.get(i10);
            int i11 = i10 + 1;
            a(i11, cVar.jP(), cVar.jQ(), cVar.isCompleted());
            if (i10 < size - 1) {
                ae(this.CS.get(i11).isCompleted());
            }
            i10 = i11;
        }
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f11890rx = str;
        this.CS.clear();
        this.CS.addAll(list);
        kB();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CS = new ArrayList();
        kA();
    }

    private void a(int i10, String str, String str2, boolean z10) {
        int i11;
        if (z10) {
            i11 = R.layout.ksad_reward_task_step_item_checked;
        } else {
            i11 = R.layout.ksad_reward_task_step_item_unchecked;
        }
        ViewGroup viewGroup = (ViewGroup) m.a(getContext(), i11, this, false);
        if (z10) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i10, str2);
        }
        addView(viewGroup);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.CS = new ArrayList();
        kA();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.CS = new ArrayList();
        kA();
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void a(ViewGroup viewGroup, int i10, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.f11890rx));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i10));
    }
}
