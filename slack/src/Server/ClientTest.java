package Server;

import javax.swing.JFrame;
public class ClientTest {
    public static void main(String[] args){
        Client charlie;
        charlie = new Client("127.0.0.1"); // localhost for now
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.startRunning();
    }
}
