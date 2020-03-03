import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Rfc865UdpServer {
	static DatagramSocket socket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Open UDP socket at well-known port
		System.out.println("Listening!!.......");
		 byte[] receive = new byte[65535];
		 int port = 4445;
		 try {
			 socket = new DatagramSocket(port);
		 } 
		 catch (SocketException e) {
			 
		 }
		 while (true) {
			 try {
			 //
			 // 2. Listen for UDP request from client
			 //
			 DatagramPacket request = new DatagramPacket(receive, 65535);
			 socket.receive(request);
			 
			 InetAddress clientAddress = request.getAddress();
			 int clientPort = request.getPort();
			 
			 byte[] data = request.getData();
			 System.out.println(new String(data));
			 //
			 // 3. Send UDP reply to client
			 //
			 String msg = "I am Tai";
			 DatagramPacket reply = new DatagramPacket(msg.getBytes(), msg.getBytes().length, clientAddress, clientPort);
			 socket.send(reply);
			 } 
			 catch (IOException e) {
				 
			 }
		 }
	}
}
