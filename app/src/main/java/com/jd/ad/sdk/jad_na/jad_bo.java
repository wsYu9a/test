package com.jd.ad.sdk.jad_na;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_yl.jad_dq;
import com.jd.ad.sdk.jad_yl.jad_er;
import com.jd.ad.sdk.jad_yl.jad_fs;
import com.jd.ad.sdk.jad_yl.jad_hu;
import com.jd.ad.sdk.jad_yl.jad_jt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class jad_bo {

    public static class jad_an {
        public static final jad_bo jad_an = new jad_bo();
    }

    public com.jd.ad.sdk.jad_yl.jad_cp jad_an(String str) {
        jad_hu jad_huVar;
        List<jad_dq> list;
        jad_dq jad_dqVar;
        jad_jt jad_er = jad_er(str);
        if (jad_er == null || (jad_huVar = jad_er.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null) {
            return null;
        }
        return jad_dqVar.jad_bo;
    }

    public String jad_bo(String str) {
        jad_er jad_erVar;
        List<jad_er> list;
        List<jad_fs> jad_dq = jad_dq(str);
        ArrayList arrayList = new ArrayList();
        if (jad_dq != null && !jad_dq.isEmpty()) {
            for (int i10 = 0; i10 < jad_dq.size(); i10++) {
                jad_fs jad_fsVar = jad_dq.get(i10);
                int size = arrayList.size();
                if (jad_fsVar != null) {
                    String str2 = jad_fsVar.jad_er;
                    if (TextUtils.isEmpty(str2)) {
                        list = jad_fsVar.jad_fs;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        jad_er jad_erVar2 = new jad_er();
                        jad_erVar2.jad_an = str2;
                        String.valueOf(size);
                        arrayList2.add(jad_erVar2);
                        list = arrayList2;
                    }
                } else {
                    list = null;
                }
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
        }
        return (arrayList.isEmpty() || (jad_erVar = (jad_er) arrayList.get(0)) == null || TextUtils.isEmpty(jad_erVar.jad_an)) ? "" : jad_erVar.jad_an;
    }

    public final jad_fs jad_cp(String str) {
        List<jad_fs> jad_dq;
        if (jad_er(str) == null || (jad_dq = jad_dq(str)) == null || jad_dq.isEmpty()) {
            return null;
        }
        return jad_dq.get(0);
    }

    @Nullable
    public List<jad_fs> jad_dq(String str) {
        jad_hu jad_huVar;
        jad_jt jad_er = jad_er(str);
        if (jad_er == null) {
            return null;
        }
        jad_jt jad_er2 = jad_er(str);
        List<jad_dq> list = (jad_er2 == null || (jad_huVar = jad_er2.jad_cp) == null) ? null : jad_huVar.jad_an;
        if (list == null || list.isEmpty() || jad_er.jad_cp.jad_an.get(0).jad_bo == null || jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an == null || jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an.isEmpty()) {
            return null;
        }
        return jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an;
    }

    public jad_jt jad_er(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return jad_jt.jad_an(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
