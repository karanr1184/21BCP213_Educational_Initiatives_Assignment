public class AirConditioning implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[AirConditioning] " + message);
    }
}
