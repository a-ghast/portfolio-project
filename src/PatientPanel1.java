import java.util.ArrayList;

/**
 * PatientPanel proof of concept.
 *
 * @author A. Ghastine
 */
public final class PatientPanel1 extends PatientPanelSecondary {

    // /**
    //  * Public class of Patient with name, PCP, and dates fields.
    //  */
    // public final class Patient {
    //     /**
    //      * the Patient's name.
    //      */
    //     private String name;

    //     /**
    //      * returns name.
    //      *
    //      * @return name
    //      */
    //     public String name() {
    //         return this.name;
    //     }

    //     /**
    //      * The patient's PCP.
    //      */
    //     private String pcp;

    //     /**
    //      * returns name.
    //      *
    //      * @return name
    //      */
    //     public String pcp() {
    //         return this.pcp;
    //     }

    //     /**
    //      * the visit dates.
    //      */
    //     private ArrayList<String> dates;

    //     /**
    //      * returns dates.
    //      *
    //      * @return dates
    //      */
    //     public ArrayList<String> dates() {
    //         return this.dates;
    //     }

    //     /**
    //      * Constructor.
    //      *
    //      * @param n
    //      * @param p
    //      */
    //     public Patient(String n, String p) {
    //         this.name = n;
    //         this.pcp = p;
    //         this.dates = new ArrayList<String>();
    //     }

    //     /**
    //      * implementing independent .equals() methods so the patient can be
    //      * identified in remove. This means the patients are solely identifiable
    //      * by name and PCP.
    //      *
    //      * @param obj
    //      *            the obj compared
    //      * @return result
    //      */
    //     @Override
    //     public boolean equals(Object obj) {
    //         boolean result = false;
    //         if (this == obj) {
    //             result = true;
    //         }
    //         if (obj != null && this.getClass() == obj.getClass()) {
    //             Patient patient = (Patient) obj;
    //             result = this.name.equals(patient.name())
    //                     && this.pcp.equals(patient.pcp())
    //                     && this.dates.equals(patient.dates());
    //         }
    //         return result;
    //     }

    //     /**
    //      * implementing independent hashCode method so the patient can be
    //      * identified in remove.
    //      */
    //     @Override
    //     public int hashCode() {
    //         return this.name.hashCode() + this.pcp.hashCode();
    //     }

    //     /**
    //      * implementing independent hashCode method so the patient can be
    //      * identified in remove.
    //      */
    //     @Override
    //     public String toString() {
    //         String result = "(" + this.name() + ", " + this.pcp() + ", "
    //                 + this.dates() + ")";
    //         return result;
    //     }
    // }

    /**
     * representation of patient panel.
     */
    private ArrayList<Patient> patients;

    /**
     * No-argument constructor.
     */
    public PatientPanel1() {
        this.patients = new ArrayList<Patient>();
    }

    /**
     * adds a patient.
     *
     * @param name
     * @param pcp
     */
    @Override
    public void addPatient(String name, String pcp) {
        this.patients.add(new Patient1(name, pcp));
    }

    /**
     * adds an existing patient.
     *
     * @param pat
     *            the Patient object to add.
     */
    @Override
    public void addPatient(Patient pat) {
        this.patients.add(pat);
    }

    /**
     * removes a patient and returns it.
     *
     * @param name
     * @param pcp
     * @requires [patient is in @code this]
     * @return the removed patient.
     *
     */
    @Override
    public Patient removePatient(String name, String pcp) {
        return this.patients
                .remove(this.patients.lastIndexOf(new Patient1(name, pcp)));
    }

    /**
     * returns whether the Panel contains a Patient.
     *
     * @param patient
     * @return whether the Panel contains a Patient.
     *
     */
    @Override
    public boolean containsPatient(Patient patient) {
        return this.patients.lastIndexOf(patient) != -1;
    }

    /**
     * @return patientPanel size
     *
     */
    @Override
    public int size() {
        return this.patients.size();
    }

    /**
     * Aliases the visit dates ArrayList.
     *
     * @param name
     * @param pcp
     * @return alias to the visit dates ArrayList.
     */
    @Override
    public ArrayList<String> getVisits(String name, String pcp) {
        return this.patients
                .get(this.patients.lastIndexOf(new Patient1(name, pcp)))
                .dates();
    }

    /**
     * removes an arbitrarily chosen patient and returns it.
     *
     * @requires [@code this is not empty]
     * @return a removed patient.
     *
     */
    @Override
    public Patient removeAny() {
        return this.patients.remove(0);
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String... args) {
        PatientPanel1 practice = new PatientPanel1();
        System.out.println(practice.size());
        practice.addPatient("John Doe", "Dr. Peck");
        System.out.println(practice.size());
        System.out.println(practice.getVisits("John Doe", "Dr. Peck"));
        practice.getVisits("John Doe", "Dr. Peck").add("1/15/2024");
        practice.getVisits("John Doe", "Dr. Peck").add("4/15/2024");
        System.out.println(practice.getVisits("John Doe", "Dr. Peck"));
        Patient removed = practice.removePatient("John Doe", "Dr. Peck");
        System.out.println(practice.size());
        System.out.println(removed.name());
        System.out.println(removed.pcp());
        System.out.println(removed.dates());
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public PatientPanelKernel newInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'newInstance'");
    }

    @Override
    public void transferFrom(PatientPanelKernel arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }

}
