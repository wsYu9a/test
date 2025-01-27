package com.alimm.tanx.core.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AdParse {

    public interface ParseCallBack {
        void parseSucc(AdInfo adInfo);
    }

    public static AdInfo tanxc_do(AdInfo adInfo) {
        try {
            LogUtils.d("AdParse", "syncAgainParseAdAndFilterData，线程：" + Thread.currentThread());
            if (adInfo != null) {
                if (adInfo.getStatus() != 0) {
                    if (adInfo.getStatus() == 1) {
                    }
                }
                if (adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
                    for (int i10 = 0; i10 < adInfo.getSeatList().size(); i10++) {
                        List<String> rawBidList = adInfo.getSeatList().get(i10).getRawBidList();
                        ArrayList arrayList = new ArrayList();
                        if (rawBidList != null && rawBidList.size() > 0) {
                            for (int i11 = 0; i11 < rawBidList.size(); i11++) {
                                BidInfo bidInfo = (BidInfo) JSON.parseObject(rawBidList.get(i11), BidInfo.class);
                                bidInfo.setRawJsonStr(tanxc_do(rawBidList.get(i11)));
                                arrayList.add(bidInfo);
                            }
                        }
                        adInfo.getSeatList().get(i10).setBidList(arrayList);
                    }
                }
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
        return adInfo;
    }

    private static String tanxc_do(String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            parseObject.remove("impression_tracking_url");
            parseObject.remove("click_tracking_url");
            parseObject.remove("winnotice_url");
            return JSON.toJSONString(parseObject);
        } catch (Exception e10) {
            LogUtils.e(e10);
            return str;
        }
    }
}
