/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ALEX
 */
public class LimitarCaracteres extends PlainDocument {

    private JTextField texto;
    private int numero;

    public LimitarCaracteres(JTextField texto, int numero) {
        this.texto = texto;
        this.numero = numero;
    }      
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {

        if ((texto.getText().length() + arg1.length()) > this.numero) {
            return;
        }
        super.insertString(arg0, arg1, arg2);
    }

    public void SNumeros(JTextField a) {
        a.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
            }
        });

    }

}
