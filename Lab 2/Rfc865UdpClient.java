import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Rfc865UdpClient {
	public static void main(String[] argv) throws UnknownHostException {
		 //
		 // 1. Open UDP socket
		 //
		 DatagramSocket socket = null;
		 InetAddress ip = InetAddress.getByName("localhost"); 
		 int port = 4445;
		 try {
			 socket = new DatagramSocket();
					 
		 } catch (SocketException e) {
			 
		 }
		 try {
		 //
		 // 2. Send UDP request to server
		 String msg = "Tran Anh Tai, TS5, 172.21.150.60";	
		 // open connection between ip in port
		 socket.connect(ip, port);
		 DatagramPacket request = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, port);
		 socket.send(request);
		 //
		 // 3. Receive UDP reply from server
		 //
		 byte[] buf3 = new byte[1024];
		 DatagramPacket reply = new DatagramPacket(buf3, buf3.length);
		 socket.receive(reply);
		 System.out.println(new String(reply.getData()));
		 
		 } catch (IOException e) {
			 
		 }
	}
}
