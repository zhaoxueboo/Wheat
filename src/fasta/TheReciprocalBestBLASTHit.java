/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class TheReciprocalBestBLASTHit {
    
    public TheReciprocalBestBLASTHit(String infileS1,String infileS2,String infileS3,String outfileS1){
        //this.getReciprocalBestBLASTHit(infileS1,infileS2,infileS3,outfileS1);
        //this.getReciprocalBestBLASTHitA(infileS1, infileS2, infileS3, outfileS1);
        //this.getReciprocalBestBLASTHitB(infileS1, infileS2, infileS3, outfileS1);
        //this.getReciprocalBestBLASTHitD(infileS1, infileS2, infileS3, outfileS1);
    }   
    
    public TheReciprocalBestBLASTHit(String infileS1,String infileS2,String outfileS){
        //getAllGeneReciprocalBestBLASTHit(infileS1,infileS2,outfileS);
        //this.getAllGeneReciprocalBestBLASTHit2(infileS1, infileS2, outfileS);
        this.getAllGeneReciprocalBestBLASTHit3(infileS1, infileS2, outfileS);
    }

    public TheReciprocalBestBLASTHit(String infile,String outfile){
        //this.getfiltertxt(infile, outfile);
        this.getfiltertxtnext(infile, outfile);
    }
    
    public void getfiltertxt(String infile,String outfile){
        try{
            BufferedReader br = IOUtils.getTextReader(infile);
            BufferedWriter bw = IOUtils.getTextWriter(outfile);
            String temp  = null;
            Set <String> filter = new HashSet();
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");
                String [] temtem = tem[0].split("_");
                String [] temtem2 = tem[1].split("_"); 
                if(filter.add(temtem2[3])){
                  bw.write(temtem[3] + "\t" + temtem2[3] + "\n");
                }           
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getfiltertxtnext (String infile,String outfile){
        try{
            BufferedReader br = IOUtils.getTextReader(infile);
            BufferedWriter bw = IOUtils.getTextWriter(outfile);
            String temp  = null;
            Set <String> filter = new HashSet();
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t"); 
                if(filter.add(tem[0])){
                  bw.write(tem[0] + "\t" + tem[1] + "\n");
                }           
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getReciprocalBestBLASTHit(String infileS1,String infileS2,String infileS3,String outfileS1){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String tempAll = null;
            boolean tempA = false;
            boolean tempB = false;
            boolean tempD = false;
            BufferedReader br1AB = IOUtils.getTextReader(infileS1);
            BufferedReader br2AD = IOUtils.getTextReader(infileS2);
            BufferedReader br3BD = IOUtils.getTextReader(infileS3);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS1);
//            Set <String> A1 = new HashSet();
//            Set <String> B1 = new HashSet();
//            Set <String> A2 = new HashSet();
//            Set <String> D2 = new HashSet();
//            Set <String> B3 = new HashSet();
//            Set <String> D3 = new HashSet();
//            String chr = null;
//            String chrtemp = null;
//            while((temp = br1AB.readLine())!= null){
//                String [] tem = temp.split("\t");
//                A1.add(tem[0]);
//                B1.add(tem[1]);
//            }
//            while((temp = br2AD.readLine())!= null){
//                String [] tem = temp.split("\t");
//                A2.add(tem[0]);
//                D2.add(tem[1]);
//            }
//            while((temp = br3BD.readLine())!= null){
//                String [] tem = temp.split("\t");
//                B3.add(tem[0]);
//                D3.add(tem[1]);
//            }       
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            HashMap<String, String> hashMap3 = new HashMap<String, String>();
            Set<String> A1 = new HashSet();
            while((temp = br1AB.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap1.put(tem[0],tem[1]);
                A1.add(tem[0]);
            }
            while((temp = br2AD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap2.put(tem[1],tem[0]);
            }
            while((temp = br3BD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap3.put(tem[0],tem[1]);
            }        
//            Iterator<String> IteratorA1 = A1.iterator();
//            Iterator<String> IteratorB1 = B1.iterator();
//            while (IteratorA1.hasNext() & IteratorB1.hasNext()) {
//                String strA1 = IteratorA1.next();
//                String strB1 = IteratorB1.next();
//                hashMap1.put(strA1,strB1);
//            }
//            Iterator<String> IteratorD2 = D2.iterator();
//            Iterator<String> IteratorA2 = A2.iterator();
//            while (IteratorD2.hasNext() & IteratorA2.hasNext()) {
//                String strD2 = IteratorD2.next();
//                String strA2 = IteratorA2.next();
//                hashMap2.put(strD2,strA2);
//            }
//            Iterator<String> IteratorB3 = B3.iterator();
//            Iterator<String> IteratorD3 = D3.iterator();
//            while (IteratorB3.hasNext() & IteratorD3.hasNext()) {
//                String strB3 = IteratorB3.next();
//                String strD3 = IteratorD3.next();
//                hashMap3.put(strB3,strD3);
//            }
//            for(int j = 0;j < A1.size();j++){
//            Set <String> A1 = hashMap1.keySet();
//            Set <String> A11 = new HashSet();
//            A11 = A1;
            Set A11 = new HashSet();
//            for (String a1 :A1){
//                A11.add(a1);
//            }
            A11.addAll(A1);
            for (String a1 : A1){
                System.out.println(a1);
//                System.out.println(hashMap1.get(a1));
//                System.out.println(hashMap3.get(hashMap1.get(a1)));
                //System.out.println(hashMap2.get(hashMap3.get(hashMap1.get(a1))));
                String B = hashMap1.get(a1);
                String D = hashMap3.get(hashMap1.get(a1));
                String AA = "";
                try{
                     AA = hashMap2.get(hashMap3.get(hashMap1.get(a1)));
                }finally{
                    
                }                 
//                A1.add(AA);
//                System.out.println(aa);
                if(AA==null) continue;
                if(a1.equals("TraesCS3A01G461400")) {
                    System.out.println("Testing");
                }
                if(AA!=null && A11.add(AA)){
                    A11.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    //bw.write(a1 + "\t" + B + "\t" + "-1" + "\n");
//                    A1.remove(hashMap2.get(hashMap3.get(hashMap1.get(a1))));
                }else if(AA == null){
//                    A1.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    //bw.write(a1 + "\t" + B + "\t" + "-1" + "\n");
                }else{
                    //System.out.println(hashMap2.get(hashMap3.get(hashMap1.get(a1))));
//                    String B = hashMap1.get(a1);
//                    String D = hashMap3.get(hashMap1.get(a1));
                    bw.write(a1 + "\t" + B + "\t" + D + "\n");
                }
            }    
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getReciprocalBestBLASTHitA(String infileS1,String infileS2,String infileS3,String outfileS1){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String tempAll = null;
            boolean tempA = false;
            boolean tempB = false;
            boolean tempD = false;
            BufferedReader br1AB = IOUtils.getTextReader(infileS1);
            BufferedReader br2AD = IOUtils.getTextReader(infileS2);
            BufferedReader br3BD = IOUtils.getTextReader(infileS3);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS1);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            HashMap<String, String> hashMap3 = new HashMap<String, String>();
            Set<String> A1 = new HashSet();
            while((temp = br1AB.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap1.put(tem[0],tem[1]);
                A1.add(tem[0]);
            }
            while((temp = br2AD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap2.put(tem[1],tem[0]);
            }
            while((temp = br3BD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap3.put(tem[0],tem[1]);
            }    
            Set A11 = new HashSet();
            A11.addAll(A1);
            for (String a1 : A1){
                String B = hashMap1.get(a1);
                String D = hashMap3.get(hashMap1.get(a1));
                String AA = hashMap2.get(hashMap3.get(hashMap1.get(a1)));
                if(AA!=null && A11.add(AA)){
                    A11.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    bw.write(a1 + "\t" + B + "\t" + "-1" + "\n");
                }else if(AA == null){
                    A1.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    bw.write(a1 + "\t" + B + "\t" + "-1" + "\n");
                }else{
                    System.out.println(hashMap2.get(hashMap3.get(hashMap1.get(a1))));
                    //bw.write(a1 + "\t" + B + "\t" + D + "\n");
                }
            }    
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getReciprocalBestBLASTHitB(String infileS1,String infileS2,String infileS3,String outfileS1){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String tempAll = null;
            boolean tempA = false;
            boolean tempB = false;
            boolean tempD = false;
            BufferedReader br1AB = IOUtils.getTextReader(infileS1);
            BufferedReader br2AD = IOUtils.getTextReader(infileS2);
            BufferedReader br3BD = IOUtils.getTextReader(infileS3);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS1);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            HashMap<String, String> hashMap3 = new HashMap<String, String>();
            Set<String> B1 = new HashSet();
            while((temp = br1AB.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap1.put(tem[0],tem[1]);
                //A1.add(temtem[3]);
            }
            while((temp = br2AD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap2.put(tem[1],tem[0]);
            }
            while((temp = br3BD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap3.put(tem[0],tem[1]);
                B1.add(tem[0]);
            } 
            Set B11 = new HashSet();
            B11.addAll(B1);
            for (String a1 : B1){
                String B = hashMap3.get(a1);
                String D = hashMap2.get(hashMap3.get(a1));
                String AA = hashMap1.get(hashMap2.get(hashMap3.get(a1)));
                if(AA!=null && B11.add(AA)){
                    B11.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    bw.write("-1" + "\t" + a1 + "\t" + B + "\n");
                }else if(AA == null){
                    B1.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    bw.write("-1" + "\t" + a1 + "\t" + B + "\n");
                }else{
                    //System.out.println(hashMap2.get(hashMap3.get(hashMap1.get(a1))));
                    //bw.write(D + "\t" + a1 + "\t" + B + "\n");
                }
            }    
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getReciprocalBestBLASTHitD(String infileS1,String infileS2,String infileS3,String outfileS1){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String tempAll = null;
            boolean tempA = false;
            boolean tempB = false;
            boolean tempD = false;
            BufferedReader br1AB = IOUtils.getTextReader(infileS1);
            BufferedReader br2AD = IOUtils.getTextReader(infileS2);
            BufferedReader br3BD = IOUtils.getTextReader(infileS3);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS1);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            HashMap<String, String> hashMap3 = new HashMap<String, String>();
            Set<String> D1 = new HashSet();
            while((temp = br1AB.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap1.put(tem[0],tem[1]);
                //A1.add(temtem[3]);
            }
            while((temp = br2AD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap2.put(tem[1],tem[0]);
                D1.add(tem[1]);
            }
            while((temp = br3BD.readLine())!= null){
                String [] tem = temp.split("\t");
//                String [] temtem = tem[0].split("_");
//                String [] temtem2 = tem[1].split("_");     
                hashMap3.put(tem[0],tem[1]);
                //B1.add(temtem[3]);
            }     
            Set D11 = new HashSet();
            D11.addAll(D1);
            for (String a1 : D1){
                String B = hashMap2.get(a1);
                String D = hashMap1.get(hashMap2.get(a1));
                String AA = hashMap3.get(hashMap1.get(hashMap2.get(a1)));
                if(AA!=null && D11.add(AA)){
                    D11.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    bw.write( B + "\t" + "-1" + "\t" + a1 + "\n");
                }else if(AA == null){
                    D1.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                    bw.write( B + "\t" + "-1" + "\t" + a1 + "\n");
                }else{
                    //System.out.println(hashMap2.get(hashMap3.get(hashMap1.get(a1))));
                    //bw.write(B + "\t" + D + "\t" + a1 + "\n");
                }
            }    
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //把各个文件合并起来,首先合并的是第一列
    public void getAllGeneReciprocalBestBLASTHit(String infileS1,String infileS2,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String temp2 = null;
            //String line1 = null;
            BufferedReader brReciprocalGene = IOUtils.getTextReader(infileS1);
            BufferedReader brAllGene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMapfirstline = new HashMap<String, String>();
            Set<String> firstline = new HashSet();
            Set<String> allGene = new HashSet();
            while((temp = brReciprocalGene.readLine())!= null){
                String [] tem = temp.split("\t");
                firstline.add(tem[0]);
                String line23 = tem[1] + "_" + tem[2];
                hashMapfirstline.put(tem[0],line23);                
            }
            while((temp2 = brAllGene.readLine())!= null){
                    String [] temtem = temp2.split("\t");
                    if(firstline.add(temtem[1])){
                        firstline.remove(temtem[1]);
                        String ABD = temtem[1].substring(8,9);
                        if(ABD.equals("A")){
                            bw.write(temtem[1] + "\t" + temtem[1] + "\t" + "-1" + "\t" + "-1" + "\n");
                        }
                    }else{
                        String get23 = hashMapfirstline.get(temtem[1]);
                        String [] temtemtem = get23.split("_");
                        bw.write(temtem[1] + "\t" + temtem[1] + "\t" + temtemtem[0] + "\t" + temtemtem[1] + "\n");
                        firstline.remove(temtem[1]);
                    }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getAllGeneReciprocalBestBLASTHit2(String infileS1,String infileS2,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String temp2 = null;
            //String line1 = null;
            BufferedReader brReciprocalGene = IOUtils.getTextReader(infileS1);
            BufferedReader brAllGene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMapfirstline = new HashMap<String, String>();
            Set<String> secondline = new HashSet();
            Set<String> allGene = new HashSet();
            while((temp = brReciprocalGene.readLine())!= null){
                String [] tem = temp.split("\t");
                //line1 = tem[0];
                secondline.add(tem[1]);
                String line13 = tem[0] + "_" + tem[2];
                hashMapfirstline.put(tem[1],line13);                
            }
            while((temp2 = brAllGene.readLine())!= null){
                    String [] temtem = temp2.split("\t");
                    if(secondline.add(temtem[1])){
                        secondline.remove(temtem[1]);
                        String ABD = temtem[1].substring(8,9);
                        if(ABD.equals("B")){
                            bw.write(temtem[1] + "\t" +  "-1" + "\t"+ temtem[1] +" \t" + "-1" + "\n");
                        }
                    }else{
                        String get23 = hashMapfirstline.get(temtem[1]);
                        String [] temtemtem = get23.split("_");
                        bw.write(temtem[1] + "\t" + temtemtem[0] + "\t" + temtem[1] + "\t" + temtemtem[1] + "\n");
                        secondline.remove(temtem[1]);
                    }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //把各个文件合并起来
    public void getAllGeneReciprocalBestBLASTHit3(String infileS1,String infileS2,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String temp2 = null;
            //String line1 = null;
            BufferedReader brReciprocalGene = IOUtils.getTextReader(infileS1);
            BufferedReader brAllGene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMapfirstline = new HashMap<String, String>();
            Set<String> thirdline = new HashSet();
            Set<String> allGene = new HashSet();
            while((temp = brReciprocalGene.readLine())!= null){
                String [] tem = temp.split("\t");
                //line1 = tem[0];
                thirdline.add(tem[2]);
                String line12 = tem[0] + "_" + tem[1];
                hashMapfirstline.put(tem[2],line12);                
            }
            while((temp2 = brAllGene.readLine())!= null){
                    String [] temtem = temp2.split("\t");
                    if(thirdline.add(temtem[1])){
                        thirdline.remove(temtem[1]);
                        String ABD = temtem[1].substring(8,9);
                        if(ABD.equals("D")){
                            bw.write(temtem[1] + "\t" +  "-1" + "\t" + "-1" +  "\t" + temtem[1] +"\n");
                        }
                    }else{
                        String get12 = hashMapfirstline.get(temtem[1]);
                        String [] temtemtem = get12.split("_");
                        bw.write(temtem[1] + "\t" + temtem[1] + "\t" + temtemtem[1] + "\t" +  temtemtem[0] +  "\n");
                        thirdline.remove(temtem[1]);
                    }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
