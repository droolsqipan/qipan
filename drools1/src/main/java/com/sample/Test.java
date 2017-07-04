package com.sample;

import java.awt.Color;

import java.util.Collection;
import java.util.Iterator;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

public class Test {

	public static void main(String[] args) {
		 KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();  
	        builder.add(ResourceFactory.newClassPathResource("rules/test.drl"), ResourceType.DRL);  
	  
	        if (builder.hasErrors()) {  
	            System.out.println("规则中存在错误，错误消息如下：");  
	            KnowledgeBuilderErrors kbuidlerErrors = builder.getErrors();  
	            for (Iterator iter = kbuidlerErrors.iterator(); iter.hasNext();) {  
	                System.out.println(iter.next());  
	            }  
	            return;  
	        }
	        Collection<KnowledgePackage> packages = builder.getKnowledgePackages();  
	        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();  
	        kbase.addKnowledgePackages(packages);  
	        StatefulKnowledgeSession session = kbase.newStatefulKnowledgeSession();
	         StatelessKnowledgeSession sessionkib;
	        DroolFuZhu dfz=new DroolFuZhu();
	        dfz.setStartI(4);
	        dfz.setStartJ(0);
	        dfz.setEndI(4);
	        dfz.setEndJ(1);
//	        session.insert(dfz);  
//            session.fireAllRules();  
            //System.out.println(dfz);
            QiZi[][] qiZi=new QiZi[9][10];//创建棋子数组
            final Color color1=new Color(249,183,173);//红方的颜色
        	final Color color2=Color.white;//白方的颜色
        	qiZi[0][0]=new QiZi(color1,"車",0,0);
    		qiZi[1][0]=new QiZi(color1,"馬",1,0);
    		qiZi[2][0]=new QiZi(color1,"相",2,0);
    		qiZi[3][0]=new QiZi(color1,"仕",3,0);
    		qiZi[4][0]=new QiZi(color1,"帥",4,0);
    		qiZi[5][0]=new QiZi(color1,"仕",5,0);
    		qiZi[6][0]=new QiZi(color1,"相",6,0);
    		qiZi[7][0]=new QiZi(color1,"馬",7,0);
    		qiZi[8][0]=new QiZi(color1,"車",8,0);
    		qiZi[1][2]=new QiZi(color1,"砲",1,2);
    		qiZi[7][2]=new QiZi(color1,"砲",7,2);
    		qiZi[0][3]=new QiZi(color1,"兵",0,3);
    		qiZi[2][3]=new QiZi(color1,"兵",2,3);
    		qiZi[4][3]=new QiZi(color1,"兵",4,3);
    		qiZi[6][3]=new QiZi(color1,"兵",6,3);
    		qiZi[8][3]=new QiZi(color1,"兵",8,3);
    		qiZi[0][9]=new QiZi(color2,"車",0,9);
    		qiZi[1][9]=new QiZi(color2,"馬",1,9);
    		qiZi[2][9]=new QiZi(color2,"象",2,9);
    		qiZi[3][9]=new QiZi(color2,"士",3,9);
    		qiZi[4][9]=new QiZi(color2,"將",4,9);
    		qiZi[5][9]=new QiZi(color2,"士",5,9);
    		qiZi[6][9]=new QiZi(color2,"象",6,9);
    		qiZi[7][9]=new QiZi(color2,"馬",7,9);
    		qiZi[8][9]=new QiZi(color2,"車",8,9);
    		qiZi[1][7]=new QiZi(color2,"炮",1,7);
    		qiZi[7][7]=new QiZi(color2,"炮",7,7);
    		qiZi[0][6]=new QiZi(color2,"卒",0,6);
    		qiZi[2][6]=new QiZi(color2,"卒",2,6);
    		qiZi[4][6]=new QiZi(color2,"卒",4,6);
    		qiZi[6][6]=new QiZi(color2,"卒",6,6);
    		qiZi[8][6]=new QiZi(color2,"卒",8,6);
            
//            車的变量0 -- 0 -- 4 -- 0 -- 
//            車的变量0 -- 0 -- 5 -- 0 -- 
//            車的变量1 -- 0 -- 5 -- 0 -- 
//            車的变量1 -- 0 -- 4 -- 0 -- 
//            車的变量3 -- 0 -- 7 -- 0 -- 
//            車的变量0 -- 0 -- 1 -- 0 -- 
            dfz.setQiZi(qiZi);
            dfz.setCanMove(true);
            dfz.setName("帥");
           
           //System.out.println(qiZi[0][1]);
//            session.insert(dfz);  
//            session.fireAllRules();
            sessionkib=(StatelessKnowledgeSession) kbase.newStatelessKnowledgeSession();
			sessionkib.execute(dfz);
            System.out.println(dfz.toString());
            System.out.println(dfz.isCanMove());

	}

}
