package com.czhj.sdk.common.track;

import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Database.DBOperator;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.Database.SQLiteLisenter;
import com.czhj.sdk.common.Database.SQLiteTrackHelper;
import com.czhj.sdk.logger.SigmobLog;
import com.martian.ads.ad.AdConfig;
import com.shu.priory.config.AdKeys;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import o3.a;

/* loaded from: classes2.dex */
public class AdTracker implements Serializable {
    private static final long serialVersionUID = 1;
    private String extInfo;
    private boolean mCalled;
    private final String mEvent;
    private Long mId;
    private final MessageType mMessageType;
    private final String mRequest_id;
    private String mSource = AdConfig.AdType.NATIVE;
    private String mUrl;
    private Integer retryCount;
    private Integer retryNum;
    private Long timestamp;

    /* renamed from: com.czhj.sdk.common.track.AdTracker$1 */
    public class AnonymousClass1 implements SQLiteLisenter {
        @Override // com.czhj.sdk.common.Database.SQLiteLisenter
        public void onFailed(Error error) {
            SigmobLog.e(error.getMessage());
        }

        @Override // com.czhj.sdk.common.Database.SQLiteLisenter
        public void onSuccess(List list) {
        }
    }

    /* renamed from: com.czhj.sdk.common.track.AdTracker$2 */
    public class AnonymousClass2 implements SQLiteLisenter {
        @Override // com.czhj.sdk.common.Database.SQLiteLisenter
        public void onFailed(Error error) {
            SigmobLog.e(error.getMessage());
        }

        @Override // com.czhj.sdk.common.Database.SQLiteLisenter
        public void onSuccess(List list) {
        }
    }

    /* renamed from: com.czhj.sdk.common.track.AdTracker$3 */
    public class AnonymousClass3 implements SQLiteTrackHelper.ExecCallBack {
        final /* synthetic */ SQLiteTrackHelper.ExecCallBack val$execCallBack;

        public AnonymousClass3(SQLiteTrackHelper.ExecCallBack execCallBack) {
            execCallBack = execCallBack;
        }

        @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
        public void onFailed(Throwable th2) {
            SQLiteTrackHelper.ExecCallBack execCallBack = execCallBack;
            if (execCallBack != null) {
                execCallBack.onFailed(th2);
            }
            SigmobLog.e(th2.getMessage());
        }

        @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
        public void onSuccess() {
            SigmobLog.d("event: " + AdTracker.this.mEvent + " url " + AdTracker.this.mUrl + " mRequest_id: " + AdTracker.this.mRequest_id + " insert success! ");
            SQLiteTrackHelper.ExecCallBack execCallBack = execCallBack;
            if (execCallBack != null) {
                execCallBack.onSuccess();
            }
        }
    }

    /* renamed from: com.czhj.sdk.common.track.AdTracker$4 */
    public class AnonymousClass4 implements SQLiteLisenter {
        public AnonymousClass4() {
        }

        @Override // com.czhj.sdk.common.Database.SQLiteLisenter
        public void onFailed(Error error) {
            SigmobLog.e(error.getMessage());
        }

        @Override // com.czhj.sdk.common.Database.SQLiteLisenter
        public void onSuccess(List list) {
            SigmobLog.d("delete id " + AdTracker.this.mId);
        }
    }

