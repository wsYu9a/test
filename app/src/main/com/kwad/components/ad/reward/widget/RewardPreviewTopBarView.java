package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String CK;
    private String CL;
    private ProgressBar CM;
    private TextView CN;
    private long CO;
    private long CP;
    private boolean CQ;
    private a CR;
    private ImageView cu;

    /* renamed from: ud */
    private TextView f11889ud;

    public interface a {
        void G(boolean z10);

        void H(boolean z10);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.CK = " 秒后即可获得奖励";
        this.CL = "恭喜你获得奖励";
        this.CO = -1L;
        this.CQ = false;
    }

    @MainThread
    private void e(long j10, long j11) {
        this.CM.setProgress((int) (j11 - j10));
    }

    @MainThread
    private void f(boolean z10, boolean z11) {
        if (this.CQ) {
            this.f11889ud.setVisibility(0);
        } else {
            this.f11889ud.setVisibility(8);
            this.CN.setText(this.CL);
            a aVar = this.CR;
            if (aVar != null) {
                aVar.H(false);
            }
        }
        this.CQ = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        View.inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.CM = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.f11889ud = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.CN = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.cu = imageView;
        imageView.setVisibility(8);
        this.cu.setOnClickListener(this);
    }

    public final boolean kz() {
        return this.CQ;
    }

    @MainThread
    public final void n(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        TextView textView = this.CN;
        if (textView != null) {
            textView.setText(ceil + this.CK);
        }
        e(j10, this.CO);
        if (this.CO - j10 >= this.CP && this.cu.getVisibility() != 0) {
            this.cu.setVisibility(0);
        }
        if (ceil <= 0) {
            f(true, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.cu) || (aVar = this.CR) == null) {
            return;
        }
        aVar.G(this.CQ);
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j10) {
        this.CP = j10;
        if (j10 <= 0) {
            this.cu.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.f11889ud;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTopBarListener(a aVar) {
        this.CR = aVar;
    }

    @MainThread
    public void setTotalCountDuration(long j10) {
        this.CO = j10;
        this.CM.setMax((int) j10);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CK = " 秒后即可获得奖励";
        this.CL = "恭喜你获得奖励";
        this.CO = -1L;
        this.CQ = false;
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.CK = " 秒后即可获得奖励";
        this.CL = "恭喜你获得奖励";
        this.CO = -1L;
        this.CQ = false;
    }
}
