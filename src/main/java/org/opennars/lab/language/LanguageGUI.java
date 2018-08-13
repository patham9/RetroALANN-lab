/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package org.opennars.lab.language;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opennars.main.Nar;
import org.opennars.entity.Sentence;
import org.opennars.gui.NARSwing;
import org.opennars.io.ConfigReader;
import org.opennars.io.events.AnswerHandler;
import org.opennars.storage.Memory;
import com.google.common.io.Resources;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author patrick.hammer
 */
public class LanguageGUI extends javax.swing.JFrame {

    //from https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
    static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    /**
     * Creates new form LanguageGUI
     */
    public LanguageGUI() throws Exception {
        initComponents();
        
        String everything = "";
        try {
            File f = new File("./language/language_knowledge.nal"); //load from file
            if(!f.exists()) {
                //else from resources
                
                String res = "language/language_knowledge.nal";
                everything = resourceFileContent(res);
                
            } else {
                everything = new Scanner(f).useDelimiter("\\Z").next();
            }
            
            jTextPane1.setText(everything);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LanguageGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jTextPane1.setCaretPosition(0);
        this.inputPanel.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                jButton1ActionPerformed(null);
            }
        }
    });
            
        languageNAR = new Nar();
        reasonerNAR = new Nar();
        NARSwing lang = new NARSwing(languageNAR);
        lang.mainWindow.setTitle("Language Nar (OpenNARS v1.6.5)");
        NARSwing reas = new NARSwing(reasonerNAR);  
        reas.mainWindow.setTitle("Reasoner Nar (OpenNARS v1.6.5)");
        languageNAR.narParameters.VOLUME = 0;
        reasonerNAR.narParameters.VOLUME = 0;
        reasonerNAR.start(0);
    }

    public static String resourceFileContent(String res) throws IOException {
        String everything = "";
        URL n = Resources.getResource(res);
        try {
            System.out.println(n.toURI().toString());
            URLConnection connection = n.openConnection();
            InputStream stream = connection.getInputStream();
            everything = convertStreamToString(stream);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return everything;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spliceCheckbox = new javax.swing.JCheckBox();
        spliceField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        attributePanel = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        eventCheck = new javax.swing.JCheckBox();
        inputPanel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Input");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPane1);

        jLabel1.setText("Start knowledge and potential training samples:");

        jLabel2.setText("Enter a sentence. Example: \"tim eats ice in manchester.\" Try re-Input in case that it was misinterpreted.");

        spliceCheckbox.setSelected(true);
        spliceCheckbox.setText("Cut up");

        spliceField.setText("2");

        jLabel3.setText("Minimal segment length:");

        jLabel4.setText("Sentence attribute relations:");

        attributePanel.setText("PLACE TIME IT");
        jScrollPane3.setViewportView(attributePanel);

        jLabel5.setText("For perceiving the sentence in pieces");

        eventCheck.setSelected(true);
        eventCheck.setText("Input as event");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputPanel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spliceCheckbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spliceField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spliceCheckbox)
                                .addComponent(jButton1)
                                .addComponent(spliceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(eventCheck))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String considerQWord(String s, HashSet<String> qwords) {
        for(String q : qwords) {
            if(q.equals(s)) {
                return "?"+s;
            }
        }
        return s;
    }
    
    //Nar learnerNAR = new Nar(); //for learning language structure
    static Nar languageNAR;
    static Nar reasonerNAR;
    ArrayList<AnswerHandler> q = new ArrayList<AnswerHandler>();
    int seed = 1;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String text = this.inputPanel.getText();
        List<String> inputs = new ArrayList<String>();
        this.inputPanel.setText("");
        String[] words = text.split(" ");
        String punctuation = "sentence";
        for(int i=0;i<words.length;i++) {
            for(int len=words.length; len>=Integer.valueOf(spliceField.getText()); len--) {
                String narsese = "(#,";
                if(i+len > words.length) { //this length is not possible
                    continue;
                }
                for(int k=i;k<i+len;k++) {
                    if(words[k].contains("?")) {
                        punctuation = "question";
                    }
                    words[k] = words[k].replace(".","").replace("?",""); //skip puncutation in words
                    narsese += "\"" + words[k]+"\"" + ",";
                }
                narsese = narsese.substring(0, narsese.length()-1);
                narsese+=").";
                inputs.add("$1.0;0.99;0.99$"+narsese);
                if(!spliceCheckbox.isSelected()) {
                    break;
                }
                break;
            }
            if(!spliceCheckbox.isSelected()) {
                break;
            }
            break;
        }
        
        languageNAR.stop();
        for(AnswerHandler ans : q) {
            ans.off();
        }
        languageNAR.reset();
        Memory.randomNumber.setSeed(seed);
        seed++;
        
        try {
            HashMap<String,String> wordTypes = new HashMap<String,String>();
            HashSet<String> qWords = new HashSet<String>();
            for(String s : jTextPane1.getText().split("\n")) {
                //if its a word type definition we won't add it directly but only when used in the sentence
                if(s.startsWith("<\"")) {
                    String word = s.split("\"")[1];
                    wordTypes.put(word, s);
                    if(s.contains("QWORD>.")) {
                        qWords.add(word);
                    }
                } else {
                    languageNAR.addInput(s);
                }
            }
            languageNAR.cycles(100);
            //add word categories of all words that occurred
            for(String word : words) {
                if(wordTypes.containsKey(word)) {
                    languageNAR.addInput(wordTypes.get(word));
                }
            }
            languageNAR.cycles(10);
            for(String s : inputs) {
                languageNAR.addInput(s);
                languageNAR.cycles(1);
            }
            
            boolean isQuestion = punctuation.equals("question");
            String punct = (isQuestion ? "?" : "." + (eventCheck.isSelected() ? " :|:" : ""));
            //Interpretation of Inheritance
            AnswerHandler cur = new AnswerHandler() {

                    @Override
                    public void onSolution(Sentence belief) {
                        //System.out.println("solution: " + belief);
                        System.out.println(belief);
                        String[] concepts = belief.term.toString().split("\"");
                        if(concepts.length < 6 || belief.toString().contains("#")) {
                            return; //just an example, no " included
                        }
                        String s = considerQWord(concepts[1],qWords).toUpperCase();
                        String p = considerQWord(concepts[3],qWords).toUpperCase();
                        String v = considerQWord(concepts[5],qWords).toUpperCase();
                        String inp = "<(*,"+s+","+p+") --> "+v+">" + punct;
                        if(v.equals("IS") || v.equals("ARE")) {
                            inp = "<"+s + " --> "+p + ">" + punct;
                        }
                        reasonerNAR.stop();
                        try {
                            reasonerNAR.addInput(inp+ " " + (isQuestion ? "" : belief.truth.toString()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        reasonerNAR.start(0);
                    }
                };
            languageNAR.ask("<(*,(/,REPRESENT,?a,_),(/,REPRESENT,?b,_)) --> (/,REPRESENT,?v,_)>", cur); 
            q.add(cur);
            
            for(String attribute : attributePanel.getText().split(" ")) {
                cur = new AnswerHandler() {
                    @Override
                    public void onSolution(Sentence belief) {
                        //System.out.println("solution: " + belief);
                        System.out.println(belief);
                        String[] concepts = belief.term.toString().split("\"");
                        if(concepts.length < 2) {
                            return; //just an example, no " included
                        }
                        String s = considerQWord(concepts[1],qWords).toUpperCase();
                        String inp = "<"+s + " --> " + attribute + ">" + punct;
                        reasonerNAR.stop();
                        try
                        {
                            reasonerNAR.addInput(inp+ " " + (isQuestion ? "" : belief.truth.toString()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        reasonerNAR.start(0);
                    }
                };
                if(!attribute.trim().equals("")) {
                    languageNAR.ask("<?what --> " + attribute + ">", cur); 
                    q.add(cur);
                }
            }
            
            languageNAR.start(0);
        } catch (Exception ex) {
            Logger.getLogger(LanguageGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {    
        NARSwing.themeInvert();
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LanguageGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(LanguageGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane attributePanel;
    private javax.swing.JCheckBox eventCheck;
    private javax.swing.JTextField inputPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JCheckBox spliceCheckbox;
    private javax.swing.JTextField spliceField;
    // End of variables declaration//GEN-END:variables
}
