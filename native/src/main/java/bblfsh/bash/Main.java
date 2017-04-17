package bblfsh.bash;

public class Main {

    public static void main(String args[]) {
        final RequestReader reader = new RequestReader(System.in);
        final ResponseWriter writer = new ResponseWriter(System.out);
        final Driver driver = new Driver(reader, writer);

        try {
            driver.run();
        } catch (CloseException e) {
            System.exit(0);
        } catch (DriverException e) {
            System.exit(1);
        }
    }
}
