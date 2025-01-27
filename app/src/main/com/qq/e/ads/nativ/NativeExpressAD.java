package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* renamed from: h */
    private volatile int f16456h;

    /* renamed from: i */
    private volatile int f16457i;

    /* renamed from: j */
    private List<Integer> f16458j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k */
    private VideoOption f16459k;

    /* renamed from: l */
    private ADSize f16460l;

    /* renamed from: m */
    private NativeExpressADListener f16461m;

    /* renamed from: n */
    private final ADListenerAdapter f16462n;

    /* renamed from: o */
    private LoadAdParams f16463o;

    /* renamed from: p */
    private volatile ServerSideVerificationOptions f16464p;

    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a */
        private NativeExpressADListener f16465a;

        /* renamed from: b */
        private NativeExpressMediaListener f16466b;

        /* renamed from: c */
        private NegativeFeedbackListener f16467c;

        /* renamed from: d */
        private ADRewardListener f16468d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f16465a = nativeExpressADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.a(this.f16465a, aDEvent) || NativeExpressAD.a(this.f16466b, aDEvent) || NativeExpressAD.a(this.f16467c, aDEvent)) {
                return;
            }
            NativeExpressAD.a(this.f16468d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f16468d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f16466b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f16467c = negativeFeedbackListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f16466b = nativeExpressMediaListener;
        }
    }

    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f16461m = nativeExpressADListener;
        this.f16462n = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    private boolean a(ADSize aDSize) {
        if (aDSize != null) {
            this.f16460l = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(2001);
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        NativeExpressADListener nativeExpressADListener = this.f16461m;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public String getAdNetWorkName() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((NEADI) t10).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i10) {
        loadAD(i10, null);
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f16463o = loadAdParams;
    }

    public void setMaxVideoDuration(int i10) {
        this.f16457i = i10;
        if (this.f16457i > 0 && this.f16456h > this.f16457i) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NEADI) t10).setMaxVideoDuration(this.f16457i);
        }
    }

    public void setMinVideoDuration(int i10) {
        this.f16456h = i10;
        if (this.f16457i > 0 && this.f16456h > this.f16457i) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NEADI) t10).setMinVideoDuration(this.f16456h);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f16462n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f16464p = serverSideVerificationOptions;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NEADI) t10).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f16459k = videoOption;
        T t10 = this.f16367a;
        if (t10 == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t10).setVideoOption(videoOption);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f16461m = nativeExpressADListener;
        this.f16462n = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    public static boolean a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    public void loadAD(int i10, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f16458j) {
                    this.f16458j.add(Integer.valueOf(i10));
                }
                return;
            }
            T t10 = this.f16367a;
            if (t10 == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f16463o;
            NEADI neadi = (NEADI) t10;
            if (loadAdParams2 != null) {
                neadi.loadAd(i10, loadAdParams2);
            } else {
                neadi.loadAd(i10);
            }
        }
    }

    public static boolean a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            }
            if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            }
            if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            }
            if (type == 207) {
                Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                if (num == null) {
                    return true;
                }
                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                return true;
            }
            if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            }
            if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            }
            switch (type) {
                case 209:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    break;
                case 210:
                    if (((Integer) aDEvent.getParam(1, Integer.class)) != null) {
                        nativeExpressMediaListener.onVideoReady(nativeExpressADView, r6.intValue());
                        break;
                    }
                    break;
                case AdEventType.VIDEO_LOADING /* 211 */:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    break;
            }
            return true;
        }
        return false;
    }

    public static boolean a(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    public static boolean a(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        String str = (String) aDEvent.getParam(String.class);
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("transId", str);
            aDRewardListener.onReward(hashMap);
        }
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f16460l, str, str2, str3, this.f16462n);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NEADI neadi = (NEADI) obj;
        neadi.setMinVideoDuration(this.f16456h);
        neadi.setMaxVideoDuration(this.f16457i);
        ((NEADI) this.f16367a).setServerSideVerificationOptions(this.f16464p);
        VideoOption videoOption = this.f16459k;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f16458j) {
            try {
                Iterator<Integer> it = this.f16458j.iterator();
                while (it.hasNext()) {
                    T t10 = this.f16367a;
                    if (t10 != 0) {
                        if (this.f16463o != null) {
                            ((NEADI) t10).loadAd(it.next().intValue(), this.f16463o);
                        } else {
                            ((NEADI) t10).loadAd(it.next().intValue());
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
