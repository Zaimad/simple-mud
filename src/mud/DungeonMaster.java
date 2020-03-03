package mud;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DungeonMaster {

    private DatagramSocket udpSocket;
    private DatagramPacket packetOutgoing;
    private DatagramPacket packetIncoming;
    private byte[] receivingPacketByteArray;
    private byte[] sendingPacketByteArray;
    private boolean running;
    //StringBuilder sb;

    public DungeonMaster() {
        receivingPacketByteArray = new byte[1024];
        sendingPacketByteArray = new byte[1024];
        packetIncoming = new DatagramPacket(receivingPacketByteArray, receivingPacketByteArray.length);
        packetOutgoing = new DatagramPacket(sendingPacketByteArray, sendingPacketByteArray.length);
    }

    public void run() {
        //sb = new StringBuilder();
        running = true;
        Scanner scan = new Scanner(System.in);
        try {
            //Is there a fixed IP I could use somehow? Without local machine, I mean...
            System.out.print("Input address to contact: ");
            String address = scan.nextLine();
            System.out.print("Input port to connect: ");
            String portString = scan.nextLine();
            int port = Integer.valueOf(portString);
            System.out.println(port+" is the port being attempted.");
            udpSocket = new DatagramSocket(port);
            udpSocket.setReceiveBufferSize(1024);

            String content;

            System.out.println("Setup complete. You can now make server requests.");
            while (running) {
                content = "";
                packetOutgoing.setAddress(InetAddress.getByName(address));
                System.out.println("Sending: ");
                packetOutgoing.setData(scan.nextLine().getBytes());
                packetOutgoing.setPort(port); //THIS IS ESSENTIAL: THE PACKET NEEDS TO HAVE A DESTINATION
                udpSocket.send(packetOutgoing);
                udpSocket.setSoTimeout(5000);
                udpSocket.receive(packetIncoming);
                content = new String(receivingPacketByteArray,packetIncoming.getOffset(),packetIncoming.getLength()).trim();

                System.out.println("Received transmission: "+content);


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }



}
