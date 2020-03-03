package mud;

import mud.gui.GraphicsHandler;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    private DatagramSocket udpSocket;
    private DatagramPacket packOutgoing;
    private DatagramPacket packIncoming;
    private byte[] receive;
    private byte[] sending;
    private boolean running;
    //StringBuilder sb;
    private GraphicsHandler gui;

    public Client() {
        receive = new byte[1024];
        sending = new byte[1024];
        packOutgoing = new DatagramPacket(sending,sending.length);
        packIncoming = new DatagramPacket(receive,receive.length);
        gui = new GraphicsHandler();
    }

    public void run() {
        //sb = new StringBuilder();
        running = true;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Input address to contact: ");
            String address = scan.nextLine();
            System.out.print("Input port to contact: ");
            String portString = scan.nextLine();
            int port = Integer.valueOf(portString);
            System.out.println("Trying to contact address "+ address +"...");
            udpSocket = new DatagramSocket();//Vazio, porque é apenas um buraco para saida de dados
            udpSocket.setReceiveBufferSize(1024);

            String content;



            System.out.println("Reaching the while.");
            while (running) {
                content = "";
                packOutgoing.setAddress(InetAddress.getByName(address));
                System.out.println("Sending: ");
                packOutgoing.setData(scan.nextLine().getBytes());
                packOutgoing.setPort(port); //THIS IS ESSENTIAL: THE PACKET NEEDS TO HAVE A DESTINATION
                udpSocket.send(packOutgoing);
                udpSocket.setSoTimeout(5000);
                udpSocket.receive(packIncoming);
                content = new String(receive,packIncoming.getOffset(),packIncoming.getLength()).trim();

                System.out.println("Received transmission: "+content);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
