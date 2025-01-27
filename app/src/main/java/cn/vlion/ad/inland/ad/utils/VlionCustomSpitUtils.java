package cn.vlion.ad.inland.ad.utils;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VlionCustomSpitUtils {
    public static ArrayList<String> getSplitString(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(",")) {
                    String[] split = str.split(",");
                    if (split != null && split.length > 0) {
                        arrayList.addAll(Arrays.asList(split));
                    }
                } else {
                    arrayList.add(str);
                }
            }
        } catch (Throwable th2) {
            LogVlion.e("getSplitString Exception=" + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return arrayList;
    }
}
