
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTrackerFrame extends JFrame // Aqui está definido a classe MouseTrackerFrame que está herdando do JFrame
{
   //Há duas variáveis que irão ser manipuladas no construtor 
   private final JPanel mousePanel; // panel in which mouse events occur (painel no qual ocorrem eventos de mouse)
   private final JLabel statusBar; // displays event information (exibe informações do evento)

   // MouseTrackerFrame constructor sets up GUI and (O construtor MouseTrackerFrame configura a GUI e)
   // registers mouse event handlers (registra manipuladores de eventos de mouse)
   public MouseTrackerFrame() // Aqui está definindo o construtor 
   {
      super("Demonstrating Mouse Events"); // Aqui está definindo o título que irá aparecer em cima

      mousePanel = new JPanel(); // Declaração de variável, novo objeto JPanel
      mousePanel.setBackground(Color.WHITE); // Aqui está definindo a cor de fundo, que será branco
      add(mousePanel, BorderLayout.CENTER); // Aqui está adicionando o fundo e deixando uma borda central 

      statusBar = new JLabel("Mouse outside JPanel"); // Declaração de variável, novo objeto, que diz mouse fora do JPanel
      add(statusBar, BorderLayout.SOUTH); // Adicionando e deixando borda do painel em baixo 

      // create and register listener for mouse and mouse motion events (criar e registrar ouvinte para eventos de movimento do mouse e do mouse)
      MouseHandler handler = new MouseHandler(); // Declaração de variável, novo objeto MouseHandler
      mousePanel.addMouseListener(handler);  // Aqui está adicionando o excutador do Mouse Listener 
      mousePanel.addMouseMotionListener(handler); // Aqui está adicionando o excutador do  Mouse Motion Listener
   } // Aqui fecha o construtor

   private class MouseHandler implements MouseListener, 
      MouseMotionListener // Aqui está definindo a classe MouseHandler, que implementará da MouseListener e MouseMotionListener
   {
      // MouseListener event handlers (Manipuladores de eventos MouseListener)
      // handle event when mouse released immediately after press (manipular evento quando o mouse é liberado imediatamente após pressionar)
      @Override
      public void mouseClicked(MouseEvent event)
      {
         statusBar.setText(String.format("Clicked at [left: %d, top: %d , right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));  // Aqui está definindo a pressão, a prmeira %d double e getX, o segundo %d eé o getY
      } 

      // handle event when mouse pressed (manipular evento quando o mouse é pressionado)
      @Override
      public void mousePressed(MouseEvent event)
      {
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", 
         event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Aqui está definindo a pressão, a prmeira %d double e getX, o segundo %d eé o getY
      }

      // handle event when mouse released (manipular evento quando o mouse é liberado)
      @Override
      public void mouseReleased(MouseEvent event)
      {
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", 
         event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Aqui está definindo a pressão, a prmeira %d double e getX, o segundo %d eé o getY
      }

      // handle event when mouse enters area (manipular evento quando o mouse entra na área) // Quando o mouse entra no painel muda a cor do fundo
      @Override
      public void mouseEntered(MouseEvent event)
      {
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", 
         event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Aqui está definindo a pressão do mouse, a prmeira %d double e getX, o segundo %d eé o getY
         mousePanel.setBackground(Color.GREEN);
      }

      // handle event when mouse exits area (manipular evento quando o mouse sai da área)
      @Override
      public void mouseExited(MouseEvent event)
      {
         statusBar.setText("Mouse outside JPanel"); // Aqui está definindo a pressão, a prmeira %d double e getX, o segundo %d eé o getY
         mousePanel.setBackground(Color.WHITE);
      }

      // MouseMotionListener event handlers (Manipuladores de eventos MouseMotionListener)
      // handle event when user drags mouse with button pressed (manipular evento quando o usuário arrasta o mouse com o botão pressionado)
      @Override
      public void mouseDragged(MouseEvent event)
      {
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY()));  // Aqui está definindo a pressão, a prmeira %d double e getX, o segundo %d eé o getY
      } 

      // handle event when user moves mouse (manipular evento quando o usuário move o mouse)
      @Override
      public void mouseMoved(MouseEvent event)
      {
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", 
         event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Aqui está definindo a pressão, a prmeira %d double e getX, o segundo %d eé o getY
      } 
      






   } // Aqui fechaa classe MouseHandler, que implementará da MouseListener e MouseMotionListener
} // Aqui fecha a classe princiapl


