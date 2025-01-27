package com.czhj.sdk.common.mta;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import b5.a;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import h3.e;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import p3.f;

/* loaded from: classes2.dex */
public abstract class PointEntitySuper {

    /* renamed from: p */
    public static final String f8503p = UUID.randomUUID().toString();

    /* renamed from: q */
    public static long f8504q = 1;

    /* renamed from: a */
    public String f8505a;

    /* renamed from: b */
    public String f8506b;

    /* renamed from: c */
    public String f8507c;

    /* renamed from: d */
    public String f8508d;

    /* renamed from: e */
    public String f8509e;

    /* renamed from: f */
    public String f8510f;

    /* renamed from: g */
    public String f8511g;

    /* renamed from: h */
    public Map<String, String> f8512h;

    /* renamed from: i */
    public String f8513i;

    /* renamed from: j */
    public String f8514j;

    /* renamed from: k */
    public String f8515k;

    /* renamed from: l */
    public String f8516l;

    /* renamed from: m */
    public int f8517m;
    protected Object mPointEntityClass;

    /* renamed from: n */
    public String f8518n;

    /* renamed from: o */
    public int f8519o;

    /* renamed from: com.czhj.sdk.common.mta.PointEntitySuper$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PointEntitySuper.this.insertToDB(null);
        }
    }

    /* renamed from: com.czhj.sdk.common.mta.PointEntitySuper$2 */
    public class AnonymousClass2 implements SQLiteMTAHelper.ExecCallBack {

        /* renamed from: a */
        public final /* synthetic */ SQLiteMTAHelper.ExecCallBack f8521a;

        public AnonymousClass2(SQLiteMTAHelper.ExecCallBack execCallBack) {
            execCallBack = execCallBack;
        }

        @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
        public void onFailed(Throwable th2) {
            SQLiteMTAHelper.ExecCallBack execCallBack = execCallBack;
            if (execCallBack != null) {
                execCallBack.onFailed(th2);
            }
            SigmobLog.e(th2.getMessage());
        }

        @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
        public void onSuccess() {
            SigmobLog.d("insert success!");
            SQLiteMTAHelper.ExecCallBack execCallBack = execCallBack;
            if (execCallBack != null) {
                execCallBack.onSuccess();
            }
        }
    }

    public static synchronized long a() {
        long j10;
        synchronized (PointEntitySuper.class) {
            j10 = f8504q;
            f8504q = 1 + j10;
        }
        return j10;
    }

    public static String captureName(String str) {
        char[] charArray = str.toCharArray();
        char c10 = charArray[0];
        if (c10 <= '`' || c10 >= '{') {
            return str;
        }
        charArray[0] = (char) (c10 - ' ');
        return String.valueOf(charArray);
    }

    public static String lowFirstChar(String str) {
        char[] charArray = str.toCharArray();
        char c10 = charArray[0];
        if (c10 <= '@' || c10 >= '[') {
            return str;
        }
        charArray[0] = (char) (c10 + a.O);
        return String.valueOf(charArray);
    }

