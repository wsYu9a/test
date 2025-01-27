package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import p3.f;

/* loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    public class CLObjectIterator implements Iterator {
        int index = 0;
        CLObject myObject;

        public CLObjectIterator(CLObject cLObject) {
            this.myObject = cLObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.myObject.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey cLKey = (CLKey) this.myObject.mElements.get(this.index);
            this.index++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb2 = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(next.toJSON());
        }
        sb2.append(" }");
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(getDebugName());
        sb2.append("{\n");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z10) {
                z10 = false;
            } else {
                sb2.append(",\n");
            }
            sb2.append(next.toFormattedJSON(CLElement.BASE_INDENT + i10, i11 - 1));
        }
        sb2.append("\n");
        addIndent(sb2, i10);
        sb2.append(f.f29748d);
        return sb2.toString();
    }
}
