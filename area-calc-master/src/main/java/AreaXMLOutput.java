public class AreaXMLOutput {
    private SumProvider sump;

    AreaXMLOutput(SumProvider sump){
        this.sump = sump;
    }

    public String output_XML() { return "<area>" + sump.sum() + "</area>"; }
}
