import java.util.ArrayList;

import components.standard.Standard;

/**
 * PatientPanel kernel component with primary methods.
 *
 * @author A. Ghastine
 */
public interface PatientPanel extends Standard<PatientPanel> {
    /**
     * Adds a visit to a Patient's data in the Panel.
     *
     * @param name
     * @param pcp
     * @param visit
     * @updates this
     * @requires Patient with the specified name and pcp is in this.
     * @ensures specified patient.dates = #patient.dates + visit
     */
    void addVisit(String name, String pcp, String visit);

    /**
     * Changes the PCP for a given patient.
     *
     * @param name
     * @param oldPCP
     * @param newPCP
     * @updates this
     * @requires Patient with the specified name and pcp is in this.
     * @ensures specified patient.pcp = newPCP
     */
    void updatePCP(String name, String oldPCP, String newPCP);

    /**
     * Returns an ArrayList of patients who share a PCP.
     *
     * @param pcp
     * @return an ArrayList of patients who share a PCP.
     * @aliases all patients who share the specified pcp
     */
    ArrayList<Patient> providerPanel(String pcp);

    /**
     * Changes a patient's name.
     *
     * @param oldName
     * @param pcp
     * @param newName
     * @updates this
     * @requires Patient with the specified name and pcp is in this.
     * @ensures specified patient.pcp = newPCP
     */
    void changeName(String oldName, String pcp, String newName);
}
