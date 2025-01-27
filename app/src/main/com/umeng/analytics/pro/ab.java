package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ab implements aj {

    /* renamed from: a */
    private String f23386a;

    /* renamed from: b */
    private ArrayList<ac> f23387b;

    /* renamed from: c */
    private String f23388c;

    /* renamed from: d */
    private String f23389d;

    /* renamed from: e */
    private String f23390e;

    /* renamed from: f */
    private String f23391f;

    public ab(String str, ArrayList<ac> arrayList) {
        this.f23386a = null;
        new ArrayList();
        this.f23388c = "";
        this.f23389d = "";
        this.f23390e = "";
        this.f23391f = "";
        this.f23386a = str;
        this.f23387b = arrayList;
    }

    public String a() {
        return this.f23386a;
    }

    @Override // com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
    }

    public String c() {
        return this.f23389d;
    }

    private String c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length <= 0) {
            return "";
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f23386a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f23391f = forbidSdkArray.toString();
            for (String str3 : split) {
                if (CcgAgent.getActionInfo(str3) != null && !forbidSdkArray.contains(str3)) {
                    return str3;
                }
            }
            return "";
        }
        for (String str4 : split) {
            ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= supportAction.length) {
                            break;
                        }
                        if (this.f23386a.equals(supportAction[i10])) {
                            str2 = str4;
                            break;
                        }
                        i10++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                } else {
                    continue;
                }
            }
        }
        return str2;
    }

    public void a(String str) {
        this.f23388c = str;
    }

    public String b() {
        return this.f23388c;
    }

    @Override // com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f23387b.size();
            if (size == 0) {
                return null;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f23387b.get(i10).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f23389d)) {
                String c10 = c(this.f23389d);
                this.f23390e = c10;
                if (TextUtils.isEmpty(c10)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f23386a + "; 未选中可用Module ; sdk: " + this.f23389d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f23386a + "; 选中Module: " + this.f23390e + "; sdk: " + this.f23389d);
                }
            }
            ac acVar = this.f23387b.get(size - 1);
            if (acVar == null || !(acVar instanceof af)) {
                return null;
            }
            long c11 = acVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f23386a);
                jSONObject2.put("sdk", this.f23389d);
                jSONObject2.put(com.umeng.ccg.a.f24241r, this.f23388c);
                jSONObject2.put("delay", c11);
                jSONObject2.put(com.umeng.ccg.a.f24242s, this.f23390e);
                jSONObject2.put(com.umeng.ccg.a.f24243t, this.f23391f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void b(String str) {
        this.f23389d = str;
    }
}
