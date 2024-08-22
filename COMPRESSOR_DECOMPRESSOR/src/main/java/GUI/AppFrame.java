/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;



import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Main application frame for file compression and decompression.
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    public AppFrame() {
        // Frame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 200);
        this.getContentPane().setBackground(Color.BLUE);
        
        // Initialize and add compress button
        compressButton = new JButton("Select File to Compress");
        compressButton.addActionListener(this);
        this.add(compressButton);
        
        // Initialize and add decompress button
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.addActionListener(this);
        this.add(decompressButton);
        
        // Make frame visible
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int response;

        if (e.getSource() == compressButton) {
            response = fileChooser.showSaveDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    compressor.method(file);
                    JOptionPane.showMessageDialog(this, "File compressed successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        } else if (e.getSource() == decompressButton) {
            response = fileChooser.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    decompressor.method(file);
                    JOptionPane.showMessageDialog(this, "File decompressed successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        }
    }
    
 
}
