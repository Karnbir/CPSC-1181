import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
        try {
            service();
        } catch (IOException e) {
            System.out.println("Connection ERROR");
        }
    }

    @Override
    public void service() throws IOException {
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

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
