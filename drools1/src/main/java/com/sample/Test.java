package com.sample;

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
	        DroolFuZhu dfz=new DroolFuZhu();
	        dfz.setStartI(0);
	        dfz.setStartJ(1);
	        dfz.setEndI(3);
	        dfz.setEndJ(4);
	        session.insert(dfz);  
            session.fireAllRules();  
            System.out.println(dfz);

	}

}
