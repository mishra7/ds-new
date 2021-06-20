/*package com.ds.str;

public class TestTila {


    public static void main(String[] args) {


    }





public  String finColumnNameByColumnNumer(Integer colNumber){
      StringBuilder output =  new StringBuilder();

      while(colNumber>0){

          int index =(colNumber-1) %26;
          output.append((char)(index+'A'));
          colNumber=(colNumber-1)/26;
      }
  return output.reverse().toString();


}

 */