    public static String toURLEncoded(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            SigmobLog.e(e10.getMessage());
            return "";
        }
    }

    public abstract String appId();

    public void commit() {
        this.mPointEntityClass = this;
        if (TextUtils.isEmpty(this.f8513i)) {
            setTimestamp(String.valueOf(System.currentTimeMillis()));
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.PointEntitySuper.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PointEntitySuper.this.insertToDB(null);
            }
        });
    }

    public String getAc_type() {
        return this.f8505a;
    }

    public String getAndroid_id() {
        return getDeviceContext() != null ? getDeviceContext().getAndroidId() : ClientMetadata.getInstance().getAndroidId();
    }

    public String getAppinfo_switch() {
        return this.f8507c;
    }

    public String getCarrier() {
        return getDeviceContext() != null ? getDeviceContext().getCarrier() : String.valueOf(ClientMetadata.getInstance().getNetworkOperatorForUrl());
    }

    public String getCategory() {
        return this.f8509e;
    }

    public String getClientversion() {
        return ClientMetadata.getDeviceOsVersion();
    }

    public int getCompatible() {
        return this.f8519o;
    }

    public abstract DeviceContext getDeviceContext();

    public String getExt() {
        return this.f8511g;
    }

    public String getGameversion() {
        return ClientMetadata.getInstance().getAppVersion();
    }

    public String getGoogle_aid() {
        return ClientMetadata.getInstance().getAdvertisingId();
    }

    public String getImei() {
        return getDeviceContext() != null ? getDeviceContext().getImei() : ClientMetadata.getInstance().getDeviceId();
    }

    public String getImei1() {
        return getDeviceContext() != null ? getDeviceContext().getImei1() : ClientMetadata.getInstance().getDeviceId(0);
    }

    public String getImei2() {
        return getDeviceContext() != null ? getDeviceContext().getImei2() : ClientMetadata.getInstance().getDeviceId(1);
    }

    public int getIntegration() {
        return this.f8517m;
    }

    public String getIs_mediation() {
        return this.f8506b;
    }

    public String getLocation_switch() {
        return this.f8508d;
    }

    public String getMd5() {
        return this.f8515k;
    }

    public String getName() {
        return this.f8516l;
    }

    public String getNetworktype() {
        return String.valueOf(ClientMetadata.getInstance().getActiveNetworkType());
    }

    public String getOaid() {
        return getDeviceContext() != null ? getDeviceContext().getOaid() : ClientMetadata.getInstance().getOAID();
    }

    public Map<String, String> getOptions() {
        if (this.f8512h == null) {
            this.f8512h = new HashMap();
        }
        return this.f8512h;
    }

    public String getOs() {
        return "2";
    }

    public abstract String getSdkversion();

    public String getSeconds_from_GMT() {
        return String.valueOf(((TimeZone.getDefault().getRawOffset() / 1000) / 60) / 60);
    }

    public String getSeq_id() {
        return String.valueOf(a());
    }

    public String getSha1() {
        return this.f8514j;
    }

    public String getSub_category() {
        return this.f8510f;
    }

    public String getTime_zone() {
        return TimeZone.getDefault().getID();
    }

    public String getTimestamp() {
        return TextUtils.isEmpty(this.f8513i) ? String.valueOf(System.currentTimeMillis()) : this.f8513i;
    }

    public String getUdid() {
        return ClientMetadata.getInstance().getUDID();
    }

    public String getUid() {
        ClientMetadata.getInstance();
        return ClientMetadata.getUid();
    }

    public String getUser_id() {
        return ClientMetadata.getUserId();
    }

    public String getVersion() {
        return this.f8518n;
    }

    public String getWmsession_id() {
        return f8503p;
    }

    public void insertToDB(SQLiteMTAHelper.ExecCallBack execCallBack) {
        try {
            if (!isAcTypeBlock() && !TextUtils.isEmpty(appId())) {
                Map<String, Object> map = toMap();
                if (getOptions() != null) {
                    map.remove("options");
                    map.putAll(getOptions());
                }
                map.put("_uniq_key", "sigandroid_" + appId());
                String jsonString = toJsonString(map);
                if (TextUtils.isEmpty(jsonString)) {
                    return;
                }
                SigmobLog.d("dcdebug:" + jsonString);
                SQLiteMTAHelper sQLiteMTAHelper = SQLiteMTAHelper.getInstance();
                if (sQLiteMTAHelper == null) {
                    return;
                }
                SQLiteDatabase writableDatabase = sQLiteMTAHelper.getWritableDatabase();
                SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
                builder.setTableName(SQLiteMTAHelper.TABLE_POINT);
                HashMap hashMap = new HashMap();
                hashMap.put("item", AESUtil.EncryptString(jsonString, Constants.AESKEY));
                hashMap.put("encryption", 1);
                builder.setColumnValues(hashMap);
                SQLiteMTAHelper.insert(writableDatabase, builder.build(), new SQLiteMTAHelper.ExecCallBack() { // from class: com.czhj.sdk.common.mta.PointEntitySuper.2

                    /* renamed from: a */
                    public final /* synthetic */ SQLiteMTAHelper.ExecCallBack f8521a;

                    public AnonymousClass2(SQLiteMTAHelper.ExecCallBack execCallBack2) {
                        execCallBack = execCallBack2;
                    }

                    @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
                    public void onFailed(Throwable th2) {
                        SQLiteMTAHelper.ExecCallBack execCallBack2 = execCallBack;
                        if (execCallBack2 != null) {
                            execCallBack2.onFailed(th2);
                        }
                        SigmobLog.e(th2.getMessage());
                    }

                    @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
                    public void onSuccess() {
                        SigmobLog.d("insert success!");
                        SQLiteMTAHelper.ExecCallBack execCallBack2 = execCallBack;
                        if (execCallBack2 != null) {
                            execCallBack2.onSuccess();
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public abstract boolean isAcTypeBlock();

    public void sendServe() {
        sendServe(null);
    }

    public void setAc_type(String str) {
        this.f8505a = str;
    }

    public void setAppinfo_switch(String str) {
        this.f8507c = str;
    }

    public void setCategory(String str) {
        this.f8509e = str;
    }

    public void setCompatible(int i10) {
        this.f8519o = i10;
    }

    public void setExt(String str) {
        this.f8511g = str;
    }

    public void setIntegration(int i10) {
        this.f8517m = i10;
    }

    public void setIs_mediation(String str) {
        this.f8506b = str;
    }

    public void setLocation_switch(String str) {
        this.f8508d = str;
    }

    public void setMd5(String str) {
        this.f8515k = str;
    }

    public void setName(String str) {
        this.f8516l = str;
    }

    public void setOptions(Map<String, String> map) {
        this.f8512h = map;
    }

    public void setSha1(String str) {
        this.f8514j = str;
    }

    public void setSub_category(String str) {
        this.f8510f = str;
    }

    public void setTimestamp(String str) {
        this.f8513i = str;
    }

    public void setVersion(String str) {
        this.f8518n = str;
    }

    public String testJsonString() {
        Map<String, Object> map = toMap();
        if (getOptions() != null) {
            map.remove("options");
            map.putAll(getOptions());
        }
        return toJsonString(map);
    }

    public String toJsonString(Map<String, Object> map) {
        if (map.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        boolean z10 = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                if (z10) {
                    sb2.append(",");
                }
                sb2.append("\"" + ((Object) entry.getKey()) + "\":");
                String uRLEncoded = entry.getValue() instanceof String ? !a(entry.getKey()) ? toURLEncoded((String) entry.getValue()) : (String) entry.getValue() : entry.getValue().toString();
                if (!uRLEncoded.startsWith("{")) {
                    uRLEncoded = "\"" + uRLEncoded + "\"";
                }
                sb2.append(uRLEncoded);
                z10 = true;
            }
        }
        sb2.append(f.f29748d);
        return sb2.toString();
    }

    public Map<String, Object> toMap() {
        List<Method> methodWithTraversal = ReflectionUtil.getMethodWithTraversal(this.mPointEntityClass.getClass());
        HashMap hashMap = new HashMap(methodWithTraversal.size());
        for (Method method : methodWithTraversal) {
            if (method.getName().startsWith(MonitorConstants.CONNECT_TYPE_GET) && !method.getName().equals("getLogs") && !method.getName().equals("getDeviceContext")) {
                try {
                    Object invoke = method.invoke(this.mPointEntityClass, null);
                    String lowFirstChar = lowFirstChar(method.getName().substring(3));
                    if (invoke != null && (!(invoke instanceof String) || !TextUtils.isEmpty((String) invoke))) {
                        if (lowFirstChar.equalsIgnoreCase(com.sigmob.sdk.downloader.core.breakpoint.f.f19049k)) {
                            lowFirstChar = "content-length";
                        } else if (lowFirstChar.equalsIgnoreCase("content_type")) {
                            lowFirstChar = e.f26401f;
                        } else if (lowFirstChar.equalsIgnoreCase("ac_type")) {
                            lowFirstChar = "_ac_type";
                        } else if (lowFirstChar.equalsIgnoreCase("user_id")) {
                            lowFirstChar = "_user_id";
                        } else if (!lowFirstChar.equalsIgnoreCase("class")) {
                        }
                        hashMap.put(lowFirstChar, invoke);
                    }
                } catch (Throwable th2) {
                    SigmobLog.e("name " + method.getName() + th2.getMessage());
                }
            }
        }
        return hashMap;
    }

    public final boolean a(String str) {
        return Arrays.asList("motion_before", "motion_after").contains(str);
    }

    public void sendServe(BuriedPointRequest.RequestListener requestListener) {
        this.mPointEntityClass = this;
        String jsonString = toJsonString(toMap());
        if (TextUtils.isEmpty(jsonString)) {
            return;
        }
        try {
            String str = "sigandroid_" + appId();
            BuriedPointRequest.BuriedPointSend(toURLEncoded(BuriedPointManager.deflateAndBase64("_uniq_key=" + str + "&_batch_value=" + ("[" + jsonString + "]"))), requestListener);
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
        }
    }
}
