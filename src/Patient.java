import java.util.ArrayList;

import components.standard.Standard;

/**
 * PatientPanel kernel component with primary methods.
 *
 * @author A. Ghastine
 */
public interface Patient extends Standard<Patient> {
    /**
     * Returns the Patient's name as a String.
     *
     * @return name
     * @ensures name = this.name
     */
    String name();

    /**
     * Returns the Patient's pcp as a String.
     *
     * @return pcp
     * @ensures pcp = this.pcp
     */
    String pcp();

    /**
     * Returns the Patient's visit dates record as an ArrayList of Strings.
     *
     * @return dates
     * @ensures dates = this.dates
     */
    ArrayList<String> dates();
}
