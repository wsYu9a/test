package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g {
    public static STConfigEntity a(Context context) {
        if (context != null) {
            com.opos.cmn.an.f.a.b("WrapSTConfigUtil", "st config read form file");
            JSONObject b2 = e.b(context);
            if (b2 != null) {
                return a(b2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.cmn.biz.ststrategy.entity.STConfigEntity a(org.json.JSONObject r24) {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.g.a(org.json.JSONObject):com.opos.cmn.biz.ststrategy.entity.STConfigEntity");
    }

    private static List<String> a(String str) {
        if (f.a(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken().trim());
        }
        return arrayList;
    }

    private static String b(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = com.opos.cmn.an.a.d.b(str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WrapSTConfigUtil", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("WrapSTConfigUtil", "urlDecodeString before:" + str + ",after:" + str2);
        return str2;
    }
}
