/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

/**
 *
 * @author xuebozhao
 */
public class Entrancefasta {
    public static void main(String args[]){
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3B/AB.Br1.3B.5K.indel.vcf.recode.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3B/btr1_3B_AB.indel.txt";
//        new vcf2fasta(infileS,outfileS);
        
        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3A/wheat_Btr1_3A.fa";
        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3B/btr1_3B_all.txt";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3A/wheat_Btr11111.fasta";
        new vcf2fasta(infileS1,infileS2,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/figures/Btr1/Btr1_all_mega.fas";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/figures/Btr1/Btr1_all_mega1.fas";
//        new vcf2fasta(infileS,outfileS);
          
//        int len = args.length;
//        String infileS = "";
//        String outfileS ="";
//        for (int i = 0; i < len; i++){
//            if (null != args[i])switch (args[i]) {
//                case "--file":
//                    infileS = args[i+1];
//                    i++;
//                    break;
//                case "--out":
//                    outfileS = args[i+1];
//                    i++;
//                    break;
//                default:
//                    break;
//            }
//        }
        
        
        
    }
}
    
