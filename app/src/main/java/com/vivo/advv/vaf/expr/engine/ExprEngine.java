package com.vivo.advv.vaf.expr.engine;

import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.expr.common.StringSupport;
import com.vivo.advv.vaf.expr.engine.executor.AddEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.AddExecutor;
import com.vivo.advv.vaf.expr.engine.executor.AndExecutor;
import com.vivo.advv.vaf.expr.engine.executor.ArrayExecutor;
import com.vivo.advv.vaf.expr.engine.executor.DivEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.DivExecutor;
import com.vivo.advv.vaf.expr.engine.executor.EqEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.EqualExecutor;
import com.vivo.advv.vaf.expr.engine.executor.Executor;
import com.vivo.advv.vaf.expr.engine.executor.FunExecutor;
import com.vivo.advv.vaf.expr.engine.executor.GEExecutor;
import com.vivo.advv.vaf.expr.engine.executor.GTExecutor;
import com.vivo.advv.vaf.expr.engine.executor.JmpExecutor;
import com.vivo.advv.vaf.expr.engine.executor.JmpcExecutor;
import com.vivo.advv.vaf.expr.engine.executor.LEExecutor;
import com.vivo.advv.vaf.expr.engine.executor.LTExecutor;
import com.vivo.advv.vaf.expr.engine.executor.MinusExecutor;
import com.vivo.advv.vaf.expr.engine.executor.ModEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.ModExecutor;
import com.vivo.advv.vaf.expr.engine.executor.MulEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.MulExecutor;
import com.vivo.advv.vaf.expr.engine.executor.NotEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.NotExecutor;
import com.vivo.advv.vaf.expr.engine.executor.OrExecutor;
import com.vivo.advv.vaf.expr.engine.executor.SubEqExecutor;
import com.vivo.advv.vaf.expr.engine.executor.SubExecutor;
import com.vivo.advv.vaf.expr.engine.executor.TerExecutor;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ExprEngine {
    private static final String TAG = "ExprEngine_TMTEST";
    private int mInstructionCount;
    private List<Executor> mExecutors = new ArrayList();
    private EngineContext mEngineContext = new EngineContext();

    public ExprEngine() {
        this.mExecutors.add(new AddExecutor());
        this.mExecutors.add(new SubExecutor());
        this.mExecutors.add(new MulExecutor());
        this.mExecutors.add(new DivExecutor());
        this.mExecutors.add(new ModExecutor());
        this.mExecutors.add(new EqualExecutor());
        this.mExecutors.add(new TerExecutor());
        this.mExecutors.add(new MinusExecutor());
        this.mExecutors.add(new NotExecutor());
        this.mExecutors.add(new GTExecutor());
        this.mExecutors.add(new LTExecutor());
        this.mExecutors.add(new NotEqExecutor());
        this.mExecutors.add(new EqEqExecutor());
        this.mExecutors.add(new GEExecutor());
        this.mExecutors.add(new LEExecutor());
        this.mExecutors.add(new FunExecutor());
        this.mExecutors.add(new AddEqExecutor());
        this.mExecutors.add(new SubEqExecutor());
        this.mExecutors.add(new MulEqExecutor());
        this.mExecutors.add(new DivEqExecutor());
        this.mExecutors.add(new ModEqExecutor());
        this.mExecutors.add(new JmpExecutor());
        this.mExecutors.add(new JmpcExecutor());
        this.mExecutors.add(new AndExecutor());
        this.mExecutors.add(new OrExecutor());
        this.mExecutors.add(new ArrayExecutor());
        this.mInstructionCount = this.mExecutors.size();
    }

    public void destroy() {
        Iterator<Executor> it = this.mExecutors.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mExecutors.clear();
        this.mEngineContext.destroy();
    }

    public boolean execute(Object obj, ExprCode exprCode) {
        CodeReader codeReader = this.mEngineContext.getCodeReader();
        if (exprCode != null) {
            codeReader.setCode(exprCode);
            int i2 = 2;
            do {
                byte readByte = codeReader.readByte();
                if (readByte > -1 && readByte < this.mInstructionCount) {
                    Executor executor = this.mExecutors.get(readByte);
                    executor.init();
                    i2 = executor.execute(obj);
                    if (1 != i2) {
                        break;
                    }
                } else {
                    VVLog.e(TAG, "operator code error:" + ((int) readByte));
                    break;
                }
            } while (!codeReader.isEndOfCode());
            if (1 == i2) {
                return true;
            }
        }
        return false;
    }

    public EngineContext getEngineContext() {
        return this.mEngineContext;
    }

    public void initFinished() {
        Iterator<Executor> it = this.mExecutors.iterator();
        while (it.hasNext()) {
            it.next().setEngineContext(this.mEngineContext);
        }
    }

    public void setNativeObjectManager(NativeObjectManager nativeObjectManager) {
        this.mEngineContext.setNativeObjectManager(nativeObjectManager);
    }

    public void setStringSupport(StringSupport stringSupport) {
        this.mEngineContext.setStringSupport(stringSupport);
    }
}
