package sistemabancario;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {

    private JTextField nomeConta;
    private JComboBox<String> tipoConta;
    private JTextField valor;
    private JTextArea resultadoArea;
    private JButton botaoCriarConta;
    private JButton botaoDepositar;
    private JButton botaoSacar;
    private JButton botaoConsultar;

    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private ContaEspecial contaEspecial;

    public InterfaceGrafica() {

        setTitle("Sistema Bancário");
        setSize(1440, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 30, 150, 30);
        add(nomeLabel);

        nomeConta = new JTextField();
        nomeConta.setBounds(200, 30, 250, 30);
        add(nomeConta);

        JLabel tipoContaLabel = new JLabel("Tipo de Conta:");
        tipoContaLabel.setBounds(50, 80, 150, 30);
        add(tipoContaLabel);

        tipoConta = new JComboBox<>(new String[]{"Conta Corrente", "Conta Poupança", "Conta Especial"});
        tipoConta.setBounds(200, 80, 250, 30);
        add(tipoConta);

        botaoCriarConta = new JButton("Criar Conta");
        botaoCriarConta.setBounds(50, 130, 150, 40);
        botaoCriarConta.setBackground(Color.black);
        botaoCriarConta.setForeground(Color.white);
        add(botaoCriarConta);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(50, 190, 150, 30);
        add(valorLabel);

        valor = new JTextField();
        valor.setBounds(200, 190, 250, 30);
        add(valor);

        botaoDepositar = new JButton("Depositar");
        botaoDepositar.setBounds(50, 240, 150, 40);
        botaoDepositar.setBackground(Color.black);
        botaoDepositar.setForeground(Color.white);
        add(botaoDepositar);

        botaoSacar = new JButton("Sacar");
        botaoSacar.setBounds(220, 240, 150, 40);
        botaoSacar.setBackground(Color.black);
        botaoSacar.setForeground(Color.white);
        add(botaoSacar);

        botaoConsultar = new JButton("Consultar");
        botaoConsultar.setBounds(50, 300, 150, 40);
        botaoConsultar.setBackground(Color.black);
        botaoConsultar.setForeground(Color.white);
        add(botaoConsultar);

        resultadoArea = new JTextArea();
        resultadoArea.setBounds(50, 360, 1340, 300);
        resultadoArea.setFont(new Font("Consolas", Font.BOLD, 20));
        resultadoArea.setEditable(false);
        add(resultadoArea);

        botaoCriarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });

        botaoDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });

        botaoSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSaque();
            }
        });

        botaoConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarConta();
            }
        });
    }

    private void criarConta() {
        String nome = nomeConta.getText().trim();
        if (nome.isEmpty()) {
            resultadoArea.setText("Por favor, insira um nome para a conta");
        } else {
            int tipo = tipoConta.getSelectedIndex();
            switch (tipo) {
                case 0:
                    contaCorrente = new ContaCorrente(1, 0, nome, 1.5);
                    resultadoArea.setText("Conta Corrente criada com sucesso!");
                    break;
                case 1:
                    contaPoupanca = new ContaPoupanca(1, 0, nome, 0.05);
                    resultadoArea.setText("Conta Poupança criada com sucesso!");
                    break;
                case 2:
                    contaEspecial = new ContaEspecial(1, 0, nome, 100);
                    resultadoArea.setText("Conta Especial criada com sucesso!");
                    break;
                default:
                    resultadoArea.setText("Tipo de conta inválido");
            }
        }
    }

    private void realizarDeposito() {
        String textoValor = this.valor.getText().trim();
        if (textoValor.isEmpty()) {
            resultadoArea.setText("Por favor, insira um valor para o depósito");
        } else {
            double valor = Double.parseDouble(this.valor.getText());
            try {
                if (contaCorrente != null) {
                    resultadoArea.setText(contaCorrente.setDepositar(valor));
                } else if (contaPoupanca != null) {
                    resultadoArea.setText(contaPoupanca.setDepositar(valor));
                } else if (contaEspecial != null) {
                    resultadoArea.setText(contaEspecial.setDepositar(valor));
                } else {
                    resultadoArea.setText("Nenhuma conta criada");
                }
            } catch (Exception e) {
                resultadoArea.setText(e.getMessage());
            }
        }
    }

    private void realizarSaque() {
        String textoValor = this.valor.getText().trim();
        if (textoValor.isEmpty()) {
            resultadoArea.setText("Por favor, insira um valor para o saque");
        } else {
            double valor = Double.parseDouble(this.valor.getText());
            try {
                if (contaCorrente != null) {
                    resultadoArea.setText(contaCorrente.setSacar(valor));
                } else if (contaPoupanca != null) {
                    resultadoArea.setText(contaPoupanca.setSacar(valor));
                } else if (contaEspecial != null) {
                    resultadoArea.setText(contaEspecial.setSacar(valor));
                } else {
                    resultadoArea.setText("Nenhuma conta criada");
                }
            } catch (Exception e) {
                resultadoArea.setText(e.getMessage());
            }
        }
    }

    private void consultarConta() {
        if (contaCorrente != null) {
            resultadoArea.setText(contaCorrente.getRetorno());
        } else if (contaPoupanca != null) {
            resultadoArea.setText(contaPoupanca.getRetorno()
            );
        } else if (contaEspecial != null) {
            resultadoArea.setText(contaEspecial.getRetorno()
            );
        } else {
            resultadoArea.setText("Nenhuma conta criada");
        }
    }
}
