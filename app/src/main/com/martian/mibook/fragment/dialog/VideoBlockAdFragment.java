package com.martian.mibook.fragment.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.d;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.PopupwindowBlockAdBinding;
import com.martian.mibook.fragment.dialog.VideoBlockAdFragment;
import com.martian.rpauth.MartianRPUserManager;
import java.text.DecimalFormat;
import je.i;
import vb.e;

/* loaded from: classes3.dex */
public class VideoBlockAdFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: j */
    public static final String f13792j = "TAG_VIDEO_BLOCK_AD";

    /* renamed from: k */
    public static final String f13793k = "INTENT_SOURCE_STRING";

    /* renamed from: l */
    public static final String f13794l = "INTENT_AD_HIDING";

    /* renamed from: f */
    public PopupwindowBlockAdBinding f13795f;

    /* renamed from: g */
    public a f13796g;

    /* renamed from: h */
    public String f13797h;

    /* renamed from: i */
    public boolean f13798i;

    public interface a {
        void a();
    }

    public static /* synthetic */ void I(DialogFragment dialogFragment) {
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        boolean s10 = MiConfigSingleton.b2().h2().s();
        d.y3(dialogFragment).T2(!s10).G1(!s10).B1(k10.getNavigationBarBackgroundColor(false), 0.0f).a1();
    }

    public /* synthetic */ void K(View view) {
        i.e0(getActivity(), "底部状态栏", e.e(this.f13797h), e.d(this.f13797h));
    }

    public /* synthetic */ void M(View view) {
        dismiss();
        this.f13796g.a();
    }

    public static void P(FragmentActivity fragmentActivity, String str, boolean z10, a aVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.popupwindow_block_ad, (ViewGroup) null)).k0(true).j0(true).x0(com.martian.libmars.R.style.BottomSheetDialog).s0(new MartianBottomSheetDialogFragment.b() { // from class: eb.l0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                VideoBlockAdFragment.I(dialogFragment);
            }
        });
        VideoBlockAdFragment videoBlockAdFragment = new VideoBlockAdFragment();
        Bundle bundle = new Bundle();
        bundle.putString(f13793k, str);
        bundle.putBoolean(f13794l, z10);
        videoBlockAdFragment.setArguments(bundle);
        videoBlockAdFragment.O(aVar);
        a10.c0(fragmentActivity, videoBlockAdFragment, f13792j, true);
    }

    private void Q() {
        if (TextUtils.isEmpty(this.f13797h)) {
            return;
        }
        this.f13795f.blockAdVip.setOnClickListener(new View.OnClickListener() { // from class: eb.m0
            public /* synthetic */ m0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoBlockAdFragment.this.K(view);
            }
        });
        this.f13795f.blockAdVideoView.setOnClickListener(new View.OnClickListener() { // from class: eb.n0
            public /* synthetic */ n0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoBlockAdFragment.this.M(view);
            }
        });
        this.f13795f.blockAdClose.setOnClickListener(new View.OnClickListener() { // from class: eb.o0
            public /* synthetic */ o0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoBlockAdFragment.this.N(view);
            }
        });
        long r10 = ReadingInstance.z().r() - MartianRPUserManager.a();
        if (r10 <= 0) {
            this.f13795f.blockAdTitle.setText(ConfigSingleton.D().s("领取无广告阅读时长"));
            this.f13795f.blockAdMinutes.setText(new StringBuilder(com.sigmob.sdk.archives.tar.e.S));
            this.f13795f.blockAdSeconds.setText(new StringBuilder(com.sigmob.sdk.archives.tar.e.S));
        } else {
            this.f13795f.blockAdTitle.setText(ConfigSingleton.D().s("无广告阅读中"));
            long j10 = r10 / 1000;
            DecimalFormat decimalFormat = new DecimalFormat(com.sigmob.sdk.archives.tar.e.S);
            this.f13795f.blockAdMinutes.setText(decimalFormat.format(j10 / 60));
            this.f13795f.blockAdSeconds.setText(decimalFormat.format(j10 % 60));
        }
        this.f13795f.blockAdVideo.setText(ConfigSingleton.D().s("看视频加" + MiConfigSingleton.b2().I1(this.f13798i) + "分钟"));
    }

    public final /* synthetic */ void N(View view) {
        dismiss();
    }

    public final void O(a aVar) {
        this.f13796g = aVar;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13797h = arguments.getString(f13793k);
            this.f13798i = arguments.getBoolean(f13794l);
        }
        if (TextUtils.isEmpty(this.f13797h)) {
            dismiss();
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        View m10 = m();
        if (m10 != null) {
            this.f13795f = PopupwindowBlockAdBinding.bind(m10);
            Q();
        }
    }
}
