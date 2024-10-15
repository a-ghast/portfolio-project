import java.util.ArrayList;

/**
 * PatientPanel proof of concept.
 *
 * @author A. Ghastine
 */
public final class PatientPanel1 {

    /**
     * Private class of Patient with name, PCP, and dates fields.
     */
    public final class Patient {
        /**
         * the Patient's name.
         */
        private String name;

        /**
         * returns name.
         *
         * @return name
         */
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
        public ArrayList<String> dates() {
            return this.dates;
        }

        /**
         * Constructor.
         *
         * @param n
         * @param p
         */
        public Patient(String n, String p) {
            this.name = n;
            this.pcp = p;
            this.dates = new ArrayList<String>();
        }

        /**
         * implementing independent .equals() methods so the patient can be
         * identified in remove. This means the patients are solely identifiable
         * by name and PCP.
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
                result = this.name.equals(patient.name)
                        && this.pcp.equals(patient.pcp);
            }
            return result;
        }

        /**
         * implementing independent hashCode method so the patient can be
         * identified in remove.
         */
        @Override
        public int hashCode() {
            return this.name.hashCode() + this.pcp.hashCode();
        }
    }

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
    public void addPatient(String name, String pcp) {
        this.patients.add(new Patient(name, pcp));
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
    public Patient removePatient(String name, String pcp) {
        return this.patients
                .remove(this.patients.lastIndexOf(new Patient(name, pcp)));
    }

    /**
     * @return patientPanel size
     *
     */
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
    public ArrayList<String> getVisits(String name, String pcp) {
        return this.patients
                .get(this.patients.lastIndexOf(new Patient(name, pcp))).dates;
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
}
