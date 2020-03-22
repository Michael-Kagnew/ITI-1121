import java.io.*;
import java.util.Arrays;
public class Utils{
	
	public static PlayList getSongsFromFile(String fileName) throws IOException{

	     BufferedReader input = null;
       
	     PlayList pList;
        try{
           
            int lines = 0;
            input = new BufferedReader(new FileReader(fileName));
            
           /* while (input.readLine()!= null){
                lines++;
                System.out.println(input.re);
            }*/

              pList= new PlayList();

             String temp = null;

             while((temp=input.readLine()) != null){
                String[] song = temp.split(":");
                pList.addSong(new Song(song[0], song[1], song[2]));
             }


        } finally{
            if(input!=null){
                input.close();
            }
        }
        System.out.println(pList.getSize());
        return pList;
}

	public static void main(String[] args) throws IOException{

		PlayList hey = Utils.getSongsFromFile("songs.csv");
		 System.out.println(hey.getSize());

	}
}