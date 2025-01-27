package com.vivo.advv.vaf.expr.engine;

import com.vivo.advv.expr.common.StringSupport;
import com.vivo.advv.vaf.expr.engine.finder.ObjectFinderManager;

/* loaded from: classes4.dex */
public class EngineContext {
    private NativeObjectManager mNativeObjectManager;
    private StringSupport mStringSupport;
    private CodeReader mCodeReader = new CodeReader();
    private RegisterManager mRegisterManager = new RegisterManager();
    private DataManager mDataManager = new DataManager();
    private ObjectFinderManager mObjectFinderManager = new ObjectFinderManager();

    public void destroy() {
        this.mCodeReader = null;
        this.mRegisterManager.destroy();
        this.mRegisterManager = null;
        this.mDataManager = null;
        this.mNativeObjectManager = null;
        this.mStringSupport = null;
        this.mObjectFinderManager = null;
    }

    public CodeReader getCodeReader() {
        return this.mCodeReader;
    }

    public DataManager getDataManager() {
        return this.mDataManager;
    }

    public NativeObjectManager getNativeObjectManager() {
        return this.mNativeObjectManager;
    }

    public ObjectFinderManager getObjectFinderManager() {
        return this.mObjectFinderManager;
    }

    public RegisterManager getRegisterManager() {
        return this.mRegisterManager;
    }

    public StringSupport getStringSupport() {
        return this.mStringSupport;
    }

    public void setNativeObjectManager(NativeObjectManager nativeObjectManager) {
        this.mNativeObjectManager = nativeObjectManager;
    }

    public void setStringSupport(StringSupport stringSupport) {
        this.mStringSupport = stringSupport;
    }
}
