public class Datenelement 
{
    private String kuerzel, name;
    private int nummer;

    public Datenelement(String k, String n){
        kuerzel = k;
        name = n;
    }
    
    public Datenelement(int nr){
        nummer = nr;
    }

    public String getName(){
        return name;
    }

    public String getKuerzel(){
        return kuerzel;
    }

    public void ausgeben(){
        System.out.print(kuerzel+":  "+name+" ");
    }
}
