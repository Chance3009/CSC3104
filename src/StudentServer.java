import java.io.*;
import java.net.*;

public class StudentServer {
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;

    public static void main(String[] args) {
        new StudentServer();
    }

    public StudentServer() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started ");

            outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat", true));

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    inputFromClient = new ObjectInputStream(socket.getInputStream());

                    Object object = inputFromClient.readObject();

                    outputToFile.writeObject(object);
                    System.out.println("A new student object is stored");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputFromClient != null) {
                    inputFromClient.close();
                }
                if (outputToFile != null) {
                    outputToFile.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
