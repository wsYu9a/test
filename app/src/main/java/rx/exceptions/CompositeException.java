package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes4.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        static String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract Object a();

        public abstract void b(Object obj);

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static class c extends b {

        /* renamed from: a */
        public final PrintStream f30451a;

        public c(PrintStream printStream) {
            super();
            this.f30451a = printStream;
        }

        @Override // rx.exceptions.CompositeException.b
        public Object a() {
            return this.f30451a;
        }

        @Override // rx.exceptions.CompositeException.b
        public void b(Object obj) {
            this.f30451a.println(obj);
        }
    }

    public static class d extends b {

        /* renamed from: a */
        public final PrintWriter f30452a;

        public d(PrintWriter printWriter) {
            super();
            this.f30452a = printWriter;
        }

        @Override // rx.exceptions.CompositeException.b
        public Object a() {
            return this.f30452a;
        }

        @Override // rx.exceptions.CompositeException.b
        public void b(Object obj) {
            this.f30452a.println(obj);
        }
    }

    public CompositeException(String str, Collection<? extends Throwable> collection) {
        this.cause = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th2 : collection) {
                if (th2 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    private void appendStackTrace(StringBuilder sb2, Throwable th2, String str) {
        sb2.append(str);
        sb2.append(th2);
        sb2.append("\n");
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            sb2.append("\t\tat ");
            sb2.append(stackTraceElement);
            sb2.append("\n");
        }
        if (th2.getCause() != null) {
            sb2.append("\tCaused by: ");
            appendStackTrace(sb2, th2.getCause(), "");
        }
    }

    private final List<Throwable> getListOfCauses(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th2.getCause();
        if (cause == null) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            if (cause.getCause() == null) {
                return arrayList;
            }
            cause = cause.getCause();
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        try {
            if (this.cause == null) {
                CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
                HashSet hashSet = new HashSet();
                Iterator<Throwable> it = this.exceptions.iterator();
                Throwable th2 = compositeExceptionCausalChain;
                while (it.hasNext()) {
                    Throwable next = it.next();
                    if (!hashSet.contains(next)) {
                        hashSet.add(next);
                        for (Throwable th3 : getListOfCauses(next)) {
                            if (hashSet.contains(th3)) {
                                next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th3);
                            }
                        }
                        try {
                            th2.initCause(next);
                        } catch (Throwable unused) {
                        }
                        th2 = th2.getCause();
                    }
                }
                this.cause = compositeExceptionCausalChain;
            }
        } catch (Throwable th4) {
            throw th4;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new d(printWriter));
    }

    private void printStackTrace(b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this);
        sb2.append("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(stackTraceElement);
            sb2.append("\n");
        }
        int i10 = 1;
        for (Throwable th2 : this.exceptions) {
            sb2.append("  ComposedException ");
            sb2.append(i10);
            sb2.append(" :");
            sb2.append("\n");
            appendStackTrace(sb2, th2, "\t");
            i10++;
        }
        synchronized (bVar.a()) {
            bVar.b(sb2.toString());
        }
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this(null, collection);
    }
}
