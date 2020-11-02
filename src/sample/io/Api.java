package sample.io;

public class Api {
   private static String baseURL="http://docker.project45.co.za:8089/p45_api/";
   //private static String baseURL="http://192.168.8.107:8089/p45_api/";
   public static String getApi(){
       return baseURL;
   }
}
