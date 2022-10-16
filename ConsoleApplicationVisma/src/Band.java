public class Band {
    private String bandName;
    private String vocalist;
    private String drummer;
    private String bassGuitarist;
    private String electricGuitarist;

    public Band(String bandName, String vocalist, String drummer, String bassGuitarist, String electricGuitarist) {
        this.bandName = bandName;
        this.vocalist = vocalist;
        this.drummer = drummer;
        this.bassGuitarist = bassGuitarist;
        this.electricGuitarist = electricGuitarist;
    }

    public Band() {

    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getVocalist() {
        return vocalist;
    }

    public void setVocalist(String vocalist) {
        this.vocalist = vocalist;
    }

    public String getDrummer() {
        return drummer;
    }

    public void setDrummer(String drummer) {
        this.drummer = drummer;
    }

    public String getBassGuitarist() {
        return bassGuitarist;
    }

    public void setBassGuitarist(String bassGuitarist) {
        this.bassGuitarist = bassGuitarist;
    }

    public String getElectricGuitarist() {
        return electricGuitarist;
    }

    public void setElectricGuitarist(String electricGuitarist) {
        this.electricGuitarist = electricGuitarist;
    }
}
