package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.util.VVLog;

/* loaded from: classes4.dex */
public abstract class BinExecutor extends ArithExecutor {
    private static final String TAG = "BinExecutor_TMTEST";

    protected int calc(Data data, Data data2) {
        Data data3 = this.mRegisterManger.get(this.mAriResultRegIndex);
        if (data3 == null) {
            return 2;
        }
        int i2 = data.mType;
        int i3 = 1;
        if (i2 == 1) {
            int i4 = data2.mType;
            if (i4 == 1) {
                i3 = calcIntInt(data3, data.getInt(), data2.getInt());
            } else if (i4 == 2) {
                i3 = calcIntFloat(data3, data.getInt(), data2.getFloat());
            } else if (i4 != 3) {
                VVLog.e(TAG, "value2 invalidate type:" + data2);
            } else {
                i3 = calcIntString(data3, data.getInt(), data2.getString());
            }
        } else if (i2 == 2) {
            int i5 = data2.mType;
            if (i5 == 1) {
                i3 = calcFloatInt(data3, data.getFloat(), data2.getInt());
            } else if (i5 == 2) {
                i3 = calcFloatFloat(data3, data.getFloat(), data2.getFloat());
            } else if (i5 != 3) {
                VVLog.e(TAG, "value2 invalidate type:" + data2);
            } else {
                i3 = calcFloatString(data3, data.getFloat(), data2.getString());
            }
        } else if (i2 != 3) {
            VVLog.e(TAG, "value1 invalidate type:" + data);
        } else {
            int i6 = data2.mType;
            if (i6 == 1) {
                i3 = calcStringInt(data3, data.getString(), data2.getInt());
            } else if (i6 == 2) {
                i3 = calcStringFloat(data3, data.getString(), data2.getFloat());
            } else if (i6 != 3) {
                VVLog.e(TAG, "value2 invalidate type:" + data2);
            } else {
                i3 = calcStringString(data3, data.getString(), data2.getString());
            }
        }
        if (2 == i3) {
            VVLog.e(TAG, "type invalidate data1:" + data + "  data2:" + data2);
        }
        return i3;
    }

    protected int calcFloatFloat(Data data, float f2, float f3) {
        return 2;
    }

    protected int calcFloatInt(Data data, float f2, int i2) {
        return 2;
    }

    protected int calcFloatString(Data data, float f2, String str) {
        return 2;
    }

    protected int calcIntFloat(Data data, int i2, float f2) {
        return 2;
    }

    protected int calcIntInt(Data data, int i2, int i3) {
        return 2;
    }

    protected int calcIntString(Data data, int i2, String str) {
        return 2;
    }

    protected int calcStringFloat(Data data, String str, float f2) {
        return 2;
    }

    protected int calcStringInt(Data data, String str, int i2) {
        return 2;
    }

    protected int calcStringString(Data data, String str, String str2) {
        return 2;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public int execute(Object obj) {
        Data readData;
        int execute = super.execute(obj);
        Data data = null;
        switch (this.mCodeReader.readByte()) {
            case 0:
                data = readData(0);
                readData = readData(0);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 1:
                data = readData(0);
                readData = readData(1);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 2:
                data = readData(0);
                readData = readData(2);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 3:
                data = readData(0);
                readData = readData(3);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 4:
                data = readData(0);
                readData = readData(4);
                break;
            case 5:
                data = readData(1);
                readData = readData(0);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 6:
                data = readData(1);
                readData = readData(4);
                break;
            case 7:
                data = readData(2);
                readData = readData(0);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 8:
                data = readData(2);
                readData = readData(4);
                break;
            case 9:
                data = readData(3);
                readData = readData(0);
                this.mAriResultRegIndex = this.mCodeReader.readByte();
                break;
            case 10:
                data = readData(3);
                readData = readData(4);
                break;
            case 11:
                data = readData(4);
                readData = readData(0);
                break;
            case 12:
                data = readData(4);
                readData = readData(1);
                break;
            case 13:
                data = readData(4);
                readData = readData(2);
                break;
            case 14:
                data = readData(4);
                readData = readData(3);
                break;
            case 15:
                data = readData(4);
                readData = readData(4);
                break;
            default:
                readData = null;
                break;
        }
        if (data != null && readData != null) {
            return calc(data, readData);
        }
        VVLog.e(TAG, "read data failed");
        return execute;
    }
}