    /* renamed from: com.czhj.sdk.common.track.AdTracker$5 */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType = iArr;
            try {
                iArr[MessageType.QUARTILE_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[MessageType.TOBID_TRACKING_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[MessageType.TRACKING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum MessageType {
        TRACKING_URL,
        QUARTILE_EVENT,
        TOBID_TRACKING_URL
    }

    public AdTracker(MessageType messageType, String str, String str2, String str3) {
        this.mRequest_id = str3;
        this.mMessageType = messageType;
        this.mUrl = str;
        this.mEvent = str2;
    }

    public static void cleanExpiredAdTracker(long j10) {
        try {
            DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), "tracks", "timestamp < " + (System.currentTimeMillis() - j10), new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.1
                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onFailed(Error error) {
                    SigmobLog.e(error.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onSuccess(List list) {
                }
            });
        } catch (Throwable th2) {
            SigmobLog.e("cleanExpiredAdTracker error", th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cleanLimitAdTracker(long r6) {
        /*
            r0 = 0
            com.czhj.sdk.common.Database.SQLiteTrackHelper r1 = com.czhj.sdk.common.Database.SQLiteTrackHelper.getInstance()     // Catch: java.lang.Throwable -> L8a
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = "select * from tracks"
            android.database.Cursor r2 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L8a
            if (r2 == 0) goto L1f
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> L1b
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L1b
            r2.close()     // Catch: java.lang.Throwable -> L1b
            r2 = r0
            goto L21
        L1b:
            r6 = move-exception
            r0 = r2
            goto L8b
        L1f:
            r3 = 0
        L21:
            int r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r5 <= 0) goto L58
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "select * from tracks order by id desc limit "
            r3.append(r4)     // Catch: java.lang.Throwable -> L1b
            r3.append(r6)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L1b
            android.database.Cursor r6 = r1.rawQuery(r6, r0)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r7 = "id"
            int r7 = r6.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L54
            boolean r1 = r6.moveToLast()     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L59
            long r1 = r6.getLong(r7)     // Catch: java.lang.Throwable -> L54
            java.lang.Long r7 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L54
            r6.close()     // Catch: java.lang.Throwable -> L54
            r6 = r0
            r0 = r7
            goto L59
        L54:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L8b
        L58:
            r6 = r2
        L59:
            if (r0 == 0) goto L87
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r7.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = "id <'"
            r7.append(r1)     // Catch: java.lang.Throwable -> L54
            r7.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = "'"
            r7.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L54
            com.czhj.sdk.common.Database.DBOperator r0 = com.czhj.sdk.common.Database.DBOperator.getInstance()     // Catch: java.lang.Throwable -> L54
            com.czhj.sdk.common.Database.SQLiteTrackHelper r1 = com.czhj.sdk.common.Database.SQLiteTrackHelper.getInstance()     // Catch: java.lang.Throwable -> L54
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L54
            java.lang.String r2 = "tracks"
            com.czhj.sdk.common.track.AdTracker$2 r3 = new com.czhj.sdk.common.track.AdTracker$2     // Catch: java.lang.Throwable -> L54
            r3.<init>()     // Catch: java.lang.Throwable -> L54
            r0.delete(r1, r2, r7, r3)     // Catch: java.lang.Throwable -> L54
        L87:
            if (r6 == 0) goto L96
            goto L93
        L8a:
            r6 = move-exception
        L8b:
            java.lang.String r7 = "cleanLimitAdTracker "
            com.czhj.sdk.logger.SigmobLog.e(r7, r6)     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L96
            r6 = r0
        L93:
            r6.close()
        L96:
            return
        L97:
            r6 = move-exception
            if (r0 == 0) goto L9d
            r0.close()
        L9d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.track.AdTracker.cleanLimitAdTracker(long):void");
    }

    public static SQLiteBuider.CreateTable createTable() {
        SQLiteBuider.CreateTable.Builder builder = new SQLiteBuider.CreateTable.Builder();
        builder.setTableName("tracks");
        builder.setPrimaryKey("id", "long");
        builder.autoincrement(true);
        HashMap hashMap = new HashMap();
        hashMap.put("url", "text");
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "text");
        hashMap.put(AdKeys.REQUEST_ID, "text");
        hashMap.put(a.f29032k, "long");
        hashMap.put("source", "text");
        hashMap.put("retryNum", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        hashMap.put(n3.a.f28759y, "text");
        hashMap.put("messageType", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        builder.setColumns(hashMap);
        return builder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x0135, code lost:
    
        if (r3 != null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0142, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135 A[EDGE_INSN: B:56:0x0135->B:89:0x0135 BREAK  A[LOOP:0: B:9:0x0073->B:42:0x00f6], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.czhj.sdk.common.track.AdTracker> getAdTrackerFromDB(int r24, long r25) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.track.AdTracker.getAdTrackerFromDB(int, long):java.util.List");
    }

    private void setId(Long l10) {
        this.mId = l10;
    }

    private void setRetryCount(int i10) {
        this.retryCount = Integer.valueOf(i10);
    }

    public void deleteDB() {
        if (this.mId == null) {
            return;
        }
        try {
            DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), "tracks", "id ='" + this.mId + "'", new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.4
                public AnonymousClass4() {
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onFailed(Error error) {
                    SigmobLog.e(error.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onSuccess(List list) {
                    SigmobLog.d("delete id " + AdTracker.this.mId);
                }
            });
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public Long getId() {
        return this.mId;
    }

    public MessageType getMessageType() {
        return this.mMessageType;
    }

    public String getRequest_id() {
        return this.mRequest_id;
    }

    public int getRetryCount() {
        return this.retryCount.intValue();
    }

    public Integer getRetryNum() {
        Integer num = this.retryNum;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public String getSource() {
        return this.mSource;
    }

    public long getTimestamp() {
        Long l10 = this.timestamp;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void insertToDB(SQLiteTrackHelper.ExecCallBack execCallBack) {
        try {
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName("tracks");
            HashMap hashMap = new HashMap();
            int i10 = AnonymousClass5.$SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[this.mMessageType.ordinal()];
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    i11 = 0;
                }
            }
            hashMap.put("url", this.mUrl);
            hashMap.put(AdKeys.REQUEST_ID, this.mRequest_id);
            hashMap.put(NotificationCompat.CATEGORY_EVENT, this.mEvent);
            hashMap.put("source", this.mSource);
            hashMap.put("retryNum", this.retryCount);
            hashMap.put(a.f29032k, Long.valueOf(System.currentTimeMillis()));
            hashMap.put(n3.a.f28759y, this.extInfo);
            hashMap.put("messageType", Integer.valueOf(i11));
            builder.setColumnValues(hashMap);
            SQLiteTrackHelper.getInstance();
            SQLiteTrackHelper.insert(SQLiteTrackHelper.getInstance().getWritableDatabase(), builder.build(), new SQLiteTrackHelper.ExecCallBack() { // from class: com.czhj.sdk.common.track.AdTracker.3
                final /* synthetic */ SQLiteTrackHelper.ExecCallBack val$execCallBack;

                public AnonymousClass3(SQLiteTrackHelper.ExecCallBack execCallBack2) {
                    execCallBack = execCallBack2;
                }

                @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
                public void onFailed(Throwable th2) {
                    SQLiteTrackHelper.ExecCallBack execCallBack2 = execCallBack;
                    if (execCallBack2 != null) {
                        execCallBack2.onFailed(th2);
                    }
                    SigmobLog.e(th2.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
                public void onSuccess() {
                    SigmobLog.d("event: " + AdTracker.this.mEvent + " url " + AdTracker.this.mUrl + " mRequest_id: " + AdTracker.this.mRequest_id + " insert success! ");
                    SQLiteTrackHelper.ExecCallBack execCallBack2 = execCallBack;
                    if (execCallBack2 != null) {
                        execCallBack2.onSuccess();
                    }
                }
            });
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public boolean isTracked() {
        return this.mCalled;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setRetryCountInc() {
        this.retryCount = Integer.valueOf(this.retryCount.intValue() + 1);
    }

    public void setRetryNum(Integer num) {
        this.retryNum = num;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setTimestamp(Long l10) {
        this.timestamp = l10;
    }

    public void setTracked() {
        this.mCalled = true;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void updateToDB() {
        try {
            SQLiteBuider.Update.Builder builder = new SQLiteBuider.Update.Builder();
            builder.setTableName("tracks");
            builder.setWhere(" where id=" + this.mId.toString());
            HashMap hashMap = new HashMap();
            hashMap.put("retryNum", this.retryCount);
            builder.setColumnValues(hashMap);
            SQLiteTrackHelper.getInstance().transactionWriteExecSQL(SQLiteTrackHelper.getInstance().getWritableDatabase(), builder.build().getSql(), null);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }
}
