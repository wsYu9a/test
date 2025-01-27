package cn.vlion.ad.inland.base.util.handle;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.v4;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class VlionBaseParameterReplace implements Serializable {
    public HashMap<String, String> AllParameter = new HashMap<>();

    public VlionBaseParameterReplace(VlionCustomParseAdData vlionCustomParseAdData) {
        if (vlionCustomParseAdData != null) {
            try {
                VlionBaseParameterHander(vlionCustomParseAdData.getmDefaultVal(), vlionCustomParseAdData.getMacroValues());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public void VlionBaseParameterHander(String str, List<VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues> list) {
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.putAll(getDefaultBaseParameter(str));
                this.AllParameter.putAll(getDefaultClickParameter(str));
                this.AllParameter.putAll(getDefaultShakeParameter(str));
                if (list != null) {
                    for (VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues macrovalues : list) {
                        if (macrovalues != null) {
                            this.AllParameter.put(macrovalues.getM(), macrovalues.getV());
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public HashMap<String, String> getDefaultBaseParameter(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("__DP_WIDTH__", str);
            hashMap.put("__DP_HEIGHT__", str);
            hashMap.put("__WIDTH__", str);
            hashMap.put("__HEIGHT__", str);
            hashMap.put("__P_DURATION__", str);
            hashMap.put("__P_DURATION_S__", str);
            hashMap.put("__P_RATE__", str);
            hashMap.put("__TIME_S__", str);
            hashMap.put("__IS_FINISHED__", str);
            hashMap.put("__CLICK_MODE__", str);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return hashMap;
    }

    public HashMap<String, String> getDefaultClickParameter(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("__TS__", str);
            hashMap.put("__TS_S__", str);
            hashMap.put("__TS_END__", str);
            hashMap.put("__TS_END_S__", str);
            hashMap.put("__PNT_DOWN_X__", str);
            hashMap.put("__PNT_DOWN_Y__", str);
            hashMap.put("__PNT_UP_X__", str);
            hashMap.put("__PNT_UP_Y__", str);
            hashMap.put("__DP_PNT_DOWN_X__", str);
            hashMap.put("__DP_PNT_DOWN_Y__", str);
            hashMap.put("__DP_PNT_UP_X__", str);
            hashMap.put("__DP_PNT_UP_Y__", str);
            hashMap.put("__DP_DOWN_X__", str);
            hashMap.put("__DP_DOWN_Y__", str);
            hashMap.put("__DP_UP_X__", str);
            hashMap.put("__DP_UP_Y__", str);
            hashMap.put("__DOWN_X__", str);
            hashMap.put("__DOWN_Y__", str);
            hashMap.put("__UP_X__", str);
            hashMap.put("__UP_Y__", str);
            hashMap.put("__IMP_X1__", str);
            hashMap.put("__IMP_Y1__", str);
            hashMap.put("__IMP_X2__", str);
            hashMap.put("__IMP_Y2__", str);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return hashMap;
    }

    public HashMap<String, String> getDefaultShakeParameter(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("__X_MAX_ACC__", str);
            hashMap.put("__Y_MAX_ACC__", str);
            hashMap.put("__Z_MAX_ACC__", str);
            hashMap.put("__TURN_X__", str);
            hashMap.put("__TURN_Y__", str);
            hashMap.put("__TURN_Z__", str);
            hashMap.put("__TURN_TIME__", str);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return hashMap;
    }

    public void handleApkDownloadParameter(int i10) {
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.put("__DLD_PHASE__", String.valueOf(i10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void handleBaseParameter(View view) {
        if (view != null) {
            try {
                if (this.AllParameter != null) {
                    int width = view.getWidth();
                    int height = view.getHeight();
                    int px2dip = DensityUtil.px2dip(VlionSDkManager.getInstance().getApplication(), width);
                    int px2dip2 = DensityUtil.px2dip(VlionSDkManager.getInstance().getApplication(), height);
                    this.AllParameter.put("__DP_WIDTH__", String.valueOf(px2dip));
                    this.AllParameter.put("__DP_HEIGHT__", String.valueOf(px2dip2));
                    this.AllParameter.put("__WIDTH__", String.valueOf(width));
                    this.AllParameter.put("__HEIGHT__", String.valueOf(height));
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i10 = iArr[0];
                    int i11 = iArr[1];
                    int width2 = view.getWidth() + i10;
                    int height2 = view.getHeight() + i11;
                    this.AllParameter.put("__IMP_X1__", String.valueOf(i10));
                    this.AllParameter.put("__IMP_Y1__", String.valueOf(i11));
                    this.AllParameter.put("__IMP_X2__", String.valueOf(width2));
                    this.AllParameter.put("__IMP_Y2__", String.valueOf(height2));
                    this.AllParameter.put("__LIP__", v4.b());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public void handleClickParameter(i0 i0Var, VlionADClickType vlionADClickType) {
    }

    public void handleExposureParameter(long j10) {
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.put("__TS_S__", String.valueOf(j10 / 1000));
                this.AllParameter.put("__TS__", String.valueOf(j10));
                this.AllParameter.put("__TS_CUSTOM_V1__", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Long.valueOf(j10)));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void handleRenderSuccessParameter(long j10) {
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.put("__READY_TIME__", String.valueOf(j10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public String handleReplace(String str) {
        if (str == null) {
            return "";
        }
        try {
            LogVlion.e("宏替换:   原始URL : " + str);
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                for (String str2 : hashMap.keySet()) {
                    str = str.replace(str2, this.AllParameter.get(str2));
                }
            }
            LogVlion.e("宏替换:   替换后URL : " + str);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return str;
    }

    public void handleShakeParameter(boolean z10, VlionSensorPara vlionSensorPara, VlionADClickType vlionADClickType) {
    }

    public void handleSwipeParameter(i0 i0Var, VlionADClickType vlionADClickType) {
    }

    public void handleVideoFinishParameter(int i10) {
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.put("__V_END_TIME__", String.valueOf(i10));
                this.AllParameter.put("__V_PLAY_LAST_FRAME__", String.valueOf(1));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void handleVideoParameter(boolean z10, int i10, int i11) {
        String valueOf;
        String str;
        try {
            if (this.AllParameter != null) {
                if (z10) {
                    valueOf = String.valueOf(i11);
                    str = "100";
                    this.AllParameter.put("__IS_FINISHED__", "1");
                    this.AllParameter.put("__TIME_S__", String.valueOf(i11));
                } else {
                    valueOf = String.valueOf(i10);
                    String valueOf2 = i11 > 0 ? String.valueOf((i10 * 100) / i11) : "0";
                    this.AllParameter.put("__IS_FINISHED__", "0");
                    this.AllParameter.put("__TIME_S__", String.valueOf(i10));
                    str = valueOf2;
                }
                int nextInt = new Random().nextInt(1000);
                this.AllParameter.put("__P_DURATION__", valueOf + nextInt);
                this.AllParameter.put("__P_DURATION_S__", valueOf);
                this.AllParameter.put("__P_RATE__", str);
                this.AllParameter.put("__V_VIDEO_TIME__", String.valueOf(i11));
                this.AllParameter.put("__V_SCENE__", String.valueOf(1));
                this.AllParameter.put("__V_BEGIN_TIME__", String.valueOf(0));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void handleVideoPlayingParameter(int i10) {
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.put("__V_PROGRESS__", String.valueOf(i10 * 1000));
                this.AllParameter.put("__V_PROGRESS_S__", String.valueOf(i10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void handleVideoStartParameter(boolean z10, int i10, int i11, VlionAdapterADConfig vlionAdapterADConfig) {
        HashMap<String, String> hashMap;
        String valueOf;
        HashMap<String, String> hashMap2;
        String valueOf2;
        HashMap<String, String> hashMap3;
        String valueOf3;
        String str = "__V_PLAY_LAST_FRAME__";
        try {
            HashMap<String, String> hashMap4 = this.AllParameter;
            if (hashMap4 != null) {
                hashMap4.put("__V_BEGIN_TIME__", String.valueOf(i10));
                if (i10 < 1) {
                    hashMap = this.AllParameter;
                    valueOf = String.valueOf(1);
                } else {
                    hashMap = this.AllParameter;
                    valueOf = String.valueOf(0);
                }
                hashMap.put("__V_PLAY_FIRST_FRAME__", valueOf);
                this.AllParameter.put("__V_PLAY_LAST_FRAME__", String.valueOf(0));
                if (z10) {
                    this.AllParameter.put("__V_TYPE__", String.valueOf(3));
                    hashMap2 = this.AllParameter;
                    valueOf2 = String.valueOf(1);
                } else {
                    if (i10 < 1) {
                        hashMap2 = this.AllParameter;
                        valueOf2 = String.valueOf(1);
                    } else {
                        hashMap2 = this.AllParameter;
                        valueOf2 = String.valueOf(2);
                    }
                    str = "__V_TYPE__";
                }
                hashMap2.put(str, valueOf2);
                if (vlionAdapterADConfig != null) {
                    if (vlionAdapterADConfig.getAutoPlay() == 3) {
                        hashMap3 = this.AllParameter;
                        valueOf3 = String.valueOf(2);
                    } else {
                        hashMap3 = this.AllParameter;
                        valueOf3 = String.valueOf(1);
                    }
                    hashMap3.put("__V_BEHAVIOR__", valueOf3);
                }
                this.AllParameter.put("__V_SCENE__", String.valueOf(1));
                this.AllParameter.put("__V_BEGIN_TIME__", String.valueOf(0));
                this.AllParameter.put("__V_STATUS__", String.valueOf(0));
                this.AllParameter.put("__V_VIDEO_TIME__", String.valueOf(i11));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionBaseParameterReplace(String str, List<VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues> list) {
        try {
            VlionBaseParameterHander(str, list);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
