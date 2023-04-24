public class Test
{
    private Graph graph;

    public Test()
    {
        graph = new Graph(7);
        graph.knotenEinfuegen(new Knoten(new Datenelement(0)));  //knotenliste[0]
        graph.knotenEinfuegen(new Knoten(new Datenelement(1)));  //knotenliste[1]
        graph.knotenEinfuegen(new Knoten(new Datenelement(2)));  //knotenliste[2]
        graph.knotenEinfuegen(new Knoten(new Datenelement(3)));  //knotenliste[3]
        graph.knotenEinfuegen(new Knoten(new Datenelement(4)));  //knotenliste[4]
        graph.knotenEinfuegen(new Knoten(new Datenelement(5)));  //knotenliste[5]
        graph.knotenEinfuegen(new Knoten(new Datenelement(6)));  //knotenliste[6]
        graph.kanteEinfuegen(0,6);
        graph.kanteEinfuegen(0,1);
        graph.kanteEinfuegen(1,2);
        graph.kanteEinfuegen(1,3);
        graph.kanteEinfuegen(2,3);
        graph.kanteEinfuegen(2,5);
        graph.kanteEinfuegen(2,6);
        graph.kanteEinfuegen(3,4);
        graph.kanteEinfuegen(5,6);
    }
    
    public void matrixAusgeben(){
        graph.matrixAusgeben();
    }

    /* public void knotenlisteAusgeben(){
        graph.knotenlisteAusgeben();
    }
    
    public void nachbarknotenAusgeben(int index){
        graph.nachbarknotenAusgeben(graph.getKnoten(index));
    }
        
    public void knotenLöschen(int index){
        graph.knotenLöschen(index);
    }
    
    public void tiefensuche(int index){
        graph.tiefensuche(index);
    }
    
    public void wegeSuche(int startindex, int zielindex){
        graph.wegeSuche(startindex, zielindex);
        graph.wegelisteAusgeben();
    } */
}

