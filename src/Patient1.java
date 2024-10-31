import java.util.ArrayList;

/**
 * Public class of Patient with name, PCP, and dates fields.
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Patient newInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'newInstance'");
    }

    @Override
    public void transferFrom(Patient arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }
}
