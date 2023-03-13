import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

class Server
{

      ServerSocket server;
      Socket socket;

      BufferedReader br;
      PrintWriter out;

    // constructor    
       public Server()
       {
            try 
            {
                server = new ServerSocket(7777);
                System.out.println("server is ready to accept connection");
                System.out.println("waiting...");
                socket = server.accept();

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream());

                startReading();
                startWriting();

            } 
            catch (Exception e)
            {
              e.printStackTrace();
            }
       } 


        
        public void startReading() 
        {
            Runnable r1 =()-> 
            {

            };


        }

        public void startWriting() 
       {
            Runnable r2 =()-> 
            {

            };


       }



    public static void main(String[] args)
    {
       System.out.println("This is server...going to start server");
       new Server(); 
    }
}