import java.util.ArrayList;

/**
 * Layered implementations of secondary methods for {@code SimpleWriter}.
 */
public abstract class PatientPanelSecondary implements PatientPanel {
    //------ Standard Methods! ----------

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        boolean result = obj != null && obj.getClass() == this.getClass();
        //Initialized to get rid of the error message on 'compared' in the while loop
        PatientPanel compared = this;
        PatientPanel holder = new PatientPanel1();
        if (result) {
            compared = (PatientPanel) obj;
            result = this.size() == compared.size();
        }
        int i = 0;
        int thisSize = this.size();
        while (i < thisSize && result) {
            Patient checkingPatient = this.removeAny();
            result = compared.containsPatient(checkingPatient);
            holder.addPatient(checkingPatient);
            i++;
        }

        int holderSize = holder.size();
        for (int j = 0; j < holderSize; j++) {
            this.addPatient(holder.removeAny());
        }

        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        PatientPanel holder = new PatientPanel1();
        int result = 0;
        int thisSize = this.size();
        for (int i = 0; i < thisSize; i++) {
            Patient checkingPatient = this.removeAny();
            result += checkingPatient.hashCode();
            holder.addPatient(checkingPatient);
        }

        int holderSize = holder.size();
        for (int j = 0; j < holderSize; j++) {
            this.addPatient(holder.removeAny());
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        String result = "{";
        PatientPanel holder = new PatientPanel1();
        int thisSize = this.size();
        for (int i = 0; i < thisSize; i++) {
            Patient checkingPatient = this.removeAny();
            if (i != 0) {
                result += ", ";
            }
            result += checkingPatient.toString();
            holder.addPatient(checkingPatient);
        }

        int holderSize = holder.size();
        for (int j = 0; j < holderSize; j++) {
            this.addPatient(holder.removeAny());
        }
        result += "}";
        return result;
    }

    // ------------ Secondary Method Implementatons -----------------
    @Override
    public void addVisit(String name, String pcp, String visit) {
        Patient pat = this.removePatient(name, pcp);
        ArrayList<String> datesAlias = this.getVisits(name, pcp);
        datesAlias.addLast(visit);
    }

    @Override
    public void updatePCP(String name, String oldPCP, String newPCP) {
        Patient pat = this.removePatient(name, oldPCP);
        this.addPatient(name, newPCP);
        Patient newPat = this.removePatient(name, newPCP);
        ArrayList<String> datesAlias = newPat.dates();
        for (String date : pat.dates()) {
            datesAlias.addLast(date);
        }
        this.addPatient(newPat);

    }

    @Override
    public ArrayList<Patient> providerPanel(String pcp) {
        ArrayList<Patient> result = new ArrayList<>();
        PatientPanel holder = (PatientPanel) this.newInstance();
        int size = this.size();
        for (int i = 0; i < size; i++) {
            Patient removed = this.removeAny();
            if (removed.pcp().equals(pcp)) {
                result.addLast(removed);
            }
            holder.addPatient(removed);
        }
        int holderSize = holder.size();
        for (int j = 0; j < holderSize; j++) {
            this.addPatient(holder.removeAny());
        }
        return result;
    }

    @Override
    public void changeName(String oldName, String pcp, String newName) {
        Patient pat = this.removePatient(oldName, pcp);
        this.addPatient(newName, pcp);
        Patient newPat = this.removePatient(newName, pcp);
        ArrayList<String> datesAlias = newPat.dates();
        for (String date : pat.dates()) {
            datesAlias.addLast(date);
        }
        this.addPatient(newPat);
    }

}
