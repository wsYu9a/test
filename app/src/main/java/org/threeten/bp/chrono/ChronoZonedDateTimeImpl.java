package org.threeten.bp.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import fj.d;
import ij.c;
import ij.f;
import ij.i;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes4.dex */
public final class ChronoZonedDateTimeImpl<D extends org.threeten.bp.chrono.a> extends d<D> implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29502a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29502a = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29502a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = (ChronoLocalDateTimeImpl) hj.d.j(chronoLocalDateTimeImpl, "dateTime");
        this.offset = (ZoneOffset) hj.d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        this.zone = (ZoneId) hj.d.j(zoneId, "zone");
    }

    private ChronoZonedDateTimeImpl<D> create(Instant instant, ZoneId zoneId) {
        return ofInstant(toLocalDate().getChronology(), instant, zoneId);
    }

    public static <R extends org.threeten.bp.chrono.a> d<R> ofBest(ChronoLocalDateTimeImpl<R> chronoLocalDateTimeImpl, ZoneId zoneId, ZoneOffset zoneOffset) {
        hj.d.j(chronoLocalDateTimeImpl, "localDateTime");
        hj.d.j(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        LocalDateTime from = LocalDateTime.from((ij.b) chronoLocalDateTimeImpl);
        List<ZoneOffset> validOffsets = rules.getValidOffsets(from);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(from);
            chronoLocalDateTimeImpl = chronoLocalDateTimeImpl.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = validOffsets.get(0);
        }
        hj.d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, zoneOffset, zoneId);
    }

    public static <R extends org.threeten.bp.chrono.a> ChronoZonedDateTimeImpl<R> ofInstant(b bVar, Instant instant, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        hj.d.j(offset, TypedValues.CycleType.S_WAVE_OFFSET);
        return new ChronoZonedDateTimeImpl<>((ChronoLocalDateTimeImpl) bVar.localDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset)), offset, zoneId);
    }

    public static d<?> readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        fj.b bVar = (fj.b) objectInput.readObject();
        ZoneOffset zoneOffset = (ZoneOffset) objectInput.readObject();
        return bVar.atZone(zoneOffset).withZoneSameLocal((ZoneId) objectInput.readObject());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    @Override // fj.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && compareTo((d<?>) obj) == 0;
    }

    @Override // fj.d
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // fj.d
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // fj.d
    public int hashCode() {
        return (toLocalDateTime().hashCode() ^ getOffset().hashCode()) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar.isDateBased() || iVar.isTimeBased() : iVar != null && iVar.isSupportedBy(this);
    }

    @Override // fj.d
    public fj.b<D> toLocalDateTime() {
        return this.dateTime;
    }

    @Override // fj.d
    public String toString() {
        String str = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() == getZone()) {
            return str;
        }
        return str + '[' + getZone().toString() + ']';
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        d<?> zonedDateTime = toLocalDate().getChronology().zonedDateTime(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, zonedDateTime);
        }
        return this.dateTime.until(zonedDateTime.withZoneSameInstant(this.offset).toLocalDateTime(), iVar);
    }

    @Override // fj.d
    public d<D> withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(LocalDateTime.from((ij.b) this));
        if (transition != null && transition.isOverlap()) {
            ZoneOffset offsetBefore = transition.getOffsetBefore();
            if (!offsetBefore.equals(this.offset)) {
                return new ChronoZonedDateTimeImpl(this.dateTime, offsetBefore, this.zone);
            }
        }
        return this;
    }

    @Override // fj.d
    public d<D> withLaterOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(LocalDateTime.from((ij.b) this));
        if (transition != null) {
            ZoneOffset offsetAfter = transition.getOffsetAfter();
            if (!offsetAfter.equals(getOffset())) {
                return new ChronoZonedDateTimeImpl(this.dateTime, offsetAfter, this.zone);
            }
        }
        return this;
    }

    @Override // fj.d
    public d<D> withZoneSameInstant(ZoneId zoneId) {
        hj.d.j(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : create(this.dateTime.toInstant(this.offset), zoneId);
    }

    @Override // fj.d
    public d<D> withZoneSameLocal(ZoneId zoneId) {
        return ofBest(this.dateTime, zoneId, this.offset);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.dateTime);
        objectOutput.writeObject(this.offset);
        objectOutput.writeObject(this.zone);
    }

    @Override // fj.d, ij.a
    public d<D> plus(long j10, i iVar) {
        return iVar instanceof ChronoUnit ? with((c) this.dateTime.plus(j10, iVar)) : toLocalDate().getChronology().ensureChronoZonedDateTime(iVar.addTo(this, j10));
    }

    @Override // fj.d, ij.a
    public d<D> with(f fVar, long j10) {
        if (!(fVar instanceof ChronoField)) {
            return toLocalDate().getChronology().ensureChronoZonedDateTime(fVar.adjustInto(this, j10));
        }
        ChronoField chronoField = (ChronoField) fVar;
        int i10 = a.f29502a[chronoField.ordinal()];
        if (i10 == 1) {
            return plus(j10 - toEpochSecond(), (i) ChronoUnit.SECONDS);
        }
        if (i10 != 2) {
            return ofBest(this.dateTime.with(fVar, j10), this.zone, this.offset);
        }
        return create(this.dateTime.toInstant(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j10))), this.zone);
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return (fVar instanceof ChronoField) || (fVar != null && fVar.isSupportedBy(this));
    }
}
