package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.virtualview.common.StringBase;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class ArithExecutor extends Executor {
    private static final String TAG = "ArithExecutor_TMTEST";
    public static final byte TYPE_Float = 2;
    public static final byte TYPE_Int = 1;
    public static final byte TYPE_None = -1;
    public static final byte TYPE_Register = 4;
    public static final byte TYPE_String = 3;
    public static final byte TYPE_Var = 0;
    protected int mAriResultRegIndex;
    protected int mItemCount;
    protected Set<Object> mTempObjs;

    private void ensureTempObjs() {
        if (this.mTempObjs == null) {
            this.mTempObjs = new HashSet(10);
        }
    }

    private boolean readRegister(Data data) {
        int readInt = this.mCodeReader.readInt();
        if (readInt < this.mAriResultRegIndex) {
            this.mAriResultRegIndex = readInt;
        }
        Data data2 = this.mRegisterManger.get(readInt);
        if (data2 == null) {
            return false;
        }
        data.copy(data2);
        return true;
    }

    private void swapObjArr(Set<Object> set) {
        ensureTempObjs();
        this.mTempObjs = set;
    }

    protected Set<Object> findObject() {
        ViewBase parent;
        ensureTempObjs();
        HashSet hashSet = new HashSet(10);
        this.mTempObjs.clear();
        int readInt = this.mCodeReader.readInt();
        if (readInt > -1) {
            Data data = this.mRegisterManger.get(readInt);
            if (data == null) {
                VVLog.e(TAG, "read obj from register failed  registerId:" + readInt);
            } else if (4 == data.mType) {
                hashSet.add(data.getObject());
            } else {
                VVLog.e(TAG, "read obj from register failed obj:" + data);
            }
        }
        byte readByte = this.mCodeReader.readByte();
        this.mItemCount = readByte;
        boolean z = true;
        boolean z2 = false;
        if (readByte >= 1) {
            if (hashSet.size() <= 0) {
                int readInt2 = this.mCodeReader.readInt();
                if (-1068784020 == readInt2) {
                    if (3 == readByte) {
                        String string = this.mStringSupport.getString(this.mCodeReader.readInt());
                        Object module = this.mNativeObjectManager.getModule(string);
                        if (module != null) {
                            hashSet.add(module);
                        } else {
                            VVLog.e(TAG, "findObject can not find module:" + string);
                        }
                    } else {
                        VVLog.e(TAG, "findObject count invalidate:" + ((int) readByte));
                    }
                    return hashSet;
                }
                if (3076010 == readInt2) {
                    hashSet.add(this.mDataManager);
                    return hashSet;
                }
                if (3559070 == readInt2) {
                    hashSet.add(this.mCom);
                } else if (this.mStringSupport.isSysString(readInt2)) {
                    VVLog.e(TAG, "findObject first token invalidate id:" + readInt2);
                } else {
                    ViewBase findCom = readInt > -1 ? null : this.mNativeObjectManager.findCom(readInt2);
                    if (findCom == null) {
                        VVLog.e(TAG, "findObject can not find com id:" + readInt2);
                    } else {
                        hashSet.add(findCom);
                    }
                }
            }
            if (hashSet.size() > 0) {
                for (int i2 = 0; i2 < readByte - 2; i2++) {
                    int readInt3 = this.mCodeReader.readInt();
                    if (this.mStringSupport.isSysString(readInt3)) {
                        switch (readInt3) {
                            case StringBase.STR_ID_parent /* -995424086 */:
                                this.mTempObjs.clear();
                                for (Object obj : hashSet) {
                                    if (obj instanceof ViewBase) {
                                        ViewBase parent2 = ((ViewBase) obj).getParent();
                                        if (parent2 != null) {
                                            this.mTempObjs.add(parent2);
                                        }
                                    } else {
                                        VVLog.w(TAG, "warning");
                                    }
                                }
                                hashSet.clear();
                                hashSet.addAll(this.mTempObjs);
                                break;
                            case StringBase.STR_ID_ancestor /* -973829677 */:
                                this.mTempObjs.clear();
                                for (Object obj2 : hashSet) {
                                    if (obj2 instanceof ViewBase) {
                                        for (ViewBase parent3 = ((ViewBase) obj2).getParent(); parent3 != null; parent3 = parent3.getParent()) {
                                            this.mTempObjs.add(parent3);
                                        }
                                    }
                                }
                                hashSet.clear();
                                hashSet.addAll(this.mTempObjs);
                                break;
                            case StringBase.STR_ID_this /* 3559070 */:
                            case StringBase.STR_ID_children /* 1659526655 */:
                                break;
                            case StringBase.STR_ID_siblings /* 166965745 */:
                                this.mTempObjs.clear();
                                for (Object obj3 : hashSet) {
                                    if ((obj3 instanceof ViewBase) && (parent = ((ViewBase) obj3).getParent()) != null && (parent instanceof Layout)) {
                                        this.mTempObjs.addAll(((Layout) parent).getSubViews());
                                        this.mTempObjs.remove(obj3);
                                    }
                                }
                                hashSet.clear();
                                hashSet.addAll(this.mTempObjs);
                                break;
                            default:
                                VVLog.e(TAG, "findObject invalidate system id:" + readInt3);
                                z = false;
                                break;
                        }
                    } else {
                        this.mTempObjs.clear();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            ViewBase findViewBaseByName = ((ViewBase) it.next()).findViewBaseByName(this.mStringSupport.getString(readInt3));
                            if (findViewBaseByName != null) {
                                this.mTempObjs.add(findViewBaseByName);
                            } else {
                                VVLog.e(TAG, "can not find obj:" + this.mStringSupport.getString(readInt3));
                            }
                        }
                        hashSet.clear();
                        hashSet.addAll(this.mTempObjs);
                    }
                    if (!z) {
                        z2 = z;
                    }
                }
                z2 = z;
            }
        } else {
            VVLog.e(TAG, "findObject count invalidate:" + ((int) readByte));
        }
        if (z2) {
            return hashSet;
        }
        return null;
    }

    @Override // com.vivo.advv.vaf.expr.engine.executor.Executor
    public void init() {
        super.init();
        this.mAriResultRegIndex = 256;
    }

    protected Data readData(int i2) {
        Data data = new Data();
        if (i2 != 0) {
            if (i2 == 1) {
                data.setInt(this.mCodeReader.readInt());
                return data;
            }
            if (i2 == 2) {
                data.setFloat(Float.intBitsToFloat(this.mCodeReader.readInt()));
                return data;
            }
            if (i2 == 3) {
                data.setString(this.mStringSupport.getString(this.mCodeReader.readInt()));
                return data;
            }
            if (i2 != 4) {
                VVLog.e(TAG, "can not read this type:" + i2);
            } else if (readRegister(data)) {
                return data;
            }
        } else if (readVar(data)) {
            return data;
        }
        return null;
    }

    protected boolean readVar(Data data) {
        Set<Object> findObject = findObject();
        if (findObject == null) {
            return false;
        }
        int readInt = this.mCodeReader.readInt();
        Iterator<Object> it = findObject.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next == this.mDataManager) {
                try {
                    next = next.getClass().getMethod("getData", String.class).invoke(next, this.mStringSupport.getString(readInt));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    VVLog.e(TAG, "getData IllegalAccessException:");
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                    VVLog.e(TAG, "getData NoSuchMethodException:");
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    VVLog.e(TAG, "getData InvocationTargetException:");
                }
            } else {
                next = this.mNativeObjectManager.getPropertyImp(next, readInt);
            }
            if (next == null) {
                VVLog.e(TAG, "getProperty failed");
            } else if (next instanceof Integer) {
                data.setInt(((Integer) next).intValue());
            } else if (next instanceof Float) {
                data.setFloat(((Float) next).floatValue());
            } else if (next instanceof String) {
                data.setString((String) next);
            } else {
                data.setObject(next);
            }
        }
        return true;
    }
}
