public class Lights implements Observer{
    public void update(String message){
        System.out.println("[Lights] " + message);
    }
}
