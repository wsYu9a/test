package com.vivo.advv.vaf.expr.engine.executor;

import com.vivo.advv.expr.common.StringSupport;
import com.vivo.advv.vaf.expr.engine.CodeReader;
import com.vivo.advv.vaf.expr.engine.DataManager;
import com.vivo.advv.vaf.expr.engine.EngineContext;
import com.vivo.advv.vaf.expr.engine.NativeObjectManager;
import com.vivo.advv.vaf.expr.engine.RegisterManager;

/* loaded from: classes4.dex */
public abstract class Executor {
    public static final int RESULT_STATE_ERROR = 2;
    public static final int RESULT_STATE_SUCCESSFUL = 1;
    private static final String TAG = "Executor_TMTEST";
    protected CodeReader mCodeReader;
    protected Object mCom;
    protected DataManager mDataManager;
    protected EngineContext mEngineContext;
    protected NativeObjectManager mNativeObjectManager;
    protected RegisterManager mRegisterManger;
    protected StringSupport mStringSupport;

    public void destroy() {
        this.mCom = null;
    }

    public int execute(Object obj) {
        this.mCom = obj;
        return 2;
    }

    public void init() {
    }

    public void setEngineContext(EngineContext engineContext) {
        this.mEngineContext = engineContext;
        this.mStringSupport = engineContext.getStringSupport();
        this.mNativeObjectManager = this.mEngineContext.getNativeObjectManager();
        this.mCodeReader = this.mEngineContext.getCodeReader();
        this.mRegisterManger = this.mEngineContext.getRegisterManager();
        this.mDataManager = this.mEngineContext.getDataManager();
    }
}
