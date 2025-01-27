package com.shu.priory.request;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.param.AdParam;
import com.shu.priory.param.UploadData;
import com.shu.priory.utils.Encoder;
import com.shu.priory.utils.h;
import com.shu.priory.utils.k;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a */
    private static volatile boolean f17233a = false;

    public static void a(Context context, AdParam adParam, c cVar) throws Exception {
        boolean booleanParam = adParam.getBooleanParam(AdKeys.DEBUG_MODE);
        h.a(booleanParam);
        if (!k.a(context)) {
            throw new AdError(ErrorCode.ERROR_NETWORK);
        }
        if (booleanParam) {
            h.a(SDKConstants.TAG, "requestAd:" + adParam.getAdUnitId());
        }
        if (TextUtils.isEmpty(adParam.getAdUnitId())) {
            throw new AdError(ErrorCode.ERROR_EMPTY_ADUNITID);
        }
        try {
            if (!f17233a) {
                if (booleanParam) {
                    h.a(SDKConstants.TAG, "re load library");
                }
                com.shu.priory.f.c.a(context, "iflyads");
                f17233a = true;
            }
            b(context, adParam, cVar);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "requestAd ReLinker Exception:" + th2.getMessage());
            throw new AdError(ErrorCode.ERROR_UNKNOWN);
        }
    }

    private static void b(Context context, AdParam adParam, c cVar) {
        MalformedURLException e10;
        UploadData.initParam(context);
        String packageData = Encoder.packageData(adParam);
        if (TextUtils.isEmpty(packageData)) {
            h.d(SDKConstants.TAG, "package request error");
            return;
        }
        byte[] zip = Encoder.zip(packageData.getBytes());
        Encoder.encrypt(zip);
        b bVar = new b();
        bVar.a(context);
        bVar.a(0);
        bVar.b(1);
        bVar.c(adParam.getIntParam(AdKeys.HTTP_REQUEST_TIMEOUT));
        String stringParam = adParam.getStringParam("x_url");
        if (TextUtils.isEmpty(stringParam)) {
            stringParam = com.shu.priory.param.b.f17177b;
            if (adParam.hasParam(AdKeys.HTTP_DNS_ENABLE) ? adParam.getBooleanParam(AdKeys.HTTP_DNS_ENABLE) : false) {
                a a10 = a.a(context);
                String a11 = a10.a();
                if (!TextUtils.isEmpty(a11)) {
                    try {
                        try {
                            bVar.a(new URL(com.shu.priory.param.b.f17177b).getHost());
                        } catch (MalformedURLException e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            stringParam = a11;
                            a10.b();
                            h.a(SDKConstants.TAG, "request url " + stringParam);
                            bVar.a(stringParam, null, zip);
                            bVar.a(cVar);
                            com.shu.priory.utils.e.a(context, "adUnitID", adParam.getAdUnitId());
                        }
                    } catch (MalformedURLException e12) {
                        a11 = stringParam;
                        e10 = e12;
                    }
                    stringParam = a11;
                }
                a10.b();
            }
        }
        h.a(SDKConstants.TAG, "request url " + stringParam);
        bVar.a(stringParam, null, zip);
        bVar.a(cVar);
        com.shu.priory.utils.e.a(context, "adUnitID", adParam.getAdUnitId());
    }
}
