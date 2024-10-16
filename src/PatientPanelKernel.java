import java.util.ArrayList;

import components.standard.Standard;

/**
 * PatientPanel Enhanced Interface with secondary methods.
 *
 * @author A. Ghastine
 */
public interface PatientPanelKernel extends Standard<PatientPanelKernel> {
    /**
     * Creates a Patient object with name = @code name and pcp = @code pcp, and
     * an empty set of visits, then adds it to this.
     *
     * @param name
     * @param pcp
     * @updates this
     * @requires no patient with the same name and pcp is in this.
     * @ensures this = #this + new Patient as specified
     */
    void addPatient(String name, String pcp);

    /**
     * Creates a Patient object with name = @code name and pcp = @code pcp, and
     * an empty set of visits, then adds it to this.
     *
     * @param name
     * @param pcp
     * @return the removed Patient
     * @updates this
     * @requires no patient with the same name and pcp is in this.
     * @ensures this = #this + new Patient as specified
     */
    Patient removePatient(String name, String pcp);

    /**
     * Returns an alias to the patient's visit dates ArrayList.
     *
     * @param name
     * @param pcp
     * @return alias to the visit dates ArrayList.
     * @aliases the Patient's dates field
     */
    ArrayList<String> getVisits(String name, String pcp);

    /**
     * Reports size of {@code this}.
     *
     * @return the number of Patients in in {@code this}
     * @ensures size = |this|
     */
    int size();
}
