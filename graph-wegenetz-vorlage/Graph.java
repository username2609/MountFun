public class Graph
{
    //Attribute:
    private Knoten[] knotenliste;
    private boolean[][] matrix;
    private int knotenzahl;

    public Graph(int m){  //m ist die Maximalzahl der Knoten
        knotenzahl = 0;
        knotenliste = new Knoten[m];
        matrix = new boolean[m][m];
    }
    
    public void knotenEinfuegen(Knoten k){
        if(knotenliste.length > knotenzahl){
            knotenliste[knotenzahl] = k;
            knotenzahl++;
        }
        else 
        System.out.println("Gott ist groﬂ! Amen Bruder. Liste ist voll!");
    }
    
    public void kanteEinfuegen(int i, int j){
        if(i < knotenzahl &&  j < knotenzahl){
        matrix[i][j] = true;
        matrix[j][i] = true;
        }
        else
        System.out.println("AMEN! Da ist kein Knoten bei i="+i+" und j="+j+".");
    }
    
    public Knoten getKnoten(int index){
        return knotenliste[index];
    } 
    
    public void knotenlisteAusgeben(){
        for(int i=0; i < knotenliste.length; i++){
            System.out.println(knotenliste[i].getInhalt().getName());
        }
    }
    
    public int knotenindexSuchenFor(Knoten k){
        
    }
    
    public int knotenindexSuchenWhile(Knoten k){
        for(int i=0; i<knotenzahl; i++){
            return
        }
    }
    
    public void matrixAusgeben(){
      //Zeilen ausgeben -------------------------------------------------
        String spalte = "    ";
        for(int i = 0; i < knotenzahl; i++){
            spalte =spalte + knotenliste[i].getInhalt().getKuerzel()+"  ";
        }
        System.out.println(spalte);
      //Zeilen ausgeben -------------------------------------------------
        for(int i = 0; i < knotenzahl; i++){
            String zeile = knotenliste[i].getInhalt().getKuerzel()+"   ";  
            for(int j = 0; j < knotenzahl; j++){
                zeile = zeile + matrixElementSchreiben(i,j)+"  ";
            }
            System.out.println(zeile);
        }
    }
    
    private String matrixElementSchreiben(int i, int j){
        if(matrix[i][j]) 
            return "x";
        else 
            return "-";
    }
}
