package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity;
import com.jd.ad.sdk.jad_fs.jad_cp;
import com.jd.ad.sdk.jad_na.jad_bo;
import com.jd.ad.sdk.jad_na.jad_cp;
import com.jd.ad.sdk.jad_xk.jad_iv;
import com.jd.ad.sdk.mdt.service.JADTouchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_jw implements JADTouchService {
    public final String[] jad_an(com.jd.ad.sdk.jad_fs.jad_bo jad_boVar, String str) {
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_bo.jad_an.jad_an.jad_cp(str);
        List<String> emptyList = jad_cp != null ? jad_cp.jad_kx : Collections.emptyList();
        if (emptyList == null) {
            return new String[0];
        }
        String[] strArr = (String[]) emptyList.toArray(new String[0]);
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = jad_boVar.jad_an(strArr[i10]);
        }
        return strArr2;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public int onViewClicked(@NonNull Context context, @NonNull View view, @NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            return -2;
        }
        String str2 = jad_cp.jad_an.jad_an.jad_an.get(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return -2;
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar2 = jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_boVar2.jad_cp(str2);
        String str4 = (jad_cp == null || TextUtils.isEmpty(jad_cp.jad_dq)) ? "" : jad_cp.jad_dq;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp2 = jad_boVar2.jad_cp(str2);
        String str5 = (jad_cp2 == null || TextUtils.isEmpty(jad_cp2.jad_cp)) ? "" : jad_cp2.jad_cp;
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp3 = jad_boVar2.jad_cp(str2);
        if (jad_cp3 != null && !TextUtils.isEmpty(jad_cp3.jad_ly)) {
            str3 = jad_cp3.jad_ly;
        }
        if ("1".equals(str3) && !TextUtils.isEmpty(str4) && com.jd.ad.sdk.jad_er.jad_an.jad_an(context, jad_boVar.jad_an(str4))) {
            jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
            return 1;
        }
        if (!"1".equals(str3) || TextUtils.isEmpty(str5)) {
            return 2;
        }
        String jad_an = jad_boVar.jad_an(str5);
        if (TextUtils.isEmpty(jad_an)) {
            return 2;
        }
        if (TextUtils.isEmpty(jad_an) || context == null) {
            return 3;
        }
        try {
            JADWebViewActivity.startActivity(context, jad_an);
            jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
            return 0;
        } catch (Exception unused) {
            return 3;
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void onViewTouch(@NonNull View view, @NonNull MotionEvent motionEvent, @NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_an jad_anVar;
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null || (jad_anVar = jad_boVar.jad_an) == null || motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            jad_anVar.jad_an.clear();
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_fs.jad_dq(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()), System.currentTimeMillis());
            return;
        }
        if (action != 1) {
            if (action == 2) {
                if (jad_anVar.jad_an.size() > 999) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(jad_anVar.jad_an.get(0));
                    arrayList.addAll(jad_anVar.jad_an.subList(r0.size() - 399, jad_anVar.jad_an.size()));
                    jad_anVar.jad_an.clear();
                    jad_anVar.jad_an.addAll(arrayList);
                    arrayList.clear();
                }
                jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis()));
                return;
            }
            if (action != 3) {
                return;
            }
        }
        jad_anVar.jad_cp = new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis());
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void registerTouchView(@NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) == null) {
            jad_cpVar.jad_an.put(str, new com.jd.ad.sdk.jad_fs.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void unregisterTouchView(@NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) != null) {
            jad_cpVar.jad_an.remove(str);
        }
    }
}
