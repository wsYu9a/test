package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;

/* loaded from: classes.dex */
public class CpuVideoView extends RelativeLayout {
    public static final String TAG = "CpuVideoView";
    private CpuVideoStatusListener mCpuVideoStatusListener;
    private FeedPortraitVideoView mVideoView;

    /* renamed from: com.baidu.mobads.sdk.api.CpuVideoView$1 */
    class AnonymousClass1 implements IFeedPortraitListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void pauseBtnClick() {
            av.h(CpuVideoView.TAG).d("pauseBtnClick: ");
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playCompletion() {
            av.h(CpuVideoView.TAG).d("playCompletion: ");
            if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                CpuVideoView.this.mCpuVideoStatusListener.playCompletion();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playError() {
            av.h(CpuVideoView.TAG).d("playError: ");
            if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                CpuVideoView.this.mCpuVideoStatusListener.playError();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playPause() {
            av.h(CpuVideoView.TAG).d("playPause: ");
            if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                CpuVideoView.this.mCpuVideoStatusListener.playPause();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playRenderingStart() {
            av.h(CpuVideoView.TAG).d("playRenderingStart: ");
            if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                CpuVideoView.this.mCpuVideoStatusListener.playRenderingStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public void playResume() {
            av.h(CpuVideoView.TAG).d("playResume: ");
            if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                CpuVideoView.this.mCpuVideoStatusListener.playResume();
            }
        }
    }

    public interface CpuVideoStatusListener {
        void playCompletion();

        void playError();

        void playPause();

        void playRenderingStart();

        void playResume();
    }

    public CpuVideoView(Context context) {
        this(context, null);
    }

    private void initVideoView() {
        FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(getContext());
        this.mVideoView = feedPortraitVideoView;
        feedPortraitVideoView.systemSetVideoMute(true);
        this.mVideoView.setProgressBarColor(-1);
        this.mVideoView.setProgressHeightInDp(1);
        this.mVideoView.setProgressBackgroundColor(-16777216);
        this.mVideoView.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.baidu.mobads.sdk.api.CpuVideoView.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
                av.h(CpuVideoView.TAG).d("pauseBtnClick: ");
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                av.h(CpuVideoView.TAG).d("playCompletion: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playCompletion();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                av.h(CpuVideoView.TAG).d("playError: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playError();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                av.h(CpuVideoView.TAG).d("playPause: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playPause();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                av.h(CpuVideoView.TAG).d("playRenderingStart: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playRenderingStart();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                av.h(CpuVideoView.TAG).d("playResume: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playResume();
                }
            }
        });
        addView(this.mVideoView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setCpuVideoStatusListener(CpuVideoStatusListener cpuVideoStatusListener) {
        this.mCpuVideoStatusListener = cpuVideoStatusListener;
    }

    public void setVideoConfig(IBasicCPUData iBasicCPUData) {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setAdData(iBasicCPUData);
        }
    }

    public CpuVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CpuVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initVideoView();
    }
}
