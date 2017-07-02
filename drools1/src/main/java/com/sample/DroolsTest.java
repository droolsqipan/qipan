package com.sample;

import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
            
            KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
            		 .newKnowledgeBuilder();
            		 kbuilder.add(ResourceFactory.newClassPathResource("test.drl",
            		DroolsTest. class), ResourceType. DRL);
            		 Collection<KnowledgePackage> kpackage =
            		kbuilder.getKnowledgePackages();
            		 KnowledgeBaseConfiguration kbConf = KnowledgeBaseFactory
            		 .newKnowledgeBaseConfiguration();
            		 kbConf.setProperty("org.drools.sequential", "true");
            		 KnowledgeBase kbase =
            		KnowledgeBaseFactory.newKnowledgeBase(kbConf);
            		 kbase.addKnowledgePackages(kpackage); //将KnowledgePackage集合添加到KnowledgeBase当中
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
