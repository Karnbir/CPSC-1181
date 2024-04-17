import java.io.DataInput;
import java.io.DataInputStream;

public class Service implements Runnable, Serve {
    private Socket client;
    private double balance;
    public Service(Socket client){
        this.client = client;
        run();
        balance = 0;
    }
    @Override
    public void run(){
        service();
    }

    @Override
    private void service(){
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataInputStream out = new DataInputStream(client.getOutputStream());

        if (in.readUTF().equalsIgnoreCase("Deposit")) {
            int amount = in.readInt();

            if (amount < 0) {
                out.writeUTF("Needs positive amount");
                out.flush();
            } else {
                balance += amount;
                out.writeUTF("Success");
                out.flush();
            }
        }

        if (in.readUTF().equalsIgnoreCase("Withdrawl")) {
            int amount = in.readInt();

            if (amount > balance) {
                out.writeUTF("ERROR, withdrawl exceeds balance");
                out.flush();
            } else {
                balance -= amount;
                out.writeUTF("Success");
                out.flush();
            }
        }

    }
}
