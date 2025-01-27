package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class EqualExecutor extends ArithExecutor {
    private static final String TAG = "EqualExecutor_TMTEST";
    protected Set<Object> mMyObjs = new HashSet();
    protected int mPropertyNameId;

    private boolean loadVar() {
        Set<Object> findObject = findObject();
        if (findObject == null) {
            VVLog.e(TAG, "load var failed");
            return true;
        }
        this.mMyObjs.clear();
        this.mMyObjs.addAll(findObject);
        this.mPropertyNameId = this.mCodeReader.readInt();
        return true;
    }

    protected int eqDeal(Data data, Data data2) {
        data.copy(data2);
        if (this.mMyObjs.size() <= 0) {
            VVLog.e(TAG, "obj is empty");
            return 2;
        }
        Iterator<Object> it = this.mMyObjs.iterator();
        while (it.hasNext()) {
            this.mNativeObjectManager.setPropertyImp(it.next(), this.mPropertyNameId, data2);
        }
        return 1;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        Data readData;
        int execute = super.execute(obj);
        byte readByte = this.mCodeReader.readByte();
        if (readByte == 0) {
            loadVar();
            readData = readData(0);
            this.mAriResultRegIndex = this.mCodeReader.readByte();
        } else if (readByte == 1) {
            loadVar();
            readData = readData(1);
            this.mAriResultRegIndex = this.mCodeReader.readByte();
        } else if (readByte == 2) {
            loadVar();
            readData = readData(2);
            this.mAriResultRegIndex = this.mCodeReader.readByte();
        } else if (readByte == 3) {
            loadVar();
            readData = readData(3);
            this.mAriResultRegIndex = this.mCodeReader.readByte();
        } else if (readByte != 4) {
            readData = null;
        } else {
            loadVar();
            readData = readData(4);
        }
        if (readData == null) {
            return execute;
        }
        Data data = this.mRegisterManger.get(this.mAriResultRegIndex);
        if (data != null) {
            return eqDeal(data, readData);
        }
        VVLog.e(TAG, "result register is null");
        return execute;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.ArithExecutor, com.vivo.advv.vaf.expr.engine.executor.Executor
    public void init() {
        super.init();
    }
}
