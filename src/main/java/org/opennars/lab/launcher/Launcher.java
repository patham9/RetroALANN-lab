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
package org.opennars.lab.launcher;

import com.google.common.io.Resources;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.xml.parsers.ParserConfigurationException;

import org.opennars.main.Nar;
import org.opennars.gui.NARSwing;
import org.opennars.io.ConfigReader;
import org.opennars.lab.predict.Predict_NARS_Core;
import org.xml.sax.SAXException;

/**
 *
 * @author tc
 */
public class Launcher extends javax.swing.JFrame {

    public static InputStream resource(String path) {
        URL n = Resources.getResource(path);
        URLConnection connection = null;
        try {
            connection = n.openConnection();
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return connection.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Creates new form Launcher
     */
    public Launcher() {
        initComponents();
        ClassLoader classloader = Launcher.class.getClassLoader();
        jLabel1.setIcon(new ImageIcon(classloader.getResource("launcher/opennars_logo.png")));

        this.setTitle("OpenNARS Launcher");
        /*try {
            BufferedImage myPicture = ImageIO.read(resource("mario.png"));
            jLabel8.setIcon(new ImageIcon(myPicture));
            
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        try {
            BufferedImage myPicture = ImageIO.read(resource("launcher/testchamber.png"));
            jLabel6.setIcon(new ImageIcon(myPicture));

        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
            BufferedImage myPicture = ImageIO.read(resource("rover.png"));
            jLabel7.setIcon(new ImageIcon(myPicture));
            
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }*/
 /*try {
            BufferedImage myPicture = ImageIO.read(resource("nartactoe.png"));
            jLabel2.setIcon(new ImageIcon(myPicture));
            
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            BufferedImage myPicture = ImageIO.read(resource("predict.png"));
            jLabel5.setIcon(new ImageIcon(myPicture));
            
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            BufferedImage myPicture = ImageIO.read(resource("launcher/pong.png"));
            jLabel9.setIcon(new ImageIcon(myPicture));

        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            BufferedImage myPicture = ImageIO.read(resource("launcher/nlp.png"));
            jLabel10.setIcon(new ImageIcon(myPicture));

        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            BufferedImage myPicture = ImageIO.read(resource("launcher/microworld.png"));
            jLabel11.setIcon(new ImageIcon(myPicture));

        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButton1.setForeground(new java.awt.Color(255, 255, 254));
        jButton1.setText("Main GUI");
        jButton1.setActionCommand("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(254, 255, 255));
        jButton2.setText("Website");
        jButton2.setActionCommand("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(254, 255, 255));
        jLabel6.setText("Test Chamber");
        jLabel6.setToolTipText("");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(254, 255, 255));
        jButton5.setText("IRC");
        jButton5.setActionCommand("jButton1");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(255, 255, 254));
        jButton3.setText("Wiki");
        jButton3.setActionCommand("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(254, 255, 255));
        jLabel9.setText("NAR Pong");
        jLabel9.setToolTipText("");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(254, 255, 255));
        jLabel10.setText("Language Lab");
        jLabel10.setToolTipText("");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(254, 255, 255));
        jLabel11.setText("Micro World");
        jLabel11.setToolTipText("");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
        });

        jButton4.setForeground(new java.awt.Color(254, 255, 255));
        jButton4.setText("Perception");
        jButton4.setActionCommand("jButton1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setForeground(new java.awt.Color(254, 255, 255));
        jButton6.setText("Prediction test");
        jButton6.setActionCommand("jButton1");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setForeground(new java.awt.Color(255, 255, 254));
        jButton7.setText("Vision");
        jButton7.setActionCommand("jButton1");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * Main GUI BUTTON 1
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            NARSwing sw = new NARSwing(new Nar());
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | ParserConfigurationException | IllegalAccessException | SAXException | ClassNotFoundException | ParseException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();

    }                                        

    /**
     * WebSite BUTTON 2
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            Desktop.getDesktop().browse(new URI("http://opennars.github.io/"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    /**
     * TestChamber Label 6
     *
     * @param evt
     */
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {                                     
        try {
            org.opennars.lab.grid2d.main.TestChamber.main(new String[]{});
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.setVisible(false);
        this.dispose();
    }                                    

    /**
     * IRC BUTTON 5
     *
     * @param evt
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            Desktop.getDesktop().browse(new URI("http://webchat.freenode.net/?channels=org.opennars"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    /**
     * Wiki Button 3
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/opennars/opennars/wiki"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    /**
     * NarPong Label 9
     *
     * @param evt
     */
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {                                     
        org.opennars.lab.microworld.Pong.main(null);
        this.dispose();
    }                                    

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    /**
     * LanguageLab Label 10
     *
     * @param evt
     */
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {                                      
        org.opennars.lab.language.LanguageGUI.main(null);
        this.dispose();
    }                                     

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    /**
     * MICROWORLD Label 11
     *
     * @param evt
     */
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {                                      
        org.opennars.lab.microworld.SimNAR.main(null);
        this.dispose();
    }                                     

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    /**
     * Perception BUTTON 4
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        org.opennars.lab.vision.SymRecognizerWithVisionChannel.main(null);
        this.dispose();
    }                                        

    /**
     * Prediction Test BUTTON 6
     *
     * @param evt
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            org.opennars.lab.predict.Predict_NARS_Core p = new org.opennars.lab.predict.Predict_NARS_Core();
            new Thread(() -> {
                try {
                    p.process();
                } catch (InterruptedException | IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | ParserConfigurationException | IllegalAccessException | SAXException | ClassNotFoundException | ParseException ex) {
                    Logger.getLogger(Predict_NARS_Core.class.getName()).log(Level.SEVERE, null, ex);
                }
            }, "Predict_NARS_Core_Class").start();
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    /**
     * Vision BUTTON 7
     *
     * @param evt
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            new Thread(() -> {
                try {
                    org.opennars.lab.vision.RasterHierachy.main(null);
                } catch (InterruptedException | IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | ParserConfigurationException | IllegalAccessException | SAXException | ClassNotFoundException | ParseException ex) {
                    Logger.getLogger(Predict_NARS_Core.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }, "Predict_NARS_Core_Class").start();
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    /**
     * Main Method to create Launcher Object
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        NARSwing.themeInvert();
        java.awt.EventQueue.invokeLater(() -> new Launcher().setVisible(true));
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration                   
}
