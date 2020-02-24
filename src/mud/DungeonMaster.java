package mud;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class DungeonMaster {

    private DatagramSocket udpListener;
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
            //192.168.248.254
            System.out.print("Input port to listen: ");
            String portString = scan.nextLine();
            int port = Integer.valueOf(portString);
            System.out.println(port+" is the port being attempted.");
            udpListener = new DatagramSocket(port);
            udpListener.setReceiveBufferSize(1024);

            String content;

            System.out.println("Reaching the while...");
            while (running) {
                content = "";
                System.out.println("Listening...");
                udpListener.receive(packetIncoming);
                content = new String(packetIncoming.getData(), packetIncoming.getOffset(), packetIncoming.getLength());
                //O COMBOIO É NECESSÁRIO PARA FAZER USO CORRECTO DO ARRAY MULTIPLE TIMES
                if ( content.equals("end") ) {
                    running = false;
                    System.out.println("End sequence initiated.");
                } else {
                    System.out.println(content.toUpperCase());
                    packetOutgoing.setAddress(packetIncoming.getAddress());
                    packetOutgoing.setData(content.trim().toUpperCase().getBytes());
                    packetOutgoing.setPort(packetIncoming.getPort());
                    udpListener.send(packetOutgoing);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }



}
