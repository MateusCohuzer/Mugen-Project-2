package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tools.Musicas;

/**
 *
 * @author Mateus CohuzEr
 */
class CRUD_GUI extends JFrame {

    Container cp;
    Container gp;
    JPanel pnCentro = new JPanel();
    JPanel pnOeste = new JPanel();

    JLabel lbOeste = new JLabel();
    JLabel lbCentro = new JLabel();

    JButton btArma = new JButton("Arma");
    JButton btCla = new JButton("Clã");
    JButton btFiliacao = new JButton("Filiação");
    JButton btGrade = new JButton("Grade");
    JButton btJujutsu = new JButton("Jujutsu");
    JButton btPais = new JButton("País");
    JButton btPlayer = new JButton("Player");
    JButton btCidade = new JButton("Cidade");
    JButton btPlace = new JButton("Place");
    JButton btRaca = new JButton("Raça");

    Musicas musicas = new Musicas();

    public CRUD_GUI() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp.add(pnOeste, BorderLayout.WEST);
        cp.add(pnCentro, BorderLayout.CENTER);
        pnCentro.add(lbCentro);

        try {
            ImageIcon icone = new ImageIcon(getClass().getResource("../res/imgs/StartScreen_Yuta_MugenProject.jpg"));
            Image imagemAux;
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(1100, 950, Image.SCALE_FAST));

            lbCentro.setIcon(icone);
        } catch (Exception e) {
            System.out.println("Erro ao carregar a imagem");
        }
        
        btPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonagemGUI personagemGUI = new PersonagemGUI();
            }
        });

        btArma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArmaGUI armaGUI = new ArmaGUI();
            }
        });

        btCla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClaGUI claGUI = new ClaGUI();
            }
        });

        btFiliacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiliacaoGUI filiacaoGUI = new FiliacaoGUI();
            }
        });

        btGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GradeGUI gradeGUI = new GradeGUI();
            }
        });

        btJujutsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JujutsuGUI jjtGUI = new JujutsuGUI();
            }
        });

        btPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaisGUI paisGUI = new PaisGUI();
            }
        });

        btRaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RacaGUI racaGUI = new RacaGUI();
            }
        });
        
        btCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CidadeGUI cidadeGUI = new CidadeGUI();
            }
        });

        btPlace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlaceGUI placeGUI = new PlaceGUI();
            }
            }
        );

        pnOeste.setLayout(new GridLayout(5, 2));
        pnOeste.add(btPlayer);
        pnOeste.add(btArma);
        pnOeste.add(btCla);
        pnOeste.add(btRaca);
        pnOeste.add(btFiliacao);
        pnOeste.add(btGrade);
        pnOeste.add(btJujutsu);
        pnOeste.add(btPais);
        pnOeste.add(btCidade);
        pnOeste.add(btPlace);
        
        btArma.setBackground(Color.WHITE);
        btCla.setBackground(Color.WHITE);
        btFiliacao.setBackground(Color.WHITE);
        btGrade.setBackground(Color.WHITE);
        btJujutsu.setBackground(Color.WHITE);
        btPais.setBackground(Color.WHITE);
        btPlayer.setBackground(Color.WHITE);
        btCidade.setBackground(Color.WHITE);
        btRaca.setBackground(Color.WHITE);
        btPlace.setBackground(Color.WHITE);

        pnCentro.setBackground(Color.WHITE);

        musicas.playBGM2();

        setTitle("Mugen Project");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/imgs/icon.png")));
        setSize(1480, 920);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
