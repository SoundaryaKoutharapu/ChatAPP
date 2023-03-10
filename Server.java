import java.io.*;
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
                System.exit(0); 
            }
       } 


        
        public void startReading() 
        {
            Runnable r1 =()-> 
            {
                System.out.println("reader started");
                
             while(true)
             {
                try
                {

                   String msg = br.readLine();

                   if(msg.equals("exit"));
                   {
                      System.out.println("client terminated the chat");
                      //break;
                       socket.close();
                   }

                   System.out.println("Client: " +msg);
             }

             catch(Exception e)
             {
                 e.printStackTrace();
             }
         }            
            };

            new Thread(r1).start();

        }

        public void startWriting() 
       {
            Runnable r2 =()-> 
            {
                System.out.println("writer started..");

                while(true && !socket.isClosed())
                {
                    try
                    {  
                   
                       BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

                       String content = br1.readLine();

                        out.println(content);
                        out.flush();

                       /* if(content.equals("exit"));
                        {
                           
                           socket.close();
                           //break;
                        }
                       */
                }

                catch(Exception e)
            {
                e.printStackTrace();
            }
            }

            };

            new Thread(r2).start();


       }



    public static void main(String[] args)
    {
       System.out.println("This is server...going to start server");
       new Server(); 
    }
}