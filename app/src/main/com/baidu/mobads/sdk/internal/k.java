package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a */
    private static final String f7202a = "竞价参数格式错误，请检查参数是否为空";

    /* renamed from: b */
    private static final String f7203b = "ecpm格式错误，请检查是否满足以下条件：ecpm需大于0，单位：分，无小数点";

    /* renamed from: c */
    private static final String f7204c = "adn格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: d */
    private static final String f7205d = "ad_t格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: e */
    private static final String f7206e = "ad_time格式错误，请检查是否满足以下条件：秒级时间戳（10位数字）、无特殊符号";

    /* renamed from: f */
    private static final String f7207f = "bid_t格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: g */
    private static final String f7208g = "reason格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: h */
    private static final String f7209h = "is_s格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: i */
    private static final String f7210i = "is_c格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    public static boolean a(boolean z10, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (linkedHashMap != null) {
            try {
                if (linkedHashMap.containsKey("ecpm")) {
                    String valueOf = String.valueOf(linkedHashMap.get("ecpm"));
                    if (!TextUtils.isEmpty(valueOf)) {
                        if (!valueOf.contains(p1.b.f29697h)) {
                            if (Integer.parseInt(valueOf) <= 0) {
                            }
                        }
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f7203b, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey(SplashAd.KEY_BIDFAIL_ADN)) {
                    String valueOf2 = String.valueOf(linkedHashMap.get(SplashAd.KEY_BIDFAIL_ADN));
                    if (!TextUtils.isEmpty(valueOf2) && (valueOf2.contains(p1.b.f29697h) || Integer.parseInt(valueOf2) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f7204c, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("ad_t")) {
                    String valueOf3 = String.valueOf(linkedHashMap.get("ad_t"));
                    if (TextUtils.isEmpty(valueOf3) && (valueOf3.contains(p1.b.f29697h) || Integer.parseInt(valueOf3) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f7205d, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("ad_time")) {
                    String valueOf4 = String.valueOf(linkedHashMap.get("ad_time"));
                    if (valueOf4.length() == 13) {
                        linkedHashMap.put("ad_time", valueOf4.substring(0, 10));
                    }
                    if (TextUtils.isEmpty(valueOf4) && (valueOf4.contains(p1.b.f29697h) || Double.parseDouble(valueOf4) < 1.0E9d)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f7206e, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("bid_t")) {
                    String valueOf5 = String.valueOf(linkedHashMap.get("bid_t"));
                    if (TextUtils.isEmpty(valueOf5) && (valueOf5.contains(p1.b.f29697h) || Integer.parseInt(valueOf5) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f7207f, null);
                        }
                        return false;
                    }
                }
                if (!z10) {
                    if (linkedHashMap.containsKey(MediationConstant.KEY_REASON)) {
                        String valueOf6 = String.valueOf(linkedHashMap.get(MediationConstant.KEY_REASON));
                        if (TextUtils.isEmpty(valueOf6) && (valueOf6.contains(p1.b.f29697h) || Integer.parseInt(valueOf6) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, f7208g, null);
                            }
                            return false;
                        }
                    }
                    if (linkedHashMap.containsKey("is_s")) {
                        String valueOf7 = String.valueOf(linkedHashMap.get("is_s"));
                        if (TextUtils.isEmpty(valueOf7) && (valueOf7.contains(p1.b.f29697h) || Integer.parseInt(valueOf7) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, f7209h, null);
                            }
                            return false;
                        }
                    }
                    if (linkedHashMap.containsKey("is_c")) {
                        String valueOf8 = String.valueOf(linkedHashMap.get("is_c"));
                        if (TextUtils.isEmpty(valueOf8) && (valueOf8.contains(p1.b.f29697h) || Integer.parseInt(valueOf8) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, f7210i, null);
                            }
                            return false;
                        }
                    }
                }
            } catch (Throwable th2) {
                if (biddingListener != null) {
                    biddingListener.onBiddingResult(false, f7202a, null);
                }
                th2.printStackTrace();
                return false;
            }
        }
        if (biddingListener != null) {
            biddingListener.onBiddingResult(true, "success", null);
        }
        return true;
    }
}
