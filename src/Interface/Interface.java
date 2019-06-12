package Interface;

import Classes.CTCPB;
import Classes.NodoIP;
import Classes.STCPB;
import Datagrama.ClienteDatagrama;
import Flujo.ClienteArchivo;
import Flujo.ServidorArchivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {

    public DefaultListModel modelo;
    public NodoIP MiNodo;
    public String IP;
    public int PORT;
    public ClienteDatagrama CD;
    public Vector<Integer> V;
    public Hashtable<Integer,String> ListaNodos;
    public Pair<String, Integer> P, PSiguiente, PAnterior;
    public STCPB ServerTexto;
    public CTCPB ClientTexto;
    public ServerTexto ST;

    public Interface(int PORT) {
        CD = new ClienteDatagrama();
        initComponents();
        modelo = new DefaultListModel();
        V = new Stack<>();
        this.PORT = PORT;
        ST = new ServerTexto();
        ST.start();

    }
    
    public void ActualizarHastable(Hashtable<Integer,String> ListaNodos){
        this.ListaNodos = ListaNodos;
    }

    public void AgregarElementos(String IP, int PORT) {
        modelo.addElement(String.valueOf(IP + ":" + PORT));
        jListLista.setModel(modelo);
    }

    public void AgregarAnterior(String text) {
        jTextFieldAnterior.setText(text);
    }

    public void AgregarSiguiente(String text) {
        jTextFieldSiguiente.setText(text);

    }

    public void ActualizarNodo(NodoIP MiNodo) {
        this.MiNodo = MiNodo;
    }

    public void ActualizarVector(Vector<Integer> V) {
        this.V = V;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListLista = new javax.swing.JList<>();
        jTextFieldAnterior = new javax.swing.JTextField();
        jTextFieldSiguiente = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTexto = new javax.swing.JTextArea();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jListLista);

        jLabel1.setText("Siguiente");

        jLabel2.setText("Anterior");

        jTextAreaTexto.setColumns(20);
        jTextAreaTexto.setRows(5);
        jScrollPane2.setViewportView(jTextAreaTexto);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarMouseClicked
        String archivo = jTextFieldNombre.getText();
        String texto = "";
        int i = -1;
        NodoIP Aux = MiNodo;

        while (i != V.size()) {
            
            if (Existe(archivo, MiNodo.getActual().getValue())) {

                /*CREAMOS EL TEXTO A MOSTRAR EN LA VENTANA*/
                texto = "Se encontró el archivo en: " + MiNodo.getActual().getKey()
                        + ":" + MiNodo.getActual().getValue()
                        + " procedemos a descargarlo " + "\n";
                
                /*SE LO MANDAMOS*/
                jTextAreaTexto.setText(texto);
                System.out.println(MiNodo.getActual().getKey());
                
                ClientTexto = new CTCPB(MiNodo.getActual().getKey(), MiNodo.getActual().getValue(),
                        "Tengo el archivo: " + archivo);
                ClientTexto.Cliente();

                //TODAVIA NO DEBE DESCARGAR
                try {
                    RecibirArchivo(MiNodo.getActual().getKey(), PORT, MiNodo.getActual().getValue(), archivo);

                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
                

                break;

            } else {
                String text = "El servidor " + MiNodo.getAnterior().getKey()
                        + ":" + MiNodo.getAnterior().getValue()
                        + " pregunta por el archivo: " + archivo
                        + " No lo tengo, pregunto a: " + MiNodo.getSiguiente().getKey() + ":"
                        + MiNodo.getSiguiente().getValue();

                ClientTexto = new CTCPB(MiNodo.getActual().getKey(), MiNodo.getActual().getValue(), text
                );

                ClientTexto.Cliente();

            }

            Mueve();
            i++;

        }

        if (i == V.size()) {
            jTextAreaTexto.setText("");
            texto = "No se encontró el archivo especificado.";
            MiNodo = Aux;
            jTextAreaTexto.setText(texto);
        }


    }//GEN-LAST:event_jButtonBuscarMouseClicked

    public static boolean Existe(String nombre_archivo, int pos) {
        
        /*OBTENEMOS EL USUARIO DE CADA COMPUTADORA*/
        File user = new File(System.getProperty("user.name"));
        String url ="C:\\Users\\" + user + "\\Documents\\" + pos  + "\\" + nombre_archivo;
        File filearchivo = new File(url);
        
        if (filearchivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void RecibirArchivo(String IP, int PortDestino, int PortOrigen, String nombre) throws IOException, InterruptedException {
        JOptionPane.showMessageDialog(null, "Descargando de: " + PortOrigen + " A: " + PortDestino);
        
        //Donde se va a guardar
        ServidorArchivo SA = new ServidorArchivo(nombre, PortDestino);
        SA.start();
        sleep(1000);

        //Fichero a transferir     
        ClienteArchivo CA = new ClienteArchivo(nombre, PortOrigen);
        CA.start();
    }

    public void Mueve() {
        P = new Pair<>(MiNodo.getSiguiente().getKey(), MiNodo.getSiguiente().getValue());
        MiNodo.setActual(P);

        int Pos = V.indexOf(P.getValue());

        if (Pos == 0) {
            PAnterior = new Pair<>(P.getKey(), V.get(V.size() - 1));
            PSiguiente = new Pair<>(P.getKey(), V.get(Pos + 1));

            MiNodo.setSiguiente(PSiguiente);
            MiNodo.setAnterior(PAnterior);
        } else if (Pos == V.size() - 1) {
            PAnterior = new Pair<>(P.getKey(), V.get(Pos - 1));
            PSiguiente = new Pair<>(P.getKey(), V.get(0));

            MiNodo.setSiguiente(PSiguiente);
            MiNodo.setAnterior(PAnterior);
        } else {
            PAnterior = new Pair<>(P.getKey(), V.get(Pos - 1));
            PSiguiente = new Pair<>(P.getKey(), V.get(Pos + 1));

            MiNodo.setSiguiente(PSiguiente);
            MiNodo.setAnterior(PAnterior);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaTexto;
    private javax.swing.JTextField jTextFieldAnterior;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldSiguiente;
    // End of variables declaration//GEN-END:variables

    class ServerTexto extends Thread {

        @Override
        public void run() {
            IniciarservidorTexto();
        }

        public void IniciarservidorTexto() {
            
            String infoCliente = "";
            /* SIEMPRE PONER EL SOCKET EN UN TRY-CATCH */
            
            try {
                
                /* PUERTO EN EL QUE ESCUCHA PETICIONES */
                ServerSocket socketServidor = new ServerSocket(PORT);
                System.out.println("Esperando peticiones...");

                while (true) {
                    /* BLOQUEO HASTA QUE RECIBA ALGUNA PETICION DEL CLIENTE */
                    Socket socketCliente = socketServidor.accept();
                    
                    /* ESTABLECEMOS EL CANAL DE ENTRADA */
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

                    /* OBTENEMOS EL CANAL DE SALIDA */
                    PrintWriter salida = new PrintWriter(new OutputStreamWriter(socketCliente.getOutputStream()));

                    /* RECIBIMOS INFORMACION DEL CLIENTE */
                    infoCliente = entrada.readLine();
                    
                    /* ENVIAMOS INFORMACION AL CLIENTE */
                    jTextAreaTexto.setText(infoCliente + "\n");

                    salida.flush();
                    salida.close();
                    entrada.close();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
