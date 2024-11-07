import java.util.ArrayList;

/**
 * Public class of Patient with name, PCP, and dates fields.
 *
 * @convention <pre>
 * [all entries in this.dates are String representations of dates]
 * </pre>
 * @correspondence <pre>
 * this = [a patient named this.name with a primary care provider of this.pcp
 * who has been seen on each of the dates in this.dates]
 * </pre>
 * @author A. Ghastine
 */
public final class Patient1 implements Patient {

    /**
     * the Patient's name.
     */
    private String name;

    /**
     * returns name.
     *
     * @return name
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * The patient's PCP.
     */
    private String pcp;

    /**
     * returns name.
     *
     * @return name
     */
    @Override
    public String pcp() {
        return this.pcp;
    }

    /**
     * the visit dates.
     */
    private ArrayList<String> dates;

    /**
     * returns dates.
     *
     * @return dates
     */
    @Override
    public ArrayList<String> dates() {
        return this.dates;
    }

    /**
     * No-argument constructor.
     */
    public Patient1() {
        this.name = "";
        this.pcp = "";
        this.dates = new ArrayList<String>();
    }

    /**
     * Constructor.
     *
     * @param n
     * @param p
     */
    public Patient1(String n, String p) {
        this.name = n;
        this.pcp = p;
        this.dates = new ArrayList<String>();
    }

    /**
     * implementing independent .equals() methods so the patient can be
     * identified in remove. This means the patients are solely identifiable by
     * name and PCP.
     *
     * @param obj
     *            the obj compared
     * @return result
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        }
        if (obj != null && this.getClass() == obj.getClass()) {
            Patient patient = (Patient) obj;
            result = this.name.equals(patient.name())
                    && this.pcp.equals(patient.pcp())
                    && this.dates.equals(patient.dates());
        }
        return result;
    }

    /**
     * implementing independent hashCode method so the patient can be identified
     * in remove.
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.pcp.hashCode();
    }

    /**
     * implementing independent hashCode method so the patient can be identified
     * in remove.
     */
    @Override
    public String toString() {
        String result = "(" + this.name() + ", " + this.pcp() + ", "
                + this.dates() + ")";
        return result;
    }

    @Override
    public void clear() {
        this.name = "";
        this.pcp = "";
        this.dates = new ArrayList<String>();
    }

    @Override
    public Patient newInstance() {
        return new Patient1();
    }

    @Override
    public void transferFrom(Patient arg0) {
        Patient1 source = (Patient1) arg0;
        this.name = source.name;
        this.pcp = source.pcp;
        this.dates = source.dates;
        source.clear();
    }
}
