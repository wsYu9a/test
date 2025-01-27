package com.cdo.oaps.ad;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.cdo.oaps.ad.wrapper.BaseRespWrapper;
import com.cdo.oaps.ad.wrapper.SqlWrapper;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(bArr);
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Map map, byte[] bArr) {
        if (map != null && !map.isEmpty() && bArr != null) {
            String dataMd5 = SqlWrapper.wrapper((Map<String, Object>) map).getDataMd5();
            if (TextUtils.isEmpty(dataMd5) || !dataMd5.equals(a(bArr))) {
                String dataMd52 = BaseRespWrapper.wrapper((Map<String, Object>) map).getDataMd5();
                if (TextUtils.isEmpty(dataMd52) || !dataMd52.equals(a(bArr))) {
                }
            }
            return true;
        }
        return false;
    }
}
