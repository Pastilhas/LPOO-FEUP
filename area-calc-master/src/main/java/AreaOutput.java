public class AreaOutput {
    private SumProvider sump;

    AreaOutput(SumProvider sump){
        this.sump = sump;
    }

    public String output() {
        return "Sum of areas: " + sump.sum();
    }
}
