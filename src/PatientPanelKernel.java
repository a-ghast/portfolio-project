import java.util.ArrayList;

import components.standard.Standard;

/**
 * PatientPanel Interface with kernel methods.
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
     * Adds Patient object pat to this.
     *
     * @param pat
     *            the patient to add
     * @updates this
     * @requires no patient with the same name and pcp is in this.
     * @ensures this = #this + new Patient as specified
     */
    void addPatient(Patient pat);

    /**
     * Creates a Patient object with name = @code name and pcp = @code pcp, and
     * an empty set of visits, then adds it to this.
     *
     * @param name
     * @param pcp
     * @return the removed Patient
     * @updates this
     * @requires patient with name and pcp is in this.
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

    /**
     * Removes any Patient object form the panel.
     *
     * @return an arbitrary-chosen patient from {@code this}
     * @ensures removeAny is in this
     */
    Patient removeAny();

    /**
     * returns whether the Panel contains a Patient.
     *
     * @param patient
     * @return whether the Panel contains a Patient.
     *
     */
    boolean containsPatient(Patient patient);
}
