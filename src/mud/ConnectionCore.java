package mud;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ConnectionCore {

    private DatagramSocket udpListener;
    private DatagramPacket packetOutgoing;
    private DatagramPacket packetIncoming;
    private byte[] receiving;
    private byte[] sending;
    private boolean running;
    //StringBuilder sb;

    public ConnectionCore() {
        receiving = new byte[1024];
        sending = new byte[1024];
        packetIncoming = new DatagramPacket(receiving, receiving.length);
        packetOutgoing = new DatagramPacket(sending, sending.length);
    }

    public void run() {
        //sb = new StringBuilder();
        running = true;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Input port to listen: ");
            String portString = scan.nextLine();
            int port = Integer.valueOf(portString);
            System.out.println(port+" is the port being attempted.");
            udpListener = new DatagramSocket(port);
            udpListener.setReceiveBufferSize(1024);

            String content;

            System.out.println("Mud logic starting...");
            //Mud logic has to be setup here


            //
            System.out.println("Mud initiated. Accepting client inputs.");
            while (running) {
                content = "";
                //System.out.println("Listening...");
                udpListener.receive(packetIncoming);
                content = new String(packetIncoming.getData(), packetIncoming.getOffset(), packetIncoming.getLength());
                //O COMBOIO É NECESSÁRIO PARA FAZER USO CORRECTO DO ARRAY MULTIPLE TIMES
                if ( content.equals("endtheworldrightnow") ) {
                    running = false;
                    System.out.println("End sequence initiated.");
                } else {
                    //Handle commmands here!

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
