package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.expr.engine.data.Value;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.Set;

/* loaded from: classes4.dex */
public class ArrayExecutor extends ArithExecutor {
    private static final String TAG = "ArrayExecutor_TMTEST";

    /* JADX WARN: Removed duplicated region for block: B:25:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean call(int r7, int r8, com.vivo.advv.vaf.expr.engine.data.Value r9, java.util.Set<java.lang.Object> r10) {
        /*
            r6 = this;
            com.vivo.advv.expr.common.StringSupport r0 = r6.mStringSupport
            java.lang.String r7 = r0.getString(r7)
            java.lang.Object r9 = r9.getValue()
            boolean r0 = r9 instanceof java.lang.Integer
            r1 = 0
            java.lang.String r2 = "ArrayExecutor_TMTEST"
            if (r0 == 0) goto La7
            r0 = 1
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.util.Iterator r10 = r10.iterator()
        L1c:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto La5
            java.lang.Object r3 = r10.next()
            r4 = 0
            boolean r5 = r3 instanceof com.vivo.advv.vaf.expr.engine.DataManager     // Catch: java.lang.Exception -> L99
            if (r5 == 0) goto L42
            com.vivo.advv.vaf.expr.engine.DataManager r3 = r6.mDataManager     // Catch: java.lang.Exception -> L99
            java.lang.Object r3 = r3.getData(r7)     // Catch: java.lang.Exception -> L99
            boolean r3 = r3 instanceof org.json.JSONArray     // Catch: java.lang.Exception -> L99
            if (r3 == 0) goto L5d
            com.vivo.advv.vaf.expr.engine.DataManager r3 = r6.mDataManager     // Catch: java.lang.Exception -> L99
            java.lang.Object r3 = r3.getData(r7)     // Catch: java.lang.Exception -> L99
            org.json.JSONArray r3 = (org.json.JSONArray) r3     // Catch: java.lang.Exception -> L99
            java.lang.Object r3 = r3.get(r9)     // Catch: java.lang.Exception -> L99
            goto L50
        L42:
            boolean r4 = r3 instanceof org.json.JSONObject     // Catch: java.lang.Exception -> L99
            if (r4 == 0) goto L52
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch: java.lang.Exception -> L99
            org.json.JSONArray r3 = r3.optJSONArray(r7)     // Catch: java.lang.Exception -> L99
            java.lang.Object r3 = r3.get(r9)     // Catch: java.lang.Exception -> L99
        L50:
            r4 = r3
            goto L5d
        L52:
            boolean r4 = r3 instanceof org.json.JSONArray     // Catch: java.lang.Exception -> L99
            if (r4 == 0) goto L84
            org.json.JSONArray r3 = (org.json.JSONArray) r3     // Catch: java.lang.Exception -> L99
            java.lang.Object r3 = r3.get(r9)     // Catch: java.lang.Exception -> L99
            goto L50
        L5d:
            com.vivo.advv.vaf.expr.engine.RegisterManager r3 = r6.mRegisterManger     // Catch: java.lang.Exception -> L99
            com.vivo.advv.vaf.expr.engine.data.Data r3 = r3.get(r8)     // Catch: java.lang.Exception -> L99
            if (r4 == 0) goto L80
            boolean r3 = r3.set(r4)     // Catch: java.lang.Exception -> L99
            if (r3 != 0) goto L1c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99
            r3.<init>()     // Catch: java.lang.Exception -> L99
            java.lang.String r5 = "call set return value failed:"
            r3.append(r5)     // Catch: java.lang.Exception -> L99
            r3.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L99
            com.vivo.advv.vaf.virtualview.util.VVLog.e(r2, r3)     // Catch: java.lang.Exception -> L99
            goto L1c
        L80:
            r3.reset()     // Catch: java.lang.Exception -> L99
            goto L1c
        L84:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99
            r0.<init>()     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = "error object:"
            r0.append(r4)     // Catch: java.lang.Exception -> L99
            r0.append(r3)     // Catch: java.lang.Exception -> L99
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L99
            com.vivo.advv.vaf.virtualview.util.VVLog.e(r2, r0)     // Catch: java.lang.Exception -> L99
            goto Lac
        L99:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = "set value failed"
            com.vivo.advv.vaf.virtualview.util.VVLog.e(r2, r0)
            r0 = 0
            goto L1c
        La5:
            r1 = r0
            goto Lac
        La7:
            java.lang.String r7 = "param not integer"
            com.vivo.advv.vaf.virtualview.util.VVLog.e(r2, r7)
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.expr.engine.executor.ArrayExecutor.call(int, int, com.vivo.advv.vaf.expr.engine.data.Value, java.util.Set):boolean");
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        int execute = super.execute(obj);
        Set<Object> findObject = findObject();
        if (findObject == null) {
            VVLog.e(TAG, "execute findObject failed");
            return execute;
        }
        int readInt = this.mItemCount > 0 ? this.mCodeReader.readInt() : -1;
        Value readParam = readParam();
        if (readParam == null) {
            VVLog.e(TAG, "param is null");
            return execute;
        }
        if (call(readInt, this.mCodeReader.readByte(), readParam, findObject)) {
            return 1;
        }
        VVLog.e(TAG, "call array failed");
        return execute;
    }

    protected Value readParam() {
        byte readByte = this.mCodeReader.readByte();
        Data readData = readData(readByte);
        if (readData != null) {
            return readData.mValue;
        }
        VVLog.e(TAG, "read param failed:" + ((int) readByte));
        return null;
    }
}
